package com.jehon.mall.product.controller;

import java.util.Arrays;
import java.util.Map;

import com.jehon.common.valid.AddGroup;
import com.jehon.common.valid.UpdateGroup;
import com.jehon.common.valid.UpdateStatusGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jehon.mall.product.entity.BrandEntity;
import com.jehon.mall.product.service.BrandService;
import com.jehon.common.utils.PageUtils;
import com.jehon.common.utils.R;

/**
 * 品牌
 *
 * @author jehon
 * @email 771970504@qq.com
 * @date 2021-10-26 17:17:13
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    public R info(@PathVariable("brandId") Long brandId){
        BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@Validated({AddGroup.class}) @RequestBody BrandEntity brand
                  //, BindingResult result
    ){

        // Map<String,String> map = new HashMap<>();
        //
        // if (result.hasErrors()) {
        //     //获取效验错误结果
        //     result.getFieldErrors().forEach((item)-> {
        //         //获取到错误提示
        //         String message = item.getDefaultMessage();
        //         //获取错误的属性的名字
        //         String field = item.getField();
        //         map.put(field,message);
        //     });
        //     return R.error(400,"提交的数据不合法").put("data",map);
        // } else {
        //
        // }
        brandService.save(brand);


        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@Validated({UpdateGroup.class}) @RequestBody BrandEntity brand){
        brandService.updateDetail(brand);

        return R.ok();
    }

    /**
     * 修改状态
     */
    @RequestMapping("/update/status")
    public R updateStatus(@Validated(UpdateStatusGroup.class) @RequestBody BrandEntity brand){
        brandService.updateById(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] brandIds){
        brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }
}
