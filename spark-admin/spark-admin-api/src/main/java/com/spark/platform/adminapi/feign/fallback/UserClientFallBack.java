package com.spark.platform.adminapi.feign.fallback;


import com.spark.platform.adminapi.feign.client.UserClient;
import com.spark.platform.common.base.constants.ServiceNameConstants;
import com.spark.platform.common.base.support.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminapi.feign.fallback
 * @ClassName: UserClientFallBack
 * @Description:
 * @Version: 1.0
 */
@Component
@Slf4j
public class UserClientFallBack implements UserClient {

    @Override
    public ApiResponse getUserByUserName(String username) {
        log.error("spark-admin服务UserClient:getUserByUserName方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.SPARK_ADMIN, "getUserByUserName");
    }

    @Override
    public ApiResponse getUserByUserId(Long id) {
        log.error("调用spark-admin服务UserClient:getUserByUserId方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.SPARK_ADMIN, "getUserByUserId");
    }
}
