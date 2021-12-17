package com.jehon.mall.search.service;

import com.jehon.common.es.SkuEsModel;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author jehon
 * @email 771970504@qq.com
 * @date 2021-10-26 16:39:35
 */
public interface ProductSaveService {

    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;
}
