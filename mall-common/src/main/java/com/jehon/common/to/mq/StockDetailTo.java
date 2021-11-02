package com.jehon.common.to.mq;

import lombok.Data;

/**
 * @author jehon
 *
 * @email 771970504@qq.com
 * @date 2021-10-26 16:39:35
 */
@Data
public class StockDetailTo {

    private Long id;
    /**
     * sku_id
     */
    private Long skuId;
    /**
     * sku_name
     */
    private String skuName;
    /**
     * 购买个数
     */
    private Integer skuNum;
    /**
     * 工作单id
     */
    private Long taskId;

    /**
     * 仓库id
     */
    private Long wareId;

    /**
     * 锁定状态
     */
    private Integer lockStatus;
}
