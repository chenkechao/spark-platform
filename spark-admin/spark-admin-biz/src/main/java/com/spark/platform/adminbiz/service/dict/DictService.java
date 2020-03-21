package com.spark.platform.adminbiz.service.dict;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.spark.platform.adminapi.entity.dict.Dict;
import com.spark.platform.adminapi.vo.VueTree;

import java.util.List;

/**
 * @author: wangdingfeng
 * @Date: 2020/3/21 13:36
 * @Description:
 */
public interface DictService extends IService<Dict> {

    /**
     * 分页数据
     * @param dict
     * @param page
     * @return
     */
    IPage findPage(Dict dict, Page page);

    /**
     * 获取树
     * @return
     */
    List<VueTree> getTree();

}
