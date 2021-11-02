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
public class Skus {

  private List<Attr> attr;

  private String skuName;

  private BigDecimal price;

  private String skuTitle;

  private String skuSubtitle;

  private List<Images> images;

  private List<String> descar;

  private int fullCount;

  private BigDecimal discount;

  private int countStatus;

  private BigDecimal fullPrice;

  private BigDecimal reducePrice;

  private int priceStatus;

  private List<MemberPrice> memberPrice;
}
