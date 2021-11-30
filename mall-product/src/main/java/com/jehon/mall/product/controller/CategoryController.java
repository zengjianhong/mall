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
     * 查询出所有分类以及子分类，以树形结构组装起来列表
     */
    @RequestMapping("/list/tree")
    public R list(){
        List<CategoryEntity> entities = categoryService.listWithTree();

        return R.ok().put("data", entities);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    public R info(@PathVariable("catId") Long catId){
        CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("data", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CategoryEntity category){
        categoryService.save(category);

        return R.ok();
    }

    @RequestMapping("/update/sort")
    public R updateSort(@RequestBody CategoryEntity[] category){
        categoryService.updateBatchById(Arrays.asList(category));
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CategoryEntity category){
        categoryService.updateCascade(category);

        return R.ok();
    }

    /**
     * 删除
     * @RequestBody:获取请求体，必须发送POST请求
     * SpringMVC自动将请求体的数据(json)转换为对象
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] catIds){

        //1、检查当前删除的菜单，是否被别的地方引用
        //categoryService.removeByIds(Arrays.asList(catIds));

        categoryService.removeMenuByIds(Arrays.asList(catIds));

        return R.ok();
    }
}
