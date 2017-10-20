<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/nav.css">
<title>济南大学信息公示网站首页</title>
</head>
<body>
	<%@ include file="siteHeader-index.jsp"%>

	<%@ include file="carousel.jsp"%>

	<div class="index-info">
		<div class="container">
			<div class="pro-top">
				<h4 class="pull-left">
					<a href="###" onclick="toContentListForNew();"><span
						class="glyphicon glyphicon-th-list"></span> 最新公开信息</a>
				</h4>
				<a href="###" onclick="toContentListForNew();"
					class="more pull-right">更多&gt;&gt;</a>
			</div>
			<div class="clearfix"></div>
			<div class="row text-justify">
				<c:forEach var="contentNew" items="${contentListNew}" varStatus="content">
					<c:if test="${content.index == 0 }">
						<div class="col-md-4 index-info-con">
							<div class="index-info-fir-top">
								<c:if test="${contentNew.top_ok == 1 }">
									<label class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-open"></span></label>
								</c:if>
								<a href="###" onclick="toContentDetail('${contentNew.id}');">${contentNew.title}</a>
								<span>${contentNew.add_time}</span>
							</div>
							<div class="index-info-fir-body">${contentNew.description}</div>
						</div>
					</c:if>
				</c:forEach>

				<div class="col-md-8 all-list">
					<c:forEach var="contentNew" items="${contentListNew}" varStatus="content">
						<c:if test="${content.index > 0}">
							<div class="all-list-pro clearfix">
								<div class="pro-date pull-left hidden-xs hidden-sm">
									<dl>
										<dt>${fn:substring(contentNew.add_time, 8, 10)}</dt>
										<dd>${fn:substring(contentNew.add_time, 5, 7)}月</dd>
									</dl>
								</div>
								<div class="pro-con pull-right">
									
									<a href="###" onclick="toContentDetail('${contentNew.id}');">
										<h5>
											<c:if test="${contentNew.top_ok == 1 }">
												<label class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-open"></span></label>
											</c:if>${contentNew.title}
										</h5>
									</a>
									<p>${contentNew.description}</p>
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
								<a href="###" onclick="toContentListForImportance();"><span
									class="glyphicon glyphicon-align-left"></span> 重要信息公开</a>
							</h4>
							<a href="###" onclick="toContentListForImportance();"
								class="more pull-right">更多&gt;&gt;</a>
						</div>
						<div class="clearfix"></div>
						<div class="list-pro-container">
							<div class="list-pro">
								<ul>
									<c:forEach var="content2" items="${contentList2}">
										<li>
										
										<a href="###"
											onclick="toContentDetail('${content2.id}');"
											class="pull-left">
											<c:if test="${content2.top_ok == 1 }">
												<label class="btn btn-primary btn-xs"><span class="list-top glyphicon glyphicon-open"></span></label>
											</c:if>${content2.title}</a><span
											class="list-date">${fn:substring(content2.add_time, 0, 10)}</span></li>
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
						<a href="http://news.ujn.edu.cn" target="_blank"><img
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
