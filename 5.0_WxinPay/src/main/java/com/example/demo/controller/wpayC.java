package com.example.demo.controller;

import com.example.demo.sdk.MyConfig;
import com.example.demo.sdk.WXPay;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class wpayC {

    MyConfig myConfig;
    WXPay wxPay;

    {
        try {
            myConfig = new MyConfig();
            wxPay = new WXPay(myConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @RequestMapping("pay")
    public void pay() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("body", "腾讯充值中心-QQ会员充值");
        data.put("out_trade_no", "2016090910595900000012");
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "123.12.12.123");
        data.put("notify_url", "http://www.example.com/wxpay/notify");
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        data.put("product_id", "12");

        try {
            wxPay.checkWXPayConfig();
            Map<String, String> resp = wxPay.unifiedOrder(data);
            System.out.println(resp);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
