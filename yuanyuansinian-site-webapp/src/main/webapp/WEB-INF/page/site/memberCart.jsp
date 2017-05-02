<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/keleyidivpager.css">
<title>我的思念-我的购物车</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>
	<div class="container con-tab miss">
	<div class="col-sm-3 miss-ico">
		<img src="${pageContext.request.contextPath}/static/images/ex3.jpg" class="img-responsive" alt="img" />
	</div>
	<div class="col-sm-9">
		<%@ include file="memberInfo.jsp"%>
	</div>
</div>

<%-- <div class="container con-tab all-bg miss-con">		
	<div class="row">
		<div class="col-sm-3">
			<div class="side-nav">
				<div class="pro-header">
					<h4>我的思念</h4>
				</div>
				<div class="side-nav-body">
					<ul>
						<li><a href="###">我的购物车</a></li>
						<li class="active"><a href="###">我的创建</a></li>
					</ul>
				</div>
			</div>
		</div>
		<iframe src="${pageContext.request.contextPath}/sinian/hall/hallController/toHallListByMember" name="my_create" id="my_create" 
						scrolling="no" frameborder="0" width="100%"></iframe>
	</div>
</div> --%>
	<div class="container con-tab all-bg miss-con">		
	<div class="row">
		<div class="col-sm-3">
			<div class="side-nav">
				<div class="pro-header">
					<h4>我的思念</h4>
				</div>
				<div class="side-nav-body">
					<ul>
						<li class="active"><a href="${pageContext.request.contextPath}/sinian/index/indexController/toMemberCart">我的购物车</a></li>
						<li><a href="${pageContext.request.contextPath}/sinian/index/indexController/toMemberCreate">我的创建</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-sm-9">
			<div class="nav-title">
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#pay" aria-controls="home" role="tab" data-toggle="tab">待付款商品</a></li>
					<li role="presentation"><a href="#paid" aria-controls="profile" role="tab" data-toggle="tab">已付款商品</a></li>
				</ul>
				<div class="btn-tools pull-right">
					<button class="btn btn-danger" id="settlement_but">点击结算</button></li>
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="tab-content">
				<div class="row tab-pane active img-list shop-list miss-shop-list" id="pay">
					<c:forEach var="cart" items="${listCart}">
						<div class="col-sm-4">
							<div class="thumbnail">
								<a href="###"><img src="${pageContext.request.contextPath}/static/images/ex2.jpg" class="img-responsive" alt="img"></a>
								<a href="###"><h5>${cart.title}</h5></a>
								<div class="shop-info miss-shop-info hidden-xs pull-right"><input type="checkbox">￥20.25</div>
							</div>
						</div>
	                 </c:forEach>
					<div class="clearfix"></div>
					<div class="page">
						<ul class="pagination">
							<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
							<li><a href="#">1</a></li>
							<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
						</ul>
					</div>
				</div>
				
				<div class="row tab-pane img-list shop-list miss-shop-list miss-shop-full" id="paid">
					<c:forEach var="order" items="${listOrder}">
						<div class="col-sm-4">
							<div class="thumbnail">
								<a href="###"><img src="${pageContext.request.contextPath}/static/images/logo.png" class="img-responsive" alt="img"></a>
								<a href="###"><h5>${order.title}</h5></a>
							</div>
						</div>
	                 </c:forEach>
					<div class="clearfix"></div>
					<div class="page">
						<ul class="pagination">
							<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
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
	<script type="text/javascript">
		var activeFlag = '我的思念';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
	</script>
</body>
</html>
