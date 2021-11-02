package com.jehon.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jehon.common.utils.PageUtils;
import com.jehon.mall.product.entity.AttrEntity;
import com.jehon.mall.product.entity.AttrGroupEntity;
import com.jehon.mall.product.vo.AttrGroupRelationVo;
import com.jehon.mall.product.vo.AttrGroupWithAttrsVo;
import com.jehon.mall.product.vo.SpuItemAttrGroupVo;

import java.util.List;
import java.util.Map;

/**
 * 属性分组
 *
 * @author jehon
 * @email 771970504@qq.com
 * @date 2021-10-26 16:39:35
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, Long catelogId);

    List<AttrGroupWithAttrsVo> getAttrGroupWithAttrsByCatelogId(Long catelogId);

    List<SpuItemAttrGroupVo> getAttrGroupWithAttrsBySpuId(Long spuId, Long catalogId);
}

