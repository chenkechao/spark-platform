package com.spark.platform.adminapi.feign.fallback;

import com.spark.platform.common.base.constants.ServiceNameConstants;
import com.spark.platform.adminapi.feign.client.RoleClient;
import com.spark.platform.common.base.support.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: waangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminapi.feign.fallback
 * @ClassName: RoleClientFallBack
 * @Description:
 * @Version: 1.0
 */
@Component
public class RoleClientFallBack implements RoleClient {

    private final Logger logger = LoggerFactory.getLogger(RoleClientFallBack.class);

    @Override
    public ApiResponse getRoleByUserId(Long id) {
        logger.error("调用spark-admin服务getRoleByUserId方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.SPARK_ADMIN, "getRoleByUserId");
    }
}
