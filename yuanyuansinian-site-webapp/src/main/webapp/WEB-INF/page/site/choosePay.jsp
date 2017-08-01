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
		<h4>支付方式选择</h4>
	</div>
	<div class="well pay-body">
		<div class="row">
			<div class="col-sm-9 pay-title">
				产品名称：${names }
			</div>
			<div class="col-sm-3 pay-count">
				应付款：￥${count }
			</div>
		</div>
	</div>
	<div class="pay-way">
		<p class="pay-way-top">
			请选择支付方式：
		</p>
		<a href="###" onclick="toAlipay('${ids }','${count }');return false;">
			<dl class="pay-way-pro">
				<dt><img src="${pageContext.request.contextPath}/static/images/alipay.png" alt="支付宝支付" class="img-responsive"></dt>  <!-- 替换相应图片即可 -->
				<!-- <dd>支付宝支付</dd> -->
			</dl>
		</a>
		<a href="###"  onclick="toTenpay('${ids }','${count }');return false;">
			<dl class="pay-way-pro">
				<dt><img src="${pageContext.request.contextPath}/static/images/tenpay.png" alt="微信支付" class="img-responsive"></dt>  <!-- 替换相应图片即可 -->
				<!-- <dd>微信支付</dd> -->
			</dl>
		</a>
	</div>
</div>
<!-- 支付方式弹出页 end -->

	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/shopping.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/cemetery.js"></script>
	<script type="text/javascript">
		//从那个纪念馆进入的该页面
		var hallId = "${hallId }";
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
			    content: contextPath + '/sinian/index/indexController/toPay?ids=' + ids + '&count=' + count + '&hallId=' + hallId
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
			    content: contextPath + '/sinian/index/indexController/toTenpay?ids=' + ids + '&count=' + count + '&hallId=' + hallId
			 });
			//var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			//parent.layer.close(index); //再执行关闭
		}
		
		/* function toClose(){
			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index); //再执行关闭  
			window.location.href = contextPath + "/sinian/index/indexController/toMemberCenter";
		} */
	</script>
</body>
</html>
