<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<link
	href="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.css"
	rel="stylesheet" type="text/css" />
<title>纪念馆新建</title>
</head>
<body class="pos-r">
	
		<div class="formControls col-xs-8 col-sm-9">
			<div id="uploader-demo">
				<!--用来存放item-->
				<div id="fileList" class="uploader-list"></div>
				<div id="filePicker">选择图片</div>
				<button id="head_but1" style="display: none"
					class="btn btn-default">开始上传</button>
			</div>
		</div>
	<%@ include file="../../../common/footer_form.jsp"%>				
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/hallDouble-uploadHead1.js">
	</script>
	<script type="text/javascript">
		var serverUrl = '/sinian/hallDouble/hallDoubleController/uploadHead1';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
		//数据ID
		var model_id = '';
		//上传图片
		function toClickUpload(id){
			model_id = id;
			$('#head_but1').trigger("click");
		}
	</script>
</body>
</body>
</html>