/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.oration;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yuanyuansinian.model.oration.Oration;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:49:54
 * @version V1.0
 */
public interface IOrationService {

	/**
	 * 
	 * @Description: 更新
	 * @param oration
	 * @return
	 */
	int updateOration(Oration oration);

	/**
	 * 
	 * @Description: 根据ID查询
	 * @param orationId
	 * @return
	 */
	Oration  queryOrationById(int orationId);

	/**
	 * 
	 * @Description: 分页列表
	 * @param oration
	 * @return
	 */
	List<Oration> queryOrationList(Oration oration);

	/**
	 * 
	 * @Description: 添加 
	 * @param request
	 * @param oration
	 * @return
	 */
	int addOration(HttpServletRequest request, Oration oration);

	/**
	 * 
	 * @Description: 删除
	 * @param orationId
	 * @return
	 */
	int deleteOration(int orationId);


	List<Oration> queryOrationListByType(Oration oration);

	List<Oration> queryOrationListByMember(String memberId, int limtNum);

	List<Oration> queryOrationListByOpenType(Oration oration);

	List<Oration> queryOrationPageListByMember(Oration oration);

	List<Oration> queryOrationNewList(int countNum6);

	void uploadImg(HttpServletRequest request, String id);

	List<Oration> queryOrationListByMemberAndHall(String hallId, String memberId,
			int limitNum);

	List<Oration> queryOrationListByHall(String hallId, int limitNum);

	List<Oration> queryOrationNewListByMember(Integer memberId, int limitNum);


}
