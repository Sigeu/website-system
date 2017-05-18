/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.suncity.controller.link;

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
import com.suncity.model.link.Link;
import com.suncity.pub.base.MyBaseController;
import com.suncity.pub.util.MyDateUtil;
import com.suncity.service.link.ILinkService;

import framework.system.pub.util.DataTablePageUtil;

/**
 * @Description: 友情链接管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/sinian/link/linkController")
public class LinkController extends MyBaseController {
	// 友情链接Service
	@Resource
	private ILinkService linkService;

	/**
	 * 
	 * @Description: 跳转到分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toLinkList")
	public String toLinkList(HttpServletRequest request, Model model) {

		return "link/linkList";
	}

	/**
	 * 
	 * @Description: 跳转到新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toLinkAdd")
	public String toLinkAdd(HttpServletRequest request, Model model) {

		return "link/linkAdd";
	}

	/**
	 * 
	 * @Description: 跳转到修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toLinkUpdate")
	public String toLinkUpdate(HttpServletRequest request, Model model) {
		int linkId = Integer.parseInt(request.getParameter("id"));
		Link link = this.linkService.queryLinkById(linkId);
		model.addAttribute("link", link);

		return "link/linkUpdate";
	}

	/**
	 * 
	 * @Description: 跳转到明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toLinkDetail")
	public String toLinkDetail(HttpServletRequest request, Model model) {
		int linkId = Integer.parseInt(request.getParameter("id"));
		Link link = this.linkService.queryLinkById(linkId);
		model.addAttribute("link", link);

		return "link/linkDetail";
	}

	/**
	 * 
	 * @Description: 分页列表
	 * @param request
	 * @param response
	 * @param link
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryLinkList")
	public DataTablePageUtil<Link> queryLinkList(HttpServletRequest request,
			HttpServletResponse response, Link link) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Link> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Link>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Link> linkList = this.linkService.queryLinkList(link);
			// 用PageInfo对结果进行包装
			PageInfo<Link> pageInfo = new PageInfo<Link>(linkList);

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
	 * @param link
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addLink")
	public Map<String, Object> addLink(HttpServletRequest request, Link link) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			linkService.addLink(request, link);
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
	 * @param link
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateLink")
	public Map<String, Object> updateLink(HttpServletRequest request, Link link) {

		Map<String, Object> map = new HashMap<String, Object>();
		link.setAdd_time(MyDateUtil.getDateTime());
		int count = this.linkService.updateLink(link);
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
	 * @param link
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveLink")
	public Map<String, Object> saveLink(HttpServletRequest request, Link link) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = this.linkService.updateLink(link);
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
	@RequestMapping("/deleteLink")
	public Map<String, Object> deleteLink(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int linkId = Integer.parseInt(request.getParameter("id"));
		int count = this.linkService.deleteLink(linkId);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, DELETE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, DELETE_FAILED_MESSAGE);
		}
		return map;
	}

}
