/**
 * Copyright (C), 2013, 山东安之畅智能交通科技有限公司
 * All right reserved.
 */
package ujn.school.cn.pub.util;

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
	private String pId;
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
		this.pId = pId;
		this.name = name;
		this.open = open;
		this.nocheck = nocheck;
		this.checked = checked;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
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
}
