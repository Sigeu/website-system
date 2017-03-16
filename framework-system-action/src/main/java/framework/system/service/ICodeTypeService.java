/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.service;

import java.util.List;

import framework.system.model.CodeType;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:49:54 
 * @version V1.0   
 */
public interface ICodeTypeService {

	CodeType getCodeTypeById(int codeTypeId);
	
	
	/**
	 * 
	 * @Description: 用户分页查询 
	 * @param codeType
	 * @return
	 */
	List<CodeType> queryCodeTypeList(CodeType codeType);
	
	/**
	 * 
	 * @Description: 用户保存 
	 * @param codeType
	 */
	int addCodeType(CodeType codeType);


	int updateCodeType(CodeType codeType);

}
