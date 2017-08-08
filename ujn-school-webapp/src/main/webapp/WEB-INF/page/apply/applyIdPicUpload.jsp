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

	<div id="uploader-demo">
	    <!--用来存放item-->
	    <div id="fileList" class="uploader-list"></div>
	    <div id="filePicker">选择图片</div>
	    <button id="ctlBtn"  class="but_hidden">开始上传</button>
	</div>

<%@ include file="../../../common/footer-site.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/apply-idupload.js"> </script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
<script type="text/javascript">
var contextPath = "${pageContext.request.contextPath}";
var apply_id = '';
</script>
</body>
</body>
</html>