package com.spark.platform.adminbiz.dao.role;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spark.platform.adminapi.entity.role.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminbiz.dao.role
 * @ClassName: RoleDao
 * @Description:
 * @Version: 1.0
 */
@Repository
public interface RoleDao extends BaseMapper<Role> {

    /**
     * 根据用户id查询用户的角色
     *
     * @param userId 用户id
     * @return Role
     */
    List<Role> getRoleByUserId(@Param(value = "userId") Long userId);
}
