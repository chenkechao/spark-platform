package com.spark.platform.adminbiz.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spark.platform.adminapi.entity.log.ApiLog;
import com.spark.platform.adminbiz.service.log.ApiLogService;
import com.spark.platform.common.base.support.ApiResponse;
import com.spark.platform.common.base.support.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminbiz.controller
 * @ClassName: ApiLogController
 * @Author: wangdingfeng
 * @Description: 日志Api
 * @Date: 2020/3/24 13:20
 * @Version: 1.0
 */
@RestController
@RequestMapping("/log")
@Api(tags = "请求日志")
public class ApiLogController extends BaseController {

    @Autowired
    private ApiLogService apiLogService;

    @PostMapping("/page")
    @ApiOperation(value = "分页获取日志信息")
    public ApiResponse page(ApiLog apiLog, Page page) {
        return success(apiLogService.findPage(apiLog, page));
    }

    @PostMapping("/api/save")
    @ApiOperation(value = "保存日志信息")
    public ApiResponse save(@RequestBody ApiLog apiLog) {
        return success(apiLogService.save(apiLog));
    }

}
