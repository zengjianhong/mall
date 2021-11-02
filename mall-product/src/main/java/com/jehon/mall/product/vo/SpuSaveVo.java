/** Copyright 2020 bejson.com */
package com.jehon.mall.product.vo;

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
public class SpuSaveVo {

  private String spuName;

  private String spuDescription;

  private Long catalogId;

  private Long brandId;

  private BigDecimal weight;

  private int publishStatus;

  private List<String> decript;

  private List<String> images;

  private Bounds bounds;

  private List<BaseAttrs> baseAttrs;

  private List<Skus> skus;
}
