package com.spark.platform.adminbiz.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spark.platform.adminapi.entity.dict.Dict;
import com.spark.platform.adminbiz.service.dict.DictService;
import com.spark.platform.common.base.support.ApiResponse;
import com.spark.platform.common.base.support.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: wangdingfeng
 * @Date: 2020/3/20 22:42
 * @Description: 字典管理
 */
@RestController
@RequestMapping("/dict")
@Api(tags = "字典管理")
public class DictController extends BaseController {

    @Autowired
    private DictService dictService;

    @GetMapping("/page")
    @ApiOperation(value = "字典列表")
    public ApiResponse page(Dict dict, Page page){
        return success(dictService.findPage(dict,page));
    }

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "根据id获取字典信息")
    public ApiResponse findById(@PathVariable Long id){
        return success(dictService.getById(id));
    }

    @GetMapping("/getTree")
    @ApiOperation(value = "获取字典树")
    public ApiResponse getTree(){
        return success(dictService.getTree());
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存字典信息")
    public ApiResponse save(@RequestBody Dict dict){
        return success(dictService.save(dict));
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新字典信息")
    public ApiResponse update(@RequestBody Dict dict){
        return success(dictService.updateById(dict));
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除字典信息")
    public ApiResponse update(@PathVariable Long id){
        return success(dictService.removeById(id));
    }


}
