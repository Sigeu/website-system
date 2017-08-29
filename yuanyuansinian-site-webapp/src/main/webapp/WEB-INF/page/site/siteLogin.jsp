<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<c:choose>
	<c:when
		test="${!empty sessionScope.memberUser }">
		<div class="login hidden-xs">
			<div class="pro-header">
				<h4 class="pro-title pull-left">用户信息</h4>
			</div>
			<div class="clearfix"></div>
			<div class="login-body">
				<!-- 用户登录后显示 start -->
					<table class="table">
						<tr class="warning"><td>用户名：</td><td>${sessionScope.memberUser.real_name}</td></tr>
						<tr class="warning"><td>帐号：</td><td>${sessionScope.memberUser.phone}</td></tr>
					</table>
					<!-- 用户登录后显示 end -->
			</div>
		</div>
	</c:when>
	<c:otherwise>
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
							placeholder="请使用注册时的手机号登录">
					</div>
					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-lock"></span>
						</div>
						<input type="password" class="form-control" id="pwd" name="pwd"
							placeholder="请输入密码">
					</div>
					<div class="input-group">
						<div class="">
							<div class="col-md-4 col-xs-6">
								<input type="text" id="vCode" name="vCode" maxlength="4" class="form-control" placeholder="验证码">
							</div>
							<div class="col-md-4 col-xs-6" style="padding:0">
								<img class="code-img pull-left" id="img_" src="${pageContext.request.contextPath}/verifyCodeServlet"> <a class="code-img-wd hidden-xs" id="kanbuq" href="##">换一张</a>
							</div>
						</div>
					</div>
					<div class="checkbox">
						<label class="pull-left"><input type="checkbox">
							记住密码</label> <a href="###" class="pull-right">忘记密码</a>
					</div>
					<button class="btn btn-success btn-login" type="button"
						id="login_but">点击登录</button>
					<button class="btn btn-warning btn-register" type="button" id="register_but2">点击注册</button>
				</form>
			</div>
		</div>
	</c:otherwise>
</c:choose>

