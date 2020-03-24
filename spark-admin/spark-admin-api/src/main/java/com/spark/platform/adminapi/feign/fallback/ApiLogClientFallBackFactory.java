package com.spark.platform.adminapi.feign.fallback;

import com.spark.platform.adminapi.entity.log.ApiLog;
import com.spark.platform.adminapi.feign.client.ApiLogClient;
import com.spark.platform.common.base.constants.ServiceNameConstants;
import com.spark.platform.common.base.support.ApiResponse;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminapi.feign.fallback
 * @ClassName: ApiLogClientFallBack
 * @Author: wangdingfeng
 * @Description: 日志调用失败返回错误信息
 * @Date: 2020/3/24 13:33
 * @Version: 1.0
 */
@Component
@Slf4j
public class ApiLogClientFallBackFactory implements FallbackFactory<ApiLogClient> {

    @Override
    public ApiLogClient create(Throwable throwable) {
        return new ApiLogClient() {
            @Override
            public ApiResponse save(ApiLog apiLog) {
                log.error("调用spark-admin服务ApiLogClient:save方法失败!,错误日志:{}",throwable.getMessage());
                return ApiResponse.hystrixError(ServiceNameConstants.SPARK_ADMIN , "save");
            }
        };
    }
}
