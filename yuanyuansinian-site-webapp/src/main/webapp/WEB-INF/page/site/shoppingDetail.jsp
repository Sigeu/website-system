<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<title>商城-产品内容页</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

	<div class="container banner-con product">
		<input type="hidden" id="product_id" name="product_id" value="${product.id }">
		<div class="col-sm-6">
			<img src="${product.pic }" class="img-responsive">
		</div>
		<div class="col-sm-6">
			<h3 id="name_">${product.name }</h3>
			<div class="product-price">
				<span class="btn-label pull-left">推荐价格</span>
				<h2 class="pull-left">
					<small>￥</small><span id="price_site">${product.price_site }</span>
				</h2>
			</div>
			<div class="clearfix"></div>
			<div class="product-reason">
				<span class="btn-label">推荐理由</span>
				<ul>
					<li><span class="glyphicon glyphicon-star"></span>${product.description }</li>
				</ul>
			</div>
			<div class="product-btn">
				<button class="btn btn-warning btn-lg" id="add_cart_but">加入购物车</button>
				<button class="btn btn-danger btn-lg" id="buy_now_but">立即购买</button>
			</div>
		</div>
	</div>

	<div class="container all-bg">
		<div class="row" style="padding-top: 15px">
			<div class="col-sm-8">
				<div class="article-body">
					<p>${product.content }</p>
				</div>
				<div class="article-near">
					<ul class="pager">
						<!-- <li class="previous disabled"><a href="#">上一篇：没有了</a></li>
						<li class="next"><a href="#">下一篇：记忆中的棉麻服饰搭配，你还记得吗？</a></li> -->
					</ul>
				</div>
			</div>

			<div class="col-sm-4 sidebar">
				<%@ include file="siteLogin.jsp"%>

				<div class="recommend">
					<%@ include file="recommend-index.jsp"%>
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
		var activeFlag = '缘园商城';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
		//供子页面调用关闭弹出页面
		function toClose(){
			layer.closeAll(); 
			window.location.href = contextPath + "/sinian/index/indexController/toMemberCenter";
		}
	</script>
</body>
</html>
