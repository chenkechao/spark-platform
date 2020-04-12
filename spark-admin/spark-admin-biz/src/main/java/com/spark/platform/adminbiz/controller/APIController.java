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
import com.spark.platform.common.security.util.UserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
        LoginUser loginUser = UserUtils.getLoginUser();
        if(null == loginUser){
            return fail("登录失效");
        }
        User user = userService.loadUserByUserId(loginUser.getId());
        UserVo userVo = new UserVo();
        List<Role> roleList = roleService.getRoleByUserId(loginUser.getId());
        //查询角色name信息
        List<String> roleNames = roleList.stream().map(Role::getRoleName).collect(toList());
        //查询角色信息
        List<String> roles = roleList.stream().map(Role::getRoleCode).collect(toList());
        //查询路由菜案信息
        List<MenuVue> menuList = menuService.findMenuTree(loginUser.getUsername());
        BeanUtils.copyProperties(user, userVo);
        userDto.setSysUser(userVo);
        userDto.setRoles(roles);
        userDto.setRoleNames(roleNames);
        userDto.setMenus(menuList);
        return success(userDto);
    }


}
