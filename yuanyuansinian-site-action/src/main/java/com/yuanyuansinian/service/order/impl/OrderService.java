/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.order.impl;

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

import com.yuanyuansinian.dao.order.OrderMapper;
import com.yuanyuansinian.model.order.Order;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.order.IOrderService;

/**   
 * @Description: 友情链接Service 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("orderService") 
public class OrderService implements IOrderService {
	//友情链接Mapper
	@Resource
	private OrderMapper orderMapper;
	
	/*
	 * (non-Javadoc)
	 * <p>Title: updateOrder</p> 
	 * <p>Description: </p> 
	 * @param order
	 * @return 
	 * @see ujn.school.cn.service.order.IOrderService#updateOrder(ujn.school.cn.model.order.Order)
	 */
	@Override
	public int updateOrder(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.updateByPrimaryKey(order);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryOrderById</p> 
	 * <p>Description: </p> 
	 * @param orderId
	 * @return 
	 * @see ujn.school.cn.service.order.IOrderService#queryOrderById(int)
	 */
	@Override
	public Order queryOrderById(int orderId) {
		// TODO Auto-generated method stub
		return orderMapper.selectByPrimaryKey(orderId);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryOrderList</p> 
	 * <p>Description: </p> 
	 * @param order
	 * @return 
	 * @see ujn.school.cn.service.order.IOrderService#queryOrderList(ujn.school.cn.model.order.Order)
	 */
	@Override
	public List<Order> queryOrderList(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.queryOrderList(order);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: addOrder</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param order
	 * @return 
	 * @see ujn.school.cn.service.order.IOrderService#addOrder(javax.servlet.http.HttpServletRequest, ujn.school.cn.model.order.Order)
	 */
	@Override
	public int addOrder(HttpServletRequest request,Order order) {
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
	                        //order.setCover_img_url(IMySystemConstants.FILE_PATH_IMAGE + fileName);
	                    }  
	                }  
	            }  
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		//创建时间
		order.setCreate_date(MyDateUtil.getDateTime());
		return orderMapper.insert(order);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: deleteOrder</p> 
	 * <p>Description: </p> 
	 * @param orderId
	 * @return 
	 * @see ujn.school.cn.service.order.IOrderService#deleteOrder(int)
	 */
	@Override
	public int deleteOrder(int orderId) {
		
		return orderMapper.deleteByPrimaryKey(orderId);
	}


	@Override
	public List<Order> queryOrderListByType(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.queryOrderListByType(order);
	}

	@Override
	public List<Order> queryOrderListByMember(String memberId, int limtNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_id", memberId);
		map.put("limtNum", limtNum);
		return orderMapper.queryOrderListByMember(map);
	}

}
