/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.service;

import java.util.List;

import framework.system.model.User;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:49:54 
 * @version V1.0   
 */
public interface IUserService {

	User getUserById(int userId);
	
	/**
	 * 
	 * @Description: 登录用户查询 
	 * @param userParam
	 * @return
	 */
	User queryUserByLogin(User userParam);
	
	/**
	 * 
	 * @Description: 用户分页查询 
	 * @param user
	 * @return
	 */
	List<User> queryUserList(User user);
	
	/**
	 * 
	 * @Description: 用户保存 
	 * @param user
	 */
	int addUser(User user);

	void updateUser(User user);

}
