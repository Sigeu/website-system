<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header-site.jsp"%>
<title>内容详情</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

	<%@ include file="page-pic.jsp"%>

	<div class="article">
		<div class="container">
			<div class="row">
				<p class="breadcrumb">
					<a href="${pageContext.request.contextPath}/index.jsp">首页</a> 
					<c:if test="${not empty locationid2}">
						\ <a href="###" onclick="toContentList('${locationid2}','${csrfPreventionSalt}');">${location2 }</a> 
					</c:if>
					<c:if test="${not empty locationid3 }">
						\ <a href="###" onclick="toContentList('${locationid3}','${csrfPreventionSalt}');">${location3 } </a> 
					</c:if>
					<c:if test="${not empty locationidThis }">
						\ <a href="###" onclick="toContentList('${locationidThis}','${csrfPreventionSalt}');">${locationThis }</a>
					</c:if>
				</p>
				<div class="article-main">
					<div class="article-top text-center">
						<h1>${content.title }</h1>
						<div class="article-info">
							<fmt:parseDate value="${content.add_time}" pattern="yyyy-MM-dd" var="add_time"/>
							<span>公开日期：<fmt:formatDate value="${add_time}" pattern="yyyy年MM月dd日" /></span>
							<span>作者：${content.issue_name }</span><span>浏览次数：${content.hits == null ? 0 : content.hits}次</span>
							<span>有效期：${content.validity_time}</span>
							<span>公开部门：${content.dept_code_name }</span>
						</div>
					</div>
					<div class="article-body">
						<p>${content.content }</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="siteFooter.jsp"%>

	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
	$(function(){
		//记录点击数
		var hits = '${content.hits }';
		if (!hits && typeof (hits) != "undefined" && hits != 0) {
			hits = 0;
		}else{
			hits = Number(hits) + 1;
		}
		$.ajax({
			type : "post",
			url : contextPath
					+ '/content/controller/contentController/updateContentHits',
			data : {
				id : '${content.id }',
				hits : hits
			},
			dataType : "json",
			success : function(data) {
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
			},
		});
	});
	</script>
</body>
</html>
