/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.controller.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

import com.alipay.api.internal.util.AlipaySignature;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanyuansinian.alipay.config.AlipayConfig;
import com.yuanyuansinian.model.column.Column;
import com.yuanyuansinian.model.order.Order;
import com.yuanyuansinian.pub.base.MyBaseController;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
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
	
	
	
	@ResponseBody
	@RequestMapping("/notifyUrl")
	public String notifyUrl(HttpServletRequest request, Order order) {
		
		String message = "success";
		/* *
		 * 功能：支付宝服务器异步通知页面
		 * 日期：2017-03-30
		 * 说明：
		 * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
		 * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。


		 *************************页面功能说明*************************
		 * 创建该页面文件时，请留心该页面文件中无任何HTML代码及空格。
		 * 该页面不能在本机电脑测试，请到服务器上做测试。请确保外部可以访问该页面。
		 * 如果没有收到该页面返回的 success 
		 * 建议该页面只做支付成功的业务逻辑处理，退款的处理请以调用退款查询接口的结果为准。
		 */
		 try {
			
		
			//获取支付宝POST过来反馈信息
			Map<String,String> params = new HashMap<String,String>();
			Map<String,String[]> requestParams = request.getParameterMap();
			for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				//乱码解决，这段代码在出现乱码时使用
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
				params.put(name, valueStr);
			}
			
			boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

			//——请在这里编写您的程序（以下代码仅作参考）——
			
			/* 实际验证过程建议商户务必添加以下校验：
			1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
			2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
			3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
			4、验证app_id是否为该商户本身。
			*/
			if(signVerified) {//验证成功
				//商户订单号
				String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			
				//支付宝交易号
				String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			
				//交易状态
				String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
				
				if(trade_status.equals("TRADE_FINISHED")){
					//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
						
					//注意：
					//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
				}else if (trade_status.equals("TRADE_SUCCESS")){
					//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
					
					//注意：
					//付款完成后，支付宝系统发送该交易状态通知
					order.setOrder_num(out_trade_no);
					//支付成功
					order.setStatus(IMySystemConstants.VALUE_1);
					//支付宝订单号
					order.setTrade_no(trade_no);
					this.orderService.updateOrderByOrderNum(order);
				}
				message = "success";
				
			}else {//验证失败
				message = "fail";
			
				//调试用，写文本函数记录程序运行情况是否正常
				//String sWord = AlipaySignature.getSignCheckContentV1(params);
				//AlipayConfig.logResult(sWord);
			}
			
			//——请在这里编写您的程序（以上代码仅作参考）——
		 } catch (Exception e) {
				// TODO: handle exception
			 message = "fail";
		}
		return message;
		
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
