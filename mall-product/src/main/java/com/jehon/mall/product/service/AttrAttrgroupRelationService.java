package com.jehon.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jehon.common.utils.PageUtils;
import com.jehon.mall.product.entity.AttrAttrgroupRelationEntity;
import com.jehon.mall.product.vo.AttrGroupRelationVo;

import java.util.List;
import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author jehon
 * @email 771970504@qq.com
 * @date 2021-10-26 16:39:35
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveBatch(List<AttrGroupRelationVo> vos);
}

