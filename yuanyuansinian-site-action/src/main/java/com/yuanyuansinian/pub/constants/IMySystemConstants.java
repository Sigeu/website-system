/**
 * Copyright (C), 2015, 灞变笢鏃棩淇炲拰绉戞妧鏈夐檺鍏徃
 * All right reserved.
 */
package com.yuanyuansinian.pub.constants;

/**
 * 绯荤粺甯搁噺
 * 
 * @author lizhaotao lzh_me@126.com
 * @date 2016骞�2鏈�2鏃�涓嬪崍2:54:24
 */
public interface IMySystemConstants {

	// 璧锋浣嶇疆1
	static final int PAGE_NUM = 1;
	// 鏁版嵁闀垮害15
	static final int PAGE_SIZE = 10;

	static final int PAGE_SIZE15 = 15;

	// 璧锋浣嶇疆1
	static final int PAGE_START = 0;
	// 鏁版嵁闀垮害15
	static final int PAGE_LENGTH = 10;

	//
	static final String VALUE_0 = "0";
	static final String VALUE_1 = "1";
	static final String VALUE_2 = "2";
	static final String VALUE_3 = "3";
	static final String VALUE_4 = "4";
	static final String VALUE_5 = "5";

	// ---鍒楄〃鏁板�-----------------//
	static final int COUNT_NUMF1 = -1;
	static final int COUNT_NUM1 = 1;
	static final int COUNT_NUM2 = 2;
	static final int COUNT_NUM3 = 3;
	static final int COUNT_NUM4 = 4;
	static final int COUNT_NUM5 = 5;
	static final int COUNT_NUM6 = 6;
	static final int COUNT_NUM7 = 7;
	static final int COUNT_NUM8 = 8;
	static final int COUNT_NUM9 = 9;
	static final int COUNT_NUM10 = 10;
	static final int COUNT_NUM11 = 11;
	static final int COUNT_NUM12 = 12;
	static final int COUNT_NUM13 = 13;
	static final int COUNT_NUM14 = 14;
	static final int COUNT_NUM15 = 15;
	// ---鍒楄〃鏁板�-----------------//

	// 鎸夊崌搴忔帓鍒�
	static final String ORDER_ASC = "asc";
	// 鎸夐檷搴忔帓鍒�
	static final String ORDER_DESC = "desc";
	// 鎸夐檷搴忔帓鍒�
	static final String ORDER_COLUMN_ADD_TIME = "add_time";
	static final String ORDER_COLUMN_UPDATE_TIME = "update_time";
	static final String FILE_PATH_IMAGE = "/upload/image/";
	static final String FILE_PATH = "upload/";
	static final String SERVER_FILE_PATH = "/yuanyuansinian-site-webapp/upload/image/";
	//绁枃
	static final String COLUMN130 = "130";
	//绾康棣�
	static final String COLUMN102 = "102";
	//鍜ㄨ---鍔ㄦ�
	static final String COLUMN107 = "107";
	static final String COLUMN123 = "123";
	
	
	static final String VALUE_A = "A";
	static final String VALUE_B = "B";
	static final String VALUE_C = "C";
	static final String VALUE_D = "D";
	static final String VALUE_E = "E";
	
	//澧撳湴鍒嗙被
	static final String CEMETERY_TYPE = "cemetery_type";
	
