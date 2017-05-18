<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/keleyidivpager.css">
<title>用户文章内容页</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

	<%@ include file="page-pic.jsp"%>

	<%-- <div class="container con-tab">
		<%@ include file="recommend.jsp"%>
	</div> --%>
	<div class="container con-tab all-bg">
		<div class="row">
			<div class="col-sm-9">
				<div class="here">
					<ol class="breadcrumb">
						<li><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
						<li>用户文章</li>
						<li class="active">${oration.title }</li>
					</ol>
				</div>
				<div class="article">
					<div class="article-top">
						<h1>${oration.title }</h1>
						<div class="article-info">
							<span>${oration.create_date }</span><span>作者：会员123 </span>
						</div>
					</div>
					<div class="article-body">
						<p>${oration.content }</p>
					</div>
					<div class="article-near">
						<ul class="pager">
							<!-- <li class="previous disabled"><a href="#">上一篇：没有了</a></li>
							<li class="next"><a href="#">下一篇：记忆中的棉麻服饰搭配，你还记得吗？</a></li> -->
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="siteFooter.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript">
		var activeFlag = '首页';
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
