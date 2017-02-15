/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import framework.system.model.Funcright;
import framework.system.model.RoleFuncright;
import framework.system.pub.base.MyBaseController;
import framework.system.pub.util.DataTablePageUtil;
import framework.system.pub.util.ZtreeNode;
import framework.system.service.IFuncrightService;

/**
 * @Description: 角色管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("system/controller/funcrightController")
public class FuncrightController extends MyBaseController {

	@Resource
	private IFuncrightService funcrightService;


	/**
	 * 
	 * @Description: 跳转到列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toFuncrightList")
	public String toFuncrightList(HttpServletRequest request, Model model) {

		return "system/funcright/funcrightList";
	}

	/**
	 * @Description:  跳转到新增
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toFuncrightAdd")
	public String toFuncrightAdd(HttpServletRequest request, Model model) {
		
		return "system/funcright/funcrightAdd";
	}

	/**
	 * 
	 * @Description: 跳转到修改
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toFuncrightUpdate")
	public String toFuncrightUpdate(HttpServletRequest request, Model model) {
		int funcrightId = Integer.parseInt(request.getParameter("id"));
		Funcright funcright = this.funcrightService.queryFuncrightById(funcrightId);
		model.addAttribute("funcright", funcright);

		return "system/funcright/funcrightUpdate";
	}

	/**
	 * 
	 * @Description: 跳转到明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toFuncrightDetail")
	public String toFuncrightDetail(HttpServletRequest request, Model model) {
		int funcrightId = Integer.parseInt(request.getParameter("id"));
		Funcright funcright = this.funcrightService.queryFuncrightById(funcrightId);
		model.addAttribute("funcright", funcright);

		return "system/funcright/funcrightDetail";
	}

	/**
	 * 
	 * @Description: 栏目分页查询
	 * @param request
	 * @param response
	 * @param funcright
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryFuncrightList")
	public DataTablePageUtil<Funcright> queryFuncrightList(
			HttpServletRequest request, HttpServletResponse response,
			Funcright funcright) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Funcright> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Funcright>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Funcright> funcrightList = this.funcrightService
					.queryFuncrightList(funcright);
			// 用PageInfo对结果进行包装
			PageInfo<Funcright> pageInfo = new PageInfo<Funcright>(funcrightList);

			// 封装数据给DataTables
			dataTable.setDraw(dataTable.getDraw());
			dataTable.setData(pageInfo.getList());
			dataTable.setRecordsTotal((int) pageInfo.getTotal());
			dataTable.setRecordsFiltered(dataTable.getRecordsTotal());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return dataTable;
	}

	/**
	 * 
	 * @Description: 添加 
	 * @param request
	 * @param funcright
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addFuncright")
	public Map<String, Object> addFuncright(HttpServletRequest request, Funcright funcright) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			funcrightService.addFuncright(request, funcright);
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}
		
		return map;
	}

	/**
	 * 
	 * @param request
	 * @param funcright
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateFuncright")
	public Map<String, Object> updateFuncright(HttpServletRequest request, Funcright funcright) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		int count = this.funcrightService.updateFuncright(funcright);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}
	

	/**
	 * 
	 * @Description: 保存
	 * @param request
	 * @param funcright
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveFuncright")
	public Map<String, Object> saveFuncright(HttpServletRequest request,
			Funcright funcright) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = this.funcrightService.updateFuncright(funcright);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}

	/**
	 * 
	 * @Description: 删除
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteFuncright")
	public Map<String, Object> deleteFuncright(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int funcrightId = Integer.parseInt(request.getParameter("id"));
		int count  = this.funcrightService.deleteFuncright(funcrightId);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, DELETE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, DELETE_FAILED_MESSAGE);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/queryFuncrightTree")
	public ZtreeNode queryFuncrightTree(HttpServletRequest request, HttpServletResponse response,Funcright funcright){
		ZtreeNode ztreeNode = null;
		//返回的数据
		try {
			String role_id = request.getParameter("role_id");
			List<Funcright>  funcrightList = this.funcrightService.queryFuncrightTree(funcright);
			List<RoleFuncright>  roleFuncrightList = this.funcrightService.queryRoleFuncrightTree(role_id);
			//根节点
			ztreeNode = new ZtreeNode("", null,"系统菜单", true, false, false);
			String funcright_code = "";
			boolean flag = false;
			for (Funcright funcrightObj : funcrightList) {
				funcright_code = funcrightObj.getFuncright_code();
				for(RoleFuncright roleFuncright : roleFuncrightList){
					if(funcright_code.equals(roleFuncright.getFuncright_code())){
						flag = true;
						break;
					}else{
						flag = false;
					}
				}
				ztreeNode.addChild((new ZtreeNode(funcrightObj.getFuncright_code()
						.toString(), "",
						funcrightObj.getFuncright_name(), true, false, flag)));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ztreeNode;
	}
}
