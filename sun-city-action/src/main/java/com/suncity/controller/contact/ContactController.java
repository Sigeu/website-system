/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.suncity.controller.contact;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suncity.model.column.Column;
import com.suncity.model.contact.Contact;
import com.suncity.pub.base.MyBaseController;
import com.suncity.service.contact.IContactService;

/**
 * @Description: 网站联系方式设置管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/sinian/contact/contactController")
public class ContactController extends MyBaseController {
	//
	@Resource
	private IContactService contactService;

	/**
	 * 
	 * @Description: 跳转到设置页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toContact")
	public String toContact(HttpServletRequest request, Model model) {

		Contact contact = this.contactService.queryContact();
		model.addAttribute("contact", contact);

		return "contact/contact";
	}
	
	/**
	 * 
	 * @Description: 跳转到联系我们页面 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toContactUs")
	public String toContactUs(HttpServletRequest request, Model model) {
		//联系我们栏目ID
		String columnId = request.getParameter("id")==null? "0":request.getParameter("id");
		Column column = null;
		if(!"".equals(columnId)){
			column = this.contactService.queryContactUs(columnId);
		}
		model.addAttribute("column", column);
		
		Contact contact = this.contactService.queryContact();
		model.addAttribute("contact", contact);

		return "site/contactUs";
	}

	/**
	 * 
	 * @Description: 更新
	 * @param request
	 * @param contact
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateContact")
	public Map<String, Object> updateContact(HttpServletRequest request,
			Contact contact) {

		Map<String, Object> map = new HashMap<String, Object>();
		int count = this.contactService.updateContact(contact);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}
}
