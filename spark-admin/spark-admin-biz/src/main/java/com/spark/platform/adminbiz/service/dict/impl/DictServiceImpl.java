package com.spark.platform.adminbiz.service.dict.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spark.platform.adminapi.entity.dict.Dict;
import com.spark.platform.adminbiz.dao.dict.DictDao;
import com.spark.platform.adminbiz.service.dict.DictService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


/**
 * @author: wangdingfeng
 * @Date: 2020/3/21 13:36
 * @Description: 字典
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictDao, Dict> implements DictService {


    @Override
    public IPage findPage(Dict dict, Page page) {
        QueryWrapper wrapper = new QueryWrapper<Dict>();
        wrapper.orderByDesc("modify_date");
        if (null != dict) {
            if (StringUtils.isNotBlank(dict.getName())) {
                wrapper.like("name", dict.getName());
            }
            if (StringUtils.isNotBlank(dict.getType())) {
                wrapper.eq("type", dict.getType());
            }
        }
        return super.page(page);
    }

}
