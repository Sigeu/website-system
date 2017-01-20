/**
 * Copyright (C), 2013, 山东安之畅智能交通科技有限公司
 * All right reserved.
 */
package ujn.school.cn.service.login;

import javax.xml.registry.infomodel.User;

import ujn.school.cn.model.login.LoginStatusEnum;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2016年12月23日 下午1:49:20 
 * @version V1.0   
 */
public interface LoginService {
	
	/**
	 * 
	 * @Description: 登陆 
	 * @param userBean
	 * @return
	 */
	LoginStatusEnum login(User user);

}
