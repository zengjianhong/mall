package com.jehon.mall.product.dao;

import com.jehon.mall.product.entity.AttrAttrgroupRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 属性&属性分组关联
 * 
 * @author jehon
 * @email 771970504@qq.com
 * @date 2021-10-26 16:39:35
 */
@Mapper
public interface AttrAttrgroupRelationDao extends BaseMapper<AttrAttrgroupRelationEntity> {

    void deleteBatchRelation(List<AttrAttrgroupRelationEntity> entityList);
}
