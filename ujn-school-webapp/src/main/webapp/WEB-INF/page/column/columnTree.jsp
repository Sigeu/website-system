<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static//hui/admin3.0/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" />
</head>
<body>
<div>
<ul id="tree_object" class="ztree">
</ul>
</div>
<%@ include file="../../../common/footer_form.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript">
var tree_object;
//设置默认选择节点
function selectCheckNode() {
	var ids = "${hasSelected}".split(",");
	for (var i = 0; i < ids.length; i++) {
		//注意：ID必须转化为数字才能正确匹配
		var node = tree_object.getNodeByParam("id", Number(ids[i]),null);
		if ("${enableCheck}" == "true") {
			try {
				tree_object.checkNode(node, true, true);
			} catch (e) {}
			tree_object.selectNode(node, false);
		} else {
			tree_object.selectNode(node, true);
		}
	}
};
//获取选中的值
function getSelected(){
	if ("${enableCheck}" == "true"){
		nodes = tree_object.getCheckedNodes(true);
	}else{
		nodes = tree_object.getSelectedNodes();
	}
	var columnArray = new Array();
	$.each(nodes,function(index,node){
		var column = new Object;
		column.id = node.id;
		column.name = node.name;
		column.class_type = node.class_type;
		columnArray.push(column);
	});
	return columnArray;
};
$(function () {
	var setting = {
			view: {
				dblClickExpand: false,
				showLine: true,
				selectedMulti: false
			},
			data: {
				simpleData: {
					enable: true,
					idKey: "id",
					pIdKey: "big_class",
					rootPId: "0"
				},
				key : {
					name : "name"
				}
			},
		callback: {
			//点击节点展开
			onClick: function (event, treeId, treeNode) {
				tree_object.expandNode(treeNode);
			},
			onCheck: function (e, treeId, treeNode) {
				var nodes = tree_object.getCheckedNodes(true);
				for (var i = 0, l = nodes.length; i < l; i++) {
					tree_object.expandNode(nodes[i], true, false, false);
				}
				return false;
			}
		}
	};
	$.ajax({
		type: "post",
		url: '${pageContext.request.contextPath}/column/controller/columnController/listColumn',
		data: {},
		dataType: "json",
		success: function (zNodes) {
			//console.log(zNodes);
			//初始化树
			tree_object =  $.fn.zTree.init($("#tree_object"), setting, zNodes);
			// 默认展开一级节点
			var nodes = tree_object.getNodesByParam("level", 0);
			for (var i = 0; i < nodes.length; i++) {
				tree_object.expandNode(nodes[i], true, false, false);
			}
			//选择已经选中的
			selectCheckNode();
		},
		error: function (XMLHttpRequest, textStatus, errorThrown) {},
	});
});
</script>
</body>
</html>