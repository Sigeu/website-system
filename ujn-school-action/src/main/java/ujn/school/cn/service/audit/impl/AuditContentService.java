/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.service.audit.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ujn.school.cn.dao.content.ContentMapper;
import ujn.school.cn.model.content.Content;
import ujn.school.cn.service.audit.IAuditContentService;

/**   
 * @Description: 内容审核Service 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("auditContentService") 
public class AuditContentService implements IAuditContentService {
	//内容审核Mapper
	@Resource
	private ContentMapper contentMapper;

	@Override
	public int updateAuditContent(Content content) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Content> queryAuditContentList(Content content) {
		// TODO Auto-generated method stub
		return contentMapper.queryAuditContentList(content);
	}

	@Override
	public Content queryContentAuditById(int auditContentId) {
		// TODO Auto-generated method stub
		return contentMapper.selectByPrimaryKey(auditContentId);
	}

	

}
