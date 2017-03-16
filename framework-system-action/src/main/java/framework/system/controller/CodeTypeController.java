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

import framework.system.model.CodeType;
import framework.system.pub.base.SystemBaseController;
import framework.system.pub.util.DataTablePageUtil;
import framework.system.service.ICodeTypeService;

/**   
 * @Description: 字典数据管理 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月17日 下午1:52:12 
 * @version V1.0   
 */
@Controller
@RequestMapping("/system/controller/codeTypeController")
public class CodeTypeController extends SystemBaseController{
	
	@Resource
	private ICodeTypeService codeTypeService;
	
	
	/**
	 * 
	 * @Description: 根据ID查询字典项类别 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryCodeTypeById")
	public String queryCodeTypeById(HttpServletRequest request,Model model){
		//获取ID
		int codeTypeId = Integer.parseInt(super.nullToStringZero(request.getParameter("id")));
		//查询数据
		CodeType codeType = this.codeTypeService.getCodeTypeById(codeTypeId);
		
		model.addAttribute("codeType", codeType);
		
		
		return "system/code/codeTypeUpdate";
	}
		
		
	/**
	 * 
	 * @Description: 跳转到字典类别列表 
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCodeTypeList")
	public String toCodeTypeList(HttpServletRequest request){
		
		
		return "system/code/codeTypeList";
	}
	
	/**
	 * 
	 * @Description: 字典类别分页查询 
	 * @param request
	 * @param response
	 * @param CodeType
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryCodeTypeList")
	public DataTablePageUtil<CodeType> queryCodeTypeList(HttpServletRequest request, HttpServletResponse response,CodeType CodeType){
		//使用DataTables的属性接收分页数据
		DataTablePageUtil<CodeType> dataTable = null;
		try {
			//使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<CodeType>(request);
			//开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),dataTable.getPage_size());
			//还是使用List，方便后期用到
			List<CodeType>  CodeTypeList = this.codeTypeService.queryCodeTypeList(CodeType);
			//用PageInfo对结果进行包装 
			PageInfo<CodeType> pageInfo = new PageInfo<CodeType>(CodeTypeList);
			
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
	 * @Description: 跳转到修改页面 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCodeTypeUpdate")
	public String toCodeTypeUpdate(HttpServletRequest request,Model model){
		//获取ID
		int codeTypeId = Integer.parseInt(super.nullToStringZero(request.getParameter("id")));
		//查询数据
		CodeType codeType = this.codeTypeService.getCodeTypeById(codeTypeId);
		
		model.addAttribute("codeType", codeType);
		
		
		return "system/code/codeTypeUpdate";
	}
	
	
	/**
	 * 
	 * @Description: 跳转到明细页面 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCodeTypeDetail")
	public String toCodeTypeDetail(HttpServletRequest request,Model model){
		//获取ID
		int codeTypeId = Integer.parseInt(super.nullToStringZero(request.getParameter("id")));
		//查询数据
		CodeType codeType = this.codeTypeService.getCodeTypeById(codeTypeId);
		
		model.addAttribute("codeType", codeType);
		
		
		return "system/code/codeTypeDetail";
	}
	
	
	/**
	 * 
	 * @Description: 更新 
	 * @param request
	 * @param CodeType
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateCodeType")
	public Map<String,Object> updateCodeType(HttpServletRequest request,CodeType CodeType){
		Map<String,Object> map = new HashMap<String,Object>();
 		int count = this.codeTypeService.updateCodeType(CodeType);
		if(RESULT_COUNT_1 == count){
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}
		
		return map;
	}
	
	/**
	 * 
	 * @Description: 添加
	 * @param request
	 * @param CodeType
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addCodeType")
	public Map<String,Object> addCodeType(HttpServletRequest request,CodeType CodeType){
		Map<String,Object> map = new HashMap<String,Object>();
 		int count = this.codeTypeService.addCodeType(CodeType);
		if(RESULT_COUNT_1 == count){
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}
		
		return map;
	}
	
	@RequestMapping("/toCodeTypeAdd")
	public String toCodeTypeAdd(Model model){
		return "system/code/codeTypeAdd";
	}
	
	//删除
	@RequestMapping("/deleteCodeType")
	public String deleteCodeType(HttpServletRequest request,Model model){
		int codeTypeId = Integer.parseInt(request.getParameter("id"));
		CodeType CodeType = this.codeTypeService.getCodeTypeById(codeTypeId);
		model.addAttribute("CodeType", CodeType);
		return "showCodeType";
	}
}
