package com.spark.platform.adminapi.feign.client;

import com.spark.platform.adminapi.feign.fallback.RoleClientFallBack;
import com.spark.platform.common.base.constants.ServiceNameConstants;
import com.spark.platform.common.feign.config.FeignRequestInterceptorConfig;
import com.spark.platform.common.base.support.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminapi.feign.client
 * @ClassName: RoleClient
 * @Description:
 * @Version: 1.0
 */
@FeignClient(contextId = "roleClient", name = ServiceNameConstants.SOPHIA_ADMIN, configuration = FeignRequestInterceptorConfig.class, fallback = RoleClientFallBack.class)
public interface RoleClient {

    @GetMapping("/role/info/{id}")
    ApiResponse getRoleByUserId(@PathVariable Long id);
}
