package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000116681697";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCNnstf2d+8uZa4NVNBLIWXBQUat/5mikRONvkRyV/uzTpIf0AO2WgFLAdX5kX5k7lQdAfXY76cNjj1yXRkG/m06Pp5nOtDrR+lxYpk8puQH+JAsqfQczKyxhz/sqaado14uZmVIa8DIvxvd89HtPe0KeL6Vd3JspaMiqAc6gmao7b+kVbAwH5pX6DbLx0x9HZRh0uXoG2CdZ5m3n9UBq/fdxyFONA+a0xR3IyEgTvm7nOXy0KLsuczhiGXsytKLoz6KJSm0Y9MXgySdIzGjFF7y/XE1RLYRModLoIgTMlIXS4EzX2jONKU3f1Yg4/d04gifQRq0gROeElQNr4Lg/GfAgMBAAECggEAUJ2F84gYflu+2hkwzTbEzNTEtRLrs/8dJtDQMznIbC1S8hXNpyZGujr36ydfydQ3dv61v/w9crrC7dbBdIMgP8UnX7bdjWatTzYFs7UOrJoZtu577ILG51EzDLLrd53opkIwlN3ZvBVcUS+IRK9VGa+GTy411Cze2h3HSu5GjUmnze9ZmxfRSrt1yq4+bd4FC19W/gMgUXGo+jCK2Hub3VazreYV0bAODRjfpUFjgMTrNbneuz2GFUnhq+WIGPY8AQc9V4yw9BRqr2IirmVrDQHV9uWwQ2pZFkzlzEox66caeIPb8KTJDcSF5/y8AJqxzaEo6beT5yRAmC+2liy20QKBgQD4fx97W39EGZMa/e+lGnivTKgWO5qzyLWlGxJAaaYzHYSH/XMdVyaqvcVHE5kUtepPdwb3qMR3JYQCRRzdaNEf8m4FXx4tjIdiz5KXv6b2s7Y4GMHQ13utrMVF3N7FsoBHZOqbFIBGrYnLrwkWnCaO6YyVKz/CxQRyQ9xY0qCvMwKBgQCR5YS3p4GQl8OgPc/leVI6RDUCrhDMe5s0FBSQ3sbXTeQGgb+3izTEg0IuoVxBePTMJo0QCuicCR9nS2aqxubzaQMTl0mzdXF35vHO7K6HmjLJ5UDQjNaVvnmmJvcsbhiya3iErfrdU4jQuTrD72hAw+Cz57fukYHzUT9FU9/j5QKBgDNPLFTwQ4rwLOu52y2gFaM8lMhibkMJAlihCle6eNK9GYxqzMYWJKnEnWNbrJQWK9dUoF+qvUZMvMErPBaLegK6r/Tz+us0xQ+mBILI09TErq9OjVZt59+oeONAA8+WV95l+/shdIsjcfxYm+vLOjrwBlMWpwe0XoKpeGnus7b5AoGAe5KQX9HD3wl8S3wvW2jv6aQd1kBCwD+tjGW5qZ7XgkNZ8Nzy2m5Q6mVWqBJKBraBeWzpq/3hWVAsxhvKQLmpod9/GJfad+LwkaMNirtTdE152SGRTVMM6dZkSQPV9U7nIi/+6zpFMjNvvYI2MQDVJ44BA8AvPSUHkWRul7Tb/LUCgYBTuJLXadLshB4u4vcLJsv7b5x4NPLlARC+MHChBBAGzqzYAvhHofrxBhc6mRch+UKZUpVsgx/BN09MP4fEzu7UI02fwOfxHnGMToX0nszpYp0VqHeN7DpQVP+Z2U2bwraULkMUdCxMUgMjUSN9XQyKpa5IZBDHjdYsNhpD4XtTRg==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjZ7LX9nfvLmWuDVTQSyFlwUFGrf+ZopETjb5Eclf7s06SH9ADtloBSwHV+ZF+ZO5UHQH12O+nDY49cl0ZBv5tOj6eZzrQ60fpcWKZPKbkB/iQLKn0HMyssYc/7KmmnaNeLmZlSGvAyL8b3fPR7T3tCni+lXdybKWjIqgHOoJmqO2/pFWwMB+aV+g2y8dMfR2UYdLl6BtgnWeZt5/VAav33cchTjQPmtMUdyMhIE75u5zl8tCi7LnM4Yhl7MrSi6M+iiUptGPTF4MknSMxoxRe8v1xNUS2ETKHS6CIEzJSF0uBM19ozjSlN39WIOP3dOIIn0EatIETnhJUDa+C4PxnwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "../../notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "../../return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
