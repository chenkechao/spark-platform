package com.spark.platform.adminapi.feign.fallback;

import com.spark.platform.adminapi.feign.client.AuthorityClient;
import com.spark.platform.common.base.constants.ServiceNameConstants;
import com.spark.platform.common.base.support.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: LHL
 * @ProjectName: sophia_scaffolding
 * @Package: com.scaffolding.sophia.admin.api.feign.fallback
 * @ClassName: AuthorityClientFallBack
 * @Description:
 * @Version: 1.0
 */
@Component
public class AuthorityClientFallBack implements AuthorityClient {

    private final Logger logger = LoggerFactory.getLogger(AuthorityClientFallBack.class);

    @Override
    public ApiResponse getOauthClientDetailsByClientId(String clientId) {
        logger.error("调用sophia-admin服务getOauthClientDetailsByClientId方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.SOPHIA_ADMIN, "getOauthClientDetailsByClientId");
    }
}
