/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.config;

import com.yuanyuansinian.model.config.Config;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:49:54 
 * @version V1.0   
 */
public interface IConfigService {
	
	/**
	 * 
	 * @Description: 查询网站设置 
	 * @return
	 */
	Config queryConfig();
	
	
	/**
	 * 
	 * @Description: 添加更新（有数据更新，无数据添加） 
	 * @param config
	 * @return
	 */
	int updateConfig(Config config);


}
