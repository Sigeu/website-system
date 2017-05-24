package com.yuanyuansinian.alipay.config;

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
	public static String app_id = "2017051607256846";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCVAAUxeJfmcptLm+ByXRP2oP9+CAhyQUVBP641FlX2S67w4c+VIKyN/l+Y9083Yw75OeM9M+2yrvN5vko4zItvxL43H0i4cE/H2Chn1I9VaLiUIxpWWEsT8y7sca6UQSHCOcPvoOpb23keyDXUGzAA469kG/57khNTlbPiO+1Y7lI/3W2p+7K+NKrZjP+NkUxy7L5LDNVZkXvnHafuF+l6K8x3rjm7b2ZdQ+POseJuYReJAOBFyMPf1TZdJ2v8wf8K7NiWNQjMWdX3iIn+ebxDZM+QK4kEfXbYXXeAr21nyPg3+5/xLW+JC+MqYaOfOWR718wlj4RGOYghA1U8m5D7AgMBAAECggEACDEHGBAsMbQtS3vXXBI37cAuK6yfYkCqYQryNeLzeOXySTXw5p70PZ41fUBjb4UXpqYDEzNOpxstMY0/oV3FcLCdUIR8x/8Ms8zzc7ng424tb596bDLQddlRxBf/5BCsnXP1jLAJEmG/h+yz4ORZwELEOrm7ROnj/B1n1VE8HD5wcSy+bi09WtmQoSmJ0wcpouePSCFKL9yDnIK6vR3H8w/lPWOTtXA9kaiQY2p62y8Dq7rsp1ufF49e9v9m9fifKdyNG9ShbmcNbKhu/BTo+RiZzhXb6y+lBtt8w9hcOZmKIpdVnhn4EcOOEKMO1CwKlHo3ErfN2altAHMkO/H32QKBgQDNADDntAxi9glN5IQNr077DI7gvKt8mj5eBpNU+ZShGzDHxgVd2sMB2MovYKe8pH/0LBredmw+fL2HsiScGOcwEM22b58sD9Uhc7W4CPHiaa4pFr3u44+W+5G1MdDT9NufrarO85hP77H4nOIATR2jwxta+LMzPY/s+18HsKHuJwKBgQC6EVW51Y7/oQaGL8huPWYChwlfGxftcsCAx5OvZ5R4+05FC/rGWQn3rFN5vg2uTZ5uRQ3E09FwxOXonsOULhAETXxbCUJtwD/wbqj++CrE48MXZemojIhlsEfp3EEAVb3Uus+O4Z4QV4NH1IqwYMEbs8brLRUeIKiQbVKvzi5fDQKBgQDBNhThzMh/3PQX/fCYFUqTQtrG5guafKWbaQcjZ7e1wDLRlskoFC8HZpPo42g0W7ZdI9SPJ34NxvO7GSN4G+CJZMz9zWZv2Nw/kxcKRSP1CTWkdFK+/Ksw2hoSdMkle/ojHUOHmf9MF9XdQ7+eGRB+cD0wGIaNHNCxwplmXgvAsQKBgD1EsAG9PJUYJNnSqiECvrBeXsueVEav3ouJLCw54z3jImbCBxWBBDM131bbKg4XKPAOdPY2+WQ0sa/jd2s3r7Z6/VPMvL7+6w70oVkzxoGGrhrqSAJkJBW38jYjfJPrp9KAoQ/fYvjmmCfy6Kgjc/L3Q6z071s4Tckg9nVFYyeRAoGAZDU+exYIHGWj4NwMHYKfPxWfwnBAVU+hbdukyvzapLHgsmvwaDWrrm4XioYyqDgZTUx9+UhMPaMBIS25uXpPlqVUwDNNa+S3u8PF4kc7VNLIhnUqCEDVCNASD5YZ5500Jqi2mSL3/ggWWGgKUvX69Wnwpi7zbmrBNloJGqlythg=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlMsT89ASJGyVUFcLp1Xk/FSiS3570NnrvzeKJFikv5FhB/qhVcVSJ/pcBYz1zeLfWZEW5D2AduIDLx7byjfW/37vdszgSk68agnbXt/FHMCiL28r8WZ4ENo7eHExnZZw3B6xOHTs48gf8WUPBLl4x9J/hconVgodXtSMAwR6rudVV0JOW/vwl8nmqhmfBID97qCnt2Snfn96d8p/ebNblsb9y7OM9qcfzMeaN5Oin2fBIPUnjzpf229AGGttWC8ME3UavHZjGLN6UJcmsBaA8ZNSNUux0Uw6InBQUKKi98lWcrsFb5C2b0BZbuZ5x8IIdOEX1/yYijTP3KbcefUZzQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//public static String notify_url = "http://www.sdyysn.com/notify_url.jsp";
	public static String notify_url = "http://www.sdyysn.com/sinian/order/orderController/notifyUrl";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://www.sdyysn.com/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "D:\\alipay";


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

