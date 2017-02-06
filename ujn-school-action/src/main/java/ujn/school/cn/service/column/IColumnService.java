/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.service.column;

import java.util.List;

import ujn.school.cn.model.column.Column;
import ujn.school.cn.model.column.ColumnWithBLOBs;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:49:54 
 * @version V1.0   
 */
public interface IColumnService {
	
	/**
	 * 
	 * @Description: 根据ID查询 
	 * @param columnId
	 * @return
	 */
	Column queryColumnById(int columnId);
	
	/**
	 * 
	 * @Description: 用户分页查询 
	 * @param column
	 * @return
	 */
	List<Column> queryColumnList(Column column);
	
	/**
	 * 
	 * @Description: 用户保存 
	 * @param column
	 */
	int saveColumn(ColumnWithBLOBs column);

	int addColumn(ColumnWithBLOBs column);

}
