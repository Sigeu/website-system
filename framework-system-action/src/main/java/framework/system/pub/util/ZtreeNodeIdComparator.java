/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.pub.util;

import java.util.Comparator;

/**   
 * @Description: ID排序 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年2月4日 下午4:27:53 
 * @version V1.0   
 */
public class ZtreeNodeIdComparator implements Comparator<Object> {
	// 按照节点编号比较  
    public int compare(Object o1, Object o2) {  
        int j1 = Integer.parseInt(((ZtreeNode) o1).getId());  
        int j2 = Integer.parseInt(((ZtreeNode) o2).getId());  
        return (j1 < j2 ? -1 : (j1 == j2 ? 0 : 1));  
    }  
}
