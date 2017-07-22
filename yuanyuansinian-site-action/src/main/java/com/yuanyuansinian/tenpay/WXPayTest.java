/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.tenpay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年7月21日 下午8:43:31 
 * @version V1.0   
 */
public class WXPayTest {

    public static void main(String[] args) throws Exception {

        // HostnameVerifier hnv = new HostnameVerifier() {
        //     public boolean verify(String hostname, SSLSession session) {
        //         // Always return true，接受任意域名服务器
        //         return true;
        //     }
        // };
        // HttpsURLConnection.setDefaultHostnameVerifier(hnv);

        String UTF8 = "UTF-8";
        String reqBody = "<xml>"
        		+ "<body>测试商家-商品类目</body>"
        		+ "<trade_type>NATIVE</trade_type>"
        		+ "<mch_id>1484404262</mch_id>"
        		+ "<sign_type>HMAC-SHA256</sign_type>"
        		+ "<nonce_str>2460ab8faa756e9b6b229b027cc611c7</nonce_str>"
        		+ "<detail />"
        		+ "<fee_type>CNY</fee_type>"
        		+ "<device_info>WEB</device_info>"
        		+ "<out_trade_no>20171909105959000000111108</out_trade_no>"
        		+ "<total_fee>1</total_fee>"
        		+ "<appid>wxde774f3f1ba672b2</appid>"
        		+ "<notify_url>http://www.sdyysn.com/wxpay/notify</notify_url>"
        		+ "<sign>2460ab8faa756e9b6b229b027cc611c7</sign>"
        		+ "<spbill_create_ip>127.0.0.1</spbill_create_ip>"
        		+ "</xml>";
        URL httpUrl = new URL("https://api.mch.weixin.qq.com/pay/unifiedorder");
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
        httpURLConnection.setRequestProperty("Host", "api.mch.weixin.qq.com");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setConnectTimeout(10*1000);
        httpURLConnection.setReadTimeout(10*1000);
        httpURLConnection.connect();
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(reqBody.getBytes(UTF8));

        //获取内容
        InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, UTF8));
        final StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
        }
        String resp = stringBuffer.toString();
        if (stringBuffer!=null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (inputStream!=null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (outputStream!=null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(resp);

    }

}

