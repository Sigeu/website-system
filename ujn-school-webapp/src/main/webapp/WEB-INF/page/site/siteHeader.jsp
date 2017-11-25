<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<nav id="logo_nav" class="navbar navbar-default navbar-static-top navbar-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"> <img alt="logo"
				src="${pageContext.request.contextPath}/static/images/logo.png"
				class="img-responsive" />
			</a>
		</div>
		<form id="search_form" action="#" method="post">
			<div class="col-xs-12 col-md-3 col-md-offset-2 navbar-search" style="padding:0px">
				<div class="input-group">
						<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
						<input type="text" name="serach_text" value="" class="form-control"> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button" id="search_but">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
				</div>
			</div>
		</form>
	</div>
</nav>

<nav id="menu_nav" class="navbar navbar-default navbar-static-top navbar-menu">
	<div class="container">
		<div class="row">
			<div id="menu_self" class="navbar-dropdown hidden-xs hidden-sm">
				<div id="navbar-dropdown-top" >
					<span onclick="toContentList('102','${csrfPreventionSalt}');">校务公开</span><span onclick="toContentList('107','${csrfPreventionSalt}');">党务公开</span>
				</div>
			</div>
			<div class="col-md-9 col-xs-12 navbar-right">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#navbar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="collapse navbar-collapse" id="navbar-collapse">
					<ul class="nav nav-justified">
						<li><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
						<c:forEach var="column" items="${columnList}">
							<c:if test="${column.class_type == 1 && column.id != 102 && column.id != 107 }">
								<li class=""><a href="###" onclick="toContentList('${column.id}','${csrfPreventionSalt}');return false;">${column.name}</a></li>
							</c:if>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
</nav>