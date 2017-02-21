/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.controller.column;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ujn.school.cn.model.column.Column;
import ujn.school.cn.model.column.ColumnWithBLOBs;
import ujn.school.cn.pub.util.MyTree;
import ujn.school.cn.pub.util.Node;
import ujn.school.cn.service.column.IColumnService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import framework.system.pub.base.MyBaseController;
import framework.system.pub.util.DataTablePageUtil;
import framework.system.pub.util.ZtreeNode;

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
		
		return "column/columnAdd";
	}
	
	
	@ResponseBody
	@RequestMapping("/queryColumnTree")
	public Map<String,String> queryColumnTree(HttpServletRequest request, HttpServletResponse response){
		Map<String,String> map = new HashMap<String,String>();
		try {
			Column columnParam = new Column();
			List<Column> columnList = columnService.queryColumnList(columnParam);
			List<Node> nodeList = new ArrayList<Node>();
			Node node = null;
			for (Column column : columnList) {
				node = new Node();
				node.setId(column.getId());  
				node.setName(column.getName());  
				node.setParentId(column.getBig_class());  
				node.setClass_type(column.getClass_type());
				nodeList.add(node);
			}
			
			MyTree tree = new MyTree(nodeList);  
	        //System.out.println(tree.buildTree()+ "\r\n</select>"); 
	        String selectHtml = tree.buildTree()+ "\r\n</select>";
	        map.put("selectHtml", selectHtml);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return map;
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
	public Map<String,String> queryColumnTreeList(HttpServletRequest request, HttpServletResponse response){
		Map<String,String> map = new HashMap<String,String>();
		try {
			Column columnParam = new Column();
			List<Column> columnList = columnService.queryColumnList(columnParam);
			
			LinkedList<Column> result = new LinkedList<Column>();
			LinkedList<Column> f = toSort(columnList, result, 0);
			for (int i = 0; i < f.size(); i++) {
				System.out.print(f.get(i).getId() + ",");
				System.out.print(f.get(i).getName() + ",");
				System.out.print(f.get(i).getBig_class() + ",");
				System.out.println(f.get(i).getNo_order());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return map;
	}
	
	/**
	 * 
	 * @param ztreeNodeList
	 * @return
	 */
	public ZtreeNode listToJson(List<ZtreeNode> ztreeNodeList){
		 // 根节点  
       ZtreeNode rootNode = null; 
       // 节点列表（散列表，用于临时存储节点对象）  
       HashMap<String,ZtreeNode> nodeMap = new HashMap<String,ZtreeNode>();  
       // 将结果集存入散列表（后面将借助散列表构造多叉树）  
       if(null != ztreeNodeList){
			for(ZtreeNode node : ztreeNodeList){
				//这里是ID
				nodeMap.put(node.getId(), node);
			}
		}
       // 构造无序的多叉树  
       Set<?> entrySet = nodeMap.entrySet();  
       for (Iterator<?> it = entrySet.iterator(); it.hasNext();) {  
           @SuppressWarnings("rawtypes")
			ZtreeNode node = (ZtreeNode) ((Map.Entry) it.next()).getValue();  
           if (null == node.getPid() || "0".equals(node.getPid()) || "".equals(node.getPid()) ) {  
           	rootNode = node;  
           } else {  
           	//这里是PID
               nodeMap.get(node.getPid()).addChild(node);  
           }  
       }  
		
       rootNode.sortChildren();  
		
		return rootNode;
	}
	
	
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
}
