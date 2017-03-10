<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/keleyidivpager.css">
<title>我的思念-内容页</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>
	<div class="container con-tab miss">
	<div class="col-sm-3 miss-ico">
		<img src="${pageContext.request.contextPath}/static/images/ex3.jpg" class="img-responsive" alt="img" />
	</div>
	<div class="col-sm-9">
		<div class="web-info">
			<h3>${memberUser.member_name}</h3>
			<p class="hidden-sm">注册时间：${memberUser.create_date}</p>
			<p class="hidden-sm">你已经在缘园思念网注册${memberUser.days }天了，感谢您的支持</p>
		</div>
		<div class="true-info">
			<ul>
				<li class="pull-left"><span>姓名：</span>${memberUser.real_name}</li>
				<li class="pull-left"><span>性别：</span>${memberUser.sex_name}</li>
				<li class="pull-left"><span>联系方式：</span>${memberUser.phone}&nbsp;|&nbsp;${memberUser.email}</li>
				<li class="pull-left"><span>居住地：</span>${memberUser.addr_old}</li>
				<li class="pull-left"><span>现住地：</span>${memberUser.addr_now}</li>
			</ul>
		</div>
		<div class="clearfix"></div>
		<div class="count-info">
			<div class="product-price pull-left"><span class="btn-label pull-left">账户余额：</span><h2 class="pull-left"><small>￥</small>${memberUser.balance}</h2></div>
			<button class="btn btn-danger pull-left" id="recharge_but">立刻充值</button>
			<button class="btn btn-warning pull-left" id="create_hall_but">创建纪念馆</button>
		</div>
	</div>
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
						<li><a href="###">我的购物车</a></li>
						<li class="active"><a href="###">我的创建</a></li>
					</ul>
				</div>
			</div>
		</div>
		<iframe src="${pageContext.request.contextPath}/sinian/hall/hallController/toHallListByMember" name="my_create" id="my_create" 
						scrolling="no" frameborder="0" width="100%"></iframe>
	</div>
</div>
	<%@ include file="siteFooter.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/member.js"></script>
	<script type="text/javascript">
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
	</script>
</body>
</html>
