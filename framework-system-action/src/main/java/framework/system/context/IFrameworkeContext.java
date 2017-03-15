package framework.system.context;

import java.util.Hashtable;

import javax.servlet.ServletContext;

/**
 * 获取上下文
 * 
 * @author lizhaotao lzh_me@126.com
 * @date 2017年3月15日 上午11:22:00
 */
public interface IFrameworkeContext {
	public static Hashtable<Object,Object> tab = new Hashtable<Object,Object>();
	/**
	 * 
	 * @Description: 根据Bean的名称获取容器中的Bean
	 * @param beanName
	 * @return
	 */
	public Object getBean(String beanName);

	/**
	 * 
	 * @Description: 获取上下文
	 * @return
	 */
	public ServletContext getServletContext();
}