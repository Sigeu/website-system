<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/keleyidivpager.css">
<title>缘园资讯-内容页</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

	<%@ include file="page-pic.jsp"%>

	<div class="container con-tab">
		<div class="img-list">
			<%@ include file="recommend.jsp"%>
		</div>
	</div>
	<div class="container con-tab all-bg">
		<div class="row">
			<div class="col-sm-3">
				<div class="side-nav">
					<div class="side-nav-top">
						<h4>缘园资讯</h4>
					</div>
					<div class="side-nav-body">
						<ul>
							<c:forEach items="${columnChildList}" var="columnChild"> 
								<c:if test="${columnChildId == columnChild.id}">
									<li class="active"><a href="###" onclick="toInformationList('${columnChild.id }')">${columnChild.name }</a></li>
								</c:if>
								<c:if test="${columnChildId != columnChild.id}">
									<li><a href="###" onclick="toInformationList('${columnChild.id }')">${columnChild.name }</a></li>
								</c:if>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-9">
				<div class="here">
					<ol class="breadcrumb">
						<li><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
						<li><a href="${pageContext.request.contextPath}/sinian/index/indexController/toInformationList" >缘园资讯</a></li>
						<li><a href="#" onclick="toInformationList('${columnChildId }')">${columnChildName }</a></li>
						<li class="active">${content.title }</li>
					</ol>
				</div>
				<div class="article">
					<div class="article-top">
						<h1>${content.title }</h1>
						<div class="article-info">
							<span>${content.add_time }</span><span>作者：${content.issue } </span><span
								class="hidden-xs">浏览次数：${content.hits }</span>
						</div>
					</div>
					<div class="article-body">
						<p>${content.content }</p>
					</div>
					<div class="article-near">
						<ul class="pager">
							<!-- <li class="previous disabled"><a href="#">上一篇：没有了</a></li>
							<li class="next"><a href="#">下一篇：记忆中的棉麻服</a></li> -->
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="siteFooter.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/information.js"></script>
	<script type="text/javascript">
		var activeFlag = '缘园资讯';
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
