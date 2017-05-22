/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yuanyuansinian.model.member.Member;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:49:54
 * @version V1.0
 */
public interface IMemberService {

	/**
	 * 
	 * @Description: 更新
	 * @param member
	 * @return
	 */
	int updateMember(Member member);

	/**
	 * 
	 * @Description: 根据ID查询
	 * @param memberId
	 * @return
	 */
	Member queryMemberById(int memberId);

	/**
	 * 
	 * @Description: 分页列表
	 * @param member
	 * @return
	 */
	List<Member> queryMemberList(Member member);

	/**
	 * 
	 * @Description: 添加
	 * @param request
	 * @param member
	 * @return
	 */
	int addMember(HttpServletRequest request, Member member);

	/**
	 * 
	 * @Description: 删除
	 * @param memberId
	 * @return
	 */
	int deleteMember(int memberId);

	Member queryMemberByPhone(String phone,String pwd);

	int queryMemberCountByPhone(String phone);

	int queryMemberCountByEmail(String email);

	Member queryMemberByEmail(String email,String pwd);

	void uploadImg(HttpServletRequest request, String id);

	int queryMemberCountByMemberName(String member_name);

}
