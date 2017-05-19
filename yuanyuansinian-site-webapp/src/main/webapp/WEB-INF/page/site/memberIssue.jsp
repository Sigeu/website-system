<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<title>我的思念-我的发布</title>
</head>
<body>

	<div class="col-sm-9">
		<div class="nav-title">
			<ul class="nav nav-tabs" role="tablist">
				<li class="active"><a href="${pageContext.request.contextPath}/sinian/index/indexController/toMemberCreate">我的建馆</a></li>
				<!-- <li role="presentation"><a href="#visit"
					aria-controls="profile" role="tab" data-toggle="tab">我的访问记录</a></li> -->
				<li role="presentation"><a href="#release"
					aria-controls="profile" role="tab" data-toggle="tab">我的发布(未启用页面)</a></li>
			</ul>
		</div>
		<div class="clearfix"></div>
		<div class="tab-content">
			<div class="tab-pane active img-list shop-list miss-setup" id="setup">
				<c:forEach var="hall" items="${hallList}">  
                   	<div class="row miss-setup-pro">
						<div class="col-sm-4 col-md-3">
							<a href="###" onclick="toHallDetail('${hall.id}');"><img
								src="${pageContext.request.contextPath}/static/images/ex3.jpg"
								class="img-responsive" alt="setup" /></a>
						</div>
						<div class="col-sm-8 col-md-9">
							<a href="###" onclick="toHallDetail('${hall.id}');"><h5>${hall.title}</h5></a>
							<p>
								<strong>创建日期：</strong>${hall.create_date}
							</p>
							<div class="miss-des text-justify">
								<strong>简介：</strong>${hall.description}
							</div>
						</div>
						<div class="clearfix"></div>
					</div> 
                 </c:forEach>
				<%-- <div class="row miss-setup-pro">
					<div class="col-sm-4 col-md-3">
						<a href="###"><img
							src="${pageContext.request.contextPath}/static/images/ex3.jpg"
							class="img-responsive" alt="setup" /></a>
					</div>
					<div class="col-sm-8 col-md-9">
						<a href="###"><h5>天束幽花纪念馆天束幽花纪念馆天束幽花纪念馆天束幽花纪念馆天束幽花纪念馆天束幽花纪念馆天束幽花纪念馆</h5></a>
						<p>
							<strong>创建日期：</strong>2016-12-30
						</p>
						<div class="miss-des text-justify">
							<strong>简介：</strong>点开直接进入相应的纪念馆页面
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="row miss-setup-pro">
					<div class="col-sm-4 col-md-3">
						<a href="###"><img
							src="${pageContext.request.contextPath}/static/images/ex3.jpg"
							class="img-responsive" alt="setup" /></a>
					</div>
					<div class="col-sm-8 col-md-9">
						<a href="###"><h5>天束幽花纪念馆</h5></a>
						<p>
							<strong>创建日期：</strong>2016-12-30
						</p>
						<div class="miss-des text-justify">
							<strong>简介：</strong>点开直接进入相应的纪念馆页面 点开直接进入相应的纪念馆页面
						</div>
					</div>
					<div class="clearfix"></div>
				</div> --%>
			</div>

			<div class="tab-pane img-list shop-list miss-list" id="visit">
				<div class="list">
					<ul>
						<li><a href="###" class="pull-left">纪念馆</a><span
							class="list-date pull-right">2016-12-30</span></li>
					</ul>
				</div>
				<div class="clearfix"></div>
				<div class="page">
					<ul class="pagination">
						<li><a href="#" aria-label="Previous"><span
								aria-hidden="true">&laquo;</span></a></li>
						<li><a href="#">1</a></li>
						<li><a href="#" aria-label="Next"><span
								aria-hidden="true">&raquo;</span></a></li>
					</ul>
				</div>
			</div>

			<div class="tab-pane img-list shop-list miss-list" id="release">
				<!-- 文章内容开始 -->
				<div class="article">
				</div>
				<!-- 文章内容结束 -->
			</div>
		</div>
	</div>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/member.js"></script>
	<script type="text/javascript">
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
	</script>
</body>
</html>
