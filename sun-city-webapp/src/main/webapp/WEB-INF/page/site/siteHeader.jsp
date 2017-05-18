<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<header class="navbar-static-top navbar-top">
	<div class="container">
		<p class="navbar-text hidden-xs">24小时联系电话：0531-86951156</p>
		<p class="navbar-text navbar-right">
		<c:choose>  
	   <c:when test="${empty sessionScope.memberUser}">
	   	<a href="${pageContext.request.contextPath}/sinian/index/indexController/toMemberLogin" class="navbar-link" style="color:#b85844">用户登录</a>
	   </c:when>  
	   <c:otherwise>
		   <a href="##" id="logout_but" class="navbar-link" style="color:#b85844">注销</a>
	   </c:otherwise>  
	</c:choose>  
		 | <a href="${pageContext.request.contextPath}/sinian/index/indexController/toRegister" class="navbar-link" id="register_but1">用户注册</a>
		  | <a href="${pageContext.request.contextPath}/sinian/contact/contactController/toContactUs" class="navbar-link">联系我们</a></p>
	</div>
</header>
<div class="navbar navbar-logo">
	<div class="container">
		<div class="navbar-header">
			<a href="${pageContext.request.contextPath}/index.jsp" class="navbar-brand logo"><img src="${pageContext.request.contextPath}/static/images/logo.png" class="img-responsive" alt="缘园思念网"></a>
		</div>
		<!-- <form  id="search_form" class="navbar-form navbar-right" role="search" action="#" method="post">
			<div class="input-group">
				<input type="text" class="form-control" id="search_text">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button" id="search_but"><span class="glyphicon glyphicon-search" style="font-size:15px; color:#aeafb4"></span></button>
				</span>
			</div>
		</form> -->
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
	</div>
</div>
<nav class="navbar navbar-mainnav">
	<div class="container">
		<div class="collapse navbar-collapse" id="navbar-collapse">
			<ul class="nav nav-justified" id="index_ul">
				<li id="index_li"><a id="index_a" href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
			</ul>
		</div>
	</div>
</nav>