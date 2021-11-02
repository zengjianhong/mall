package com.jehon.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jehon.common.to.OrderTo;
import com.jehon.common.to.SkuHasStockVo;
import com.jehon.common.to.mq.StockLockedTo;
import com.jehon.common.utils.PageUtils;
import com.jehon.mall.ware.entity.WareSkuEntity;
import com.jehon.mall.ware.vo.WareSkuLockVo;

import java.util.List;
import java.util.Map;

/**
 * 商品库存
 *
 * @author jehon
 * @email 771970504@qq.com
 * @date 2021-10-26 23:20:04
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 添加库存
     * @param skuId
     * @param wareId
     * @param skuNum
     */
    void addStock(Long skuId, Long wareId, Integer skuNum);

    /**
     * 判断是否有库存
     * @param skuIds
     * @return
     */
    List<SkuHasStockVo> getSkuHasStock(List<Long> skuIds);

    /**
     * 锁定库存
     * @param vo
     * @return
     */
    boolean orderLockStock(WareSkuLockVo vo);


    /**
     * 解锁库存
     * @param to
     */
    void unlockStock(StockLockedTo to);

    /**
     * 解锁订单
     * @param orderTo
     */
    void unlockStock(OrderTo orderTo);
}

