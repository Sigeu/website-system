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
						<li><a href="${pageContext.request.contextPath}/sinian/index/indexController/toMemberWarehouse">我的仓库</a></li>
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
							<!-- 商品过期时间 start -->
							<div class="clearfix"></div>
							<span>有效期：${cart.validity_day==null? '10': cart.validity_day }天</span>
							<!-- 商品过期时间 end -->
							<div class="settlement-price">单价：￥${cart.price_site }</div>
							<div class="settlement-number">
								<form class="form-horizontal">
									<div class="form-group">
										<label class="col-sm-3 col-md-2 control-label">数量：</label>
										<div class="col-sm-3 col-md-2 settlement-input">
											<input type="text" name="count_num" value="" class="form-control" placeholder="购买数量" />
										</div>
									</div>
								</form>
								<c:choose>  
								   <c:when test="${empty sessionScope.memberUser}">
								   </c:when>  
								   <c:otherwise>
									   <button class="btn btn-danger pull-left" onclick="toDelete('${cart.id }')">删除</button>
								   </c:otherwise>  
								</c:choose>
							</div>
							<!-- <div class="settlement-price pull-left">需支付：<b>￥</b><span id="money_num">0.00</span></div> -->
							<div class="shop-info pull-right"><input type="checkbox"  value="${cart.product_name}-${cart.product_id}-${cart.price_site}" name="pay_check" value="${cart.product_id }">勾选结算</div>
						</div>
						<div class="clearfix"></div>
					</div>
                </c:forEach>
				<button class="btn btn-danger pull-right settlement-btn" id="settlement_but">结算</button>
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
		//文本框输入事件,任何非正整数的输入都重置为1
		$("input[name='count_num']").blur(function(){
			$(this).val(this.value.replace(/[^\d]/g, 1).replace(/(\d{4})(?=\d)/g, "$1 "));
		});
		//删除
		function toDelete(id) {
			layer.confirm("确认要从购物车删除此物品吗？", {
				btn : [ '确认', '取消' ]
			//按钮
			}, function(index) {
				$.ajax({
					url : contextPath + '/sinian/cart/cartController/deleteCart',
					type : "POST",
					dataType : "JSON",
					data : {
						id : id 
					},
					success : function(data) {
						layer.open({
							content : data.result_message,
							yes : function(index, layero) {
								window.location.reload();//刷新当前页面
								layer.close(index); //如果设定了yes回调，需进行手工关闭
							}
						});
					}
				});
			}, function(index) {
				layer.close(index);
			});
		}
		
		//供子页面调用关闭弹出页面
		function toClose(){
			layer.closeAll(); 
			window.location.href = contextPath + "/sinian/index/indexController/toMemberCenter";
		}
	</script>
</body>
</html>
