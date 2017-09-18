/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.controller.content;

import java.util.ArrayList;
import java.util.Collection;
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

import ujn.school.cn.model.column.Column;
import ujn.school.cn.model.content.Content;
import ujn.school.cn.model.content.ContentWithBLOBs;
import ujn.school.cn.pub.base.MyBaseController;
import ujn.school.cn.pub.constants.IMySystemConstants;
import ujn.school.cn.pub.util.MyDateUtil;
import ujn.school.cn.pub.util.MyRandomUtils;
import ujn.school.cn.service.column.IColumnService;
import ujn.school.cn.service.content.IContentService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import framework.system.model.Code;
import framework.system.model.Department;
import framework.system.pub.util.DataTablePageUtil;
import framework.system.pub.util.LogUtil;
import framework.system.service.ICodeService;
import framework.system.service.IDepartmentService;

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
	
	@Resource
	private IColumnService columnService;
	
	@Resource
	private ICodeService codeService;
	
	@Resource
	private IDepartmentService departmentService;
	
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
	 * @Description: 跳转到统计页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toContentStatistics")
	public String toContentStatistics(HttpServletRequest request, Model model) {

		return "content/contentStatistics";
	}
	
	/**
	 * 
	 * @Description: 跳转到部门文章统计页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toContentStatisticsForDept")
	public String toContentStatisticsForDept(HttpServletRequest request, Model model) {
		
		//部门下拉列表
		List<Department> departmentList = departmentService.queryDepartmentList(null);
		model.addAttribute("departmentList", departmentList);
		return "content/contentStatisticsForDept";
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
		
		//一级栏目
		List<Column> columnListByLevel = columnService.queryColumnListByLevel(IMySystemConstants.VALUE_1);
		model.addAttribute("columnListByLevel", columnListByLevel);
		
		//字典表 重要信息数据标签
		List<Code> codeImportantList = codeService.queryCodeListByType(IMySystemConstants.IMPORTANCE);
		model.addAttribute("codeImportantList", codeImportantList);
		
		//字典表 内容标签
		List<Code> codeContentList = codeService.queryCodeListByType(IMySystemConstants.CONTENT_TAG);
		model.addAttribute("codeContentList", codeContentList);
		
		
		//字典表 目录分类
		List<Code> classCodeList = codeService.queryCodeListByType(IMySystemConstants.CLASS_CODE);
		model.addAttribute("classCodeList", classCodeList);
		
		//8位的随机字符串密码（数字和字符）
		String randomPwd = MyRandomUtils.randomString(IMySystemConstants.COUNT_NUM8);
		model.addAttribute("randomPwd", randomPwd);
		
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
		//一级栏目
		List<Column> columnListByLevel = columnService.queryColumnListByLevel(IMySystemConstants.VALUE_1);
		model.addAttribute("columnListByLevel", columnListByLevel);
		
		//字典表 重要信息数据标签
		List<Code> codeImportantList = codeService.queryCodeListByType(IMySystemConstants.IMPORTANCE);
		model.addAttribute("codeImportantList", codeImportantList);
		
		//字典表 内容标签
		List<Code> codeContentList = codeService.queryCodeListByType(IMySystemConstants.CONTENT_TAG);
		model.addAttribute("codeContentList", codeContentList);
		
		
		//字典表 目录分类
		List<Code> classCodeList = codeService.queryCodeListByType(IMySystemConstants.CLASS_CODE);
		model.addAttribute("classCodeList", classCodeList);
		
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
			
			
			List<String> list = getAllDeptCodeByUser(request);
			content.setList(list);
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
	 * @Description: 文章统计
	 * @param request
	 * @param response
	 * @param content
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryContentStatistics")
	public DataTablePageUtil<Content> queryContentStatistics(HttpServletRequest request,
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
			List<Content> contentList = this.contentService.queryContentStatistics(content);
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
	 * @Description: 按部门文章统计
	 * @param request
	 * @param response
	 * @param content
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryContentStatisticsForDept")
	public DataTablePageUtil<Content> queryContentStatisticsByDept(HttpServletRequest request,
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
			List<Content> contentList = this.contentService.queryContentStatisticsForDept(content);
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
			content.setIssue(getSessionUser(request).getLogin_name());
			//发布年份
			content.setYear_code(MyDateUtil.getYear());
			content.setDept_code(getSessionUser(request).getDept());
			//校务
			if(IMySystemConstants.COLUMN102.equals(content.getClass1())){
				content.setOpen_code(IMySystemConstants.VALUE_1);
			}else if(IMySystemConstants.COLUMN107.equals(content.getClass1())){
				content.setOpen_code(IMySystemConstants.VALUE_2);
			}else{
				content.setOpen_code(IMySystemConstants.VALUE_3);
			}
			//设置class1\class2\class3
			String thisColumnId = content.getColumn_id();
			String parentClass1 = getParentClassByColumnId(thisColumnId);
			String parentClass2 = getParentClassByColumnId(parentClass1);
			//选择的是二级菜单
			if("0".equals(parentClass2)) {
				content.setClass1(parentClass1);
				content.setClass2(thisColumnId);
			}else {
				content.setClass1(parentClass2);
				content.setClass2(parentClass1);
				content.setClass3(thisColumnId);
			}
			
			//默认状态为“0”：待审核
			content.setStatus(IMySystemConstants.VALUE_0);
			contentService.addContent(request, content);
			//更新文章编号
			contentService.updateContentOrderNum(content);
			
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
			
			//记录日志
			LogUtil.saveLog(request, "内容管理-添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
			//记录日志
			LogUtil.saveLog(request, "内容管理-添加失败");
		}

		return map;
	}
	
	/**
	 * 
	 * @Description: 根据栏目ID查询父栏目ID 
	 * @param columnId
	 * @return
	 */
	String getParentClassByColumnId(String columnId) {
		int parentClass = 0;
		Column column = columnService.queryColumnById(Integer.parseInt(columnId));
		if(null != column) {
			parentClass = column.getBig_class();
		}
		return parentClass+"";
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
		//修改后状态为“待审核”
		content.setStatus(IMySystemConstants.VALUE_0);
		int count = this.contentService.updateContent(content);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}
		
		//记录日志
		LogUtil.saveLog(request, "内容管理-修改");
		
		return map;
	}
	
	/**
	 * 
	 * @Description: 审核
	 * @param request
	 * @param content
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/auditContent")
	public Map<String, Object> auditContent(HttpServletRequest request, ContentWithBLOBs content) {

		Map<String, Object> map = new HashMap<String, Object>();
		content.setAdd_time(MyDateUtil.getDateTime());
		int count = this.contentService.auditContent(content);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, "审核成功！");
		} else {
			map.put(RESULT_MESSAGE_STRING, "审核失败！");
		}
		
		//记录日志
		LogUtil.saveLog(request, "内容管理-审核");
		
		return map;
	}
	/**
	 * 
	 * @Description: 批量审核，type:3,审核不通过，type:1,审核通过
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/auditContentForMore")
	public Map<String,Object> auditContentForMore(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			String ids = request.getParameter("id");
			String type = request.getParameter("type");
	 		boolean flag = this.contentService.auditContentForMore(ids,type);
			if(flag){
				map.put(RESULT_MESSAGE_STRING, "审核成功！");
			} else {
				map.put(RESULT_MESSAGE_STRING, "审核失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		
		//记录日志
		LogUtil.saveLog(request, "内容管理-删除");
		
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
		
		//记录日志
		LogUtil.saveLog(request, "内容管理-恢复");
		
		return map;
	}
	/**
	 * 
	 * @Description: 查询当前用户的部门和子部门 
	 * @param request
	 * @return
	 */
	protected List<String>  getAllDeptCodeByUser (HttpServletRequest request){
		Map<String,String> map = new HashMap<String,String>();
		// 1级
		String deptCode = getSessionUser(request).getDept();
		map.put(deptCode, deptCode);
		// 2级
		//根据父类查询子节点
		List<Department>  departmentList = this.departmentService.queryDepartmentListByParent(deptCode);
		if(null != departmentList && !departmentList.isEmpty()){
			// 3级
			List<Department>  departmentAllList = this.departmentService.queryDepartmentListByParentList(departmentList);
			if(null != departmentAllList && !departmentAllList.isEmpty()){
				for(Department dept3 : departmentAllList){
					map.put(dept3.getDept_code(), dept3.getDept_code());
				}
			}
		}
		for(Department dept2 : departmentList){
			map.put(dept2.getDept_code(), dept2.getDept_code());
		}
		
		Collection<String> valueCollection = map.values();
	    List<String> valueList = new ArrayList<String>(valueCollection);
	    
		return valueList;
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
	
	/**
	 * 
	 * @Description: 更新点击数 
	 * @param request
	 * @param content
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateContentHits")
	public Map<String, Object> updateContentHits(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String id = request.getParameter("id");
			String hits = request.getParameter("hits");
			this.contentService.updateContentHits(id,hits);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return map;
	}
}
