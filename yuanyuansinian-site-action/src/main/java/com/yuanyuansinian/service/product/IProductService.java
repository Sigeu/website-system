/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yuanyuansinian.model.product.Product;
import com.yuanyuansinian.model.product.ProductWithBLOBs;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:49:54
 * @version V1.0
 */
public interface IProductService {

	/**
	 * 
	 * @Description: 更新
	 * @param product
	 * @return
	 */
	int updateProduct(ProductWithBLOBs product);

	/**
	 * 
	 * @Description: 根据ID查询
	 * @param productId
	 * @return
	 */
	ProductWithBLOBs  queryProductById(int productId);

	/**
	 * 
	 * @Description: 分页列表
	 * @param product
	 * @return
	 */
	List<Product> queryProductList(Product product);

	/**
	 * 
	 * @Description: 添加 
	 * @param request
	 * @param product
	 * @return
	 */
	int addProduct(HttpServletRequest request, ProductWithBLOBs product);

	/**
	 * 
	 * @Description: 删除
	 * @param productId
	 * @return
	 */
	int deleteProduct(int productId);

	List<Product> queryProductRecycleList(Product product);

	List<Product> queryProductListByType(String type);

	int recoverProduct(int productId);

	void uploadImg(HttpServletRequest request, String id);


}
