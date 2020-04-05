package com.spark.platform.flowable.biz.service.impl;

import com.spark.platform.flowable.api.vo.TaskVO;
import com.spark.platform.flowable.biz.service.ActTaskQueryService;
import com.spark.platform.flowable.biz.service.ActTaskService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.task.Comment;
import org.flowable.task.api.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangdingfeng
 * @Date: 2020/4/4 21:49
 * @Description: 流程任务相关Service
 */
@Service
@Slf4j
public class ActTaskServiceImpl implements ActTaskService {

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private ActTaskQueryService actTaskQueryService;

    @Override
    public void setVariableLocal(String taskId, String variableName, Object value) {
        taskService.setVariableLocal(taskId, variableName, value);
    }

    @Override
    public void setVariablesLocal(String taskId, Map<String, ? extends Object> variables) {
        taskService.setVariablesLocal(taskId, variables);
    }

    @Override
    public void claim(String taskId, String userId) {
        log.info("-----签收任务ID:{}，签收人ID:{}---------",taskId,userId);
        taskService.claim(taskId, userId);
    }

    @Override
    public void unClaim(String taskId) {
        log.info("-----反签收任务ID:{}---------",taskId);
        taskService.unclaim(taskId);
    }

    @Override
    public void complete(String taskId) {
        this.complete(taskId, null);
        log.info("-----------任务ID：{},已完成-----------", taskId);
    }

    @Override
    public void complete(String taskId, Map<String, Object> variables) {
        log.info("-----完成任务ID:{}---------",taskId);
        taskService.complete(taskId, variables);
    }

    @Override
    public Map<String, Object> complete(String taskId, Map<String, Object> variables, boolean localScope) {
        TaskVO finishTask = actTaskQueryService.queryTaskVOById(taskId);
        if(null == finishTask || StringUtils.isBlank(finishTask.getId())){
            throw new RuntimeException("任务已经被提交");
        }
        taskService.complete(taskId, variables, localScope);
        Task task = actTaskQueryService.processInstanceId(finishTask.getProcessInstanceId());
        TaskVO activeTask = new TaskVO();
        BeanUtils.copyProperties(task, activeTask);
        Map<String, Object> map = new HashMap<>(16);
        map.put("finish", finishTask);
        map.put("active", activeTask);
        return map;
    }

    @Override
    public void setAssignee(String taskId, String userId) {
        log.info("-----移交任务ID:{},移交给用户ID:{}---------",taskId,userId);
        taskService.setAssignee(taskId, userId);
    }

    @Override
    public void delegate(String taskId, String userId) {
        log.info("-----委派任务ID:{},委派给用户ID:{}---------",taskId,userId);
        taskService.delegateTask(taskId, userId);
    }

    @Override
    public void resolveTask(String taskId) {
        log.info("-----委派完成任务ID:{}---------",taskId);
        taskService.resolveTask(taskId);
    }

    @Override
    public void setOwner(String taskId, String userId) {
        log.info("-----更改任务拥有者：任务ID:{},用户ID:{}---------",taskId,userId);
        taskService.setOwner(taskId, userId);
    }

    @Override
    public void delete(String taskId) {
        log.info("-----删除任务：任务ID:{}---------",taskId);
        taskService.deleteTask(taskId);
    }

    @Override
    public void deleteWithReason(String taskId, String reason) {
        log.info("-----删除任务：任务ID:{}---------",taskId);
        taskService.deleteTask(taskId, reason);
    }

    @Override
    public void addCandidateUser(String taskId, String userId) {
        log.info("----任务添加任务处理人：任务ID:{},处理人ID：{}---------",taskId,userId);
        taskService.addCandidateUser(taskId, userId);
    }

    @Override
    public Comment addComment(String taskId, String processInstanceId, String message) {
        log.info("----任务或者流程实例添加备注：任务ID:{},流程实例ID{}---------",taskId,processInstanceId);
        return taskService.addComment(taskId, processInstanceId, message);
    }

    @Override
    public List<Comment> getTaskComments(String taskId) {
        return taskService.getTaskComments(taskId);
    }

    @Override
    public void withdraw(String processInstanceId, String currentActivityId, String newActivityId) {
        log.info("----任务撤回：流程实例ID:{},当前活动任务ID:{},撤回到达的任务ID:{}，---------",processInstanceId,currentActivityId,newActivityId);
        runtimeService.createChangeActivityStateBuilder()
                .processInstanceId(processInstanceId)
                .moveActivityIdTo(currentActivityId, newActivityId)
                .changeState();
    }
}
