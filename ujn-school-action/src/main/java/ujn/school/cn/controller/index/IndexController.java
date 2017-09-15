/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.controller.index;

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

import ujn.school.cn.model.carousel.Carousel;
import ujn.school.cn.model.column.Column;
import ujn.school.cn.model.config.Config;
import ujn.school.cn.model.contact.Contact;
import ujn.school.cn.model.content.Content;
import ujn.school.cn.model.content.ContentWithBLOBs;
import ujn.school.cn.model.link.Link;
import ujn.school.cn.pub.base.MyBaseController;
import ujn.school.cn.pub.constants.IMySystemConstants;
import ujn.school.cn.pub.util.MyDateUtil;
import ujn.school.cn.pub.util.MyIpV4Util;
import ujn.school.cn.pub.util.MyRandomUtils;
import ujn.school.cn.service.carousel.ICarouselService;
import ujn.school.cn.service.column.IColumnService;
import ujn.school.cn.service.config.IConfigService;
import ujn.school.cn.service.contact.IContactService;
import ujn.school.cn.service.content.IContentService;
import ujn.school.cn.service.link.ILinkService;

import com.github.pagehelper.PageHelper;

import framework.system.model.Code;
import framework.system.service.ICodeService;

/**
 * @Description: 栏目管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/index/controller/indexController")
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
	
	// 轮播图片Service
	@Resource
	private ICarouselService carouselService;
	
	@Resource
	private ICodeService codeService;
	
	
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
			Config config = configService.queryConfig();
			// 网站联系方式
			Contact contact = contactService.queryContact();
			// 友情链接
			List<Link> linkList = linkService.queryLinkList(null);
			
			// 最新公开信息 :只查询属于校务和党务的栏目及其子栏目里的内容
			Content content1 = new Content();
			//最新发布的6条信息
			content1.setLimit_num(IMySystemConstants.COUNT_NUM6);
			List<Content> contentListNew = contentService.queryContentListByNew(content1);
			model.addAttribute("contentListNew", contentListNew);
			
			
			// 重要信息公开，重要信息显示5条，:只查询属于校务和党务的栏目及其子栏目里的内容
			Content content2 = new Content();
			content2.setLimit_num(IMySystemConstants.COUNT_NUM5);
			List<Content> contentList2 = contentService.queryContentListByImportance(content2);
			model.addAttribute("contentList2", contentList2);
			// 信息公开规章制度 
			Content content3 = new Content();
			String column_id3 = IMySystemConstants.COLUMN109;
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
			List<Column> columnList102 = columnService.queryColumnListByIdAndLevel(IMySystemConstants.COLUMN102,IMySystemConstants.VALUE_2);
			//党务
			List<Column> columnList107 = columnService.queryColumnListByIdAndLevel(IMySystemConstants.COLUMN107,IMySystemConstants.VALUE_2);
			
			model.addAttribute("columnList102", columnList102);
			model.addAttribute("columnList107", columnList107);
			//3级菜单
			List<Column> columnList3 = columnService.queryAllColumnListByLevel3();
			model.addAttribute("columnList3", columnList3);
			//党务
			//LinkedList<Column> columnLinkedList2 = this.toSort(resultList, result, 107);
			//转换为ArrayList
			//List<Column> columnList2 = new ArrayList<Column>(columnLinkedList2);
			Carousel carousel = new Carousel();
			//轮播图片
			carousel.setCarousel_type(IMySystemConstants.VALUE_1);
			List<Carousel> carouselList = this.carouselService.queryCarouselList(carousel);
			
			model.addAttribute("config", config);
			model.addAttribute("contact", contact);
			model.addAttribute("linkList", linkList);
			
			
			model.addAttribute("contentList3", contentList3);
			model.addAttribute("column_id3", column_id3);
			model.addAttribute("columnList", columnList);
			//model.addAttribute("columnList1", columnList1);
			//model.addAttribute("columnList2", columnList2);
			model.addAttribute("carouselList", carouselList);
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
		Config config = configService.queryConfig();
		// 栏目内容 
		Content content = new Content();
		String column_id = request.getParameter("id")==null? "0":request.getParameter("id");
		content.setColumn_id(column_id);
		
		//content.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
		//content.setOrder_type(IMySystemConstants.ORDER_DESC);
		//content.setCount_num(IMySystemConstants.COUNT_NUM4);
		//内容列表
		int pageNo = Integer.parseInt(request.getParameter("p")==null? "0":request.getParameter("p"));
		PageHelper.startPage(pageNo,IMySystemConstants.PAGE_SIZE15);
		List<Content> contentList = contentService.queryContentListByColumn(content);
		int totalRecords = contentList.size();
		int totalPage = (totalRecords  +  IMySystemConstants.PAGE_SIZE15  - 1) / IMySystemConstants.PAGE_SIZE15;  
		
		
		// 侧栏年度报告 
		Content contentReport = new Content();
		String column_id_report = IMySystemConstants.COLUMN113;
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
		
		//校务
		List<Column> columnList102 = columnService.queryColumnListByIdAndLevel(IMySystemConstants.COLUMN102,IMySystemConstants.VALUE_2);
		//党务
		List<Column> columnList107 = columnService.queryColumnListByIdAndLevel(IMySystemConstants.COLUMN107,IMySystemConstants.VALUE_2);
		
		model.addAttribute("columnList102", columnList102);
		model.addAttribute("columnList107", columnList107);
		//3级菜单
		List<Column> columnList3 = columnService.queryAllColumnListByLevel3();
		model.addAttribute("columnList3", columnList3);
		
		List<Column> columnListThis3 = columnService.queryColumnListByIdAndLevel(column_id,IMySystemConstants.VALUE_3);
		model.addAttribute("columnListThis3", columnListThis3);
		model.addAttribute("contact", contact);
		model.addAttribute("config", config);
		model.addAttribute("linkList", linkList);
		model.addAttribute("contentList", contentList);
		model.addAttribute("column_id", column_id);
		model.addAttribute("totalRecords", totalRecords);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("contentReportList", contentReportList);
		model.addAttribute("column", column);
		model.addAttribute("columnList", columnList);
		
		return "site/articleListForLevel3";
	}
	
	
	/**
	 * 
	 * @Description: 3级栏目内容列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/toContentListForLevel3")
	public String toContentListForLevel3(HttpServletRequest request, Model model) {
		// 网站联系方式
		Contact contact = contactService.queryContact();
		// 友情链接
		List<Link> linkList = linkService.queryLinkList(null);
		Config config = configService.queryConfig();
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
		String column_id_report = IMySystemConstants.COLUMN113;
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
		
		//校务
		List<Column> columnList102 = columnService.queryColumnListByIdAndLevel(IMySystemConstants.COLUMN102,IMySystemConstants.VALUE_2);
		//党务
		List<Column> columnList107 = columnService.queryColumnListByIdAndLevel(IMySystemConstants.COLUMN107,IMySystemConstants.VALUE_2);
		
		model.addAttribute("columnList102", columnList102);
		model.addAttribute("columnList107", columnList107);
		//3级菜单
		List<Column> columnList3 = columnService.queryAllColumnListByLevel3();
		model.addAttribute("columnList3", columnList3);
		
		List<Column> columnListThis3 = columnService.queryColumnListByIdAndLevel(column_id,IMySystemConstants.VALUE_3);
		model.addAttribute("columnListThis3", columnListThis3);
		model.addAttribute("contact", contact);
		model.addAttribute("config", config);
		model.addAttribute("linkList", linkList);
		model.addAttribute("contentList", contentList);
		model.addAttribute("column_id", column_id);
		model.addAttribute("totalRecords", totalRecords);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("contentReportList", contentReportList);
		model.addAttribute("column", column);
		model.addAttribute("columnList", columnList);
		return "site/articleListForLevel3";
	}
	
	/**
	 * 
	 * @Description: 信息公开申请 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toContentList112")
	public String toContentList112(HttpServletRequest request, Model model) {
		// 网站联系方式
		Contact contact = contactService.queryContact();
		// 友情链接
		List<Link> linkList = linkService.queryLinkList(null);
		
		Config config = configService.queryConfig();
		
		// 侧栏年度报告 
		Content contentReport = new Content();
		String column_id_report = IMySystemConstants.COLUMN113;
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
		
		//校务
		List<Column> columnList102 = columnService.queryColumnListByIdAndLevel(IMySystemConstants.COLUMN102,IMySystemConstants.VALUE_2);
		//党务
		List<Column> columnList107 = columnService.queryColumnListByIdAndLevel(IMySystemConstants.COLUMN107,IMySystemConstants.VALUE_2);
		
		model.addAttribute("columnList102", columnList102);
		model.addAttribute("columnList107", columnList107);
		//3级菜单
		List<Column> columnList3 = columnService.queryAllColumnListByLevel3();
		model.addAttribute("columnList3", columnList3);
		
		model.addAttribute("contact", contact);
		model.addAttribute("config", config);
		model.addAttribute("linkList", linkList);
		model.addAttribute("contentReportList", contentReportList);
		model.addAttribute("columnList", columnList);
		
		return "site/apply";
	}
	
	
	/**
	 * 
	 * @Description: 信息公开目录
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toContentList111")
	public String toContentList111(HttpServletRequest request, Model model) {
		// 网站联系方式
		Contact contact = contactService.queryContact();
		// 友情链接
		List<Link> linkList = linkService.queryLinkList(null);
		
		Config config = configService.queryConfig();
		
		
		//栏目
		List<Column> resultList = columnService.queryColumnList(null);
		//排序
		LinkedList<Column> result = new LinkedList<Column>();
		LinkedList<Column> columnLinkedList = this.toSort(resultList, result, 0);
		//转换为ArrayList
		List<Column> columnList = new ArrayList<Column>(columnLinkedList);
		
		//校务
		List<Column> columnList102 = columnService.queryColumnListByIdAndLevel(IMySystemConstants.COLUMN102,IMySystemConstants.VALUE_2);
		//党务
		List<Column> columnList107 = columnService.queryColumnListByIdAndLevel(IMySystemConstants.COLUMN107,IMySystemConstants.VALUE_2);
		
		model.addAttribute("columnList102", columnList102);
		model.addAttribute("columnList107", columnList107);
		//3级菜单
		List<Column> columnList3 = columnService.queryAllColumnListByLevel3();
		model.addAttribute("columnList3", columnList3);
		
		//栏目ID
		String column_id = request.getParameter("id")==null? "0":request.getParameter("id");
		model.addAttribute("column_id", column_id);
		
		model.addAttribute("contact", contact);
		model.addAttribute("config", config);
		model.addAttribute("linkList", linkList);
		model.addAttribute("columnList", columnList);
		
		return "site/catalog";
	}
	
	/**
	 * 
	 * @Description: 年度报告
	 * @param model
	 * @return
	 */
	@RequestMapping("/toContentList113")
	public String toContentList113(HttpServletRequest request, Model model) {
		// 网站联系方式
		Contact contact = contactService.queryContact();
		// 友情链接
		List<Link> linkList = linkService.queryLinkList(null);
		Config config = configService.queryConfig();
		// 栏目内容 
		Content content = new Content();
		String column_id = request.getParameter("id")==null? "0":request.getParameter("id");
		content.setColumn_id(column_id);
		
		//content.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
		//content.setOrder_type(IMySystemConstants.ORDER_DESC);
		//content.setCount_num(IMySystemConstants.COUNT_NUM4);
		//内容列表
		int pageNo = Integer.parseInt(request.getParameter("p")==null? "0":request.getParameter("p"));
		PageHelper.startPage(pageNo,IMySystemConstants.PAGE_SIZE15);
		List<Content> contentList = contentService.queryContentListByColumn(content);
		int totalRecords = contentList.size();
		int totalPage = (totalRecords  +  IMySystemConstants.PAGE_SIZE15  - 1) / IMySystemConstants.PAGE_SIZE15;  
		
		
		//点击的栏目
		Column column = columnService.queryColumnById(Integer.parseInt(column_id));
		
		//栏目
		List<Column> resultList = columnService.queryColumnList(null);
		//排序
		LinkedList<Column> result = new LinkedList<Column>();
		LinkedList<Column> columnLinkedList = this.toSort(resultList, result, 0);
		//转换为ArrayList
		List<Column> columnList = new ArrayList<Column>(columnLinkedList);
		
		//校务
		List<Column> columnList102 = columnService.queryColumnListByIdAndLevel(IMySystemConstants.COLUMN102,IMySystemConstants.VALUE_2);
		//党务
		List<Column> columnList107 = columnService.queryColumnListByIdAndLevel(IMySystemConstants.COLUMN107,IMySystemConstants.VALUE_2);
		
		model.addAttribute("columnList102", columnList102);
		model.addAttribute("columnList107", columnList107);
		//3级菜单
		List<Column> columnList3 = columnService.queryAllColumnListByLevel3();
		model.addAttribute("columnList3", columnList3);
		
		List<Column> columnListThis3 = columnService.queryColumnListByIdAndLevel(column_id,IMySystemConstants.VALUE_3);
		model.addAttribute("columnListThis3", columnListThis3);
		model.addAttribute("contact", contact);
		model.addAttribute("config", config);
		model.addAttribute("linkList", linkList);
		model.addAttribute("contentList", contentList);
		model.addAttribute("column_id", column_id);
		model.addAttribute("totalRecords", totalRecords);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("column", column);
		model.addAttribute("columnList", columnList);
		
		return "site/articleListForReport";
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
		Config config = configService.queryConfig();
		// 友情链接
		List<Link> linkList = linkService.queryLinkList(null);
		
		int contentId =  Integer.parseInt(nullToStringZero(request.getParameter("id")));
		Content content = contentService.queryContentById(contentId);
		
		//设置当前位置
		String thisColumnId = content.getColumn_id();
		Column thisColumn = columnService.queryColumnById(Integer.parseInt(thisColumnId));
		//当前栏目
		model.addAttribute("locationThis", thisColumn.getName());
		model.addAttribute("locationidThis", thisColumnId);
		//当前栏目的父类
		Column parentColumn1 = columnService.queryColumnById(thisColumn.getBig_class());
		if(null != parentColumn1) {
			model.addAttribute("location3", parentColumn1.getName());
			model.addAttribute("locationid3", parentColumn1.getId());
			//父类的父类
			Column parentColumn2 = columnService.queryColumnById(parentColumn1.getBig_class());
			//选择的是三级菜单
			if(null != parentColumn2) {
				model.addAttribute("location2", parentColumn2.getName());
				model.addAttribute("locationid2", parentColumn2.getId());
			}
		}
		
		//栏目
		List<Column> resultList = columnService.queryColumnList(null);
		//排序
		LinkedList<Column> result = new LinkedList<Column>();
		LinkedList<Column> columnLinkedList = this.toSort(resultList, result, 0);
		//转换为ArrayList
		List<Column> columnList = new ArrayList<Column>(columnLinkedList);
		model.addAttribute("columnList", columnList);
		
		//校务
		List<Column> columnList102 = columnService.queryColumnListByIdAndLevel(IMySystemConstants.COLUMN102,IMySystemConstants.VALUE_2);
		//党务
		List<Column> columnList107 = columnService.queryColumnListByIdAndLevel(IMySystemConstants.COLUMN107,IMySystemConstants.VALUE_2);
		
		model.addAttribute("columnList102", columnList102);
		model.addAttribute("columnList107", columnList107);
		//3级菜单
		List<Column> columnList3 = columnService.queryAllColumnListByLevel3();
		model.addAttribute("columnList3", columnList3);
		
		model.addAttribute("contact", contact);
		model.addAttribute("config", config);
		model.addAttribute("linkList", linkList);
		model.addAttribute("content", content);
		
		return "site/article";
	}
	
	
	/**
	 * 
	 * @Description: 根据栏目ID查询父栏目ID 
	 * @param columnId
	 * @return
	 */
	Column getParentColumnByColumnId(String columnId) {
		Column column = columnService.queryColumnById(Integer.parseInt(columnId));
		return column;
	}
	
	@RequestMapping("/toContentDetailByPwd")
	public String toContentDetailByPwd(HttpServletRequest request, Model model) {

		return "site/article";
	}
	
	/**
	 * 
	 * @Description: 查询子栏目
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryColumnListByIdAndLevel")
	public List<Column> queryColumnListByIdAndLevel(HttpServletRequest request){
		List<Column> listColumn = new ArrayList<Column>();
		String id = nullToString(request.getParameter("id"));
		String level = nullToString(request.getParameter("level"));
		listColumn = columnService.queryColumnListByIdAndLevel(id,level);
		
		return listColumn;
	}
	/**
	 * 
	 * @Description: 内容访问方式验证
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
					if(checkUserIp(ip)){
						//允许访问
						open_type = IMySystemConstants.VALUE_1;
					}else{
						//不允许访问
						open_type = IMySystemConstants.VALUE_3;
					}
					/*// 网站配置
					Config config = configService.queryConfig();
					String ipSection = config.getIp_section();
					if(MyIpUtil.ipExistsInRange(ip, ipSection)){
						//允许访问
						open_type = IMySystemConstants.VALUE_1;
					}else{
						//不允许访问
						open_type = IMySystemConstants.VALUE_3;
					}*/
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
	 * @Description: 验证用户IP是否在网站设置的IP范围内 
	 * @param userIp
	 * @return
	 */
	public boolean checkUserIp(String userIp) {
		//获取设置的IP范围
		String code_type = "IP_SCOPE";
		List<Code>  codeList = this.codeService.queryCodeListByType(code_type);
		//默认值
		boolean flag = false;
		for(Code codeIp : codeList){
			System.out.println(codeIp.getCode_value());
			String[] idScope = codeIp.getCode_value().split("-");
			if(2 == idScope.length){
				String startIp = idScope[0];
				String endIp = idScope[1];
				//startIp > endIp
				if(MyIpV4Util.compareIpV4s(startIp, endIp) > 0){
					//判断条件为用户ip大于endIp,小于等于startIp
					if((MyIpV4Util.compareIpV4s(userIp, endIp) >= 0) && (MyIpV4Util.compareIpV4s(userIp, startIp) <= 0)){
						flag = true;
						break;
					}
				}else{
					//startIp < endIp
					//判断条件为用户ip大于startIp,小于等于endIp
					if((MyIpV4Util.compareIpV4s(userIp, startIp) >= 0) && (MyIpV4Util.compareIpV4s(userIp, endIp) <= 0)){
						flag = true;
						break;
					}
				}
			}
			
		}
		return flag;
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
	 * @Description: 搜索
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) {
		String search_text = request.getParameter("serach_text")==null? "":request.getParameter("serach_text");
		
		//内容列表
		//List<Content> contentList = contentService.queryContentList(content);
		
		// 网站联系方式
		Contact contact = contactService.queryContact();
		// 友情链接
		List<Link> linkList = linkService.queryLinkList(null);
		
		// 侧栏年度报告 
		Content contentReport = new Content();
		String column_id_report = IMySystemConstants.COLUMN113;
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
		//model.addAttribute("contentList", contentList);
		model.addAttribute("contentReportList", contentReportList);
		model.addAttribute("columnList", columnList);
		model.addAttribute("search_text", search_text);
		
		return "site/searchList";
	}
	
	/**
	 * 
	 * @Description: 搜索结果分页 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/searchForPage")
	public List<Content> searchForPage(HttpServletRequest request) {
		List<Content> listContentPage = null;
		String search_text = request.getParameter("serach_text")==null? "":request.getParameter("serach_text");
		try {
			// 最新公开信息 
			ContentWithBLOBs content = new ContentWithBLOBs();
			content.setTitle(search_text);
			content.setContent(search_text);
			content.setKeywords(search_text);
			content.setDescription(search_text);
			content.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
			content.setOrder_type(IMySystemConstants.ORDER_DESC);
			content.setCount_num(IMySystemConstants.COUNT_NUM4);
			// 所有数据
			listContentPage = contentService.queryContentListForSearch(content);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listContentPage;
	}
	
	
	//重要信息列表
	@RequestMapping("/queryContentListForImportance")
	public String queryContentListForImportance(HttpServletRequest request, Model model) {
		
		//内容列表
		int pageNo = Integer.parseInt(request.getParameter("p")==null? "0":request.getParameter("p"));
		PageHelper.startPage(pageNo,IMySystemConstants.PAGE_SIZE15);
		List<Content> contentList = contentService.queryContentListByImportance(null);
		int totalRecords = contentList.size();
		int totalPage = (totalRecords  +  IMySystemConstants.PAGE_SIZE15  - 1) / IMySystemConstants.PAGE_SIZE15;  
		
		// 网站联系方式
		Contact contact = contactService.queryContact();
		// 友情链接
		List<Link> linkList = linkService.queryLinkList(null);
		
		// 侧栏年度报告 
		Content contentReport = new Content();
		String column_id_report = IMySystemConstants.COLUMN113;
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
		model.addAttribute("search_text", "重要公开信息");
		
		return "site/searchList";
	}
	
	//最新公开信息分页列表
	@RequestMapping("/queryContentListForNew")
	public String queryContentListForNew(HttpServletRequest request, Model model) {
			
		//内容列表
		//List<Content> contentList = contentService.queryContentListByNew(null);
		
		// 网站联系方式
		Contact contact = contactService.queryContact();
		// 友情链接
		List<Link> linkList = linkService.queryLinkList(null);
		
		// 侧栏年度报告 
		Content contentReport = new Content();
		String column_id_report = IMySystemConstants.COLUMN113;
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
		//model.addAttribute("contentList", contentList);
		model.addAttribute("contentReportList", contentReportList);
		model.addAttribute("columnList", columnList);
		model.addAttribute("search_text", "最新公开信息");
		
		return "site/articleNewList";
	}
	
	/**
	 * 
	 * @Description: 最新公开分页 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/articleNewForPage")
	public List<Content> articleNewForPage(HttpServletRequest request) {
		List<Content> listContentPage = null;
		try {
			Content content = new Content();
			// 所有数据
			listContentPage = contentService.queryContentListByNew(content);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listContentPage;
	}
	
	/**
	 * 
	 * @Description: 信息公开制度-更多-分页列表 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryContentListForPage109")
	public String queryContentListForPage109(HttpServletRequest request, Model model) {
			
		// 网站联系方式
		Contact contact = contactService.queryContact();
		// 友情链接
		List<Link> linkList = linkService.queryLinkList(null);
		
		// 侧栏年度报告 
		Content contentReport = new Content();
		String column_id_report = IMySystemConstants.COLUMN113;
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
		model.addAttribute("contentReportList", contentReportList);
		model.addAttribute("columnList", columnList);
		model.addAttribute("search_text", "最新公开信息");
		
		return "site/articleList109";
	}
	
	/**
	 * 
	 * @Description: 信息公开制度
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/articleListForPage109")
	public List<Content> articleListForPage109(HttpServletRequest request) {
		List<Content> listContentPage = null;
		try {
			Content content = new Content();
			content.setColumn_id("109");
			// 所有数据
			listContentPage = contentService.queryContentListByColumn(content);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listContentPage;
	}
	
	/**
	 * 
	 * @Description: 信息公开指南-更多-分页列表 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryContentListForPage110")
	public String queryContentListForPage110(HttpServletRequest request, Model model) {
			
		// 网站联系方式
		Contact contact = contactService.queryContact();
		// 友情链接
		List<Link> linkList = linkService.queryLinkList(null);
		
		// 侧栏年度报告 
		Content contentReport = new Content();
		String column_id_report = IMySystemConstants.COLUMN113;
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
		model.addAttribute("contentReportList", contentReportList);
		model.addAttribute("columnList", columnList);
		model.addAttribute("search_text", "最新公开信息");
		
		return "site/articleList110";
	}
	
	/**
	 * 
	 * @Description: 信息公开指南
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/articleListForPage110")
	public List<Content> articleListForPage110(HttpServletRequest request) {
		List<Content> listContentPage = null;
		try {
			Content content = new Content();
			content.setColumn_id("110");
			// 所有数据
			listContentPage = contentService.queryContentListByColumn(content);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listContentPage;
	}
	
	/**
	 * 
	 * @Description: 年度报告-更多-分页列表 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryContentListForPage113")
	public String queryContentListForPage113(HttpServletRequest request, Model model) {
			
		// 网站联系方式
		Contact contact = contactService.queryContact();
		// 友情链接
		List<Link> linkList = linkService.queryLinkList(null);
		
		// 侧栏年度报告 
		Content contentReport = new Content();
		String column_id_report = IMySystemConstants.COLUMN113;
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
		model.addAttribute("contentReportList", contentReportList);
		model.addAttribute("columnList", columnList);
		model.addAttribute("search_text", "最新公开信息");
		
		return "site/articleList113";
	}
	
	/**
	 * 
	 * @Description: 年度报告
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/articleListForPage113")
	public List<Content> articleListForPage113(HttpServletRequest request) {
		List<Content> listContentPage = null;
		try {
			Content content = new Content();
			content.setColumn_id("113");
			// 所有数据
			listContentPage = contentService.queryContentListByColumn(content);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listContentPage;
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
	
	/**
	 * 
	 * @Description: 重新生成访问密码 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/createPwd")
	public String createPwd(HttpServletRequest request) {
		String randomPwd = MyRandomUtils.randomString(IMySystemConstants.COUNT_NUM8);
		return randomPwd;
	}
}
