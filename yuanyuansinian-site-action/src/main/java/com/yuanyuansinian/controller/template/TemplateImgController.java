/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.controller.template;

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
import com.yuanyuansinian.model.template.TemplateImg;
import com.yuanyuansinian.pub.base.MyBaseController;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.service.template.ITemplateImgService;

import framework.system.pub.util.DataTablePageUtil;

/**
 * @Description: 灵堂模版图片管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/sinian/templateImg/templateImgController")
public class TemplateImgController extends MyBaseController {
	// 灵堂模版图片Service
	@Resource
	private ITemplateImgService templateImgService;

	/**
	 * 
	 * @Description: 跳转到分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toTemplateImgList")
	public String toTemplateImgList(HttpServletRequest request, Model model) {

		return "templateImg/templateImgList";
	}

	/**
	 * 
	 * @Description: 跳转到新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toTemplateImgAdd")
	public String toTemplateImgAdd(HttpServletRequest request, Model model) {

		return "templateImg/templateImgAdd";
	}

	/**
	 * 
	 * @Description: 跳转到修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toTemplateImgUpdate")
	public String toTemplateImgUpdate(HttpServletRequest request, Model model) {
		int templateImgId = Integer.parseInt(request.getParameter("id"));
		TemplateImg templateImg = this.templateImgService.queryTemplateImgById(templateImgId);
		model.addAttribute("templateImg", templateImg);

		return "templateImg/templateImgUpdate";
	}

	/**
	 * 
	 * @Description: 跳转到明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toTemplateImgDetail")
	public String toTemplateImgDetail(HttpServletRequest request, Model model) {
		int templateImgId = Integer.parseInt(request.getParameter("id"));
		TemplateImg templateImg = this.templateImgService.queryTemplateImgById(templateImgId);
		model.addAttribute("templateImg", templateImg);

		return "templateImg/templateImgDetail";
	}
	
	/**
	 * 
	 * @Description: 模版选择页面 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toSingleTemplateImgChoose")
	public String toSingleTemplateImgChoose(HttpServletRequest request, Model model) {
		// 单人模版
		List<TemplateImg> singleTemplateImgList = this.templateImgService.queryTemplateImgListByType(IMySystemConstants.VALUE_1);
		model.addAttribute("singleTemplateImgList", singleTemplateImgList);
		
		return "templateImg/singleTemplateImgChoose";
	}
	
	/**
	 * 
	 * @Description: 模版选择页面 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toDoubleTemplateImgChoose")
	public String toDoubleTemplateImgChoose(HttpServletRequest request, Model model) {
		// 单人模版
		List<TemplateImg> doubleTemplateImgList = this.templateImgService.queryTemplateImgListByType(IMySystemConstants.VALUE_2);
		model.addAttribute("doubleTemplateImgList", doubleTemplateImgList);
				
		return "templateImg/doubleTemplateImgChoose";
	}
	
	/**
	 * 
	 * @Description: 分页列表
	 * @param request
	 * @param response
	 * @param templateImg
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryTemplateImgList")
	public DataTablePageUtil<TemplateImg> queryTemplateImgList(HttpServletRequest request,
			HttpServletResponse response, TemplateImg templateImg) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<TemplateImg> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<TemplateImg>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<TemplateImg> templateImgList = this.templateImgService.queryTemplateImgList(templateImg);
			// 用PageInfo对结果进行包装
			PageInfo<TemplateImg> pageInfo = new PageInfo<TemplateImg>(templateImgList);

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
	 * @param templateImg
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addTemplateImg")
	public Map<String, Object> addTemplateImg(HttpServletRequest request, TemplateImg templateImg) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			templateImgService.addTemplateImg(request, templateImg);
			map.put("model_id", templateImg.getId());
			//map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			//map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}
	
	/**
	 * 
	 * @Description: 上传灵堂模版图片 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/uploadImg")
	public Map<String, Object> uploadImg(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String id = nullToStringZero(request.getParameter("model_id"));
			//保存数据
			templateImgService.uploadTemplateImgImg(request, id);
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
	 * @param templateImg
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateTemplateImg")
	public Map<String, Object> updateTemplateImg(HttpServletRequest request, TemplateImg templateImg) {

		Map<String, Object> map = new HashMap<String, Object>();
		int count = this.templateImgService.updateTemplateImg(templateImg);
		map.put("model_id", templateImg.getId());
		if (RESULT_COUNT_1 == count) {
			map.put("templateImg_id", templateImg.getId());
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
	@RequestMapping("/deleteTemplateImg")
	public Map<String, Object> deleteTemplateImg(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int templateImgId = Integer.parseInt(request.getParameter("id"));
		int count = this.templateImgService.deleteTemplateImg(templateImgId);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, DELETE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, DELETE_FAILED_MESSAGE);
		}
		return map;
	}
	
	/**
	 * 
	 * @Description: 根据ID查询图片 
	 * @param request
	 * @param response
	 */
	/*@RequestMapping("/queryImgById")
	public void queryImgById(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//id
			int templateImgId = Integer.parseInt(request.getParameter("id"));
			TemplateImg templateImg = this.templateImgService.queryTemplateImgById(templateImgId);
			if(null != templateImg){
				if(null != templateImg.getImg()){
					byte[] pic = templateImg.getImg();
		            InputStream is = new ByteArrayInputStream(pic);
		            ServletOutputStream out=null;
		            response.setContentType("application/octet-stream;charset=UTF-8");
		            byte[] buff = new byte[2048];
		            int size = 0;
		            out = response.getOutputStream();
		            while (is != null && (size = is.read(buff)) != -1) {
		            	out.write(buff, 0, size);
		            }
		            out.flush();
		            out.close();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	

	/**
	 * 
	 * @Description: 查看原图
	 * @param request
	 * @param response
	 * void
	 */
	@RequestMapping("/showImg")
	public String showImg(HttpServletRequest request, Model model) {
		
		int templateImgId = Integer.parseInt(request.getParameter("id"));
		model.addAttribute("id", templateImgId);
		
		return "templateImg/templateImgImg";
	}
}
