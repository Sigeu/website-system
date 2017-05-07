/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.cart.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.yuanyuansinian.dao.cart.CartMapper;
import com.yuanyuansinian.model.cart.Cart;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.cart.ICartService;

/**   
 * @Description: 友情链接Service 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("cartService") 
public class CartService implements ICartService {
	//友情链接Mapper
	@Resource
	private CartMapper cartMapper;
	
	/*
	 * (non-Javadoc)
	 * <p>Title: updateCart</p> 
	 * <p>Description: </p> 
	 * @param cart
	 * @return 
	 * @see ujn.school.cn.service.cart.ICartService#updateCart(ujn.school.cn.model.cart.Cart)
	 */
	@Override
	public int updateCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartMapper.updateByPrimaryKey(cart);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryCartById</p> 
	 * <p>Description: </p> 
	 * @param cartId
	 * @return 
	 * @see ujn.school.cn.service.cart.ICartService#queryCartById(int)
	 */
	@Override
	public Cart queryCartById(int cartId) {
		// TODO Auto-generated method stub
		return cartMapper.selectByPrimaryKey(cartId);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryCartList</p> 
	 * <p>Description: </p> 
	 * @param cart
	 * @return 
	 * @see ujn.school.cn.service.cart.ICartService#queryCartList(ujn.school.cn.model.cart.Cart)
	 */
	@Override
	public List<Cart> queryCartList(Cart cart) {
		// TODO Auto-generated method stub
		return cartMapper.queryCartList(cart);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: addCart</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param cart
	 * @return 
	 * @see ujn.school.cn.service.cart.ICartService#addCart(javax.servlet.http.HttpServletRequest, ujn.school.cn.model.cart.CartWithBLOBs)
	 */
	@Override
	public int addCart(HttpServletRequest request,Cart cart) {
		int flag = 0;
		try {
			//先查询是否已经在购物车
			Cart cartProduct = cartMapper.selectByProductId(cart.getProduct_id());
			if(null == cartProduct){
				//创建时间
				cart.setCreate_date(MyDateUtil.getDateTime());
				flag = cartMapper.insert(cart);
			}else{
				flag = 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: deleteCart</p> 
	 * <p>Description: </p> 
	 * @param cartId
	 * @return 
	 * @see ujn.school.cn.service.cart.ICartService#deleteCart(int)
	 */
	@Override
	public int deleteCart(int cartId) {
		
		return cartMapper.deleteByPrimaryKey(cartId);
	}

	@Override
	public List<Cart> queryCartListByType(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> queryCartListByMember(String memberId, int limtNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_id", memberId);
		map.put("limtNum", limtNum);
		
		return cartMapper.queryCartListByMember(map);
	}

}
