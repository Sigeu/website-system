/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.cemetery.impl;

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

import com.yuanyuansinian.dao.cemetery.CemeteryMapper;
import com.yuanyuansinian.model.cemetery.Cemetery;
import com.yuanyuansinian.model.cemetery.CemeteryWithBLOBs;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.cemetery.ICemeteryService;

/**   
 * @Description: 友情链接Service 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("cemeteryService") 
public class CemeteryService implements ICemeteryService {
	//友情链接Mapper
	@Resource
	private CemeteryMapper cemeteryMapper;
	
	/*
	 * (non-Javadoc)
	 * <p>Title: updateCemetery</p> 
	 * <p>Description: </p> 
	 * @param cemetery
	 * @return 
	 * @see ujn.school.cn.service.cemetery.ICemeteryService#updateCemetery(ujn.school.cn.model.cemetery.Cemetery)
	 */
	@Override
	public int updateCemetery(CemeteryWithBLOBs cemetery) {
		// TODO Auto-generated method stub
		return cemeteryMapper.updateByPrimaryKeySelective(cemetery);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryCemeteryById</p> 
	 * <p>Description: </p> 
	 * @param cemeteryId
	 * @return 
	 * @see ujn.school.cn.service.cemetery.ICemeteryService#queryCemeteryById(int)
	 */
	@Override
	public Cemetery queryCemeteryById(int cemeteryId) {
		// TODO Auto-generated method stub
		return cemeteryMapper.selectByPrimaryKey(cemeteryId);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: addCemetery</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param cemetery
	 * @return 
	 * @see ujn.school.cn.service.cemetery.ICemeteryService#addCemetery(javax.servlet.http.HttpServletRequest, ujn.school.cn.model.cemetery.Cemetery)
	 */
	@Override
	public int addCemetery(HttpServletRequest request,CemeteryWithBLOBs cemetery) {
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
	                        //cemetery.setCover_img_url(IMySystemConstants.FILE_PATH_IMAGE + fileName);
	                    }  
	                }  
	            }  
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		//创建时间
		cemetery.setCreate_date(MyDateUtil.getDateTime());
		return cemeteryMapper.insert(cemetery);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: deleteCemetery</p> 
	 * <p>Description: </p> 
	 * @param cemeteryId
	 * @return 
	 * @see ujn.school.cn.service.cemetery.ICemeteryService#deleteCemetery(int)
	 */
	@Override
	public int deleteCemetery(int cemeteryId) {
		
		return cemeteryMapper.deleteByPrimaryKey(cemeteryId);
	}


	@Override
	public List<Cemetery> queryCemeteryListByType(String cemetery_type) {
		// TODO Auto-generated method stub
		return cemeteryMapper.queryCemeteryListByType(cemetery_type);
	}

	@Override
	public List<Cemetery> queryCemeteryListByMember(String memberId, int limtNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("limtNum", limtNum);
		
		return cemeteryMapper.queryCemeteryListByMember(map);
	}

	@Override
	public List<Cemetery> queryCemeteryListByOpenType(Cemetery cemetery) {
		// TODO Auto-generated method stub
		return cemeteryMapper.queryCemeteryListByOpenType(cemetery);
	}

	@Override
	public List<Cemetery> queryCemeteryList(Cemetery cemetery) {
		// TODO Auto-generated method stub
		return cemeteryMapper.queryCemeteryList(cemetery);
	}

	@Override
	public List<Cemetery> queryCemeteryPageListByMember(Cemetery cemetery) {
		// TODO Auto-generated method stub
		return cemeteryMapper.queryCemeteryPageListByMemberCemetery(cemetery);
	}

	@Override
	public void uploadCemeteryImg(HttpServletRequest request, String id) {
		try {
			//创建一个通用的多部分解析器  
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext()); 
	        Cemetery  cemetery =  null;
	        //判断 request 是否有文件上传,即多部分请求  
	        if(multipartResolver.isMultipart(request)){ 
	        	cemetery =  new Cemetery();
	            //转换成多部分request    
	            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
	            //设置ID
	            cemetery.setId(Integer.parseInt(id));
	            //封面照片
	            MultipartFile img_index = multiRequest.getFile("img_cemetery");
	            if(null != img_index){
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
                        cemetery.setImgs("/" + srcPathTem + "/" + fileName);
                    }  
	            }
	        }
	        //保存
	        cemeteryMapper.uploadCemeteryImg(cemetery);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Cemetery> queryCemeteryListForCountNum(int countNum) {
		// TODO Auto-generated method stub
		return cemeteryMapper.queryCemeteryListForCountNum(countNum);
	}

}
