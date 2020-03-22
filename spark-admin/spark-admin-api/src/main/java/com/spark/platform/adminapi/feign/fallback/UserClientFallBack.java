package com.spark.platform.adminapi.feign.fallback;


import com.spark.platform.adminapi.feign.client.UserClient;
import com.spark.platform.common.base.constants.ServiceNameConstants;
import com.spark.platform.common.base.support.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class UserClientFallBack implements UserClient {

    private final Logger logger = LoggerFactory.getLogger(UserClientFallBack.class);

    @Override
    public ApiResponse getUserByUserName(String username) {
        logger.error("spark-admin服务getUserByUserName方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.SPARK_ADMIN, "getUserByUserName");
    }

    @Override
    public ApiResponse getUserByUserId(Long id) {
        logger.error("调用spark-admin服务getUserByUserId方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.SPARK_ADMIN, "getUserByUserId");
    }
}
