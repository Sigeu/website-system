/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.controller.carousel;

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
import com.yuanyuansinian.model.carousel.Carousel;
import com.yuanyuansinian.pub.base.MyBaseController;
import com.yuanyuansinian.service.carousel.ICarouselService;

import framework.system.pub.util.DataTablePageUtil;

/**
 * @Description: 轮播图片管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/sinian/carousel/carouselController")
public class CarouselController extends MyBaseController {
	// 轮播图片Service
	@Resource
	private ICarouselService carouselService;

	/**
	 * 
	 * @Description: 跳转到分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCarouselList")
	public String toCarouselList(HttpServletRequest request, Model model) {

		return "carousel/carouselList";
	}

	/**
	 * 
	 * @Description: 跳转到新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCarouselAdd")
	public String toCarouselAdd(HttpServletRequest request, Model model) {

		return "carousel/carouselAdd";
	}

	/**
	 * 
	 * @Description: 跳转到修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCarouselUpdate")
	public String toCarouselUpdate(HttpServletRequest request, Model model) {
		int carouselId = Integer.parseInt(request.getParameter("id"));
		Carousel carousel = this.carouselService.queryCarouselById(carouselId);
		model.addAttribute("carousel", carousel);

		return "carousel/carouselUpdate";
	}

	/**
	 * 
	 * @Description: 跳转到明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCarouselDetail")
	public String toCarouselDetail(HttpServletRequest request, Model model) {
		int carouselId = Integer.parseInt(request.getParameter("id"));
		Carousel carousel = this.carouselService.queryCarouselById(carouselId);
		model.addAttribute("carousel", carousel);

		return "carousel/carouselDetail";
	}

	/**
	 * 
	 * @Description: 分页列表
	 * @param request
	 * @param response
	 * @param carousel
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryCarouselList")
	public DataTablePageUtil<Carousel> queryCarouselList(HttpServletRequest request,
			HttpServletResponse response, Carousel carousel) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Carousel> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Carousel>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Carousel> carouselList = this.carouselService.queryCarouselList(carousel);
			// 用PageInfo对结果进行包装
			PageInfo<Carousel> pageInfo = new PageInfo<Carousel>(carouselList);

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
	 * @param carousel
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addCarousel")
	public Map<String, Object> addCarousel(HttpServletRequest request, Carousel carousel) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			carouselService.addCarousel(request, carousel);
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
	 * @param carousel
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateCarousel")
	public Map<String, Object> updateCarousel(HttpServletRequest request, Carousel carousel) {

		Map<String, Object> map = new HashMap<String, Object>();
		//carousel.setAdd_time(MyDateUtil.getDateTime());
		int count = this.carouselService.updateCarousel(carousel);
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
	 * @param carousel
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveCarousel")
	public Map<String, Object> saveCarousel(HttpServletRequest request, Carousel carousel) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = this.carouselService.updateCarousel(carousel);
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
	@RequestMapping("/deleteCarousel")
	public Map<String, Object> deleteCarousel(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int carouselId = Integer.parseInt(request.getParameter("id"));
		int count = this.carouselService.deleteCarousel(carouselId);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, DELETE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, DELETE_FAILED_MESSAGE);
		}
		return map;
	}

}
