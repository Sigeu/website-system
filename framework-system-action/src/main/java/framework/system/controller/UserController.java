/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import framework.system.model.User;
import framework.system.pub.base.MyBaseController;
import framework.system.service.IUserService;

/**   
 * @Description: 用户管理 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月17日 下午1:52:12 
 * @version V1.0   
 */
@Controller
@RequestMapping("/userController")
public class UserController extends MyBaseController{
	
	@Resource
	private IUserService userService;
	
	
	//跳转到用户列表
	@RequestMapping("/getUserById")
	public String getUserById(HttpServletRequest request,Model model){
		int userId = Integer.parseInt("1");
		User user = this.userService.getUserById(userId);
		System.out.println(user.getLogin_name()+"------------");
		model.addAttribute("user", user);
		return "showUser";
	}
		
		
	//跳转到用户列表
	@RequestMapping("/toUserList")
	public String toUserList(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "system/user/userList";
	}
	
	//跳转到修改
	@RequestMapping("/toUserUpdate")
	public String toUserUpdate(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
	
	//列表
	@RequestMapping("/queryUserList")
	public String queryUserList(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
	
	//更新
	@RequestMapping("/updateUser")
	public String updateUser(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
	
	//保存
	@RequestMapping("/saveUser")
	public String saveUser(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
	
	//添加
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
	
	//删除
	@RequestMapping("/deleteUser")
	public String deleteUser(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
}
