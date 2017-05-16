/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.gift;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yuanyuansinian.model.gift.HallGift;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:49:54
 * @version V1.0
 */
public interface IHallGiftService {

	/**
	 * 
	 * @Description: 更新
	 * @param hallGift
	 * @return
	 */
	int updateHallGift(HallGift hallGift);

	/**
	 * 
	 * @Description: 根据ID查询
	 * @param hallGiftId
	 * @return
	 */
	HallGift  queryHallGiftById(int hallGiftId);

	/**
	 * 
	 * @Description: 分页列表
	 * @param hallGift
	 * @return
	 */
	List<HallGift> queryHallGiftList(HallGift hallGift);

	/**
	 * 
	 * @Description: 添加 
	 * @param request
	 * @param hallGift
	 * @return
	 */
	int addHallGift(HttpServletRequest request, HallGift hallGift);

	/**
	 * 
	 * @Description: 删除
	 * @param hallGiftId
	 * @return
	 */
	int deleteHallGift(int hallGiftId);

	List<HallGift> queryHallGiftListByType(String type);

	List<HallGift> queryHallGiftListForHall(int hallId , int limitNum);

}
