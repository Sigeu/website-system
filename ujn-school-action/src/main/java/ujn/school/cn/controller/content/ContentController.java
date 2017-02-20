/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.controller.content;

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
import ujn.school.cn.model.content.ContentWithBLOBs;
import ujn.school.cn.pub.util.DateUtil;
import ujn.school.cn.service.content.IContentService;

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
@RequestMapping("/content/controller/contentController")
public class ContentController extends MyBaseController {
	// 内容Service
	@Resource
	private IContentService contentService;

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

	/**
	 * 
	 * @Description: 跳转到新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toContentAdd")
	public String toContentAdd(HttpServletRequest request, Model model) {

		return "content/contentAdd";
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
		Content content = this.contentService.queryContentById(contentId);
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
			contentService.addContent(request, content);
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
	public Map<String, Object> updateContent(HttpServletRequest request, Content content) {

		Map<String, Object> map = new HashMap<String, Object>();
		content.setAdd_time(DateUtil.getDateTime());
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
	 * @Description: 保存
	 * @param request
	 * @param content
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveContent")
	public Map<String, Object> saveContent(HttpServletRequest request, Content content) {
		Map<String, Object> map = new HashMap<String, Object>();
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

}
