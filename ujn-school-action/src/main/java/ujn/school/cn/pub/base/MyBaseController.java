package ujn.school.cn.pub.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * 基类：提取一些公用的方法
 * 
 * @author lizhaotao lzh_me@126.com
 * @date 2016年12月22日 下午2:55:55
 */
public class MyBaseController extends MultiActionController{

	/**
	 *  
	 * @Description: 获取保存在Session中的用户对象
	 * @param request
	 * @return
	 * User
	 */
	/*protected User getSessionUser(HttpServletRequest request) {
		//UserSessionUtil.getUser(request);
		
		return (User) UserSessionUtil.getUser(request);
	}*/

	// 将用户对象保存到Session中
	/*
	 * protected void setSessionUser(HttpServletRequest request,User user) {
	 * request.getSession().setAttribute(CommonConstant.USER_CONTEXT, user); }
	 */
	

	/**
	 * 将返回结果通过IO返回到前台
	 * 
	 * @param resp
	 *            HttpServletResponse
	 * @param msg
	 *            String
	 */
	public void writeMsgToIo(HttpServletResponse resp, String msg) {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = resp.getWriter();
			out.write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != out) {
				out.close();
			}
		}
	}

	/**
	 * 
	 * @Description: 将JSON格式的数据通过write方式返回到页面，
	 *               解决writeMsgToIo方法返回的JSON数据经常无法解析问题。
	 * @param response
	 * @param msg
	 *            void
	 */
	public void writeJsonMsgToPage(HttpServletResponse response, String msg) {
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != out) {
				out.close();
			}
		}
	}

	
	// 返回的KEY
	public static final String RESULT_MESSAGE_STRING = "result_message";

	// 保存成功
	public static final String SAVE_SUCESS_MESSAGE = "保存成功！";

	// 提交成功
	public static final String SUBMIT_SUCESS_MESSAGE = "提交成功！";

	// 保存失败
	public static final String SAVE_FAILED_MESSAGE = "保存失败，请联系管理员！";

	// 提交失败
	public static final String SUBMIT_FAILED_MESSAGE = "提交失败，请联系管理员！";

	// 状态字段值
	public static final String STATUS_CODE_0 = "0";
	public static final String STATUS_CODE_1 = "1";
	public static final String STATUS_CODE_2 = "2";
	public static final String STATUS_CODE_3 = "3";
	
	
	//流程字段
	public static final String INSPECTOR_INFO_AUDIT = "inspectorInfoAudit";
	public static final String INSTANCE_ID = "instanceId";

	// ------------------------------------------------------------------constants

}
