/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.hall;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yuanyuansinian.model.hall.HallDouble;
import com.yuanyuansinian.model.hall.HallDoubleWithBLOBs;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:49:54
 * @version V1.0
 */
public interface IHallDoubleService {

	/**
	 * 
	 * @Description: 更新
	 * @param hallDouble
	 * @return
	 */
	int updateHallDouble(HallDouble hallDouble);

	/**
	 * 
	 * @Description: 根据ID查询
	 * @param hallDoubleId
	 * @return
	 */
	HallDouble  queryHallDoubleById(int hallDoubleId);

	/**
	 * 
	 * @Description: 分页列表
	 * @param hallDouble
	 * @return
	 */
	List<HallDouble> queryHallDoubleList(HallDouble hallDouble);

	/**
	 * 
	 * @Description: 删除
	 * @param hallDoubleId
	 * @return
	 */
	int deleteHallDouble(int hallDoubleId);


	List<HallDouble> queryHallDoubleListByType(HallDouble hallDouble);

	List<HallDouble> queryHallDoubleListByMember(String memberId, int limtNum);

	List<HallDouble> queryHallDoubleListByOpenType(String open_type);

	List<HallDouble> queryHallDoublePageListByMember(HallDouble hallDouble);

	List<HallDouble> queryHallDoubleNewList(int countNum);

	List<HallDouble> queryHallDoubleListBySearch(String search_text);

	void addSingleHallDouble(HttpServletRequest request, HallDoubleWithBLOBs hallDouble);

	void addDoubleHallDouble(HttpServletRequest request, HallDoubleWithBLOBs hallDouble);

	void uploadImg(HttpServletRequest request, String id);



}
