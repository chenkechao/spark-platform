package com.spark.platform.adminbiz.service.dict.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spark.platform.adminapi.entity.dict.Dict;
import com.spark.platform.adminapi.vo.VueTree;
import com.spark.platform.adminbiz.dao.dict.DictDao;
import com.spark.platform.adminbiz.service.dict.DictService;
import com.spark.platform.common.utils.TreeUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wangdingfeng
 * @Date: 2020/3/21 13:36
 * @Description:
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictDao, Dict> implements DictService {

    @Override
    public IPage findPage(Dict dict, Page page) {

        return super.page(page);
    }

    @Override
    public List<VueTree> getTree() {
        return (List<VueTree>) TreeUtils.toTree(super.baseMapper.getTree(),VueTree.class);
    }
}
