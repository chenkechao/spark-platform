package com.spark.platform.flowable.biz.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.spark.platform.flowable.api.vo.HistTaskVO;
import com.spark.platform.flowable.biz.service.ActHistTaskService;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.flowable.task.api.history.HistoricTaskInstanceQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wangdingfeng
 * @Date: 2020/4/4 21:48
 * @Description: 历史流程service
 */
@Service
public class ActHistTaskServiceImpl implements ActHistTaskService {

    @Autowired
    private HistoryService historyService;

    @Autowired
    private RuntimeService runtimeService;

    @Override
    public HistoricTaskInstanceQuery createHistoricTaskInstanceQuery() {
        return historyService.createHistoricTaskInstanceQuery();
    }

    @Override
    public HistoricTaskInstance activeTask(String instanceId) {
        return createHistoricTaskInstanceQuery().processInstanceId(instanceId).unfinished().singleResult();
    }

    @Override
    public HistoricTaskInstance finishedTask(String taskId) {
        return createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
    }

    @Override
    public List<HistoricTaskInstance> listByInstanceId(String instanceId) {
        return createHistoricTaskInstanceQuery().processInstanceId(instanceId).orderByTaskCreateTime().desc().list();

    }

    @Override
    public List<HistoricTaskInstance> pageListByInstanceId(String instanceId, int start, int limit) {
        return createHistoricTaskInstanceQuery()
                .processInstanceId(instanceId)
                .orderByTaskCreateTime()
                .desc().listPage(start, limit);

    }

    @Override
    public Page pageListByUserId(String userId, Page page) {
        int firstResult = (int)((page.getCurrent()-1)*page.getSize());
        int maxResults = (int)(page.getCurrent()*page.getSize());
        List<HistoricTaskInstance> historicTaskInstances = createHistoricTaskInstanceQuery().taskAssignee(userId)
                .includeProcessVariables().orderByHistoricTaskInstanceEndTime().desc().
                        listPage(firstResult,maxResults);
        List<HistTaskVO> histTaskVOS = Lists.newArrayList();
        historicTaskInstances.forEach(historicTaskInstance -> {
            HistTaskVO histTaskVO = new HistTaskVO();
            BeanUtil.copyProperties(historicTaskInstance,histTaskVO);
            histTaskVO.setVariables(historicTaskInstance.getProcessVariables());
            histTaskVO.setBusinessKey(runtimeService.createProcessInstanceQuery().processInstanceId(historicTaskInstance.getProcessInstanceId()).singleResult().getBusinessKey());
            histTaskVOS.add(histTaskVO);
        });
        long count = createHistoricTaskInstanceQuery().taskAssignee(userId).count();
        page.setTotal(count);
        page.setRecords(histTaskVOS);
        return page;
    }
}
