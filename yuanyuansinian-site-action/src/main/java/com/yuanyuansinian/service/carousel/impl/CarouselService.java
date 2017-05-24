/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.carousel.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.yuanyuansinian.dao.carousel.CarouselMapper;
import com.yuanyuansinian.model.carousel.Carousel;
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
		//
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
	
	/*
	 * (non-Javadoc)
	 * <p>Title: uploadCarouselImg</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param id 
	 * @see com.yuanyuansinian.service.carousel.ICarouselService#uploadCarouselImg(javax.servlet.http.HttpServletRequest, java.lang.String)
	 */
	@Override
	public void uploadCarouselImg(HttpServletRequest request, String id) {
		try {
			//创建一个通用的多部分解析器  
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext()); 
	        Carousel carousel =  null;
	        //判断 request 是否有文件上传,即多部分请求  
	        if(multipartResolver.isMultipart(request)){ 
	        	carousel =  new Carousel();
	            //转换成多部分request    
	            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
	            //设置ID
	            carousel.setId(Integer.parseInt(id));
	            //封面照片
	            MultipartFile img_index = multiRequest.getFile("img_carousel");
	            if(null != img_index){
	            	byte[] imgFile = img_index.getBytes();
					// 保存照片
	            	carousel.setImg(imgFile);
	            }
	        }
	        //保存
	        carouselMapper.uploadCarouselImg(carousel);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public Carousel queryCarouselBySingle() {
		List<Carousel> listCarousel = carouselMapper.queryCarouselBySingle();
		Carousel carousel = null;
		if(!listCarousel.isEmpty()){
			carousel = listCarousel.get(0);
		}
		return carousel;
	}

	@Override
	public List<Carousel> queryCarouselListForSystem(Carousel carousel) {
		// TODO Auto-generated method stub
		return carouselMapper.queryCarouselListForSystem(carousel);
	}
}
