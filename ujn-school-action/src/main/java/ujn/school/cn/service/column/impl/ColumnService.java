/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.service.column.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ujn.school.cn.dao.column.ColumnMapper;
import ujn.school.cn.model.column.Column;
import ujn.school.cn.model.column.ColumnWithBLOBs;
import ujn.school.cn.service.column.IColumnService;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("columnService") 
public class ColumnService implements IColumnService {
	@Resource
	private ColumnMapper columnMapper;
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryColumnById</p> 
	 * <p>Description: </p> 
	 * @param columnId
	 * @return 
	 * @see ujn.school.cn.service.column.IColumnService#queryColumnById(int)
	 */
	@Override
	public Column queryColumnById(int columnId) {

        return columnMapper.selectByPrimaryKey(columnId);
	}

	/*
	 * (non-Javadoc)
	 * <p>Title: queryColumnList</p> 
	 * <p>Description: </p> 
	 * @param column
	 * @return 
	 * @see ujn.school.cn.service.column.IColumnService#queryColumnList(ujn.school.cn.model.column.Column)
	 */
	@Override
	public List<Column> queryColumnList(Column column) {
		// TODO Auto-generated method stub
		return columnMapper.queryColumnList(column);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: saveColumn</p> 
	 * <p>Description: </p> 
	 * @param column
	 * @return 
	 * @see ujn.school.cn.service.column.IColumnService#saveColumn(ujn.school.cn.model.column.ColumnWithBLOBs)
	 */
	@Override
	public int updateColumn(ColumnWithBLOBs column) {
		// TODO Auto-generated method stub
		return columnMapper.updateByPrimaryKeyWithBLOBs(column);
	}

	/*
	 * (non-Javadoc)
	 * <p>Title: addColumn</p> 
	 * <p>Description: </p> 
	 * @param column
	 * @return 
	 * @see ujn.school.cn.service.column.IColumnService#addColumn(ujn.school.cn.model.column.ColumnWithBLOBs)
	 */
	@Override
	public int addColumn(ColumnWithBLOBs column) {
		// TODO Auto-generated method stub
		return columnMapper.insert(column);
	}

}
