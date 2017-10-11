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
	<%-- <div class="container con-tab all-bg miss-con">		
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
	</div> --%>
<div style="background-color:transparent">		
	<div class="gift-con">
		<div class="pro-header">
			<h4 class="pro-title pull-left">缘园思念网礼品选择</h4>
			<button class="btn btn-danger btn-xs pull-right" style="margin-top:7px"id="submit_buy">购买</button>
		</div>
		<div class="clearfix"></div>
		
		<div class="row">
			<div class="col-sm-2">
				<div class="side-nav">
					<div class="side-nav-body">
						<ul>
							<li class="active" id="type1"><a href="###">鲜花礼品</a></li>
							<li id="type2"><a href="###">烟酒礼品</a></li>
							<li id="type3"><a href="###">蜡烛烛台</a></li>
							<li id="type4"><a href="###">什锦礼品</a></li>
						</ul>
					</div>
				</div>
			</div>
			
			<div class="col-sm-10" style="display:block" id="div1">
				<c:forEach items="${productList}" var="product" varStatus="productStatus"> 
					<c:if test="${product.type == 1}"> 
						<div class="col-sm-3 col-lg-2 gift-pro">
							<div class="thumbnail">
								<a href="###">
									<img src="${product.pic}" class="img-responsive" onclick="toShoppingDetail('${product.id}');">
									<dl class="text-center">
										<dt onclick="toShoppingDetail('${product.id}');">${product.name}</dt>
										<dd><input type="checkbox"  name="product_choose" value="${product.name}-${product.id}-${product.price_site}">￥${product.price_site}</dd>
										<dd>有效期：${product.validity_day==null? '10': product.validity_day}天</dd>
									</dl>
								</a>
							</div>
						</div>
					</c:if>
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
			
			<div class="col-sm-10" style="display:none" id="div2">
				<c:forEach items="${productList}" var="product" varStatus="productStatus"> 
					<c:if test="${product.type == 2}">
						<div class="col-sm-3 col-lg-2 gift-pro">
							<div class="thumbnail">
								<a href="###">
									<img src="${product.pic}" class="img-responsive" onclick="toShoppingDetail('${product.id}');">
									<dl class="text-center">
										<dt onclick="toShoppingDetail('${product.id}');">${product.name}</dt>
										<dd><input type="checkbox"  name="product_choose" value="${product.name}-${product.id}-${product.price_site}">￥${product.price_site}</dd>
										<dd>有效期：${product.validity_day==null? '10': product.validity_day}天</dd>
									</dl>
								</a>
							</div>
						</div>
					</c:if>
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
			
			
			<div class="col-sm-10" style="display:none" id="div3">
				<c:forEach items="${productList}" var="product" varStatus="productStatus"> 
					<c:if test="${product.type == 3}">
						<div class="col-sm-3 col-lg-2 gift-pro">
							<div class="thumbnail">
								<a href="###">
									<img src="${product.pic}" class="img-responsive" onclick="toShoppingDetail('${product.id}');">
									<dl class="text-center">
										<dt onclick="toShoppingDetail('${product.id}');">${product.name}</dt>
										<dd><input type="checkbox"  name="product_choose" value="${product.name}-${product.id}-${product.price_site}">￥${product.price_site}</dd>
										<dd>有效期：${product.validity_day==null? '10': product.validity_day}天</dd>
									</dl>
								</a>
							</div>
						</div>
					</c:if>
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
			
			
			<div class="col-sm-10" style="display:none" id="div4">
				<c:forEach items="${productList}" var="product" varStatus="productStatus"> 
					<c:if test="${product.type == 4}">
						<div class="col-sm-3 col-lg-2 gift-pro">
							<div class="thumbnail">
								<a href="###">
									<img src="${product.pic}" class="img-responsive" onclick="toShoppingDetail('${product.id}');">
									<dl class="text-center">
										<dt onclick="toShoppingDetail('${product.id}');">${product.name}</dt>
										<dd><input type="checkbox"  name="product_choose" value="${product.name}-${product.id}-${product.price_site}">￥${product.price_site}</dd>
										<dd>有效期：${product.validity_day==null? '10': product.validity_day}天</dd>
									</dl>
								</a>
							</div>
						</div>
					</c:if>
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
</div>
<div class="clearfix"></div>

	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/article.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/hallChooseProduct.js"></script>
	<script type="text/javascript">
		//从那个纪念馆进入的该页面
		var hallId = "${hallId }";
		var activeFlag = '产品选择列表';
		//-------分页数据----------
		var id = '${column_id }';
		var totalPage = '${totalPage }';
		var totalRecords = '${totalRecords }';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
		//-------分页数据----------
		
		$('#type1').bind('click',function(){
			$('#div1').show();
			$('#type1').addClass('active');
			$('#div2,#div3,#div4').hide();
			$('#type2,#type3,#type4').removeClass('active');
		});
		$('#type2').bind('click',function(){
			$('#div2').show();
			$('#type2').addClass('active');
			$('#div1,#div3,#div4').hide();
			$('#type1,#type3,#type4').removeClass('active');
		});
		$('#type3').bind('click',function(){
			$('#div3').show();
			$('#type3').addClass('active');
			$('#div1,#div2,#div4').hide();
			$('#type1,#type2,#type4').removeClass('active');
		});
		$('#type4').bind('click',function(){
			$('#div4').show();
			$('#type4').addClass('active');
			$('#div1,#div2,#div3').hide();
			$('#type1,#type2,#type3').removeClass('active');
		});
		
		//供子页面调用关闭弹出页面
		function toClose(){
			layer.closeAll(); 
			window.location.href = contextPath + "/sinian/index/indexController/toMemberCenter";
		}
	</script>
</body>
</html>
