/** Copyright 2020 bejson.com */
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
public class MemberPrice {

  private Long id;
  private String name;
  private BigDecimal price;
}
