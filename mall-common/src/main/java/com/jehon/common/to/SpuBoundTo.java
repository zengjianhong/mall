package com.jehon.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author jehon
 *
 * @email 771970504@qq.com
 * @date 2021-10-26 16:39:35
 */
@Data
public class SpuBoundTo {

    private Long spuId;

    private BigDecimal buyBounds;

    private BigDecimal growBounds;
}
