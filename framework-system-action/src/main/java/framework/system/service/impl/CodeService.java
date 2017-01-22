/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import framework.system.dao.CodeMapper;
import framework.system.model.Code;
import framework.system.service.ICodeService;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("codeService") 
public class CodeService implements ICodeService {
	@Resource
	private CodeMapper codeMapper;
	
	@Override
	public Code getCodeById(int codeId) {
		//加载xml文件
        //ApplicationContext  ac = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
        //codeMapper = (CodeMapper) ac.getBean("codeMapper");

        return codeMapper.selectByPrimaryKey(codeId);
	}

	@Override
	public Code queryCodeByLogin(Code codeParam) {
		// TODO Auto-generated method stub
		return codeMapper.queryCodeByLogin(codeParam);
	}

	@Override
	public List<Code> queryCodeList(Code code) {
		// TODO Auto-generated method stub
		return codeMapper.queryCodeList(code);
	}

	@Override
	public int saveCode(Code code) {
		// TODO Auto-generated method stub
		return codeMapper.insertSelective(code);
	}

}
