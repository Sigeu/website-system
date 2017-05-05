/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.controller.oration;

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
import com.yuanyuansinian.model.oration.Oration;
import com.yuanyuansinian.pub.base.MyBaseController;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.column.IColumnService;
import com.yuanyuansinian.service.oration.IOrationService;

import framework.system.pub.util.DataTablePageUtil;

/**
 * @Description: 祭文管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/sinian/oration/orationController")
public class OrationController extends MyBaseController {
	// 产品Service
	@Resource
	private IOrationService orationService;
	
	@Resource
	private IColumnService columnService;

	/**
	 * 
	 * @Description: 跳转到分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toOrationList")
	public String toOrationList(HttpServletRequest request, Model model) {

		return "oration/orationList";
	}
	
	/**
	 * 
	 * @Description: 跳转到产品回收站列表 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toOrationRecycleList")
	public String toOrationRecycleList(HttpServletRequest request, Model model) {

		return "oration/orationRecycleList";
	}

	/**
	 * 
	 * @Description: 跳转到新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toOrationAdd")
	public String toOrationAdd(HttpServletRequest request, Model model) {
		//获取登录的会员
		Member memberUser = super.getSessionMemberUser(request);
		if(null == memberUser){
			return "redirect:/sinian/index/indexController/toMemberLogin";
		}else{

			return "oration/orationAdd";
		}
	}

	/**
	 * 
	 * @Description: 跳转到修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toOrationUpdate")
	public String toOrationUpdate(HttpServletRequest request, Model model) {
		int orationId = Integer.parseInt(request.getParameter("id"));
		Oration oration = this.orationService.queryOrationById(orationId);
		model.addAttribute("oration", oration);
		
		return "oration/orationUpdate";
	}
	

	/**
	 * 
	 * @Description: 跳转到明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toOrationDetail")
	public String toOrationDetail(HttpServletRequest request, Model model) {
		int orationId = Integer.parseInt(request.getParameter("id"));
		Oration  oration = this.orationService.queryOrationById(orationId);
		model.addAttribute("oration", oration);

		return "oration/orationDetail";
	}

	/**
	 * 
	 * @Description: 分页列表
	 * @param request
	 * @param response
	 * @param oration
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryOrationList")
	public DataTablePageUtil<Oration> queryOrationList(HttpServletRequest request,
			HttpServletResponse response, Oration oration) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Oration> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Oration>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Oration> orationList = this.orationService.queryOrationList(oration);
			// 用PageInfo对结果进行包装
			PageInfo<Oration> pageInfo = new PageInfo<Oration>(orationList);

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
	 * @Description: 分页列表
	 * @param request
	 * @param response
	 * @param oration
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryOrationListByMember")
	public DataTablePageUtil<Oration> queryOrationListByMember(HttpServletRequest request,
			HttpServletResponse response, Oration oration) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Oration> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Oration>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Oration> orationList = this.orationService.queryOrationPageListByMember(oration);
			// 用PageInfo对结果进行包装
			PageInfo<Oration> pageInfo = new PageInfo<Oration>(orationList);

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
	 * @Description: 根据公开状态查询列表 
	 * @param request
	 * @param response
	 * @param oration
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryOrationListByOpenType")
	public DataTablePageUtil<Oration> queryOrationListByOpenType(HttpServletRequest request,
			HttpServletResponse response, Oration oration) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Oration> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Oration>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Oration> orationList = this.orationService.queryOrationListByOpenType(oration);
			// 用PageInfo对结果进行包装
			PageInfo<Oration> pageInfo = new PageInfo<Oration>(orationList);

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
	 * @param oration
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOration")
	public Map<String, Object> addOration(HttpServletRequest request, Oration oration) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Member memberUser = super.getSessionMemberUser(request);
			//发布人
			oration.setCreate_user(memberUser.getId().toString());
			orationService.addOration(request, oration);
			map.put("model_id", oration.getId());
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}
	
	/**
	 * 
	 * @Description:封面图片上传（方法命名保持一致）
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/uploadImg")
	public Map<String, Object> uploadImg(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String id = nullToStringZero(request.getParameter("model_id"));
			//保存数据
			orationService.uploadImg(request, id);
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
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
	 * @param oration
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateOration")
	public Map<String, Object> updateOration(HttpServletRequest request, Oration oration) {

		Map<String, Object> map = new HashMap<String, Object>();
		oration.setCreate_date(MyDateUtil.getDateTime());
		map.put("model_id", oration.getId());
		int count = this.orationService.updateOration(oration);
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
	@RequestMapping("/deleteOration")
	public Map<String, Object> deleteOration(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int orationId = Integer.parseInt(request.getParameter("id"));
		int count = this.orationService.deleteOration(orationId);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, DELETE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, DELETE_FAILED_MESSAGE);
		}
		return map;
	}
}
