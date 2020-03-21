package com.spark.platform.adminbiz.controller;

import com.spark.platform.adminapi.entity.authority.Menu;
import com.spark.platform.adminapi.vo.MenuVue;
import com.spark.platform.adminbiz.service.menu.MenuService;
import com.spark.platform.common.base.support.BaseController;
import com.spark.platform.adminapi.dto.UserDto;
import com.spark.platform.adminapi.entity.role.Role;
import com.spark.platform.adminapi.entity.user.User;
import com.spark.platform.adminapi.vo.UserVo;
import com.spark.platform.adminbiz.service.role.RoleService;
import com.spark.platform.adminbiz.service.user.UserService;
import com.spark.platform.common.base.support.ApiResponse;
import com.spark.platform.common.security.model.LoginUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminbiz.controller
 * @ClassName: APIController
 * @Description: 用户登录
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api")
@Api(tags = "用户登录")
public class APIController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/principal")
    @ApiOperation(value = "获取用户信息")
    public ApiResponse getUserInfo() {
        UserDto userDto = new UserDto();
        LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(null == loginUser){
            return fail("登录失效");
        }
        User user = userService.loadUserByUserId(loginUser.getId());
        UserVo userVo = new UserVo();
        //查询角色信息
        List<String> roles = roleService.getRoleByUserId(loginUser.getId()).stream().map(Role::getRoleCode).collect(toList());
        //查询权限信息
        List<String> authList = menuService.findAuthByUserId(loginUser.getId()).stream().map(Menu::getPermission).collect(toList());
        //查询路由菜案信息
        List<MenuVue> menuList = menuService.findMenuTree(loginUser.getUsername());
        BeanUtils.copyProperties(user, userVo);
        userDto.setSysUser(userVo);
        userDto.setPermissions(authList);
        userDto.setRoles(roles);
        userDto.setMenus(menuList);
        return success(userDto);
    }

    /**
     * 开放登录接口
     * @param userVo
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口")
    public ApiResponse webLogin(@RequestBody UserVo userVo){
        UserVo result = userService.loginByPassword(userVo.getUsername(), userVo.getPassword());
        if(null != result){
            return success(result);
        }
        return fail("账户名或密码错误");
    }


}
