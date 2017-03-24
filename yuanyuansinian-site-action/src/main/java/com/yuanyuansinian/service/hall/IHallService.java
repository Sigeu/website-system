/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.hall;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yuanyuansinian.model.hall.Hall;
import com.yuanyuansinian.model.hall.HallWithBLOBs;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:49:54
 * @version V1.0
 */
public interface IHallService {

	/**
	 * 
	 * @Description: 更新
	 * @param hall
	 * @return
	 */
	int updateHall(Hall hall);

	/**
	 * 
	 * @Description: 根据ID查询
	 * @param hallId
	 * @return
	 */
	Hall  queryHallById(int hallId);

	/**
	 * 
	 * @Description: 分页列表
	 * @param hall
	 * @return
	 */
	List<Hall> queryHallList(Hall hall);

	/**
	 * 
	 * @Description: 删除
	 * @param hallId
	 * @return
	 */
	int deleteHall(int hallId);


	List<Hall> queryHallListByType(Hall hall);

	List<Hall> queryHallListByMember(String memberId, int limtNum);

	List<Hall> queryHallListByOpenType(String open_type);

	List<Hall> queryHallPageListByMember(Hall hall);

	List<Hall> queryHallNewList(int countNum);

	List<Hall> queryHallListBySearch(String search_text);

	void addSingleHall(HttpServletRequest request, HallWithBLOBs hall);

	void addDoubleHall(HttpServletRequest request, HallWithBLOBs hall);

	void uploadSingleHallImg(HttpServletRequest request, String hall_id);


}
