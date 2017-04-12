/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.service.content.impl;

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

import ujn.school.cn.dao.content.ContentMapper;
import ujn.school.cn.model.content.Content;
import ujn.school.cn.model.content.ContentWithBLOBs;
import ujn.school.cn.pub.constants.IMySystemConstants;
import ujn.school.cn.pub.util.MyAutoGenerateOrderNum;
import ujn.school.cn.pub.util.MyDateUtil;
import ujn.school.cn.service.content.IContentService;

/**   
 * @Description: 友情链接Service 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("contentService") 
public class ContentService implements IContentService {
	//友情链接Mapper
	@Resource
	private ContentMapper contentMapper;
	
	/*
	 * (non-Javadoc)
	 * <p>Title: updateContent</p> 
	 * <p>Description: </p> 
	 * @param content
	 * @return 
	 * @see ujn.school.cn.service.content.IContentService#updateContent(ujn.school.cn.model.content.Content)
	 */
	@Override
	public int updateContent(ContentWithBLOBs content) {
		// TODO Auto-generated method stub
		return contentMapper.updateByPrimaryKeyWithBLOBs(content);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryContentById</p> 
	 * <p>Description: </p> 
	 * @param contentId
	 * @return 
	 * @see ujn.school.cn.service.content.IContentService#queryContentById(int)
	 */
	@Override
	public ContentWithBLOBs queryContentById(int contentId) {
		// TODO Auto-generated method stub
		return contentMapper.selectByPrimaryKey(contentId);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryContentList</p> 
	 * <p>Description: </p> 
	 * @param content
	 * @return 
	 * @see ujn.school.cn.service.content.IContentService#queryContentList(ujn.school.cn.model.content.Content)
	 */
	@Override
	public List<Content> queryContentList(Content content) {
		// TODO Auto-generated method stub
		return contentMapper.queryContentList(content);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: addContent</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param content
	 * @return 
	 * @see ujn.school.cn.service.content.IContentService#addContent(javax.servlet.http.HttpServletRequest, ujn.school.cn.model.content.ContentWithBLOBs)
	 */
	@Override
	public int addContent(HttpServletRequest request,ContentWithBLOBs content) {
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
	                        content.setCover_img_url(IMySystemConstants.FILE_PATH_IMAGE + fileName);
	                    }  
	                }  
	            }  
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		//创建时间
		content.setAdd_time(MyDateUtil.getDateTime());
		return contentMapper.insert(content);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: deleteContent</p> 
	 * <p>Description: </p> 
	 * @param contentId
	 * @return 
	 * @see ujn.school.cn.service.content.IContentService#deleteContent(int)
	 */
	@Override
	public int deleteContent(int contentId) {
		
		return contentMapper.deleteByPrimaryKey(contentId);
	}

	@Override
	public List<Content> queryContentRecycleList(Content content) {
		// TODO Auto-generated method stub
		return contentMapper.queryContentRecycleList(content);
	}

	@Override
	public List<Content> queryContentListByColumn(Content content) {
		// TODO Auto-generated method stub
		return contentMapper.queryContentListByColumn(content);
	}

	@Override
	public int recoverContent(int contentId) {
		// TODO Auto-generated method stub
		return contentMapper.recoverContent(contentId);
	}

	@Override
	public void updateContentOrderNum(ContentWithBLOBs content) {
		// TODO Auto-generated method stub
		content.setCode_num(MyAutoGenerateOrderNum.generateArticleOrder(content,content.getId()+""));
		contentMapper.updateContentOrderNum(content);
	}

	@Override
	public int auditContent(ContentWithBLOBs content) {
		// TODO Auto-generated method stub
		return contentMapper.auditContent(content);
	}

	@Override
	public List<Content> queryContentListByNew(Content content) {
		// TODO Auto-generated method stub
		return contentMapper.queryContentListByNew(content);
	}

	@Override
	public List<Content> queryContentListByImportance(Content content) {
		// TODO Auto-generated method stub
		return contentMapper.queryContentListByImportance(content);
	}
	


}
