/**
 * Copyright (C), 2015, 灞变笢鏃棩淇炲拰绉戞妧鏈夐檺鍏徃
 * All right reserved.
 */
package com.suncity.pub.constants;

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
	static final String APP_ID = "";
	//开发者私钥，由开发者自己生成
	static final String APP_PRIVATE_KEY = ""; 
	//参数返回格式，只支持json
	static final String FORMAT = "json"; 
	//编码集，支持GBK/UTF-8
	static final String CHARSET = "UTF-8";
	//支付宝公钥，由支付宝生成
	static final String ALIPAY_PUBLIC_KEY = "";
	//商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
	static final String SIGN_TYPE = "RSA2";
	//支付宝网关（固定）
	static final String RETURN_URL = "http://www.sdyysn.com/CallBack/return_url.jsp";
	//支付宝网关（固定）
	static final String NOTIFY_URL = "http://www.sdyysn.com/CallBack/notify_url.jsp";
}
