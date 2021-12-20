package com.jehon.mall.thirdparty.controller;

import com.jehon.common.utils.R;
import com.jehon.mall.thirdparty.component.SmsComponent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

public class SmsSendController {

    @Resource
    private SmsComponent smsComponent;

    /**
     * 提供给别的服务进行调用
     * @param phone
     * @param code
     * @return
     */
    @GetMapping(value = "/sendCode")
    public R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code) {

        //发送验证码
        smsComponent.sendCode(phone,code);

        return R.ok();
    }
}
