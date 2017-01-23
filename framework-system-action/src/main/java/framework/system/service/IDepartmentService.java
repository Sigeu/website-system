/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.service;

import java.util.List;

import framework.system.model.Department;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:49:54 
 * @version V1.0   
 */
public interface IDepartmentService {
	
	/**
	 * 
	 * @Description: 根据ID查询 
	 * @param departmentId
	 * @return
	 */
	Department getDepartmentById(int departmentId);
	
	/**
	 * 
	 * @Description: 用户分页查询 
	 * @param department
	 * @return
	 */
	List<Department> queryDepartmentList(Department department);
	
	/**
	 * 
	 * @Description: 用户保存 
	 * @param department
	 */
	int saveDepartment(Department department);

}
