/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.dao.login;

import framework.system.model.User;



/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2016年12月26日 下午1:27:55 
 * @version V1.0   
 */
public interface LoginDao {
	
	/**
	 * 
	 * @Description: 根据登录名查询用户 
	 * @param loginName
	 * @return
	 */
	User queryUserByLoginName(String loginName);
}
