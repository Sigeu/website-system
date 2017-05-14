/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.member.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.yuanyuansinian.dao.member.MemberMapper;
import com.yuanyuansinian.model.member.Member;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.member.IMemberService;

/**   
 * @Description: 会员Service 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("memberService") 
public class MemberService implements IMemberService {
	//会员Mapper
	@Resource
	private MemberMapper memberMapper;
	
	/*
	 * (non-Javadoc)
	 * <p>Title: updateMember</p> 
	 * <p>Description: </p> 
	 * @param member
	 * @return 
	 * @see ujn.school.cn.service.member.IMemberService#updateMember(ujn.school.cn.model.member.Member)
	 */
	@Override
	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		return memberMapper.updateByPrimaryKey(member);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryMemberById</p> 
	 * <p>Description: </p> 
	 * @param memberId
	 * @return 
	 * @see ujn.school.cn.service.member.IMemberService#queryMemberById(int)
	 */
	@Override
	public Member queryMemberById(int memberId) {
		// TODO Auto-generated method stub
		return memberMapper.selectByPrimaryKey(memberId);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryMemberList</p> 
	 * <p>Description: </p> 
	 * @param member
	 * @return 
	 * @see ujn.school.cn.service.member.IMemberService#queryMemberList(ujn.school.cn.model.member.Member)
	 */
	@Override
	public List<Member> queryMemberList(Member member) {
		// TODO Auto-generated method stub
		return memberMapper.queryMemberList(member);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: addMember</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param member
	 * @return 
	 * @see ujn.school.cn.service.member.IMemberService#addMember(javax.servlet.http.HttpServletRequest, ujn.school.cn.model.member.Member)
	 */
	@Override
	public int addMember(HttpServletRequest request,Member member) {
		//创建时间
		member.setCreate_date(MyDateUtil.getDateTime());
		return memberMapper.insert(member);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: deleteMember</p> 
	 * <p>Description: </p> 
	 * @param memberId
	 * @return 
	 * @see ujn.school.cn.service.member.IMemberService#deleteMember(int)
	 */
	@Override
	public int deleteMember(int memberId) {
		
		return memberMapper.deleteByPrimaryKey(memberId);
	}

	@Override
	public Member queryMemberByPhone(String phone,String pwd) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("phone", phone);
		map.put("pwd", pwd);
		return memberMapper.queryMemberByPhone(map);
	}

	@Override
	public int queryMemberCountByPhone(String phone) {
		// TODO Auto-generated method stub
		return memberMapper.queryMemberCountByPhone(phone);
	}

	@Override
	public int queryMemberCountByEmail(String email) {
		// TODO Auto-generated method stub
		return memberMapper.queryMemberCountByEmail(email);
	}

	@Override
	public Member queryMemberByEmail(String email,String pwd) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("pwd", pwd);
		return memberMapper.queryMemberByEmail(map);
	}

	@Override
	public void uploadImg(HttpServletRequest request, String id) {
		try {
			//创建一个通用的多部分解析器  
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext()); 
	        Member member =  null;
	        //判断 request 是否有文件上传,即多部分请求  
	        if(multipartResolver.isMultipart(request)){ 
	        	member =  new Member();
	            //转换成多部分request    
	            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
	            //设置ID
	            member.setId(Integer.parseInt(id));
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
                        
                        //定义上传路径  
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
                        member.setImgs("/" + srcPathTem + "/" + fileName);
                    }  
	            }
	        }
	        //保存
	        memberMapper.uploadImg(member);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	


}
