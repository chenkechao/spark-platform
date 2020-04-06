package com.spark.platform.flowable.biz.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.spark.platform.common.base.constants.ProcessConstants;
import com.spark.platform.flowable.api.DTO.DeploymentDTO;
import com.spark.platform.flowable.api.vo.DeploymentVO;
import com.spark.platform.flowable.api.vo.TaskVO;
import com.spark.platform.flowable.biz.service.ActProcessService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * @author: wangdingfeng
 * @Date: 2020/4/4 21:49
 * @Description: 流程对象Service
 */
@Service
@Slf4j
public class ActProcessServiceImpl implements ActProcessService {

    @Autowired
    private RepositoryService repositoryService;

    @Override
    public DeploymentBuilder createDeployment() {
        return repositoryService.createDeployment();
    }

    @Override
    public DeploymentQuery createDeploymentQuery() {
        return repositoryService.createDeploymentQuery();
    }

    @Override
    public ProcessDefinitionQuery createProcessDefinitionQuery() {
        return repositoryService.createProcessDefinitionQuery();
    }

    @Override
    public Deployment deploy(String bpmnFileUrl) {
        Deployment deploy = createDeployment().addClasspathResource(bpmnFileUrl).deploy();
        log.info("部署成功，当前部署ID:{}-部署的key{}-部署name;{}",deploy.getId(),deploy.getKey(),deploy.getName());
        return deploy;
    }

    @Override
    public Deployment deploy(String url, String pngUrl) {
        Deployment deploy = createDeployment().addClasspathResource(url).addClasspathResource(pngUrl).deploy();
        log.info("部署成功，当前部署ID:{}-部署的key{}-部署name;{}",deploy.getId(),deploy.getKey(),deploy.getName());
        return deploy;
    }

    @Override
    public DeploymentVO deploy(String name, String tenantId, String category, ZipInputStream zipInputStream) {
        Deployment deployment = createDeployment().addZipInputStream(zipInputStream)
                .name(name).category(category).tenantId(tenantId).deploy();
        DeploymentVO deploymentVO = new DeploymentVO();
        //忽略二进制文件（模板文件、模板图片）返回
        BeanUtils.copyProperties(deployment,deploymentVO,"resources");
        return deploymentVO;
    }

    @Override
    public Deployment deployBpmnAndDrl(String url, String drlUrl) {
        Deployment deploy = createDeployment().addClasspathResource(url).addClasspathResource(drlUrl).deploy();
        log.info("部署成功，当前部署ID:{}-部署的key{}-部署name;{}",deploy.getId(),deploy.getKey(),deploy.getName());
        return deploy;
    }

    @Override
    public Deployment deploy(String url, String name, String category) {
        Deployment deploy = createDeployment().addClasspathResource(url).name(name).category(category).deploy();
        log.info("部署成功，当前部署ID:{}-部署的key{}-部署name;{}",deploy.getId(),deploy.getKey(),deploy.getName());
        return deploy;
    }

    @Override
    public Deployment deploy(String url, String pngUrl, String name, String category) {
        Deployment deploy = createDeployment().addClasspathResource(url).addClasspathResource(pngUrl)
                .name(name).category(category).deploy();
        log.info("部署成功，当前部署ID:{}-部署的key{}-部署name;{}",deploy.getId(),deploy.getKey(),deploy.getName());
        return deploy;
    }

    @Override
    public boolean exist(String processDefinitionKey) {
        ProcessDefinitionQuery processDefinitionQuery
                = createProcessDefinitionQuery().processDefinitionKey(processDefinitionKey);
        long count = processDefinitionQuery.count();
        return count > 0 ? true : false;
    }

    @Override
    public DeploymentVO deploy(String name, String tenantId, String category, InputStream in) {
        Deployment deployment = createDeployment().addInputStream(name + ProcessConstants.BPMN_FILE_SUFFIX, in)
                .name(name)
                .tenantId(tenantId)
                .category(category)
                .deploy();
        DeploymentVO deploymentVO = new DeploymentVO();
        //忽略二进制文件（模板文件、模板图片）返回
        BeanUtils.copyProperties(deployment,deploymentVO,"resources");
        return deploymentVO;

    }

    @Override
    public ProcessDefinition queryByProcessDefinitionKey(String processDefinitionKey) {
        ProcessDefinition processDefinition
                = createProcessDefinitionQuery()
                .processDefinitionKey(processDefinitionKey)
                .active().singleResult();
        return processDefinition;
    }

    @Override
    public Deployment deployName(String deploymentName) {
        List<Deployment> list = repositoryService
                .createDeploymentQuery()
                .deploymentName(deploymentName).list();
        Assert.notNull(list, "list must not be null");
        return list.get(0);
    }

    @Override
    public void addCandidateStarterUser(String processDefinitionKey, String userId) {
        repositoryService.addCandidateStarterUser(processDefinitionKey, userId);
    }

    @Override
    public Page<DeploymentVO> listPage(DeploymentDTO deploymentDTO, Page page) {
        int firstResult = (int)((page.getCurrent()-1)*page.getSize());
        int maxResults = (int)(page.getCurrent()*page.getSize());
        DeploymentQuery deploymentQuery = createDeploymentQuery();
        if(StringUtils.isNotBlank(deploymentDTO.getDeploymentName())){
            deploymentQuery.deploymentNameLike(deploymentDTO.getDeploymentName());
        }
        if(StringUtils.isNotBlank(deploymentDTO.getDeploymentKey())){
            deploymentQuery.deploymentKeyLike(deploymentDTO.getDeploymentKey());
        }
        if(StringUtils.isNotBlank(deploymentDTO.getCategory())){
            deploymentQuery.deploymentKeyLike(deploymentDTO.getCategory());
        }
        long count = deploymentQuery.count();
        List<Deployment> deployments = deploymentQuery.orderByDeploymenTime().desc().listPage(firstResult,maxResults);
        List<DeploymentVO> deploymentVOS = Lists.newArrayList();
        deployments.forEach(deployment -> {
            DeploymentVO deploymentVO = new DeploymentVO();
            //忽略二进制文件（模板文件、模板图片）返回
            BeanUtils.copyProperties(deployment,deploymentVO,"resources");
            deploymentVOS.add(deploymentVO);
        });
        page.setRecords(deploymentVOS);
        page.setTotal(count);
        return page;
    }
}
