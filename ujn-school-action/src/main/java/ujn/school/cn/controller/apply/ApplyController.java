/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.controller.apply;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ujn.school.cn.model.apply.Apply;
import ujn.school.cn.pub.base.MyBaseController;
import ujn.school.cn.pub.constants.IMySystemConstants;
import ujn.school.cn.pub.util.MyDateUtil;
import ujn.school.cn.pub.util.PoiExcelUtil;
import ujn.school.cn.service.apply.IApplyService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import framework.system.pub.util.DataTablePageUtil;

/**
 * @Description: 在线申请管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/apply/controller/applyController")
public class ApplyController extends MyBaseController {
	// 在线申请Service
	@Resource
	private IApplyService applyService;

	/**
	 * 
	 * @Description: 跳转到分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toApplyList")
	public String toApplyList(HttpServletRequest request, Model model) {

		return "apply/applyList";
	}

	// 意见反馈
	@RequestMapping("/toFeedbackList")
	public String toFeedbackList(HttpServletRequest request, Model model) {

		return "apply/feedbackList";
	}

	/**
	 * 
	 * @Description: 跳转到新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toApplyAdd")
	public String toApplyAdd(HttpServletRequest request, Model model) {

		return "apply/applyAdd";
	}

	/**
	 * 
	 * @Description: 跳转到修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toApplyUpdate")
	public String toApplyUpdate(HttpServletRequest request, Model model) {
		int applyId = Integer.parseInt(request.getParameter("id"));
		Apply apply = this.applyService.queryApplyById(applyId);
		model.addAttribute("apply", apply);

		return "apply/applyUpdate";
	}

	/**
	 * 
	 * @Description: 跳转到明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toApplyDetail")
	public String toApplyDetail(HttpServletRequest request, Model model) {
		int applyId = Integer.parseInt(request.getParameter("id"));
		Apply apply = this.applyService.queryApplyById(applyId);
		model.addAttribute("apply", apply);

		return "apply/applyDetail";
	}
	
	/**
	 * 
	 * @Description: 根据ID和确认码查询明细
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toShowReplyApplyDetail")
	public String toShowReplyApplyDetail(HttpServletRequest request, Model model) {
		int applyId = Integer.parseInt(request.getParameter("id"));
		String check_pwd = request.getParameter("check_pwd");
		Apply apply = this.applyService.queryApplyByIdAndCheckPwd(applyId,check_pwd);
		model.addAttribute("apply", apply);

		return "apply/applyDetailForReply";
	}
	
	/**
	 * 
	 * @Description: 跳转到回复页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toApplyReply")
	public String toApplyReply(HttpServletRequest request, Model model) {
		int applyId = Integer.parseInt(request.getParameter("id"));
		Apply apply = this.applyService.queryApplyById(applyId);
		model.addAttribute("apply", apply);

		return "apply/applyReply";
	}
	
	/**
	 * 
	 * @Description: 身份证上传
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toApplyIdPicUpload")
	public String toApplyIdPicUpload(HttpServletRequest request, Model model) {

		return "apply/applyIdPicUpload";
	}

	/**
	 * 
	 * @Description: 营业执照上传
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toApplyCreditPicUpload")
	public String toApplyCreditPicUpload(HttpServletRequest request, Model model) {

		return "apply/applyCreditPicUpload";
	}

	/**
	 * 
	 * @Description: 附件上传
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toApplyFilePicUpload")
	public String toApplyFilePicUpload(HttpServletRequest request, Model model) {

		return "apply/applyFilePicUpload";
	}

	/**
	 * 
	 * @Description: 分页列表
	 * @param request
	 * @param response
	 * @param apply
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryApplyList")
	public DataTablePageUtil<Apply> queryApplyList(HttpServletRequest request,
			HttpServletResponse response, Apply apply) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Apply> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Apply>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Apply> applyList = this.applyService.queryApplyList(apply);
			// 用PageInfo对结果进行包装
			PageInfo<Apply> pageInfo = new PageInfo<Apply>(applyList);

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
	 * @Description: 根据确认码查询数据 
	 * @param request
	 * @param response
	 * @param apply
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryApplyByPwd")
	public DataTablePageUtil<Apply> queryApplyByPwd(HttpServletRequest request,
			HttpServletResponse response, Apply apply) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Apply> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Apply>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Apply> applyList = this.applyService.queryApplyByPwd(apply);
			// 用PageInfo对结果进行包装
			PageInfo<Apply> pageInfo = new PageInfo<Apply>(applyList);

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
	 * @Description: 回复
	 * @param request
	 * @param apply
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/replyApply")
	public Map<String, Object> replyApply(HttpServletRequest request,
			Apply apply) {

		Map<String, Object> map = new HashMap<String, Object>();
		apply.setReply_date(MyDateUtil.getDateTime());
		int count = this.applyService.updateApplyForReply(request,apply);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, "回复成功");
		} else {
			map.put(RESULT_MESSAGE_STRING, "回复失败");
		}

		return map;
	}
	
	/**
	 * 
	 * @Description: 添加
	 * @param request
	 * @param apply
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addApply")
	public Map<String, Object> addApply(HttpServletRequest request, Apply apply) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 默认状态 1：正常
			apply.setStatus(STATUS_CODE_1);
			applyService.addApply(request, apply);
			map.put("apply_id", apply.getId());
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
	 * @param apply
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateApply")
	public Map<String, Object> updateApply(HttpServletRequest request,
			Apply apply) {

		Map<String, Object> map = new HashMap<String, Object>();
		// apply.setAdd_time(MyDateUtil.getDateTime());
		int count = this.applyService.updateApply(apply);
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
	 * @param apply
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveApply")
	public Map<String, Object> saveApply(HttpServletRequest request, Apply apply) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = this.applyService.updateApply(apply);
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
	@RequestMapping("/deleteApply")
	public Map<String, Object> deleteApply(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int applyId = Integer.parseInt(request.getParameter("id"));
		int count = this.applyService.deleteApply(applyId);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, DELETE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, DELETE_FAILED_MESSAGE);
		}
		return map;
	}

	/**
	 * 
	 * @Description: 上传身份证图片
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/uploadIdImg")
	public Map<String, Object> uploadIdImg(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String id = nullToStringZero(request.getParameter("model_id"));
			// 保存数据
			applyService.uploadIdImg(request, id);
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}

	/**
	 * 
	 * @Description: 上传营业执照图片
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/uploadCreditCodeImg")
	public Map<String, Object> uploadCreditCodeImg(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String id = nullToStringZero(request.getParameter("model_id"));
			// 保存数据
			applyService.uploadCreditCodeImg(request, id);
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}

	/**
	 * 
	 * @Description: 附件上传
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/uploadFile")
	public Map<String, Object> uploadFile(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String id = nullToStringZero(request.getParameter("model_id"));
			// 保存数据
			applyService.uploadFile(request, id);
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}

	/**
	 * 
	 * @Description: 查看原图
	 * @param request
	 * @param response
	 *            void
	 */
	@RequestMapping("/showImg")
	public String showImg(HttpServletRequest request, Model model) {

		int applyId = Integer.parseInt(request.getParameter("id"));
		//确认码：为了防止前台通过url修改id查询数据
		String check_pwd = request.getParameter("check_pwd");
		
		String type = request.getParameter("type");
		Apply apply = this.applyService.queryApplyByIdAndCheckPwd(applyId,check_pwd);
		model.addAttribute("apply", apply);
		model.addAttribute("type", type);

		return "apply/applyImg";
	}

	/**
	 * 
	 * @Description: 申请文件下载
	 * @param fileName
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/downloadFile")
	public void downloadFile(@RequestParam("id") Integer applyId,@RequestParam("check_pwd") String check_pwd,
			HttpServletRequest request, HttpServletResponse response) {
		
		//确认码：为了防止前台通过url修改id查询数据
		Apply apply = this.applyService.queryApplyByIdAndCheckPwd(applyId,check_pwd);
		if (null != apply) {
			String realPath = request.getServletContext().getRealPath(
					IMySystemConstants.FILE_PATH_IMAGE);
			String apply_file_path = apply.getApply_file_path();
			String fileName = apply_file_path.substring(apply_file_path
					.lastIndexOf("/") + 1);
			File file = new File(realPath, fileName);
			if (file.exists()) {
				response.setCharacterEncoding("utf-8");
				response.setContentType("multipart/form-data");
				response.setHeader("Content-Disposition",
						"attachment;fileName=" + fileName);

				// response.setContentType("application/force-download");//
				// 设置强制下载不打开
				// response.addHeader("Content-Disposition",
				// "attachment;fileName=" + fileName);// 设置文件名
				byte[] buffer = new byte[1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer);
					while (i != -1) {
						os.write(buffer, 0, i);
						i = bis.read(buffer);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					if (bis != null) {
						try {
							bis.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @Description: 回复附件下载 
	 * @param applyId
	 * @param request
	 * @param response
	 */
	@RequestMapping("/downloadFileForReply")
	public void downloadFileForReply(@RequestParam("id") Integer applyId,@RequestParam("check_pwd") String check_pwd,
			HttpServletRequest request, HttpServletResponse response) {
		//确认码：为了防止前台通过url修改id查询数据
		Apply apply = this.applyService.queryApplyByIdAndCheckPwd(applyId,check_pwd);
		if (null != apply) {
			String realPath = request.getServletContext().getRealPath(
					IMySystemConstants.FILE_PATH_IMAGE);
			String reply_file_path = apply.getReply_file_path();
			String fileName = reply_file_path.substring(reply_file_path
					.lastIndexOf("/") + 1);
			File file = new File(realPath, fileName);
			if (file.exists()) {
				response.setCharacterEncoding("utf-8");
				response.setContentType("multipart/form-data");
				response.setHeader("Content-Disposition",
						"attachment;fileName=" + fileName);

				// response.setContentType("application/force-download");//
				// 设置强制下载不打开
				// response.addHeader("Content-Disposition",
				// "attachment;fileName=" + fileName);// 设置文件名
				byte[] buffer = new byte[1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer);
					while (i != -1) {
						os.write(buffer, 0, i);
						i = bis.read(buffer);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					if (bis != null) {
						try {
							bis.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @Description: excel导出
	 * @param fileName
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/exportExcel")
	public void exportExcel(@RequestParam("user_type") String user_type,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			Apply apply = new Apply();
			apply.setUser_type(user_type);
			List<Apply> applyList = this.applyService.queryApplyList(apply);
			String title = "";
			if (STATUS_CODE_1.equals(user_type)) {
				title = "个人";
			} else if (STATUS_CODE_2.equals(user_type)) {
				title = "企业";
			}
			/*-------------------改造自 AbstractJExcelView-------------------------------------*/
			// 创建标题名称
			String titlename = title + "在线申请";
			// 创建表格标题
			String[] titles = { "申请人姓名", "申请日期", "分类", "联系电话", "工作单位", "申请内容" };
			// 列名
			String[] columns = { "user_name", "create_date", "user_type_name",
					"user_tel", "user_unit", "content" };
			// 列宽
			Integer[] widths = { 25, 25, 25, 25, 40, 100 };
			// sheet名称
			String sheetName = title + "在线申请导出数据";
			String excel_name = title + "在线申请导出数据";
			// excel 名称
			//String codedFileName = java.net.URLEncoder.encode(excel_name, "UTF-8");
			String codedFileName =  this.encodeChineseDownloadFileName(request,excel_name);
			// 设置导出格式和名称
			response.reset();
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename="
					+ codedFileName + ".xls");

			PoiExcelUtil.export(response, applyList, titles, columns, widths,
					sheetName, Apply.class, false, titlename);
			/*--------------------------------------------------------*/
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * 对文件流输出下载的中文文件名进行编码 屏蔽各种浏览器版本的差异性
	 * 
	 * @throws UnsupportedEncodingException
	 */
	public String encodeChineseDownloadFileName(
			HttpServletRequest request, String pFileName) throws Exception {

		String filename = null;
		String agent = request.getHeader("USER-AGENT");
		if (null != agent) {
			if (-1 != agent.indexOf("Firefox")) {// Firefox
				filename = "=?UTF-8?B?"
						+ (new String(
								org.apache.commons.codec.binary.Base64
										.encodeBase64(pFileName
												.getBytes("UTF-8")))) + "?=";
			} else if (-1 != agent.indexOf("Chrome")) {// Chrome
				filename = new String(pFileName.getBytes(), "ISO8859-1");
			} else {// IE7+
				filename = java.net.URLEncoder.encode(pFileName, "UTF-8");
				filename = filename.replace("+", "%20");
			}
		} else {
			filename = pFileName;
		}
		return filename;
	}
}
