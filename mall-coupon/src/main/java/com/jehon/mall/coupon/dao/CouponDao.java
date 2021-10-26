package com.jehon.mall.coupon.dao;

import com.jehon.mall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author jehon
 * @email 771970504@qq.com
 * @date 2021-10-26 23:07:57
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
