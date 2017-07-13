//关闭index
var index_

var utils = {
	getRootPath: function () {
		var pathName = window.location.pathname.substring(1);
		var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
		return window.location.protocol + '//' + window.location.host + '/' + webName + '/';
	},
	isBlank: function (obj) {
		return (!obj || $.trim(obj) === "");
	},
	isNotBlank: function (obj) {
		return !commons.isBlank(obj);
	},
	//获取文件名后缀
	getExtension: function (file_name) {
		var result = /\.[^\.]+/.exec(file_name);
		return result;
	},
	// 取得父链接参数
	getParameter: function (name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) {
			return unescape(r[2]);
		}
		return null;
	},
	//栏目选择
	treeSelectColumn: function (enableCheck, hasSelected, func) {
		index_ = top.layer.open({
				type: 2,
				title: '选择栏目',
				shadeClose: true,
				shade: false,
				maxmin: true, //开启最大化最小化按钮
				area: ['625px', '745px'],
				content: [contextPath + '/column/controller/columnController/columnTree?enableCheck=' + enableCheck + "&hasSelected=" + hasSelected, "no"],
				btn: ["确认", "关闭"],
				yes: function (index, layero) {
					var selectedData = layero.find("iframe")[0].contentWindow.getSelected();
					top.layer.close(index_);
					func(selectedData);
				}
			});
	},
	
	//选择部门,enableCheck:是否允许多选。func回调方法
	treeSelectDept: function (enableCheck, hasSelected, func) {
		index_ = top.layer.open({
				type: 2,
				title: '选择部门',
				shadeClose: true,
				shade: false,
				maxmin: true, //开启最大化最小化按钮
				area: ['625px', '745px'],
				content: [contextPath + 'sys/office/officeTree?enableCheck=' + enableCheck + "&hasSelected=" + hasSelected, "no"],
				btn: ["确认", "关闭"],
				yes: function (index, layero) {
					var selectedData = layero.find("iframe")[0].contentWindow.getSelected();
					top.layer.close(index_);
					func(selectedData);
				}
			});
	},
	//选择用户,enableCheck:是否允许多选。func回调方法
	treeSelectUser: function (enableCheck, hasSelected, func) {
		index_ = top.layer.open({
				type: 2,
				title: '选择用户',
				shadeClose: true,
				shade: false,
				maxmin: true, //开启最大化最小化按钮
				area: ['625px', '745px'],
				content: [contextPath + 'sys/user/userTreePage?enableCheck=' + enableCheck + "&hasSelected=" + hasSelected, "no"],
				btn: ["确认", "关闭"],
				yes: function (index, layero) {
					var tree = layero.find("iframe")[0].contentWindow.tree_object;
					var userArray = new Array();
					if (enableCheck) {
						nodes = tree.getCheckedNodes(true);
					} else {
						nodes = tree.getSelectedNodes();
					}
					for (var i = 0; i < nodes.length; i++) { //<c:if test="${checked && notAllowSelectParent}">
						if (nodes[i].isParent && enableCheck) {
							continue; // 如果为复选框选择，则过滤掉父节点
						}
						if (nodes[i].level == 0) {
							top.layer.msg("不能选择根部门（" + nodes[i].name + "）请重新选择。");
							return false;
						}
						if (nodes[i].isParent) {
							top.layer.msg("不能选择部门（" + nodes[i].name + "）请重新选择。");
							return false;
						}
						console.log(nodes[i]);
						var user = new Object;
						user.id = nodes[i].id;
						user.userName = nodes[i].name;
						user.userAccount = nodes[i].userAccount;
						userArray.push(user);
					}
					if(userArray.length > 0){
						top.layer.close(index_);
						func(userArray);
					}
				}
			});
	},
	//上级菜单选择
	treeSelectParentMenu: function (enableCheck, hasSelected, func) {
		index_ = top.layer.open({
				type: 2,
				title: '选择菜单',
				shadeClose: true,
				shade: false,
				maxmin: true, //开启最大化最小化按钮
				area: ['625px', '745px'],
				content: [contextPath + 'sys/menu/menuTree?enableCheck=' + enableCheck + "&hasSelected=" + hasSelected, "no"],
				btn: ["确认", "关闭"],
				yes: function (index, layero) {
					var selectedData = layero.find("iframe")[0].contentWindow.getSelected();
					top.layer.close(index_);
					func(selectedData);
				}
			});
	},
	//角色分配菜单
	treeSelectRoleMenu: function (enableCheck, hasSelected, func) {
		index_ = top.layer.open({
				type: 2,
				title: '分配菜单',
				shadeClose: true,
				shade: false,
				maxmin: true, //开启最大化最小化按钮
				area: ['625px', '745px'],
				content: [contextPath + 'sys/menu/menuRoleTree?enableCheck=' + enableCheck + "&hasSelected=" + hasSelected, "no"],
				btn: ["确认", "关闭"],
				yes: function (index, layero) {
					var selectedData = layero.find("iframe")[0].contentWindow.getSelected();
					top.layer.close(index_);
					func(selectedData);
				}
			});
	},
	//选择菜单图标,enableCheck:是否允许多选。func回调方法
	treeSelectIcon: function (func) {
		index_ = top.layer.open({
				type: 2,
				title: '选择图标',
				shadeClose: true,
				shade: false,
				maxmin: true, //开启最大化最小化按钮
				area: ['625px', '745px'],
				//允许出现滚动条
				content: [contextPath + 'sys/menu/menuIconList'],
				btn: ["确认", "关闭"],
				yes: function (index, layero) {
					var selectedData = layero.find("iframe")[0].contentWindow.getSelected();
					top.layer.close(index_);
					func(selectedData);
				}
			});
	},
	//选择角色,enableCheck:是否允许多选。func回调方法
	treeSelectRole: function (enableCheck, hasSelected, func) {
		index_ = top.layer.open({
				type: 2,
				title: '选择角色',
				shadeClose: true,
				shade: false,
				maxmin: true, //开启最大化最小化按钮
				area: ['625px', '745px'],
				content: [contextPath + 'sys/role/roleTreePage?enableCheck=' + enableCheck + "&hasSelected=" + hasSelected, "no"],
				btn: ["确认", "关闭"],
				yes: function (index, layero) {
					var tree = layero.find("iframe")[0].contentWindow.tree_object;
					var roleArray = new Array();
					if (enableCheck) {
						nodes = tree.getCheckedNodes(true);
					} else {
						nodes = tree.getSelectedNodes();
					}
					for (var i = 0; i < nodes.length; i++) { //<c:if test="${checked && notAllowSelectParent}">
						if (nodes[i].isParent && enableCheck) {
							continue; // 如果为复选框选择，则过滤掉父节点
						}
						//console.log(nodes[i]);
						var role = new Object;
						role.id = nodes[i].id;
						role.name = nodes[i].name;
						roleArray.push(role);
					}
					if(roleArray.length > 0){
						top.layer.close(index_);
						func(roleArray);
					}
				}
			});
	}
};
