package com.jehon.mall.order.feign;

import com.jehon.mall.order.vo.OrderItemVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("mall-cart")
public interface CartFeignService {

    /**
     * 查询当前用户购物车选中的商品项
     * @return
     */
    @GetMapping(value = "/currentUserCartItems")
    List<OrderItemVo> getCurrentCartItems();
}
