/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.controller.apply;

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

import ujn.school.cn.model.apply.Apply;
import ujn.school.cn.pub.base.MyBaseController;
import ujn.school.cn.pub.util.MyDateUtil;
import ujn.school.cn.service.apply.IApplyService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import framework.system.pub.util.DataTablePageUtil;

/**
 * @Description: 在线申请管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/apply/controller/applyController")
public class ApplyController extends MyBaseController {
	// 在线申请Service
	@Resource
	private IApplyService applyService;

	/**
	 * 
	 * @Description: 跳转到分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toApplyList")
	public String toApplyList(HttpServletRequest request, Model model) {

		return "apply/applyList";
	}
	
	//意见反馈
	@RequestMapping("/toFeedbackList")
	public String toFeedbackList(HttpServletRequest request, Model model) {

		return "apply/feedbackList";
	}

	/**
	 * 
	 * @Description: 跳转到新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toApplyAdd")
	public String toApplyAdd(HttpServletRequest request, Model model) {

		return "apply/applyAdd";
	}

	/**
	 * 
	 * @Description: 跳转到修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toApplyUpdate")
	public String toApplyUpdate(HttpServletRequest request, Model model) {
		int applyId = Integer.parseInt(request.getParameter("id"));
		Apply apply = this.applyService.queryApplyById(applyId);
		model.addAttribute("apply", apply);

		return "apply/applyUpdate";
	}

	/**
	 * 
	 * @Description: 跳转到明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toApplyDetail")
	public String toApplyDetail(HttpServletRequest request, Model model) {
		int applyId = Integer.parseInt(request.getParameter("id"));
		Apply apply = this.applyService.queryApplyById(applyId);
		model.addAttribute("apply", apply);

		return "apply/applyDetail";
	}

	/**
	 * 
	 * @Description: 分页列表
	 * @param request
	 * @param response
	 * @param apply
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryApplyList")
	public DataTablePageUtil<Apply> queryApplyList(HttpServletRequest request,
			HttpServletResponse response, Apply apply) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Apply> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Apply>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Apply> applyList = this.applyService.queryApplyList(apply);
			// 用PageInfo对结果进行包装
			PageInfo<Apply> pageInfo = new PageInfo<Apply>(applyList);

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
	 * @Description: 在线反馈
	 * @param request
	 * @param response
	 * @param apply
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryFeedbackList")
	public DataTablePageUtil<Apply> queryFeedbackList(HttpServletRequest request,
			HttpServletResponse response, Apply apply) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Apply> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Apply>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Apply> applyList = this.applyService.queryApplyList(apply);
			// 用PageInfo对结果进行包装
			PageInfo<Apply> pageInfo = new PageInfo<Apply>(applyList);

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
	 * @param apply
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addApply")
	public Map<String, Object> addApply(HttpServletRequest request, Apply apply) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			applyService.addApply(request, apply);
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
	 * @param apply
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateApply")
	public Map<String, Object> updateApply(HttpServletRequest request, Apply apply) {

		Map<String, Object> map = new HashMap<String, Object>();
		//apply.setAdd_time(MyDateUtil.getDateTime());
		int count = this.applyService.updateApply(apply);
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
	 * @param apply
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveApply")
	public Map<String, Object> saveApply(HttpServletRequest request, Apply apply) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = this.applyService.updateApply(apply);
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
	@RequestMapping("/deleteApply")
	public Map<String, Object> deleteApply(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int applyId = Integer.parseInt(request.getParameter("id"));
		int count = this.applyService.deleteApply(applyId);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, DELETE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, DELETE_FAILED_MESSAGE);
		}
		return map;
	}

}
