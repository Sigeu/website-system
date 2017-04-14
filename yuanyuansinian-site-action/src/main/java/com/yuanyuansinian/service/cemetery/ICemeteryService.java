/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.cemetery;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yuanyuansinian.model.cemetery.Cemetery;
import com.yuanyuansinian.model.cemetery.CemeteryWithBLOBs;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:49:54
 * @version V1.0
 */
public interface ICemeteryService {

	/**
	 * 
	 * @Description: 更新
	 * @param cemetery
	 * @return
	 */
	int updateCemetery(CemeteryWithBLOBs cemetery);

	/**
	 * 
	 * @Description: 根据ID查询
	 * @param cemeteryId
	 * @return
	 */
	Cemetery  queryCemeteryById(int cemeteryId);

	/**
	 * 
	 * @Description: 分页列表
	 * @param cemetery
	 * @return
	 */
	List<Cemetery> queryCemeteryList(Cemetery cemetery);

	/**
	 * 
	 * @Description: 添加 
	 * @param request
	 * @param cemetery
	 * @return
	 */
	int addCemetery(HttpServletRequest request, CemeteryWithBLOBs cemetery);

	/**
	 * 
	 * @Description: 删除
	 * @param cemeteryId
	 * @return
	 */
	int deleteCemetery(int cemeteryId);


	List<Cemetery> queryCemeteryListByType(String cemetery_type);

	List<Cemetery> queryCemeteryListByMember(String memberId, int limtNum);

	List<Cemetery> queryCemeteryListByOpenType(Cemetery cemetery);

	List<Cemetery> queryCemeteryPageListByMember(Cemetery cemetery);

	void uploadCemeteryImg(HttpServletRequest request, String id);


}
