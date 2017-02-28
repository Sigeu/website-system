<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/keleyidivpager.css">
<title>内容列表</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-static-top navbar-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="###"> <img alt="logo"
				src="${pageContext.request.contextPath}/static/images/logo.png"
				class="img-responsive" />
			</a>
		</div>
		<div
			class="col-xs-12 col-sm-4 col-sm-offset-1 col-md-3 col-md-offset-3 navbar-search"
			style="padding: 0px">
			<div class="input-group">
				<input type="text" class="form-control"> <span
					class="input-group-btn">
					<button class="btn btn-default" type="button">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</span>
			</div>
		</div>
	</div>
	</nav>

	<nav class="navbar navbar-default navbar-static-top navbar-menu">
	<div class="container">
		<div class="row">
			<div class="navbar-dropdown hidden-xs hidden-sm">
				<div id="navbar-dropdown-top">
					<span class="">校务公开</span><span>党务公开</span>
				</div>
			</div>
			<div class="col-md-9 col-xs-12 navbar-right">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#navbar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="collapse navbar-collapse" id="navbar-collapse">
					<ul class="nav nav-justified">
						<li class="active"><a href="###">首页</a></li>
						<li><a href="###">信息公开制度</a></li>
						<li><a href="###">信息公开指南</a></li>
						<li><a href="###">信息公开目录</a></li>
						<li><a href="###">信息公开申请</a></li>
						<li><a href="###">年度报告</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</nav>

	<div class="container" style="padding-left: 0; padding-right: 0">
		<img src="${pageContext.request.contextPath}/static/images/banner.jpg"
			class="img-responsive" alt="济大风光">
	</div>

	<div class="article all-con">
		<div class="container">
			<div class="row">
				<div class="col-md-9 article-sidebarl list-sidebarl list-sidebarr">
					<div class="list">
						<div class="pro-top">
							<h4 class="pull-left">
								<a href="###"><span class="glyphicon glyphicon-list"></span>
									学生奖学金申请与管理规定</a>
							</h4>
							<a href="###" class="more pull-right">更多&gt;&gt;</a>
						</div>
						<div class="clearfix"></div>
						<div class="list-pro-container">
							<div class="list-pro">
								<ul>
									<c:forEach var="content" items="${contentList}">
										<li><a href="###"
											onclick="toContentDetail('${content.id}');" class="pull-left">${content.title}</a><span
											class="list-date">${content.add_time}</span></li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
					<nav class="page">
					<ul class="pagination">
						<div id="div_pager"></div>
						<!-- <li><a href="#">&laquo;</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">&raquo;</a></li> -->
					</ul>
					</nav>
				</div>
				<%@ include file="articleListSidebar.jsp"%>
			</div>
		</div>
	</div>
	<input type="hidden" name="id" id="id_" value="${column_id }">
	<%@ include file="siteFooter.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/keleyidivpager.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/article.pager.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/article.js"></script>
	<script type="text/javascript">
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
