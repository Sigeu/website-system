/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.controller.product;

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
import com.yuanyuansinian.model.product.Product;
import com.yuanyuansinian.model.product.ProductWithBLOBs;
import com.yuanyuansinian.pub.base.MyBaseController;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.column.IColumnService;
import com.yuanyuansinian.service.product.IProductService;

import framework.system.pub.util.DataTablePageUtil;

/**
 * @Description: 产品管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/sinian/product/productController")
public class ProductController extends MyBaseController {
	// 产品Service
	@Resource
	private IProductService productService;
	
	@Resource
	private IColumnService columnService;

	/**
	 * 
	 * @Description: 跳转到分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toProductList")
	public String toProductList(HttpServletRequest request, Model model) {

		return "product/productList";
	}
	
	/**
	 * 
	 * @Description: 跳转到产品回收站列表 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toProductRecycleList")
	public String toProductRecycleList(HttpServletRequest request, Model model) {

		return "product/productRecycleList";
	}

	/**
	 * 
	 * @Description: 跳转到新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toProductAdd")
	public String toProductAdd(HttpServletRequest request, Model model) {
		
		
		return "product/productAdd";
	}

	/**
	 * 
	 * @Description: 跳转到修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toProductUpdate")
	public String toProductUpdate(HttpServletRequest request, Model model) {
		int productId = Integer.parseInt(request.getParameter("id"));
		Product product = this.productService.queryProductById(productId);
		model.addAttribute("product", product);
		
		
		return "product/productUpdate";
	}
	

	/**
	 * 
	 * @Description: 跳转到明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toProductDetail")
	public String toProductDetail(HttpServletRequest request, Model model) {
		int productId = Integer.parseInt(request.getParameter("id"));
		ProductWithBLOBs  product = this.productService.queryProductById(productId);
		model.addAttribute("product", product);

		return "product/productDetail";
	}

	/**
	 * 
	 * @Description: 分页列表
	 * @param request
	 * @param response
	 * @param product
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryProductList")
	public DataTablePageUtil<Product> queryProductList(HttpServletRequest request,
			HttpServletResponse response, Product product) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Product> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Product>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Product> productList = this.productService.queryProductList(product);
			// 用PageInfo对结果进行包装
			PageInfo<Product> pageInfo = new PageInfo<Product>(productList);

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
	 * @Description: 产品回收站
	 * @param request
	 * @param response
	 * @param product
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryProductRecycleList")
	public DataTablePageUtil<Product> queryProductRecycleList(HttpServletRequest request,
			HttpServletResponse response, Product product) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Product> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Product>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Product> productList = this.productService.queryProductRecycleList(product);
			// 用PageInfo对结果进行包装
			PageInfo<Product> pageInfo = new PageInfo<Product>(productList);

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
	 * @param product
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addProduct")
	public Map<String, Object> addProduct(HttpServletRequest request, ProductWithBLOBs product) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//发布人
			//product.setIssue(getSessionUser(request).getLogin_name());
			//默认状态为“0”：待审核
			product.setStatus(IMySystemConstants.VALUE_0);
			productService.addProduct(request, product);
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
	 * @param product
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateProduct")
	public Map<String, Object> updateProduct(HttpServletRequest request, ProductWithBLOBs product) {

		Map<String, Object> map = new HashMap<String, Object>();
		product.setCreate_date(MyDateUtil.getDateTime());
		int count = this.productService.updateProduct(product);
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
	@RequestMapping("/deleteProduct")
	public Map<String, Object> deleteProduct(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int productId = Integer.parseInt(request.getParameter("id"));
		int count = this.productService.deleteProduct(productId);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, DELETE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, DELETE_FAILED_MESSAGE);
		}
		return map;
	}
	
	/**
	 * 
	 * @Description: 恢复产品 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/recoverProduct")
	public Map<String, Object> recoverProduct(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int productId = Integer.parseInt(request.getParameter("id"));
		int count = this.productService.recoverProduct(productId);
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
