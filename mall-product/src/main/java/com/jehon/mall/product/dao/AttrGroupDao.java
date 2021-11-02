package com.jehon.mall.product.dao;

import com.jehon.mall.product.entity.AttrGroupEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jehon.mall.product.vo.SpuItemAttrGroupVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 属性分组
 * 
 * @author jehon
 * @email 771970504@qq.com
 * @date 2021-10-26 16:39:35
 */
@Mapper
public interface AttrGroupDao extends BaseMapper<AttrGroupEntity> {

    List<SpuItemAttrGroupVo> getAttrGroupWithAttrsBySpuId(Long spuId, Long catalogId);
}
