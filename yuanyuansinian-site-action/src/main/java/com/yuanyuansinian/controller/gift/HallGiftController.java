/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.controller.gift;

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
import com.yuanyuansinian.model.gift.HallGift;
import com.yuanyuansinian.pub.base.MyBaseController;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.gift.IHallGiftService;

import framework.system.model.Code;
import framework.system.pub.util.DataTablePageUtil;
import framework.system.service.ICodeService;

/**
 * @Description: 纪念馆灵堂礼物管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/sinian/hallGift/hallGiftController")
public class HallGiftController extends MyBaseController {
	// 纪念馆灵堂礼物Service
	@Resource
	private IHallGiftService hallGiftService;

	@Resource
	private ICodeService codeService;

	/**
	 * 
	 * @Description: 跳转到商城纪念馆灵堂礼物分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallGiftList")
	public String toHallGiftList(HttpServletRequest request, Model model) {

		return "hallGift/hallGiftList";
	}

	/**
	 * 
	 * @Description: 跳转到纪念馆纪念馆灵堂礼物列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallHallGiftList")
	public String toHallHallGiftList(HttpServletRequest request, Model model) {

		return "hallGift/hallHallGiftList";
	}

	/**
	 * 
	 * @Description: 跳转到礼品列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallGiftListForHall")
	public String toHallGiftListForHall(HttpServletRequest request, Model model) {

		return "hallGift/hallGiftListForHall";
	}

	/**
	 * 
	 * @Description: 跳转到纪念馆灵堂礼物回收站列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallGiftRecycleList")
	public String toHallGiftRecycleList(HttpServletRequest request, Model model) {

		return "hallGift/hallGiftRecycleList";
	}

	/**
	 * 
	 * @Description: 跳转到商城纪念馆灵堂礼物新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallGiftAdd")
	public String toHallGiftAdd(HttpServletRequest request, Model model) {
		// 纪念馆灵堂礼物小类
		List<Code> codeList = codeService.queryCodeListByType("hallGift_type");

		model.addAttribute("codeList", codeList);
		// 纪念馆灵堂礼物大类
		model.addAttribute("big_type", IMySystemConstants.VALUE_1);

		return "hallGift/hallGiftAdd";
	}

	/**
	 * 
	 * @Description: 跳转到纪念馆纪念馆灵堂礼物新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallHallGiftAdd")
	public String toHallHallGiftAdd(HttpServletRequest request, Model model) {
		// 纪念馆灵堂礼物小类
		List<Code> codeList = codeService.queryCodeListByType("hall_type");

		model.addAttribute("codeList", codeList);
		// 纪念馆灵堂礼物大类
		model.addAttribute("big_type", IMySystemConstants.VALUE_2);

		return "hallGift/hallHallGiftAdd";
	}

	/**
	 * 
	 * @Description: 跳转到商城纪念馆灵堂礼物修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallGiftUpdate")
	public String toHallGiftUpdate(HttpServletRequest request, Model model) {
		int hallGiftId = Integer.parseInt(request.getParameter("id"));
		HallGift hallGift = this.hallGiftService.queryHallGiftById(hallGiftId);
		model.addAttribute("hallGift", hallGift);

		// List<Code> codeList =
		// codeService.queryCodeListByType("hallGift_type");
		// model.addAttribute("codeList", codeList);
		// 纪念馆灵堂礼物大类
		// List<Code> bigTypeCodeList =
		// codeService.queryCodeListByType("big_type");
		// model.addAttribute("bigTypeCodeList", bigTypeCodeList);

		return "hallGift/hallGiftUpdate";
	}

	/**
	 * 
	 * @Description: 跳转到纪念馆纪念馆灵堂礼物修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallHallGiftUpdate")
	public String toHallHallGiftUpdate(HttpServletRequest request, Model model) {
		int hallGiftId = Integer.parseInt(request.getParameter("id"));
		HallGift hallGift = this.hallGiftService.queryHallGiftById(hallGiftId);
		model.addAttribute("hallGift", hallGift);

		return "hallGift/hallHallGiftUpdate";
	}

	/**
	 * 
	 * @Description: 跳转到商城纪念馆灵堂礼物明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallGiftDetail")
	public String toHallGiftDetail(HttpServletRequest request, Model model) {
		int hallGiftId = Integer.parseInt(request.getParameter("id"));
		HallGift hallGift = this.hallGiftService.queryHallGiftById(hallGiftId);
		model.addAttribute("hallGift", hallGift);

		return "hallGift/hallGiftDetail";
	}

	/**
	 * 
	 * @Description: 商城纪念馆灵堂礼物分页列表
	 * @param request
	 * @param response
	 * @param hallGift
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryHallGiftList")
	public DataTablePageUtil<HallGift> queryHallGiftList(
			HttpServletRequest request, HttpServletResponse response,
			HallGift hallGift) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<HallGift> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<HallGift>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<HallGift> hallGiftList = this.hallGiftService
					.queryHallGiftList(hallGift);
			// 用PageInfo对结果进行包装
			PageInfo<HallGift> pageInfo = new PageInfo<HallGift>(hallGiftList);

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
	 * @Description:  查询当前纪念馆灵堂中已经摆放的礼物
	 * @param request
	 * @param response
	 * @param hallGift
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryHallGiftListForHall")
	public List<HallGift> queryHallGiftListForHall(
			HttpServletRequest request, HttpServletResponse response,
			HallGift hallGift) {
		//返回结果
		List<HallGift>  listHallGift = null;
		try {
			//listHallGift = this.hallGiftService.queryHallGiftListForHall(0,IMySystemConstants.COUNT_NUM15);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return listHallGift;
	}

	/**
	 * 
	 * @Description: 添加商城纪念馆灵堂礼物
	 * @param request
	 * @param hallGift
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addHallGift")
	public Map<String, Object> addHallGift(HttpServletRequest request,
			HallGift hallGift) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 发布人
			// hallGift.setIssue(getSessionUser(request).getLogin_name());
			// 默认状态为“0”：待审核
			hallGift.setUse_status(IMySystemConstants.VALUE_0);
			hallGiftService.addHallGift(request, hallGift);
			map.put("model_id", hallGift.getId());
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}

	/**
	 * 
	 * @Description: 商城纪念馆灵堂礼物修改
	 * @param request
	 * @param hallGift
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateHallGift")
	public Map<String, Object> updateHallGift(HttpServletRequest request,
			HallGift hallGift) {

		Map<String, Object> map = new HashMap<String, Object>();
		hallGift.setCreate_date(MyDateUtil.getDateTime());
		map.put("model_id", hallGift.getId());
		int count = this.hallGiftService.updateHallGift(hallGift);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}

	/**
	 * 
	 * @Description: 纪念馆灵堂礼物删除
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteHallGift")
	public Map<String, Object> deleteHallGift(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hallGiftId = Integer.parseInt(request.getParameter("id"));
		int count = this.hallGiftService.deleteHallGift(hallGiftId);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, DELETE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, DELETE_FAILED_MESSAGE);
		}
		return map;
	}

}
