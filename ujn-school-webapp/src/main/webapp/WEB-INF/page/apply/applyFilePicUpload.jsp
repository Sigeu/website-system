<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link href="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<title>信息公开申请</title>
<style type="text/css">
.but_hidden{position: absolute; visibility: hidden;}
</style>
</head>
<body class="pos-r">

	<div id="uploader" class="wu-example">
	    <!--用来存放文件信息-->
	    <div id="thelist" class="uploader-list"></div>
	    <div class="btns">
	        <div id="picker">选择文件</div>
	        <button id="ctlBtn" class="btn btn-default but_hidden">开始上传</button>
	    </div>
	</div>

<%@ include file="../../../common/footer-site.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/apply-upload.js"> </script>
<script type="text/javascript">
var contextPath = "${pageContext.request.contextPath}";
var totalPage = '';
function toClickUpload(){
	$('#ctlBtn').trigger("click");
}
</script>
</body>
</body>
</html>