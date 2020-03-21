package com.spark.platform.adminapi.entity.dict;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.spark.platform.common.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;


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
public class Dict extends BaseEntity{

    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 上级ID
     */
    private Long pid;

    /**
     * 字典值
     */
    private Integer value;

    /**
     * 字典名称
     */
    private String name;

    /**
     * 字典类型
     */
    private String type;

    /**
     * 描述
     */
    private String description;


}
