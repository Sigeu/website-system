/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.pub.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import ujn.school.cn.model.content.Content;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年3月27日 下午3:21:08
 * @version V1.0
 */
public class MyAutoGenerateOrderNum {
	/**
	 * 锁对象，可以为任意对象
	 */
	private static Object lockObj = "lockerOrder";
	/**
	 * 订单号生成计数器
	 */
	private static long orderNumCount = 0L;
	/**
	 * 每毫秒生成订单号数量最大值
	 */
	private static int maxPerMSECSize = 1000;

	/**
	 * 生成非重复订单号，理论上限1毫秒1000个，可扩展
	 * 
	 * @param tname
	 *            测试用
	 */
	public static String generateOrderNum(String tname) {
		// 最终生成的订单号
		String finOrderNum = "";
		try {
			synchronized (lockObj) {
				// 取系统当前时间作为订单号变量前半部分，精确到毫秒
				long nowLong = Long.parseLong(new SimpleDateFormat(
						"yyyyMMddHHmmssSSS").format(new Date()));
				// 计数器到最大值归零，可扩展更大，目前1毫秒处理峰值1000个，1秒100万
				if (orderNumCount > maxPerMSECSize) {
					orderNumCount = 0L;
				}
				// 组装订单号
				String countStr = maxPerMSECSize + orderNumCount + "";
				finOrderNum = nowLong + countStr.substring(1);
				orderNumCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return finOrderNum;
	}
	
	/**
	 * 
	 * @Description: 济大信息公开，自动生成文章编号 
	 * 		 编码规则：1、信息公开类别（1位），1为校务公开，2为党务公开,3为其余栏目；
	 * 				2、单位代码（2位），为学校机构的编码，不足位前补0；
	 * 				3、目录分类编码（2位），分为16类（对应的是二级导航），为01-11和99，99代表其它公开事项；
	 * 				4、年份代码（4位），为信息生成年份；
	 * 				5、信息流水号（5位），为某部门某年产生的信息流水号，标识文章的序号，这里使用5位数ID，不足前补0；
	 * 				6、公开方式码（1位），1为主动公开，2为依申请公开
	 * 		编码举例：1-01-2010-00007-1，表示校务公开（1），校长办公室（01），2010年主动公开（1）的00007号信息。
	 * @param content
	 * @param id
	 * @return
	 */
	public static String generateArticleOrder(Content content ,String id) {
		String articleOrder = "";
		//1、信息公开类别
		articleOrder = content.getOpen_code() + "-";
		//2、单位代码
		articleOrder = articleOrder + content.getDept_code() + "-";
		//3、目录分类编码
		articleOrder = articleOrder + content.getClass_code() + "-";
		//4、年份代码
		articleOrder = articleOrder + MyDateUtil.getYear() + "-";
		//5、生成流水号
		int idLength = id.length();
		String orderNum = "";
		if(idLength < 5){
			if(1 == idLength){
				orderNum = "0000" + id;
			}
			if(2 == idLength){
				orderNum = "000" + id;
			}
			if(3 == idLength){
				orderNum = "00" + id;
			}
			if(4 == idLength){
				orderNum = "0" + id;
			}
			if(5 == idLength){
				orderNum = id;
			}
		}
		
		articleOrder = articleOrder + orderNum + "-";
		//6、公开方式码
		articleOrder = articleOrder + content.getOpen_type_code();
		
		return articleOrder;
	}
	
	public static void main(String[] args) {
		// 测试多线程调用订单号生成工具
		try {
			for (int i = 0; i < 200; i++) {
				Thread t1 = new Thread(new Runnable() {
					public void run() {
						MyAutoGenerateOrderNum makeOrder = new MyAutoGenerateOrderNum();
						makeOrder.generateOrderNum("a");
					}
				}, "at" + i);
				t1.start();

				Thread t2 = new Thread(new Runnable() {
					public void run() {
						MyAutoGenerateOrderNum makeOrder = new MyAutoGenerateOrderNum();
						makeOrder.generateOrderNum("b");
					}
				}, "bt" + i);
				t2.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
