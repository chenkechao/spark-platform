package com.spark.platform.adminapi.feign.fallback;

import com.spark.platform.adminapi.feign.client.AuthorityClient;
import com.spark.platform.common.base.constants.ServiceNameConstants;
import com.spark.platform.common.base.support.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminapi.feign.fallback
 * @ClassName: AuthorityClientFallBack
 * @Description:
 * @Version: 1.0
 */
@Component
@Slf4j
public class AuthorityClientFallBack implements AuthorityClient {
    @Override
    public ApiResponse getOauthClientDetailsByClientId(String clientId) {
        log.error("调用spark-admin服务AuthorityClient:getOauthClientDetailsByClientId方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.SPARK_ADMIN, "getOauthClientDetailsByClientId");
    }
}
