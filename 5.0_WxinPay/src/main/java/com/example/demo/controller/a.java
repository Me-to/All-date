//package com.example.demo.controller;
//
//import com.example.demo.sdk.MyConfig;
//import com.example.demo.sdk.WXPayConfig;
//
//import java.util.HashMap;
//
///**
// * 获取沙盒 sandbox_signkey
// *
// * @author yclimb
// * @date 2018/9/18
// */
// public  class a{
//
//
//private void doget() throws Exception {
//    WXPayConfig config = WXPayConfig.getInstance();
//        HashMap<String, String> data = new HashMap<String, String>();
//        // 商户号
//        data.put("mch_id", config.getMchID());
//        // 获取随机字符串
//        data.put("nonce_str", WXPayUtil.generateNonceStr());
//        // 生成签名
//        String sign = WXPayUtil.generateSignature(data, config.getKey());
//        data.put("sign", sign);
//
//        // 得到 sandbox_signkey
//        WXPay wxPay = new WXPay(config);
//        String result = wxPay.requestWithoutCert("/sandboxnew/pay/getsignkey", data, 10000, 10000);
//        System.out.println(result);
//        }
//}