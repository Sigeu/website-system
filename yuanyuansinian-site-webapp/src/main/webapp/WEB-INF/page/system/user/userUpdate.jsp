<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../../common/header.jsp"%>
<title>用户信息表页</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>更新用户
		</nav>
	<div class="page-container">
	<form action="${pageContext.request.contextPath}/system/controller/userController/updateUser" method="post" class="form form-horizontal" id="form-user-add">
		<input type="hidden" name="id" id="id" value="${user.id}">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>登录名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${user.login_name}" placeholder="网站名称" id="login_name" name="login_name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">用户姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${user.real_name}" placeholder="用户姓名" id="real_name" name="real_name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">性别：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${user.sex}" placeholder="性别" id="sex" name="sex">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">部门：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${user.dept}" placeholder="部门" id="dept" name="dept">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">邮箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${user.email}" placeholder="邮箱" id="email" name="email">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">联系电话：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${user.contact_tel}" placeholder="联系电话" id="contact_tel" name="contact_tel">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">说明：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="remark" cols="" rows="" class="textarea"  placeholder="描述说明" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="$.Huitextarealength(this,200)">${user.remark}</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		</br>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="submit_but" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="../../../../common/footer_form.jsp"%>
<script type="text/javascript">
$(function(){
	//表单验证
	//$("#form_").Validform();

	$('#close_but').on('click', function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
		return false;
	});
	
});


//表单提交，可上传文件
$(function() {
	var options = {
		success : function(data) {
			layer.alert(data.result_message, {
			  closeBtn: 0
			}, function(){
				//父页面刷新
				parent.reloadPage();
				var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
				parent.layer.close(index); //再执行关闭
			});
		}
	};
	// 准备form表单
	$("#form-user-add").ajaxForm(options);
	// 表单提交     
	$('#submit_but').on('click', function() {
		$("#form-user-add").ajaxSubmit(options);
		return false;
	});
	
});
</script>
</body>
</body>
</html>