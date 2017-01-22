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

import framework.system.model.Code;
import framework.system.pub.base.MyBaseController;
import framework.system.pub.util.DataTablePageUtil;
import framework.system.service.ICodeService;

/**   
 * @Description: 字典数据管理 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月17日 下午1:52:12 
 * @version V1.0   
 */
@Controller
@RequestMapping("/system/controller/codeController")
public class CodeController extends MyBaseController{
	
	@Resource
	private ICodeService CodeService;
	
	
	//跳转到用户列表
	@RequestMapping("/getCodeById")
	public String getCodeById(HttpServletRequest request,Model model){
		int CodeId = Integer.parseInt("1");
		Code Code = this.CodeService.getCodeById(CodeId);
		model.addAttribute("Code", Code);
		return "showCode";
	}
		
		
	//跳转到用户列表
	@RequestMapping("/toCodeList")
	public String toCodeList(Model model){
		return "system/Code/CodeList";
	}
	
	/**
	 * 
	 * @Description: 用户分页查询 
	 * @param request
	 * @param response
	 * @param Code
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryCodeList")
	public DataTablePageUtil<Code> queryCodeList(HttpServletRequest request, HttpServletResponse response,Code Code){
		//使用DataTables的属性接收分页数据
		DataTablePageUtil<Code> dataTable = null;
		try {
			//使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Code>(request);
			//开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),dataTable.getPage_size());
			//还是使用List，方便后期用到
			List<Code>  CodeList = this.CodeService.queryCodeList(Code);
			//用PageInfo对结果进行包装 
			PageInfo<Code> pageInfo = new PageInfo<Code>(CodeList);
			
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
	@RequestMapping("/toCodeUpdate")
	public String toCodeUpdate(HttpServletRequest request,Model model){
		int CodeId = Integer.parseInt(request.getParameter("id"));
		Code Code = this.CodeService.getCodeById(CodeId);
		model.addAttribute("Code", Code);
		return "showCode";
	}
	
	
	
	//更新
	@RequestMapping("/updateCode")
	public String updateCode(HttpServletRequest request,Model model){
		int CodeId = Integer.parseInt(request.getParameter("id"));
		Code Code = this.CodeService.getCodeById(CodeId);
		model.addAttribute("Code", Code);
		return "showCode";
	}
	
	//保存
	@ResponseBody
	@RequestMapping("/saveCode")
	public Map<String,Object> saveCode(HttpServletRequest request,Code Code,Model model){
		Map<String,Object> map = new HashMap<String,Object>();
 		int count = this.CodeService.saveCode(Code);
		if(RESULT_COUNT_1 == count){
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}
		
		return map;
	}
	
	@RequestMapping("/toCodeAdd")
	public String toCodeAdd(Model model){
		return "system/Code/CodeAdd";
	}
	
	//添加
	@RequestMapping("/addCode")
	public String addCode(HttpServletRequest request,Model model){
		int CodeId = Integer.parseInt(request.getParameter("id"));
		Code Code = this.CodeService.getCodeById(CodeId);
		model.addAttribute("Code", Code);
		return "showCode";
	}
	
	//删除
	@RequestMapping("/deleteCode")
	public String deleteCode(HttpServletRequest request,Model model){
		int CodeId = Integer.parseInt(request.getParameter("id"));
		Code Code = this.CodeService.getCodeById(CodeId);
		model.addAttribute("Code", Code);
		return "showCode";
	}
}
