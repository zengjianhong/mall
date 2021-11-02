package com.jehon.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jehon.common.utils.PageUtils;
import com.jehon.mall.product.entity.CategoryEntity;
import com.jehon.mall.product.vo.Catelog2Vo;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author jehon
 * @email 771970504@qq.com
 * @date 2021-10-26 16:39:35
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    void removeMenuByIds(List<Long> asList);

    /**
     * 找到catelogId的完整路径
     * [父/子/孙]
     * @param catelogId
     * @return
     */
    Long[] findCatelogPath(Long catelogId);

    public void updateCascade(CategoryEntity category);

    List<CategoryEntity> getLevel1Categorys();

    Map<String, List<Catelog2Vo>> getCatalogJson();
}

