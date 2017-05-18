/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.suncity.controller.product;

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
import com.suncity.model.product.Product;
import com.suncity.model.product.ProductWithBLOBs;
import com.suncity.pub.base.MyBaseController;
import com.suncity.pub.constants.IMySystemConstants;
import com.suncity.pub.util.MyDateUtil;
import com.suncity.service.column.IColumnService;
import com.suncity.service.product.IProductService;

import framework.system.model.Code;
import framework.system.pub.util.DataTablePageUtil;
import framework.system.service.ICodeService;

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
	
	@Resource
	private ICodeService codeService;

	/**
	 * 
	 * @Description: 跳转到商城产品分页列表
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
	 * @Description: 跳转到纪念馆产品列表 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallProductList")
	public String toHallProductList(HttpServletRequest request, Model model) {

		return "product/hallProductList";
	}
	/**
	 * 
	 * @Description: 跳转到礼品列表 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toProductListForHall")
	public String toProductListForHall(HttpServletRequest request, Model model) {

		return "product/productListForHall";
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
	 * @Description: 跳转到商城产品新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toProductAdd")
	public String toProductAdd(HttpServletRequest request, Model model) {
		//产品小类
		List<Code> codeList = codeService.queryCodeListByType("product_type");
		
		model.addAttribute("codeList", codeList);
		//产品大类
		model.addAttribute("big_type", IMySystemConstants.VALUE_1);
		
		return "product/productAdd";
	}
	
	/**
	 * 
	 * @Description: 跳转到纪念馆产品新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallProductAdd")
	public String toHallProductAdd(HttpServletRequest request, Model model) {
		//产品小类
		List<Code> codeList = codeService.queryCodeListByType("hall_type");
		
		model.addAttribute("codeList", codeList);
		//产品大类
		model.addAttribute("big_type", IMySystemConstants.VALUE_2);
		
		return "product/hallProductAdd";
	}

	/**
	 * 
	 * @Description: 跳转到商城产品修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toProductUpdate")
	public String toProductUpdate(HttpServletRequest request, Model model) {
		int productId = Integer.parseInt(request.getParameter("id"));
		Product product = this.productService.queryProductById(productId);
		model.addAttribute("product", product);
		
		//List<Code> codeList = codeService.queryCodeListByType("product_type");
		//model.addAttribute("codeList", codeList);
		//产品大类
		//List<Code> bigTypeCodeList = codeService.queryCodeListByType("big_type");
		//model.addAttribute("bigTypeCodeList", bigTypeCodeList);
		
		
		return "product/productUpdate";
	}
	
	/**
	 * 
	 * @Description: 跳转到纪念馆产品修改页面 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallProductUpdate")
	public String toHallProductUpdate(HttpServletRequest request, Model model) {
		int productId = Integer.parseInt(request.getParameter("id"));
		Product product = this.productService.queryProductById(productId);
		model.addAttribute("product", product);
		
		return "product/hallProductUpdate";
	}

	/**
	 * 
	 * @Description: 跳转到商城产品明细页面
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
	 * @Description: 跳转到纪念馆产品明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallProductDetail")
	public String toHallProductDetail(HttpServletRequest request, Model model) {
		int productId = Integer.parseInt(request.getParameter("id"));
		ProductWithBLOBs  product = this.productService.queryProductById(productId);
		model.addAttribute("product", product);

		return "product/hallProductDetail";
	}

	/**
	 * 
	 * @Description: 商城产品分页列表
	 * @param request
	 * @param response
	 * @param product
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryProductList")
	public DataTablePageUtil<Product> queryProductList(HttpServletRequest request,
			HttpServletResponse response, Product product) {
		//商城产品
		product.setBig_type(IMySystemConstants.VALUE_1);
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
	 * @Description: 纪念馆产品列表 
	 * @param request
	 * @param response
	 * @param product
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryHallProductList")
	public DataTablePageUtil<Product> queryHallProductList(HttpServletRequest request,
			HttpServletResponse response, Product product) {
		//纪念馆产品
		product.setBig_type(IMySystemConstants.VALUE_2);
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
	 * @Description: 礼品分页列表
	 * @param request
	 * @param response
	 * @param product
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryProductListForHall")
	public DataTablePageUtil<Product> queryProductListForHall(HttpServletRequest request,
			HttpServletResponse response, Product product) {
		//纪念馆产品
		product.setBig_type(IMySystemConstants.VALUE_2);
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
	 * @Description: 添加商城产品
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
			map.put("model_id", product.getId());
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}
	/**
	 * 
	 * @Description: 封面上传 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/uploadImg")
	public Map<String, Object> uploadImg(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String id = nullToStringZero(request.getParameter("model_id"));
			//保存数据
			productService.uploadImg(request, id);
			
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}
	
	/**
	 * 
	 * @Description: 商城产品修改
	 * @param request
	 * @param product
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateProduct")
	public Map<String, Object> updateProduct(HttpServletRequest request, ProductWithBLOBs product) {

		Map<String, Object> map = new HashMap<String, Object>();
		product.setCreate_date(MyDateUtil.getDateTime());
		map.put("model_id", product.getId());
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
	 * @Description: 产品删除
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
	
}
