/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import framework.system.dao.RoleFuncrightMapper;
import framework.system.dao.RoleMapper;
import framework.system.dao.UserRoleMapper;
import framework.system.model.Role;
import framework.system.model.RoleFuncright;
import framework.system.model.UserRole;
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
	
	@Resource
	private UserRoleMapper userRoleMapper;
	
	@Resource
	private RoleFuncrightMapper roleFuncrightMapper;

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

	@Override
	public List<Role> getRoleSelectList() {
		// TODO Auto-generated method stub
		return roleMapper.getRoleSelectList();
	}

	@Override
	public List<Role> queryRoleTree(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.queryRoleTree(role);
	}

	@Override
	public List<UserRole> queryUserRoleTree(String user_code) {
		// TODO Auto-generated method stub
		return userRoleMapper.queryUserRoleTree(user_code);
	}
	
	@Transactional
	@Override
	public boolean addUserRole(String login_name,String role_ids) {
		boolean flag = false;
		try {
			if(null != role_ids){
				//先删除
				userRoleMapper.deleteByUserCode(login_name);
				UserRole userRole = null;
				for(String role_code : role_ids.split(",")){
					if(!"".equals(role_code.trim())){
						userRole = new UserRole();
						userRole.setUser_code(login_name);
						userRole.setRole_code(role_code);
						userRoleMapper.insert(userRole);
					}
					
				}
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag = false;
		}
		
		return flag;
	}

	@Override
	public boolean addUserFuncright(String role_id, String funcright_ids) {
		boolean flag = false;
		try {
			if(null != funcright_ids){
				//先删除
				roleFuncrightMapper.deleteByRoleCode(role_id);
				RoleFuncright roleFuncright = null;
				for(String funcright_id : funcright_ids.split(",")){
					if(!"".equals(funcright_id.trim())){
						roleFuncright = new RoleFuncright();
						roleFuncright.setRole_code(role_id);;
						roleFuncright.setFuncright_code(funcright_id);
						roleFuncrightMapper.insert(roleFuncright);
					}
					
				}
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag = false;
		}
		
		return flag;
	}
	


}
