/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.controller.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
import com.yuanyuansinian.model.column.Column;
import com.yuanyuansinian.model.content.Content;
import com.yuanyuansinian.model.content.ContentWithBLOBs;
import com.yuanyuansinian.pub.base.MyBaseController;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.column.IColumnService;
import com.yuanyuansinian.service.content.IContentService;

import framework.system.pub.util.DataTablePageUtil;

/**
 * @Description: 内容管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/sinian/content/contentController")
public class ContentController extends MyBaseController {
	// 内容Service
	@Resource
	private IContentService contentService;
	
	@Resource
	private IColumnService columnService;

	/**
	 * 
	 * @Description: 跳转到分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toContentList")
	public String toContentList(HttpServletRequest request, Model model) {

		return "content/contentList";
	}
	
	@RequestMapping("/toNoticeList")
	public String toNoticeList(HttpServletRequest request, Model model) {

		return "content/noticeList";
	}
	
	/**
	 * 
	 * @Description: 跳转到内容回收站列表 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toContentRecycleList")
	public String toContentRecycleList(HttpServletRequest request, Model model) {

		return "content/contentRecycleList";
	}

	/**
	 * 
	 * @Description: 跳转到新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toContentAdd")
	public String toContentAdd(HttpServletRequest request, Model model) {
		
		List<Column> columnList = columnService.queryColumnList(null);
		//处理栏目名称
		for(Column co : columnList){
			if(2 == co.getClass_type()){
				co.setName("&brvbar;&mdash;" + co.getName());
			}else if(3 == co.getClass_type()){
				co.setName("&brvbar;&mdash;&mdash;" + co.getName());
			}else if(4 == co.getClass_type()){
				co.setName("&brvbar;&mdash;&mdash;&mdash;" + co.getName());
			}else{
				//co.setName(co.getName());
			}
		}
		//排序
		LinkedList<Column> result = new LinkedList<Column>();
		LinkedList<Column> columnLinkedList = this.toSort(columnList, result, 0);
		//转换为ArrayList
		List<Column> columnSelectList = new ArrayList<Column>(columnLinkedList);
		model.addAttribute("columnSelectList", columnSelectList);
		
		return "content/contentAdd";
	}
	
	/**
	 * 
	 * @Description: 跳转到通知公告新增 页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toNoticeAdd")
	public String toNoticeAdd(HttpServletRequest request, Model model) {
		
		
		return "content/noticeAdd";
	}

	/**
	 * 
	 * @Description: 跳转到修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toContentUpdate")
	public String toContentUpdate(HttpServletRequest request, Model model) {
		int contentId = Integer.parseInt(request.getParameter("id"));
		Content content = this.contentService.queryContentById(contentId);
		model.addAttribute("content", content);
		
		List<Column> columnList = columnService.queryColumnList(null);
		//处理栏目名称
		for(Column co : columnList){
			if(2 == co.getClass_type()){
				co.setName("&brvbar;&mdash;" + co.getName());
			}else if(3 == co.getClass_type()){
				co.setName("&brvbar;&mdash;&mdash;" + co.getName());
			}else if(4 == co.getClass_type()){
				co.setName("&brvbar;&mdash;&mdash;&mdash;" + co.getName());
			}else{
				//co.setName(co.getName());
			}
		}
		//排序
		LinkedList<Column> result = new LinkedList<Column>();
		LinkedList<Column> columnLinkedList = this.toSort(columnList, result, 0);
		//转换为ArrayList
		List<Column> columnSelectList = new ArrayList<Column>(columnLinkedList);
		model.addAttribute("columnSelectList", columnSelectList);
		
		return "content/contentUpdate";
	}
	

	/**
	 * 
	 * @Description: 跳转到明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toContentDetail")
	public String toContentDetail(HttpServletRequest request, Model model) {
		int contentId = Integer.parseInt(request.getParameter("id"));
		ContentWithBLOBs  content = this.contentService.queryContentById(contentId);
		model.addAttribute("content", content);

		return "content/contentDetail";
	}

	/**
	 * 
	 * @Description: 分页列表
	 * @param request
	 * @param response
	 * @param content
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryContentList")
	public DataTablePageUtil<Content> queryContentList(HttpServletRequest request,
			HttpServletResponse response, Content content) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Content> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Content>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Content> contentList = this.contentService.queryContentList(content);
			// 用PageInfo对结果进行包装
			PageInfo<Content> pageInfo = new PageInfo<Content>(contentList);

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
	 * @Description: 通知公告列表 
	 * @param request
	 * @param response
	 * @param content
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryNoticeList")
	public DataTablePageUtil<Content> queryNoticeList(HttpServletRequest request,
			HttpServletResponse response, Content content) {
		//通知公告
		content.setColumn_id(IMySystemConstants.COLUMN123);
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Content> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Content>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Content> contentList = this.contentService.queryNoticeList(content);
			// 用PageInfo对结果进行包装
			PageInfo<Content> pageInfo = new PageInfo<Content>(contentList);

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
	 * @Description: 内容回收站
	 * @param request
	 * @param response
	 * @param content
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryContentRecycleList")
	public DataTablePageUtil<Content> queryContentRecycleList(HttpServletRequest request,
			HttpServletResponse response, Content content) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Content> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Content>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Content> contentList = this.contentService.queryContentRecycleList(content);
			// 用PageInfo对结果进行包装
			PageInfo<Content> pageInfo = new PageInfo<Content>(contentList);

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
	 * @param content
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addContent")
	public Map<String, Object> addContent(HttpServletRequest request, ContentWithBLOBs content) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//发布人
			content.setIssue(getSessionSystemUser(request).getLogin_name());
			//添加时间
			content.setAdd_time(MyDateUtil.getDateTime());
			content.setUpdate_time(MyDateUtil.getDateTime());
			//默认状态为“0”：待审核
			content.setStatus(IMySystemConstants.VALUE_0);
			contentService.addContent(request, content);
			map.put("content_id", content.getId());
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}

	
	@ResponseBody
	@RequestMapping("/uploadContentImg")
	public Map<String, Object> uploadContentImg(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String id = nullToStringZero(request.getParameter("model_id"));
			//保存数据
			contentService.uploadContentImg(request, id);
			
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
	 * @param content
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateContent")
	public Map<String, Object> updateContent(HttpServletRequest request, ContentWithBLOBs content) {

		Map<String, Object> map = new HashMap<String, Object>();
		content.setAdd_time(MyDateUtil.getDateTime());
		content.setUpdate_time(MyDateUtil.getDateTime());
		map.put("content_id", content.getId());
		int count = this.contentService.updateContent(content);
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
	@RequestMapping("/deleteContent")
	public Map<String, Object> deleteContent(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int contentId = Integer.parseInt(request.getParameter("id"));
		int count = this.contentService.deleteContent(contentId);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, DELETE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, DELETE_FAILED_MESSAGE);
		}
		return map;
	}
	
	/**
	 * 
	 * @Description: 恢复内容 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/recoverContent")
	public Map<String, Object> recoverContent(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int contentId = Integer.parseInt(request.getParameter("id"));
		int count = this.contentService.recoverContent(contentId);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, DELETE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, DELETE_FAILED_MESSAGE);
		}
		return map;
	}
	
	
	/**
	 * 排序
	 * @param list
	 * @param result
	 * @param father
	 * @return
	 */
	protected LinkedList<Column> toSort(List<Column> list,
			LinkedList<Column> result, int father) {
		List<Column> temp = new ArrayList<Column>();
		// 最高层,临时存放
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBig_class() == father) {
				temp.add(list.get(i));
			}
		}

		if (temp.size() < 1) {
			return result;
		} else { 
			// 删除最高层
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getBig_class() == father) {
					list.remove(j);
				}
			}
			// 对最高层排序
			for (int i = 0; i < temp.size() - 1; i++) {
				for (int j = i + 1; j < temp.size(); j++) {
					if (temp.get(i).getNo_order() > temp.get(j).getNo_order()) {
						Column column = temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j, column);
					}
				}
			}
			// 递归
			for (int i = 0; i < temp.size(); i++) {
				result.add(temp.get(i));
				toSort(list, result, temp.get(i).getId());
			}
			return result;
		}

	}
}
