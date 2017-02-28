<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/nav.css">
<title>index</title>
<script type="text/javascript">
	//-------分页数据----------
	var id = '${column_id }';
	var totalPage = '${totalPage }';
	var totalRecords = '${totalRecords }';
	// 项目路径
	var contextPath = '${pageContext.request.contextPath}';
	//-------分页数据----------
</script>
</head>
<body>
	<%-- <nav class="navbar navbar-default navbar-static-top navbar-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="###"> <img alt="logo"
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
	</nav> --%>

<!-- 	<nav class="navbar navbar-default navbar-static-top navbar-menu">
		<div class="container">
			<div class="row">
				<div class="navbar-dropdown hidden-xs hidden-sm">
					<div id="navbar-dropdown-top">
						<span class="navbar-dorpdown-one">校务公开</span><span>党务公开</span>
					</div>
					<div id="navbar-dropdown-con">
						<ul>
							<li class="navbar-pos"><a href="###"
								class="navbar-dropdown-two">基本信息<span>&gt;</span></a></li>
							<li class="navbar-pos"><a href="###"
								class="navbar-dropdown-two">招生考试信息<span>&gt;</span></a></li>
							<li class="navbar-pos"><a href="###"
								class="navbar-dropdown-two">财务、资产及收费信息<span>&gt;</span></a></li>
							<li class="navbar-pos"><a href="###"
								class="navbar-dropdown-two">人事师资信息<span>&gt;</span></a></li>
							<li class="navbar-pos"><a href="###"
								class="navbar-dropdown-two">教学质量信息<span>&gt;</span></a></li>
							<li class="navbar-pos"><a href="###"
								class="navbar-dropdown-two active">学生管理服务信息<span>&gt;</span></a>
								<ul class="navbar-dropdown-thr">
									<li><a href="###">学籍管理办法</a></li>
									<li><a href="###">学生奖学金申请与管理规定</a></li>
									<li><a href="###">助学金申请与管理规定</a></li>
									<li><a href="###">学费减免申请与管理规定</a></li>
									<li><a href="###">助学贷款申请与管理规定</a></li>
									<li><a href="###">勤工俭学的申请与管理规定</a></li>
									<li><a href="###">学生奖励处罚办法</a></li>
									<li><a href="###">学生申诉办法</a></li>
								</ul></li>
							<li class="navbar-pos"><a href="###"
								class="navbar-dropdown-two">学风建设信息<span>&gt;</span></a></li>
							<li class="navbar-pos"><a href="###"
								class="navbar-dropdown-two">学位、学科信息<span>&gt;</span></a></li>
							<li class="navbar-pos"><a href="###"
								class="navbar-dropdown-two">对外交流与合作信息<span>&gt;</span></a></li>
							<li class="navbar-pos"><a href="###"
								class="navbar-dropdown-two">其他信息<span>&gt;</span></a></li>
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
							<li class="active"><a href="###">首页</a></li>
							<li><a href="###">信息公开制度</a></li>
							<li><a href="###">信息公开指南</a></li>
							<li><a href="###">信息公开目录</a></li>
							<li><a href="###">信息公开申请</a></li>
							<li><a href="###">年度报告</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav> -->
	<%@ include file="siteHeader.jsp"%>

