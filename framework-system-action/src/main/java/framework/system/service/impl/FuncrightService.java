/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import framework.system.dao.FuncrightMapper;
import framework.system.dao.RoleFuncrightMapper;
import framework.system.model.Funcright;
import framework.system.model.RoleFuncright;
import framework.system.service.IFuncrightService;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("funcrightService") 
public class FuncrightService implements IFuncrightService {
	@Resource
	private FuncrightMapper funcrightMapper;
	
	@Resource
	private RoleFuncrightMapper roleFuncrightMapper;

	@Override
	public int updateFuncright(Funcright funcright) {
		// TODO Auto-generated method stub
		return funcrightMapper.updateByPrimaryKey(funcright);
	}

	@Override
	public Funcright queryFuncrightById(int funcrightId) {
		// TODO Auto-generated method stub
		return funcrightMapper.selectByPrimaryKey(funcrightId);
	}

	@Override
	public List<Funcright> queryFuncrightList(Funcright funcright) {
		// TODO Auto-generated method stub
		return funcrightMapper.queryFuncrightList(funcright);
	}

	@Override
	public int addFuncright(HttpServletRequest request,Funcright funcright) {
		//创建时间
		return funcrightMapper.insert(funcright);
	}

	@Override
	public int deleteFuncright(int funcrightId) {
		
		return funcrightMapper.deleteByPrimaryKey(funcrightId);
	}

	@Override
	public List<Funcright> queryFuncrightTree(Funcright funcright) {
		// TODO Auto-generated method stub
		return funcrightMapper.queryFuncrightTree(funcright);
	}

	@Override
	public List<RoleFuncright> queryRoleFuncrightTree(String role_id) {
		// TODO Auto-generated method stub
		return roleFuncrightMapper.queryRoleFuncrightTree(role_id);
	}
	


}
