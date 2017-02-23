/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.controller.audit;

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

import ujn.school.cn.model.content.Content;
import ujn.school.cn.pub.util.DateUtil;
import ujn.school.cn.service.audit.IAuditContentService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import framework.system.pub.base.MyBaseController;
import framework.system.pub.util.DataTablePageUtil;

/**
 * @Description: 内容管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/audit/controller/auditController")
public class AuditContentController extends MyBaseController {
	// 内容审核Service
	@Resource
	private IAuditContentService auditContentService;
	

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
	@RequestMapping("/toAuditContentUpdate")
	public String toAuditContentUpdate(HttpServletRequest request, Model model) {
		int auditContentId = Integer.parseInt(request.getParameter("id"));
		Content auditContent = this.auditContentService.queryAuditContentById(auditContentId);
		model.addAttribute("auditContent", auditContent);

		return "audit/auditContentUpdate";
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
		content.setAdd_time(DateUtil.getDateTime());
		int count = this.auditContentService.updateAuditContent(content);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}
	
}
