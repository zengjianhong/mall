package com.jehon.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jehon.common.utils.PageUtils;
import com.jehon.mall.ware.entity.WareOrderTaskEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author jehon
 * @email 771970504@qq.com
 * @date 2021-10-26 23:20:04
 */
public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);

    WareOrderTaskEntity getOrderTaskByOrderSn(String orderSn);
}

