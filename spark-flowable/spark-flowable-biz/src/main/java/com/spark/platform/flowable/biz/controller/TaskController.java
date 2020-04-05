package com.spark.platform.flowable.biz.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spark.platform.common.base.support.ApiResponse;
import com.spark.platform.common.base.support.BaseController;
import com.spark.platform.flowable.biz.service.ActHistTaskService;
import com.spark.platform.flowable.biz.service.ActTaskQueryService;
import com.spark.platform.flowable.biz.service.ActTaskService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: wangdingfeng
 * @Date: 2020/4/5 14:33
 * @Description:
 */
@RestController
@RequestMapping("/runtime/tasks")
public class TaskController extends BaseController {

    @Autowired
    private ActTaskQueryService actTaskQueryService;

    @Autowired
    private ActTaskService actTaskService;

    @Autowired
    private ActHistTaskService actHistTaskService;


    @GetMapping("/page")
    @ApiOperation(value = "根据用户ID或者用户组ID，查询该用户代办", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String"),
            @ApiImplicitParam(name = "groupId", value = "用户组ID", required = true, dataType = "String")
    })
    public ApiResponse page(Page page,String userId,String groupId){
        return success(actTaskQueryService.taskCandidateOrAssignedOrGroupPage(userId,groupId,page));
    }


    public ApiResponse query(){
        return success();
    }


    @GetMapping(value = "/comment")
    @ApiOperation(value = "查询批注信息", produces = "application/json")
    @ApiImplicitParams({@ApiImplicitParam(name = "taskId", value = "任务ID", required = true, dataType = "String")})
    public ApiResponse getTaskComments(String taskId) {
        return success(actTaskService.getTaskComments(taskId));
    }

    @GetMapping(value = "/his/page")
    @ApiOperation(value = "查询批注信息", produces = "application/json")
    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String")})
    public ApiResponse hisPage(Page page,String userId){
        return success(actHistTaskService.pageListByUserId(userId,page));
    }



}
