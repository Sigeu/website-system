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
	<header class="navbar-static-top navbar-top hidden-xs">
	<div class="container">
		<p class="navbar-text hidden-xs">技术支持：源拾科技有限公司</p>
		<p class="navbar-text navbar-right">技术支持：lzh_me@126.com</p>
	</div>
</header>

<div class="navbar-logo">
	<div class="container">
		<div class="navbar-header">
			<a href="index.html" class="navbar-brand logo"><img src="${pageContext.request.contextPath}/static/images/logo.png" class="img-responsive" alt="缘园思念网"></a>
		</div>
		<form class="navbar-form navbar-right hidden" role="search">
			<div class="input-group">
				<input type="text" class="form-control">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search" style="font-size:15px; color:#aeafb4"></span></button>
				</span>
			</div>
		</form>
	</div>
</div>


<div class="modal show login-modal" id="regModal" tabindex="-1" data-backdrop="static">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">用户登录</h4>
			</div>
			<div class="modal-body">
				<div class="container-fluid" >
					<form class="form-horizontal" id="login_form" action="##" method="post">
						<input type="hidden" id="flag" name="flag" value="${flag }">
						<input type="hidden" id="type" name="type" value="${type }">
						 <div class="form-group">
							<label class="control-label col-md-3">手机号码</label>
							<div class="col-md-9">
								<input type="text" class="form-control" id="name" name="name" placeholder="请输入注册时的手机号码">	
							</div>
						</div>
						 <div class="form-group">
							<label class="control-label col-md-3">密码</label>
							<div class="col-md-9">
								<input type="password" class="form-control" id="pwd" name="pwd" placeholder="请输入您的密码">	
							</div>
						</div>
						 <%-- <div class="form-group">
							<label class="control-label col-md-3">验证码</label>
							<div class="">
								<div class="col-md-5 col-xs-8">
									<input type="text" class="form-control pull-left" placeholder="请输入验证码">
								</div>
								<div class="col-md-4 col-xs-4" style="padding:0">
									<a href="###"><img src="${pageContext.request.contextPath}/static/images/code.jpg" class="code-img pull-left"></a><a href="###" class="code-img-wd hidden-xs">换一张</a>
								</div>
							</div>
						</div> --%>
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" id="return_but">返回</button>
				<button class="btn btn-default" type="reset">重置</button>
				<button class="btn btn-danger" id="login_but">提交</button>
			</div>
		</div>
	</div>
</div>
	<%@ include file="siteFooterForLogin.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/member.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/login.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
	<script type="text/javascript">
		var activeFlag = '会员登录';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
	</script>
</body>
</html>
