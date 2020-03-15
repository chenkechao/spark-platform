package com.spark.platform.adminbiz.service.authority;


import com.spark.platform.adminapi.entity.authority.Authority;

import java.util.List;

/**
 * @author: LHL
 * @ProjectName: sophia_scaffolding
 * @Package: com.scaffolding.sophia.admin.biz.service.authority
 * @ClassName: AuthorityService
 * @Description:
 * @Version: 1.0
 */
public interface AuthorityService {

    /**
     * 根据用户id查询用户的权限
     *
     * @param id 用户id
     * @return List<Authority>
     */
    List<Authority> findAuthorityByUserId(Long id);
}
