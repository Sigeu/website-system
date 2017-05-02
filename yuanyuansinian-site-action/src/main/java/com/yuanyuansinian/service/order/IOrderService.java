/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yuanyuansinian.model.order.Order;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:49:54
 * @version V1.0
 */
public interface IOrderService {

	/**
	 * 
	 * @Description: 更新
	 * @param order
	 * @return
	 */
	int updateOrder(Order order);

	/**
	 * 
	 * @Description: 根据ID查询
	 * @param orderId
	 * @return
	 */
	Order  queryOrderById(int orderId);

	/**
	 * 
	 * @Description: 分页列表
	 * @param order
	 * @return
	 */
	List<Order> queryOrderList(Order order);

	/**
	 * 
	 * @Description: 添加 
	 * @param request
	 * @param order
	 * @return
	 */
	int addOrder(HttpServletRequest request, Order order);

	/**
	 * 
	 * @Description: 删除
	 * @param orderId
	 * @return
	 */
	int deleteOrder(int orderId);


	List<Order> queryOrderListByType(Order order);

	List<Order> queryOrderListByMember(String memberId, int limtNum);


}
