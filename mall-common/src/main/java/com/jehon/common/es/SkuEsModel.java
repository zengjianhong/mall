package com.jehon.common.es;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author jehon
 *
 * @email 771970504@qq.com
 * @date 2021-10-26 16:39:35
 */
@Data
public class SkuEsModel {

    private Long skuId;

    private Long spuId;

    private String skuTitle;

    private BigDecimal skuPrice;

    private String skuImg;

    private Long saleCount;

    private Boolean hasStock;

    private Long hotScore;

    private Long brandId;

    private Long catalogId;

    private String brandName;

    private String brandImg;

    private String catalogName;

    private List<Attrs> attrs;

    @Data
    public static class Attrs {

        private Long attrId;

        private String attrName;

        private String attrValue;

    }
}
