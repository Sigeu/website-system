<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<title>查看图片</title>
</head>
<body class="pos-r">
	<div>
		<img 
			src="${pageContext.request.contextPath}/sinian/carousel/carouselController/queryImgById?id=${id }">
	</div>
<%@ include file="../../../common/footer_form.jsp"%>
<script type="text/javascript">
//表单提交，可上传文件
$(function() {
	//返回
	/* $('#close_but').on('click', function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
		return false;
	}); */
	
});
</script>
</body>
</body>
</html>