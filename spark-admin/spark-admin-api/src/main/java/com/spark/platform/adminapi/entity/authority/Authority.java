package com.spark.platform.adminapi.entity.authority;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.spark.platform.common.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: LHL
 * @ProjectName: sophia_scaffolding
 * @Package: com.scaffolding.sophia.admin.api.entity.authority.entity
 * @ClassName: Authority
 * @Description:
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@TableName("sys_auth")
@ApiModel(value = "Authority",description = "权限设置")
public class Authority extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 权限名称
     * */
    private String authName;
    /**
     * 权限代码
     * */
    private String authCode;
    /**
     * 权限url
     * */
    private String authUrl;

}
