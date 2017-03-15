package framework.system.context;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * 框架上下文
 * 
 * @author lizhaotao lzh_me@126.com
 * @date 2017年3月15日 上午11:22:17
 */
public class FrameworkeContext implements IFrameworkeContext, Context {
	private static ServletContext servletContext;
	private static FrameworkeContext applicationContext;

	/**
	 * 
	 * @return FrameContext .
	 */
	public static FrameworkeContext getInstance() {
		if (applicationContext == null) {
			applicationContext = new FrameworkeContext();
		}
		return applicationContext;
	}

	/**
	 * 刷新内存区域
	 */
	public void refresh() {
		tab.clear();
	}

	/**
	 * 从框架中移除对象
	 * 
	 * @param key
	 *            .
	 */
	public void remove(Object key) {
		tab.remove(key);
	}

	/**
	 * 从框架获取对象
	 * 
	 * @param key
	 *            Object .
	 * @return Object .
	 */
	public Object getValue(Object key) {
		return tab.get(key);
	}

	/**
	 * 将对象重新注册到框架中
	 * 
	 * @param key
	 *            Object
	 * @param value
	 *            Object
	 * @return boolean
	 */
	public boolean repreg(Object key, Object value) {
		tab.put(key, value);
		return true;
	}

	/**
	 * 将对象注册到框架中
	 * 
	 * @param key
	 *            Object
	 * @param value
	 *            Object
	 * @return boolean
	 */
	public boolean reg(Object key, Object value) {
		if (tab.containsKey(key)) {
			return false;
		}
		if (value != null) {
			tab.put(key, value);
		}
		return true;
	}

	/**
	 * 判断对象是否存在
	 * 
	 * @param key
	 *            Object
	 * @return boolean
	 */
	public boolean contains(Object key) {
		return tab.containsKey(key);
	}

	/**
	 * 打印系统堆栈信息
	 * 
	 * @return String
	 */
	public String dumpContext() {
		StringBuffer buffer = new StringBuffer();
		Object dmz = null;
		Object key = null;
		Object object = null;
		Map map = null;
		Set set = null;
		for (Enumeration e = tab.keys(); e.hasMoreElements();) {
			key = e.nextElement();
			buffer.append(key);
			buffer.append("\n");
			map = (Map) tab.get(key);
			set = map.keySet();
			for (Iterator i = set.iterator(); i.hasNext();) {
				dmz = i.next();
				object = map.get(dmz);
				buffer.append(dmz);
				buffer.append(object);
				buffer.append("\n");
			}
		}
		return buffer.toString();
	}

	/**
	 * 获取上下文
	 * 
	 * @return ServletContext
	 */
	public ServletContext getServletContext() {
		if (servletContext == null) {
			WebApplicationContext webApplicationContext = ContextLoader
					.getCurrentWebApplicationContext();
			servletContext = webApplicationContext.getServletContext();
		}
		return servletContext;
	}

	/**
	 * 根据Bean的名称获取Spring容器中的Bean
	 * 
	 * @param beanName
	 *            String
	 * @return Object
	 */
	public Object getBean(String beanName) {
		WebApplicationContext webApplicationContext = ContextLoader
				.getCurrentWebApplicationContext();
		return webApplicationContext.getBean(beanName);
	}
}