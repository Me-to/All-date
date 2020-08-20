//package com.example.demo.controller;
//
//import com.example.demo.sdk.WXPayUtil;
//import com.github.binarywang.utils.qrcode.MatrixToImageWriter;
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.MultiFormatWriter;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
//import com.sun.deploy.net.HttpUtils;
//
//import java.io.OutputStream;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.SortedMap;
//import java.util.TreeMap;
//
//public class B {
//
//    /**
//     * 统一下单方法
//     * @return
//     */
//    private String unifiedOrder(VideoOrder videoOrder) throws Exception {
//
//        //int i = 1/0;   //模拟异常
//        //生成签名
//        SortedMap<String,String> params = new TreeMap<>();
//        params.put("appid",weChatConfig.getAppId());
//        params.put("mch_id", weChatConfig.getMchId());
//        params.put("nonce_str",CommonUtils.generateUUID());
//        params.put("body",videoOrder.getVideoTitle());
//        params.put("out_trade_no",videoOrder.getOutTradeNo());
//        params.put("total_fee",videoOrder.getTotalFee().toString());
//        params.put("spbill_create_ip",videoOrder.getIp());
//        params.put("notify_url",weChatConfig.getPayCallbackUrl());
//        params.put("trade_type","NATIVE");
//
//        //sign签名
//        String sign = WXPayUtil.createSign(params, weChatConfig.getKey());
//        params.put("sign",sign);
//
//        //map转xml
//        String payXml = WXPayUtil.mapToXml(params);
//
//        System.out.println(payXml);
//        //统一下单
//        String orderStr = HttpUtils.doPost(WeChatConfig.getUnifiedOrderUrl(),payXml,4000);
//        if(null == orderStr) {
//            return null;
//        }
//
//        Map<String, String> unifiedOrderMap =  WXPayUtil.xmlToMap(orderStr);
//        System.out.println(unifiedOrderMap.toString());
//        if(unifiedOrderMap != null) {
//            return unifiedOrderMap.get("code_url");
//        }
//
//        return null;
//    }
//
//
////返回code_url  根据链接生成二维码返回到前台，采用的是google的方法   单独方法 可写在controller层
//	try{
//        //生成二维码配置
//        Map<EncodeHintType,Object> hints =  new HashMap<>();
//
//        //设置纠错等级
//        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
//        //编码类型
//        hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");
//
//        BitMatrix bitMatrix = new MultiFormatWriter().encode(codeUrl, BarcodeFormat.QR_CODE,400,400,hints);
//        OutputStream out =  response.getOutputStream();
//
//        MatrixToImageWriter.writeToStream(bitMatrix,"png",out);
//
//    }catch (Exception e){
//        e.printStackTrace();
//    }
//
//
//}
