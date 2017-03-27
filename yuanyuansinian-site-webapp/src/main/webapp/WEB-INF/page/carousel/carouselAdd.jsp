<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<link href="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<title>轮播图片添加</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>新增轮播图片
		</nav>
	<div class="page-container">
	<form action="${pageContext.request.contextPath}/sinian/carousel/carouselController/addCarousel" method="post" class="form form-horizontal" id="form-carousel-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>标题：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="标题" id="title" name="title">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">URL：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="URL" id="img_url" name="img_url">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">排序值：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="0" placeholder="排序值，越小越靠前" id="no_order" name="no_order">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">缩略图：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div id="uploader-demo">
				    <!--用来存放item-->
				    <div id="fileList" class="uploader-list"></div>
				    <div id="filePicker">选择图片</div>
				    <button id="ctlBtn" style="display:none" class="btn btn-default">开始上传</button>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">描述：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="description" cols="" rows="" class="textarea"  placeholder="描述说明" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="$.Huitextarealength(this,200)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">备注说明：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="remark" cols="" rows="" class="textarea"  placeholder="描述说明" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="$.Huitextarealength(this,200)"></textarea>
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
<%@ include file="../../../common/footer_form.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/carousel-upload.js"> </script>
<script type="text/javascript">
	// 项目路径
	var contextPath = '${pageContext.request.contextPath}';
	//数据ID
	var model_id = '';
</script>
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
	$("#form-carousel-add").ajaxForm(options);
	// 表单提交     
	$('#submit_but').on('click', function() {
		$("#form-carousel-add").ajaxSubmit(options);
		return false;
	});
	
});
</script>
</body>
</body>
</html>