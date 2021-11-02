package com.jehon.mall.coupon.service.impl;

import com.jehon.common.to.MemberPrice;
import com.jehon.common.to.SkuReductionTo;
import com.jehon.mall.coupon.entity.MemberPriceEntity;
import com.jehon.mall.coupon.entity.SkuLadderEntity;
import com.jehon.mall.coupon.service.MemberPriceService;
import com.jehon.mall.coupon.service.SkuLadderService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jehon.common.utils.PageUtils;
import com.jehon.common.utils.Query;

import com.jehon.mall.coupon.dao.SkuFullReductionDao;
import com.jehon.mall.coupon.entity.SkuFullReductionEntity;
import com.jehon.mall.coupon.service.SkuFullReductionService;


@Service("skuFullReductionService")
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionDao, SkuFullReductionEntity> implements SkuFullReductionService {

    @Autowired
    private SkuLadderService skuLadderService;

    @Autowired
    private MemberPriceService memberPriceService;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        QueryWrapper<SkuFullReductionEntity> queryWrapper = new QueryWrapper<>();

        String key = (String) params.get("key");

        if (!StringUtils.isEmpty(key)) {
            queryWrapper.eq("id",key).or().eq("sku_id",key);
        }

        IPage<SkuFullReductionEntity> page = this.page(
                new Query<SkuFullReductionEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public void saveSkuReduction(SkuReductionTo skuReductionTo) {

        //1、保存满减打折、会员价
        //1、1）、sku的优惠、满减等信息：gulimall_sms--->sms_sku_ladder、sms_sku_full_reduction、sms_member_price
        SkuLadderEntity skuLadderEntity = new SkuLadderEntity();
        BeanUtils.copyProperties(skuReductionTo,skuLadderEntity);
        skuLadderEntity.setAddOther(skuReductionTo.getCountStatus());

        if (skuReductionTo.getFullCount() > 0) {
            skuLadderService.save(skuLadderEntity);
        }

        //2、sms_sku_full_reduction
        SkuFullReductionEntity skuFullReductionEntity = new SkuFullReductionEntity();
        BeanUtils.copyProperties(skuReductionTo,skuFullReductionEntity);
        if (skuFullReductionEntity.getFullPrice().compareTo(BigDecimal.ZERO) == 1) {
            this.save(skuFullReductionEntity);
        }

        //3、sms_member_price
        List<MemberPrice> memberPrice = skuReductionTo.getMemberPrice();

        List<MemberPriceEntity> collect = memberPrice.stream().map(mem -> {
            MemberPriceEntity memberPriceEntity = new MemberPriceEntity();
            memberPriceEntity.setSkuId(skuReductionTo.getSkuId());
            memberPriceEntity.setMemberLevelId(mem.getId());
            memberPriceEntity.setMemberLevelName(mem.getName());
            memberPriceEntity.setMemberPrice(mem.getPrice());
            memberPriceEntity.setAddOther(1);
            return memberPriceEntity;
        }).filter(item -> {
            return item.getMemberPrice().compareTo(BigDecimal.ZERO) == 1;
        }).collect(Collectors.toList());

        memberPriceService.saveBatch(collect);
    }
}