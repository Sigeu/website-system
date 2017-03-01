<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<nav class="navbar navbar-default navbar-static-top navbar-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/"> <img alt="logo"
				src="${pageContext.request.contextPath}/static/images/logo.png"
				class="img-responsive" />
			</a>
		</div>
		<div
			class="col-xs-12 col-sm-4 col-sm-offset-1 col-md-3 col-md-offset-3 navbar-search"
			style="padding: 0px">
			<div class="input-group">
				<input type="text" class="form-control"> <span
					class="input-group-btn">
					<button class="btn btn-default" type="button">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</span>
			</div>
		</div>
	</div>
</nav>

<nav class="navbar navbar-default navbar-static-top navbar-menu">
	<div class="container">
		<div class="row">
			<div class="navbar-dropdown hidden-xs hidden-sm">
				<div id="navbar-dropdown-top">
					<span id="span_first">校务公开</span><span id="span_second">党务公开</span>
				</div>
				<!-- id="navbar-dropdown-con" -->
				<div id="div_first" style="display: none">
					<ul>
					<c:forEach var="column" items="${columnList}">
						<c:if test="${column.big_class == 102}">
							<c:if test="${column.class_type == 2}">
								<li class="navbar-pos">
								<a href="###"
									class="navbar-dropdown-two active">${column.name }<span>&gt;</span></a>
									<c:if test="${column.class_type == 3}">
										<ul class="navbar-dropdown-thr" style="display: none">
											<li><a href="###">${column.name }</a></li>
										</ul>
									</c:if>
								</li>
							</c:if>
						</c:if>
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
					<c:forEach var="column" items="${columnList}">
						<c:if test="${column.big_class == 102}">
							<c:if test="${column.class_type == 2}">
								<li class="navbar-pos">
								<a href="###"
									class="navbar-dropdown-two active">${column.name }2<span>&gt;</span></a>
									<c:if test="${column.class_type == 3}">
										<ul class="navbar-dropdown-thr" style="display: none">
											<li><a href="###">${column.name }</a></li>
										</ul>
									</c:if>
								</li>
							</c:if>
						</c:if>
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
						<c:forEach var="column" items="${columnList}">
							<c:if test="${column.class_type == 1}">
								<li class="active"><a href="###" onclick="toContentList('${column.id}');">${column.name}</a></li>
							</c:if>
						</c:forEach>
						<!-- <li class="active"><a href="###">首页</a></li>
						<li><a href="###">信息公开制度</a></li>
						<li><a href="###">信息公开指南</a></li>
						<li><a href="###">信息公开目录</a></li>
						<li><a href="###">信息公开申请</a></li>
						<li><a href="###">年度报告</a></li> -->
					</ul>
				</div>
			</div>
		</div>
	</div>
</nav>