/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.service.link;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ujn.school.cn.model.link.Link;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:49:54
 * @version V1.0
 */
public interface ILinkService {

	/**
	 * 
	 * @Description: 更新
	 * @param link
	 * @return
	 */
	int updateLink(Link link);

	/**
	 * 
	 * @Description: 根据ID查询
	 * @param linkId
	 * @return
	 */
	Link queryLinkById(int linkId);

	/**
	 * 
	 * @Description: 分页列表
	 * @param link
	 * @return
	 */
	List<Link> queryLinkList(Link link);

	/**
	 * 
	 * @Description: 添加
	 * @param request
	 * @param link
	 * @return
	 */
	int addLink(HttpServletRequest request, Link link);

	/**
	 * 
	 * @Description: 删除
	 * @param linkId
	 * @return
	 */
	int deleteLink(int linkId);

}
