package com.spark.platform.adminapi.feign.client;

import com.spark.platform.common.base.constants.ServiceNameConstants;
import com.spark.platform.commonfeign.config.FeignRequestInterceptorConfig;
import com.spark.platform.adminapi.feign.fallback.AuthorityClientFallBack;
import com.spark.platform.common.base.support.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: LHL
 * @ProjectName: sophia_scaffolding
 * @Package: com.scaffolding.sophia.admin.api.feign.client
 * @ClassName: AuthorityClient
 * @Description:
 * @Version: 1.0
 */
@FeignClient(contextId = "authorityClient", name = ServiceNameConstants.SOPHIA_ADMIN, configuration = FeignRequestInterceptorConfig.class, fallback = AuthorityClientFallBack.class)
public interface AuthorityClient {

    @GetMapping("/authority/api/info")
    ApiResponse getOauthClientDetailsByClientId(@RequestParam String clientId);
}
