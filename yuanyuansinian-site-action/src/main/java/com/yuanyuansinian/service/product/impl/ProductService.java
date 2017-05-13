/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.product.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.yuanyuansinian.dao.product.ProductMapper;
import com.yuanyuansinian.model.product.Product;
import com.yuanyuansinian.model.product.ProductWithBLOBs;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.product.IProductService;

/**   
 * @Description: 友情链接Service 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("productService") 
public class ProductService implements IProductService {
	//友情链接Mapper
	@Resource
	private ProductMapper productMapper;
	
	/*
	 * (non-Javadoc)
	 * <p>Title: updateProduct</p> 
	 * <p>Description: </p> 
	 * @param product
	 * @return 
	 * @see ujn.school.cn.service.product.IProductService#updateProduct(ujn.school.cn.model.product.Product)
	 */
	@Override
	public int updateProduct(ProductWithBLOBs product) {
		// TODO Auto-generated method stub
		return productMapper.updateByPrimaryKeySelective(product);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryProductById</p> 
	 * <p>Description: </p> 
	 * @param productId
	 * @return 
	 * @see ujn.school.cn.service.product.IProductService#queryProductById(int)
	 */
	@Override
	public ProductWithBLOBs queryProductById(int productId) {
		// TODO Auto-generated method stub
		return productMapper.selectByPrimaryKey(productId);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryProductList</p> 
	 * <p>Description: </p> 
	 * @param product
	 * @return 
	 * @see ujn.school.cn.service.product.IProductService#queryProductList(ujn.school.cn.model.product.Product)
	 */
	@Override
	public List<Product> queryProductList(Product product) {
		// TODO Auto-generated method stub
		return productMapper.queryProductList(product);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: addProduct</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param product
	 * @return 
	 * @see ujn.school.cn.service.product.IProductService#addProduct(javax.servlet.http.HttpServletRequest, ujn.school.cn.model.product.ProductWithBLOBs)
	 */
	@Override
	public int addProduct(HttpServletRequest request,ProductWithBLOBs product) {
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
	                        //product.setCover_img_url(IMySystemConstants.FILE_PATH_IMAGE + fileName);
	                    }  
	                }  
	            }  
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		//创建时间
		product.setCreate_date(MyDateUtil.getDateTime());
		return productMapper.insert(product);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: deleteProduct</p> 
	 * <p>Description: </p> 
	 * @param productId
	 * @return 
	 * @see ujn.school.cn.service.product.IProductService#deleteProduct(int)
	 */
	@Override
	public int deleteProduct(int productId) {
		
		return productMapper.deleteByPrimaryKey(productId);
	}

	@Override
	public List<Product> queryProductRecycleList(Product product) {
		// TODO Auto-generated method stub
		return productMapper.queryProductRecycleList(product);
	}

	@Override
	public List<Product> queryProductListByType(String type) {
		// TODO Auto-generated method stub
		return productMapper.queryProductListByType(type);
	}

	@Override
	public int recoverProduct(int productId) {
		// TODO Auto-generated method stub
		return productMapper.recoverProduct(productId);
	}

	@Override
	public void uploadImg(HttpServletRequest request, String id) {
		try {
			//创建一个通用的多部分解析器  
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext()); 
	        Product product =  null;
	        //判断 request 是否有文件上传,即多部分请求  
	        if(multipartResolver.isMultipart(request)){ 
	        	product =  new Product();
	            //转换成多部分request    
	            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
	            //设置ID
	            product.setId(Integer.parseInt(id));
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
                        //String path = request.getContextPath() + "/" + IMySystemConstants.FILE_PATH_IMAGE;
                        
                        //定义上传路径  
                        //String path = "E:/upload-file/"; 
                        File localFile = new File(path, fileName);  
                        if(!localFile.exists()){  
                        	localFile.mkdirs();  
                        }  
                        img_index.transferTo(localFile); 
                        //处理url
                        String webNameSrc = request.getContextPath();
                        String webName = webNameSrc.substring(1);
                        String srcP = path.substring(path.indexOf(webName),path.length());
                        String srcPathTem = srcP.replace("\\", "/");
                        product.setPic("/" + srcPathTem + "/" + fileName);
                    }  
	            }
	        }
	        //保存
	        productMapper.uploadImg(product);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> queryProductListByIds(String[] productIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productIds", productIds);
		return productMapper.queryProductListByIds(map);
	}

}
