<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/keleyidivpager.css">
<title>我的思念-我的创建</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>
	<div class="container con-tab miss">
		<%@ include file="memberInfo.jsp"%>
	</div>
<div class="container con-tab all-bg miss-con">		
	<div class="row">
		<div class="col-sm-3">
			<div class="side-nav">
				<div class="pro-header">
					<h4>我的思念</h4>
				</div>
				<div class="side-nav-body">
					<ul>
						<li><a href="${pageContext.request.contextPath}/sinian/index/indexController/toMemberCart">我的购物车</a></li>
						<li class="active"><a href="${pageContext.request.contextPath}/sinian/index/indexController/toMemberCreate">我的创建</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-sm-9">
			<div class="nav-title">
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#setup" aria-controls="home" role="tab" data-toggle="tab">我的建馆</a></li>
					<li role="presentation"><a href="#release" aria-controls="profile" role="tab" data-toggle="tab">我的发布</a></li>
				</ul>
			</div>
			<div class="clearfix"></div>
			<div class="tab-content">
				<div class="tab-pane active img-list shop-list miss-setup" id="setup">
					<c:forEach var="hall" items="${listHallNew}">
						<div class="row miss-setup-pro">
							<div class="col-sm-4 col-md-3">
								<a href="###" onclick="toHallDetail('${hall.id }','${hall.hall_type }')"><img src="${hall.imgs }" class="img-responsive" /></a>
							</div>
							<div class="col-sm-8 col-md-9">
								<a href="###" onclick="toHallDetail('${hall.id }','${hall.hall_type }')"><h5>${hall.title }</h5></a>
								<p><strong>创建日期：</strong>${hall.create_date }</p>
								<div class="miss-des text-justify"><strong>简介：</strong>${hall.description }</div>
							</div>
							<div class="clearfix"></div>
						</div>
	                </c:forEach>
				</div>
				
				<div class="tab-pane img-list shop-list miss-list" id="visit">
					<div class="list">
						
					</div>
					<div class="clearfix"></div>
					<div class="page">
						<ul class="pagination">
							<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
							<li><a href="#">1</a></li>
							<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
						</ul>
					</div>
				</div>
				<div class="tab-pane img-list shop-list miss-list" id="release">
					<div class="list">
					</div>
					<div class="clearfix"></div>
					<div class="page">
						<ul class="pagination">
							<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
							<li><a href="#">1</a></li>
							<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
	<%@ include file="siteFooter.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/member.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/hall.js"></script>
	<script type="text/javascript">
		var activeFlag = '我的思念';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
	</script>
</body>
</html>
