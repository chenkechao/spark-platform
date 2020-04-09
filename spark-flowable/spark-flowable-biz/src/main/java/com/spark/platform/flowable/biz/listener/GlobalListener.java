package com.spark.platform.flowable.biz.listener;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.BaseExecutionListener;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.identitylink.api.IdentityLink;
import org.flowable.task.service.delegate.DelegateTask;

import java.util.Date;
import java.util.Set;

/**
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.flowable.biz.listener
 * @ClassName: GlobalListener
 * @Author: wangdingfeng
 * @Description: 执行监听器
 * @Date: 2020/4/8 14:21
 * @Version: 1.0
 */
@Slf4j
public class GlobalListener implements TaskListener,ExecutionListener {

    @Override
    public void notify(DelegateExecution delegateExecution) {
        String defId = delegateExecution.getProcessDefinitionId();
        String instanceId = delegateExecution.getProcessInstanceId();
        String eventName = delegateExecution.getEventName();
        log.info("流程定义ID:{}   流程实例ID:{}", defId, instanceId);
        log.debug("监听器事件名称：{}", eventName);
        switch (eventName){
            case BaseExecutionListener.EVENTNAME_START:
                delegateExecution.setVariable("SYSTEM_JUDGE_SUBMIT_VALUE","pass");
                log.debug("{}事件执行了start", eventName);break;
            case BaseExecutionListener.EVENTNAME_END:
                log.debug("{}事件执行了end", eventName);break;
            case BaseExecutionListener.EVENTNAME_TAKE:
                log.debug("{}事件执行了take", eventName);break;
            default:
                break;
        }
    }

    @Override
    public void notify(DelegateTask delegateTask) {
        Date createTime = delegateTask.getCreateTime();
        String name = delegateTask.getName();
        String eventName = delegateTask.getEventName();
        String assignee = delegateTask.getAssignee();
        Set<IdentityLink> candidates = delegateTask.getCandidates();
        log.info("演示任务相关信息===========================================================");
        log.info("任务Key:{}",  delegateTask.getTaskDefinitionKey());
        log.info("任务Name:{}", name);
        log.info("任务createTime:{}", createTime);
        log.info("任务assignee:{}", assignee);
        log.info("任务candidates:{}", candidates);
    }
}
