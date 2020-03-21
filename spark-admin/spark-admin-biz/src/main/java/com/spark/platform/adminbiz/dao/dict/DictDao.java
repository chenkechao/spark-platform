package com.spark.platform.adminbiz.dao.dict;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spark.platform.adminapi.entity.dict.Dict;
import com.spark.platform.adminapi.vo.VueTree;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: wangdingfeng
 * @Date: 2020/3/21 13:34
 * @Description: 字典 dao
 */
@Repository
public interface DictDao extends BaseMapper<Dict> {

    /**
     * 查询树节点
     * @return
     */
    @Select("SELECT id,pid,name AS 'label' FROM sys_dict WHERE del_flag = 0")
    @ResultType(VueTree.class)
    List<VueTree> getTree();

}
