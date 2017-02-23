/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.service.audit;

import java.util.List;

import ujn.school.cn.model.content.Content;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:49:54
 * @version V1.0
 */
public interface IAuditContentService {

	/**
	 * 
	 * @Description: 更新
	 * @param content
	 * @return
	 */
	int updateAuditContent(Content content);


	/**
	 * 
	 * @Description: 分页列表
	 * @param content
	 * @return
	 */
	List<Content> queryAuditContentList(Content content);


	Content queryAuditContentById(int auditContentId);

}
