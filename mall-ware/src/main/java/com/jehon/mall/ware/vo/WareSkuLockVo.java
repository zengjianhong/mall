package com.jehon.mall.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description 锁定库存的vo
 * @author jehon
 *
 * @email 771970504@qq.com
 * @date 2021-10-26 23:20:04
 */
@Data
public class WareSkuLockVo {

    private String orderSn;

    /** 需要锁住的所有库存信息 **/
    private List<OrderItemVo> locks;
}