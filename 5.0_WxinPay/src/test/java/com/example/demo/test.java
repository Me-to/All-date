package com.example.demo;

import com.example.demo.sdk.MyConfig;
import com.example.demo.sdk.WXPay;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class test {

    @Test
    public void pay() throws Exception {

        MyConfig config = new MyConfig();
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<String, String>();
        data.put("body", "腾讯充值中心-QQ会员充值");
        data.put("out_trade_no", "2016090910595901090013");
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", "101");
        data.put("spbill_create_ip", "123.12.12.123");
        data.put("notify_url", "http://www.example.com/wxpay/notify");
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        data.put("product_id", "12");

        try {
            wxpay.checkWXPayConfig();
            Map<String, String> resp = wxpay.unifiedOrder(data);
            System.out.println("订单下单显示" + resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 订单查询
     *
     * @throws Exception
     */
    @Test
    public void dingdancha() throws Exception {
        MyConfig config = new MyConfig();
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", "2016090910595901090013");

        try {
            Map<String, String> resp = wxpay.orderQuery(data);
            System.out.println("订单查询显示" + resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 退款查询
     *
     * @throws Exception
     */
    @Test
    public void tui() throws Exception {
        MyConfig config = new MyConfig();
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", "2016090910595901090013");

        try {
            Map<String, String> resp = wxpay.refundQuery(data);
            System.out.println("退款查询显示" + resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载对账单
     * @throws Exception
     */
    @Test
    public void downbil() throws Exception {
        MyConfig config = new MyConfig();
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<String, String>();
        data.put("bill_date", "20140603");
        data.put("bill_type", "ALL");

        try {
            Map<String, String> resp = wxpay.downloadBill(data);
            System.out.println("下载对账单"+resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}



