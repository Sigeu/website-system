/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.cart.impl;

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

import com.yuanyuansinian.dao.cart.CartMapper;
import com.yuanyuansinian.model.cart.Cart;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.cart.ICartService;

/**   
 * @Description: 友情链接Service 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("cartService") 
public class CartService implements ICartService {
	//友情链接Mapper
	@Resource
	private CartMapper cartMapper;
	
	/*
	 * (non-Javadoc)
	 * <p>Title: updateCart</p> 
	 * <p>Description: </p> 
	 * @param cart
	 * @return 
	 * @see ujn.school.cn.service.cart.ICartService#updateCart(ujn.school.cn.model.cart.Cart)
	 */
	@Override
	public int updateCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartMapper.updateByPrimaryKey(cart);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryCartById</p> 
	 * <p>Description: </p> 
	 * @param cartId
	 * @return 
	 * @see ujn.school.cn.service.cart.ICartService#queryCartById(int)
	 */
	@Override
	public Cart queryCartById(int cartId) {
		// TODO Auto-generated method stub
		return cartMapper.selectByPrimaryKey(cartId);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryCartList</p> 
	 * <p>Description: </p> 
	 * @param cart
	 * @return 
	 * @see ujn.school.cn.service.cart.ICartService#queryCartList(ujn.school.cn.model.cart.Cart)
	 */
	@Override
	public List<Cart> queryCartList(Cart cart) {
		// TODO Auto-generated method stub
		return cartMapper.queryCartList(cart);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: addCart</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param cart
	 * @return 
	 * @see ujn.school.cn.service.cart.ICartService#addCart(javax.servlet.http.HttpServletRequest, ujn.school.cn.model.cart.CartWithBLOBs)
	 */
	@Override
	public int addCart(HttpServletRequest request,Cart cart) {
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
	                        //cart.setCover_img_url(IMySystemConstants.FILE_PATH_IMAGE + fileName);
	                    }  
	                }  
	            }  
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		//创建时间
		cart.setCreate_date(MyDateUtil.getDateTime());
		return cartMapper.insert(cart);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: deleteCart</p> 
	 * <p>Description: </p> 
	 * @param cartId
	 * @return 
	 * @see ujn.school.cn.service.cart.ICartService#deleteCart(int)
	 */
	@Override
	public int deleteCart(int cartId) {
		
		return cartMapper.deleteByPrimaryKey(cartId);
	}

	@Override
	public List<Cart> queryCartListByType(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}

}
