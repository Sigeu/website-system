<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<link href="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<title>内容信息表页</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>更新内容
		</nav>
	<div class="page-container">
	<form action="${pageContext.request.contextPath}/sinian/content/contentController/updateContent" method="post" class="form form-horizontal" id="form_">
		<input type="hidden" name="id" id="id_" value="${content.id}">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">添加时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${content.add_time}" placeholder="添加时间" id="add_time" name="add_time" class="input-text Wdate">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">更新时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${content.update_time}" placeholder="更新时间" id="update_time" name="update_time" class="input-text Wdate">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">点击数：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${content.hits}" placeholder="点击数" id="hits" name="hits">
			</div>
		</div>
		<%-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">作者：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${content.title}" placeholder="作者" id="issue" name="issue">
			</div>
		</div> --%>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/content-upload.js"> </script>
<script type="text/javascript">
//项目路径
var contextPath = '${pageContext.request.contextPath}';
$(function(){
	//UE编辑器
	var ue = UE.getEditor('editor');
	
	$('#close_but').on('click', function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
		return false;
	});
	//赋值
	$('#column_id').val('${content.column_id}');
	ue.ready(function() {//编辑器初始化完成再赋值  
    	ue.setContent('${content.content}');  //赋值给UEditor  
    });  
});


//表单提交，可上传文件
$(function() {
	//表单验证
	$("#form_").validate({
		debug:true,
		onkeyup:false,
		focusCleanup:false,
		success:"valid",
		submitHandler:function(form){
			$('#ctlBtn').trigger("click");
			return false;
		},
		rules:{
			title:{
				required:true,
				maxlength:100
			},
			no_order:{
				digits:true
			},
			links:{
				url:true
			}
		}
	});
});
</script>
</body>
</body>
</html>