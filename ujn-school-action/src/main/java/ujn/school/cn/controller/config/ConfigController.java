/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.controller.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ujn.school.cn.model.config.Config;
import ujn.school.cn.pub.base.MyBaseController;
import ujn.school.cn.service.config.IConfigService;

/**
 * @Description: 网站设置管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/config/controller/configController")
public class ConfigController extends MyBaseController {
	//
	@Resource
	private IConfigService configService;

	/**
	 * 
	 * @Description: 跳转到设置页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toConfig")
	public String toConfig(HttpServletRequest request, Model model) {

		Config config = this.configService.queryConfig();
		model.addAttribute("config", config);

		return "config/config";
	}

	/**
	 * 
	 * @Description: 更新
	 * @param request
	 * @param config
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateConfig")
	public Map<String, Object> updateConfig(HttpServletRequest request,
			Config config) {

		Map<String, Object> map = new HashMap<String, Object>();
		int count = this.configService.updateConfig(config);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}
}
