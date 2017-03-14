<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/keleyidivpager.css">
<title>搜索结果-列表页</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

	<%@ include file="page-pic.jsp"%>
	
	<div class="container con-tab all-bg">		
	<div class="info-list">
		<div class="pro-header">
			<h4 class="pro-title pull-left">站内搜索：关键字"<mark>缘园思念</mark><span class="hidden-xs">"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共找到信息<mark>10</mark>条</span></h4>
		</div>
		<div class="clearfix"></div>
		<div class="arclist info-list-body">
			
			<div class="search-list-con">
				<div class="search-pro">
					<a href="###"><h5><span>缘园思念</span>幼儿园教具、窗帘等设备采购及空调移机招标公告</h5></a>
					<p class="search-date">2016-12-16</p>
					<p>本项目为<span>缘园思念</span>触摸屏、幼儿园教具、监控等设备采购共分3个包，供应商不得对包内设备分摸屏、幼儿园教具、监控等设备采购共分3个包，供应商不得对包内设备分项响应；详细技术参数招标文件。包号 货物名称   预算。</p>
				</div>
				<div class="search-pro">
					<a href="###"><h5><span>缘园思念</span>幼儿园教具、窗帘等设备采购及空调移机招标公告</h5></a>
					<p class="search-date">2016-12-16</p>
					<p>本项目为<span>缘园思念</span>触摸屏、幼儿园教具、监控等设备采购共分3个包，供应商不摸屏、幼儿园教具、监控等设备采购共分3个包，供应商不得对包内设备分得对包内设备分项响应；详细技术参数招标文件。包号 货物名称   预算。</p>
				</div>
				<div class="search-pro">
					<a href="###"><h5><span>缘园思念</span>幼儿园教具、窗帘等设备采购及空调移机招标公告</h5></a>
					<p class="search-date">2016-12-16</p>
					<p>本项目为<span>缘园思念</span>触摸屏、幼儿园教具、监控等设备采购共分3个包，供应商不摸屏、幼儿园教具、监控等设备采购共分3个包，供应商不得对包内设备分得对包内设备分项响应；详细技术参数招标文件。包号 货物名称   预算。</p>
				</div>
				<div class="search-pro">
					<a href="###"><h5><span>缘园思念</span>幼儿园教具、窗帘等设备采购及空调移机招标公告</h5></a>
					<p class="search-date">2016-12-16</p>
					<p>本项目为<span>缘园思念</span>触摸屏、幼儿园教具、监控等设备采购共分3个包，供应商不得摸屏、幼儿园教具、监控等设备采购共分3个包，供应商不得对包内设备分对包内设备分项响应；详细技术参数招标文件。包号 货物名称   预算。</p>
				</div>
				<div class="search-pro">
					<a href="###"><h5><span>缘园思念</span>幼儿园教具、窗帘等设备采购及空调移机招标公告</h5></a>
					<p class="search-date">2016-12-16</p>
					<p>本项目为<span>缘园思念</span>触摸屏、幼儿园教具、监控等设备采购共分3个包，供应摸屏、幼儿园教具、监控等设备采购共分3个包，供应商不得对包内设备分商不得对包内设备分项响应；详细技术参数招标文件。包号 货物名称   预算。</p>
				</div>
				<div class="search-pro">
					<a href="###"><h5><span>缘园思念</span>幼儿园教具、窗帘等设备采购及空调移机招标公告</h5></a>
					<p class="search-date">2016-12-16</p>
					<p>本项目为<span>缘园思念</span>触摸屏、幼儿园教具、监控等设备采购共分3个包，供应商不得对包内设备分项响应；详细技术参数招标文件。包号 货物名称   预算。</p>
				</div>
			</div>
		</div>
		<div class="page">
			<ul class="pagination">
				<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
			</ul>
		</div>
	</div>
</div>


	<%@ include file="siteFooter.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/login.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/notice.js"></script>
	<script type="text/javascript">
		var activeFlag = '搜索';
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
