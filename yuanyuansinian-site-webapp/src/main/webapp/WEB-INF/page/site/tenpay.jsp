<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
<title>商城-产品内容页</title>
</head>
<body>

<!-- 支付方式弹出页 start -->
<div class="container pay">
	<div class="pay-top">
		<h4>收银台</h4>
	</div>
	<div class="well pay-body pay-wx-body">
		<div class="row">
			<div class="col-sm-9">
				<dl>
					<dt>产品名称：缘园思念网商品</dt>
					<dd>订单编号：${outTradeNo }</dd>
				<dl>
			</div>
			<div class="col-sm-3 pay-wx-count">
				应付金额：￥${totalAmount }
			</div>
		</div>
	</div>
	<div class="pay-way">
		<div class="pay-wx">
			<img src="${pageContext.request.contextPath}/static/images/wx.png" class="wxlogo pull-left">
			<div class="pay-label pull-left">推荐</div>
			<div class="pay-des pull-left">亿万用户的选择，更快更安全</div>
			<div class="pay-price pull-right">支付：<span>${totalAmount }</span>元</div>
		</div>
		<div class="pay-code">
			<img src="${pageContext.request.contextPath}/sinian/index/indexController/encodeQrcode?urlCode=${urlCode}" class="pay-code-img" alt="微信支付">
			<img src="${pageContext.request.contextPath}/static/images/pay.jpg" class="pay-code-des" alt="微信支付">
		</div>
	</div>
</div>
<!-- 支付方式弹出页 end -->

	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/shopping.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/cemetery.js"></script>
	<script type="text/javascript">
		var activeFlag = '缘园商城';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
		//支付宝支付
		function toAlipay(ids,count){
			layer.open({
			    type: 2,
			    maxmin:true,
			    title:["结算"],
			    area: ['100%', '100%'],
			    shadeClose: false, //点击遮罩关闭
			    content: contextPath + '/sinian/index/indexController/toPay?ids=' + ids + '&count=' + count
			 });
		}
		
		//微信支付
		function toTenpay(ids,count){
			layer.open({
			    type: 2,
			    maxmin:true,
			    title:["结算"],
			    area: ['100%', '100%'],
			    shadeClose: false, //点击遮罩关闭
			    content: contextPath + '/sinian/index/indexController/toTenpay?ids=' + ids + '&count=' + count
			 });
			//var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			//parent.layer.close(index); //再执行关闭
		}
		
		
		//定时器，每隔5s查询订单支付状态，订单状态改变，清除页面定时器，页面跳转  
		var timeCheckOrder = window.setInterval(checkOrder,5000);
		function checkOrder() {
			$.ajax({
				method : "POST",
				url : contextPath + "/sinian/index/indexController/checkTenpay",
				data : {
					'outTradeNo' : '${outTradeNo }'
				}
			}).done(function(data) {
				//支付状态
				var status = data.status;
				
				if (status == "0") {
					//window.clearInterval(timeCheckOrder);
					//当你在iframe页面关闭自身时
					var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
					parent.layer.close(index); //再执行关闭   
					//支付成功跳转  
					//window.location.href = contextPath + "/sinian/index/indexController/toMemberCenter";
				} else if(status == "2"){
					//支付失败  
					clearInterval(timeCheckOrder);
				}
			});
		}
		
	</script>
</body>
</html>
