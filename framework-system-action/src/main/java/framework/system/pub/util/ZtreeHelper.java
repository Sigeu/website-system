/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.pub.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年2月4日 下午4:24:15 
 * @version V1.0   
 */
public class ZtreeHelper {
	public static void main(String[] args) {  
        // 读取层次数据结果集列表   
        List<HashMap<String,String>> dataList = VirtualDataGenerator.getVirtualResult();  
  
        // 节点列表（散列表，用于临时存储节点对象）  
        HashMap<String,ZtreeNode> nodeMap = new HashMap<String,ZtreeNode>();  
        // 根节点  
        ZtreeNode rootNode = null;  
        // 将结果集存入散列表（后面将借助散列表构造多叉树）  
        for (Iterator it = dataList.iterator(); it.hasNext();) {  
            Map dataRecord = (Map) it.next();  
            ZtreeNode node = new ZtreeNode();  
            node.setId((String) dataRecord.get("id"));  
            node.setName((String) dataRecord.get("text")); 
            node.setPid((String) dataRecord.get("parentId"));  
            nodeMap.put(node.getId(), node);  
        }  
        // 构造无序的多叉树  
        Set entrySet = nodeMap.entrySet();  
        for (Iterator it = entrySet.iterator(); it.hasNext();) {  
            ZtreeNode node = (ZtreeNode) ((Map.Entry) it.next()).getValue();  
            if (node.getPid() == null || "".equals(node.getPid())) {  
            	rootNode = node;  
            } else {  
                ((ZtreeNode) nodeMap.get(node.getPid())).addChild(node);  
            }  
        }  
        // 输出无序的树形菜单的JSON字符串  
        System.out.println(rootNode);  
        // 对多叉树进行横向排序  
        rootNode.sortChildren();  
        // 输出有序的树形菜单的JSON字符串  
        System.out.println(rootNode);  
  
		List<ZtreeNode> ztreeNodeList = VirtualDataGenerator.getZtreeNodeVirtualResult();
		listToJson(ztreeNodeList);
        // 程序输出结果如下:  
        //  
        // 无序的树形菜单（格式化后的结果，可使用JSON格式化工具查看，  
        // 例如 http://jsonviewer.stack.hu/ 在线查看器）:    
        //  {  
        //   id : '100000',   
        //   text : '廊坊银行总行',   
        //   children : [  
        //     {  
        //     id : '110000',   
        //     text : '廊坊分行',   
        //     children : [  
        //       {  
        //       id : '113000',   
        //       text : '廊坊银行开发区支行',   
        //       leaf : true  
        //       },  
        //       {  
        //       id : '111000',   
        //       text : '廊坊银行金光道支行',   
        //       leaf : true  
        //       },  
        //       {  
        //       id : '112000',   
        //       text : '廊坊银行解放道支行',   
        //       children : [  
        //         {  
        //         id : '112200',   
        //         text : '廊坊银行三大街支行',   
        //         leaf : true  
        //         },  
        //         {  
        //         id : '112100',   
        //         text : '廊坊银行广阳道支行',   
        //         leaf : true  
        //         }  
        //       ]  
        //       }  
        //     ]  
        //     }  
        //   ]  
        //  }  
  
        // 有序的树形菜单（格式化后的结果）：  
        //  {  
        //   id : '100000',   
        //   text : '廊坊银行总行',   
        //   children : [  
        //     {  
        //     id : '110000',   
        //     text : '廊坊分行',   
        //     children : [  
        //       {  
        //       id : '111000',   
        //       text : '廊坊银行金光道支行',   
        //       leaf : true  
        //       },  
        //       {  
        //       id : '112000',   
        //       text : '廊坊银行解放道支行',   
        //       children : [  
        //         {  
        //         id : '112100',   
        //         text : '廊坊银行广阳道支行',   
        //         leaf : true  
        //         },  
        //         {  
        //         id : '112200',   
        //         text : '廊坊银行三大街支行',   
        //         leaf : true  
        //         }  
        //       ]  
        //       },  
        //       {  
        //       id : '113000',   
        //       text : '廊坊银行开发区支行',   
        //       leaf : true  
        //       }  
        //     ]  
        //     }  
        //   ]  
        //  }    
  
    }  
	
	
	public static String listToJson(List<ZtreeNode> ztreeNodeList){
		String jsonString = "";
		 // 根节点  
        ZtreeNode rootNode = null; 
        // 节点列表（散列表，用于临时存储节点对象）  
        HashMap<String,ZtreeNode> nodeMap = new HashMap<String,ZtreeNode>();  
     // 将结果集存入散列表（后面将借助散列表构造多叉树）  
        for (Iterator<ZtreeNode> it = ztreeNodeList.iterator(); it.hasNext();) {  
        	ZtreeNode dataRecord = it.next();  
            nodeMap.put(dataRecord.getId(), dataRecord);  
        }  
        // 构造无序的多叉树  
        Set entrySet = nodeMap.entrySet();  
        for (Iterator it = entrySet.iterator(); it.hasNext();) {  
            ZtreeNode node = (ZtreeNode) ((Map.Entry) it.next()).getValue();  
            if (node.getPid() == null || "".equals(node.getPid())) {  
            	rootNode = node;  
            } else {  
                ((ZtreeNode) nodeMap.get(node.getPid())).addChild(node);  
            }  
        }  
        
        
		/*if(null != ztreeNodeList){
			for(ZtreeNode node : ztreeNodeList){
				if (node.getPid() == null || "".equals(node.getPid())) {  
	            	rootNode = node;  
	            } else {  
	            	node.addChild(node);  
	            }  
			}
		}*/
        // 输出无序的树形菜单的JSON字符串  
        System.out.println(rootNode);  
        // 对多叉树进行横向排序  
        rootNode.sortChildren();  
        // 输出有序的树形菜单的JSON字符串  
        System.out.println(rootNode); 
        
		
		return jsonString;
	}
}
