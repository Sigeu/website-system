/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.controller.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanyuansinian.model.member.Member;
import com.yuanyuansinian.pub.base.MyBaseController;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.member.IMemberService;

import framework.system.pub.util.DataTablePageUtil;

/**
 * @Description: 友情链接管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/sinian/member/memberController")
public class MemberController extends MyBaseController {
	// 友情链接Service
	@Resource
	private IMemberService memberService;

	/**
	 * 
	 * @Description: 跳转到分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toMemberList")
	public String toMemberList(HttpServletRequest request, Model model) {

		return "member/memberList";
	}

	/**
	 * 
	 * @Description: 跳转到新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toMemberAdd")
	public String toMemberAdd(HttpServletRequest request, Model model) {

		return "member/memberAdd";
	}

	/**
	 * 
	 * @Description: 跳转到修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toMemberUpdate")
	public String toMemberUpdate(HttpServletRequest request, Model model) {
		int memberId = Integer.parseInt(request.getParameter("id"));
		Member member = this.memberService.queryMemberById(memberId);
		model.addAttribute("member", member);

		return "member/memberUpdate";
	}

	/**
	 * 
	 * @Description: 跳转到明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toMemberDetail")
	public String toMemberDetail(HttpServletRequest request, Model model) {
		int memberId = Integer.parseInt(request.getParameter("id"));
		Member member = this.memberService.queryMemberById(memberId);
		model.addAttribute("member", member);

		return "member/memberDetail";
	}

	/**
	 * 
	 * @Description: 分页列表
	 * @param request
	 * @param response
	 * @param member
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryMemberList")
	public DataTablePageUtil<Member> queryMemberList(HttpServletRequest request,
			HttpServletResponse response, Member member) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Member> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Member>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Member> memberList = this.memberService.queryMemberList(member);
			// 用PageInfo对结果进行包装
			PageInfo<Member> pageInfo = new PageInfo<Member>(memberList);

			// 封装数据给DataTables
			dataTable.setDraw(dataTable.getDraw());
			dataTable.setData(pageInfo.getList());
			dataTable.setRecordsTotal((int) pageInfo.getTotal());
			dataTable.setRecordsFiltered(dataTable.getRecordsTotal());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return dataTable;
	}

	/**
	 * 
	 * @Description: 添加
	 * @param request
	 * @param member
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addMember")
	public Map<String, Object> addMember(HttpServletRequest request, Member member) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			memberService.addMember(request, member);
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}
	
	@ResponseBody
	@RequestMapping("/registerMember")
	public Map<String, Object> registerMember(HttpServletRequest request, Member member) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			memberService.addMember(request, member);
			map.put(RESULT_MESSAGE_STRING, "注册成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}
	
	/**
	 * 
	 * @Description: 修改
	 * @param request
	 * @param member
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateMember")
	public Map<String, Object> updateMember(HttpServletRequest request, Member member) {

		Map<String, Object> map = new HashMap<String, Object>();
		member.setCreate_date(MyDateUtil.getDateTime());
		int count = this.memberService.updateMember(member);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}

	/**
	 * 
	 * @Description: 保存
	 * @param request
	 * @param member
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveMember")
	public Map<String, Object> saveMember(HttpServletRequest request, Member member) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = this.memberService.updateMember(member);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}

	/**
	 * 
	 * @Description: 删除
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteMember")
	public Map<String, Object> deleteMember(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int memberId = Integer.parseInt(request.getParameter("id"));
		int count = this.memberService.deleteMember(memberId);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, DELETE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, DELETE_FAILED_MESSAGE);
		}
		return map;
	}

}
