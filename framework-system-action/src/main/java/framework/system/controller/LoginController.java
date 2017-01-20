/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import framework.system.model.User;
import framework.system.pub.base.MyBaseController;
import framework.system.service.IUserService;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 下午5:02:47 
 * @version V1.0   
 */
@Controller
@RequestMapping("/loginController")
public class LoginController extends MyBaseController{
	@Resource
	private IUserService userService;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,User userParam){
		try {
			
			 //转发方式1
	        //return "home.jsp";
	        //转发方式2
	        //return "forward:index.jsp";
	        //重定向方式
	        //return "redirect:index.jsp";
			User user = userService.queryUserByLogin(userParam);
			if(null != user && !"".equals(user.getLogin_name())){
				request.getSession().setAttribute(SESSION_USER_KEY, user);
				return "main/index";
			}else{
				return "forward:/login.jsp";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "forward:/login.jsp";
		}
	}
}
