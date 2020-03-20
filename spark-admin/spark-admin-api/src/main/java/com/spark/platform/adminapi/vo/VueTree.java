package com.spark.platform.adminapi.vo;

import lombok.Data;

import java.util.List;

/**
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.adminapi.vo
 * @ClassName: VueTree
 * @Author: wangdingfeng
 * @Description: vue 树节点数据
 * @Date: 2020/3/20 15:19
 * @Version: 1.0
 */
@Data
public class VueTree {

    private Long id;

    private String label;

    private Long pid;

    private List<VueTree> children;
}
