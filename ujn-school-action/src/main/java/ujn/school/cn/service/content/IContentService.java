/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.service.content;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ujn.school.cn.model.content.Content;
import ujn.school.cn.model.content.ContentWithBLOBs;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:49:54
 * @version V1.0
 */
public interface IContentService {

	/**
	 * 
	 * @Description: 更新
	 * @param content
	 * @return
	 */
	int updateContent(ContentWithBLOBs content);

	/**
	 * 
	 * @Description: 根据ID查询
	 * @param contentId
	 * @return
	 */
	ContentWithBLOBs  queryContentById(int contentId);

	/**
	 * 
	 * @Description: 分页列表
	 * @param content
	 * @return
	 */
	List<Content> queryContentList(Content content);

	/**
	 * 
	 * @Description: 添加 
	 * @param request
	 * @param content
	 * @return
	 */
	int addContent(HttpServletRequest request, ContentWithBLOBs content);

	/**
	 * 
	 * @Description: 删除
	 * @param contentId
	 * @return
	 */
	int deleteContent(int contentId);

	List<Content> queryContentRecycleList(Content content);

	List<Content> queryContentListByColumn(Content content);

	int recoverContent(int contentId);

	void updateContentOrderNum(ContentWithBLOBs content);

	int auditContent(ContentWithBLOBs content);

}
