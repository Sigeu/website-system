/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.service.link.impl;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import ujn.school.cn.dao.link.LinkMapper;
import ujn.school.cn.model.link.Link;
import ujn.school.cn.pub.util.DateUtil;
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
	public int addLink(HttpServletRequest request,Link link) {
		try {
			//创建一个通用的多部分解析器  
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
	        //判断 request 是否有文件上传,即多部分请求  
	        if(multipartResolver.isMultipart(request)){  
	            //转换成多部分request    
	            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
	            //取得request中的所有文件名  
	            Iterator<String> iter = multiRequest.getFileNames();  
	            while(iter.hasNext()){  
	                //取得上传文件  
	                MultipartFile file = multiRequest.getFile(iter.next());  
	                if(file != null){  
	                    //取得当前上传文件的文件名称  
	                    String myFileName = file.getOriginalFilename();  
	                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
	                    if(myFileName.trim() !=""){  
	                        //重命名上传后的文件名  
	                        String fileName = "link-" + file.getOriginalFilename();  
	                        //定义上传路径  
	                        String path = "E:/upload-file/"; 
	                        File localFile = new File(path, fileName);  
	                        if(!localFile.exists()){  
	                        	localFile.mkdirs();  
	                        }  
	                        file.transferTo(localFile);  
	                        link.setWeb_logo(path);
	                    }  
	                }  
	            }  
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		//创建时间
		link.setAdd_time(DateUtil.getDateTime());
		return linkMapper.insert(link);
	}

	@Override
	public int deleteLink(int linkId) {
		
		return linkMapper.deleteByPrimaryKey(linkId);
	}
	


}
