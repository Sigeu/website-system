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
	
	@Override
	public Column queryColumnById(int columnId) {
		//加载xml文件
        //ApplicationContext  ac = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
        //columnMapper = (ColumnMapper) ac.getBean("columnMapper");

        return columnMapper.selectByPrimaryKey(columnId);
	}


	@Override
	public List<Column> queryColumnList(Column column) {
		// TODO Auto-generated method stub
		return columnMapper.queryColumnList(column);
	}

	@Override
	public int saveColumn(ColumnWithBLOBs column) {
		// TODO Auto-generated method stub
		return columnMapper.insertSelective(column);
	}


	@Override
	public int addColumn(ColumnWithBLOBs column) {
		// TODO Auto-generated method stub
		return columnMapper.insert(column);
	}

}
