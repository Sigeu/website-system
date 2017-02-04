/**
 * Copyright (C), 2013, 山东安之畅智能交通科技有限公司
 * All right reserved.
 */
package framework.system.pub.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @Description: ztree node 
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月3日 下午3:02:01
 * @version V1.0
 */
public class ZtreeNode {

	//id
	private String id;
	//父类id
	private String pid;
	//名称
	private String name;
	// 是否默认打开
	private boolean open; 
	// 是否可以选
	private boolean nocheck; 
	// 是否默认选上
	private boolean checked; 

	public ZtreeNode() {
		super();
	}

	public ZtreeNode(String id, String pId, String name, boolean open,
			boolean nocheck, boolean checked) {
		super();
		this.id = id;
		this.pid = pId;
		this.name = name;
		this.open = open;
		this.nocheck = nocheck;
		this.checked = checked;
	}

	/** 
     * 孩子节点列表 
     */  
    private List<ZtreeNode> children = new ArrayList<ZtreeNode>();  
  
    // 添加孩子节点  
    public void addChild(ZtreeNode node) {  
        children.add(node);  
    }  
  
    // 先序遍历，拼接JSON字符串  
    public String toString() {  
        String result = "{" + "id : '" + id + "'" + ", text : '" + name + "'";  
        if (children.size() != 0) {  
            result += ", children : [";  
            for (Iterator<ZtreeNode> it = children.iterator(); it.hasNext();) {  
                result += it.next().toString() + ",";  
            }  
            result = result.substring(0, result.length() - 1);  
            result += "]";  
        } else {  
            result += ", leaf : true";  
        }  
        return result + "}";  
    }  
  
    // 兄弟节点横向排序  
	public void sortChildren() {  
        if (children.size() != 0) {  
            // 对本层节点进行排序（可根据不同的排序属性，传入不同的比较器，这里传入ID比较器）  
            Collections.sort(children, new ZtreeNodeIdComparator());  
            // 对每个节点的下一层节点进行排序  
            for (Iterator<ZtreeNode> it = children.iterator(); it.hasNext();) {  
                it.next().sortChildren();  
            }  
        }  
    }  
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isNocheck() {
		return nocheck;
	}

	public void setNocheck(boolean nocheck) {
		this.nocheck = nocheck;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
}
