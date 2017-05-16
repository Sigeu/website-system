/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.gift.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.yuanyuansinian.dao.gift.HallGiftMapper;
import com.yuanyuansinian.model.gift.HallGift;
import com.yuanyuansinian.service.gift.IHallGiftService;

/**   
 * @Description: 纪念馆灵堂礼物Service 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("hallGiftService") 
public class HallGiftService implements IHallGiftService {
	//纪念馆灵堂礼物Mapper
	@Resource
	private HallGiftMapper hallGiftMapper;
	
	/*
	 * (non-Javadoc)
	 * <p>Title: updateHallGift</p> 
	 * <p>Description: </p> 
	 * @param hallGift
	 * @return 
	 * @see ujn.school.cn.service.hallGift.IHallGiftService#updateHallGift(ujn.school.cn.model.hallGift.HallGift)
	 */
	@Override
	public int updateHallGift(HallGift hallGift) {
		// TODO Auto-generated method stub
		return hallGiftMapper.updateByPrimaryKeySelective(hallGift);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryHallGiftById</p> 
	 * <p>Description: </p> 
	 * @param hallGiftId
	 * @return 
	 * @see ujn.school.cn.service.hallGift.IHallGiftService#queryHallGiftById(int)
	 */
	@Override
	public HallGift queryHallGiftById(int hallGiftId) {
		// TODO Auto-generated method stub
		return hallGiftMapper.selectByPrimaryKey(hallGiftId);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryHallGiftList</p> 
	 * <p>Description: </p> 
	 * @param hallGift
	 * @return 
	 * @see ujn.school.cn.service.hallGift.IHallGiftService#queryHallGiftList(ujn.school.cn.model.hallGift.HallGift)
	 */
	@Override
	public List<HallGift> queryHallGiftList(HallGift hallGift) {
		// TODO Auto-generated method stub
		return hallGiftMapper.queryHallGiftList(hallGift);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: addHallGift</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param hallGift
	 * @return 
	 * @see ujn.school.cn.service.hallGift.IHallGiftService#addHallGift(javax.servlet.http.HttpServletRequest, ujn.school.cn.model.hallGift.HallGift)
	 */
	@Override
	public int addHallGift(HttpServletRequest request,HallGift hallGift) {
		
		return hallGiftMapper.insert(hallGift);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: deleteHallGift</p> 
	 * <p>Description: </p> 
	 * @param hallGiftId
	 * @return 
	 * @see ujn.school.cn.service.hallGift.IHallGiftService#deleteHallGift(int)
	 */
	@Override
	public int deleteHallGift(int hallGiftId) {
		
		return hallGiftMapper.deleteByPrimaryKey(hallGiftId);
	}


	@Override
	public List<HallGift> queryHallGiftListByType(String type) {
		// TODO Auto-generated method stub
		return hallGiftMapper.queryHallGiftListByType(type);
	}

	@Override
	public List<HallGift> queryHallGiftListForHall(int hallId, int limitNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hallId", hallId);
		map.put("limitNum", limitNum);
		return hallGiftMapper.queryHallGiftListForHall(map);
	}

}
