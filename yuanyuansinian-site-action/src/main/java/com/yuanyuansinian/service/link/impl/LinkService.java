/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.link.impl;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.yuanyuansinian.dao.link.LinkMapper;
import com.yuanyuansinian.model.link.Link;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.link.ILinkService;

/**   
 * @Description: 友情链接Service 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("linkService") 
public class LinkService implements ILinkService {
	//友情链接Mapper
	@Resource
	private LinkMapper linkMapper;
	
	/*
	 * (non-Javadoc)
	 * <p>Title: updateLink</p> 
	 * <p>Description: </p> 
	 * @param link
	 * @return 
	 * @see ujn.school.cn.service.link.ILinkService#updateLink(ujn.school.cn.model.link.Link)
	 */
	@Override
	public int updateLink(Link link) {
		// TODO Auto-generated method stub
		return linkMapper.updateByPrimaryKey(link);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryLinkById</p> 
	 * <p>Description: </p> 
	 * @param linkId
	 * @return 
	 * @see ujn.school.cn.service.link.ILinkService#queryLinkById(int)
	 */
	@Override
	public Link queryLinkById(int linkId) {
		// TODO Auto-generated method stub
		return linkMapper.selectByPrimaryKey(linkId);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryLinkList</p> 
	 * <p>Description: </p> 
	 * @param link
	 * @return 
	 * @see ujn.school.cn.service.link.ILinkService#queryLinkList(ujn.school.cn.model.link.Link)
	 */
	@Override
	public List<Link> queryLinkList(Link link) {
		// TODO Auto-generated method stub
		return linkMapper.queryLinkList(link);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: addLink</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param link
	 * @return 
	 * @see ujn.school.cn.service.link.ILinkService#addLink(javax.servlet.http.HttpServletRequest, ujn.school.cn.model.link.Link)
	 */
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
	                    	UUID uuid = UUID.randomUUID();
	                        String fileName = uuid + file.getOriginalFilename(); 
	                        String path = request.getSession().getServletContext().getRealPath(IMySystemConstants.FILE_PATH_IMAGE);
	                        //定义上传路径  
	                        //String path = "E:/upload-file/"; 
	                        File localFile = new File(path, fileName);  
	                        if(!localFile.exists()){  
	                        	localFile.mkdirs();  
	                        }  
	                        file.transferTo(localFile);  
	                        link.setWeb_logo(IMySystemConstants.FILE_PATH_IMAGE + fileName);
	                    }  
	                }  
	            }  
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		//创建时间
		link.setAdd_time(MyDateUtil.getDateTime());
		return linkMapper.insert(link);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: deleteLink</p> 
	 * <p>Description: </p> 
	 * @param linkId
	 * @return 
	 * @see ujn.school.cn.service.link.ILinkService#deleteLink(int)
	 */
	@Override
	public int deleteLink(int linkId) {
		
		return linkMapper.deleteByPrimaryKey(linkId);
	}
	


}
