/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import framework.system.model.Log;
import framework.system.pub.base.MyBaseController;
import framework.system.pub.util.DataTablePageUtil;
import framework.system.service.ILogService;

/**   
 * @Description: 登录日志管理 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月17日 下午1:52:12 
 * @version V1.0   
 */
@Controller
@RequestMapping("/system/controller/logController")
public class LogController extends MyBaseController{
	
	@Resource
	private ILogService logService;
	
	
	//跳转到用户列表
	@RequestMapping("/getLogById")
	public String getLogById(HttpServletRequest request,Model model){
		int logId = Integer.parseInt("1");
		Log log = this.logService.getLogById(logId);
		model.addAttribute("Log", log);
		return "showLog";
	}
		
		
	//跳转到用户列表
	@RequestMapping("/toLogList")
	public String toLogList(Model model){
		
		return "system/log/logList";
	}
	
	/**
	 * 
	 * @Description: 用户分页查询 
	 * @param request
	 * @param response
	 * @param Log
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryLogList")
	public DataTablePageUtil<Log> queryLogList(HttpServletRequest request, HttpServletResponse response,Log log){
		//使用DataTables的属性接收分页数据
		DataTablePageUtil<Log> dataTable = null;
		try {
			//使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Log>(request);
			//开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),dataTable.getPage_size());
			//还是使用List，方便后期用到
			List<Log>  logList = this.logService.queryLogList(log);
			//用PageInfo对结果进行包装 
			PageInfo<Log> pageInfo = new PageInfo<Log>(logList);
			
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
	
}
