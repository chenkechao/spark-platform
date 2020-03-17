package com.spark.platform.adminbiz.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spark.platform.adminapi.entity.user.User;
import com.spark.platform.common.base.support.BaseController;
import com.spark.platform.adminbiz.service.user.UserService;
import com.spark.platform.common.base.support.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author: LHL
 * @ProjectName: sophia_scaffolding
 * @Package: com.scaffolding.sophia.admin.biz.controller
 * @ClassName: UserController
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/info/{id}")
    @ApiOperation(value = "根据用户id获取用户信息")
    public ApiResponse getUserByUserId(@PathVariable Long id) {
        return success(userService.loadUserByUserId(id));
    }

    @GetMapping("/api")
    @ApiOperation(value = "根据用户名获取用户信息")
    public ApiResponse getUserByUserName(@RequestParam String username) {
        return success(userService.loadUserByUserName(username));
    }

    /**
     * 测试权限
     * @return
     */
    @GetMapping("/auth")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public ApiResponse auth(){
        return success("获取成功");
    }

    /**
     * 分页查询数据
     * @param user
     * @param page
     * @return
     */
    @PostMapping("/page")
    @ApiOperation(value = "获取用户列表分页")
    public ApiResponse page(User user, Page page){
        return success(userService.findPage(user,page));
    }
}
