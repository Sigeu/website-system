<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<title>友情链接修改</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>更新友情链接
		</nav>
	<div class="page-container">
	<form action="${pageContext.request.contextPath}/sinian/link/linkController/updateLink" method="post" class="form form-horizontal" id="form-link-update">
		<input type="hidden" name="id" id="id" value="${link.id }" >
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>网站名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${link.web_name }" placeholder="网站名称" id="web_name" name="web_name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">网站URL：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${link.web_url }" placeholder="网站URL" id="web_url" name="web_url">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">联系方式：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${link.contact }" placeholder="联系方式" id="contact" name="contact">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">描述说明：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="info" cols="" rows="" class="textarea"  placeholder="描述说明" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="$.Huitextarealength(this,200)">${link.info }</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">排序值：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${link.order_no }" placeholder="排序值，越小越靠前" id="order_no" name="order_no">
			</div>
		</div>
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">缩略图：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="btn-upload form-group">
				  <input class="input-text upload-url radius" type="text" name="uploadfile-1" id="uploadfile-1" readonly>&nbsp;<a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 浏览文件</a>
				  <input type="file" multiple name="file-1" class="input-file">
				</span>
			</div>
		</div> -->
		</br>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="submit_but" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="../../../common/footer_form.jsp"%>
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
	$("#form-link-update").ajaxForm(options);
	// 表单提交     
	$('#submit_but').on('click', function() {
		$("#form-link-update").ajaxSubmit(options);
		return false;
	});
	
});
</script>
</body>
</body>
</html>