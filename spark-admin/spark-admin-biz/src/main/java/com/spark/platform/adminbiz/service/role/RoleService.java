package com.spark.platform.adminbiz.service.role;


import com.spark.platform.adminapi.entity.role.Role;

import java.util.List;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminbiz.service.role
 * @ClassName: RoleService
 * @Description:
 * @Version: 1.0
 */
public interface RoleService {


    /**
     * 根据用户id查询用户的角色
     *
     * @param userId 用户id
     * @return Role
     */
    List<Role> getRoleByUserId(Long userId);
}
