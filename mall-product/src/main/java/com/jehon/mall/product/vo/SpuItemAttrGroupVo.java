package com.jehon.mall.product.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author jehon
 *
 * @email 771970504@qq.com
 * @date 2021-10-26 16:39:35
 */
@Data
@ToString
public class SpuItemAttrGroupVo {

    private String groupName;

    private List<Attr> attrs;
}
