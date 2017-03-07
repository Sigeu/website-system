/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.mytest.mybatis;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:59:38
 * @version V1.0
 */
public class AutoMyBatisCode {
	public static void main(String[] args) {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("src/main/resources/config/mybatis-generator.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config;
		try {
			config = cp.parseConfiguration(configFile);

			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator;
			try {
				myBatisGenerator = new MyBatisGenerator(config, callback,
						warnings);
				myBatisGenerator.generate(null);
			} catch (Exception e) {

				e.printStackTrace();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
