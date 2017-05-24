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
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.github.pagehelper.PageHelper;
import com.yuanyuansinian.alipay.config.AlipayConfig;
import com.yuanyuansinian.model.carousel.Carousel;
import com.yuanyuansinian.model.cart.Cart;
import com.yuanyuansinian.model.cemetery.Cemetery;
import com.yuanyuansinian.model.column.Column;
import com.yuanyuansinian.model.contact.Contact;
import com.yuanyuansinian.model.content.Content;
import com.yuanyuansinian.model.content.ContentWithBLOBs;
import com.yuanyuansinian.model.gift.HallGift;
import com.yuanyuansinian.model.hall.Hall;
import com.yuanyuansinian.model.hall.HallDouble;
import com.yuanyuansinian.model.link.Link;
import com.yuanyuansinian.model.member.Member;
import com.yuanyuansinian.model.oration.Oration;
import com.yuanyuansinian.model.order.Order;
import com.yuanyuansinian.model.product.Product;
import com.yuanyuansinian.model.warehouse.Warehouse;
import com.yuanyuansinian.pub.base.MyBaseController;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyAutoGenerateOrderNum;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.carousel.ICarouselService;
import com.yuanyuansinian.service.cart.ICartService;
import com.yuanyuansinian.service.cemetery.ICemeteryService;
import com.yuanyuansinian.service.column.IColumnService;
import com.yuanyuansinian.service.config.IConfigService;
import com.yuanyuansinian.service.contact.IContactService;
import com.yuanyuansinian.service.content.IContentService;
import com.yuanyuansinian.service.gift.IHallGiftService;
import com.yuanyuansinian.service.hall.IHallDoubleService;
import com.yuanyuansinian.service.hall.IHallService;
import com.yuanyuansinian.service.link.ILinkService;
import com.yuanyuansinian.service.oration.IOrationService;
import com.yuanyuansinian.service.order.IOrderService;
import com.yuanyuansinian.service.product.IProductService;
import com.yuanyuansinian.service.warehouse.IWarehouseService;

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
	
	// 
	@Resource
	private IOrationService orationService;
	
	// 产品Service
	@Resource
	private IProductService productService;
	
	// 轮播图片Service
	@Resource
	private ICarouselService carouselService;
	
	// 墓地陵园Service
	@Resource
	private ICemeteryService cemeteryService;
	// 购物车
	@Resource
	private ICartService cartService;
	// 订单
	@Resource
	private IOrderService orderService;
	
	// 双人纪念馆Service
	@Resource
	private IHallDoubleService hallDoubleService;
	
	@Resource
	private IWarehouseService warehouseService;
	
	// 纪念馆灵堂礼物Service
	@Resource
	private IHallGiftService hallGiftService;
	
	/**
	 * @Description:  显示网站主页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request,  Model model) {
		try {
			// 友情链接
			//List<Link> linkList = linkService.queryLinkList(null);
			//model.addAttribute("linkList", linkList);
			//最新建馆
			List<Hall> listHallNew = hallService.queryHallNewList(IMySystemConstants.COUNT_NUM6);
			//最新建馆 列表
			model.addAttribute("listHallNew", listHallNew);
			model.addAttribute("column_id102", IMySystemConstants.COLUMN102);
			
			// 资讯
			Content content107 = new Content();
			String column_id107 = IMySystemConstants.COLUMN107;
			content107.setClass1(column_id107);
			content107.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
			content107.setOrder_type(IMySystemConstants.ORDER_DESC);
			//6条
			content107.setCount_num(IMySystemConstants.COUNT_NUM6);
			//资讯列表
			List<Content> contentList107 = contentService.queryContentListByColumnClass1(content107);
			model.addAttribute("contentList107", contentList107);
			model.addAttribute("column_id107", column_id107);
			
			
			// 最新祭文
			Content content130 = new Content();
			String column_id130 = IMySystemConstants.COLUMN130;
			content130.setColumn_id(column_id130);
			content130.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
			content130.setOrder_type(IMySystemConstants.ORDER_DESC);
			//8条
			content130.setCount_num(IMySystemConstants.COUNT_NUM8);
			//最新祭文列表
			List<Content> contentList130 = contentService.queryContentListByColumn(content130);
			model.addAttribute("contentList130", contentList130);
			model.addAttribute("column_id130", column_id130);
			//公墓陵园推荐
			List<Cemetery> cemeteryList = this.cemeteryService.queryCemeteryListForCountNum(IMySystemConstants.COUNT_NUM4);
			model.addAttribute("cemeteryList", cemeteryList);
			
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
			
			
			
			//
			String columnId = "107";
			//子栏目
			List<Column> columnChildList = columnService.queryChildColumnListByColumnId(columnId);
			
			//资讯子栏目
			model.addAttribute("columnChildList", columnChildList);
			
			Carousel carousel = new Carousel();
			//轮播图片
			carousel.setCarousel_type(IMySystemConstants.VALUE_1);
			List<Carousel> carouselList = this.carouselService.queryCarouselList(carousel);
			model.addAttribute("carouselList", carouselList);
			
			
			model.addAttribute("contentList3", contentList3);
			model.addAttribute("column_id3", column_id3);
			model.addAttribute("columnList", columnList);
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
	
	
	@RequestMapping("/toRegister")
	public String toRegister(HttpServletRequest request, Model model) {
		
		return "site/register";
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
		String search_text = request.getParameter("search_text")==null? "":request.getParameter("search_text");
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
		List<Content> contentList = contentService.queryContentListForSearch(content);
		int totalRecords = contentList.size();
		int totalPage = (totalRecords  +  IMySystemConstants.PAGE_SIZE15  - 1) / IMySystemConstants.PAGE_SIZE15;  
		
		
		
		model.addAttribute("contentList", contentList);
		model.addAttribute("totalRecords", totalRecords);
		model.addAttribute("totalPage", totalPage);
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
	
	/**
	 * 
	 * @Description: 导航 
	 * @param request
	 * @return
	 */
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
			String column_id = IMySystemConstants.COLUMN123;
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
		//网上纪念馆:公开属性，单人
		List<Hall> listSingleHallByOpenType = hallService.queryHallListByOpenType(IMySystemConstants.VALUE_1);
		
		//网上纪念馆:公开属性，双人
		List<HallDouble> listHallDoubleByOpenType = hallDoubleService.queryHallDoubleListByOpenType(IMySystemConstants.VALUE_1);
				
		
		//公墓陵园推荐
		List<Cemetery> cemeteryList = this.cemeteryService.queryCemeteryListForCountNum(IMySystemConstants.COUNT_NUM4);
		model.addAttribute("cemeteryList", cemeteryList);
		
		model.addAttribute("listHallNew", listHallNew);
		model.addAttribute("listOrationNew", listOrationNew);
		model.addAttribute("listSingleHallByOpenType", listSingleHallByOpenType);
		model.addAttribute("listHallDoubleByOpenType", listHallDoubleByOpenType);
		return "site/hallList";
	}
	
	/**
	 * 
	 * @Description:  单人纪念馆详细内容
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallSingleDetail")
	public String toHallSingleDetail(HttpServletRequest request, Model model) {
		
		int hallId = Integer.parseInt(request.getParameter("id"));
		Hall hall = this.hallService.queryHallById(hallId);
		
		int days = MyDateUtil.getMargin(MyDateUtil.getDate(), hall.getDeath_date());
		hall.setDays(days);
		model.addAttribute("hall", hall);
		//当前纪念馆的祭文
		List<Oration> listOration = orationService.queryOrationListByHall(hallId+"", IMySystemConstants.COUNT_NUM5);
		model.addAttribute("listOration", listOration);
		
		return "site/hallSingleDetail";
	}
	
	/**
	 * 
	 * @Description: 跳转到单人纪念馆-祭奠
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toShowSingleMemorial")
	public String toShowSingleMemorial(HttpServletRequest request, Model model) {
		//纪念馆内容
		int hallId = Integer.parseInt(request.getParameter("id"));
		Hall hall = this.hallService.queryHallById(hallId);
		int days = MyDateUtil.getMargin(MyDateUtil.getDate(), hall.getDeath_date());
		hall.setDays(days);
		model.addAttribute("hall", hall);
		
		//当前纪念馆摆放的礼物
		List<HallGift>  listHallGift = this.hallGiftService.queryHallGiftListForHall(hallId, IMySystemConstants.COUNT_NUM15);
		model.addAttribute("listHallGift", listHallGift);
		
		return "site/hallSingleMemorial";
	}
	
	
	/**
	 * 
	 * @Description: 跳转到双人纪念馆-祭奠
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toShowDoubleMemorial")
	public String toShowDoubleMemorial(HttpServletRequest request, Model model) {
		
		int hallId = Integer.parseInt(request.getParameter("id"));
		HallDouble hallDouble = this.hallDoubleService.queryHallDoubleById(hallId);
		
		int days = MyDateUtil.getMargin(MyDateUtil.getDate(), hallDouble.getDeath_date());
		hallDouble.setDays(days);
		model.addAttribute("hallDouble", hallDouble);
		
		
		//当前纪念馆摆放的礼物
		List<HallGift>  listHallGift = this.hallGiftService.queryHallGiftListForHall(hallId, IMySystemConstants.COUNT_NUM15);
		model.addAttribute("listHallGift", listHallGift);
		
		return "site/hallDoubleMemorial";
	}
	
	/**
	 * 
	 * @Description: 双人纪念馆详细内容 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallDoubleDetail")
	public String toHallDoubleDetail(HttpServletRequest request, Model model) {
		
		int hallDoubleId = Integer.parseInt(request.getParameter("id"));
		HallDouble hallDouble = this.hallDoubleService.queryHallDoubleById(hallDoubleId);
		int days = MyDateUtil.getMargin(MyDateUtil.getDate(), hallDouble.getDeath_date());
		hallDouble.setDays(days);
		model.addAttribute("hallDouble", hallDouble);
		
		//获取登录的会员
		//Member memberUser = super.getSessionMemberUser(request);
		//String memberId= memberUser.getId().toString();
		//当前纪念馆的祭文
		List<Oration> listOration = orationService.queryOrationListByHall(hallDoubleId+"", IMySystemConstants.COUNT_NUM5);
		model.addAttribute("listOration", listOration);
				
		return "site/hallDoubleDetail";
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
		
		//公墓陵园推荐
		List<Cemetery> cemeteryList = this.cemeteryService.queryCemeteryListForCountNum(IMySystemConstants.COUNT_NUM4);
		model.addAttribute("cemeteryList", cemeteryList);
		
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
	
	//用户文章内容
	@RequestMapping("/toOrationDetail")
	public String toOrationDetail(HttpServletRequest request, Model model) {
		int orationId = Integer.parseInt((request.getParameter("id")==null? "0":request.getParameter("id")));
		Oration oration = orationService.queryOrationById(orationId);
		
		model.addAttribute("oration", oration);
		
		return "site/orationDetail";
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
		
		List<Product> productList1 = productService.queryProductListByType(IMySystemConstants.VALUE_1);
		model.addAttribute("productList1", productList1);
		
		List<Product> productList2 = productService.queryProductListByType(IMySystemConstants.VALUE_2);
		model.addAttribute("productList2", productList2);
		
		List<Product> productList3 = productService.queryProductListByType(IMySystemConstants.VALUE_3);
		model.addAttribute("productList3", productList3);
		
		//公墓陵园推荐
		List<Cemetery> cemeteryList = this.cemeteryService.queryCemeteryListForCountNum(IMySystemConstants.COUNT_NUM4);
		model.addAttribute("cemeteryList", cemeteryList);
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
		int productId = Integer.parseInt((request.getParameter("id")==null? "0":request.getParameter("id")));
		Product product = productService.queryProductById(productId);
		model.addAttribute("product", product);
		
		//公墓陵园推荐
		List<Cemetery> cemeteryList = this.cemeteryService.queryCemeteryListForCountNum(IMySystemConstants.COUNT_NUM4);
		model.addAttribute("cemeteryList", cemeteryList);
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
		List<Cemetery> cemeteryListA = this.cemeteryService.queryCemeteryListByType(IMySystemConstants.VALUE_A);
		model.addAttribute("cemeteryListA", cemeteryListA);
		
		List<Cemetery> cemeteryListB = this.cemeteryService.queryCemeteryListByType(IMySystemConstants.VALUE_B);
		model.addAttribute("cemeteryListB", cemeteryListB);
		
		List<Cemetery> cemeteryListC = this.cemeteryService.queryCemeteryListByType(IMySystemConstants.VALUE_C);
		model.addAttribute("cemeteryListC", cemeteryListC);
		
		List<Cemetery> cemeteryListD = this.cemeteryService.queryCemeteryListByType(IMySystemConstants.VALUE_D);
		model.addAttribute("cemeteryListD", cemeteryListD);
		
		List<Cemetery> cemeteryListE = this.cemeteryService.queryCemeteryListByType(IMySystemConstants.VALUE_E);
		model.addAttribute("cemeteryListE", cemeteryListE);
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
		int contentId = Integer.parseInt((request.getParameter("id")==null? "0":request.getParameter("id")));
		Cemetery cemetery = cemeteryService.queryCemeteryById(contentId);
		model.addAttribute("cemetery", cemetery);
		
		//公墓陵园推荐
		List<Cemetery> cemeteryList = this.cemeteryService.queryCemeteryListForCountNum(IMySystemConstants.COUNT_NUM4);
		model.addAttribute("cemeteryList", cemeteryList);
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
			//最新建馆:双人馆、单人馆合并后的结果集
			List<Hall> listHallNew = hallService.queryHallNewListByMember(memberUser.getId(), IMySystemConstants.COUNT_NUM6);
			model.addAttribute("listHallNew", listHallNew);
			
			//我的访问
			//List<Visit> listVisit = visitService.queryVisitListByMember(memberUser.getId()+"", IMySystemConstants.COUNT_NUM2);
			//model.addAttribute("listVisit", listVisit);
			
			//我的发布
			List<Oration> listOration = orationService.queryOrationListByMember(memberUser.getId()+"", IMySystemConstants.COUNT_NUM12);
			model.addAttribute("listOration", listOration);
			
			return "site/memberCenter";
		}
		
	}
	
	//购物车
	@RequestMapping("/toMemberCart")
	public String toMemberCart(HttpServletRequest request, Model model) {
		//获取登录的会员
		Member memberUser = super.getSessionMemberUser(request);
		if(null == memberUser){
			return "redirect:/sinian/index/indexController/toMemberLogin";
		}else{
			//待付款商品
			List<Cart> listCart = cartService.queryCartListByMember(memberUser.getId().toString(), IMySystemConstants.COUNT_NUM9);
			model.addAttribute("listCart", listCart);
			
			//已购买商品
			List<Order> listOrder = orderService.queryOrderListByMember(memberUser.getId().toString(), IMySystemConstants.COUNT_NUM9);
			model.addAttribute("listOrder", listOrder);
			return "site/memberCart";
		}
		
	}
	
	
	//我的创建
	@RequestMapping("/toMemberCreate")
	public String toMemberCreate(HttpServletRequest request, Model model) {
		
		//获取登录的会员
		Member memberUser = super.getSessionMemberUser(request);
		if(null == memberUser){
			return "redirect:/sinian/index/indexController/toMemberLogin";
		}else{
			//最新建馆:双人馆、单人馆合并后的结果集
			List<Hall> listHallNew = hallService.queryHallNewListByMember(memberUser.getId(), IMySystemConstants.COUNT_NUM6);
			model.addAttribute("listHallNew", listHallNew);
			
			//最新文章
			List<Oration> listOrationNew = orationService.queryOrationNewListByMember(memberUser.getId(), IMySystemConstants.COUNT_NUM6);
			model.addAttribute("listOrationNew", listOrationNew);
			
			
			return "site/memberCreate";
		}
		
	}
	
	//结算页面
	@RequestMapping("/toSettlement")
	public String toSettlement(HttpServletRequest request, Model model) {
		String ids = request.getParameter("id")==null? "":request.getParameter("id");
		String[] productIds = ids.split(",");
		
		//可以购买的产品
		List<Product> productList = productService.queryProductListByIds(productIds);
		model.addAttribute("productList", productList);
		
		return "site/settlementList";
	}
	
	
	/**
	 * 
	 * @Description: 查看纪念馆 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toShowHall")
	public String toShowHall(HttpServletRequest request, Model model) {
		String returnPage = "site/hallSingleDetail";
		//id
		String id = request.getParameter("id")==null? "0":request.getParameter("id");
		
		Hall hall = hallService.queryHallById(Integer.parseInt(id));
		
		model.addAttribute("hall", hall);
		if(null != hall){
			if(IMySystemConstants.VALUE_1.equals(hall.getHall_type())){
				returnPage = "site/hallSingleDetail";
			}else{
				returnPage = "site/hallDoubleDetail";
			}
		}
		 return returnPage;
	}
	
	/**
	 * 
	 * @Description: 跳转到已买产品页面 (舍弃，礼品不存放仓库，直接购买使用)
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toChooseMyProduct")
	public String toChooseMyProduct(HttpServletRequest request, Model model) {
		Member memberUser = super.getSessionMemberUser(request);
		//纪念馆类型
		String hallType = request.getParameter("hallType")==null? "":request.getParameter("hallType");
		model.addAttribute("hallType", hallType);
		
		String hallId = request.getParameter("hallId")==null? "":request.getParameter("hallId");
		model.addAttribute("hallId", hallId);
		//type
		String type = request.getParameter("type")==null? "":request.getParameter("type");
		//已购买的产品
		Warehouse warehouse = new Warehouse();
		warehouse.setProduct_type(type);
		warehouse.setMember_id(memberUser.getId()+"");
		List<Warehouse> listWarehouse = warehouseService.queryWarehouseListByType(type);
		model.addAttribute("listWarehouse", listWarehouse);
		//可以购买的产品
		List<Product> productList = productService.queryProductListByType(type);
		model.addAttribute("productList", productList);
		
		 return "site/hallChooseMyProduct";
	}
	
	/**
	 * 
	 * @Description: 跳转到纪念馆选择祭品页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toChooseProduct")
	public String toChooseProduct(HttpServletRequest request, Model model) {
		//type
		String type = request.getParameter("type")==null? "":request.getParameter("type");
		List<Product> productList = productService.queryProductListByType(type);
		
		model.addAttribute("productList", productList);
		
		 return "site/hallChooseProduct";
	}
	
	/**
	 * 
	 * @Description: 跳转到纪念馆选择所有分类祭品页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toChooseProductAll")
	public String toChooseProductAll(HttpServletRequest request, Model model) {
		Product product = new Product();
		//纪念馆商品
		product.setBig_type("2");
		List<Product> productList = productService.queryProductList(product);
		
		model.addAttribute("productList", productList);
		
		 return "site/hallChooseProduct";
	}
	
	/**
	 * 
	 * @Description: 纪念馆灵堂页面，包括选择的商品 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toShowHallAndProduct")
	public String toShowHallAndProduct(HttpServletRequest request, Model model) {
		//type
		/*String type = request.getParameter("type")==null? "":request.getParameter("type");
		Product productParam = new Product();
		productParam.setType(type);
		List<Product> productList = productService.queryProductListByType(productParam);
		
		model.addAttribute("productList", productList);*/
		
		 return "site/hallSingleDetailAndProduct";
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
		//标识为灵堂购买礼品
		String flag = request.getParameter("flag")==null? "":request.getParameter("flag");
		//标识礼品分类
		String type = request.getParameter("type")==null? "":request.getParameter("type");
		model.addAttribute("flag", flag);
		model.addAttribute("type", type);
		
		return "site/memberLogin";
	}
	
	//显示购买的礼品和总金额
	@RequestMapping("/toPay")
	public void toPay(HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			Member memberUser = super.getSessionMemberUser(request);
			//礼品
			String ids = request.getParameter("ids")==null? "":request.getParameter("ids");
			//总价
			String count = request.getParameter("count")==null? "0":request.getParameter("count");
			orderService.addOrderByIds(request, ids, memberUser.getId()+"", count);
			
			//设置支付属性
			String outTradeNo = MyAutoGenerateOrderNum.generateOrderNum("");
			String productCode = "FAST_INSTANT_TRADE_PAY";
			float totalAmount = Float.parseFloat(count);
			//float  totalAmount   =  (float)(Math.round(totalAmountTemp*100))/100;
			String subject = "缘园思念网祭奠礼品";
			String body = "礼品名称";
			String passbackParams = "";
			String sysServiceProviderId = MyAutoGenerateOrderNum.generateOrderNum("");
			//支付
			AlipayClient alipayClient = new DefaultAlipayClient(
					AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type); // 获得初始化的AlipayClient
			AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
			alipayRequest.setReturnUrl(AlipayConfig.return_url);
			alipayRequest.setNotifyUrl(AlipayConfig.notify_url);// 在公共参数中设置回跳和通知地址
			alipayRequest
					.setBizContent("{"
							+ "    \"out_trade_no\":\""+ outTradeNo + "\","
							+ "    \"product_code\":\""+ productCode + "\","
							+ "    \"total_amount\":" + totalAmount+ ","
							+ "    \"subject\":\"" + subject + "\","
							+ "    \"body\":\"" + body + "\","
							+ "    \"passback_params\":\"" + passbackParams + "\","
							+ "    \"extend_params\":{"
							+ "    \"sys_service_provider_id\":\"" + sysServiceProviderId + "\""
							+ "    }" + "  }");// 填充业务参数
										
			/*alipayRequest.setBizContent("{" + "\"out_trade_no\":\"" + outTradeNo + "\"," +
			        "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
			        "    \"total_amount\":88.88," +
			        "    \"subject\":\"Iphone6 16G\"," +
			        "    \"body\":\"Iphone6 16G\"," +
			        "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
			        "    \"extend_params\":{" +
			        "    \"sys_service_provider_id\":\"2089511833207846\"" +
			        "    }"+
			        "  }");*/
			String form = "";
			try {
				form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
			} catch (AlipayApiException e) {
				e.printStackTrace();
			}
			response.setContentType("text/html;charset=" + IMySystemConstants.CHARSET);
			response.getWriter().write(form);// 直接将完整的表单html输出到页面
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
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
