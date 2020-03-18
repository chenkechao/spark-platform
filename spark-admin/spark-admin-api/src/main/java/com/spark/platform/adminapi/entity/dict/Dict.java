package com.spark.platform.adminapi.entity.dict;

import com.baomidou.mybatisplus.annotation.TableName;
import com.spark.platform.common.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminapi.entity.dict
 * @ClassName: Dict
 * @Description:
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@TableName("sys_dict")
@ApiModel(value = "Dict",description = "字典设置")
public class Dict extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 字典值
     */
    private Integer value;

    /**
     * 上级ID
     */
    private Long pid;

    /**
     * 字典名称
     */
    private String name;

    /**
     * 字典类型
     */
    private String type;

    /**
     * 是否删除 (0 是  1否)
     */
    private Integer isDeleted;


}