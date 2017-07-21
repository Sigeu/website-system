/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.controller.contact;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import framework.system.pub.util.LogUtil;
import ujn.school.cn.model.contact.Contact;
import ujn.school.cn.pub.base.MyBaseController;
import ujn.school.cn.service.contact.IContactService;

/**
 * @Description: 网站联系方式设置管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/contact/controller/contactController")
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
		
		//记录日志
		LogUtil.saveLog(request, "网站联系方式-修改");
		
		return map;
	}
}
