/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import framework.system.dao.DepartmentMapper;
import framework.system.model.Department;
import framework.system.service.IDepartmentService;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("departmentService") 
public class DepartmentService implements IDepartmentService {
	@Resource
	private DepartmentMapper departmentMapper;
	
	@Override
	public Department getDepartmentById(int departmentId) {
		//加载xml文件
        //ApplicationContext  ac = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
        //departmentMapper = (DepartmentMapper) ac.getBean("departmentMapper");

        return departmentMapper.selectByPrimaryKey(departmentId);
	}


	@Override
	public List<Department> queryDepartmentList(Department department) {
		// TODO Auto-generated method stub
		return departmentMapper.queryDepartmentList(department);
	}

	@Override
	public int saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentMapper.insertSelective(department);
	}

}
