/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.controller.audit;

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
import com.yuanyuansinian.pub.base.MyBaseController;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.audit.IAuditContentService;
import com.yuanyuansinian.service.column.IColumnService;

import framework.system.pub.util.DataTablePageUtil;

/**
 * @Description: 内容管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/sinian/audit/auditController")
public class AuditContentController extends MyBaseController {
	// 内容审核Service
	@Resource
	private IAuditContentService auditContentService;
	
	@Resource
	private IColumnService columnService;
	

	/**
	 * 
	 * @Description: 跳转到内容审核列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toAuditContentList")
	public String toAuditContentList(HttpServletRequest request, Model model) {

		return "audit/auditContentList";
	}


	/**
	 * 
	 * @Description: 跳转到内容审核（可修改）页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toContentAudit")
	public String toContentAudit(HttpServletRequest request, Model model) {
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
		
		
		int auditContentId = Integer.parseInt(request.getParameter("id"));
		Content auditContent = this.auditContentService.queryContentAuditById(auditContentId);
		model.addAttribute("auditContent", auditContent);
		model.addAttribute("columnSelectList", columnSelectList);

		return "audit/auditContent";
	}


	/**
	 * 
	 * @Description: 分页列表
	 * @param request
	 * @param response
	 * @param auditContent
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryAuditContentList")
	public DataTablePageUtil<Content> queryAuditContentList(HttpServletRequest request,
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
			List<Content> auditContentList = this.auditContentService.queryAuditContentList(content);
			// 用PageInfo对结果进行包装
			PageInfo<Content> pageInfo = new PageInfo<Content>(auditContentList);

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
	 * @Description: 修改
	 * @param request
	 * @param auditContent
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateAuditContent")
	public Map<String, Object> updateAuditContent(HttpServletRequest request, Content content) {

		Map<String, Object> map = new HashMap<String, Object>();
		content.setAdd_time(MyDateUtil.getDateTime());
		int count = this.auditContentService.updateAuditContent(content);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
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