	//alipay
	//支付宝网关（固定）
	static final String ALIPAY_URL = "https://openapi.alipay.com/gateway.do";
	//APPID 即创建应用后生成
	static final String APP_ID = "2017051607256846";
	//开发者私钥，由开发者自己生成
	static final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCVAAUxeJfmcptLm+ByXRP2oP9+CAhyQUVBP641FlX2S67w4c+VIKyN/l+Y9083Yw75OeM9M+2yrvN5vko4zItvxL43H0i4cE/H2Chn1I9VaLiUIxpWWEsT8y7sca6UQSHCOcPvoOpb23keyDXUGzAA469kG/57khNTlbPiO+1Y7lI/3W2p+7K+NKrZjP+NkUxy7L5LDNVZkXvnHafuF+l6K8x3rjm7b2ZdQ+POseJuYReJAOBFyMPf1TZdJ2v8wf8K7NiWNQjMWdX3iIn+ebxDZM+QK4kEfXbYXXeAr21nyPg3+5/xLW+JC+MqYaOfOWR718wlj4RGOYghA1U8m5D7AgMBAAECggEACDEHGBAsMbQtS3vXXBI37cAuK6yfYkCqYQryNeLzeOXySTXw5p70PZ41fUBjb4UXpqYDEzNOpxstMY0/oV3FcLCdUIR8x/8Ms8zzc7ng424tb596bDLQddlRxBf/5BCsnXP1jLAJEmG/h+yz4ORZwELEOrm7ROnj/B1n1VE8HD5wcSy+bi09WtmQoSmJ0wcpouePSCFKL9yDnIK6vR3H8w/lPWOTtXA9kaiQY2p62y8Dq7rsp1ufF49e9v9m9fifKdyNG9ShbmcNbKhu/BTo+RiZzhXb6y+lBtt8w9hcOZmKIpdVnhn4EcOOEKMO1CwKlHo3ErfN2altAHMkO/H32QKBgQDNADDntAxi9glN5IQNr077DI7gvKt8mj5eBpNU+ZShGzDHxgVd2sMB2MovYKe8pH/0LBredmw+fL2HsiScGOcwEM22b58sD9Uhc7W4CPHiaa4pFr3u44+W+5G1MdDT9NufrarO85hP77H4nOIATR2jwxta+LMzPY/s+18HsKHuJwKBgQC6EVW51Y7/oQaGL8huPWYChwlfGxftcsCAx5OvZ5R4+05FC/rGWQn3rFN5vg2uTZ5uRQ3E09FwxOXonsOULhAETXxbCUJtwD/wbqj++CrE48MXZemojIhlsEfp3EEAVb3Uus+O4Z4QV4NH1IqwYMEbs8brLRUeIKiQbVKvzi5fDQKBgQDBNhThzMh/3PQX/fCYFUqTQtrG5guafKWbaQcjZ7e1wDLRlskoFC8HZpPo42g0W7ZdI9SPJ34NxvO7GSN4G+CJZMz9zWZv2Nw/kxcKRSP1CTWkdFK+/Ksw2hoSdMkle/ojHUOHmf9MF9XdQ7+eGRB+cD0wGIaNHNCxwplmXgvAsQKBgD1EsAG9PJUYJNnSqiECvrBeXsueVEav3ouJLCw54z3jImbCBxWBBDM131bbKg4XKPAOdPY2+WQ0sa/jd2s3r7Z6/VPMvL7+6w70oVkzxoGGrhrqSAJkJBW38jYjfJPrp9KAoQ/fYvjmmCfy6Kgjc/L3Q6z071s4Tckg9nVFYyeRAoGAZDU+exYIHGWj4NwMHYKfPxWfwnBAVU+hbdukyvzapLHgsmvwaDWrrm4XioYyqDgZTUx9+UhMPaMBIS25uXpPlqVUwDNNa+S3u8PF4kc7VNLIhnUqCEDVCNASD5YZ5500Jqi2mSL3/ggWWGgKUvX69Wnwpi7zbmrBNloJGqlythg="; 
	//参数返回格式，只支持json
	static final String FORMAT = "json"; 
	//编码集，支持GBK/UTF-8
	static final String CHARSET = "UTF-8";
	//支付宝公钥，由支付宝生成
	static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlMsT89ASJGyVUFcLp1Xk/FSiS3570NnrvzeKJFikv5FhB/qhVcVSJ/pcBYz1zeLfWZEW5D2AduIDLx7byjfW/37vdszgSk68agnbXt/FHMCiL28r8WZ4ENo7eHExnZZw3B6xOHTs48gf8WUPBLl4x9J/hconVgodXtSMAwR6rudVV0JOW/vwl8nmqhmfBID97qCnt2Snfn96d8p/ebNblsb9y7OM9qcfzMeaN5Oin2fBIPUnjzpf229AGGttWC8ME3UavHZjGLN6UJcmsBaA8ZNSNUux0Uw6InBQUKKi98lWcrsFb5C2b0BZbuZ5x8IIdOEX1/yYijTP3KbcefUZzQIDAQAB";
	//商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
	static final String SIGN_TYPE = "RSA2";
	//支付宝网关（固定）
	static final String RETURN_URL = "http://www.sdyysn.com/CallBack/return_url.jsp";
	//支付宝网关（固定）
	static final String NOTIFY_URL = "http://www.sdyysn.com/CallBack/notify_url.jsp";
}
