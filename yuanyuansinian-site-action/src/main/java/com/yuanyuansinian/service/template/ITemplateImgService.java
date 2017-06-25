/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.template;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yuanyuansinian.model.template.TemplateImg;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:49:54
 * @version V1.0
 */
public interface ITemplateImgService {

	/**
	 * 
	 * @Description: 更新
	 * @param templateImg
	 * @return
	 */
	int updateTemplateImg(TemplateImg templateImg);

	/**
	 * 
	 * @Description: 根据ID查询
	 * @param templateImgId
	 * @return
	 */
	TemplateImg queryTemplateImgById(int templateImgId);

	/**
	 * 
	 * @Description: 分页列表
	 * @param templateImg
	 * @return
	 */
	List<TemplateImg> queryTemplateImgList(TemplateImg templateImg);

	/**
	 * 
	 * @Description: 添加
	 * @param request
	 * @param templateImg
	 * @return
	 */
	int addTemplateImg(HttpServletRequest request, TemplateImg templateImg);

	/**
	 * 
	 * @Description: 删除
	 * @param templateImgId
	 * @return
	 */
	int deleteTemplateImg(int templateImgId);

	void uploadTemplateImgImg(HttpServletRequest request, String id);

	List<TemplateImg> queryTemplateImgListByType(String template_type);

}
