<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/keleyidivpager.css">
<title>商城-列表页</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

	<%@ include file="page-pic.jsp"%>

	<div class="container con-tab">
		<div class="img-list">
			<%@ include file="recommend.jsp"%>
		</div>
	</div>

	<div class="container con-tab all-bg shop">
		<!-- 分类1开始 -->
		<div class="row">
			<div class="shop-header">
				<h4>鲜花礼品推荐</h4>
				<a href="${pageContext.request.contextPath}/sinian/index/indexController/toShoppingPageList?id=1" class="more pull-right">更多&raquo;</a>
			</div>
			<div class="col-sm-3 hidden-xs">
				<a href="###" class="shop-cat"><img src="${pageContext.request.contextPath}/static/images/shop1.jpg"
					class="img-responsive" alt="shop-cat"></a>
			</div>
			<div class="col-sm-9">
				<div class="row img-list shop-list">
					<c:forEach items="${productList1}" var="product1" varStatus="product1Status"> 
							<div class="col-sm-4">
								<div class="thumbnail">
									<a href="###" onclick="toShoppingDetail('${product1.id }')"><img src="${product1.pic }"
										class="img-responsive" alt="img"></a> <a href="###" onclick="toShoppingDetail('${product1.id }')"><h5>${product1.name }</h5></a>
									<div class="shop-info hidden-xs hidden-sm pull-right">
										<small>￥</small>${product1.price_site }
										<c:choose>  
										   <c:when test="${empty product1.units}">
										   	<small>元宝</small>
										   </c:when>  
										   <c:otherwise>
											   <small>${product1.units }</small>
										   </c:otherwise>  
										</c:choose> 
									</div>
								</div>
							</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<!-- 分类1结束 -->
		<!-- 分类2开始 -->
		<div class="row">
			<div class="shop-header">
				<h4>烟酒礼品推荐</h4>
				<a href="${pageContext.request.contextPath}/sinian/index/indexController/toShoppingPageList?id=2" class="more pull-right">更多&raquo;</a>
			</div>
			<div class="col-sm-3 hidden-xs">
				<a href="###" class="shop-cat"><img src="${pageContext.request.contextPath}/static/images/shop2.jpg"
					class="img-responsive" alt="shop-cat"></a>
			</div>
			<div class="col-sm-9">
				<div class="row img-list shop-list">
					<c:forEach items="${productList2}" var="product2" varStatus="product2Status"> 
							<div class="col-sm-4">
								<div class="thumbnail">
									<a href="###" onclick="toShoppingDetail('${product2.id }')"><img src="${product2.pic }"
										class="img-responsive" alt="img"></a> <a href="###" onclick="toShoppingDetail('${product2.id }')"><h5>${product2.name }</h5></a>
									<div class="shop-info hidden-xs hidden-sm pull-right">
										<small>￥</small>${product2.price_site }
										<c:choose>  
										   <c:when test="${empty product2.units}">
										   	<small>元宝</small>
										   </c:when>  
										   <c:otherwise>
											   <small>${product2.units }</small>
										   </c:otherwise>  
										</c:choose> 
									</div>
								</div>
							</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<!-- 分类2结束 -->
		<!-- 分类3开始 -->
		<div class="row">
			<div class="shop-header">
				<h4>蜡烛烛台推荐</h4>
				<a href="${pageContext.request.contextPath}/sinian/index/indexController/toShoppingPageList?id=3" class="more pull-right">更多&raquo;</a>
			</div>
			<div class="col-sm-3 hidden-xs">
				<a href="###" class="shop-cat"><img src="${pageContext.request.contextPath}/static/images/shop3.jpg"
					class="img-responsive" alt="shop-cat"></a>
			</div>
			<div class="col-sm-9">
				<div class="row img-list shop-list">
					<c:forEach items="${productList3}" var="product3" varStatus="product3Status"> 
							<div class="col-sm-4">
								<div class="thumbnail">
									<a href="###" onclick="toShoppingDetail('${product3.id }')"><img src="${product3.pic }"
										class="img-responsive" alt="img"></a> <a href="###" onclick="toShoppingDetail('${product3.id }')"><h5>${product3.name }</h5></a>
									<div class="shop-info hidden-xs hidden-sm pull-right">
										<small>￥</small>${product3.price_site }
										<c:choose>  
										   <c:when test="${empty product3.units}">
										   	<small>元宝</small>
										   </c:when>  
										   <c:otherwise>
											   <small>${product3.units }</small>
										   </c:otherwise>  
										</c:choose> 
									</div>
								</div>
							</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<!-- 分类3结束 -->
		<!-- 分类4开始 -->
		<div class="row">
			<div class="shop-header">
				<h4>什锦礼品推荐</h4>
				<a href="${pageContext.request.contextPath}/sinian/index/indexController/toShoppingPageList?id=4" class="more pull-right">更多&raquo;</a>
			</div>
			<div class="col-sm-3 hidden-xs">
				<a href="###" class="shop-cat"><img src="${pageContext.request.contextPath}/static/images/shop4.jpg"
					class="img-responsive" alt="shop-cat"></a>
			</div>
			<div class="col-sm-9">
				<div class="row img-list shop-list">
					<c:forEach items="${productList4}" var="product4" varStatus="product4Status"> 
							<div class="col-sm-4">
								<div class="thumbnail">
									<a href="###" onclick="toShoppingDetail('${product4.id }')"><img src="${product4.pic }"
										class="img-responsive" alt="img"></a> <a href="###" onclick="toShoppingDetail('${product4.id }')"><h5>${product4.name }</h5></a>
									<div class="shop-info hidden-xs hidden-sm pull-right">
										<small>￥</small>${product4.price_site }
										<c:choose>  
										   <c:when test="${empty product4.units}">
										   	<small>元宝</small>
										   </c:when>  
										   <c:otherwise>
											   <small>${product4.units }</small>
										   </c:otherwise>  
										</c:choose> 
									</div>
								</div>
							</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<!-- 分类4结束 -->
		<!-- 根据需要，他们要添加更多分类 -->
	</div>

	<%@ include file="siteFooter.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/article.js"></script>
	<script type="text/javascript">
		var activeFlag = '缘园商城';
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
