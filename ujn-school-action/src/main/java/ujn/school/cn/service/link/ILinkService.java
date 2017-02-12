/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.service.link;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ujn.school.cn.model.column.Column;
import ujn.school.cn.model.link.Link;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:49:54 
 * @version V1.0   
 */
public interface ILinkService {
	
	
	
	/**
	 * @param link
	 * @return
	 */
	int updateLink(Link link);


	Link queryLinkById(int linkId);


	List<Link> queryLinkList(Link link);


	int addLink(HttpServletRequest request,Link link);


	int deleteLink(int linkId);


}
