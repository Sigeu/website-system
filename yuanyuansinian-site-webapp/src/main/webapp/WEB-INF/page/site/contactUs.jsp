<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<title>联系我们</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

	<div class="container contact">
	<div class="article-top">
		<h1>缘园思念网简介</h1>
	</div>
	<div class="article-body" style="padding-top:0">
		<p></p>
		<p></p>
		<p></p>
		<p></p>
		<p></p>
		<p></p>
	</div>
</div>

<div class="container contact contact-add">
	<div class="row">
		<div class="col-sm-6 col-md-5 contact-left">
			<h2>山东缘园思念信息咨询有限公司</h2>
			<p class="hidden-sm"><span class="glyphicon glyphicon-map-marker"></span>${contact.address }</p>
			<p class="contact-tel"><span class="glyphicon glyphicon-phone-alt"></span>${contact.tel }</p>
			<p class="contact-zip hidden-sm">邮编：${contact.addr_zip }</p>
		</div>
		<div class="col-sm-6 col-md-7 contact-add-map">
			<img src="${pageContext.request.contextPath}/static/images/contact.png" class="img-responsive" alt="地理位置" />
		</div>
	</div>
</div>

	<%@ include file="siteFooter.jsp"%>

	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript">
		var activeFlag = '首页';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
	</script>
</body>
</html>
