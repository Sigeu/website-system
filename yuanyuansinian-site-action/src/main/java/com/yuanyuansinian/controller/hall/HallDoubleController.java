/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.controller.hall;

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
import com.yuanyuansinian.model.hall.HallDouble;
import com.yuanyuansinian.model.hall.HallDoubleWithBLOBs;
import com.yuanyuansinian.model.member.Member;
import com.yuanyuansinian.model.oration.Oration;
import com.yuanyuansinian.pub.base.MyBaseController;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.hall.IHallDoubleService;
import com.yuanyuansinian.service.oration.IOrationService;

import framework.system.pub.util.DataTablePageUtil;

/**
 * @Description: 双人纪念馆管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/sinian/hallDouble/hallDoubleController")
public class HallDoubleController extends MyBaseController {
	// 双人纪念馆Service
	@Resource
	private IHallDoubleService hallDoubleService;
	
	@Resource
	private IOrationService orationService;

	/**
	 * 
	 * @Description: 跳转到分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallDoubleList")
	public String toHallDoubleList(HttpServletRequest request, Model model) {

		return "hallDouble/hallDoubleList";
	}
	
	/**
	 * 
	 * @Description: 跳转到会员创建的纪念馆列表 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallDoubleListByMember")
	public String toHallDoubleListByMember(HttpServletRequest request, Model model) {
		//设置差当前登录会员
		String memberId = super.getSessionMemberUser(request).getId()+"";
		
		//我创建的纪念馆
		List<HallDouble> hallDoubleList = this.hallDoubleService.queryHallDoubleListByMember(memberId,IMySystemConstants.COUNT_NUM2);
		//我的访问 visit
		
		//我发布的祭文
		List<Oration> orationList = this.orationService.queryOrationListByMember(memberId,IMySystemConstants.COUNT_NUM2);
		
		model.addAttribute("hallDoubleList", hallDoubleList);
		model.addAttribute("orationList", orationList);
		
		return "site/memberIssue";
	}

	/**
	 * 
	 * @Description:跳转到双人馆新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallDoubleAdd")
	public String toHallDoubleAdd(HttpServletRequest request, Model model) {
		//获取登录的会员
		Member memberUser = super.getSessionMemberUser(request);
		if(null == memberUser){
			return "redirect:/sinian/index/indexController/toMemberLogin";
		}else{
			return "hallDouble/hallDoubleAdd";
		}
		
		
	}

	/**
	 * 
	 * @Description: 跳转到修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallDoubleUpdate")
	public String toHallDoubleUpdate(HttpServletRequest request, Model model) {
		int hallDoubleId = Integer.parseInt(request.getParameter("id"));
		HallDouble hallDouble = this.hallDoubleService.queryHallDoubleById(hallDoubleId);
		model.addAttribute("hallDouble", hallDouble);
		
		return "hallDouble/hallDoubleUpdate";
	}
	

	/**
	 * 
	 * @Description: 跳转到明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallDoubleDetail")
	public String toHallDoubleDetail(HttpServletRequest request, Model model) {
		int hallDoubleId = Integer.parseInt(request.getParameter("id"));
		HallDouble  hallDouble = this.hallDoubleService.queryHallDoubleById(hallDoubleId);
		model.addAttribute("hallDouble", hallDouble);

		return "hallDouble/hallDoubleDetail";
	}

	/**
	 * 
	 * @Description: 分页列表
	 * @param request
	 * @param response
	 * @param hallDouble
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryHallDoubleList")
	public DataTablePageUtil<HallDouble> queryHallDoubleList(HttpServletRequest request,
			HttpServletResponse response, HallDouble hallDouble) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<HallDouble> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<HallDouble>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<HallDouble> hallDoubleList = this.hallDoubleService.queryHallDoubleList(hallDouble);
			// 用PageInfo对结果进行包装
			PageInfo<HallDouble> pageInfo = new PageInfo<HallDouble>(hallDoubleList);

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
	 * @param hallDouble
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryHallDoubleListByMember")
	public DataTablePageUtil<HallDouble> queryHallDoubleListByMember(HttpServletRequest request,
			HttpServletResponse response, HallDouble hallDouble) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<HallDouble> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<HallDouble>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<HallDouble> hallDoubleList = this.hallDoubleService.queryHallDoublePageListByMember(hallDouble);
			// 用PageInfo对结果进行包装
			PageInfo<HallDouble> pageInfo = new PageInfo<HallDouble>(hallDoubleList);

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
	 * @param hallDouble
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryHallDoubleListByOpenType")
	public DataTablePageUtil<HallDouble> queryHallDoubleListByOpenType(HttpServletRequest request,
			HttpServletResponse response, HallDouble hallDouble) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<HallDouble> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<HallDouble>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<HallDouble> hallDoubleList = this.hallDoubleService.queryHallDoubleListByOpenType(IMySystemConstants.VALUE_2);
			// 用PageInfo对结果进行包装
			PageInfo<HallDouble> pageInfo = new PageInfo<HallDouble>(hallDoubleList);

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
	 * @Description: 双人馆添加
	 * @param request
	 * @param hallDouble
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addDoubleHall")
	public Map<String, Object> addDoubleHall(HttpServletRequest request, HallDoubleWithBLOBs hallDouble) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Member memberUser = super.getSessionMemberUser(request);
			//发布人
			hallDouble.setCreate_user(memberUser.getId().toString());
			//默认状态为“0”：待审核
			hallDoubleService.addDoubleHallDouble(request, hallDouble);
			map.put("model_id", hallDouble.getId());
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
			hallDoubleService.uploadImg(request, id);
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
	 * @param hallDouble
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateHallDouble")
	public Map<String, Object> updateHallDouble(HttpServletRequest request, HallDouble hallDouble) {

		Map<String, Object> map = new HashMap<String, Object>();
		hallDouble.setCreate_date(MyDateUtil.getDateTime());
		map.put("model_id", hallDouble.getId());
		int count = this.hallDoubleService.updateHallDouble(hallDouble);
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
	@RequestMapping("/deleteHallDouble")
	public Map<String, Object> deleteHallDouble(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hallDoubleId = Integer.parseInt(request.getParameter("id"));
		int count = this.hallDoubleService.deleteHallDouble(hallDoubleId);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, DELETE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, DELETE_FAILED_MESSAGE);
		}
		return map;
	}
}
