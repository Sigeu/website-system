<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<title>纪念馆-内容页</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>
	
	<div class="container incense">
		<div class="incense-body">
			<img src="${pageContext.request.contextPath}/static/images/incense-double.jpg" class="img-responsive incense-bg incense-double hidden-xs" alt="incense">
			<img src="${pageContext.request.contextPath}/static/images/ex.jpg" class="img-responsive incense-double-img pull-left" alt="incense">
			<img src="${pageContext.request.contextPath}/static/images/ex.jpg" class="img-responsive incense-double-img incense-double-imgsec pull-right" alt="incense">
			<div class="incense-btn">
				<button class="btn btn-danger">上香</button>
				<button class="btn btn-danger">贡品</button>
				<button class="btn btn-danger">献花</button>
				<button class="btn btn-danger">点歌</button>
			</div>
		</div>
	</div>


	<%@ include file="siteFooter.jsp"%>

	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/hallDetail.js"></script>
	<script type="text/javascript">
		var activeFlag = '纪念馆灵堂';
		//-------分页数据----------
		var id = '${column_id }';
		var totalPage = '${totalPage }';
		var totalRecords = '${totalRecords }';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
		//-------分页数据----------
	</script>
</body>
</html>
