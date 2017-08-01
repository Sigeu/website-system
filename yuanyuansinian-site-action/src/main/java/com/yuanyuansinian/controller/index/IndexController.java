/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.controller.index;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.github.pagehelper.PageHelper;
import com.github.wxpay.sdk.WXPay;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.yuanyuansinian.alipay.config.AlipayConfig;
import com.yuanyuansinian.model.carousel.Carousel;
import com.yuanyuansinian.model.cart.Cart;
import com.yuanyuansinian.model.cemetery.Cemetery;
import com.yuanyuansinian.model.column.Column;
import com.yuanyuansinian.model.contact.Contact;
import com.yuanyuansinian.model.content.Content;
import com.yuanyuansinian.model.content.ContentWithBLOBs;
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
import com.yuanyuansinian.service.member.IMemberService;
import com.yuanyuansinian.service.oration.IOrationService;
import com.yuanyuansinian.service.order.IOrderService;
import com.yuanyuansinian.service.product.IProductService;
import com.yuanyuansinian.service.warehouse.IWarehouseService;
import com.yuanyuansinian.tenpay.config.MyConfig;

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

	// 会员Service
	@Resource
	private IMemberService memberService;

	/**
	 * @Description: 显示网站主页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model) {
		try {
			// 友情链接
			// List<Link> linkList = linkService.queryLinkList(null);
			// model.addAttribute("linkList", linkList);
			// 最新建馆
			List<Hall> listHallNew = hallService
					.queryHallNewList(IMySystemConstants.COUNT_NUM6);
			// 最新建馆 列表
			model.addAttribute("listHallNew", listHallNew);
			model.addAttribute("column_id102", IMySystemConstants.COLUMN102);

			// 资讯
			Content content107 = new Content();
			String column_id107 = IMySystemConstants.COLUMN107;
			content107.setClass1(column_id107);
			content107
					.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
			content107.setOrder_type(IMySystemConstants.ORDER_DESC);
			// 6条
			content107.setCount_num(IMySystemConstants.COUNT_NUM6);
			// 资讯列表
			List<Content> contentList107 = contentService
					.queryContentListByColumnClass1(content107);
			model.addAttribute("contentList107", contentList107);
			model.addAttribute("column_id107", column_id107);

			// 最新祭文
			Content content130 = new Content();
			String column_id130 = IMySystemConstants.COLUMN130;
			content130.setColumn_id(column_id130);
			content130
					.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
			content130.setOrder_type(IMySystemConstants.ORDER_DESC);
			// 8条
			content130.setCount_num(IMySystemConstants.COUNT_NUM8);
			// 最新祭文列表
			List<Content> contentList130 = contentService
					.queryContentListByColumn(content130);
			model.addAttribute("contentList130", contentList130);
			model.addAttribute("column_id130", column_id130);
			// 公墓陵园推荐
			List<Cemetery> cemeteryList = this.cemeteryService
					.queryCemeteryListForCountNum(IMySystemConstants.COUNT_NUM4);
			model.addAttribute("cemeteryList", cemeteryList);

			// 信息公开规章制度
			Content content3 = new Content();
			String column_id3 = "103";
			content3.setColumn_id(column_id3);
			content3.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
			content3.setOrder_type(IMySystemConstants.ORDER_DESC);
			content3.setCount_num(IMySystemConstants.COUNT_NUM2);
			// 内容列表
			List<Content> contentList3 = contentService
					.queryContentListByColumn(content3);

			// 栏目
			List<Column> resultList = columnService.queryColumnList(null);
			// 排序
			LinkedList<Column> result = new LinkedList<Column>();
			LinkedList<Column> columnLinkedList = this.toSort(resultList,
					result, 0);
			// 转换为ArrayList
			List<Column> columnList = new ArrayList<Column>(columnLinkedList);

			//
			String columnId = "107";
			// 子栏目
			List<Column> columnChildList = columnService
					.queryChildColumnListByColumnId(columnId);

			// 资讯子栏目
			model.addAttribute("columnChildList", columnChildList);

			Carousel carousel = new Carousel();
			// 轮播图片
			carousel.setCarousel_type(IMySystemConstants.VALUE_1);
			List<Carousel> carouselList = this.carouselService
					.queryCarouselList(carousel);
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
		String column_id = request.getParameter("id") == null ? "0" : request
				.getParameter("id");
		content.setColumn_id(column_id);
		content.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
		content.setOrder_type(IMySystemConstants.ORDER_DESC);
		content.setCount_num(IMySystemConstants.COUNT_NUM4);
		// 内容列表
		int pageNo = Integer.parseInt(request.getParameter("p") == null ? "0"
				: request.getParameter("p"));
		PageHelper.startPage(pageNo, IMySystemConstants.PAGE_SIZE15);
		List<Content> contentList = contentService
				.queryContentListByColumn(content);
		int totalRecords = contentList.size();
		int totalPage = (totalRecords + IMySystemConstants.PAGE_SIZE15 - 1)
				/ IMySystemConstants.PAGE_SIZE15;

		// 侧栏年度报告
		Content contentReport = new Content();
		String column_id_report = "103";
		contentReport.setColumn_id(column_id_report);
		contentReport.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
		contentReport.setOrder_type(IMySystemConstants.ORDER_DESC);
		contentReport.setCount_num(IMySystemConstants.COUNT_NUM5);
		// 年度报告内容列表
		List<Content> contentReportList = contentService
				.queryContentListByColumn(contentReport);
		// 点击的栏目
		Column column = columnService.queryColumnById(Integer
				.parseInt(column_id));

		// 栏目
		List<Column> resultList = columnService.queryColumnList(null);
		// 排序
		LinkedList<Column> result = new LinkedList<Column>();
		LinkedList<Column> columnLinkedList = this
				.toSort(resultList, result, 0);
		// 转换为ArrayList
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
		// Contact contact = contactService.queryContact();
		// 友情链接
		// List<Link> linkList = linkService.queryLinkList(null);

		int contentId = Integer
				.parseInt((request.getParameter("id") == null ? "0" : request
						.getParameter("id")));
		Content content = contentService.queryContentById(contentId);

		// model.addAttribute("contact", contact);
		// model.addAttribute("linkList", linkList);
		model.addAttribute("content", content);

		return "site/article";
	}

	@RequestMapping("/toRegister")
	public String toRegister(HttpServletRequest request, Model model) {

		return "site/register";
	}

	// 双人馆头像1
	@RequestMapping("/hallDoubleAddHeadOne")
	public String hallDoubleAddHeadOne(HttpServletRequest request, Model model) {

		return "hallDouble/hallDoubleAddHead1";
	}

	// 双人馆头像2
	@RequestMapping("/hallDoubleAddHeadTwo")
	public String hallDoubleAddHeadTwo(HttpServletRequest request, Model model) {

		return "hallDouble/hallDoubleAddHead2";
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
		String search_text = request.getParameter("search_text") == null ? ""
				: request.getParameter("search_text");
		// 最新公开信息
		ContentWithBLOBs content = new ContentWithBLOBs();
		content.setTitle(search_text);
		content.setContent(search_text);
		content.setKeywords(search_text);
		content.setDescription(search_text);
		content.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
		content.setOrder_type(IMySystemConstants.ORDER_DESC);
		content.setCount_num(IMySystemConstants.COUNT_NUM4);
		// 内容列表
		int pageNo = Integer.parseInt(request.getParameter("p") == null ? "0"
				: request.getParameter("p"));
		PageHelper.startPage(pageNo, IMySystemConstants.PAGE_SIZE15);
		List<Content> contentList = contentService
				.queryContentListForSearch(content);
		int totalRecords = contentList.size();
		int totalPage = (totalRecords + IMySystemConstants.PAGE_SIZE15 - 1)
				/ IMySystemConstants.PAGE_SIZE15;

		model.addAttribute("contentList", contentList);
		model.addAttribute("totalRecords", totalRecords);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("search_text", search_text);

		return "site/searchList";
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
			// 栏目
			List<Column> resultList = columnService
					.queryColumnListForNavigation(IMySystemConstants.COUNT_NUM1);
			// 排序
			LinkedList<Column> result = new LinkedList<Column>();
			LinkedList<Column> columnLinkedList = this.toSort(resultList,
					result, 0);
			// 转换为ArrayList
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
			contentNotice
					.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
			contentNotice.setOrder_type(IMySystemConstants.ORDER_DESC);
			contentNotice.setCount_num(IMySystemConstants.COUNT_NUM9);
			// 通知公告
			List<Content> contentNoticeList = contentService
					.queryContentListByColumn(contentNotice);

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

		int contentId = Integer
				.parseInt((request.getParameter("id") == null ? "0" : request
						.getParameter("id")));
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
		// 通知公告
		List<Content> contentNoticeList = contentService
				.queryContentList(contentNotice);

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
	 * @Description: 纪念馆列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallList")
	public String toHallList(HttpServletRequest request, Model model) {

		// 最新建馆
		List<Hall> listHallNew = hallService
				.queryHallNewList(IMySystemConstants.COUNT_NUM6);
		// 最新文章
		List<Oration> listOrationNew = orationService
				.queryOrationNewList(IMySystemConstants.COUNT_NUM6);
		// 网上纪念馆:公开属性，单人
		List<Hall> listSingleHallByOpenType = hallService
				.queryHallListByOpenType(IMySystemConstants.VALUE_1);

		// 网上纪念馆:公开属性，双人
		List<HallDouble> listHallDoubleByOpenType = hallDoubleService
				.queryHallDoubleListByOpenType(IMySystemConstants.VALUE_1);

		// 公墓陵园推荐
		List<Cemetery> cemeteryList = this.cemeteryService
				.queryCemeteryListForCountNum(IMySystemConstants.COUNT_NUM4);
		model.addAttribute("cemeteryList", cemeteryList);

		model.addAttribute("listHallNew", listHallNew);
		model.addAttribute("listOrationNew", listOrationNew);
		model.addAttribute("listSingleHallByOpenType", listSingleHallByOpenType);
		model.addAttribute("listHallDoubleByOpenType", listHallDoubleByOpenType);
		return "site/hallList";
	}

	/*-------------------------------------网站内容分页列表 begin----------------------------------*/

	/**
	 * 
	 * @Description: 纪念馆搜索-分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/searchHall")
	public String searchHall(HttpServletRequest request, Model model) {
		String search_text = request.getParameter("hall_name") == null ? ""
				: request.getParameter("hall_name");
		// 网上纪念馆:公开属性，单人和双人
		List<Hall> listHallBySearch = hallService
				.queryHallListBySearch(search_text);

		model.addAttribute("search_text", search_text);
		model.addAttribute("size", listHallBySearch.size());
		return "site/hallSearchList";
	}

	/**
	 * 
	 * @Description: 纪念馆搜索-分页调用
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/searchHallForPage")
	public List<Hall> searchHallForPage(HttpServletRequest request) {
		List<Hall> listHallBySearch = null;
		try {
			String search_text = request.getParameter("hall_name") == null ? ""
					: request.getParameter("hall_name");
			// 网上纪念馆:公开属性，单人和双人
			listHallBySearch = hallService.queryHallListBySearch(search_text);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listHallBySearch;
	}

	/**
	 * 
	 * @Description: 网站首页-最新建馆-更多页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallPageList")
	public String toHallPageList(HttpServletRequest request, Model model) {

		// 最新建馆：单人、双人,查询所有数据
		List<Hall> listHallNew = hallService.queryAllHallList("");

		model.addAttribute("size", listHallNew.size());
		return "site/hallPageList";
	}

	/**
	 * 
	 * @Description: 网站首页，最新建馆->更多页面->分页调用
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/hallForPage")
	public List<Hall> hallForPage(HttpServletRequest request) {
		List<Hall> listHallByPage = null;
		try {
			// 网上纪念馆:公开属性，单人和双人
			listHallByPage = hallService.queryAllHallList("");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listHallByPage;
	}

	/**
	 * 
	 * @Description: 网站首页-单人馆-更多页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallSinglePageList")
	public String toHallSinglePageList(HttpServletRequest request, Model model) {

		// 单人查询所有数据
		List<Hall> listSingleHall = hallService
				.queryAllHallList(IMySystemConstants.VALUE_1);

		model.addAttribute("size", listSingleHall.size());
		return "site/hallSinglePageList";
	}

	/**
	 * 
	 * @Description: 网站首页-单人馆->更多页面->分页调用
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/hallSingleForPage")
	public List<Hall> hallSingleForPage(HttpServletRequest request) {
		List<Hall> listHallByPage = null;
		try {
			// 网上纪念馆:公开属性，单人
			listHallByPage = hallService
					.queryAllHallList(IMySystemConstants.VALUE_1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listHallByPage;
	}

	/**
	 * 
	 * @Description: 网站首页-双人馆-更多页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallDoublePageList")
	public String toHallDoublePageList(HttpServletRequest request, Model model) {

		// 单人查询所有数据
		List<Hall> listSingleHall = hallService
				.queryAllHallList(IMySystemConstants.VALUE_2);

		model.addAttribute("size", listSingleHall.size());
		return "site/hallDoublePageList";
	}

	/**
	 * 
	 * @Description: 网站首页-双人馆->更多页面->分页调用
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/hallDoubleForPage")
	public List<Hall> hallDoubleForPage(HttpServletRequest request) {
		List<Hall> listHallByPage = null;
		try {
			// 网上纪念馆:公开属性，单人
			listHallByPage = hallService
					.queryAllHallList(IMySystemConstants.VALUE_2);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listHallByPage;
	}

	/**
	 * 
	 * @Description: 网站首页-文章（最新祭奠）-更多页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toContentPageList")
	public String toContentPageList(HttpServletRequest request, Model model) {

		// 栏目ID
		String column_id = request.getParameter("id") == null ? "" : request
				.getParameter("id");
		// 文章列表
		List<Content> listContentByPage = contentService
				.queryContentPageListByColumn(column_id);
		// 总条数
		model.addAttribute("size", listContentByPage.size());
		model.addAttribute("column_id", column_id);

		return "site/contentPageList";
	}

	/**
	 * 
	 * @Description: 网站首页-文章内容-分页调用
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/contentForPage")
	public List<Content> contentForPage(HttpServletRequest request) {
		List<Content> listContentByPage = null;
		try {
			// 栏目ID
			String column_id = request.getParameter("id") == null ? ""
					: request.getParameter("id");
			// 文章列表
			listContentByPage = contentService
					.queryContentPageListByColumn(column_id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listContentByPage;
	}

	/**
	 * 
	 * @Description: 公墓陵园-分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCemeteryPageList")
	public String toCemeteryPageList(HttpServletRequest request, Model model) {

		// 分类ID
		String cemetery_type = request.getParameter("id") == null ? ""
				: request.getParameter("id");
		// 公墓陵园
		List<Cemetery> listCemeteryPage = cemeteryService
				.queryCemeteryListByType(cemetery_type);

		model.addAttribute("size", listCemeteryPage.size());
		model.addAttribute("cemetery_type", cemetery_type);

		return "site/cemeteryPageList";
	}

	/**
	 * 
	 * @Description: 公墓陵园-分页调用
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/cemeteryForPage")
	public List<Cemetery> cemeteryForPage(HttpServletRequest request) {
		List<Cemetery> listCemeteryPage = null;
		try {
			// 分类ID
			String cemetery_type = request.getParameter("id") == null ? ""
					: request.getParameter("id");
			// 公墓陵园
			listCemeteryPage = cemeteryService
					.queryCemeteryListByType(cemetery_type);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listCemeteryPage;
	}

	/**
	 * 
	 * @Description: 用户文章-分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toOrationPageList")
	public String toOrationPageList(HttpServletRequest request, Model model) {

		Oration oration = new Oration();
		// 公开
		oration.setOpen_type(IMySystemConstants.VALUE_1);
		// 所有公开的用户文章
		List<Oration> listOrationPage = orationService
				.queryOrationListByOpenType(oration);

		model.addAttribute("size", listOrationPage.size());

		return "site/orationPageList";
	}

	/**
	 * 
	 * @Description: 用户文章-分页调用
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/orationForPage")
	public List<Oration> orationForPage(HttpServletRequest request) {
		List<Oration> listOrationPage = null;
		try {
			Oration oration = new Oration();
			// 公开
			oration.setOpen_type(IMySystemConstants.VALUE_1);
			// 所有公开的用户文章
			listOrationPage = orationService
					.queryOrationListByOpenType(oration);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listOrationPage;
	}

	/**
	 * 
	 * @Description: 商城产品-分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toShoppingPageList")
	public String toShoppingPageList(HttpServletRequest request, Model model) {

		// 分类ID
		String type = request.getParameter("id") == null ? "" : request
				.getParameter("id");
		// 所有公开的用户文章
		List<Product> listProductPage = productService
				.queryProductListByType(type);

		model.addAttribute("size", listProductPage.size());
		model.addAttribute("type", type);

		return "site/shoppingPageList";
	}

	/**
	 * 
	 * @Description: 商城产品-分页调用
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/shoppingForPage")
	public List<Product> shoppingForPage(HttpServletRequest request) {
		List<Product> listProductPage = null;
		try {
			// 分类ID
			String type = request.getParameter("id") == null ? "" : request
					.getParameter("id");
			// 所有公开的用户文章
			listProductPage = productService.queryProductListByType(type);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listProductPage;
	}

	/*-------------------------------------网站内容分页列表 end------------------------------------*/

	/**
	 * 
	 * @Description: 单人纪念馆详细内容
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toHallSingleDetail")
	public String toHallSingleDetail(HttpServletRequest request, Model model) {

		int hallId = Integer.parseInt(request.getParameter("id"));
		Hall hall = this.hallService.queryHallById(hallId);

		int days = MyDateUtil.getMargin(MyDateUtil.getDate(),
				hall.getDeath_date());
		hall.setDays(days);
		model.addAttribute("hall", hall);
		// 当前纪念馆的祭文
		List<Oration> listOration = orationService.queryOrationListByHall(
				hallId + "", IMySystemConstants.COUNT_NUM5);
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
		// 纪念馆内容
		int hallId = Integer.parseInt(request.getParameter("id"));
		Hall hall = this.hallService.queryHallById(hallId);
		int days = MyDateUtil.getMargin(MyDateUtil.getDate(),
				hall.getDeath_date());
		hall.setDays(days);
		model.addAttribute("hall", hall);

		// 当前纪念馆摆放的礼物
		// List<HallGift> listHallGift =
		// this.hallGiftService.queryHallGiftListForHall(hallId,
		// IMySystemConstants.COUNT_NUM15);
		// model.addAttribute("listHallGift", listHallGift);

		// 根据纪念馆查询礼品：不区分会员
		Warehouse warehouse = new Warehouse();
		warehouse.setHall_id(hallId + "");
		List<Warehouse> listWarehouse = warehouseService
				.queryWarehouseListByHall(warehouse);

		model.addAttribute("listWarehouse", listWarehouse);

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
		HallDouble hallDouble = this.hallDoubleService
				.queryHallDoubleById(hallId);

		int days = MyDateUtil.getMargin(MyDateUtil.getDate(),
				hallDouble.getDeath_date());
		hallDouble.setDays(days);
		model.addAttribute("hallDouble", hallDouble);

		// 当前纪念馆摆放的礼物
		// List<HallGift> listHallGift =
		// this.hallGiftService.queryHallGiftListForHall(hallId,
		// IMySystemConstants.COUNT_NUM15);
		// model.addAttribute("listHallGift", listHallGift);

		// 根据纪念馆查询礼品：不区分会员
		Warehouse warehouse = new Warehouse();
		warehouse.setHall_id(hallId + "");
		List<Warehouse> listWarehouse = warehouseService
				.queryWarehouseListByHall(warehouse);

		model.addAttribute("listWarehouse", listWarehouse);

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
		HallDouble hallDouble = this.hallDoubleService
				.queryHallDoubleById(hallDoubleId);
		int days = MyDateUtil.getMargin(MyDateUtil.getDate(),
				hallDouble.getDeath_date());
		hallDouble.setDays(days);

		int days2 = MyDateUtil.getMargin(MyDateUtil.getDate(),
				hallDouble.getDeath_date2());
		hallDouble.setDays2(days2);

		model.addAttribute("hallDouble", hallDouble);

		// 获取登录的会员
		// Member memberUser = super.getSessionMemberUser(request);
		// String memberId= memberUser.getId().toString();
		// 当前纪念馆的祭文
		List<Oration> listOration = orationService.queryOrationListByHall(
				hallDoubleId + "", IMySystemConstants.COUNT_NUM5);
		model.addAttribute("listOration", listOration);

		return "site/hallDoubleDetail";
	}

	/**
	 * 
	 * @Description: 双人馆修改
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toDoubleHallUpdate")
	public String toDoubleHallUpdate(HttpServletRequest request, Model model) {

		int hallId = Integer.parseInt(request.getParameter("id"));
		HallDouble hallDouble = this.hallDoubleService
				.queryHallDoubleById(hallId);

		int days = MyDateUtil.getMargin(MyDateUtil.getDate(),
				hallDouble.getDeath_date());
		hallDouble.setDays(days);
		model.addAttribute("hallDouble", hallDouble);

		return "site/hallDoubleUpdate";
	}

	/**
	 * 
	 * @Description: 单人馆修改
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toSingleHallUpdate")
	public String toSingleHallUpdate(HttpServletRequest request, Model model) {

		int hallId = Integer.parseInt(request.getParameter("id"));
		Hall hall = this.hallService.queryHallById(hallId);

		int days = MyDateUtil.getMargin(MyDateUtil.getDate(),
				hall.getDeath_date());
		hall.setDays(days);
		model.addAttribute("hall", hall);

		return "site/hallSingleUpdate";
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
		// 子栏目
		List<Column> columnChildList = columnService
				.queryChildColumnListByColumnId(columnId);

		// 点击的子栏目
		String columnChildId = request.getParameter("id") == null ? columnChildDefault
				: request.getParameter("id");
		String columnChildName = (columnService.queryColumnById(Integer
				.parseInt(columnChildId))).getName();
		// 子栏目内容
		Content contentChild = new Content();
		contentChild.setColumn_id(columnChildId);
		contentChild.setOrder_column(IMySystemConstants.ORDER_COLUMN_ADD_TIME);
		contentChild.setOrder_type(IMySystemConstants.ORDER_DESC);
		contentChild.setCount_num(IMySystemConstants.COUNT_NUM5);
		// 子栏目内容
		List<Content> contentChildList = contentService
				.queryContentListByColumn(contentChild);

		// 公墓陵园推荐
		List<Cemetery> cemeteryList = this.cemeteryService
				.queryCemeteryListForCountNum(IMySystemConstants.COUNT_NUM4);
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
		// 子栏目
		List<Column> columnChildList = columnService
				.queryChildColumnListByColumnId(columnId);

		// 点击的子栏目
		String columnChildId = request.getParameter("column_id") == null ? columnChildDefault
				: request.getParameter("column_id");
		String columnChildName = (columnService.queryColumnById(Integer
				.parseInt(columnChildId))).getName();
		// 内容id
		int contentId = Integer
				.parseInt((request.getParameter("id") == null ? "0" : request
						.getParameter("id")));
		Content content = contentService.queryContentById(contentId);

		model.addAttribute("columnChildList", columnChildList);
		model.addAttribute("content", content);
		model.addAttribute("columnChildId", columnChildId);
		model.addAttribute("columnChildName", columnChildName);

		return "site/informationDetail";
	}

	// 用户文章内容
	@RequestMapping("/toOrationDetail")
	public String toOrationDetail(HttpServletRequest request, Model model) {
		int orationId = Integer
				.parseInt((request.getParameter("id") == null ? "0" : request
						.getParameter("id")));
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

		List<Product> productList1 = productService
				.queryProductListByType(IMySystemConstants.VALUE_1);
		model.addAttribute("productList1", productList1);

		List<Product> productList2 = productService
				.queryProductListByType(IMySystemConstants.VALUE_2);
		model.addAttribute("productList2", productList2);

		List<Product> productList3 = productService
				.queryProductListByType(IMySystemConstants.VALUE_3);
		model.addAttribute("productList3", productList3);

		List<Product> productList4 = productService
				.queryProductListByType(IMySystemConstants.VALUE_4);
		model.addAttribute("productList4", productList4);

		// 公墓陵园推荐
		List<Cemetery> cemeteryList = this.cemeteryService
				.queryCemeteryListForCountNum(IMySystemConstants.COUNT_NUM4);
		model.addAttribute("cemeteryList", cemeteryList);
		return "site/shoppingList";
	}

	/**
	 * 
	 * @Description: 商城内容页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toShoppingDetail")
	public String toShoppingDetail(HttpServletRequest request, Model model) {
		int productId = Integer
				.parseInt((request.getParameter("id") == null ? "0" : request
						.getParameter("id")));
		Product product = productService.queryProductById(productId);
		model.addAttribute("product", product);

		// 公墓陵园推荐
		List<Cemetery> cemeteryList = this.cemeteryService
				.queryCemeteryListForCountNum(IMySystemConstants.COUNT_NUM4);
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
		List<Cemetery> cemeteryListA = this.cemeteryService
				.queryCemeteryListByType(IMySystemConstants.VALUE_A);
		model.addAttribute("cemeteryListA", cemeteryListA);

		List<Cemetery> cemeteryListB = this.cemeteryService
				.queryCemeteryListByType(IMySystemConstants.VALUE_B);
		model.addAttribute("cemeteryListB", cemeteryListB);

		List<Cemetery> cemeteryListC = this.cemeteryService
				.queryCemeteryListByType(IMySystemConstants.VALUE_C);
		model.addAttribute("cemeteryListC", cemeteryListC);

		List<Cemetery> cemeteryListD = this.cemeteryService
				.queryCemeteryListByType(IMySystemConstants.VALUE_D);
		model.addAttribute("cemeteryListD", cemeteryListD);

		List<Cemetery> cemeteryListE = this.cemeteryService
				.queryCemeteryListByType(IMySystemConstants.VALUE_E);
		model.addAttribute("cemeteryListE", cemeteryListE);
		return "site/cemeteryList";
	}

	/**
	 * 
	 * @Description: 公墓陵园内容页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCemeteryDetail")
	public String toCemeteryDetail(HttpServletRequest request, Model model) {
		int contentId = Integer
				.parseInt((request.getParameter("id") == null ? "0" : request
						.getParameter("id")));
		Cemetery cemetery = cemeteryService.queryCemeteryById(contentId);
		model.addAttribute("cemetery", cemetery);

		// 公墓陵园推荐
		List<Cemetery> cemeteryList = this.cemeteryService
				.queryCemeteryListForCountNum(IMySystemConstants.COUNT_NUM4);
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
		// 获取登录的会员
		Member memberUser = super.getSessionMemberUser(request);
		if (null == memberUser) {
			return "redirect:/sinian/index/indexController/toMemberLogin";
		} else {
			// 针对注册后默认登录的用户，先查询数据
			Member member = this.memberService.queryMemberByPhone(
					memberUser.getPhone(), "");
			model.addAttribute("memberUser", member);
			// 最新建馆:双人馆、单人馆合并后的结果集
			List<Hall> listHallNew = hallService.queryHallNewListByMember(
					memberUser.getId(), IMySystemConstants.COUNT_NUM6);
			model.addAttribute("listHallNew", listHallNew);

			// 我的访问
			// List<Visit> listVisit =
			// visitService.queryVisitListByMember(memberUser.getId()+"",
			// IMySystemConstants.COUNT_NUM2);
			// model.addAttribute("listVisit", listVisit);

			// 我的发布
			List<Oration> listOration = orationService
					.queryOrationListByMember(memberUser.getId() + "",
							IMySystemConstants.COUNT_NUM12);
			model.addAttribute("listOration", listOration);

			return "site/memberCenter";
		}

	}

	// 购物车
	@RequestMapping("/toMemberCart")
	public String toMemberCart(HttpServletRequest request, Model model) {
		// 获取登录的会员
		Member memberUser = super.getSessionMemberUser(request);
		if (null == memberUser) {
			return "redirect:/sinian/index/indexController/toMemberLogin";
		} else {
			// 待付款商品
			List<Cart> listCart = cartService.queryCartListByMember(memberUser
					.getId().toString(), IMySystemConstants.COUNT_NUM9);
			model.addAttribute("listCart", listCart);

			// 已购买商品
			List<Order> listOrder = orderService.queryOrderListByMember(
					memberUser.getId().toString(),
					IMySystemConstants.COUNT_NUM9);
			model.addAttribute("listOrder", listOrder);
			return "site/memberCart";
		}

	}

	// 我的创建
	@RequestMapping("/toMemberCreate")
	public String toMemberCreate(HttpServletRequest request, Model model) {

		// 获取登录的会员
		Member memberUser = super.getSessionMemberUser(request);
		if (null == memberUser) {
			return "redirect:/sinian/index/indexController/toMemberLogin";
		} else {
			// 最新建馆:双人馆、单人馆合并后的结果集
			List<Hall> listHallNew = hallService.queryHallNewListByMember(
					memberUser.getId(), IMySystemConstants.COUNT_NUM6);
			model.addAttribute("listHallNew", listHallNew);

			// 最新文章
			List<Oration> listOrationNew = orationService
					.queryOrationNewListByMember(memberUser.getId(),
							IMySystemConstants.COUNT_NUM6);
			model.addAttribute("listOrationNew", listOrationNew);

			return "site/memberCreate";
		}

	}

	// 仓库
	@RequestMapping("/toMemberWarehouse")
	public String toMemberWarehouse(HttpServletRequest request, Model model) {
		// 获取登录的会员
		Member memberUser = super.getSessionMemberUser(request);
		if (null == memberUser) {
			return "redirect:/sinian/index/indexController/toMemberLogin";
		} else {
			// 默认查询所有的纪念馆产品
			String type = "2";
			// 已购买的产品
			Warehouse warehouse = new Warehouse();
			warehouse.setProduct_type(type);
			// 当前用户
			warehouse.setMember_id(memberUser.getId() + "");
			List<Warehouse> listWarehouse = warehouseService
					.queryWarehouseListByType(warehouse);
			model.addAttribute("listWarehouse", listWarehouse);

			// 我创建的纪念馆，用于选择使用在哪个纪念馆
			List<Hall> listHallNew = hallService.queryHallNewListByMember(
					memberUser.getId(), IMySystemConstants.COUNT_NUM6);
			model.addAttribute("listHallNew", listHallNew);

			return "site/memberWarehouse";
		}

	}

	// 结算页面
	@RequestMapping("/toSettlement")
	public String toSettlement(HttpServletRequest request, Model model) {
		String ids = request.getParameter("id") == null ? "" : request
				.getParameter("id");
		String[] productIds = ids.split(",");

		// 可以购买的产品
		List<Product> productList = productService
				.queryProductListByIds(productIds);
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
		// id
		String id = request.getParameter("id") == null ? "0" : request
				.getParameter("id");

		Hall hall = hallService.queryHallById(Integer.parseInt(id));

		model.addAttribute("hall", hall);
		if (null != hall) {
			if (IMySystemConstants.VALUE_1.equals(hall.getHall_type())) {
				returnPage = "site/hallSingleDetail";
			} else {
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
		// 纪念馆类型
		String hallType = request.getParameter("hallType") == null ? ""
				: request.getParameter("hallType");
		model.addAttribute("hallType", hallType);

		String hallId = request.getParameter("hallId") == null ? "" : request
				.getParameter("hallId");
		model.addAttribute("hallId", hallId);
		// type
		String type = request.getParameter("type") == null ? "" : request
				.getParameter("type");
		// 已购买的产品
		Warehouse warehouse = new Warehouse();
		warehouse.setProduct_type(type);
		warehouse.setMember_id(memberUser.getId() + "");
		List<Warehouse> listWarehouse = warehouseService
				.queryWarehouseListByType(warehouse);
		model.addAttribute("listWarehouse", listWarehouse);
		// 可以购买的产品
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
		// type
		String type = request.getParameter("type") == null ? "" : request
				.getParameter("type");
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
		// 纪念馆商品
		product.setBig_type("2");
		List<Product> productList = productService.queryProductList(product);

		model.addAttribute("productList", productList);
		// 从哪个纪念馆进入的
		String hallId = request.getParameter("hallId") == null ? "" : request
				.getParameter("hallId");
		model.addAttribute("hallId", hallId);

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
		// type
		/*
		 * String type = request.getParameter("type")==null?
		 * "":request.getParameter("type"); Product productParam = new
		 * Product(); productParam.setType(type); List<Product> productList =
		 * productService.queryProductListByType(productParam);
		 * 
		 * model.addAttribute("productList", productList);
		 */

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
	 * @Description: 我的思念内容页
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
		// 标识为灵堂购买礼品
		String flag = request.getParameter("flag") == null ? "" : request
				.getParameter("flag");
		// 双人馆还是单人馆
		String type = request.getParameter("hallType") == null ? "" : request
				.getParameter("hallType");

		String hallId = request.getParameter("hallId") == null ? "" : request
				.getParameter("hallId");
		model.addAttribute("flag", flag);
		model.addAttribute("type", type);
		model.addAttribute("hallId", hallId);

		return "site/memberLogin";
	}

	/**
	 * 
	 * @Description: 选择支付页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/choosePay")
	public String choosePay(HttpServletRequest request, Model model) {
		// 礼品
		String ids = request.getParameter("ids") == null ? "" : request
				.getParameter("ids");
		String names = request.getParameter("names") == null ? "" : request
				.getParameter("names");
		// 总价
		String count = request.getParameter("count") == null ? "0" : request
				.getParameter("count");
		
		String hallId = request.getParameter("hallId") == null ? "" : request
				.getParameter("hallId");
		
		model.addAttribute("ids", ids);
		model.addAttribute("names", names);
		model.addAttribute("count", count);
		model.addAttribute("hallId", hallId);

		return "site/choosePay";
	}

	/**
	 * 
	 * @Description: 支付宝支付
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping("/toPay")
	public void toPay(HttpServletRequest request, HttpServletResponse response,
			Model model) {
		try {
			Member memberUser = super.getSessionMemberUser(request);
			// 从哪个纪念馆点击进来的
			String hallId = request.getParameter("hallId") == null ? ""
					: request.getParameter("hallId");

			// 礼品
			String ids = request.getParameter("ids") == null ? "" : request
					.getParameter("ids");
			// 总价
			String count = request.getParameter("count") == null ? "0"
					: request.getParameter("count");
			// String outTradeNoAll = "";
			// 生成订单:只生成一个订单
			Order order = new Order();
			// 订单号
			String order_num = MyAutoGenerateOrderNum.generateOrderNum("");
			order.setOrder_num(order_num);
			order.setMember_id(memberUser.getId() + "");
			// 所有的产品id
			order.setProduct_id(ids);
			order.setHall_id(hallId);
			// 总价
			order.setProduct_price(Double.parseDouble(count));
			order.setCreate_date(MyDateUtil.getDateTime());
			order.setStatus(IMySystemConstants.VALUE_0);
			// outTradeNoAll += order_num + "|";
			// 生成订单
			orderService.addOrder(request, order);
			// orderService.addOrderByIds(request, ids, memberUser.getId()+"",
			// count, hallId);

			// 设置支付属性
			String outTradeNo = order_num;// 一个订单
			String productCode = "FAST_INSTANT_TRADE_PAY";
			float totalAmount = Float.parseFloat(count);
			// float totalAmount = (float)(Math.round(totalAmountTemp*100))/100;
			String subject = "缘园思念网祭奠礼品";
			String body = "礼品名称";
			String passbackParams = "";
			String sysServiceProviderId = MyAutoGenerateOrderNum
					.generateOrderNum("");
			// 支付
			AlipayClient alipayClient = new DefaultAlipayClient(
					AlipayConfig.gatewayUrl, AlipayConfig.app_id,
					AlipayConfig.merchant_private_key, "json",
					AlipayConfig.charset, AlipayConfig.alipay_public_key,
					AlipayConfig.sign_type); // 获得初始化的AlipayClient
			AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
			alipayRequest.setReturnUrl(AlipayConfig.return_url);
			alipayRequest.setNotifyUrl(AlipayConfig.notify_url);// 在公共参数中设置回跳和通知地址
			alipayRequest.setBizContent("{" + "    \"out_trade_no\":\""
					+ outTradeNo + "\"," + "    \"product_code\":\""
					+ productCode + "\"," + "    \"total_amount\":"
					+ totalAmount + "," + "    \"subject\":\"" + subject
					+ "\"," + "    \"body\":\"" + body + "\","
					+ "    \"passback_params\":\"" + passbackParams + "\","
					+ "    \"extend_params\":{"
					+ "    \"sys_service_provider_id\":\"" + hallId + "\""
					+ "    }" + "  }");// 填充业务参数

			String form = "";
			try {
				form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
			} catch (AlipayApiException e) {
				e.printStackTrace();
			}
			response.setContentType("text/html;charset="
					+ IMySystemConstants.CHARSET);
			response.getWriter().write(form);// 直接将完整的表单html输出到页面
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Description: 微信支付
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping("/toTenpay")
	public String toTenpay(HttpServletRequest request, Model model) {
		try {
			Member memberUser = super.getSessionMemberUser(request);
			// 从哪个纪念馆点击进来的
			String hallId = request.getParameter("hallId") == null ? "" : request
					.getParameter("hallId");
			// 礼品
			String ids = request.getParameter("ids") == null ? "" : request
					.getParameter("ids");
			// 总价
			String count = request.getParameter("count") == null ? "0" : request
					.getParameter("count");
			// String outTradeNoAll = "";
			// 生成订单:只生成一个订单
			Order order = new Order();
			// 订单号
			String order_num = MyAutoGenerateOrderNum.generateOrderNum("");
			order.setOrder_num(order_num);
			order.setMember_id(memberUser.getId() + "");
			// 所有的产品id
			order.setProduct_id(ids);
			order.setHall_id(hallId);
			// 总价
			order.setProduct_price(Double.parseDouble(count));
			order.setCreate_date(MyDateUtil.getDateTime());
			order.setStatus(IMySystemConstants.VALUE_0);
			// outTradeNoAll += order_num + "|";
			// 生成订单
			orderService.addOrder(request, order);
			// orderService.addOrderByIds(request, ids, memberUser.getId()+"",
			// count, hallId);
	
			// 设置支付属性
			String outTradeNo = order_num;// 一个订单
			float totalAmount = Float.parseFloat(count);
	
			model.addAttribute("body", "缘园思念网商品");
			model.addAttribute("outTradeNo", outTradeNo);
			model.addAttribute("totalAmount", totalAmount);
			//model.addAttribute("productId", ids);
			
			//支付
			MyConfig config = new MyConfig();
			WXPay wxpay = new WXPay(config);
	
			Map<String, String> data = new HashMap<String, String>();
			// 商品描述
			data.put("body", "缘园思念网商品");
			// 商户订单号:商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一
			data.put("out_trade_no", outTradeNo);
			// 设备号:自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"
			data.put("device_info", "");
			// 标价币种:默认人民币：CNY
			data.put("fee_type", "CNY");
			// 标价金额:订单总金额，单位为分
			NumberFormat nf = NumberFormat.getNumberInstance();
			//去掉小数位
			nf.setMaximumFractionDigits(0);
			//String totalAmountStr = (totalAmount * 100)+"";
			
			//System.out.println(nf.format(totalAmount));
			data.put("total_fee", nf.format(totalAmount * 100));
			// 终端IP:APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
			data.put("spbill_create_ip", getIpAddr(request));
			// 通知地址:异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
			data.put("notify_url", config.getNotifyUrl());
			// 交易类型,NATIVE:扫码支付
			data.put("trade_type", "NATIVE"); // 此处指定为扫码支付
			// 商品ID：trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义。
			data.put("product_id", ids);
			// 调用统一支付接口
			Map<String, String> respMap = wxpay.unifiedOrder(data);
			// 接收生成二维码的URL
			String urlCode = respMap.get("code_url");
			
			model.addAttribute("urlCode", urlCode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "site/tenpay";
	}

	
	/**
	 * 
	 * @Description: 检查微信付款是否支付成功
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkTenpay")
	public Map<String, Object> checkTenpay(HttpServletRequest request,@RequestParam(value = "outTradeNo", required = false,defaultValue = "") String outTradeNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//本系统订单号
			//String outTradeNo = request.getParameter("outTradeNo")==null? "": request.getParameter("id");
			//默认状态
			String status = IMySystemConstants.VALUE_0;
			Order order = orderService.queryOrderByOrderNum(outTradeNo);
			if(null != order){
				status = order.getStatus();
			}
			map.put("status", status);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 生成二维码图片 不存储 直接以流的形式输出到页面
	 * 
	 * @param content
	 * @param response
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/encodeQrcode")
	public void encodeQrcode(
			@RequestParam(value = "urlCode", required = false,defaultValue = "") String urlCode,
			HttpServletRequest request, HttpServletResponse response) {

		try {

			/*MyConfig config = new MyConfig();
			WXPay wxpay = new WXPay(config);

			Map<String, String> data = new HashMap<String, String>();
			// 商品描述
			data.put("body", "缘园思念网商品");
			// 商户订单号:商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一
			data.put("out_trade_no", outTradeNo);
			// 设备号:自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"
			data.put("device_info", "");
			// 标价币种:默认人民币：CNY
			data.put("fee_type", "CNY");
			// 标价金额:订单总金额，单位为分
			data.put("total_fee", (totalAmount * 100) + "");
			// 终端IP:APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
			data.put("spbill_create_ip", getIpAddr(request));
			// 通知地址:异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
			data.put("notify_url", config.getNotifyUrl());
			// 交易类型,NATIVE:扫码支付
			data.put("trade_type", "NATIVE"); // 此处指定为扫码支付
			// 商品ID：trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义。
			data.put("product_id", productId);
			// 调用统一支付接口
			Map<String, String> respMap = wxpay.unifiedOrder(data);*/
			// 接收生成二维码的URL
			//String urlCode = respMap.get("code_url");

			// 生成二维码
			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			@SuppressWarnings("rawtypes")
			Map hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8"); // 设置字符集编码类型
			BitMatrix bitMatrix = null;
			bitMatrix = multiFormatWriter.encode(urlCode,
					BarcodeFormat.QR_CODE, 500, 500, hints);
			BufferedImage image = toBufferedImage(bitMatrix);
			// 输出二维码图片流
			try {
				ImageIO.write(image, "png", response.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
			}
		}

		return image;
	}

	// 我的仓库：更新使用状态
	@ResponseBody
	@RequestMapping("/updateWarehouseForUse")
	public Map<String, Object> updateWarehouseForUse(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// id
			String ids = request.getParameter("ids") == null ? "" : request
					.getParameter("ids");
			// 纪念馆
			String hall_id = request.getParameter("hall_id") == null ? ""
					: request.getParameter("hall_id");
			Warehouse warehouse = null;
			for (String id : ids.split(",")) {
				warehouse = new Warehouse();
				warehouse.setId(Integer.parseInt(id));
				warehouse.setHall_id(hall_id);
				warehouseService.updateWarehouseStatus(warehouse);
			}
			map.put(RESULT_MESSAGE_STRING, "操作成功！");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 获取IP
	 * 
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
