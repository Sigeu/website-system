/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import framework.system.dao.RoleMapper;
import framework.system.model.Role;
import framework.system.service.IRoleService;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("roleService") 
public class RoleService implements IRoleService {
	@Resource
	private RoleMapper roleMapper;

	@Override
	public int updateRole(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.updateByPrimaryKey(role);
	}

	@Override
	public Role queryRoleById(int roleId) {
		// TODO Auto-generated method stub
		return roleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public List<Role> queryRoleList(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.queryRoleList(role);
	}

	@Override
	public int addRole(HttpServletRequest request,Role role) {
		//创建时间
		return roleMapper.insert(role);
	}

	@Override
	public int deleteRole(int roleId) {
		
		return roleMapper.deleteByPrimaryKey(roleId);
	}
	


}
