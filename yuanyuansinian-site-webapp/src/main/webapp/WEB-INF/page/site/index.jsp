<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/nav.css">
<title>网站首页</title>
</head>
<body>
<%@ include file="siteHeader.jsp"%>

<%@ include file="carousel.jsp"%>
<div class="container all-bg" style="padding-bottom:20px">
	<div class="row">
		<div class="col-sm-8">
			<div class="setup all-info">
				<div class="pro-header">
					<h4 class="pro-title pull-left">最新建馆</h4>
					<a href="###" class="more pull-right">更多&raquo;</a>
				</div>
				<div class="clearfix"></div>
				<div class="row">
					<div class="col-sm-6 col-md-4">
						<c:forEach items="${listHallNew}" var="hallNew" varStatus="hallStatus"> 
							<c:if test="${hallStatus.index == 0 }">
								<div class="thumbnail">
									<a href="###" onclick="toShowHall('${hallNew.id}');"><img src="${hallNew.imgs}" alt="${hallNew.title}"></a>
									<div class="caption">
										<a href="###"><h5>${hallNew.title}</h5></a>
										<p class="thumbnail-des text-justify"><strong>简介：</strong>${hallNew.description}</p>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
					<div class="col-sm-6 col-md-4">
						<c:forEach items="${listHallNew}" var="hallNew" varStatus="hallStatus"> 
							<c:if test="${hallStatus.index == 1 }">
								<div class="thumbnail">
									<a href="###" onclick="toShowHall('${hallNew.id}');"><img src="${hallNew.imgs}" alt="${hallNew.title}"></a>
									<div class="caption">
										<a href="###"><h5>${hallNew.title}</h5></a>
										<p class="thumbnail-des text-justify"><strong>简介：</strong>${hallNew.description}</p>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
					<div class="col-sm-6 col-md-4">
						<c:forEach items="${listHallNew}" var="hallNew" varStatus="hallStatus">  
							<c:if test="${hallStatus.index == 2 }">
								<div class="thumbnail">
									<a href="###" onclick="toShowHall('${hallNew.id}');"><img src="${hallNew.imgs}" alt="${hallNew.title}"></a>
									<div class="caption">
										<a href="###"><h5>${hallNew.title}</h5></a>
										<p class="thumbnail-des text-justify"><strong>简介：</strong>${hallNew.description}</p>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
			
			<div class="information arclist">
				<div class="pro-header">
					<h4 class="pro-title pull-left">缘园资讯</h4>
					<ul class="pull-right pro-header-tool hidden-xs">
					<c:forEach items="${columnChildList}" var="columnChild"> 
							<li class="pull-left"><a href="###" onclick="toInformationList('${columnChild.id }')">${columnChild.name }</a></li>
					</c:forEach>
					</ul>
				</div>
				<div class="row media">
					<c:forEach items="${contentList107}" var="content107" varStatus="content"> 
							<c:if test="${content.index == 0 }">
					<div class="col-md-5 media-img">
						<a class="media-left" href="#" onclick="toInformationDetail('${content107.id }','${content107.column_id}')"><img src="${content107.cover_img_url }" class="img-responsive" alt="img"></a>
					</div>
					<div class="col-md-7">
						
						<div class="col-md-4 index-info-con">
							<div class="media-body">
								<a href="###" onclick="toInformationDetail('${content107.id}','${content107.column_id}');"><h5 class="media-heading">${content107.title}</h5></a>
								<p>${fn:substring(content107.add_time, 0, 10)}</p>
								<p class="arclist-des text-justify">${content107.description}</p>
							</div>
						</div>
							
					</div>
					</c:if>
					</c:forEach>
				</div>
				<div class="list">
					<ul>
						<c:forEach items="${contentList107}" var="content107" varStatus="content"> 
							<c:if test="${content.index > 0 }">
								<li><a href="###" onclick="toInformationDetail('${content107.id }','${content107.column_id}')" class="pull-left">${content107.title}</a><span class="list-date pull-right">${fn:substring(content107.add_time, 0, 10)}</span></li>
							</c:if>
						</c:forEach>
					</ul>
				</div>
			</div>
			
			<div class="memorial arclist">
				<div class="pro-header">
					<h4 class="pro-title pull-left">最新祭奠推荐</h4>
					<ul class="pull-right pro-header-tool hidden-xs">
						<li class="pull-left"><a href="###">时间<span class="glyphicon glyphicon-arrow-up"></span></a></li>
						<li class="pull-left"><a href="###">热度<span class="glyphicon glyphicon-arrow-down"></span></a></li>
						<li class="pull-left"><a href="###">更多&raquo;</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
				<div class="list">
					<ul>
						<c:forEach items="${contentList130}" var="content130"> 
							<li><a href="###" class="pull-left" onclick="toOrationDetail('${content130.id }')">${content130.title }</a>
							<span class="list-date pull-right">${fn:substring(content130.add_time, 0, 10)}</span></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="col-sm-4 sidebar">
			<%@ include file="siteLogin.jsp"%>
			<br/>
			<%@ include file="siteSearch.jsp"%>
			<div class="notice">
				<%@ include file="notice.jsp"%>
			</div>
			
			<div class="recommend">
				<%@ include file="recommend-index.jsp"%>
			</div>
		</div>
	</div>
</div>


<%@ include file="siteFooter.jsp"%>
<%@ include file="../../../common/footer-site.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/login.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/carousel.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/notice.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/index.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/information.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/oration.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/cemetery.js"></script>
<script type="text/javascript">
	var activeFlag = '首页';
	$('#index_li').addClass('active');
	//-------分页数据----------
	//var id = '${column_id }';
	//var totalPage = '${totalPage }';
	//var totalRecords = '${totalRecords }';
	// 项目路径
	var contextPath = '${pageContext.request.contextPath}';
	//-------分页数据----------	
</script>
</body>
</html>
