/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.pub.base;

import javax.servlet.http.HttpServletRequest;

import framework.system.model.User;

/**
 * 基类：提取一些公用的方法
 * 
 * @author lizhaotao lzh_me@126.com
 * @date 2016年12月22日 下午2:55:55
 */
public class MyBaseController{


	/**
	 * 
	 * @Description: 获取保存在Session中的用户对象
	 * @param request
	 * @return User
	 */
	protected User getSessionUser(HttpServletRequest request) {
		
		return (User) request.getSession().getAttribute(SESSION_USER_KEY);
	}

	// 将用户对象保存到Session中
	protected void setSessionUser(HttpServletRequest request, User user) {
		request.getSession().setAttribute(SESSION_USER_KEY, user);
	}


	// 用户session key=
	public static final String SESSION_USER_KEY = "session_user";
	// 返回的KEY
	public static final String RESULT_MESSAGE_STRING = "result_message";
	public static final String RESULT_STATUS_STRING = "status_flag";

	// 结果数
	public static final int RESULT_COUNT_0 = 0;
	public static final int RESULT_COUNT_1 = 1;

	// 保存成功
	public static final String SAVE_SUCESS_MESSAGE = "保存成功！";
	public static final String DELETE_SUCESS_MESSAGE = "保存成功！";

	// 提交成功
	public static final String SUBMIT_SUCESS_MESSAGE = "提交成功！";

	// 保存失败
	public static final String SAVE_FAILED_MESSAGE = "保存失败，请联系管理员！";
	public static final String DELETE_FAILED_MESSAGE = "保存失败，请联系管理员！";

	// 提交失败
	public static final String SUBMIT_FAILED_MESSAGE = "提交失败，请联系管理员！";

	// 状态字段值
	public static final String STATUS_CODE_0 = "0";
	public static final String STATUS_CODE_1 = "1";
	public static final String STATUS_CODE_2 = "2";
	public static final String STATUS_CODE_3 = "3";

	// ------------------------------------------------------------------constants

}
