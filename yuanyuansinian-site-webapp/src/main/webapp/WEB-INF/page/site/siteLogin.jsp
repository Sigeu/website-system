<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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