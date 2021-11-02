package com.jehon.mall.product.feign;

import com.jehon.common.es.SkuEsModel;
import com.jehon.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 *
 * @author jehon
 * @email 771970504@qq.com
 * @date 2021-10-26 16:39:35
 */
@FeignClient("mall-search")
public interface SearchFeignService {

    @PostMapping(value = "/search/save/product")
    R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels);
}
