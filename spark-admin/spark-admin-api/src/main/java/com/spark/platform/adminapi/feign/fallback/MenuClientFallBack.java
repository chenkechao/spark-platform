package com.spark.platform.adminapi.feign.fallback;

import com.spark.platform.adminapi.feign.client.MenuClient;
import com.spark.platform.common.base.constants.ServiceNameConstants;
import com.spark.platform.common.base.support.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminapi.feign.fallback
 * @ClassName: MenuClientFallBack
 * @Author: wangdingfeng
 * @Description: 调用错误返回结果
 * @Date: 2020/3/17 9:26
 * @Version: 1.0
 */
@Component
@Slf4j
public class MenuClientFallBack implements MenuClient {

    @Override
    public ApiResponse findAuthByUserId(Long userId) {
        log.error("调用spark-admin服务findAuthByUserId方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.SPARK_ADMIN, "findAuthByUserId");
    }
}
