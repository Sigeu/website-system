/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.service;

import java.util.List;

import framework.system.model.Log;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:49:54 
 * @version V1.0   
 */
public interface ILogService {

	Log getLogById(int logId);
	
	/**
	 * 
	 * @Description: 用户分页查询 
	 * @param log
	 * @return
	 */
	List<Log> queryLogList(Log log);
	
	/**
	 * 
	 * @Description: 用户保存 
	 * @param log
	 */
	int saveLog(Log log);
	
	/**
	 * 
	 * @Description: 新增
	 * @param log
	 * @return
	 */
	int addLog(Log log);

}
