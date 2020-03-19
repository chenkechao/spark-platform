package com.spark.platform.adminbiz.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spark.platform.adminapi.entity.role.Role;
import com.spark.platform.adminbiz.service.role.RoleService;
import com.spark.platform.common.base.support.BaseController;
import com.spark.platform.common.base.support.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminbiz.controller
 * @ClassName: RoleController
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/role")
@Api(tags = "角色管理")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/info/{id}")
    @ApiOperation(value = "根据用户id获取用户角色信息")
    public ApiResponse getRoleByUserId(@PathVariable Long id) {
        return success(roleService.getRoleByUserId(id));
    }

    @PostMapping("/page")
    @ApiOperation(value = "获取角色列表分页")
    public ApiResponse page(Role role, Page page){
        return success(roleService.findPage(role,page));
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存角色信息")
    public ApiResponse save(@RequestBody Role role){
        return success(roleService.save(role));
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新角色信息")
    public ApiResponse update(@RequestBody Role role){
        return success(roleService.updateById(role));
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "更新角色信息")
    public ApiResponse delete(@PathVariable Long id){
        return success(roleService.removeById(id));
    }


}