<%-- 	<div id="myCarousel" class="carousel slide">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item active" style="background: #223240">
				<img
					src="${pageContext.request.contextPath}/static/images/slide1.png"
					alt="第一张">
			</div>
			<div class="item" style="background: #F5E4DC;">
				<img
					src="${pageContext.request.contextPath}/static/images/slide2.png"
					alt="第二张">
			</div>
			<div class="item" style="background: #DE2A2D;">
				<img
					src="${pageContext.request.contextPath}/static/images/slide3.png"
					alt="第三张">
			</div>
		</div>
		<a href="#myCarousel" data-slide="prev" class="carousel-control left">
			<span class="glyphicon glyphicon-chevron-left"></span>
		</a> <a href="#myCarousel" data-slide="next"
			class="carousel-control right"> <span
			class="glyphicon glyphicon-chevron-right"></span>
		</a>
	</div> --%>
	<%@ include file="carousel.jsp"%>

	<div class="index-info">
		<div class="container">
			<div class="pro-top">
				<h4 class="pull-left">
					<a href="###" onclick="toContentList('${column_id1}');"><span
						class="glyphicon glyphicon-th-list"></span> 最新公开信息</a>
				</h4>
				<a href="###" onclick="toContentList('${column_id1}');"
					class="more pull-right">更多&gt;&gt;</a>
			</div>
			<div class="clearfix"></div>
			<div class="row text-justify">
				<c:forEach var="content1" items="${contentList1}">
					<c:if test="content1.index == 0">
						<div class="col-md-4 index-info-con">
							<div class="index-info-fir-top">
								<a href="###" onclick="toContentDetail('${content1.id}');">${content1.title}</a>
								<span>${content1.add_time}</span>
							</div>
							<div class="index-info-fir-body">${content1.description}</div>
						</div>
					</c:if>
				</c:forEach>

				<div class="col-md-8 all-list">
					<c:forEach var="content1" items="${contentList1}">
						<c:if test="content1.index > 1">
							<div class="all-list-pro clearfix">
								<div class="pro-date pull-left hidden-xs hidden-sm">
									<dl>
										<dt>${content1.add_time}</dt>
										<dd>${content1.add_time}月</dd>
									</dl>
								</div>
								<div class="pro-con pull-right">
									<a href="###" onclick="toContentDetail('${content1.id}');"><h5>${content1.title}</h5></a>
									<p>${content1.description}</p>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<div class="index-tab">
		<div class="container">
			<div class="row">
				<div class="col-md-8 list-tab">
					<div class="list">
						<div class="pro-top">
							<h4 class="pull-left">
								<a href="###" onclick="toContentList('${column_id2}');"><span
									class="glyphicon glyphicon-align-left"></span> 重要信息公开</a>
							</h4>
							<a href="###" onclick="toContentList('${column_id2}');"
								class="more pull-right">更多&gt;&gt;</a>
						</div>
						<div class="clearfix"></div>
						<div class="list-pro-container">
							<div class="list-pro">
								<ul>
									<c:forEach var="content2" items="${contentList2}">
										<li><a href="###"
											onclick="toContentDetail('${content2.id}');"
											class="pull-left">${content2.title}</a><span
											class="list-date">${content2.add_time}</span></li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
					<div class="list info-list">
						<div class="pro-top">
							<h4 class="pull-left">
								<a href="###" onclick="toContentList('${column_id3}');"><span
									class="glyphicon glyphicon-list-alt"></span> 信息公开规章制度</a>
							</h4>
							<a href="###" onclick="toContentList('${column_id3}');"
								class="more pull-right">更多&gt;&gt;</a>
						</div>
						<div class="clearfix"></div>
						<div class="list-pro-container">
							<div class="list-pro">
								<ul>
									<c:forEach var="content3" items="${contentList3}">
										<li><a href="###"
											onclick="toContentDetail('${content3.id}');"
											class="pull-left">${content3.title}</a><span
											class="list-date">${content3.add_time}</span></li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="contact">
						<div class="pro-top">
							<h4 class="pull-left">
								<a href="###">信息公开联系方式</a>
							</h4>
							<!-- <a href="###" class="more pull-right">更多&gt;&gt;</a> -->
						</div>
						<div class="clearfix"></div>
						<ul>
							<li>部门：${contact.dept_name }</li>
							<li>地址：${contact.address }</li>
							<li>电话：${contact.tel }</li>
							<li>邮编：${contact.addr_zip }</li>
							<li>邮箱：${contact.email }</li>
						</ul>
						<a href="###"><img
							src="${pageContext.request.contextPath}/static/images/news.jpg"
							class="img-responsive" alt="济大新闻网"></a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="siteFooter.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/article.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/nav.js"></script>
	<script type="text/javascript">
		$(function() {
			//轮播自动播放
			$('#myCarousel').carousel({
				//自动4秒播放
				interval : 4000,
			});
		});

		var spanos = document.getElementById("navbar-dropdown-top")
				.getElementsByTagName("span");
		var ulos = document.getElementById("navbar-dropdown-con")
				.getElementsByTagName("ul");
		function show(num) {
			for (i = 0; i < spanos.length; i++) {
				if (i == num) {
					spanos[i].className = "navbar-dorpdown-one";
					ulos[i].style.display = "block";
				} else {
					spanos[i].className = "";
					ulos[i].style.display = "none";
				}
			}
		}
	</script>
</body>
</html>
