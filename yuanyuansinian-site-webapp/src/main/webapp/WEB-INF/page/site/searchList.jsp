<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/keleyidivpager.css">
<title>搜索结果-列表页</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

	<%@ include file="page-pic.jsp"%>
	
	<div class="container con-tab all-bg">		
	<div class="info-list">
		<div class="pro-header">
			<h4 class="pro-title pull-left">站内搜索：关键字"<mark>${search_text }</mark><span class="hidden-xs">"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共找到信息<mark>${totalRecords }</mark>条</span></h4>
		</div>
		<div class="clearfix"></div>
		<div class="arclist info-list-body">
			
			<div class="search-list-con">
				<c:forEach items="${contentList}" var="content"> 
					<div class="search-pro">
						<a href="###" onclick="toShowNoticeDetail('${content.id }')"><h5>${content.title }</h5></a>
						<p class="search-date">${fn:substring(content.add_time, 0, 10)}</p>
						<p>${content.description }</p>
					</div>
				</c:forEach>
				
			</div>
		</div>
		<div class="page">
			<ul class="pagination">
				<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				<li><a href="#">1</a></li>
				<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
			</ul>
		</div>
	</div>
</div>


	<%@ include file="siteFooter.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/login.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/notice.js"></script>
			<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/article.js"></script>
	<script type="text/javascript">
		var activeFlag = '公墓陵园';
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
