/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.controller.cemetery;

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
import com.yuanyuansinian.model.cemetery.Cemetery;
import com.yuanyuansinian.model.cemetery.CemeteryWithBLOBs;
import com.yuanyuansinian.model.oration.Oration;
import com.yuanyuansinian.pub.base.MyBaseController;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.cemetery.ICemeteryService;
import com.yuanyuansinian.service.oration.IOrationService;

import framework.system.pub.util.DataTablePageUtil;

/**
 * @Description: 墓地陵园管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/sinian/cemetery/cemeteryController")
public class CemeteryController extends MyBaseController {
	// 墓地陵园Service
	@Resource
	private ICemeteryService cemeteryService;
	
	@Resource
	private IOrationService orationService;

	/**
	 * 
	 * @Description: 跳转到分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCemeteryList")
	public String toCemeteryList(HttpServletRequest request, Model model) {

		return "cemetery/cemeteryList";
	}
	
	/**
	 * 
	 * @Description: 跳转到会员创建的纪念馆列表 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCemeteryListByMember")
	public String toCemeteryListByMember(HttpServletRequest request, Model model) {
		//设置差当前登录会员
		String memberId = super.getSessionMemberUser(request).getId()+"";
		
		//我创建的纪念馆
		List<Cemetery> cemeteryList = this.cemeteryService.queryCemeteryListByMember(memberId,IMySystemConstants.COUNT_NUM2);
		//我的访问 visit
		
		//我发布的祭文
		List<Oration> orationList = this.orationService.queryOrationListByMember(memberId,IMySystemConstants.COUNT_NUM2);
		
		model.addAttribute("cemeteryList", cemeteryList);
		model.addAttribute("orationList", orationList);
		
		return "site/memberIssue";
	}
	/**
	 * 
	 * @Description: 跳转到墓地陵园回收站列表 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCemeteryRecycleList")
	public String toCemeteryRecycleList(HttpServletRequest request, Model model) {

		return "cemetery/cemeteryRecycleList";
	}

	/**
	 * 
	 * @Description: 跳转到新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCemeteryAdd")
	public String toCemeteryAdd(HttpServletRequest request, Model model) {
		
		
		return "cemetery/cemeteryAdd";
	}

	/**
	 * 
	 * @Description: 跳转到修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCemeteryUpdate")
	public String toCemeteryUpdate(HttpServletRequest request, Model model) {
		int cemeteryId = Integer.parseInt(request.getParameter("id"));
		Cemetery cemetery = this.cemeteryService.queryCemeteryById(cemeteryId);
		model.addAttribute("cemetery", cemetery);
		
		return "cemetery/cemeteryUpdate";
	}
	

	/**
	 * 
	 * @Description: 跳转到明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCemeteryDetail")
	public String toCemeteryDetail(HttpServletRequest request, Model model) {
		int cemeteryId = Integer.parseInt(request.getParameter("id"));
		Cemetery  cemetery = this.cemeteryService.queryCemeteryById(cemeteryId);
		model.addAttribute("cemetery", cemetery);

		return "cemetery/cemeteryDetail";
	}

	/**
	 * 
	 * @Description: 分页列表
	 * @param request
	 * @param response
	 * @param cemetery
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryCemeteryList")
	public DataTablePageUtil<Cemetery> queryCemeteryList(HttpServletRequest request,
			HttpServletResponse response, Cemetery cemetery) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Cemetery> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Cemetery>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Cemetery> cemeteryList = this.cemeteryService.queryCemeteryList(cemetery);
			// 用PageInfo对结果进行包装
			PageInfo<Cemetery> pageInfo = new PageInfo<Cemetery>(cemeteryList);

			// 封装数据给DataTables
			dataTable.setDraw(dataTable.getDraw());
			dataTable.setData(pageInfo.getList());
			dataTable.setRecordsTotal((int) pageInfo.getTotal());
			dataTable.setRecordsFiltered(dataTable.getRecordsTotal());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return dataTable;
	}
	
	/**
	 * 
	 * @Description: 分页列表
	 * @param request
	 * @param response
	 * @param cemetery
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryCemeteryListByMember")
	public DataTablePageUtil<Cemetery> queryCemeteryListByMember(HttpServletRequest request,
			HttpServletResponse response, Cemetery cemetery) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Cemetery> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Cemetery>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Cemetery> cemeteryList = this.cemeteryService.queryCemeteryPageListByMember(cemetery);
			// 用PageInfo对结果进行包装
			PageInfo<Cemetery> pageInfo = new PageInfo<Cemetery>(cemeteryList);

			// 封装数据给DataTables
			dataTable.setDraw(dataTable.getDraw());
			dataTable.setData(pageInfo.getList());
			dataTable.setRecordsTotal((int) pageInfo.getTotal());
			dataTable.setRecordsFiltered(dataTable.getRecordsTotal());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return dataTable;
	}
	
	/**
	 * 
	 * @Description: 根据公开状态查询列表 
	 * @param request
	 * @param response
	 * @param cemetery
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryCemeteryListByOpenType")
	public DataTablePageUtil<Cemetery> queryCemeteryListByOpenType(HttpServletRequest request,
			HttpServletResponse response, Cemetery cemetery) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Cemetery> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Cemetery>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Cemetery> cemeteryList = this.cemeteryService.queryCemeteryListByOpenType(cemetery);
			// 用PageInfo对结果进行包装
			PageInfo<Cemetery> pageInfo = new PageInfo<Cemetery>(cemeteryList);

			// 封装数据给DataTables
			dataTable.setDraw(dataTable.getDraw());
			dataTable.setData(pageInfo.getList());
			dataTable.setRecordsTotal((int) pageInfo.getTotal());
			dataTable.setRecordsFiltered(dataTable.getRecordsTotal());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return dataTable;
	}

	/**
	 * 
	 * @Description: 添加
	 * @param request
	 * @param cemetery
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addCemetery")
	public Map<String, Object> addCemetery(HttpServletRequest request, CemeteryWithBLOBs cemetery) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//发布人
			//cemetery.setIssue(getSessionUser(request).getLogin_name());
			//默认状态为“0”：待审核
			cemeteryService.addCemetery(request, cemetery);
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}

	/**
	 * 
	 * @Description: 修改
	 * @param request
	 * @param cemetery
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateCemetery")
	public Map<String, Object> updateCemetery(HttpServletRequest request, Cemetery cemetery) {

		Map<String, Object> map = new HashMap<String, Object>();
		cemetery.setCreate_date(MyDateUtil.getDateTime());
		int count = this.cemeteryService.updateCemetery(cemetery);
		if (RESULT_COUNT_1 == count) {
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
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteCemetery")
	public Map<String, Object> deleteCemetery(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int cemeteryId = Integer.parseInt(request.getParameter("id"));
		int count = this.cemeteryService.deleteCemetery(cemeteryId);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, DELETE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, DELETE_FAILED_MESSAGE);
		}
		return map;
	}
}
