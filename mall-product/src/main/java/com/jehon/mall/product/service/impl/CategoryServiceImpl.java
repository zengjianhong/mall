package com.jehon.mall.product.service.impl;

import com.jehon.common.exception.RRException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jehon.common.utils.PageUtils;
import com.jehon.common.utils.Query;

import com.jehon.mall.product.dao.CategoryDao;
import com.jehon.mall.product.entity.CategoryEntity;
import com.jehon.mall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 树型显示
     *
     * @return
     */
    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);

        List<CategoryEntity> treeMenus = categoryEntities.stream().filter((categoryEntity) -> {
            return categoryEntity.getParentCid() == 0;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).map((menu) -> {
            menu.setChildren(getChildren(menu, categoryEntities));
            return menu;
        }).collect(Collectors.toList());

        return treeMenus;
    }


    private List<CategoryEntity> getChildren(CategoryEntity rootMenu, List<CategoryEntity> allMenus) {

        List<CategoryEntity> childrenList = allMenus.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid().equals(rootMenu.getCatId());
        }).map(menu -> {
            menu.setChildren(getChildren(menu, allMenus));
            return menu;
        }).sorted((m1, m2) -> {
            return (m1.getSort() == null ? 0 : m1.getSort()) - (m2.getSort() == null ? 0 : m2.getSort());
        }).collect(Collectors.toList());
        return childrenList;
    }

    @Override
    public void removeMenus(List<Long> asList) {
        System.out.println("删除的数据为： ++ ++++" + asList);
        // 逻辑删除
        int result = baseMapper.deleteBatchIds(asList);
        if (result < 0) {
            throw new RRException("删除失败");
        }
    }

    /**
     * 寻找一个category的全路径  example [2.3,6]
     *
     * @param catelogId
     * @return
     */
    @Override
    public Long[] findCategoryPath(Long catelogId) {
        List<Long> path = new ArrayList<>();
        List<Long> parentPath = findParentPath(catelogId, path);
        Collections.reverse(parentPath);
        return parentPath.toArray(new Long[parentPath.size()]);
    }

    private List<Long> findParentPath(Long catelogId, List<Long> path) {
        path.add(catelogId);
        CategoryEntity categoryEntity = baseMapper.selectById(catelogId);
        if (categoryEntity.getParentCid() != 0) {
            findParentPath(categoryEntity.getParentCid(), path);
        }
        return path;
    }

}