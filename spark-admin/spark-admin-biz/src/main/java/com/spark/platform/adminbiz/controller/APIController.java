package com.spark.platform.adminbiz.controller;

import com.google.common.collect.Lists;
import com.spark.platform.adminbiz.service.authority.AuthorityService;
import com.spark.platform.adminbiz.service.menu.MenuService;
import com.spark.platform.common.base.support.BaseController;
import com.spark.platform.adminapi.dto.UserDto;
import com.spark.platform.adminapi.entity.authority.Authority;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: LHL
 * @ProjectName: sophia_scaffolding
 * @Package: com.scaffolding.sophia.admin.biz.controller
 * @ClassName: APIController
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api")
@Api(tags = "用户登录")
public class APIController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;


    @GetMapping("/principal")
    @ApiOperation(value = "获取用户信息")
    public ApiResponse getUserInfo() {
        UserDto userDto = new UserDto();
        LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.loadUserByUserId(loginUser.getId());
        UserVo userVo = new UserVo();
        Role role = roleService.getRoleByUserId(loginUser.getId());
        List<Authority> authList = authorityService.findAuthorityByUserId(loginUser.getId());
        List<String> authCodeList = new ArrayList<>();
        List<String> roleCodeList = new ArrayList<>();
        List<String> menuCodeList = new ArrayList<>();
        for (Authority authority : authList) {
            authCodeList.add(authority.getAuthCode());
            menuCodeList.add(authority.getAuthCode());
        }
        roleCodeList.add(role.getRoleCode());
        BeanUtils.copyProperties(user, userVo);
        userDto.setSysUser(userVo);
        userDto.setPermissions(authCodeList);
        userDto.setRoles(roleCodeList);
        userDto.setMenus(menuCodeList);
        Map<String,Object> map = new HashMap<>();
        map.put("name",userVo.getUsername());
        map.put("roles",roleCodeList);
        map.put("avatar",userVo.getHeadImage());
        map.put("routers",menuService.findMenuTree(loginUser.getUsername()));
        return success(map);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口")
    public ApiResponse webLogin(@RequestBody UserVo userVo){
        UserVo result = userService.loginByPassword(userVo.getUsername(), userVo.getPassword());
        if(null != result){
            return success(result);
        }
        return fail("登陆失败");
    }


}
