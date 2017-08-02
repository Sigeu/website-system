/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.controller.order;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.yuanyuansinian.alipay.config.AlipayConfig;
import com.yuanyuansinian.model.column.Column;
import com.yuanyuansinian.model.member.Member;
import com.yuanyuansinian.model.order.Order;
import com.yuanyuansinian.model.product.Product;
import com.yuanyuansinian.model.warehouse.Warehouse;
import com.yuanyuansinian.pub.base.MyBaseController;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.column.IColumnService;
import com.yuanyuansinian.service.order.IOrderService;
import com.yuanyuansinian.service.product.IProductService;
import com.yuanyuansinian.service.warehouse.IWarehouseService;
import com.yuanyuansinian.tenpay.config.MyConfig;

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
	
	@Resource
	private IWarehouseService warehouseService;
	
	@Resource
	private IProductService productService;

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
	 * @Description: 支付宝通知
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/notifyUrl")
	public String notifyUrl(HttpServletRequest request) {
		//获取登录的会员
		Member memberUser = super.getSessionMemberUser(request);
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
				//商户订单号：所有的订单
				String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			
				//支付宝交易号
				String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			
				//交易状态
				String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
				//纪念馆ID
				String hallId = new String(request.getParameter("sys_service_provider_id").getBytes("ISO-8859-1"),"UTF-8");
				
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
					Order order = new Order();
					order.setOrder_num(out_trade_no);
					//支付成功
					order.setStatus(IMySystemConstants.VALUE_1);
					order.setHall_id(hallId);
					//支付宝订单号
					order.setTrade_no(trade_no);
					this.orderService.updateOrderByOrderNum(order);
					
					//更新仓库
					Order orderData = this.orderService.queryOrderByOrderNum(out_trade_no);
					if(null != orderData){
						//购买的所有产品id
						String[] idArray = orderData.getProduct_id().split(",");
						Warehouse warehouse = null;
						Product product = null;
						for(String product_id : idArray){
							product = new Product();
							product = this.productService.queryProductById(Integer.parseInt(product_id));
							warehouse = new Warehouse();
							warehouse.setOrder_id(out_trade_no);
							warehouse.setProduct_id(product_id);
							warehouse.setPurchase_date(MyDateUtil.getDateTime());
							warehouse.setUse_date(MyDateUtil.getDateTime());
							warehouse.setMember_id(memberUser.getId()+"");
							//有效期
							warehouse.setValidity_day(product.getValidity_day()==null? DAYS_:product.getValidity_day());
							warehouse.setEnd_date(MyDateUtil.addDay(MyDateUtil.getDate(), Integer.parseInt(product.getValidity_day()==null? DAYS_:product.getValidity_day())));
							if(null != orderData.getHall_id() && !"".equals(orderData.getHall_id())){
								//正在使用
								warehouse.setUse_status(IMySystemConstants.VALUE_1);
								warehouse.setHall_id(orderData.getHall_id());
							}else{
								//未使用
								warehouse.setUse_status(IMySystemConstants.VALUE_0);
								warehouse.setHall_id("");
							}
							
							warehouse.setProduct_type(product.getType());
							
							this.warehouseService.addWarehouse(null, warehouse);
						}
						
					}
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
			 e.printStackTrace();
			 message = "fail";
		}
		return message;
		
	}
	
	
	//接收支付返回信息
	@RequestMapping("/returnUrl")
	public String returnUrl(HttpServletRequest request) {
		//获取登录的会员
		Member memberUser = super.getSessionMemberUser(request);
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
			 /* *
			  * 功能：支付宝服务器同步通知页面
			  * 日期：2017-03-30
			  * 说明：
			  * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
			  * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。


			  *************************页面功能说明*************************
			  * 该页面仅做页面展示，业务逻辑处理请勿在该页面执行
			  */
			  
			 	//获取支付宝GET过来反馈信息
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
			 	if(signVerified) {
			 		//商户订单号
			 		String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			 	
			 		//支付宝交易号
			 		String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			 	
			 		//付款金额
			 		//String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
			 		//纪念馆ID
					//String hallId = new String(request.getParameter("sys_service_provider_id").getBytes("ISO-8859-1"),"UTF-8");
					
					//
					Order order = new Order();
					order.setOrder_num(out_trade_no);
					//支付成功
					order.setStatus(IMySystemConstants.VALUE_1);
					//order.setHall_id(hallId);
					//支付宝订单号
					order.setTrade_no(trade_no);
					this.orderService.updateOrderByOrderNum(order);
					//添加仓库
					Order orderData = this.orderService.queryOrderByOrderNum(out_trade_no);
					if(null != orderData){
						//购买的所有产品id
						String[] idArray = orderData.getProduct_id().split(",");
						Warehouse warehouse = null;
						Product product = null;
						for(String product_id : idArray){
							product = new Product();
							product = this.productService.queryProductById(Integer.parseInt(product_id));
							warehouse = new Warehouse();
							warehouse.setOrder_id(out_trade_no);
							warehouse.setProduct_id(product_id);
							warehouse.setPurchase_date(MyDateUtil.getDateTime());
							warehouse.setUse_date(MyDateUtil.getDateTime());
							warehouse.setMember_id(memberUser.getId()+"");
							//有效期
							warehouse.setValidity_day(product.getValidity_day()==null? DAYS_:product.getValidity_day());
							warehouse.setEnd_date(MyDateUtil.addDay(MyDateUtil.getDate(), Integer.parseInt(product.getValidity_day()==null? DAYS_:product.getValidity_day())));
							if(null != orderData.getHall_id() && !"".equals(orderData.getHall_id())){
								//正在使用
								warehouse.setUse_status(IMySystemConstants.VALUE_1);
								warehouse.setHall_id(orderData.getHall_id());
							}else{
								//未使用
								warehouse.setUse_status(IMySystemConstants.VALUE_0);
								warehouse.setHall_id("");
							}
							warehouse.setProduct_type(product.getType());
							this.warehouseService.addWarehouse(null, warehouse);
						}
						
					}
					message = "redirect:/sinian/index/indexController/toMemberWarehouse";
					
			 		//out.println("trade_no:"+trade_no+"<br/>out_trade_no:"+out_trade_no+"<br/>total_amount:"+total_amount);
			 	}else {
			 		//out.println("验签失败");
			 		message = "redirect:/sinian/index/indexController/toMemberWarehouse";
			 	}
			 	//——请在这里编写您的程序（以上代码仅作参考）——
		 } catch (Exception e) {
				// TODO: handle exception
			 e.printStackTrace();
			 message = "redirect:/sinian/index/indexController/toMemberWarehouse";
		}
		return message;
		
	}

	
	/**
	 * 
	 * @Description: 微信支付通知 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/notifyUrlForTenpay")
	public String notifyUrlForTenpay(HttpServletRequest request,HttpServletResponse response) {
		String message = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
		try {
			//获取登录的会员
			Member memberUser = super.getSessionMemberUser(request);
			//读取参数  
		    InputStream inputStream ;  
		    StringBuffer sb = new StringBuffer();  
		    inputStream = request.getInputStream();  
		    String s ;  
		    BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));  
		    while ((s = in.readLine()) != null){  
		        sb.append(s);  
		    }  
		    in.close();  
		    inputStream.close();  
		  
		    
		    //判断签名是否正确  
	        String notifyData = sb.toString(); // 支付结果通知的xml格式数据
	
	        MyConfig config = new MyConfig();
	        WXPay wxpay = new WXPay(config);
	
	        Map<String, String> notifyMap = WXPayUtil.xmlToMap(notifyData);  // 转换成map
	
	        if (wxpay.isPayResultNotifySignatureValid(notifyMap)) {
	            // 签名正确
	            // 进行处理。
	            // 注意特殊情况：订单已经退款，但收到了支付结果成功的通知，不应把商户侧订单状态从退款改成支付成功
	        	
	        	//商户订单号
		 		String out_trade_no = notifyMap.get("out_trade_no");
		 	
		 		//微信支付订单号
		 		String trade_no = notifyMap.get("transaction_id");
				//
				Order order = new Order();
				order.setOrder_num(out_trade_no);
				//支付成功
				order.setStatus(IMySystemConstants.VALUE_1);
				//order.setHall_id(hallId);
				//微信订单号
				order.setTrade_no(trade_no);
				this.orderService.updateOrderByOrderNum(order);
				//添加仓库
				Order orderData = this.orderService.queryOrderByOrderNum(out_trade_no);
				System.out.println("out_trade_no:" + out_trade_no + "------");
				if(null != orderData){
					//购买的所有产品id
					String[] idArray = orderData.getProduct_id().split(",");
					Warehouse warehouse = null;
					Product product = null;
					for(String product_id : idArray){
						System.out.println("product_id:" + product_id + "------");
						product = new Product();
						product = this.productService.queryProductById(Integer.parseInt(product_id));
						warehouse = new Warehouse();
						warehouse.setOrder_id(out_trade_no);
						warehouse.setProduct_id(product_id);
						warehouse.setPurchase_date(MyDateUtil.getDateTime());
						warehouse.setUse_date(MyDateUtil.getDateTime());
						warehouse.setMember_id(memberUser.getId()+"");
						//有效期
						warehouse.setValidity_day(product.getValidity_day()==null? DAYS_:product.getValidity_day());
						warehouse.setEnd_date(MyDateUtil.addDay(MyDateUtil.getDate(), Integer.parseInt(product.getValidity_day()==null? DAYS_:product.getValidity_day())));
						if(null != orderData.getHall_id() && !"".equals(orderData.getHall_id())){
							//正在使用
							warehouse.setUse_status(IMySystemConstants.VALUE_1);
							warehouse.setHall_id(orderData.getHall_id());
						}else{
							//未使用
							warehouse.setUse_status(IMySystemConstants.VALUE_0);
							warehouse.setHall_id("");
						}
						warehouse.setProduct_type(product.getType());
						this.warehouseService.addWarehouse(request, warehouse);
						System.out.println("添加仓库---------------");
					}
					
				}
				message = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
	        }
	        else {
	            // 签名错误，如果数据里没有sign字段，也认为是签名错误
	        	 System.out.println("通知签名验证失败---时间::::"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	        	 message = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[签名验证失败]]></return_msg></xml>";
	        }
	        
	        //处理业务完毕  
	        BufferedOutputStream out = new BufferedOutputStream(  
	                response.getOutputStream());  
	        out.write(message.getBytes());  
	        out.flush();  
	        out.close(); 
        
		} catch (Exception e) {
			// TODO: handle exception
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
