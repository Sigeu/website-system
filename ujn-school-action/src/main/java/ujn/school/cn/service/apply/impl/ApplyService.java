/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.service.apply.impl;

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

import ujn.school.cn.dao.apply.ApplyMapper;
import ujn.school.cn.dao.file.FileMapper;
import ujn.school.cn.model.apply.Apply;
import ujn.school.cn.pub.constants.IMySystemConstants;
import ujn.school.cn.pub.util.MyDateUtil;
import ujn.school.cn.pub.util.MyRandomUtils;
import ujn.school.cn.service.apply.IApplyService;

/**   
 * @Description: 在线申请Service 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("applyService") 
public class ApplyService implements IApplyService {
	//在线申请Mapper
	@Resource
	private ApplyMapper applyMapper;
	
	@Resource
	private FileMapper fileMapper;
	
	/*
	 * (non-Javadoc)
	 * <p>Title: updateApply</p> 
	 * <p>Description: </p> 
	 * @param apply
	 * @return 
	 * @see ujn.school.cn.service.apply.IApplyService#updateApply(ujn.school.cn.model.apply.Apply)
	 */
	@Override
	public int updateApply(Apply apply) {
		// TODO Auto-generated method stub
		return applyMapper.updateByPrimaryKey(apply);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryApplyById</p> 
	 * <p>Description: </p> 
	 * @param applyId
	 * @return 
	 * @see ujn.school.cn.service.apply.IApplyService#queryApplyById(int)
	 */
	@Override
	public Apply queryApplyById(int applyId) {
		// TODO Auto-generated method stub
		return applyMapper.selectByPrimaryKey(applyId);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryApplyList</p> 
	 * <p>Description: </p> 
	 * @param apply
	 * @return 
	 * @see ujn.school.cn.service.apply.IApplyService#queryApplyList(ujn.school.cn.model.apply.Apply)
	 */
	@Override
	public List<Apply> queryApplyList(Apply apply) {
		// TODO Auto-generated method stub
		return applyMapper.queryApplyList(apply);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: addApply</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param apply
	 * @return 
	 * @see ujn.school.cn.service.apply.IApplyService#addApply(javax.servlet.http.HttpServletRequest, ujn.school.cn.model.apply.Apply)
	 */
	@Override
	public int addApply(HttpServletRequest request,Apply apply) {
		//创建时间
		apply.setCreate_date(MyDateUtil.getDateTime());
		apply.setCheck_pwd(MyRandomUtils.randomString(32));
		applyMapper.insert(apply);
		try {
			//附件表
			ujn.school.cn.model.file.File ujnFile = new ujn.school.cn.model.file.File();
			//创建一个通用的多部分解析器  
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
	        //判断 request 是否有文件上传,即多部分请求  
	        if(multipartResolver.isMultipart(request)){  
	            //转换成多部分request    
	            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
	            
	            //营业执照
	            MultipartFile file_credit = multiRequest.getFile("file-credit");
	            if(null != file_credit){
	            	Apply applyCredit = new Apply();
	            	//取得当前上传文件的文件名称  
                    String myFileName = file_credit.getOriginalFilename();  
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
                        file_credit.transferTo(localFile); 
                        applyCredit.setId(apply.getId());
                        //处理url
                        applyCredit.setCredit_code_file(IMySystemConstants.SERVER_FILE_PATH + fileName);
                      //保存
            	        applyMapper.uploadCreditCodeImg(applyCredit);
                    }
	            }
	            
	            //附件
	            MultipartFile file_apply = multiRequest.getFile("file-apply");
	            if(null != file_apply){
                	//取得当前上传文件的文件名称  
                    String myFileName = file_apply.getOriginalFilename();  
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                    if(myFileName.trim() !=""){  
                        //重命名上传后的文件名  
                    	UUID uuid = UUID.randomUUID();
                        String fileName = uuid + file_apply.getOriginalFilename(); 
                        String path = request.getSession().getServletContext().getRealPath(IMySystemConstants.FILE_PATH_IMAGE);
                        //定义上传路径  
                        //String path = "E:/upload-file/"; 
                        File localFile = new File(path, fileName);  
                        if(!localFile.exists()){  
                        	localFile.mkdirs();  
                        }  
                        file_apply.transferTo(localFile);  
                        //保存文件信息到附件表
                        ujnFile.setBelong_id(apply.getId()+"");
                        ujnFile.setFile_name(myFileName);
                        ujnFile.setFile_path(path);
                        ujnFile.setFile_status(IMySystemConstants.VALUE_1);
                        //保存附件表
                        fileMapper.insertSelective(ujnFile);
                    }  
	                }  
	            }
	            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: deleteApply</p> 
	 * <p>Description: </p> 
	 * @param applyId
	 * @return 
	 * @see ujn.school.cn.service.apply.IApplyService#deleteApply(int)
	 */
	@Override
	public int deleteApply(int applyId) {
		
		return applyMapper.deleteByPrimaryKey(applyId);
	}

	@Override
	public void uploadIdImg(HttpServletRequest request, String id) {
		try {
			//创建一个通用的多部分解析器  
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext()); 
	        Apply apply =  null;
	        //判断 request 是否有文件上传,即多部分请求  
	        if(multipartResolver.isMultipart(request)){ 
	        	apply =  new Apply();
	            //转换成多部分request    
	            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
	            //设置ID
	            apply.setId(Integer.parseInt(id));
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
                        apply.setId_file(IMySystemConstants.SERVER_FILE_PATH + fileName);
                    }
	            }
	        }
	        //保存
	        applyMapper.uploadIdImg(apply);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void uploadFile(HttpServletRequest request, String id) {
		try {
			//附件表
			ujn.school.cn.model.file.File ujnFile = new ujn.school.cn.model.file.File();
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
	                        //保存文件信息到附件表
	                        ujnFile.setBelong_id(id);
	                        ujnFile.setFile_name(myFileName);
	                        ujnFile.setFile_path(path);
	                        ujnFile.setFile_status(IMySystemConstants.VALUE_1);
	                        //保存附件表
	                        fileMapper.insertSelective(ujnFile);
	                    }  
	                }  
	            }  
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void uploadCreditCodeImg(HttpServletRequest request, String id) {
		try {
			//创建一个通用的多部分解析器  
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext()); 
	        Apply apply =  null;
	        //判断 request 是否有文件上传,即多部分请求  
	        if(multipartResolver.isMultipart(request)){ 
	        	apply =  new Apply();
	            //转换成多部分request    
	            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
	            //设置ID
	            apply.setId(Integer.parseInt(id));
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
                        apply.setCredit_code_file(IMySystemConstants.SERVER_FILE_PATH + fileName);
                    }
	            }
	        }
	        //保存
	        applyMapper.uploadCreditCodeImg(apply);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	


}
