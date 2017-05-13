/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.warehouse;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yuanyuansinian.model.warehouse.Warehouse;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:49:54
 * @version V1.0
 */
public interface IWarehouseService {

	/**
	 * 
	 * @Description: 更新
	 * @param warehouse
	 * @return
	 */
	int updateWarehouse(Warehouse warehouse);

	/**
	 * 
	 * @Description: 根据ID查询
	 * @param warehouseId
	 * @return
	 */
	Warehouse  queryWarehouseById(int warehouseId);

	/**
	 * 
	 * @Description: 分页列表
	 * @param warehouse
	 * @return
	 */
	List<Warehouse> queryWarehouseList(Warehouse warehouse);

	/**
	 * 
	 * @Description: 添加 
	 * @param request
	 * @param warehouse
	 * @return
	 */
	int addWarehouse(HttpServletRequest request, Warehouse warehouse);

	/**
	 * 
	 * @Description: 删除
	 * @param warehouseId
	 * @return
	 */
	int deleteWarehouse(int warehouseId);

	List<Warehouse> queryWarehouseListByType(String type);

	int updateWarehouseForUse(Warehouse warehouse);

}
