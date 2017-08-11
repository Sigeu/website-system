<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<title>查看原图</title>
</head>
<body class="pos-r">
	<div>
	<c:if test="${type == '1' }">
		<img 
			src="${apply.id_file }">
	</c:if>
	<c:if test="${type == '2' }">
		<img 
			src="${apply.credit_code_file }">
	</c:if>
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