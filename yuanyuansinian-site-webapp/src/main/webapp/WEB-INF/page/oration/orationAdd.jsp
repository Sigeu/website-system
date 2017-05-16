<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<link href="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<title>发布文章</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 网站产品管理 <span class="c-gray en">&gt;</span>新增文章
		</nav>
	<div class="page-container">
	<form action="${pageContext.request.contextPath}/sinian/oration/orationController/addOration" method="post" class="form form-horizontal" id="form_">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>纪念馆：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" id="hall" name="hall">
					<option value="0">--请选择--</option>  
                    <c:forEach items="${listHallNew}" var="hall">  
                    	<option value="${hall.id}">${hall.title}</option>  
                    </c:forEach>  
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>文章名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="文章名称" id="title" name="title">
			</div>
		</div>
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>关键词：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="关键词" id="keywords" name="keywords">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>标签：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="标签" id="tags" name="tags">
			</div>
		</div> -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">文章内容：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<script id="editor" name="content" type="text/plain" style="width:100%;height:400px;"></script> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">排序值：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="0" placeholder="排序值，越小越靠前" id="no_order" name="no_order">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">是否公开</label>
			<div class="checkbox col-sm-8 col-md-9">
				<label><input type="radio" name="open_type" value="1" checked="checked"> 公开</label> <label><input
					type="radio" name="open_type" value="0"> 不公开</label>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">文章封面：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div id="uploader-demo">
				    <!--用来存放item-->
				    <div id="fileList" class="uploader-list"></div>
				    <div id="filePicker">选择图片</div>
				    <button id="ctlBtn" style="display:none" class="btn btn-default">开始上传</button>
				</div>
			</div>
		</div>
		</br>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="submit_but" class="btn btn-secondary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button id="close_but" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="../../../common/footer_form.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/common-upload.js"> </script>
<script type="text/javascript">
var contextPath = '${pageContext.request.contextPath}';
var serverUrl = '/sinian/oration/orationController/uploadImg';
$(function(){
	//UE编辑器
	var ue = UE.getEditor('editor');

	$('#close_but').on('click', function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
		return false;
	});
	
});


//表单提交，可上传文件
$(function() {
	//表单验证
	$("#form_").validate({
		rules:{
			title:{
				required:true,
				maxlength:100
			},
			hall:{
				required:true
			},
			content:{
				required:true
			},
			open_type:{
				required:true
			},
			no_order:{
				digits:true
			}
		},
		onkeyup:false,
		focusCleanup:false,
		success:"valid",
		submitHandler:function(form){
			var imgList = $('#fileList').children('div');
			if (imgList.length > 0) {
				$('#ctlBtn').trigger("click");
				// not empty
			} else {
				//  is empty
				var options = {
						success : function(data) {
							layer.alert(data.result_message, {
								  closeBtn: 1
								}, function(){
									//父页面刷新
									parent.window.location.reload();
									var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
									parent.layer.close(index); //再执行关闭
								});
						}
					};
					// 准备form表单
					$("#form_").ajaxForm(options);
					// 表单提交     
					$("#form_").ajaxSubmit(options);
			}  
			return false;
		}
	});
	
});
</script>
</body>
</body>
</html>