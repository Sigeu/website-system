<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/keleyidivpager.css">
<title>缘园资讯-列表页</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

	<%@ include file="page-pic.jsp"%>

	<div class="container con-tab">
		<div class="img-list">
			<%@ include file="recommend.jsp"%>
		</div>
	</div>
	<div class="container con-tab all-bg">
		<div class="row">
			<div class="col-sm-3">
				<div class="side-nav">
					<div class="pro-header">
						<h4>缘园资讯</h4>
					</div>
					<div class="side-nav-body">
						<ul>
						<c:forEach items="${columnChildList}" var="columnChild"> 
							<c:if test="${columnChildId == columnChild.id}">
								<li class="active"><a href="###" onclick="toInformationList('${columnChild.id }')">${columnChild.name }</a></li>
							</c:if>
							<c:if test="${columnChildId != columnChild.id}">
								<li><a href="###" onclick="toInformationList('${columnChild.id }')">${columnChild.name }</a></li>
							</c:if>
						</c:forEach>
							<!-- <li><a href="###">缘园动态</a></li>
							<li class="active"><a href="###">宗教文化</a></li>
							<li><a href="###">民间习俗</a></li>
							<li><a href="###">祭祀礼仪</a></li>
							<li><a href="###">孝道文化</a></li>
							<li><a href="###">墓志铭</a></li>
							<li><a href="###">祭文</a></li>
							<li><a href="###">悼文</a></li> -->
						</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-9">
				<div class="info-list">
					<div class="pro-header">
						<h4 class="pro-title pull-left">${columnChildName }</h4>
					</div>
					<div class="clearfix"></div>
					<div class="arclist info-list-body">
						<div class="row media">
							<c:forEach items="${contentChildList}" var="contentChild" varStatus="status"> 
								<c:if test="${status.index == 0}">
									<div class="col-md-4 media-img">
										<a class="media-left" href="#" onclick="toInformationDetail('${contentChild.id }','${columnChildId }')"><img src="${pageContext.request.contextPath}/static/images/ex3.jpg"
											class="img-responsive" alt="img"></a>
									</div>
									<div class="col-md-8">
										<div class="media-body">
											<a href="###" onclick="toInformationDetail('${contentChild.id }','${columnChildId }')"><h5 class="media-heading">${contentChild.title}</h5></a>
											<p>${contentChild.add_time}</p>
											<p class="arclist-des text-justify">${contentChild.description}</p>
										</div>
									</div>
								</c:if>
							</c:forEach>
							
						</div>
						<div class="list">
							<ul>
								<li><a href="###" class="pull-left">宋人眼里荒唐离奇的北地胡风民俗</a><span
									class="list-date pull-right">2016-12-30</span></li>
								<li><a href="###" class="pull-left">齐鲁文化—鲁文化在中国上古文化中的地位齐鲁文化—鲁文化在中国上古文化中的地位齐鲁文化—鲁文化在中国上古文化中的地位齐鲁文化—鲁文化在中国上古文化中的地位齐鲁文化—鲁文化在中国上古文化中的地位齐鲁文化—鲁文化在中国上古文化中的地位</a><span
									class="list-date pull-right">2016-12-30</span></li>
								<li><a href="###" class="pull-left">全民阅读生肖民俗文化惠民活动
										明天将在解放碑十字金街开幕</a><span class="list-date pull-right">2016-12-30</span></li>
								<li><a href="###" class="pull-left">全国百家媒体聚焦2016互联网+茶产业暨万里茶道武当道茶品牌推介活动</a><span
									class="list-date pull-right">2016-12-30</span></li>
								<li><a href="###" class="pull-left">《房陵锣鼓歌》出版
										千古诗经民歌传唱至今深山传唱受赞誉</a><span class="list-date pull-right">2016-12-30</span></li>
								<li><a href="###" class="pull-left">宋人眼里荒唐离奇的北地胡风民俗</a><span
									class="list-date pull-right">2016-12-30</span></li>
								<li><a href="###" class="pull-left">齐鲁文化—鲁文化在中国上古文化中的地位</a><span
									class="list-date pull-right">2016-12-30</span></li>
								<li><a href="###" class="pull-left">全民阅读生肖民俗文化惠民活动
										明天将在解放碑十字金街开幕</a><span class="list-date pull-right">2016-12-30</span></li>
								<li><a href="###" class="pull-left">全国百家媒体聚焦2016互联网+茶产业暨万里茶道武当道茶品牌推介活动</a><span
									class="list-date pull-right">2016-12-30</span></li>
								<li><a href="###" class="pull-left">《房陵锣鼓歌》出版
										千古诗经民歌传唱至今深山传唱受赞誉</a><span class="list-date pull-right">2016-12-30</span></li>
								<li><a href="###" class="pull-left">宋人眼里荒唐离奇的北地胡风民俗</a><span
									class="list-date pull-right">2016-12-30</span></li>
								<li><a href="###" class="pull-left">齐鲁文化—鲁文化在中国上古文化中的地位</a><span
									class="list-date pull-right">2016-12-30</span></li>
								<li><a href="###" class="pull-left">全民阅读生肖民俗文化惠民活动
										明天将在解放碑十字金街开幕</a><span class="list-date pull-right">2016-12-30</span></li>
								<li><a href="###" class="pull-left">全国百家媒体聚焦2016互联网+茶产业暨万里茶道武当道茶品牌推介活动</a><span
									class="list-date pull-right">2016-12-30</span></li>
								<li><a href="###" class="pull-left">《房陵锣鼓歌》出版
										千古诗经民歌传唱至今深山传唱受赞誉</a><span class="list-date pull-right">2016-12-30</span></li>
							</ul>
						</div>
					</div>
					<div class="page">
						<ul class="pagination">
							<li><a href="#" aria-label="Previous"><span
									aria-hidden="true">&laquo;</span></a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#" aria-label="Next"><span
									aria-hidden="true">&raquo;</span></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="siteFooter.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/information.js"></script>
	<script type="text/javascript">
		var activeFlag = '缘园资讯';
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
