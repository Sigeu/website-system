/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.suncity.controller.cart;

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
import com.suncity.model.cart.Cart;
import com.suncity.model.column.Column;
import com.suncity.model.member.Member;
import com.suncity.pub.base.MyBaseController;
import com.suncity.pub.constants.IMySystemConstants;
import com.suncity.pub.util.MyDateUtil;
import com.suncity.service.cart.ICartService;
import com.suncity.service.column.IColumnService;

import framework.system.pub.util.DataTablePageUtil;

/**
 * @Description: 产品管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/sinian/cart/cartController")
public class CartController extends MyBaseController {
	// 产品Service
	@Resource
	private ICartService cartService;
	
	@Resource
	private IColumnService columnService;

	/**
	 * 
	 * @Description: 跳转到分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCartList")
	public String toCartList(HttpServletRequest request, Model model) {

		return "cart/cartList";
	}
	
	/**
	 * 
	 * @Description: 跳转到产品回收站列表 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCartRecycleList")
	public String toCartRecycleList(HttpServletRequest request, Model model) {

		return "cart/cartRecycleList";
	}

	/**
	 * 
	 * @Description: 跳转到新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCartAdd")
	public String toCartAdd(HttpServletRequest request, Model model) {
		
		
		return "cart/cartAdd";
	}

	/**
	 * 
	 * @Description: 跳转到修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCartUpdate")
	public String toCartUpdate(HttpServletRequest request, Model model) {
		int cartId = Integer.parseInt(request.getParameter("id"));
		Cart cart = this.cartService.queryCartById(cartId);
		model.addAttribute("cart", cart);
		
		return "cart/cartUpdate";
	}
	

	/**
	 * 
	 * @Description: 跳转到明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCartDetail")
	public String toCartDetail(HttpServletRequest request, Model model) {
		int cartId = Integer.parseInt(request.getParameter("id"));
		Cart  cart = this.cartService.queryCartById(cartId);
		model.addAttribute("cart", cart);

		return "cart/cartDetail";
	}

	/**
	 * 
	 * @Description: 分页列表
	 * @param request
	 * @param response
	 * @param cart
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryCartList")
	public DataTablePageUtil<Cart> queryCartList(HttpServletRequest request,
			HttpServletResponse response, Cart cart) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Cart> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Cart>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Cart> cartList = this.cartService.queryCartList(cart);
			// 用PageInfo对结果进行包装
			PageInfo<Cart> pageInfo = new PageInfo<Cart>(cartList);

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
	 * @param cart
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addCart")
	public Map<String, Object> addCart(HttpServletRequest request, Cart cart) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//获取登录的会员
			Member memberUser = super.getSessionMemberUser(request);
			if(null == memberUser){
				//return "redirect:/sinian/index/indexController/toMemberLogin";
				map.put(RESULT_MESSAGE_STRING, "请登录后购买！");
				map.put("flag", "0");
			}else{
				cart.setMember_id(memberUser.getId().toString());
				cart.setProduct_num(IMySystemConstants.COUNT_NUM1);
				cartService.addCart(request, cart);
				map.put(RESULT_MESSAGE_STRING, "加入购物车成功");
				map.put("flag", "1");
			}
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
	 * @param cart
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateCart")
	public Map<String, Object> updateCart(HttpServletRequest request, Cart cart) {

		Map<String, Object> map = new HashMap<String, Object>();
		cart.setCreate_date(MyDateUtil.getDateTime());
		int count = this.cartService.updateCart(cart);
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
	@RequestMapping("/deleteCart")
	public Map<String, Object> deleteCart(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int cartId = Integer.parseInt(request.getParameter("id"));
		int count = this.cartService.deleteCart(cartId);
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
