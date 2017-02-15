/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.controller;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import framework.system.model.Department;
import framework.system.pub.base.MyBaseController;
import framework.system.pub.util.DataTablePageUtil;
import framework.system.pub.util.ZtreeNode;
import framework.system.service.IDepartmentService;

/**   
 * @Description: 部门管理 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月17日 下午1:52:12 
 * @version V1.0   
 */
@Controller
@RequestMapping("/system/controller/departmentController")
public class DepartmentController extends MyBaseController{
	
	@Resource
	private IDepartmentService departmentService;
	
	
	//跳转到用户列表
	@RequestMapping("/queryDepartmentById")
	public String queryDepartmentById(HttpServletRequest request,Model model){
		int departmentId = Integer.parseInt("1");
		Department department = this.departmentService.getDepartmentById(departmentId);
		model.addAttribute("department", department);
		return "showDepartment";
	}
		
		
	//跳转到用户列表
	@RequestMapping("/toDepartmentList")
	public String toDepartmentList(Model model){
		return "system/department/departmentList";
	}
	
	/**
	 * 
	 * @Description: 用户分页查询 
	 * @param request
	 * @param response
	 * @param department
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryDepartmentList")
	public DataTablePageUtil<Department> queryDepartmentList(HttpServletRequest request, HttpServletResponse response,Department department){
		//使用DataTables的属性接收分页数据
		DataTablePageUtil<Department> dataTable = null;
		try {
			//使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Department>(request);
			//开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),dataTable.getPage_size());
			//还是使用List，方便后期用到
			List<Department>  departmentList = this.departmentService.queryDepartmentList(department);
			//用PageInfo对结果进行包装 
			PageInfo<Department> pageInfo = new PageInfo<Department>(departmentList);
			
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
	
	/**
	 * @Description: 部门树 
	 * @param request
	 * @param response
	 * @param department
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryDepartmentTree")
	public ZtreeNode queryDepartmentTree(HttpServletRequest request, HttpServletResponse response,Department department){
		ZtreeNode ztreeNode = null;
		//返回的数据
		List<ZtreeNode> listZtreeNode = new ArrayList<ZtreeNode>();
		try {
			List<Department>  departmentList = this.departmentService.queryDepartmentList(department);
			for (Department departmentObj : departmentList) {
				listZtreeNode.add(new ZtreeNode(departmentObj.getDept_code()
						.toString(), departmentObj.getParent_code().toString(),
						departmentObj.getDept_name(), true, false, false));
			}
			
			ztreeNode = this.listToJson(listZtreeNode);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ztreeNode;
	}
	
	
	//跳转到修改
	@RequestMapping("/toDepartmentUpdate")
	public String toDepartmentUpdate(HttpServletRequest request,Model model){
		int departmentId = Integer.parseInt(request.getParameter("id"));
		Department department = this.departmentService.getDepartmentById(departmentId);
		model.addAttribute("department", department);
		return "showDepartment";
	}
	
	
	
	//更新
	@RequestMapping("/updateDepartment")
	public String updateDepartment(HttpServletRequest request,Model model){
		int departmentId = Integer.parseInt(request.getParameter("id"));
		Department department = this.departmentService.getDepartmentById(departmentId);
		model.addAttribute("department", department);
		return "showDepartment";
	}
	
	//保存
	@ResponseBody
	@RequestMapping("/saveDepartment")
	public Map<String,Object> saveDepartment(HttpServletRequest request,Department department,Model model){
		Map<String,Object> map = new HashMap<String,Object>();
 		int count = this.departmentService.saveDepartment(department);
		if(RESULT_COUNT_1 == count){
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}
		
		return map;
	}
	
	@RequestMapping("/toDepartmentAdd")
	public String toDepartmentAdd(Model model){
		return "system/department/departmentAdd";
	}
	
	//添加
	@RequestMapping("/addDepartment")
	public String addDepartment(HttpServletRequest request,Model model){
		int departmentId = Integer.parseInt(request.getParameter("id"));
		Department department = this.departmentService.getDepartmentById(departmentId);
		model.addAttribute("department", department);
		return "showDepartment";
	}
	
	//删除
	@RequestMapping("/deleteDepartment")
	public String deleteDepartment(HttpServletRequest request,Model model){
		int departmentId = Integer.parseInt(request.getParameter("id"));
		Department department = this.departmentService.getDepartmentById(departmentId);
		model.addAttribute("department", department);
		return "showDepartment";
	}
	
	
	public ZtreeNode listToJson(List<ZtreeNode> ztreeNodeList){
		 // 根节点  
        ZtreeNode rootNode = null; 
        // 节点列表（散列表，用于临时存储节点对象）  
        HashMap<String,ZtreeNode> nodeMap = new HashMap<String,ZtreeNode>();  
        // 将结果集存入散列表（后面将借助散列表构造多叉树）  
        if(null != ztreeNodeList){
			for(ZtreeNode node : ztreeNodeList){
				//这里是ID
				nodeMap.put(node.getId(), node);
			}
		}
        // 构造无序的多叉树  
        Set<?> entrySet = nodeMap.entrySet();  
        for (Iterator<?> it = entrySet.iterator(); it.hasNext();) {  
            @SuppressWarnings("rawtypes")
			ZtreeNode node = (ZtreeNode) ((Map.Entry) it.next()).getValue();  
            if (null == node.getPid() || "0".equals(node.getPid()) || "".equals(node.getPid()) ) {  
            	rootNode = node;  
            } else {  
            	//这里是PID
                nodeMap.get(node.getPid()).addChild(node);  
            }  
        }  
		
        // 输出无序的树形菜单的JSON字符串  
        //System.out.println(rootNode);  
        // 对多叉树进行横向排序  
        rootNode.sortChildren();  
        // 输出有序的树形菜单的JSON字符串  
        //System.out.println(rootNode); 
		
		return rootNode;
	}
}
