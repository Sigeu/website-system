/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.service.config;

import java.util.List;

import ujn.school.cn.model.column.Column;
import ujn.school.cn.model.config.Config;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:49:54 
 * @version V1.0   
 */
public interface IConfigService {
	
	/**
	 * 
	 * @return
	 */
	Config queryConfig();
	
	
	/**
	 * @param config
	 * @return
	 */
	int updateConfig(Config config);


}