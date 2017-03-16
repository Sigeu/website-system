/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import framework.system.dao.CodeTypeMapper;
import framework.system.model.CodeType;
import framework.system.service.ICodeTypeService;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("codeTypeService") 
public class CodeTypeService implements ICodeTypeService {
	@Resource
	private CodeTypeMapper codeTypeMapper;
	
	@Override
	public CodeType getCodeTypeById(int codeTypeId) {
		//加载xml文件
        //ApplicationContext  ac = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
        //codeTypeMapper = (CodeTypeMapper) ac.getBean("codeTypeMapper");

        return codeTypeMapper.selectByPrimaryKey(codeTypeId);
	}


	@Override
	public List<CodeType> queryCodeTypeList(CodeType codeType) {
		// TODO Auto-generated method stub
		return codeTypeMapper.queryCodeTypeList(codeType);
	}

	@Override
	public int addCodeType(CodeType codeType) {
		// TODO Auto-generated method stub
		return codeTypeMapper.insertSelective(codeType);
	}


	@Override
	public int updateCodeType(CodeType codeType) {
		// TODO Auto-generated method stub
		return codeTypeMapper.updateByPrimaryKeySelective(codeType);
	}

}
