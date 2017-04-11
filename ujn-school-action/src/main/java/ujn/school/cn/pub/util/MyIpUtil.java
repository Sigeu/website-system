/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.pub.util;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年4月10日 下午1:15:57
 * @version V1.0
 */
public class MyIpUtil {

	/**
	 * 
	 * @Description: 验证IP是否属于某个IP段
	 * @param ip
	 * @param ipSections 可以是多个IP段
	 * @return
	 */
	public static boolean ipExistsInRange(String ip, String ipSections) {
		
		boolean flag = false;
		for(String ipSection : ipSections.split(",")){
			ipSection = ipSection.trim();
			ip = ip.trim();
			int idx = ipSection.indexOf('-');
			String beginIP = "";
			String endIP = "";
			if(idx > 0){
				beginIP = ipSection.substring(0, idx);
				endIP = ipSection.substring(idx + 1);
				
			}else{
				beginIP = ipSection;
				endIP = ipSection;
			}
			flag = getIp2long(beginIP) <= getIp2long(ip)
					&& getIp2long(ip) <= getIp2long(endIP);
			if(flag){
				break;
			}
		}
		

		return flag;

	}

	public static long getIp2long(String ip) {

		ip = ip.trim();
		String[] ips = ip.split("\\.");
		long ip2long = 0L;
		for (int i = 0; i < 4; ++i) {
			ip2long = ip2long << 8 | Integer.parseInt(ips[i]);
		}

		return ip2long;

	}

	/*public static long getIp2long2(String ip) {

		ip = ip.trim();
		String[] ips = ip.split("\\.");
		long ip1 = Integer.parseInt(ips[0]);
		long ip2 = Integer.parseInt(ips[1]);
		long ip3 = Integer.parseInt(ips[2]);
		long ip4 = Integer.parseInt(ips[3]);
		long ip2long = 1L * ip1 * 256 * 256 * 256 + ip2 * 256 * 256 + ip3 * 256
				+ ip4;

		return ip2long;

	}*/

	public static void main(String[] args) {

		String ip = "10.10.10.116";
		String ipSection = "10.10.10.116";
		boolean exists = ipExistsInRange(ip, ipSection);
		System.out.println(exists);
		System.out.println(getIp2long(ip));
		
	}

}
