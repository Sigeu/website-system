/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.pub.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 用了组装tree
 * @author lzh_me@126.com
 *
 */
public class MyTree {
	private StringBuffer html = new StringBuffer();  
    private List<Node> nodes;  
      
    public MyTree(List<Node> nodes){  
        this.nodes = nodes;  
    }  
      
    public String buildTree(){  
        html.append("<select class='select' id='big_class' name='big_class' >");  
        for (Node node : nodes) {  
            Integer id = node.getId();  
            if ( 0 == node.getParentId() ) {  
            	if(1 == node.getClass_type()){
            		html.append("\r\n<option value='" + id + "'>" + node.getName()+ "</option>"); 
            	}else if(2 == node.getClass_type()){
            		html.append("\r\n<option value='" + id + "'>&nbsp;&brvbar;&mdash; " + node.getName()+ "</option>"); 
            	}else if(3 == node.getClass_type()){
            		html.append("\r\n<option value='" + id + "'>&nbsp;&nbsp;&brvbar;&mdash; " + node.getName()+ "</option>"); 
            	}else if(4 == node.getClass_type()){
            		html.append("\r\n<option value='" + id + "'>&nbsp;&nbsp;&nbsp;&brvbar;&mdash; " + node.getName()+ "</option>"); 
            	}else{
            		html.append("\r\n<option value='" + id + "'>" + node.getName()+ "</option>"); 
            	}
                 
                build(node);  
            }  
        }  
        //html.append("\r\n</ul>");  
        return html.toString();  
    }  
      
    private void build(Node node){  
        List<Node> children = getChildren(node);  
        if (!children.isEmpty()) {  
            //html.append("\r\n<ul>");  
            for (Node child : children) {  
                Integer id = child.getId();  
                if(1 == child.getClass_type()){
            		html.append("\r\n<option value='" + id + "'>" + node.getName()+ "</option>"); 
            	}else if(2 == child.getClass_type()){
            		html.append("\r\n<option value='" + id + "'>&nbsp;&brvbar;&mdash; " + node.getName()+ "</option>"); 
            	}else if(3 == child.getClass_type()){
            		html.append("\r\n<option value='" + id + "'>&nbsp;&nbsp;&brvbar;&mdash; " + node.getName()+ "</option>"); 
            	}else if(4 == child.getClass_type()){
            		html.append("\r\n<option value='" + id + "'>&nbsp;&nbsp;&nbsp;&brvbar;&mdash; " + node.getName()+ "</option>"); 
            	}else{
            		html.append("\r\n<option value='" + id + "'>" + node.getName()+ "</option>"); 
            	}
                html.append("\r\n<option value='" + id + "'>" + child.getName()+ "</option>");  
                build(child);  
            }  
            //html.append("\r\n</ul>");  
        }   
    }  
      
    private List<Node> getChildren(Node node){  
        List<Node> children = new ArrayList<Node>();  
        Integer id = node.getId();  
        for (Node child : nodes) {  
            if (id.equals(child.getParentId())) {  
                children.add(child);  
            }  
        }  
        return children;  
    }  
}
