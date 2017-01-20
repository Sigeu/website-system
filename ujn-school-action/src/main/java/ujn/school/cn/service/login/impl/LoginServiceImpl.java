/**
 * Copyright (C), 2013, 山东安之畅智能交通科技有限公司
 * All right reserved.
 */
package ujn.school.cn.service.login.impl;

import javax.annotation.Resource;
import javax.xml.registry.infomodel.User;

import org.springframework.stereotype.Service;

import ujn.school.cn.dao.login.LoginDao;
import ujn.school.cn.model.login.LoginStatusEnum;
import ujn.school.cn.service.login.LoginService;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2016年12月23日 下午1:49:35 
 * @version V1.0   
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService{
	@Resource
	private LoginDao loginDao;

	@Override
	public LoginStatusEnum login(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}
