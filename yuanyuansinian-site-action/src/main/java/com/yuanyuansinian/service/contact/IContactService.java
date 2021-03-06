/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.contact;

import com.yuanyuansinian.model.column.Column;
import com.yuanyuansinian.model.contact.Contact;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:49:54 
 * @version V1.0   
 */
public interface IContactService {
	
	/**
	 * 
	 * @Description: 查询网站联系方式设置 
	 * @return
	 */
	Contact queryContact();
	
	
	/**
	 * 
	 * @Description: 添加更新（有数据更新，无数据添加） 
	 * @param contact
	 * @return
	 */
	int updateContact(Contact contact);


	Column queryContactUs(String columnId);


}
