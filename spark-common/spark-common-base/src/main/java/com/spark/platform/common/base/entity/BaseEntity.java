package com.spark.platform.common.base.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.common.base.entity
 * @ClassName: BaseEntity
 * @Description:
 * @Version: 1.0
 */
@Data
public abstract class BaseEntity {

    /**
     * 创建人
     */
    private String creator;
    /**
     * 修改人
     */
    private String modifier;
    /**
     * 创建时间
     */
    private LocalDateTime createDate;
    /**
     * 修改时间
     */
    private LocalDateTime modifyDate;
    /**
     * 系统状态
     */
    private Integer delFlag;
    /**
     * 备注
     */
    private String remarks;
}
