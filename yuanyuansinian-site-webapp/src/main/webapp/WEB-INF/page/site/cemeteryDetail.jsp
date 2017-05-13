<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/keleyidivpager.css">
<title>墓地陵园-内容页</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>
	<div class="container banner-con product">
	<div class="col-sm-6">
		<img src="${cemetery.imgs }" class="img-responsive" alt="product">
	</div>
	<div class="col-sm-6">
		<h3>${cemetery.title }</h3>
		<div class="product-price"><span class="btn-label pull-left">推荐价格</span><h2 class="pull-left"><small>￥</small>${cemetery.price }</h2></div>
		<div class="clearfix"></div>
		<div class="product-reason">
			<span class="btn-label">推荐理由</span>
			<ul>
				<li><span class="glyphicon glyphicon-star"></span>${cemetery.description }</li>
			</ul>
		</div>
		<div class="product-btn">
			<button class="btn btn-warning btn-lg" id="add_cart_but">加入购物车</button>
			<button class="btn btn-danger btn-lg" id="buy_now_but">立即购买</button>
			<button class="btn btn-success btn-lg" id="buy_later_but" >预定本墓</button>
		</div>
	</div>
</div>

<div class="container all-bg">
	<div class="row" style="padding-top:15px">
		<div class="col-sm-8">
			<div class="article-tab">
				<div class="pro-header article-tab-header">
					<h5 class="pro-title pull-left">平面位置</h5>
				</div>
				<div class="clearfix"></div>
				<div class="map">
					<div class="map-body">
						<img src="${pageContext.request.contextPath}/static/images/map.jpg" class="img-responsive" alt="map" />
					</div>
					<p class="pull-left">图示中红色为已售出，绿色位已预订，空白为可选</p>
					<button class="btn btn-warning pull-right">点击显示墓园结构</button>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="article-tab">
				<div class="pro-header article-tab-header">
					<h5 class="pro-title pull-left">详细介绍</h5>
				</div>
				<div class="clearfix"></div>
				<div class="article-body">
					<p>${cemetery.content }</p>
				</div>
			</div>
		</div>
		
		<div class="col-sm-4 sidebar">
			<%@ include file="siteLogin.jsp"%>
			<div class="recommend">
				<div class="pro-header">
					<h4 class="pro-title pull-left">公墓陵园推荐</h4>
					<a href="###" class="more pull-right">更多&raquo;</a>
				</div>
				<div class="clearfix"></div>
				<div class="recommend-body">
					<%@ include file="recommend-index.jsp"%>
				</div>
			</div>
		</div>
	</div>
</div>

	<%@ include file="siteFooter.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/shopping.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/cemetery.js"></script>
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
