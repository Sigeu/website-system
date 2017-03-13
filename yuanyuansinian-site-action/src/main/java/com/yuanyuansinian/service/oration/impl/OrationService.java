/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.oration.impl;

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

import com.yuanyuansinian.dao.oration.OrationMapper;
import com.yuanyuansinian.model.oration.Oration;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.oration.IOrationService;

/**   
 * @Description: 友情链接Service 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("orationService") 
public class OrationService implements IOrationService {
	//友情链接Mapper
	@Resource
	private OrationMapper orationMapper;
	
	/*
	 * (non-Javadoc)
	 * <p>Title: updateOration</p> 
	 * <p>Description: </p> 
	 * @param oration
	 * @return 
	 * @see ujn.school.cn.service.oration.IOrationService#updateOration(ujn.school.cn.model.oration.Oration)
	 */
	@Override
	public int updateOration(Oration oration) {
		// TODO Auto-generated method stub
		return orationMapper.updateByPrimaryKey(oration);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryOrationById</p> 
	 * <p>Description: </p> 
	 * @param orationId
	 * @return 
	 * @see ujn.school.cn.service.oration.IOrationService#queryOrationById(int)
	 */
	@Override
	public Oration queryOrationById(int orationId) {
		// TODO Auto-generated method stub
		return orationMapper.selectByPrimaryKey(orationId);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: addOration</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param oration
	 * @return 
	 * @see ujn.school.cn.service.oration.IOrationService#addOration(javax.servlet.http.HttpServletRequest, ujn.school.cn.model.oration.Oration)
	 */
	@Override
	public int addOration(HttpServletRequest request,Oration oration) {
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
	                        //oration.setCover_img_url(IMySystemConstants.FILE_PATH_IMAGE + fileName);
	                    }  
	                }  
	            }  
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		//创建时间
		oration.setCreate_date(MyDateUtil.getDateTime());
		return orationMapper.insert(oration);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: deleteOration</p> 
	 * <p>Description: </p> 
	 * @param orationId
	 * @return 
	 * @see ujn.school.cn.service.oration.IOrationService#deleteOration(int)
	 */
	@Override
	public int deleteOration(int orationId) {
		
		return orationMapper.deleteByPrimaryKey(orationId);
	}


	@Override
	public List<Oration> queryOrationListByType(Oration oration) {
		// TODO Auto-generated method stub
		return orationMapper.queryOrationListByType(oration);
	}

	@Override
	public List<Oration> queryOrationListByMember(String memberId, int limtNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("limtNum", limtNum);
		return orationMapper.queryOrationListByMember(map);
	}

	@Override
	public List<Oration> queryOrationListByOpenType(Oration oration) {
		// TODO Auto-generated method stub
		return orationMapper.queryOrationListByOpenType(oration);
	}

	@Override
	public List<Oration> queryOrationList(Oration oration) {
		// TODO Auto-generated method stub
		return orationMapper.queryOrationList(oration);
	}

	@Override
	public List<Oration> queryOrationPageListByMember(Oration oration) {
		// TODO Auto-generated method stub
		return orationMapper.queryOrationPageListByMember(oration);
	}

	@Override
	public List<Oration> queryOrationNewList(int countNum) {
		// TODO Auto-generated method stub
		return orationMapper.queryOrationNewList(countNum);
	}

}
