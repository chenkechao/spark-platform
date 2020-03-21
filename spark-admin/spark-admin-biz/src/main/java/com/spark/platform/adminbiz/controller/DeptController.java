package com.spark.platform.adminbiz.controller;

import com.spark.platform.adminapi.entity.dept.Dept;
import com.spark.platform.adminbiz.service.dept.DeptService;
import com.spark.platform.common.base.support.ApiResponse;
import com.spark.platform.common.base.support.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: wangdingfeng
 * @Date: 2020/3/20 22:42
 * @Description: 部门管理
 */
@RestController
@RequestMapping("/dept")
@Api(tags = "部门管理")
public class DeptController extends BaseController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/list")
    @ApiOperation(value = "部门列表")
    public ApiResponse list(@RequestBody Dept dept){
        return success(deptService.list(dept));
    }

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "根据id获取部门信息")
    public ApiResponse findById(@PathVariable Long id){
        return success(deptService.getById(id));
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存部门信息")
    public ApiResponse save(@RequestBody Dept dept){
        return success(deptService.list(dept));
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新部门信息")
    public ApiResponse update(@RequestBody Dept dept){
        return success(deptService.list(dept));
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "更新部门信息")
    public ApiResponse update(@PathVariable Long id){
        return success(deptService.removeById(id));
    }


}
