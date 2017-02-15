/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.service.config.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ujn.school.cn.dao.config.ConfigMapper;
import ujn.school.cn.model.config.Config;
import ujn.school.cn.service.config.IConfigService;

/**
 * @Description: 网站设置
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:50:13
 * @version V1.0
 */
@Service("configService")
public class ConfigService implements IConfigService {
	@Resource
	private ConfigMapper configMapper;

	/*
	 * (non-Javadoc) <p>Title: updateConfig</p> <p>Description: </p>
	 * 
	 * @param config
	 * 
	 * @return
	 * 
	 * @see
	 * ujn.school.cn.service.config.IConfigService#updateConfig(ujn.school.cn
	 * .model.config.Config)
	 */
	@Override
	public int updateConfig(Config config) {
		// TODO Auto-generated method stub
		return configMapper.updateConfig(config);
	}

	/*
	 * (non-Javadoc) <p>Title: queryConfig</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see ujn.school.cn.service.config.IConfigService#queryConfig()
	 */
	@Override
	public Config queryConfig() {
		// TODO Auto-generated method stub
		return configMapper.selectByPrimaryKey(1);
	}

}
