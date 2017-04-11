/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.service.apply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ujn.school.cn.model.apply.Apply;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 上午10:49:54
 * @version V1.0
 */
public interface IApplyService {

	/**
	 * 
	 * @Description: 更新
	 * @param apply
	 * @return
	 */
	int updateApply(Apply apply);

	/**
	 * 
	 * @Description: 根据ID查询
	 * @param applyId
	 * @return
	 */
	Apply queryApplyById(int applyId);

	/**
	 * 
	 * @Description: 分页列表
	 * @param apply
	 * @return
	 */
	List<Apply> queryApplyList(Apply apply);

	/**
	 * 
	 * @Description: 添加
	 * @param request
	 * @param apply
	 * @return
	 */
	int addApply(HttpServletRequest request, Apply apply);

	/**
	 * 
	 * @Description: 删除
	 * @param applyId
	 * @return
	 */
	int deleteApply(int applyId);

}
