<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/nav.css">
<title>网站首页</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

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
											class="pull-left"><label class="btn btn-primary btn-xs">${content2.title}</label></a><span
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
	<script type="text/javascript">
		//-------分页数据----------
		var id = '${column_id }';
		var totalPage = '${totalPage }';
		var totalRecords = '${totalRecords }';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
		//-------分页数据----------	
	</script>
</body>
</html>
