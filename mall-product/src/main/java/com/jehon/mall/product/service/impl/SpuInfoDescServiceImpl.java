package com.jehon.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jehon.common.utils.PageUtils;
import com.jehon.common.utils.Query;

import com.jehon.mall.product.dao.SpuInfoDescDao;
import com.jehon.mall.product.entity.SpuInfoDescEntity;
import com.jehon.mall.product.service.SpuInfoDescService;


@Service("spuInfoDescService")
public class SpuInfoDescServiceImpl extends ServiceImpl<SpuInfoDescDao, SpuInfoDescEntity> implements SpuInfoDescService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuInfoDescEntity> page = this.page(
                new Query<SpuInfoDescEntity>().getPage(params),
                new QueryWrapper<SpuInfoDescEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public void saveSpuInfoDesc(SpuInfoDescEntity spuInfoDescEntity) {

        this.baseMapper.insert(spuInfoDescEntity);
    }
}