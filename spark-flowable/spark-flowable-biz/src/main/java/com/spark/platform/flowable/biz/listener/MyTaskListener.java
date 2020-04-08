package com.spark.platform.flowable.biz.listener;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.BaseTaskListener;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.identitylink.api.IdentityLink;
import org.flowable.task.service.delegate.DelegateTask;

import java.util.Date;
import java.util.Set;

/**
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.flowable.biz.listener
 * @ClassName: TaskListener
 * @Author: wangdingfeng
 * @Description: 任务监听器
 * @Date: 2020/4/8 14:22
 * @Version: 1.0
 */
@Slf4j
public class MyTaskListener implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        String taskDefKey = delegateTask.getTaskDefinitionKey();
        Date createTime = delegateTask.getCreateTime();
        String name = delegateTask.getName();
        String eventName = delegateTask.getEventName();
        String assignee = delegateTask.getAssignee();
        Set<IdentityLink> candidates = delegateTask.getCandidates();
        log.info("演示任务相关信息===========================================================");
        log.info("任务Key:{}", taskDefKey);
        log.info("任务Name:{}", name);
        log.info("任务createTime:{}", createTime);
        log.info("任务assignee:{}", assignee);
        log.info("任务candidates:{}", candidates);

        log.error("演示事件执行顺序===========================================================");
        if (BaseTaskListener.EVENTNAME_CREATE.endsWith(eventName)) {
            log.info("创建：create=========");
        } else if (BaseTaskListener.EVENTNAME_ASSIGNMENT.endsWith(eventName)) {
            log.info("指派：assignment========");
        } else if (BaseTaskListener.EVENTNAME_COMPLETE.endsWith(eventName)) {
            log.info("完成：complete===========");
        } else if (BaseTaskListener.EVENTNAME_DELETE.endsWith(eventName)) {
            log.info("销毁：delete=============");
        }
    }
}
