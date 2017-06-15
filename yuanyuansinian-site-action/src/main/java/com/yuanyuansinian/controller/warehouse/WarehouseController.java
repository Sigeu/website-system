/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.controller.warehouse;

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
import com.yuanyuansinian.model.member.Member;
import com.yuanyuansinian.model.warehouse.Warehouse;
import com.yuanyuansinian.pub.base.MyBaseController;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.column.IColumnService;
import com.yuanyuansinian.service.warehouse.IWarehouseService;

import framework.system.model.Code;
import framework.system.pub.util.DataTablePageUtil;
import framework.system.service.ICodeService;

/**
 * @Description: 已购买产品管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/sinian/warehouse/warehouseController")
public class WarehouseController extends MyBaseController {
	// 已购买产品Service
	@Resource
	private IWarehouseService warehouseService;
	
	@Resource
	private IColumnService columnService;
	
	@Resource
	private ICodeService codeService;

	/**
	 * 
	 * @Description: 跳转到商城已购买产品分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toWarehouseList")
	public String toWarehouseList(HttpServletRequest request, Model model) {

		return "warehouse/warehouseList";
	}
	
	/**
	 * 
	 * @Description: 跳转到纪念馆已购买产品列表 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallWarehouseList")
	public String toHallWarehouseList(HttpServletRequest request, Model model) {

		return "warehouse/hallWarehouseList";
	}
	/**
	 * 
	 * @Description: 跳转到礼品列表 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toWarehouseListForHall")
	public String toWarehouseListForHall(HttpServletRequest request, Model model) {

		return "warehouse/warehouseListForHall";
	}
	
	/**
	 * 
	 * @Description: 跳转到已购买产品回收站列表 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toWarehouseRecycleList")
	public String toWarehouseRecycleList(HttpServletRequest request, Model model) {

		return "warehouse/warehouseRecycleList";
	}

	/**
	 * 
	 * @Description: 跳转到商城已购买产品新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toWarehouseAdd")
	public String toWarehouseAdd(HttpServletRequest request, Model model) {
		//已购买产品小类
		List<Code> codeList = codeService.queryCodeListByType("warehouse_type");
		
		model.addAttribute("codeList", codeList);
		//已购买产品大类
		model.addAttribute("big_type", IMySystemConstants.VALUE_1);
		
		return "warehouse/warehouseAdd";
	}
	
	/**
	 * 
	 * @Description: 跳转到纪念馆已购买产品新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallWarehouseAdd")
	public String toHallWarehouseAdd(HttpServletRequest request, Model model) {
		//已购买产品小类
		List<Code> codeList = codeService.queryCodeListByType("hall_type");
		
		model.addAttribute("codeList", codeList);
		//已购买产品大类
		model.addAttribute("big_type", IMySystemConstants.VALUE_2);
		
		return "warehouse/hallWarehouseAdd";
	}

	/**
	 * 
	 * @Description: 跳转到商城已购买产品修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toWarehouseUpdate")
	public String toWarehouseUpdate(HttpServletRequest request, Model model) {
		int warehouseId = Integer.parseInt(request.getParameter("id"));
		Warehouse warehouse = this.warehouseService.queryWarehouseById(warehouseId);
		model.addAttribute("warehouse", warehouse);
		
		//List<Code> codeList = codeService.queryCodeListByType("warehouse_type");
		//model.addAttribute("codeList", codeList);
		//已购买产品大类
		//List<Code> bigTypeCodeList = codeService.queryCodeListByType("big_type");
		//model.addAttribute("bigTypeCodeList", bigTypeCodeList);
		
		
		return "warehouse/warehouseUpdate";
	}
	
	/**
	 * 
	 * @Description: 跳转到纪念馆已购买产品修改页面 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallWarehouseUpdate")
	public String toHallWarehouseUpdate(HttpServletRequest request, Model model) {
		int warehouseId = Integer.parseInt(request.getParameter("id"));
		Warehouse warehouse = this.warehouseService.queryWarehouseById(warehouseId);
		model.addAttribute("warehouse", warehouse);
		
		return "warehouse/hallWarehouseUpdate";
	}

	/**
	 * 
	 * @Description: 跳转到商城已购买产品明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toWarehouseDetail")
	public String toWarehouseDetail(HttpServletRequest request, Model model) {
		int warehouseId = Integer.parseInt(request.getParameter("id"));
		Warehouse  warehouse = this.warehouseService.queryWarehouseById(warehouseId);
		model.addAttribute("warehouse", warehouse);

		return "warehouse/warehouseDetail";
	}
	
	
	/**
	 * 
	 * @Description: 跳转到纪念馆已购买产品明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallWarehouseDetail")
	public String toHallWarehouseDetail(HttpServletRequest request, Model model) {
		int warehouseId = Integer.parseInt(request.getParameter("id"));
		Warehouse  warehouse = this.warehouseService.queryWarehouseById(warehouseId);
		model.addAttribute("warehouse", warehouse);

		return "warehouse/hallWarehouseDetail";
	}

	/**
	 * 
	 * @Description: 商城已购买产品分页列表
	 * @param request
	 * @param response
	 * @param warehouse
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryWarehouseList")
	public DataTablePageUtil<Warehouse> queryWarehouseList(HttpServletRequest request,
			HttpServletResponse response, Warehouse warehouse) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Warehouse> dataTable = null;
		//获取登录的会员
		Member memberUser = super.getSessionMemberUser(request);
		String memberId= memberUser.getId().toString();
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Warehouse>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Warehouse> warehouseList = this.warehouseService.queryWarehouseList(warehouse);
			// 用PageInfo对结果进行包装
			PageInfo<Warehouse> pageInfo = new PageInfo<Warehouse>(warehouseList);

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
	 * @Description: 纪念馆已购买产品列表 
	 * @param request
	 * @param response
	 * @param warehouse
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryHallWarehouseList")
	public DataTablePageUtil<Warehouse> queryHallWarehouseList(HttpServletRequest request,
			HttpServletResponse response, Warehouse warehouse) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Warehouse> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Warehouse>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Warehouse> warehouseList = this.warehouseService.queryWarehouseList(warehouse);
			// 用PageInfo对结果进行包装
			PageInfo<Warehouse> pageInfo = new PageInfo<Warehouse>(warehouseList);

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
	 * @Description: 礼品分页列表
	 * @param request
	 * @param response
	 * @param warehouse
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryWarehouseListForHall")
	public DataTablePageUtil<Warehouse> queryWarehouseListForHall(HttpServletRequest request,
			HttpServletResponse response, Warehouse warehouse) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Warehouse> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Warehouse>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Warehouse> warehouseList = this.warehouseService.queryWarehouseList(warehouse);
			// 用PageInfo对结果进行包装
			PageInfo<Warehouse> pageInfo = new PageInfo<Warehouse>(warehouseList);

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
	 * @Description: 添加商城已购买产品
	 * @param request
	 * @param warehouse
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addWarehouse")
	public Map<String, Object> addWarehouse(HttpServletRequest request, Warehouse warehouse) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//发布人
			//warehouse.setIssue(getSessionUser(request).getLogin_name());
			//默认状态为“0”：待审核
			warehouse.setUse_status(IMySystemConstants.VALUE_0);
			warehouseService.addWarehouse(request, warehouse);
			map.put("model_id", warehouse.getId());
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}
	
	/**
	 * 
	 * @Description: 商城已购买产品修改
	 * @param request
	 * @param warehouse
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateWarehouse")
	public Map<String, Object> updateWarehouse(HttpServletRequest request, Warehouse warehouse) {

		Map<String, Object> map = new HashMap<String, Object>();
		warehouse.setPurchase_date(MyDateUtil.getDateTime());
		map.put("model_id", warehouse.getId());
		int count = this.warehouseService.updateWarehouse(warehouse);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}
	
	//使用礼品
	@ResponseBody
	@RequestMapping("/updateWarehouseForUse")
	public Map<String, Object> updateWarehouseForUse(HttpServletRequest request) {
		
		int warehouseId = Integer.parseInt(request.getParameter("id"));
		Warehouse  warehouse = this.warehouseService.queryWarehouseById(warehouseId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		String today = MyDateUtil.getDate();
		String endDay = MyDateUtil.addDay(today,Integer.parseInt(warehouse.getValidity_day()));
		//使用日期
		warehouse.setUse_date(today);
		//结束日期
		warehouse.setEnd_date(endDay);
		//使用状态
		warehouse.setUse_status(STATUS_CODE_1);
		
		int count = this.warehouseService.updateWarehouseForUse(warehouse);
		if (RESULT_COUNT_1 == count) {
			map.put("flag", "1");
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put("flag", "0");
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}
	/**
	 * 
	 * @Description: 已购买产品删除
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteWarehouse")
	public Map<String, Object> deleteWarehouse(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int warehouseId = Integer.parseInt(request.getParameter("id"));
		int count = this.warehouseService.deleteWarehouse(warehouseId);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, DELETE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, DELETE_FAILED_MESSAGE);
		}
		return map;
	}
	
}
