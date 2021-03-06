package com.jehon.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jehon.common.to.SkuReductionTo;
import com.jehon.common.utils.PageUtils;
import com.jehon.mall.coupon.entity.SkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author jehon
 * @email 771970504@qq.com
 * @date 2021-10-26 23:07:57
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSkuReduction(SkuReductionTo skuReductionTo);
}

