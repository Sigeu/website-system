<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<title>内容详情</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

	<%@ include file="page-pic.jsp"%>

	<div class="article">
		<div class="container">
			<div class="row">
				<%-- <p class="breadcrumb">
					<a href="###">首页</a>><a href="###">${content.column_name }></a> ${content.title }
				</p> --%>
				<div class="article-main">
					<div class="article-top text-center">
						<h1>${content.title }</h1>
						<div class="article-info">
							<fmt:parseDate value="${content.add_time}" pattern="yyyy-MM-dd" var="add_time"/>
							<span><fmt:formatDate value="${add_time}" pattern="yyyy年MM月dd日" /></span>
							<span>作者：${content.issue }</span>
						</div>
					</div>
					<div class="article-body">
						<p>${content.content }</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="siteFooter.jsp"%>

	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript">
		var activeFlag = '文章内容页';
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
