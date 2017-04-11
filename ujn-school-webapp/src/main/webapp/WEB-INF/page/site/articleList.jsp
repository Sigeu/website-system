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
	<%@ include file="siteHeader.jsp"%>

	<%@ include file="page-pic.jsp"%>

	<div class="article all-con">
		<div class="container">
			<div class="row">
				<%@ include file="articleListSidebarMenu.jsp"%>
				<div class="col-md-9 article-sidebarl list-sidebarl list-sidebarr">
					<div class="list">
						<div class="pro-top">
							<h4 class="pull-left">
								<span class="glyphicon glyphicon-list"></span>
									${column.name }
							</h4>
							<!-- <a href="###" class="more pull-right">更多&gt;&gt;</a> -->
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
					</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<input type="hidden" name="id" id="id_" value="${column_id }">
	<%@ include file="siteFooter.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
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
