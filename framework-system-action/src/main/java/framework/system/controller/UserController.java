/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import framework.system.model.User;
import framework.system.pub.base.MyBaseController;
import framework.system.pub.util.DataTablePageUtil;
import framework.system.service.IUserService;

/**   
 * @Description: 用户管理 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月17日 下午1:52:12 
 * @version V1.0   
 */
@Controller
@RequestMapping("/system/controller/userController")
public class UserController extends MyBaseController{
	
	@Resource
	private IUserService userService;
	
	
	//跳转到用户列表
	@RequestMapping("/getUserById")
	public String getUserById(HttpServletRequest request,Model model){
		int userId = Integer.parseInt("1");
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
		
		
	//跳转到用户列表
	@RequestMapping("/toUserList")
	public String toUserList(Model model){
		return "system/user/userList";
	}
	
	/**
	 * 
	 * @Description: 用户分页查询 
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryUserList")
	public DataTablePageUtil<User> queryUserList(HttpServletRequest request, HttpServletResponse response,User user){
		//使用DataTables的属性接收分页数据
		DataTablePageUtil<User> dataTable = null;
		try {
			//使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<User>(request);
			//开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),dataTable.getPage_size());
			//还是使用List，方便后期用到
			List<User>  userList = this.userService.queryUserList(user);
			//用PageInfo对结果进行包装 
			PageInfo<User> pageInfo = new PageInfo<User>(userList);
			
			//封装数据给DataTables
			dataTable.setDraw(dataTable.getDraw());
			dataTable.setData(pageInfo.getList());  
		    dataTable.setRecordsTotal((int)pageInfo.getTotal());  
		    dataTable.setRecordsFiltered(dataTable.getRecordsTotal());
		    
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return dataTable;
	}
	
	//跳转到修改
	@RequestMapping("/toUserUpdate")
	public String toUserUpdate(HttpServletRequest request,Model model){
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
	@ResponseBody
	@RequestMapping("/saveUser")
	public Map<String,Object> saveUser(HttpServletRequest request,User user,Model model){
		Map<String,Object> map = new HashMap<String,Object>();
 		int count = this.userService.saveUser(user);
		if(RESULT_COUNT_1 == count){
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}
		
		return map;
	}
	
	@RequestMapping("/toUserAdd")
	public String toUserAdd(Model model){
		return "system/user/userAdd";
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
