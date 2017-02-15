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

import framework.system.model.Role;
import framework.system.model.User;
import framework.system.pub.base.MyBaseController;
import framework.system.pub.util.DataTablePageUtil;
import framework.system.service.IRoleService;
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
	//用户Service
	@Resource
	private IUserService userService;
	//角色Service
	@Resource
	private IRoleService roleService;
	
		
	/**
	 * 
	 * @Description: 跳转到用户列表 页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toUserList")
	public String toUserList(HttpServletRequest request, Model model){
		return "system/user/userList";
	}
	
	/**
	 * 
	 * @Description: 跳转到用户添加页面 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toUserAdd")
	public String toUserAdd(HttpServletRequest request, Model model){
		try {
			//角色下拉列表
			//List<Role> roleList = roleService.getRoleSelectList();
			//model.addAttribute("roleList", roleList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "system/user/userAdd";
	}
	
	/**
	 * 
	 * @Description: 跳转到用户授权页面 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toUserRole")
	public String toUserRole(HttpServletRequest request, Model model){
		try {
			//角色下拉列表
			//List<Role> roleList = roleService.getRoleSelectList();
			//model.addAttribute("roleList", roleList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "system/user/userRole";
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
		return "system/user/userUpdate";
	}
	
	
	
	//更新
	@RequestMapping("/updateUser")
	public Map<String,Object> updateUser(HttpServletRequest request,User user){
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			this.userService.updateUser(user);
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}
		
		return map;
	}
	
	//保存
	@ResponseBody
	@RequestMapping("/addUser")
	public Map<String,Object> addUser(HttpServletRequest request,User user,Model model){
		Map<String,Object> map = new HashMap<String,Object>();
 		int count = this.userService.addUser(user);
		if(RESULT_COUNT_1 == count){
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}
		
		return map;
	}
	

	
	
	/**
	 * 
	 * @Description: 删除
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteUser")
	public Map<String,Object> deleteUser(HttpServletRequest request){
		int userId = Integer.parseInt(request.getParameter("id"));
		Map<String,Object> map = new HashMap<String,Object>();
 		int count = this.userService.deleteUser(userId);
		if(RESULT_COUNT_1 == count){
			map.put(RESULT_MESSAGE_STRING, "删除成功！");
		} else {
			map.put(RESULT_MESSAGE_STRING, "删除失败！");
		}
		
		return map;
	}
	
	/**
	 * 
	 * @Description: 停用用户 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/stopUser")
	public Map<String,Object> stopUser(HttpServletRequest request){
		int userId = Integer.parseInt(request.getParameter("id"));
		Map<String,Object> map = new HashMap<String,Object>();
 		int count = this.userService.stopUser(userId);
		if(RESULT_COUNT_1 == count){
			map.put(RESULT_MESSAGE_STRING, "停用成功！");
		} else {
			map.put(RESULT_MESSAGE_STRING, "停用失败！");
		}
		
		return map;
	}
	
	/**
	 * 
	 * @Description: 启用用户 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/startUser")
	public Map<String,Object> startUser(HttpServletRequest request){
		int userId = Integer.parseInt(request.getParameter("id"));
		Map<String,Object> map = new HashMap<String,Object>();
 		int count = this.userService.startUser(userId);
		if(RESULT_COUNT_1 == count){
			map.put(RESULT_MESSAGE_STRING, "启用成功！");
		} else {
			map.put(RESULT_MESSAGE_STRING, "启用失败！");
		}
		
		return map;
	}
}
