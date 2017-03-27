<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../../common/header.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/zTreeStyle/zTreeStyle.css" type="text/css">
<title>用户授权页</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		系统管理 <span class="c-gray en">&gt;</span>用户授权
	</nav>
	<div id="win"></div>
	<div id="win2"></div>
	<div data-options="fit:true" style="height: 100%">
		<div class="zTreeDemoBackground left">
			<ul id="roleTree" class="ztree"></ul>
		</div>
	</div>
	<div>
		<form action="${pageContext.request.contextPath}/system/controller/roleController/addUserRole" method="post" class="form form-horizontal" id="form-userRole-add">
			<input type="hidden" name="login_name" id="login_name" value="${login_name }">
			<div class="col-xs-offset-4">
				<button id="submit_but" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</form>
	</div>
	<%@ include file="../../../../common/footer_tree.jsp"%>
	<!-- form提交 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
	<script type="text/javascript">
		//初始化
		var setting = {
			check: {
				enable: true,
				nocheckInherit: true
			},
			data: {
				simpleData: {
					enable: true
				}
			}
		};
		
		$(function(){
			$.ajax({
				 type: "post",
				 url: "${pageContext.request.contextPath}/system/controller/roleController/queryRoleTree",
	             data: {'login_name' : $('#login_name').val()},
	             dataType: "json",
	             success: function(data){
	            	 $.fn.zTree.init($("#roleTree"), setting, data);
	             },
	             error: function(XMLHttpRequest, textStatus, errorThrown) {
                    layer.alert(textStatus);
                },
			 });
			
			$('#submit_but').on('click',function(){
				var treeObj = $.fn.zTree.getZTreeObj("roleTree");
				var nodes = treeObj.getCheckedNodes(true);
				var node_ids = '';
			   	 $(nodes).each(function(index,element){
			   		node_ids += element.id + ",";
			   	 });
			   	var login_name = $('#login_name').val();
		        $('#form-userRole-add').ajaxSubmit({
		            type: 'post', // 提交方式 get/post
		            url: '${pageContext.request.contextPath}/system/controller/roleController/addUserRole', // 需要提交的 url
		            dataType : "json",
		            data: {
		                'login_name': login_name,
		                'role_ids': node_ids
		            },
		            success: function(data) { // data 保存提交后返回的数据，一般为 json 数据
		                // 此处可对 data 作相关处理
		            	layer.alert(data.result_message, {
							  closeBtn: 1
							}, function(){
								//父页面刷新
								window.location.reload();//刷新当前页面.
								var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
								parent.layer.close(index); //再执行关闭
							});
		            }
		           // $('#menu_from').resetForm(); // 提交后重置表单
		        });
		       // return false; // 阻止表单自动提交事件
			});
		});
	</script>
</body>
</html>