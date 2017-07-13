/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.controller.column;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ujn.school.cn.model.column.Column;
import ujn.school.cn.model.column.ColumnWithBLOBs;
import ujn.school.cn.pub.base.MyBaseController;
import ujn.school.cn.service.column.IColumnService;
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
	public String toColumnList(HttpServletRequest request, Model model) {

		return "column/columnList";
	}

	/**
	 * 
	 * @Description: 跳转到添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toColumnAdd")
	public String toColumnAdd(HttpServletRequest request, Model model) {

		/*// 还是使用List，方便后期用到
		List<Column> columnList = this.columnService.queryColumnList(null);
		if (null != columnList) {
			// 处理栏目名称
			for (Column co : columnList) {
				if (2 == co.getClass_type()) {
					co.setName("&brvbar;&mdash;" + co.getName());
				} else if (3 == co.getClass_type()) {
					co.setName("&brvbar;&mdash;&mdash;" + co.getName());
				} else if (4 == co.getClass_type()) {
					co.setName("&brvbar;&mdash;&mdash;&mdash;" + co.getName());
				} else {
					// co.setName(co.getName());
				}
			}
		}

		// 排序
		LinkedList<Column> result = new LinkedList<Column>();
		LinkedList<Column> columnLinkedList = this
				.toSort(columnList, result, 0);

		// 传到页面
		model.addAttribute("columnList", columnLinkedList);*/

		return "column/columnAdd";
	}

	/**
	 * 
	 * @Description: 树状List数据
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryColumnTreeList")
	public Map<String, Object> queryColumnTreeList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Column> columnList = columnService.queryColumnList(null);
			// 处理栏目名称
			for (Column co : columnList) {
				if (2 == co.getClass_type()) {
					co.setName("&brvbar;&mdash;" + co.getName());
				} else if (3 == co.getClass_type()) {
					co.setName("&brvbar;&mdash;&mdash;" + co.getName());
				} else if (4 == co.getClass_type()) {
					co.setName("&brvbar;&mdash;&mdash;&mdash;" + co.getName());
				} else {
					// co.setName(co.getName());
				}
			}
			// 排序
			LinkedList<Column> result = new LinkedList<Column>();
			LinkedList<Column> columnLinkedList = this.toSort(columnList,
					result, 0);
			// 转换为ArrayList
			List<Column> resultList = new ArrayList<Column>(columnLinkedList);
			map.put("resultList", resultList);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * 排序
	 * 
	 * @param list
	 * @param result
	 * @param father
	 * @return
	 */
	protected LinkedList<Column> toSort(List<Column> list,
			LinkedList<Column> result, int father) {
		List<Column> temp = new ArrayList<Column>();
		// 最高层,临时存放
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBig_class() == father) {
				temp.add(list.get(i));
			}
		}

		if (temp.size() < 1) {
			return result;
		} else {
			// 删除最高层
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getBig_class() == father) {
					list.remove(j);
				}
			}
			// 对最高层排序
			for (int i = 0; i < temp.size() - 1; i++) {
				for (int j = i + 1; j < temp.size(); j++) {
					if (temp.get(i).getNo_order() > temp.get(j).getNo_order()) {
						Column column = temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j, column);
					}
				}
			}
			// 递归
			for (int i = 0; i < temp.size(); i++) {
				result.add(temp.get(i));
				toSort(list, result, temp.get(i).getId());
			}
			return result;
		}

	}

	/**
	 * 
	 * @Description: 跳转到修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toColumnUpdate")
	public String toColumnUpdate(HttpServletRequest request, Model model) {
		int columnId = Integer.parseInt(request.getParameter("id"));
		Column column = this.columnService.queryColumnById(columnId);
		model.addAttribute("column", column);

		// 还是使用List，方便后期用到
		List<Column> columnList = this.columnService.queryColumnList(null);
		// 处理栏目名称
		for (Column co : columnList) {
			if (2 == co.getClass_type()) {
				co.setName("&brvbar;&mdash;" + co.getName());
			} else if (3 == co.getClass_type()) {
				co.setName("&brvbar;&mdash;&mdash;" + co.getName());
			} else if (4 == co.getClass_type()) {
				co.setName("&brvbar;&mdash;&mdash;&mdash;" + co.getName());
			} else {
				// co.setName(co.getName());
			}
		}
		LinkedList<Column> result = new LinkedList<Column>();
		LinkedList<Column> columnLinkedList = this
				.toSort(columnList, result, 0);
		model.addAttribute("columnList", columnLinkedList);

		return "column/columnUpdate";
	}

	/**
	 * 
	 * @Description: 跳转到栏目设置页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toColumnConfig")
	public String toColumnConfig(HttpServletRequest request, Model model) {
		int columnId = Integer.parseInt(request.getParameter("id"));
		Column column = this.columnService.queryColumnById(columnId);
		model.addAttribute("column", column);

		return "column/columnConfig";
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

		return "column/columnDetail";
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
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Column>(request);
			// 还是使用List，方便后期用到
			List<Column> columnList = this.columnService
					.queryColumnList(column);
			// 处理栏目名称
			for (Column co : columnList) {
				if (2 == co.getClass_type()) {
					co.setName("&brvbar;&mdash;" + co.getName());
				} else if (3 == co.getClass_type()) {
					co.setName("&brvbar;&mdash;&mdash;" + co.getName());
				} else if (4 == co.getClass_type()) {
					co.setName("&brvbar;&mdash;&mdash;&mdash;" + co.getName());
				} else {
					// co.setName(co.getName());
				}
			}
			// 排序
			LinkedList<Column> result = new LinkedList<Column>();
			LinkedList<Column> columnLinkedList = this.toSort(columnList,
					result, 0);
			// 转换为ArrayList
			List<Column> resultList = new ArrayList<Column>(columnLinkedList);

			// 封装数据给DataTables
			dataTable.setDraw(dataTable.getDraw());
			dataTable.setData(resultList);
			dataTable.setRecordsTotal(resultList.size());
			dataTable.setRecordsFiltered(dataTable.getRecordsTotal());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return dataTable;
	}
	
	/**
	 * 
	 * @Description: 获取所有数据 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listColumn")
	public List<Column> listColumn() {
		List<Column> columnList = null;
		try {
			columnList = this.columnService.queryColumnList(null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return columnList;
	}

	/**
	 * 
	 * @Description: 栏目数据（树状结构）
	 * @param enableCheck
	 * @param hasSelected
	 * @param model
	 * @return
	 */
	@RequestMapping("columnTree")
	public String columnTree(
			@RequestParam(value = "enableCheck", required = false, defaultValue = "false") Boolean enableCheck,
			@RequestParam(value = "hasSelected", required = false, defaultValue = "") String hasSelected,
			Model model) {
		model.addAttribute("enableCheck", enableCheck);// 是否允许多选
		model.addAttribute("hasSelected", hasSelected);// 默认选中的

		return "column/columnTree";
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
	public Map<String, Object> addColumn(HttpServletRequest request,
			ColumnWithBLOBs column) {

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
	 * @param column
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateColumn")
	public Map<String, Object> updateColumn(HttpServletRequest request,
			ColumnWithBLOBs column) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = this.columnService.updateColumn(column);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}

	/**
	 * 
	 * @Description: 更新配置
	 * @param request
	 * @param column
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateColumnConfig")
	public Map<String, Object> updateColumnConfig(HttpServletRequest request,
			ColumnWithBLOBs column) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = this.columnService.updateColumnConfig(column);
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
	@RequestMapping("/deleteColumn")
	public Map<String, Object> deleteColumn(HttpServletRequest request,
			Model model) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String ids = request.getParameter("ids") == null ? "" : request
					.getParameter("ids");
			boolean flag = this.columnService.deleteColumn(ids);
			if (flag) {
				map.put(RESULT_MESSAGE_STRING, "删除成功！");
			} else {
				map.put(RESULT_MESSAGE_STRING, "删除失败！");
			}

		} catch (Exception e) {
			// TODO: handle exception
			map.put(RESULT_MESSAGE_STRING, "删除失败！");
		}

		return map;
	}

	/**
	 * 
	 * @Description: 根据栏目ID查询子栏目
	 * @param request
	 * @param response
	 * @param column
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryChildColumnListById")
	public List<Column> queryChildColumnListById(HttpServletRequest request,
			HttpServletResponse response) {
		List<Column> columnList = new ArrayList<Column>();
		try {
			String id = request.getParameter("id") == null ? "" : request
					.getParameter("id");
			// 还是使用List，方便后期用到
			columnList = this.columnService.queryChildColumnListById(id);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return columnList;
	}
}
