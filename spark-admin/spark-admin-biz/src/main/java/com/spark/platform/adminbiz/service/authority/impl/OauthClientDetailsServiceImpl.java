package com.spark.platform.adminbiz.service.authority.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spark.platform.adminbiz.service.authority.OauthClientDetailsService;
import com.spark.platform.common.base.constants.GlobalsConstants;
import com.spark.platform.adminapi.entity.authority.OauthClientDetails;
import com.spark.platform.adminbiz.dao.authority.OauthClientDetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminbiz.service.authority.impl
 * @ClassName: OauthClientDetailsServiceImpl
 * @Description: Oauth 授权管理
 * @Version: 1.0
 */
@Service("oauthClientDetailsService")
public class OauthClientDetailsServiceImpl extends ServiceImpl<OauthClientDetailsDao, OauthClientDetails> implements OauthClientDetailsService {

    @Autowired
    private OauthClientDetailsDao oauthClientDetailsDao;

    @Override
    @Cacheable(value= GlobalsConstants.REDIS_CLIENT_CACHE,unless = "#result == null", key="T(com.spark.platform.common.base.constants.GlobalsConstants).CLIENT_DETAILS_KEY.concat(T(String).valueOf(#clientId))")
    public OauthClientDetails findOauthClientDetailsByClientId(String clientId) {
        return oauthClientDetailsDao.getOauthClientDetailsByClientId(clientId);
    }
}