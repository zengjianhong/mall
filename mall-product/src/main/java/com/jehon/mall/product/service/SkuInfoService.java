package com.jehon.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jehon.common.utils.PageUtils;
import com.jehon.mall.product.entity.SkuInfoEntity;
import com.jehon.mall.product.vo.SkuItemVo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * sku信息
 *
 * @author jehon
 * @email 771970504@qq.com
 * @date 2021-10-26 16:39:35
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSkuInfo(SkuInfoEntity skuInfoEntity);

    PageUtils queryPageCondition(Map<String, Object> params);

    List<SkuInfoEntity> getSkusBySpuId(Long spuId);

    /**
     * 查询商品详情
     * @param skuId
     * @return
     */
    SkuItemVo item(Long skuId) throws ExecutionException, InterruptedException;
}

