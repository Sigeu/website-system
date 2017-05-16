<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<title>纪念馆-礼品列表</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>
	
	<div class="container con-tab all-bg miss-con">		
	<div class="nav-title">
		<ul class="nav nav-tabs" role="tablist">
			<li role="presentation" class="active"><a href="#pay" aria-controls="home" role="tab" data-toggle="tab">礼品</a></li>
		</ul>
		<div class="btn-tools pull-right">
			<button class="btn btn-danger" id="submit_buy">购买</button></li>
		</div>
	</div>
	<div class="clearfix"></div>
	<div class="tab-content">
		<div class="row tab-pane active img-list shop-list miss-shop-list incense-product-list" id="pay">
			<c:forEach items="${productList}" var="product" varStatus="productStatus"> 
				<div class="col-sm-3">
					<div class="thumbnail">
						<a href="###" onclick="toShoppingDetail('${product.id}');"><img src="${product.pic}" class="img-responsive"></a>
						<a href="###" onclick="toShoppingDetail('${product.id}');"><h5>${product.name}</h5></a>
						<div class="shop-info miss-shop-info pull-right"><input type="checkbox"  name="product_choose" value="${product.name}-${product.id}-${product.price_site}">￥${product.price_site}</div>
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
	</div>
</div>


	<%@ include file="siteFooter.jsp"%>

	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/article.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/hallChooseProduct.js"></script>
	<script type="text/javascript">
		var activeFlag = '产品选择列表';
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
