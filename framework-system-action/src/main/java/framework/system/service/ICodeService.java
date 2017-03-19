/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.service;

import java.util.List;

import framework.system.model.Code;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:49:54 
 * @version V1.0   
 */
public interface ICodeService {

	Code getCodeById(int codeId);
	
	/**
	 * 
	 * @Description: 用户分页查询 
	 * @param code
	 * @return
	 */
	List<Code> queryCodeList(Code code);
	
	/**
	 * 
	 * @Description: 用户保存 
	 * @param code
	 */
	int addCode(Code code);

	int deleteCode(int codeId);

	int updateCode(Code code);

	List<Code> queryCodeListByType(String code_type);


}
