package com.spark.platform.adminapi.feign.client;

import com.spark.platform.adminapi.feign.fallback.ApiClientFallBack;
import com.spark.platform.common.base.constants.ServiceNameConstants;
import com.spark.platform.commonfeign.config.FeignRequestInterceptorConfig;
import com.spark.platform.common.base.support.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminapi.feign.client
 * @ClassName: ApiClient
 * @Description:
 * @Version: 1.0
 */
@FeignClient(contextId = "apiClient", name = ServiceNameConstants.SOPHIA_ADMIN, configuration = FeignRequestInterceptorConfig.class, fallback = ApiClientFallBack.class)
public interface ApiClient {

    @GetMapping("/api/principal")
    ApiResponse getUserInfo();

}
