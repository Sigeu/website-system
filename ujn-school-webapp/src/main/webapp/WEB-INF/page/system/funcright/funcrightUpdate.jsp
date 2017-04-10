<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../../common/header.jsp"%>
<title>菜单表页</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>菜单修改
		</nav>
	<div class="page-container">
	<form action="${pageContext.request.contextPath}/system/controller/funcrightController/updateFuncright" method="post" class="form form-horizontal" id="form-funcright-update">
		<input type="hidden" name="id" id="id" value="${funcright.id }" >
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>菜单code：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${funcright.funcright_code }" placeholder="菜单code" id="funcright_code" name="funcright_code">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>菜单名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${funcright.funcright_name }" placeholder="菜单名称" id="funcright_name" name="funcright_name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>菜单url：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${funcright.url }" placeholder="菜单url" id="url" name="url">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>排序：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${funcright.show_order }" placeholder="排序号，越小越靠前" id="show_order" name="show_order">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">描述说明：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="remark" cols="" rows="" class="textarea"  placeholder="描述说明" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="$.Huitextarealength(this,200)">${funcright.remark }</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		</br>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="submit_but" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button id="close_but"  class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
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
			  closeBtn: 1
			}, function(){
				//父页面刷新
				parent.reloadPage();
				var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
				parent.layer.close(index); //再执行关闭
			});
		}
	};
	// 准备form表单
	$("#form-funcright-update").ajaxForm(options);
	// 表单提交     
	$('#submit_but').on('click', function() {
		$("#form-funcright-update").ajaxSubmit(options);
		return false;
	});
	
});
</script>
</body>
</body>
</html>