/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.suncity.service.cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.suncity.model.cart.Cart;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:49:54
 * @version V1.0
 */
public interface ICartService {

	/**
	 * 
	 * @Description: 更新
	 * @param cart
	 * @return
	 */
	int updateCart(Cart cart);

	/**
	 * 
	 * @Description: 根据ID查询
	 * @param cartId
	 * @return
	 */
	Cart  queryCartById(int cartId);

	/**
	 * 
	 * @Description: 分页列表
	 * @param cart
	 * @return
	 */
	List<Cart> queryCartList(Cart cart);

	/**
	 * 
	 * @Description: 添加 
	 * @param request
	 * @param cart
	 * @return
	 */
	int addCart(HttpServletRequest request, Cart cart);

	/**
	 * 
	 * @Description: 删除
	 * @param cartId
	 * @return
	 */
	int deleteCart(int cartId);


	List<Cart> queryCartListByType(Cart cart);

	List<Cart> queryCartListByMember(String memberId, int limtNum);

}
