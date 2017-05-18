/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.suncity.service.warehouse.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.suncity.dao.warehouse.WarehouseMapper;
import com.suncity.model.warehouse.Warehouse;
import com.suncity.pub.util.MyDateUtil;
import com.suncity.service.warehouse.IWarehouseService;

/**   
 * @Description: 友情链接Service 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("warehouseService") 
public class WarehouseService implements IWarehouseService {
	//友情链接Mapper
	@Resource
	private WarehouseMapper warehouseMapper;
	
	/*
	 * (non-Javadoc)
	 * <p>Title: updateWarehouse</p> 
	 * <p>Description: </p> 
	 * @param warehouse
	 * @return 
	 * @see ujn.school.cn.service.warehouse.IWarehouseService#updateWarehouse(ujn.school.cn.model.warehouse.Warehouse)
	 */
	@Override
	public int updateWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method stub
		return warehouseMapper.updateByPrimaryKeySelective(warehouse);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryWarehouseById</p> 
	 * <p>Description: </p> 
	 * @param warehouseId
	 * @return 
	 * @see ujn.school.cn.service.warehouse.IWarehouseService#queryWarehouseById(int)
	 */
	@Override
	public Warehouse queryWarehouseById(int warehouseId) {
		// TODO Auto-generated method stub
		return warehouseMapper.selectByPrimaryKey(warehouseId);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryWarehouseList</p> 
	 * <p>Description: </p> 
	 * @param warehouse
	 * @return 
	 * @see ujn.school.cn.service.warehouse.IWarehouseService#queryWarehouseList(ujn.school.cn.model.warehouse.Warehouse)
	 */
	@Override
	public List<Warehouse> queryWarehouseList(Warehouse warehouse) {
		// TODO Auto-generated method stub
		return warehouseMapper.queryWarehouseList(warehouse);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: addWarehouse</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param warehouse
	 * @return 
	 * @see ujn.school.cn.service.warehouse.IWarehouseService#addWarehouse(javax.servlet.http.HttpServletRequest, ujn.school.cn.model.warehouse.Warehouse)
	 */
	@Override
	public int addWarehouse(HttpServletRequest request,Warehouse warehouse) {
		//创建时间
		warehouse.setPurchase_date(MyDateUtil.getDateTime());
		return warehouseMapper.insert(warehouse);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: deleteWarehouse</p> 
	 * <p>Description: </p> 
	 * @param warehouseId
	 * @return 
	 * @see ujn.school.cn.service.warehouse.IWarehouseService#deleteWarehouse(int)
	 */
	@Override
	public int deleteWarehouse(int warehouseId) {
		
		return warehouseMapper.deleteByPrimaryKey(warehouseId);
	}

	@Override
	public List<Warehouse> queryWarehouseListByType(String type) {
		// TODO Auto-generated method stub
		return warehouseMapper.queryWarehouseListByType(type);
	}

	@Override
	public int updateWarehouseForUse(Warehouse warehouse) {
		// TODO Auto-generated method stub
		return warehouseMapper.updateWarehouseForUse(warehouse);
	}


}
