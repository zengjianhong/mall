package com.jehon.mall.ware.feign;

import com.jehon.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jehon
 *
 * @email 771970504@qq.com
 * @date 2021-10-26 23:20:04
 */
@FeignClient("mall-order")
public interface OrderFeignService {

    @GetMapping(value = "/order/order/status/{orderSn}")
    R getOrderStatus(@PathVariable("orderSn") String orderSn);
}
