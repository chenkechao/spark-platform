package com.spark.platform.adminapi.feign.fallback;

import com.spark.platform.common.base.constants.ServiceNameConstants;
import com.spark.platform.adminapi.feign.client.ApiClient;
import com.spark.platform.common.base.support.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminapi.feign.fallback
 * @ClassName: ApiClientFallBack
 * @Description:
 * @Version: 1.0
 */
@Component
@Slf4j
public class ApiClientFallBack implements ApiClient {
    @Override
    public ApiResponse getUserInfo() {
        log.error("调用spark-admin服务ApiClient:getUserInfo方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.SPARK_ADMIN , "getUserInfo");
    }

}
