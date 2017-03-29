/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.controller.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.yuanyuansinian.model.column.Column;
import com.yuanyuansinian.model.contact.Contact;
import com.yuanyuansinian.model.content.Content;
import com.yuanyuansinian.model.content.ContentWithBLOBs;
import com.yuanyuansinian.model.hall.Hall;
import com.yuanyuansinian.model.link.Link;
import com.yuanyuansinian.model.member.Member;
import com.yuanyuansinian.model.oration.Oration;
import com.yuanyuansinian.pub.base.MyBaseController;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.column.IColumnService;
import com.yuanyuansinian.service.config.IConfigService;
import com.yuanyuansinian.service.contact.IContactService;
import com.yuanyuansinian.service.content.IContentService;
import com.yuanyuansinian.service.hall.IHallService;
import com.yuanyuansinian.service.link.ILinkService;
import com.yuanyuansinian.service.oration.IOrationService;

/**
 * @Description: 主页管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/sinian/index/indexController")
public class IndexController extends MyBaseController {
	// 栏目
	@Resource
	private IColumnService columnService;
	// 网站配置
	@Resource
	private IConfigService configService;
	// 网站联系方式
	@Resource
	private IContactService contactService;
	// 友情链接
	@Resource
	private ILinkService linkService;
	// 内容Service
	@Resource
	private IContentService contentService;
	
	// 纪念馆
	@Resource
	private IHallService hallService;
	
	// 纪念馆
	@Resource
	private IOrationService orationService;
	
	/**
	 * @Description:  显示网站主页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request,  Model model) {
		try {
			// 网站配置
			//Config config = configService.queryConfig();
			// 网站联系方式
			//Contact contact = contactService.queryContact();
			// 友情链接
			List<Link> linkList = linkService.queryLinkList(null);
			// 最新公开信息 
			Content content1 = new Content();
			String column_id1 = "111";
			content1.setColumn_id(column_id1);
			content1.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
			content1.setOrder_type(IMySystemConstants.ORDER_DESC);
			content1.setCount_num(IMySystemConstants.COUNT_NUM4);
			//内容列表
			List<Content> contentList1 = contentService.queryContentListByColumn(content1);
			// 重要信息公开 
			Content content2 = new Content();
			String column_id2 = "112";
			content2.setColumn_id(column_id2);
			content2.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
			content2.setOrder_type(IMySystemConstants.ORDER_DESC);
			content2.setCount_num(IMySystemConstants.COUNT_NUM2);
			//内容列表
			List<Content> contentList2 = contentService.queryContentListByColumn(content2);
			// 信息公开规章制度 
			Content content3 = new Content();
			String column_id3 = "103";
			content3.setColumn_id(column_id3);
			content3.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
			content3.setOrder_type(IMySystemConstants.ORDER_DESC);
			content3.setCount_num(IMySystemConstants.COUNT_NUM2);
			//内容列表
			List<Content> contentList3 = contentService.queryContentListByColumn(content3);
			
			//栏目
			List<Column> resultList = columnService.queryColumnList(null);
			//排序
			LinkedList<Column> result = new LinkedList<Column>();
			LinkedList<Column> columnLinkedList = this.toSort(resultList, result, 0);
			//转换为ArrayList
			List<Column> columnList = new ArrayList<Column>(columnLinkedList);
			
			
			//校务
			//LinkedList<Column> columnLinkedList1 = this.toSort(resultList, result, 102);
			//转换为ArrayList
			//List<Column> columnList1 = new ArrayList<Column>(columnLinkedList1);
			
			
			//党务
			//LinkedList<Column> columnLinkedList2 = this.toSort(resultList, result, 107);
			//转换为ArrayList
			//List<Column> columnList2 = new ArrayList<Column>(columnLinkedList2);
			
			
			//model.addAttribute("config", config);
			//model.addAttribute("contact", contact);
			model.addAttribute("linkList", linkList);
			model.addAttribute("contentList1", contentList1);
			model.addAttribute("column_id1", column_id1);
			model.addAttribute("contentList2", contentList2);
			model.addAttribute("column_id2", column_id2);
			model.addAttribute("contentList3", contentList3);
			model.addAttribute("column_id3", column_id3);
			model.addAttribute("columnList", columnList);
			//model.addAttribute("columnList1", columnList1);
			//model.addAttribute("columnList2", columnList2);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "site/index";
	}
	
	/**
	 * 
	 * @Description: 跳转到栏目更多页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toContentList")
	public String toContentList(HttpServletRequest request, Model model) {
		// 网站联系方式
		Contact contact = contactService.queryContact();
		// 友情链接
		List<Link> linkList = linkService.queryLinkList(null);
		
		// 最新公开信息 
		Content content = new Content();
		String column_id = request.getParameter("id")==null? "0":request.getParameter("id");
		content.setColumn_id(column_id);
		content.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
		content.setOrder_type(IMySystemConstants.ORDER_DESC);
		content.setCount_num(IMySystemConstants.COUNT_NUM4);
		//内容列表
		int pageNo = Integer.parseInt(request.getParameter("p")==null? "0":request.getParameter("p"));
		PageHelper.startPage(pageNo,IMySystemConstants.PAGE_SIZE15);
		List<Content> contentList = contentService.queryContentListByColumn(content);
		int totalRecords = contentList.size();
		int totalPage = (totalRecords  +  IMySystemConstants.PAGE_SIZE15  - 1) / IMySystemConstants.PAGE_SIZE15;  
		
		
		// 侧栏年度报告 
		Content contentReport = new Content();
		String column_id_report = "103";
		contentReport.setColumn_id(column_id_report);
		contentReport.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
		contentReport.setOrder_type(IMySystemConstants.ORDER_DESC);
		contentReport.setCount_num(IMySystemConstants.COUNT_NUM5);
		//年度报告内容列表
		List<Content> contentReportList = contentService.queryContentListByColumn(contentReport);
		//点击的栏目
		Column column = columnService.queryColumnById(Integer.parseInt(column_id));
		
		//栏目
		List<Column> resultList = columnService.queryColumnList(null);
		//排序
		LinkedList<Column> result = new LinkedList<Column>();
		LinkedList<Column> columnLinkedList = this.toSort(resultList, result, 0);
		//转换为ArrayList
		List<Column> columnList = new ArrayList<Column>(columnLinkedList);
		
		model.addAttribute("contact", contact);
		model.addAttribute("linkList", linkList);
		model.addAttribute("contentList", contentList);
		model.addAttribute("column_id", column_id);
		model.addAttribute("totalRecords", totalRecords);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("contentReportList", contentReportList);
		model.addAttribute("column", column);
		model.addAttribute("columnList", columnList);
		return "site/articleList";
	}

	
	/**
	 * 
	 * @Description: 跳转到详情页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toContentDetail")
	public String toContentDetail(HttpServletRequest request, Model model) {
		// 网站联系方式
		Contact contact = contactService.queryContact();
		// 友情链接
		List<Link> linkList = linkService.queryLinkList(null);
		
		int contentId = Integer.parseInt((request.getParameter("id")==null? "0":request.getParameter("id")));
		Content content = contentService.queryContentById(contentId);
		
		model.addAttribute("contact", contact);
		model.addAttribute("linkList", linkList);
		model.addAttribute("content", content);
		
		return "site/article";
	}
	
	@RequestMapping("/toContentDetailByPwd")
	public String toContentDetailByPwd(HttpServletRequest request, Model model) {

		return "site/article";
	}
	
	@RequestMapping("/toRegister")
	public String toRegister(HttpServletRequest request, Model model) {
		
		return "site/register";
	}
	
	/**
	 * 
	 * @Description: 
	 * @param request
	 * @param column
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toContentCheck")
	public Map<String, Object> toContentCheck(HttpServletRequest request) {
		//默认3，不允许访问
		String open_type = IMySystemConstants.VALUE_3;
		Map<String, Object> map = new HashMap<String, Object>();
		String contentId = request.getParameter("id")==null? "0":request.getParameter("id");
		Content content = contentService.queryContentById(Integer.parseInt(contentId));
		// 有效日期
		String validity_time = "";
		String read_type = "";
		if(null != content){
			validity_time = content.getValidity_time();
			read_type = content.getRead_type();
			String now = MyDateUtil.getDateTime();
			//比较日期
			if(MyDateUtil.getMargin(now, validity_time) > 1){
				//已过有效期
			}else{
				if(IMySystemConstants.VALUE_0.equals(read_type)){
					//0：直接查看
					open_type = IMySystemConstants.VALUE_0;
				}else if(IMySystemConstants.VALUE_1.equals(read_type)){
					//验证IP
					String ip = getIpAddr(request);
					if("127.0.0.1".equals(ip)){
						//允许访问
						open_type = IMySystemConstants.VALUE_1;
					}else{
						//不允许访问
						open_type = IMySystemConstants.VALUE_3;
					}
				}else if(IMySystemConstants.VALUE_2.equals(read_type)){
					//2：输入密码查看
					open_type = IMySystemConstants.VALUE_2;
				}
			}
		}
		
		map.put("open_type", open_type);

		return map;
	}
	
	/**
	 * 
	 * @Description: 验证访问密码 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toContentCheckPwd")
	public Map<String, Object> toContentCheckPwd(HttpServletRequest request) {
		//默认4，密码错误不允许访问
		String open_type = IMySystemConstants.VALUE_4;
		Map<String, Object> map = new HashMap<String, Object>();
		String contentId = request.getParameter("id")==null? "0":request.getParameter("id");
		String pwd = request.getParameter("pwd")==null? "":request.getParameter("pwd");
		Content content = contentService.queryContentById(Integer.parseInt(contentId));
		// 有效日期
		String read_pwd = "";
		if(null != content){
			read_pwd = content.getRead_pwd();
			if(!"".equals(read_pwd) && pwd.equals(read_pwd)){
				//密码正确可以访问
				open_type = IMySystemConstants.VALUE_5;
			}else{
				//密码错误不允许访问
				open_type = IMySystemConstants.VALUE_4;
			}
		}
		
		map.put("open_type", open_type);

		return map;
	}
	
	/**
	 * 
	 * @Description: TODO 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) {
		String search_text = request.getParameter("serach_text")==null? "":request.getParameter("serach_text");
		// 最新公开信息 
		ContentWithBLOBs content = new ContentWithBLOBs();
		content.setTitle(search_text);
		content.setContent(search_text);
		content.setKeywords(search_text);
		content.setDescription(search_text);
		content.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
		content.setOrder_type(IMySystemConstants.ORDER_DESC);
		content.setCount_num(IMySystemConstants.COUNT_NUM4);
		//内容列表
		int pageNo = Integer.parseInt(request.getParameter("p")==null? "0":request.getParameter("p"));
		PageHelper.startPage(pageNo,IMySystemConstants.PAGE_SIZE15);
		List<Content> contentList = contentService.queryContentList(content);
		int totalRecords = contentList.size();
		int totalPage = (totalRecords  +  IMySystemConstants.PAGE_SIZE15  - 1) / IMySystemConstants.PAGE_SIZE15;  
		
		// 网站联系方式
		Contact contact = contactService.queryContact();
		// 友情链接
		List<Link> linkList = linkService.queryLinkList(null);
		
		// 侧栏年度报告 
		Content contentReport = new Content();
		String column_id_report = "103";
		contentReport.setColumn_id(column_id_report);
		contentReport.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
		contentReport.setOrder_type(IMySystemConstants.ORDER_DESC);
		contentReport.setCount_num(IMySystemConstants.COUNT_NUM5);
		//年度报告内容列表
		List<Content> contentReportList = contentService.queryContentListByColumn(contentReport);
		
		//栏目
		List<Column> resultList = columnService.queryColumnList(null);
		//排序
		LinkedList<Column> result = new LinkedList<Column>();
		LinkedList<Column> columnLinkedList = this.toSort(resultList, result, 0);
		//转换为ArrayList
		List<Column> columnList = new ArrayList<Column>(columnLinkedList);
		
		model.addAttribute("contact", contact);
		model.addAttribute("linkList", linkList);
		model.addAttribute("contentList", contentList);
		model.addAttribute("totalRecords", totalRecords);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("contentReportList", contentReportList);
		model.addAttribute("columnList", columnList);
		model.addAttribute("search_text", search_text);
		
		return "site/searchList";
	}
	
	
	/**
	 * 
	 * @Description: 纪念馆搜索
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/searchHall")
	public String searchHall(HttpServletRequest request, Model model) {
		String search_text = request.getParameter("hall_name")==null? "":request.getParameter("hall_name");
		// 最新公开信息 
		//网上纪念馆:公开属性，单人和双人
		List<Hall> listHallBySearch = hallService.queryHallListBySearch(search_text);
		
		model.addAttribute("search_text", search_text);
		model.addAttribute("listHallBySearch", listHallBySearch);
		
		return "site/hallSearchList";
	}
	
	/**
	 * 
	 * @Description: 网站联系方式 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/contact")
	public Map<String, Object> contact(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 网站联系方式
			Contact contact = contactService.queryContact();
			map.put("contact", contact);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/navigation")
	public Map<String, Object> navigation(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//栏目
			List<Column> resultList = columnService.queryColumnListForNavigation(IMySystemConstants.COUNT_NUM1);
			//排序
			LinkedList<Column> result = new LinkedList<Column>();
			LinkedList<Column> columnLinkedList = this.toSort(resultList, result, 0);
			//转换为ArrayList
			List<Column> columnList = new ArrayList<Column>(columnLinkedList);
			
			map.put("columnList", columnList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map;
	}
	
	
	/**
	 * 
	 * @Description: 通知公告 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/notice")
	public Map<String, Object> notice(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 通知公告
			Content contentNotice = new Content();
			String column_id = "123";
			contentNotice.setColumn_id(column_id);
			contentNotice.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
			contentNotice.setOrder_type(IMySystemConstants.ORDER_DESC);
			contentNotice.setCount_num(IMySystemConstants.COUNT_NUM9);
			//通知公告
			List<Content> contentNoticeList = contentService.queryContentListByColumn(contentNotice);
			
			map.put("contentNoticeList", contentNoticeList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 
	 * @Description: 跳转到通知公告-详情页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toNoticeDetail")
	public String toNoticeDetail(HttpServletRequest request, Model model) {
		
		int contentId = Integer.parseInt((request.getParameter("id")==null? "0":request.getParameter("id")));
		Content content = contentService.queryContentById(contentId);
		
		model.addAttribute("content", content);
		
		return "site/noticeDetail";
	}
	
	/**
	 * 
	 * @Description: 跳转到通知公告列表页 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toNoticeList")
	public String toNoticeList(HttpServletRequest request, Model model) {
		
		// 通知公告
		Content contentNotice = new Content();
		String column_id = "123";
		contentNotice.setColumn_id(column_id);
		contentNotice.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
		contentNotice.setOrder_type(IMySystemConstants.ORDER_DESC);
		contentNotice.setCount_num(IMySystemConstants.COUNT_NUM9);
		//通知公告
		List<Content> contentNoticeList = contentService.queryContentList(contentNotice);
		
		model.addAttribute("contentNoticeList", contentNoticeList);
		
		return "site/noticeDetail";
	}
	
	
	/**
	 * 
	 * @Description: 友情链接 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/link")
	public Map<String, Object> link(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 友情链接
			List<Link> linkList = linkService.queryLinkList(null);
			
			map.put("linkList", linkList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * @Description:  纪念馆列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallList")
	public String toHallList(HttpServletRequest request, Model model) {
		
		//最新建馆
		List<Hall> listHallNew = hallService.queryHallNewList(IMySystemConstants.COUNT_NUM6);
		//最新文章
		List<Oration> listOrationNew = orationService.queryOrationNewList(IMySystemConstants.COUNT_NUM6);
		//网上纪念馆:公开属性，单人和双人
		List<Hall> listHallByOpenType = hallService.queryHallListByOpenType(IMySystemConstants.VALUE_2);
		
		model.addAttribute("listHallNew", listHallNew);
		model.addAttribute("listOrationNew", listOrationNew);
		model.addAttribute("listHallByOpenType", listHallByOpenType);
		return "site/hallList";
	}
	
	/**
	 * 
	 * @Description:  纪念馆内容页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallDetail")
	public String toHallDetail(HttpServletRequest request, Model model) {

		return "site/hallDetail";
	}
	
	/**
	 * 
	 * @Description: 缘园资讯列表(首页和列表页为一个)
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toInformationList")
	public String toInformationList(HttpServletRequest request, Model model) {
		//
		String columnId = "107";
		String columnChildDefault = "124";
		//子栏目
		List<Column> columnChildList = columnService.queryChildColumnListByColumnId(columnId);
		
		//点击的子栏目
		String columnChildId = request.getParameter("id")==null? columnChildDefault:request.getParameter("id");
		String columnChildName = (columnService.queryColumnById(Integer.parseInt(columnChildId))).getName();
		//子栏目内容
		Content contentChild = new Content();
		contentChild.setColumn_id(columnChildId);
		contentChild.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
		contentChild.setOrder_type(IMySystemConstants.ORDER_DESC);
		contentChild.setCount_num(IMySystemConstants.COUNT_NUM5);
		//子栏目内容
		List<Content> contentChildList = contentService.queryContentListByColumn(contentChild);
		
		
		model.addAttribute("columnChildList", columnChildList);
		model.addAttribute("contentChildList", contentChildList);
		model.addAttribute("columnChildId", columnChildId);
		model.addAttribute("columnChildName", columnChildName);
		
		return "site/informationList";
	}
	
	/**
	 * 
	 * @Description: 缘园资讯列表详情页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toInformationDetail")
	public String toInformationDetail(HttpServletRequest request, Model model) {
		//
		String columnId = "107";
		String columnChildDefault = "124";
		//子栏目
		List<Column> columnChildList = columnService.queryChildColumnListByColumnId(columnId);
		
		//点击的子栏目
		String columnChildId = request.getParameter("column_id")==null? columnChildDefault:request.getParameter("column_id");
		String columnChildName = (columnService.queryColumnById(Integer.parseInt(columnChildId))).getName();
		//内容id
		int contentId = Integer.parseInt((request.getParameter("id")==null? "0":request.getParameter("id")));
		Content content = contentService.queryContentById(contentId);
		
		
		model.addAttribute("columnChildList", columnChildList);
		model.addAttribute("content", content);
		model.addAttribute("columnChildId", columnChildId);
		model.addAttribute("columnChildName", columnChildName);
		
		return "site/informationDetail";
	}
	
	
	/**
	 * 
	 * @Description: 商城列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toShoppingList")
	public String toShoppingList(HttpServletRequest request, Model model) {
		
		return "site/shoppingList";
	}
	
	/**
	 * 
	 * @Description:  商城内容页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toShoppingDetail")
	public String toShoppingDetail(HttpServletRequest request, Model model) {

		return "site/shoppingDetail";
	}
	
	/**
	 * 
	 * @Description: 公墓陵园列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCemeteryList")
	public String toCemeteryList(HttpServletRequest request, Model model) {
		
		return "site/cemeteryList";
	}
	
	/**
	 * 
	 * @Description:  公墓陵园内容页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCemeteryDetail")
	public String toCemeteryDetail(HttpServletRequest request, Model model) {

		return "site/cemeteryDetail";
	}
	
	/**
	 * 
	 * @Description: 我的思念
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toMemberCenter")
	public String toMemberCenter(HttpServletRequest request, Model model) {
		//获取登录的会员
		Member memberUser = super.getSessionMemberUser(request);
		if(null == memberUser){
			return "redirect:/sinian/index/indexController/toMemberLogin";
		}else{
			model.addAttribute("memberUser", memberUser);
			return "site/memberCenter";
		}
		
	}
	
	//购物车
	@RequestMapping("/toMemberCart")
	public String toMemberCart(HttpServletRequest request, Model model) {
		
		
		return "site/memberCart";
	}
	
	
	//我的创建
	@RequestMapping("/toMemberCreate")
	public String toMemberCreate(HttpServletRequest request, Model model) {
		
		
		return "site/memberCreate";
	}
	/**
	 * 
	 * @Description: 会员信息页面，可修改密码，修改信息 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toMemberEdit")
	public String toMemberEdit(HttpServletRequest request, Model model) {
		
		
		return "site/memberEdit";
	}
		
	/**
	 * 
	 * @Description:  我的思念内容页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toMemberCenterDetail")
	public String toMemberCenterDetail(HttpServletRequest request, Model model) {

		return "site/memberCenterDetail";
	}
	
	/**
	 * 
	 * @Description: 跳转到会员登录 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toMemberLogin")
	public String toMemberLogin(HttpServletRequest request, Model model) {
		
		return "site/memberLogin";
	}
	
	/**
	 * 获取IP
	 * @param request
	 * @return
	 */
	String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * 
	 * @Description: 栏目排序 
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
