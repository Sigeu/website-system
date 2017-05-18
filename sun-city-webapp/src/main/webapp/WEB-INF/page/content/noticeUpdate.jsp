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
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>所属栏目：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" id="column_id" name="column_id">
					<option value="0">--请选择--</option>  
                    <c:forEach items="${columnSelectList}" var="column">  
                    	<option value="${column.id}">${column.name}</option>  
                    </c:forEach>  
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>标题：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${content.title}" placeholder="标题" id="title" name="title">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">详细内容：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<script id="editor" name="content" type="text/plain" style="width:100%;height:400px;"></script> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">描述说明：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="description" cols="" rows="" class="textarea"  placeholder="描述说明" datatype="*10-100" dragonfly="true" onKeyUp="$.Huitextarealength(this,200)">${content.description}</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">排序值：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${content.no_order}" placeholder="排序值，越小越靠前" id="no_order" name="no_order">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">封面图片：</label>
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
			<label class="form-label col-xs-4 col-sm-2">外部链接：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${content.links}" placeholder="链接到网站外部的网址" id="links" name="links">
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