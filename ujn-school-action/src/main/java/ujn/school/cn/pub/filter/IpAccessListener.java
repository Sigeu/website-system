/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.pub.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年11月25日 下午5:11:02
 * @version V1.0
 */
public class IpAccessListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		// IP存储器
		Map<String, Long[]> ipMap = new HashMap<String, Long[]>();
		context.setAttribute("ipMap", ipMap);
		// 限制IP存储器：存储被限制的IP信息
		Map<String, Long> limitedIpMap = new HashMap<String, Long>();
		context.setAttribute("limitedIpMap", limitedIpMap);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
