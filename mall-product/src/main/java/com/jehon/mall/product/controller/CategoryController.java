package com.jehon.mall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.jehon.common.exception.RRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jehon.mall.product.entity.CategoryEntity;
import com.jehon.mall.product.service.CategoryService;
import com.jehon.common.utils.PageUtils;
import com.jehon.common.utils.R;



/**
 * 商品三级分类
 *
 * @author jehon
 * @email 771970504@qq.com
 * @date 2021-10-26 17:17:13
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 查出所有分类和子分类列表 以树型结构组成
     */
    @GetMapping("/list/tree")
    public R list() {
        List<CategoryEntity> categoryEntities = categoryService.listWithTree();
        return R.ok().put("data", categoryEntities);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    public R info(@PathVariable("catId") Long catId) {
        CategoryEntity category = categoryService.getById(catId);
        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody(required = false) CategoryEntity category) {
        categoryService.save(category);
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody(required = false) CategoryEntity category) {
        categoryService.updateById(category);
        return R.ok();
    }

    /**
     * 批量修改
     */
    @PostMapping("/updateBatch")
    public R update(@RequestBody(required = false) CategoryEntity[] category) {
        boolean result = categoryService.updateBatchById(Arrays.asList(category));
        if (!result) {
            throw new RRException("批量修改失败");
        }
        return R.ok();
    }

    /**
     * 批量删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Long[] catIds) {
        categoryService.removeMenus(Arrays.asList(catIds));
        return R.ok();
    }

}
