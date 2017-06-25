/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.template.impl;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.yuanyuansinian.dao.template.TemplateImgMapper;
import com.yuanyuansinian.model.template.TemplateImg;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.service.template.ITemplateImgService;

/**   
 * @Description: 灵堂模版图片Service 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("templateImgService") 
public class TemplateImgService implements ITemplateImgService {
	//灵堂模版图片Mapper
	@Resource
	private TemplateImgMapper templateImgMapper;
	
	/*
	 * (non-Javadoc)
	 * <p>Title: updateTemplateImg</p> 
	 * <p>Description: </p> 
	 * @param templateImg
	 * @return 
	 * @see ujn.school.cn.service.templateImg.ITemplateImgService#updateTemplateImg(ujn.school.cn.model.templateImg.TemplateImg)
	 */
	@Override
	public int updateTemplateImg(TemplateImg templateImg) {
		// TODO Auto-generated method stub
		return templateImgMapper.updateByPrimaryKeySelective(templateImg);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryTemplateImgById</p> 
	 * <p>Description: </p> 
	 * @param templateImgId
	 * @return 
	 * @see ujn.school.cn.service.templateImg.ITemplateImgService#queryTemplateImgById(int)
	 */
	@Override
	public TemplateImg queryTemplateImgById(int templateImgId) {
		// TODO Auto-generated method stub
		return templateImgMapper.selectByPrimaryKey(templateImgId);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryTemplateImgList</p> 
	 * <p>Description: </p> 
	 * @param templateImg
	 * @return 
	 * @see ujn.school.cn.service.templateImg.ITemplateImgService#queryTemplateImgList(ujn.school.cn.model.templateImg.TemplateImg)
	 */
	@Override
	public List<TemplateImg> queryTemplateImgList(TemplateImg templateImg) {
		// TODO Auto-generated method stub
		return templateImgMapper.queryTemplateImgList(templateImg);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: addTemplateImg</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param templateImg
	 * @return 
	 * @see ujn.school.cn.service.templateImg.ITemplateImgService#addTemplateImg(javax.servlet.http.HttpServletRequest, ujn.school.cn.model.templateImg.TemplateImg)
	 */
	@Override
	public int addTemplateImg(HttpServletRequest request,TemplateImg templateImg) {
		//
		return templateImgMapper.insert(templateImg);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: deleteTemplateImg</p> 
	 * <p>Description: </p> 
	 * @param templateImgId
	 * @return 
	 * @see ujn.school.cn.service.templateImg.ITemplateImgService#deleteTemplateImg(int)
	 */
	@Override
	public int deleteTemplateImg(int templateImgId) {
		
		return templateImgMapper.deleteByPrimaryKey(templateImgId);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: uploadTemplateImgImg</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param id 
	 * @see com.yuanyuansinian.service.templateImg.ITemplateImgService#uploadTemplateImgImg(javax.servlet.http.HttpServletRequest, java.lang.String)
	 */
	@Override
	public void uploadTemplateImgImg(HttpServletRequest request, String id) {
		try {
			//创建一个通用的多部分解析器  
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext()); 
	        TemplateImg templateImg =  null;
	        //判断 request 是否有文件上传,即多部分请求  
	        if(multipartResolver.isMultipart(request)){ 
	        	templateImg =  new TemplateImg();
	            //转换成多部分request    
	            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
	            //设置ID
	            templateImg.setId(Integer.parseInt(id));
	            //封面照片
	            MultipartFile img_index = multiRequest.getFile("img_");
	            if(null != img_index){
	            	//byte[] imgFile = img_index.getBytes();
					// 保存照片
	            	//carousel.setImg(imgFile);
                    //取得当前上传文件的文件名称  
                    String myFileName = img_index.getOriginalFilename();  
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                    if(myFileName.trim() !=""){  
                        //重命名上传后的文件名  
                    	UUID uuid = UUID.randomUUID();
                        String fileName = uuid + myFileName; 
                        String path = request.getSession().getServletContext().getRealPath(IMySystemConstants.FILE_PATH_IMAGE);
                        //定义上传路径  
                        //String path = "E:/upload-file/"; 
                        File localFile = new File(path, fileName);  
                        if(!localFile.exists()){  
                        	localFile.mkdirs();  
                        }  
                        img_index.transferTo(localFile); 
                        //处理url
                        templateImg.setImgs(IMySystemConstants.SERVER_FILE_PATH + fileName);
                    }  
	            }
	        }
	        //保存
	        templateImgMapper.uploadTemplateImgImg(templateImg);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public List<TemplateImg> queryTemplateImgListByType(String template_type) {
		// TODO Auto-generated method stub
		return templateImgMapper.queryTemplateImgListByType(template_type);
	}
}
