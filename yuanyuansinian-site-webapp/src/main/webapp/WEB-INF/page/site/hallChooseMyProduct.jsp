<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<title>纪念馆-已买商品选择</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>
	
	<div class="container con-tab all-bg miss-con">		
	<div class="nav-title">
		<ul class="nav nav-tabs" role="tablist">
			<li role="presentation" class="active"><a href="#pay" aria-controls="home" role="tab" data-toggle="tab" id="warehouse_li">已买礼品</a></li>
			<li role="presentation"><a href="#paid" aria-controls="profile" role="tab" data-toggle="tab" id="buy_li">重新购买</a></li>
		</ul>
		<div class="btn-tools pull-right">
			<button class="btn btn-danger" id="submit_choose">点击提交</button></li>
			<button class="btn btn-danger" id="submit_buy" style="display:none">购买</button></li>
		</div>
	</div>
	<div class="clearfix"></div>
	<div class="tab-content">
		<div class="row tab-pane active img-list shop-list miss-shop-list incense-product-list" id="pay">
			<c:forEach items="${listWarehouse}" var="warehouse" varStatus="warehouseStatus"> 
				<div class="col-sm-3">
					<div class="thumbnail">
						<a href="###"  onclick="toProductDetail('${warehouse.product_id}');"><img src="${pageContext.request.contextPath}/static/images/ex2.jpg" class="img-responsive"></a>
						<a href="###"><h5>${warehouse.product_name}</h5></a>
						<div class="shop-info miss-shop-info pull-right"><input type="radio" name="warehouse_choose" value="${warehouse.id}">使用</div>
					</div>
				</div>
			</c:forEach>
			
			<div class="col-sm-3">
				<div class="thumbnail">
					<a href="###"><img src="${pageContext.request.contextPath}/static/images/4.JPG" class="img-responsive"></a>
					<a href="###"><h5>测试礼品</h5></a>
					<div class="shop-info miss-shop-info pull-right"><input type="radio" name="warehouse_choose" value="1">使用</div>
				</div>
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
		
		<div class="row tab-pane img-list shop-list miss-shop-list incense-product-list" id="paid">
			<c:forEach items="${productList}" var="product" varStatus="productStatus"> 
				<div class="col-sm-3">
					<div class="thumbnail">
						<a href="###"  onclick="toProductDetail('${product.id }');"><img src="${product.pic }" class="img-responsive"></a>
						<a href="###" onclick="toProductDetail('${product.id }');"><h5>${product.name }</h5></a>
						<div class="shop-info miss-shop-info pull-right"><input type="checkbox" name="pay_check" value="${product.id }">购买</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>


	<%@ include file="siteFooter.jsp"%>

	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/hallDetail.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/hallChooseMyProduct.js"></script>
	<script type="text/javascript">
		var activeFlag = '产品选择列表';
		var hallType = '${hallType}';
		var hallId = '${hallId}';
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
