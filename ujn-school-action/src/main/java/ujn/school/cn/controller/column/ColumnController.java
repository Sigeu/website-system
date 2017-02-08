/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.controller.column;

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

import ujn.school.cn.model.column.Column;
import ujn.school.cn.model.column.ColumnWithBLOBs;
import ujn.school.cn.service.column.IColumnService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import framework.system.pub.base.MyBaseController;
import framework.system.pub.util.DataTablePageUtil;

/**
 * @Description: 栏目管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/column/controller/columnController")
public class ColumnController extends MyBaseController {

	@Resource
	private IColumnService columnService;

	/**
	 * 
	 * @Description: 跳转到栏目列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/toColumnList")
	public String toColumnList(Model model) {

		return "column/columnList";
	}

	/**
	 * 
	 * @Description: 跳转到添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toColumnAdd")
	public String toColumnAdd(Model model) {
		return "column/columnAdd";
	}

	/**
	 * 
	 * @Description: 跳转到修改
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toColumnUpdate")
	public String toColumnUpdate(HttpServletRequest request, Model model) {
		int columnId = Integer.parseInt(request.getParameter("id"));
		Column column = this.columnService.queryColumnById(columnId);
		model.addAttribute("column", column);

		return "system/column/columnUpdate";
	}

	/**
	 * 
	 * @Description: 跳转到明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toColumnDetail")
	public String toColumnDetail(HttpServletRequest request, Model model) {
		int columnId = Integer.parseInt(request.getParameter("id"));
		Column column = this.columnService.queryColumnById(columnId);
		model.addAttribute("column", column);

		return "system/column/column";
	}

	/**
	 * 
	 * @Description: 栏目分页查询
	 * @param request
	 * @param response
	 * @param column
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryColumnList")
	public DataTablePageUtil<Column> queryColumnList(
			HttpServletRequest request, HttpServletResponse response,
			Column column) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Column> dataTable = null;
		try {
			System.out.println("order_dir:"+request.getParameter("order_dir") + "--order:--");
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Column>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Column> columnList = this.columnService
					.queryColumnList(column);
			// 用PageInfo对结果进行包装
			PageInfo<Column> pageInfo = new PageInfo<Column>(columnList);

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
	 * @param column
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addColumn")
	public Map<String, Object> addColumn(HttpServletRequest request, ColumnWithBLOBs column) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		int count = this.columnService.addColumn(column);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}

	/**
	 * 
	 * @Description: 更新
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateColumn")
	public String updateColumn(HttpServletRequest request, Model model) {
		int columnId = Integer.parseInt(request.getParameter("id"));
		Column column = this.columnService.queryColumnById(columnId);
		model.addAttribute("column", column);
		return "showColumn";
	}

	/**
	 * 
	 * @Description: 保存
	 * @param request
	 * @param column
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveColumn")
	public Map<String, Object> saveColumn(HttpServletRequest request,
			ColumnWithBLOBs column) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = this.columnService.saveColumn(column);
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
	@RequestMapping("/deleteColumn")
	public String deleteColumn(HttpServletRequest request, Model model) {
		int columnId = Integer.parseInt(request.getParameter("id"));
		Column column = this.columnService.queryColumnById(columnId);
		model.addAttribute("column", column);
		return "showColumn";
	}

	/**
	 * 
	 * @Description: 明细查询
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryColumnById")
	public String queryColumnById(HttpServletRequest request, Model model) {
		int columnId = Integer.parseInt(request.getParameter("id"));
		Column column = this.columnService.queryColumnById(columnId);
		model.addAttribute("column", column);
		return "showColumn";
	}
}
