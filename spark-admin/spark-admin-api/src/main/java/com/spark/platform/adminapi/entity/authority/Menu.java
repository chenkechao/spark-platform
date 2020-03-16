package com.spark.platform.adminapi.entity.authority;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.spark.platform.common.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: LHL
 * @ProjectName: sophia_scaffolding
 * @Package: com.scaffolding.sophia.admin.api.entity.authority
 * @ClassName: Menu
 * @Date: 2019/11/5 09:58
 * @Description:
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@TableName("sys_menu")
@ApiModel(value = "Menu",description = "菜单设置")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父级菜单主键
     */
    private Long pid;

    /**
     * 类型 0 菜单 1 按钮
     */
    private String type;
    /**
     * 是否外链
     */
    private boolean iFrame;

    /**
     * 路径
     */
    private String path;
    /**
     * 组件路径
     */
    private String component;
    /**
     * 权限
     */
    private String permission;
    /**
     * 是否隐藏
     */
    private boolean hidden;
    /**
     * 图标
     */
    private String icon;
    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改时间
     */
    private LocalDateTime modifyDate;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 备注
     */
    private String remarks;
    /**
     * 删除状态
     */
    private String delFlag;

    private List<Menu> children;

}
