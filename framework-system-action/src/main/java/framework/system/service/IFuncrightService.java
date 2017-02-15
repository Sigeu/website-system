/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import framework.system.model.Funcright;
import framework.system.model.RoleFuncright;


/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:49:54 
 * @version V1.0   
 */
public interface IFuncrightService {
	/**
	 * @param funcright
	 * @return
	 */
	int updateFuncright(Funcright funcright);


	Funcright queryFuncrightById(int funcrightId);


	List<Funcright> queryFuncrightList(Funcright funcright);


	int addFuncright(HttpServletRequest request,Funcright funcright);


	int deleteFuncright(int funcrightId);



	List<Funcright> queryFuncrightTree(Funcright funcright);


	List<RoleFuncright> queryRoleFuncrightTree(String role_id);

}
