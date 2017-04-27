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
import com.yuanyuansinian.model.hall.Hall;
import com.yuanyuansinian.model.hall.HallWithBLOBs;
import com.yuanyuansinian.model.member.Member;
import com.yuanyuansinian.model.oration.Oration;
import com.yuanyuansinian.pub.base.MyBaseController;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.hall.IHallService;
import com.yuanyuansinian.service.oration.IOrationService;

import framework.system.pub.util.DataTablePageUtil;

/**
 * @Description: 产品管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/sinian/hall/hallController")
public class HallController extends MyBaseController {
	// 产品Service
	@Resource
	private IHallService hallService;
	
	@Resource
	private IOrationService orationService;

	/**
	 * 
	 * @Description: 跳转到分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallList")
	public String toHallList(HttpServletRequest request, Model model) {

		return "hall/hallList";
	}
	
	/**
	 * 
	 * @Description: 跳转到会员创建的纪念馆列表 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallListByMember")
	public String toHallListByMember(HttpServletRequest request, Model model) {
		//设置差当前登录会员
		String memberId = super.getSessionMemberUser(request).getId()+"";
		
		//我创建的纪念馆
		List<Hall> hallList = this.hallService.queryHallListByMember(memberId,IMySystemConstants.COUNT_NUM2);
		//我的访问 visit
		
		//我发布的祭文
		List<Oration> orationList = this.orationService.queryOrationListByMember(memberId,IMySystemConstants.COUNT_NUM2);
		
		model.addAttribute("hallList", hallList);
		model.addAttribute("orationList", orationList);
		
		return "site/memberIssue";
	}

	/**
	 * 
	 * @Description: 跳转到单人馆新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallSingleAdd")
	public String toHallSingleAdd(HttpServletRequest request, Model model) {
		
		
		return "hall/hallSingleAdd";
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
		
		
		return "hall/hallDoubleAdd";
	}

	/**
	 * 
	 * @Description: 跳转到修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallUpdate")
	public String toHallUpdate(HttpServletRequest request, Model model) {
		int hallId = Integer.parseInt(request.getParameter("id"));
		Hall hall = this.hallService.queryHallById(hallId);
		model.addAttribute("hall", hall);
		
		return "hall/hallUpdate";
	}
	

	/**
	 * 
	 * @Description: 跳转到明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallDetail")
	public String toHallDetail(HttpServletRequest request, Model model) {
		int hallId = Integer.parseInt(request.getParameter("id"));
		Hall  hall = this.hallService.queryHallById(hallId);
		model.addAttribute("hall", hall);

		return "hall/hallDetail";
	}

	/**
	 * 
	 * @Description: 分页列表
	 * @param request
	 * @param response
	 * @param hall
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryHallList")
	public DataTablePageUtil<Hall> queryHallList(HttpServletRequest request,
			HttpServletResponse response, Hall hall) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Hall> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Hall>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Hall> hallList = this.hallService.queryHallList(hall);
			// 用PageInfo对结果进行包装
			PageInfo<Hall> pageInfo = new PageInfo<Hall>(hallList);

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
	 * @param hall
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryHallListByMember")
	public DataTablePageUtil<Hall> queryHallListByMember(HttpServletRequest request,
			HttpServletResponse response, Hall hall) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Hall> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Hall>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Hall> hallList = this.hallService.queryHallPageListByMember(hall);
			// 用PageInfo对结果进行包装
			PageInfo<Hall> pageInfo = new PageInfo<Hall>(hallList);

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
	 * @param hall
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryHallListByOpenType")
	public DataTablePageUtil<Hall> queryHallListByOpenType(HttpServletRequest request,
			HttpServletResponse response, Hall hall) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Hall> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Hall>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Hall> hallList = this.hallService.queryHallListByOpenType(IMySystemConstants.VALUE_2);
			// 用PageInfo对结果进行包装
			PageInfo<Hall> pageInfo = new PageInfo<Hall>(hallList);

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
	 * @Description: 单人馆添加
	 * @param request
	 * @param hall
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addSingleHall")
	public Map<String, Object> addSingleHall(HttpServletRequest request, HallWithBLOBs hall) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Member member = getSessionMemberUser(request);
			//创建会员
			hall.setCreate_user(member.getId()+"");
			//创建时间
			hall.setCreate_date(MyDateUtil.getDateTime());
			//纪念馆类型：单人馆
			hall.setHall_type(IMySystemConstants.VALUE_1);
			//保存数据
			hallService.addSingleHall(request, hall);
			map.put("hall_id", hall.getId());
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}
	
	@ResponseBody
	@RequestMapping("/uploadSingleHallImg")
	public Map<String, Object> uploadSingleHallImg(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String id = nullToStringZero(request.getParameter("model_id"));
			//保存数据
			hallService.uploadSingleHallImg(request, id);
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}
	/**
	 * 
	 * @Description: 双人馆添加
	 * @param request
	 * @param hall
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addDoubleHall")
	public Map<String, Object> addDoubleHall(HttpServletRequest request, HallWithBLOBs hall) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//发布人
			//hall.setIssue(getSessionUser(request).getLogin_name());
			//默认状态为“0”：待审核
			hallService.addDoubleHall(request, hall);
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
	 * @param hall
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateHall")
	public Map<String, Object> updateHall(HttpServletRequest request, Hall hall) {

		Map<String, Object> map = new HashMap<String, Object>();
		hall.setCreate_date(MyDateUtil.getDateTime());
		int count = this.hallService.updateHall(hall);
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
	@RequestMapping("/deleteHall")
	public Map<String, Object> deleteHall(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hallId = Integer.parseInt(request.getParameter("id"));
		int count = this.hallService.deleteHall(hallId);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, DELETE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, DELETE_FAILED_MESSAGE);
		}
		return map;
	}
}
