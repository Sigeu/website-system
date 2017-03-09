/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.controller.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
import com.yuanyuansinian.model.column.Column;
import com.yuanyuansinian.model.order.Order;
import com.yuanyuansinian.pub.base.MyBaseController;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.column.IColumnService;
import com.yuanyuansinian.service.order.IOrderService;

import framework.system.pub.util.DataTablePageUtil;

/**
 * @Description: 产品管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/sinian/order/orderController")
public class OrderController extends MyBaseController {
	// 产品Service
	@Resource
	private IOrderService orderService;
	
	@Resource
	private IColumnService columnService;

	/**
	 * 
	 * @Description: 跳转到分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toOrderList")
	public String toOrderList(HttpServletRequest request, Model model) {

		return "order/orderList";
	}
	
	/**
	 * 
	 * @Description: 跳转到产品回收站列表 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toOrderRecycleList")
	public String toOrderRecycleList(HttpServletRequest request, Model model) {

		return "order/orderRecycleList";
	}

	/**
	 * 
	 * @Description: 跳转到新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toOrderAdd")
	public String toOrderAdd(HttpServletRequest request, Model model) {
		
		
		return "order/orderAdd";
	}

	/**
	 * 
	 * @Description: 跳转到修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toOrderUpdate")
	public String toOrderUpdate(HttpServletRequest request, Model model) {
		int orderId = Integer.parseInt(request.getParameter("id"));
		Order order = this.orderService.queryOrderById(orderId);
		model.addAttribute("order", order);
		
		List<Column> columnList = columnService.queryColumnList(null);
		//处理栏目名称
		for(Column co : columnList){
			if(2 == co.getClass_type()){
				co.setName("&brvbar;&mdash;" + co.getName());
			}else if(3 == co.getClass_type()){
				co.setName("&brvbar;&mdash;&mdash;" + co.getName());
			}else if(4 == co.getClass_type()){
				co.setName("&brvbar;&mdash;&mdash;&mdash;" + co.getName());
			}else{
				//co.setName(co.getName());
			}
		}
		//排序
		LinkedList<Column> result = new LinkedList<Column>();
		LinkedList<Column> columnLinkedList = this.toSort(columnList, result, 0);
		//转换为ArrayList
		List<Column> columnSelectList = new ArrayList<Column>(columnLinkedList);
		model.addAttribute("columnSelectList", columnSelectList);
		
		return "order/orderUpdate";
	}
	

	/**
	 * 
	 * @Description: 跳转到明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toOrderDetail")
	public String toOrderDetail(HttpServletRequest request, Model model) {
		int orderId = Integer.parseInt(request.getParameter("id"));
		Order  order = this.orderService.queryOrderById(orderId);
		model.addAttribute("order", order);

		return "order/orderDetail";
	}

	/**
	 * 
	 * @Description: 分页列表
	 * @param request
	 * @param response
	 * @param order
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryOrderList")
	public DataTablePageUtil<Order> queryOrderList(HttpServletRequest request,
			HttpServletResponse response, Order order) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Order> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Order>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Order> orderList = this.orderService.queryOrderList(order);
			// 用PageInfo对结果进行包装
			PageInfo<Order> pageInfo = new PageInfo<Order>(orderList);

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
	 * @param order
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrder")
	public Map<String, Object> addOrder(HttpServletRequest request, Order order) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//发布人
			//order.setIssue(getSessionUser(request).getLogin_name());
			//默认状态为“0”：待审核
			orderService.addOrder(request, order);
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
	 * @param order
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateOrder")
	public Map<String, Object> updateOrder(HttpServletRequest request, Order order) {

		Map<String, Object> map = new HashMap<String, Object>();
		order.setCreate_date(MyDateUtil.getDateTime());
		int count = this.orderService.updateOrder(order);
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
	@RequestMapping("/deleteOrder")
	public Map<String, Object> deleteOrder(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int orderId = Integer.parseInt(request.getParameter("id"));
		int count = this.orderService.deleteOrder(orderId);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, DELETE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, DELETE_FAILED_MESSAGE);
		}
		return map;
	}
	
	
	/**
	 * 排序
	 * @param list
	 * @param result
	 * @param father
	 * @return
	 */
	protected LinkedList<Column> toSort(List<Column> list,
			LinkedList<Column> result, int father) {
		List<Column> temp = new ArrayList<Column>();
		// 最高层,临时存放
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBig_class() == father) {
				temp.add(list.get(i));
			}
		}

		if (temp.size() < 1) {
			return result;
		} else { 
			// 删除最高层
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getBig_class() == father) {
					list.remove(j);
				}
			}
			// 对最高层排序
			for (int i = 0; i < temp.size() - 1; i++) {
				for (int j = i + 1; j < temp.size(); j++) {
					if (temp.get(i).getNo_order() > temp.get(j).getNo_order()) {
						Column column = temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j, column);
					}
				}
			}
			// 递归
			for (int i = 0; i < temp.size(); i++) {
				result.add(temp.get(i));
				toSort(list, result, temp.get(i).getId());
			}
			return result;
		}

	}
}
