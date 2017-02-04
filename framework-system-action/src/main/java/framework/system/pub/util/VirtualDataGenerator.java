/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.pub.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年2月4日 下午4:29:02 
 * @version V1.0   
 */
public class VirtualDataGenerator {
	// 构造无序的结果集列表，实际应用中，该数据应该从数据库中查询获得；  
    public static List getVirtualResult() {  
        List dataList = new ArrayList();  
  
        HashMap dataRecord1 = new HashMap();  
        dataRecord1.put("id", "112000");  
        dataRecord1.put("text", "廊坊银行解放道支行");  
        dataRecord1.put("parentId", "110000");  
  
        HashMap dataRecord2 = new HashMap();  
        dataRecord2.put("id", "112200");  
        dataRecord2.put("text", "廊坊银行三大街支行");  
        dataRecord2.put("parentId", "112000");  
  
        HashMap dataRecord3 = new HashMap();  
        dataRecord3.put("id", "112100");  
        dataRecord3.put("text", "廊坊银行广阳道支行");  
        dataRecord3.put("parentId", "112000");  
  
        HashMap dataRecord4 = new HashMap();  
        dataRecord4.put("id", "113000");  
        dataRecord4.put("text", "廊坊银行开发区支行");  
        dataRecord4.put("parentId", "110000");  
  
        HashMap dataRecord5 = new HashMap();  
        dataRecord5.put("id", "100000");  
        dataRecord5.put("text", "廊坊银行总行");  
        dataRecord5.put("parentId", "");  
  
        HashMap dataRecord6 = new HashMap();  
        dataRecord6.put("id", "110000");  
        dataRecord6.put("text", "廊坊分行");  
        dataRecord6.put("parentId", "100000");  
  
        HashMap dataRecord7 = new HashMap();  
        dataRecord7.put("id", "111000");  
        dataRecord7.put("text", "廊坊银行金光道支行");  
        dataRecord7.put("parentId", "110000");  
  
        dataList.add(dataRecord1);  
        dataList.add(dataRecord2);  
        dataList.add(dataRecord3);  
        dataList.add(dataRecord4);  
        dataList.add(dataRecord5);  
        dataList.add(dataRecord6);  
        dataList.add(dataRecord7);  
  
        return dataList;  
    }  
    
    
    
    public static List<ZtreeNode> getZtreeNodeVirtualResult() {  
        List<ZtreeNode> dataList = new ArrayList<ZtreeNode>();  
  
        ZtreeNode ztreeNode1 = new ZtreeNode();
        ztreeNode1.setId("370000");
        ztreeNode1.setName("山东省");
        ztreeNode1.setPid("0");
        
        ZtreeNode ztreeNode2 = new ZtreeNode();
        ztreeNode2.setId("370100");
        ztreeNode2.setName("济南");
        ztreeNode2.setPid("370000");
        
        
        ZtreeNode ztreeNode3 = new ZtreeNode();
        ztreeNode3.setId("370200");
        ztreeNode3.setName("青岛");
        ztreeNode3.setPid("370000");
        
        
        ZtreeNode ztreeNode4 = new ZtreeNode();
        ztreeNode4.setId("370101");
        ztreeNode4.setName("历下区");
        ztreeNode4.setPid("370100");
        
        
        ZtreeNode ztreeNode5 = new ZtreeNode();
        ztreeNode5.setId("370102");
        ztreeNode5.setName("市中区");
        ztreeNode5.setPid("370100");
        
        
        ZtreeNode ztreeNode6 = new ZtreeNode();
        ztreeNode6.setId("370201");
        ztreeNode6.setName("市辖区");
        ztreeNode6.setPid("370200");
        
        
        ZtreeNode ztreeNode7 = new ZtreeNode();
        ztreeNode7.setId("370202");
        ztreeNode7.setName("李沧区");
        ztreeNode7.setPid("370201");
  
        
        ZtreeNode ztreeNode8 = new ZtreeNode();
        ztreeNode8.setId("37010101");
        ztreeNode8.setName("历下区A街道办");
        ztreeNode8.setPid("370101");
  
        dataList.add(ztreeNode3);  
        dataList.add(ztreeNode4);  
        dataList.add(ztreeNode5);  
        dataList.add(ztreeNode6);
        dataList.add(ztreeNode1);  
        dataList.add(ztreeNode2);  
        dataList.add(ztreeNode7);
        dataList.add(ztreeNode8); 
  
        return dataList;  
    }  
}
