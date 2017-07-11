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
					<a href="###">首页</a> \ <a href="###">信息管理制度</a> \ 济南大学召开中外合作办学工作调度会
				</p>
				<div class="article-main">
					<div class="article-top text-center">
						<h1>${content.title }</h1>
						<div class="article-info">
							<fmt:parseDate value="${content.add_time}" pattern="yyyy-MM-dd" var="add_time"/>
							<span>公开日期：<fmt:formatDate value="${add_time}" pattern="yyyy年MM月dd日" /></span>
							<span>作者：${content.issue_name }</span><span>浏览次数：${content.hits }次</span>
							<span>有效期：${content.validity_time}</span>
							<span>公开部门：${content.dept_code_name }</span>
						</div>
					</div>
					<div class="article-body">
						<p>${content.content }</p>
					</div>
				</div>
				<div class="article-like">
					<div class="article-like-top">
						<h4 class="pull-left">相关阅读</h4>
						<button type="button" class="btn btn-primary pull-right">关闭</button>
						<div class="clearfix"></div>
					</div>
					<div class="clearfix"></div>
					<div class="all-list">
						<div class="all-list-pro clearfix">
							<div class="pro-date pull-left hidden-xs hidden-sm">
								<dl>
									<dt>08</dt>
									<dd>12月</dd>
								</dl>
							</div>
							<div class="pro-con article-pro-con pull-right">
								<a href="###"><h5>相关阅读测试1</h5></a>
								<p>测试内容描述显示，测试内容描述显示测试内容描述显示测试内容描述显示测试内容描述显示测试内容描述显示最多80字比较符合版面设计。</p>
							</div>
						</div>
						<div class="all-list-pro clearfix">
							<div class="pro-date pull-left hidden-xs hidden-sm">
								<dl>
									<dt>09</dt>
									<dd>03月</dd>
								</dl>
							</div>
							<div class="pro-con article-pro-con pull-right">
								<a href="###"><h5>相关阅读测试2</h5></a>
								<p>本项目为济南大学触摸屏、幼儿园教具、监控等设备采购共分3个包，供应商不得对包内设备分项响应；详细技术参数招标文件。包号本项目为济南大学触摸屏、幼儿园教具、监控等设备采购共分3个包，供应商不得对包内设备分项响应；详细技术参数招标文件。包号
									货物名称 预算。</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="siteFooter.jsp"%>

	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
	</script>
</body>
</html>
