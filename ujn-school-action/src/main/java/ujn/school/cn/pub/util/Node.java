package ujn.school.cn.pub.util;

/**
 * 用来组装数据
 * 
 * @author lzh_me@126.com
 *
 */
public class Node {
	private int id;
	private int parentId;
	private String name;
	private int class_type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClass_type() {
		return class_type;
	}

	public void setClass_type(int class_type) {
		this.class_type = class_type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
}
