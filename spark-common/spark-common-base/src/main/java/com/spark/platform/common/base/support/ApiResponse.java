package com.spark.platform.common.base.support;

import com.spark.platform.common.base.enums.SparkHttpStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.common.base.support
 * @ClassName: ApiResponse
 * @Description: 公共的返回值
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
public class ApiResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    private Object data;

    public ApiResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public ApiResponse(SparkHttpStatus sophiaHttpStatus) {
        this.code = sophiaHttpStatus.getCode();
        this.message = sophiaHttpStatus.getMessage();
    }


    /**
     * 调用服务的错误
     * @param serviceName 服务名
     * @param methodName 方法名
     * @return 结果视图
     */
    public static ApiResponse hystrixError(String serviceName,String methodName) {
        String msg = SparkHttpStatus.HYSTRIX_ERROR.getMessage().replace("xxx", serviceName).replace("{}", methodName);
        return new ApiResponse(SparkHttpStatus.HYSTRIX_ERROR.getCode(), msg);
    }
}
