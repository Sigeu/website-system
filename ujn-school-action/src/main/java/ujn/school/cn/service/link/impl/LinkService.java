/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.service.link.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ujn.school.cn.dao.link.LinkMapper;
import ujn.school.cn.model.link.Link;
import ujn.school.cn.service.link.ILinkService;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("linkService") 
public class LinkService implements ILinkService {
	@Resource
	private LinkMapper linkMapper;

	@Override
	public int updateLink(Link link) {
		// TODO Auto-generated method stub
		return linkMapper.updateByPrimaryKey(link);
	}

	@Override
	public Link queryLinkById(int linkId) {
		// TODO Auto-generated method stub
		return linkMapper.selectByPrimaryKey(linkId);
	}

	@Override
	public List<Link> queryLinkList(Link link) {
		// TODO Auto-generated method stub
		return linkMapper.queryLinkList(link);
	}

	@Override
	public int addLink(Link link) {
		// TODO Auto-generated method stub
		return linkMapper.insert(link);
	}
	


}
