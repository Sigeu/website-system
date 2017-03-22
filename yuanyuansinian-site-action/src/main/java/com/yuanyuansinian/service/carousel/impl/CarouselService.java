/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.carousel.impl;

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

import com.yuanyuansinian.dao.carousel.CarouselMapper;
import com.yuanyuansinian.model.carousel.Carousel;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.service.carousel.ICarouselService;

/**   
 * @Description: 轮播图片Service 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("carouselService") 
public class CarouselService implements ICarouselService {
	//轮播图片Mapper
	@Resource
	private CarouselMapper carouselMapper;
	
	/*
	 * (non-Javadoc)
	 * <p>Title: updateCarousel</p> 
	 * <p>Description: </p> 
	 * @param carousel
	 * @return 
	 * @see ujn.school.cn.service.carousel.ICarouselService#updateCarousel(ujn.school.cn.model.carousel.Carousel)
	 */
	@Override
	public int updateCarousel(Carousel carousel) {
		// TODO Auto-generated method stub
		return carouselMapper.updateByPrimaryKey(carousel);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryCarouselById</p> 
	 * <p>Description: </p> 
	 * @param carouselId
	 * @return 
	 * @see ujn.school.cn.service.carousel.ICarouselService#queryCarouselById(int)
	 */
	@Override
	public Carousel queryCarouselById(int carouselId) {
		// TODO Auto-generated method stub
		return carouselMapper.selectByPrimaryKey(carouselId);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryCarouselList</p> 
	 * <p>Description: </p> 
	 * @param carousel
	 * @return 
	 * @see ujn.school.cn.service.carousel.ICarouselService#queryCarouselList(ujn.school.cn.model.carousel.Carousel)
	 */
	@Override
	public List<Carousel> queryCarouselList(Carousel carousel) {
		// TODO Auto-generated method stub
		return carouselMapper.queryCarouselList(carousel);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: addCarousel</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param carousel
	 * @return 
	 * @see ujn.school.cn.service.carousel.ICarouselService#addCarousel(javax.servlet.http.HttpServletRequest, ujn.school.cn.model.carousel.Carousel)
	 */
	@Override
	public int addCarousel(HttpServletRequest request,Carousel carousel) {
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
	                        //carousel.setWeb_logo(IMySystemConstants.FILE_PATH_IMAGE + fileName);
	                    }  
	                }  
	            }  
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		//创建时间
		return carouselMapper.insert(carousel);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: deleteCarousel</p> 
	 * <p>Description: </p> 
	 * @param carouselId
	 * @return 
	 * @see ujn.school.cn.service.carousel.ICarouselService#deleteCarousel(int)
	 */
	@Override
	public int deleteCarousel(int carouselId) {
		
		return carouselMapper.deleteByPrimaryKey(carouselId);
	}
	


}
