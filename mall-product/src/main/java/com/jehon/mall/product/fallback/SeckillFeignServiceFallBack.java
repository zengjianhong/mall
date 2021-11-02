package com.jehon.mall.product.fallback;

import com.jehon.common.exception.BizCodeEnum;
import com.jehon.common.utils.R;
import com.jehon.mall.product.feign.SeckillFeignService;
import org.springframework.stereotype.Component;

/**
 *
 * @author jehon
 * @email 771970504@qq.com
 * @date 2021-10-26 16:39:35
 */
@Component
public class SeckillFeignServiceFallBack implements SeckillFeignService {

    @Override
    public R getSkuSeckilInfo(Long skuId) {
        return R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(),BizCodeEnum.TO_MANY_REQUEST.getMessage());
    }
}
