package framework.system.context;

/**
 * Context顶级接口，供各内存管理类使用
 * 
 * @author lizhaotao lzh_me@126.com
 * @date 2017年3月15日 上午11:20:04
 */
public interface Context {
	/**
	 * 
	 * @Description: 注册
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean reg(Object key, Object value);

	/**
	 * 
	 * @Description: 重新注册
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean repreg(Object key, Object value);

	/**
	 * 
	 * @Description: 根据key获取value
	 * @param key
	 * @return
	 */
	public Object getValue(Object key);

	/**
	 * 
	 * @Description: 刷新内存
	 */
	public void refresh();

	/**
	 * 
	 * @Description: 判断对象是否存在
	 * @param key
	 * @return
	 */
	public boolean contains(Object key);
}
