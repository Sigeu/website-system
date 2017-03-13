<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/keleyidivpager.css">
<title>网站会员登录</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>
	<div class="login hidden-xs">
	<div class="pro-header">
		<h4 class="pro-title pull-left">用户登录</h4>
	</div>
	<div class="clearfix"></div>
	<div class="login-body">
		<form id="login_form" action="##" method="post">
			<div class="input-group">
				<div class="input-group-addon">
					<span class="glyphicon glyphicon-user"></span>
				</div>
				<input type="text" class="form-control" id="name" name="name"
					placeholder="请输入手机号或者邮箱登录">
			</div>
			<div class="input-group">
				<div class="input-group-addon">
					<span class="glyphicon glyphicon-lock"></span>
				</div>
				<input type="text" class="form-control" id="pwd" name="pwd"
					placeholder="请输入密码">
			</div>
			<div class="checkbox">
				<label class="pull-left"><input type="checkbox">
					记住密码</label> <a href="###" class="pull-right">忘记密码</a>
			</div>
			<button class="btn btn-success btn-login" type="button"
				id="login_but">点击登录</button>
			<button class="btn btn-warning btn-register" id="register_but2">点击注册</button>
		</form>
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
