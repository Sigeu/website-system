/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.suncity.service.contact.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.suncity.dao.column.ColumnMapper;
import com.suncity.dao.contact.ContactMapper;
import com.suncity.model.column.Column;
import com.suncity.model.contact.Contact;
import com.suncity.service.contact.IContactService;

/**
 * @Description: 网站联系方式设置
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:50:13
 * @version V1.0
 */
@Service("contactService")
public class ContactService implements IContactService {
	@Resource
	private ContactMapper contactMapper;
	
	@Resource
	private ColumnMapper columMapper;

	/*
	 * (non-Javadoc) <p>Title: updateContact</p> <p>Description: </p>
	 * 
	 * @param contact
	 * 
	 * @return
	 * 
	 * @see
	 * ujn.school.cn.service.contact.IContactService#updateContact(ujn.school.cn
	 * .model.contact.Contact)
	 */
	@Override
	public int updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return contactMapper.updateContact(contact);
	}

	/*
	 * (non-Javadoc) <p>Title: queryContact</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see ujn.school.cn.service.contact.IContactService#queryContact()
	 */
	@Override
	public Contact queryContact() {
		// TODO Auto-generated method stub
		return contactMapper.selectByPrimaryKey(1);
	}

	@Override
	public Column queryContactUs(String columnId) {
		
		return columMapper.selectByPrimaryKey(Integer.parseInt(columnId));
	}

}
