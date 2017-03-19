/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import framework.system.model.Code;
import framework.system.pub.base.SystemBaseController;
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
public class CodeController extends SystemBaseController{
	
	@Resource
	private ICodeService codeService;
	
		
	/**
	 * 
	 * @Description: 跳转到用户列表 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCodeList")
	public String toCodeList(HttpServletRequest request, Model model){
		
		return "system/code/codeList";
	}
	
	/**
	 * 
	 * @Description: 分页查询 
	 * @param request
	 * @param Code
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryCodeList")
	public DataTablePageUtil<Code> queryCodeList(HttpServletRequest request, Code Code){
		//使用DataTables的属性接收分页数据
		DataTablePageUtil<Code> dataTable = null;
		try {
			//使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Code>(request);
			//开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),dataTable.getPage_size());
			//还是使用List，方便后期用到
			List<Code>  CodeList = this.codeService.queryCodeList(Code);
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
	
	/**
	 * 
	 * @Description:根据类别查询字典数据
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryCodeListByType")
	public List<Code> queryCodeListByType(HttpServletRequest request){
		List<Code> codeList = new ArrayList<Code>();
		//类别
		String code_type = nullToString(request.getParameter("code_type"));
		
		codeList = this.codeService.queryCodeListByType(code_type);
		
		
		return codeList;
	}
	
	
	/**
	 * 
	 * @Description: 跳转到修改 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCodeUpdate")
	public String toCodeUpdate(HttpServletRequest request,Model model){
		
		//获取ID
		int codeId = Integer.parseInt(super.nullToStringZero(request.getParameter("id")));
		//查询数据
		Code code = this.codeService.getCodeById(codeId);
		
		model.addAttribute("code", code);
				
		return "system/code/codeUpdate";
	}
	
	
	
	/**
	 * 
	 * @Description: 更新 
	 * @param request
	 * @param Code
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateCode")
	public Map<String,Object> updateCode(HttpServletRequest request,Code Code){
		Map<String,Object> map = new HashMap<String,Object>();
 		int count = this.codeService.updateCode(Code);
		if(RESULT_COUNT_1 == count){
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}
		
		return map;
	}
	
	/**
	 * 
	 * @Description: 新增 
	 * @param request
	 * @param Code
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addCode")
	public Map<String,Object> addCode(HttpServletRequest request,Code Code){
		Map<String,Object> map = new HashMap<String,Object>();
 		int count = this.codeService.addCode(Code);
		if(RESULT_COUNT_1 == count){
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}
		
		return map;
	}
	
	/**
	 * 
	 * @Description: 跳转到添加页面 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCodeAdd")
	public String toCodeAdd(HttpServletRequest request, Model model){
		//字典类别
		String code_type = nullToString(request.getParameter("code_type"));
		model.addAttribute("code_type", code_type);
		
		return "system/code/codeAdd";
	}
	
	
	/**
	 * 
	 * @Description: 删除 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteCode")
	public Map<String,Object> deleteCode(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		
		int codeId = Integer.parseInt(super.nullToStringZero(request.getParameter("id")));
		int count = this.codeService.deleteCode(codeId);
		if(RESULT_COUNT_1 == count){
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}
		
		return map;
	}
}
