/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.hall.impl;

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

import com.yuanyuansinian.dao.hall.HallDoubleMapper;
import com.yuanyuansinian.model.hall.HallDouble;
import com.yuanyuansinian.model.hall.HallDoubleWithBLOBs;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.hall.IHallDoubleService;

/**   
 * @Description: 友情链接Service 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("hallDoubleService") 
public class HallDoubleService implements IHallDoubleService {
	//友情链接Mapper
	@Resource
	private HallDoubleMapper hallDoubleMapper;
	
	/*
	 * (non-Javadoc)
	 * <p>Title: updateHallDouble</p> 
	 * <p>Description: </p> 
	 * @param hallDouble
	 * @return 
	 * @see ujn.school.cn.service.hallDouble.IHallDoubleService#updateHallDouble(ujn.school.cn.model.hallDouble.HallDouble)
	 */
	@Override
	public int updateHallDouble(HallDouble hallDouble) {
		// TODO Auto-generated method stub
		return hallDoubleMapper.updateByPrimaryKey(hallDouble);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryHallDoubleById</p> 
	 * <p>Description: </p> 
	 * @param hallDoubleId
	 * @return 
	 * @see ujn.school.cn.service.hallDouble.IHallDoubleService#queryHallDoubleById(int)
	 */
	@Override
	public HallDouble queryHallDoubleById(int hallDoubleId) {
		// TODO Auto-generated method stub
		return hallDoubleMapper.selectByPrimaryKey(hallDoubleId);
	}
	
	
	/*
	 * (non-Javadoc)
	 * <p>Title: deleteHallDouble</p> 
	 * <p>Description: </p> 
	 * @param hallDoubleId
	 * @return 
	 * @see ujn.school.cn.service.hallDouble.IHallDoubleService#deleteHallDouble(int)
	 */
	@Override
	public int deleteHallDouble(int hallDoubleId) {
		
		return hallDoubleMapper.deleteByPrimaryKey(hallDoubleId);
	}


	@Override
	public List<HallDouble> queryHallDoubleListByType(HallDouble hallDouble) {
		// TODO Auto-generated method stub
		return hallDoubleMapper.queryHallDoubleListByType(hallDouble);
	}

	@Override
	public List<HallDouble> queryHallDoubleListByMember(String memberId, int limtNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("limtNum", limtNum);
		
		return hallDoubleMapper.queryHallDoubleListByMember(map);
	}

	@Override
	public List<HallDouble> queryHallDoubleListByOpenType(String open_type) {
		// TODO Auto-generated method stub
		return hallDoubleMapper.queryHallDoubleListByOpenType(open_type);
	}

	@Override
	public List<HallDouble> queryHallDoubleList(HallDouble hallDouble) {
		// TODO Auto-generated method stub
		return hallDoubleMapper.queryHallDoubleList(hallDouble);
	}

	@Override
	public List<HallDouble> queryHallDoublePageListByMember(HallDouble hallDouble) {
		// TODO Auto-generated method stub
		return hallDoubleMapper.queryHallDoublePageListByMemberHallDouble(hallDouble);
	}

	@Override
	public List<HallDouble> queryHallDoubleNewList(int countNum) {
		// TODO Auto-generated method stub
		return hallDoubleMapper.queryHallDoubleNewList(countNum);
	}

	@Override
	public List<HallDouble> queryHallDoubleListBySearch(String search_text) {
		// TODO Auto-generated method stub
		return hallDoubleMapper.queryHallDoubleListBySearch(search_text);
	}

	@Override
	public void addSingleHallDouble(HttpServletRequest request, HallDoubleWithBLOBs hallDouble) {
		//保存
        hallDoubleMapper.insert(hallDouble);
	}

	@Override
	public void addDoubleHallDouble(HttpServletRequest request, HallDoubleWithBLOBs hallDouble) {
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
	                        //hallDouble.setCover_img_url(IMySystemConstants.FILE_PATH_IMAGE + fileName);
	                    }  
	                }  
	            }  
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		//创建时间
		hallDouble.setCreate_date(MyDateUtil.getDateTime());
		hallDoubleMapper.insert(hallDouble);
		
	}

	@Override
	public void uploadImg(HttpServletRequest request, String hallDouble_id) {
		try {
			//创建一个通用的多部分解析器  
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext()); 
	        HallDoubleWithBLOBs hallDouble =  null;
	        //判断 request 是否有文件上传,即多部分请求  
	        if(multipartResolver.isMultipart(request)){ 
	        	hallDouble =  new HallDoubleWithBLOBs();
	            //转换成多部分request    
	            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
	            //设置ID
				hallDouble.setId(Integer.parseInt(hallDouble_id));
	            //封面照片
	            MultipartFile img_index = multiRequest.getFile("img_");
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
                        hallDouble.setImgs("/" + srcPathTem + "/" + fileName);
                    }
	            }
	        }
	        //保存
	        hallDoubleMapper.uploadImg(hallDouble);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
