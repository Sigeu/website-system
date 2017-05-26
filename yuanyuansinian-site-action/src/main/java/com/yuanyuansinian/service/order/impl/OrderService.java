/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.order.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.yuanyuansinian.dao.order.OrderMapper;
import com.yuanyuansinian.model.order.Order;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyAutoGenerateOrderNum;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.order.IOrderService;

/**
 * @Description: 友情链接Service
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:50:13
 * @version V1.0
 */
@Service("orderService")
public class OrderService implements IOrderService {
	// 友情链接Mapper
	@Resource
	private OrderMapper orderMapper;

	/*
	 * (non-Javadoc) <p>Title: updateOrder</p> <p>Description: </p>
	 * 
	 * @param order
	 * 
	 * @return
	 * 
	 * @see
	 * ujn.school.cn.service.order.IOrderService#updateOrder(ujn.school.cn.model
	 * .order.Order)
	 */
	@Override
	public int updateOrder(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.updateByPrimaryKey(order);
	}

	/*
	 * (non-Javadoc) <p>Title: queryOrderById</p> <p>Description: </p>
	 * 
	 * @param orderId
	 * 
	 * @return
	 * 
	 * @see ujn.school.cn.service.order.IOrderService#queryOrderById(int)
	 */
	@Override
	public Order queryOrderById(int orderId) {
		// TODO Auto-generated method stub
		return orderMapper.selectByPrimaryKey(orderId);
	}

	/*
	 * (non-Javadoc) <p>Title: queryOrderList</p> <p>Description: </p>
	 * 
	 * @param order
	 * 
	 * @return
	 * 
	 * @see
	 * ujn.school.cn.service.order.IOrderService#queryOrderList(ujn.school.cn
	 * .model.order.Order)
	 */
	@Override
	public List<Order> queryOrderList(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.queryOrderList(order);
	}

	/*
	 * (non-Javadoc) <p>Title: addOrder</p> <p>Description: </p>
	 * 
	 * @param request
	 * 
	 * @param order
	 * 
	 * @return
	 * 
	 * @see
	 * ujn.school.cn.service.order.IOrderService#addOrder(javax.servlet.http
	 * .HttpServletRequest, ujn.school.cn.model.order.Order)
	 */
	@Override
	public int addOrder(HttpServletRequest request, Order order) {
		// 创建时间
		order.setCreate_date(MyDateUtil.getDateTime());
		return orderMapper.insert(order);
	}

	/*
	 * (non-Javadoc) <p>Title: deleteOrder</p> <p>Description: </p>
	 * 
	 * @param orderId
	 * 
	 * @return
	 * 
	 * @see ujn.school.cn.service.order.IOrderService#deleteOrder(int)
	 */
	@Override
	public int deleteOrder(int orderId) {

		return orderMapper.deleteByPrimaryKey(orderId);
	}

	@Override
	public List<Order> queryOrderListByType(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.queryOrderListByType(order);
	}

	@Override
	public List<Order> queryOrderListByMember(String memberId, int limtNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_id", memberId);
		map.put("limtNum", limtNum);
		return orderMapper.queryOrderListByMember(map);
	}

	@Override
	public void addOrderByIds(HttpServletRequest request, String ids,
			String memberId, String count, String hallId) {
		Order order = null;
		for (String id : ids.split(",")) {
			order = new Order();
			// 订单号
			order.setOrder_num(MyAutoGenerateOrderNum.generateOrderNum(""));
			order.setMember_id(memberId);
			order.setProduct_id(id);
			order.setHall_id(hallId);
			// order.setProduct_price(product_price);
			order.setCreate_date(MyDateUtil.getDateTime());
			order.setStatus(IMySystemConstants.VALUE_0);
			orderMapper.insert(order);
		}
		
	}

	@Override
	public void updateOrderByOrderNum(Order order) {
		// TODO Auto-generated method stub
		orderMapper.updateOrderByOrderNum(order);
	}

	@Override
	public Order queryOrderByOrderNum(String order_num) {
		// TODO Auto-generated method stub
		return orderMapper.queryOrderByOrderNum(order_num);
	}

}
