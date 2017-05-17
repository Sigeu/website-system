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
						<li><a href="${pageContext.request.contextPath}/sinian/index/indexController/toMemberCreate">我的建馆</a></li>
						<li class="active"><a href="${pageContext.request.contextPath}/sinian/index/indexController/toMemberCart">我的购物车</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-sm-9">
			<div class="settlement">
				<c:forEach var="cart" items="${listCart}">
					<div class="settlement-pro">
						<div class="col-sm-4 settlement-img"><a href="###" onclick="toShoppingDetail('${cart.product_id }')"><img src="${cart.product_pic}" ></a></div>
						<div class="col-sm-8 settlement-info">
							<div class="settlement-title"><a href="###" onclick="toShoppingDetail('${cart.product_id }')">${cart.product_name}</a></div>
							<div class="settlement-price">单价：￥${cart.price_site }</div>
							<div class="settlement-number">
								<form class="form-horizontal">
									<div class="form-group">
										<label class="col-sm-3 col-md-2 control-label">数量：</label>
										<div class="col-sm-3 col-md-2 settlement-input">
											<input type="text" class="form-control" placeholder="请输入" />
										</div>
									</div>
								</form>
							</div>
							<!-- <div class="settlement-price pull-left">需支付：￥0.00</div> -->
							<div class="shop-info pull-right"><input type="checkbox" name="pay_check" value="${cart.product_id }"></div>
						</div>
						<div class="clearfix"></div>
					</div>
                </c:forEach>
				
				<button class="btn btn-danger pull-right settlement-btn" id="settlement_but">立刻结算</button>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
	<%@ include file="siteFooter.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/member.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/article.js"></script>
	<script type="text/javascript">
		var activeFlag = '我的思念';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
	</script>
</body>
</html>
