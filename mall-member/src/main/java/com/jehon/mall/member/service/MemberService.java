package com.jehon.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jehon.common.utils.PageUtils;
import com.jehon.mall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author jehon
 * @email 771970504@qq.com
 * @date 2021-10-26 23:13:55
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

