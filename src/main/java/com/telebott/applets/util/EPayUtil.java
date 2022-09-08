package com.telebott.applets.util;

import com.alibaba.fastjson.JSONObject;
import com.telebott.applets.data.EPayData;
import com.telebott.applets.entity.EPay;
import com.telebott.applets.entity.Order;

public class EPayUtil {
    public static String submit(EPay ePay, Order order, String type){
        StringBuilder sb = new StringBuilder();
        sb.append("<form name=\"punchout_form\" method=\"post\" action=\"").append(ePay.getUrl()).append("\">");
        EPayData data = new EPayData();
        data.setPid(new Long(ePay.getMchId()));
        data.setType(type);
        data.setOut_trade_no(order.getOutTradeNo());
        data.setMoney(String.valueOf(order.getMoney()));
        data.setNotify_url(ePay.getNotifyUrl());
        data.setReturn_url(ePay.getCallbackUrl());
        data.setSign(data.getSign(ePay.getSecretKey()));
        String sign = data.getSign();
        String sign_type = data.getSign_type();
        JSONObject object = EPayData.getObject(data);
        object.put("sign", sign);
        object.put("sign_type", sign_type);
        return sb.append(getBody(object)).append("<input type=\"submit\" value=\"立即支付\" style=\"display:none\" >\n" +
                "</form>\n" +
                "<script>document.forms[0].submit();</script>").toString();
    }
    public static String getBody(JSONObject object){
        StringBuilder sb = new StringBuilder();
        for (String key: object.keySet()) {
            if (object.get(key) != null){
                sb.append("<input type=\"hidden\" name=\"").append(key).append("\" value=\"").append(object.get(key)).append("\">");
            }
        }
        return sb.toString();
    }
}
