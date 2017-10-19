<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/admin.css">
<title>网站后台管理登录</title>
<meta name="keywords"
	content="">
<meta name="description"
	content="">
</head>
<body>
<div class="navbar navbar-logo admin">
	<div class="container">
		<div class="navbar-header">
			<a href="index.html" class="navbar-brand logo"><img src="${pageContext.request.contextPath}/static/images/login.png" class="img-responsive" alt=""></a>
		</div>
	</div>
</div>

<div class="login-jumb">
	<img src="${pageContext.request.contextPath}/static/images/jumb.jpg" class="img-responsive login-img hidden-xs" alt="background" />
	<form id="form_" class="form form-horizontal" action="${pageContext.request.contextPath}/system/controller/loginController/login"
				method="post">
	<!-- 模态框声明 -->
	<div class="modal show" id="regModal" tabindex="-1" data-backdrop="static">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">用户登录</h4>
				</div>
				<div class="modal-body">
					<div class="container-fluid">
							 <div class="form-group">
								<label class="control-label col-md-3">用户名</label>
								<div class="col-md-9">
									<input type="text" id="login_name" name="login_name" class="form-control" placeholder="请输入您的用户名">	
								</div>
							</div>
							 <div class="form-group">
								<label class="control-label col-md-3">密码</label>
								<div class="col-md-9">
									<input id="password" name="password" type="password" class="form-control" placeholder="请输入您的密码" autocomplete="off">	
								</div>
							</div>
							 <div class="form-group">
								<label class="control-label col-md-3">验证码</label>
								<div class="">
									<div class="col-md-5 col-xs-8">
										<input type="text" class="form-control pull-left" placeholder="请输入验证码">
									</div>
									<div class="col-md-4 col-xs-4" style="padding:0">
										<a href="###"><img class="code-img pull-left" id="img_" src="${pageContext.request.contextPath}/verifyCodeServlet"></a> <a class="code-img-wd hidden-xs" id="kanbuq" href="##">换一张</a>
									</div>
								</div>
							</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-default" type="reset">重置</button>
					<button class="btn btn-primary" id="submit_but" name="submit_but" type="submit">提交</button>
				</div>
			</div>
		</div>
	</div>
	</form>
</div>

<footer id="footer">
	<div class="container">
		<div class="row">
			<div class="col-sm-9">
				<ul>
					<li>Copyright &copy; 1995-2016 University of Jinan</li>
					<li>鲁ICP备05001960号</li>
					<li>地址：济南市市中区南辛庄西路336号     电话：0531-89736251 <span class="hidden-xs hidden-sm">邮编：250022</span></li>
				</ul>
			</div>
			<div class="col-sm-3">
				<div class="footer-tool pull-right hidden-xs">
					<p>技术支持：源拾科技有限公司</p>
					<p>技术邮箱：lzh_me@126.com</p>
				</div>
			</div>
		</div>
	</div>
</footer>
<%@ include file="common/footer_index.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/layer/2.4/layer.js"></script>
<script type="text/javascript">  
	$(function(){
		$('#kanbuq').on('click',function(){
			$('#img_').attr('src','${pageContext.request.contextPath}/verifyCodeServlet?' + new Date().getTime());
		});
	});
	
</script>
</body>
</html>