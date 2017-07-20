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
					
						<input type="text" name="serach_text" class="form-control"> <span
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
					<span id="span_first">校务公开</span><span id="span_second">党务公开</span>
				</div>
				<div id="div_first" style="display: block">
					<ul>
					<c:forEach var="column" items="${columnList102}">
							<li class="navbar-pos" columnId="${column.id}">
							<a href="###"  onclick="toContentList('${column.id}');" 
								class="navbar-dropdown-two">${column.name }<span>&gt;</span></a>
									<ul class="navbar-dropdown-thr" style="display: none">
										<c:forEach var="column3" items="${columnList3}">
											<c:if test="${column3.big_class == column.id}">
												<li><a href="###" onclick="toContentListForLevel3('${column3.id}');" ><em class="glyphicon glyphicon-stop"></em>&nbsp;${column3.name }</a></li>
											</c:if>
										</c:forEach>
									</ul>
							</li>
					</c:forEach>
					</ul>
					<ul style="display: none">
						<li><a href="###">00</a></li>
						<li><a href="###">11</a></li>
						<li><a href="###">22</a></li>
						<li><a href="###">33</a></li>
						<li><a href="###">44</a></li>
					</ul>
				</div>
				<div id="div_second" style="display: none">
					<ul>
					<c:forEach var="column" items="${columnList107}">
							<li class="navbar-pos">
							<a href="###" onclick="toContentList('${column.id}');" 
								class="navbar-dropdown-two">${column.name }<span>&gt;</span></a>
									<ul class="navbar-dropdown-thr" style="display: none">
										<c:forEach var="column3" items="${columnList3}">
											<c:if test="${column3.big_class == column.id}">
												<li><a href="###" onclick="toContentListForLevel3('${column3.id}');" ><em class="glyphicon glyphicon-stop"></em>&nbsp;${column3.name }</a></li>
											</c:if>
										</c:forEach>
									</ul>
							</li>
					</c:forEach>
					</ul>
					<ul style="display: none">
						<li><a href="###">00</a></li>
						<li><a href="###">11</a></li>
						<li><a href="###">22</a></li>
						<li><a href="###">33</a></li>
						<li><a href="###">44</a></li>
					</ul>
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
								<li class=""><a href="###" onclick="toContentList('${column.id}');">${column.name}</a></li>
							</c:if>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
</nav>