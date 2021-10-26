package com.jehon.mall.order.dao;

import com.jehon.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author jehon
 * @email 771970504@qq.com
 * @date 2021-10-26 23:16:35
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
