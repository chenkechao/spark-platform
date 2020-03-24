package com.spark.platform.adminapi.entity.log;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminapi.entity.log
 * @ClassName: ApiLog
 * @Author: wangdingfeng
 * @Description: api请求日志
 * @Date: 2020/3/24 13:09
 * @Version: 1.0
 */
@Data
public class ApiLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * url
     */
    private String url;
    /**
     * 方法名
     */
    private String method;
    /**
    参数
     */
    private String params;
    /**
     * 访问时间
     */
    private LocalDateTime createTime;
    /**
     * 耗时
     */
    private Integer times;
    /**
     * 访问用户
     */
    private String creator;
    /**
     * 访问ip
     */
    private String ip;
    /**
     * 地址
     */
    private String address;
    /**
     * 请求方式
     */
    private String methodType;
    /**
     * 描述
     */
    private String description;
    /**
     * 状态
     */
    private String status;
    /**
     * 错误日志
     */
    private String errorLog;

}
