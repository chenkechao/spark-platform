package com.spark.platform.adminbiz.service.authority;


import com.spark.platform.adminapi.entity.authority.OauthClientDetails;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminbiz.service.authority
 * @ClassName: oauthClientDetailsService
 * @Description: Oauth 授权管理
 * @Version: 1.0
 */
public interface OauthClientDetailsService{

    /**
     * 根据clientId查询OauthClientDetails
     *
     * @param clientId clientId
     * @return OauthClientDetails
     */
    OauthClientDetails findOauthClientDetailsByClientId(String clientId);

}
