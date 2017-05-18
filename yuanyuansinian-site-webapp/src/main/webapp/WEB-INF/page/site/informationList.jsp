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
<title>缘园资讯-列表页</title>
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
					<div class="pro-header">
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
				<div class="info-list">
					<div class="pro-header">
						<h4 class="pro-title pull-left">${columnChildName }</h4>
					</div>
					<div class="clearfix"></div>
					<div class="arclist info-list-body">
						<div class="row media">
							<c:forEach items="${contentChildList}" var="contentChild" varStatus="status"> 
								<c:if test="${status.index == 0}">
									<div class="col-md-4 media-img">
										<a class="media-left" href="#" onclick="toInformationDetail('${contentChild.id }','${columnChildId }')">
										<c:choose>  
										   <c:when test="${empty contentChild.cover_img_url}">
										   		<img src="${pageContext.request.contextPath}/static/images/ex3.jpg"
											class="img-responsive" >
										   </c:when>  
										   <c:otherwise>
											    <img src="${contentChild.cover_img_url}"
											class="img-responsive">
										   </c:otherwise>  
										</c:choose>  
										</a>
									</div>
									<div class="col-md-8">
										<div class="media-body">
											<a href="###" onclick="toInformationDetail('${contentChild.id }','${columnChildId }')"><h5 class="media-heading">${contentChild.title}</h5></a>
											<p>${contentChild.add_time}</p>
											<p class="arclist-des text-justify">${contentChild.description}</p>
										</div>
									</div>
								</c:if>
							</c:forEach>
							
						</div>
						<div class="list">
							<ul>
								<c:forEach items="${contentChildList}" var="contentChild" varStatus="status"> 
								<c:if test="${status.index > 0 and status.index < 16}">
									<li><a href="###" onclick="toInformationDetail('${contentChild.id }','${columnChildId }')" class="pull-left">${contentChild.title}</a><span
									class="list-date pull-right">${fn:substring(contentChild.add_time, 0, 10)}</span></li>
								</c:if>
							</c:forEach>
							</ul>
						</div>
					</div>
					<div class="page">
						<ul class="pagination">
							<li><a href="#" aria-label="Previous"><span
									aria-hidden="true">&laquo;</span></a></li>
							<li><a href="#">1</a></li>
							<li><a href="#" aria-label="Next"><span
									aria-hidden="true">&raquo;</span></a></li>
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
