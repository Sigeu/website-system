<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/nav.css">
<title>网站首页</title>
</head>
<body>
<%@ include file="siteHeader.jsp"%>

<%@ include file="carousel.jsp"%>
<div class="container all-bg" style="padding-bottom:20px">
	<div class="row">
		<div class="col-sm-8">
			<div class="setup all-info">
				<div class="pro-header">
					<h4 class="pro-title pull-left">最新建馆</h4>
					<a href="###" class="more pull-right">更多&raquo;</a>
				</div>
				<div class="clearfix"></div>
				<div class="row">
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<a href="###" onclick="toShowHall('32');"><img src="${pageContext.request.contextPath}/static/images/slide1.png" alt="img"></a>
							<div class="caption">
								<a href="###"><h5>天束幽花</h5></a>
								<p><strong>在世：</strong>2016-2016</p>
								<p class="thumbnail-des text-justify"><strong>简介：</strong>上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感</p>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<a href="###" onclick="toShowHall('32');"><img src="${pageContext.request.contextPath}/static/images/ex.jpg" alt="img"></a>
							<div class="caption">
								<a href="###"><h5>天束幽花</h5></a>
								<p><strong>在世：</strong>2016-2016</p>
								<p class="thumbnail-des text-justify"><strong>简介：</strong>上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感</p>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<a href="###" onclick="toShowHall('32');"><img src="${pageContext.request.contextPath}/static/images/ex.jpg" alt="img"></a>
							<div class="caption">
								<a href="###"><h5>天束幽花</h5></a>
								<p><strong>在世：</strong>2016-2016</p>
								<p class="thumbnail-des text-justify"><strong>简介：</strong>上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="information arclist">
				<div class="pro-header">
					<h4 class="pro-title pull-left">缘园资讯</h4>
					<ul class="pull-right pro-header-tool hidden-xs">
					<c:forEach items="${columnChildList}" var="columnChild"> 
							<li class="pull-left"><a href="###" onclick="toInformationList('${columnChild.id }')">${columnChild.name }</a></li>
					</c:forEach>
						<!-- <li class="pull-left"><a href="###">宗教文化</a></li>
						<li class="pull-left"><a href="###">民间习俗</a></li>
						<li class="pull-left"><a href="###">祭祀礼仪</a></li>
						<li class="pull-left"><a href="###">孝道文化</a></li>
						<li class="pull-left"><a href="###">墓志铭</a></li>
						<li class="pull-left"><a href="###">祭文</a></li>
						<li class="pull-left"><a href="###">悼文</a></li> -->
					</ul>
				</div>
				<div class="row media">
					<div class="col-md-5 media-img">
						<a class="media-left" href="#"><img src="${pageContext.request.contextPath}/static/images/ex2.jpg" class="img-responsive" alt="img"></a>
					</div>
					<div class="col-md-7">
						<div class="media-body">
							<a href="###"><h5 class="media-heading">电影《爵迹》剧情简介</h5></a>
							<p>2017-1-1</p>
							<p class="arclist-des text-justify">传说中的神话奥汀大陆分为水、风、火、地四个国家，每个国家都有精通魂术的人，其中最厉害的七个被称为王爵。水国普通男孩麒零（陈学冬饰）离奇地被七度王爵银尘（吴亦凡饰）收为使徒，卷入了这场魂术的风暴。</p>
						</div>
					</div>
				</div>
				<div class="list">
					<ul>
						<li><a href="###" class="pull-left">宋人眼里荒唐离奇的北地胡风民俗</a><span class="list-date pull-right">2016-12-30</span></li>
						<li><a href="###" class="pull-left">齐鲁文化—鲁文化在中国上古文化中的地位</a><span class="list-date pull-right">2016-12-30</span></li>
						<li><a href="###" class="pull-left">全民阅读生肖民俗文化惠民活动 明天将在解放碑十字金街开幕</a><span class="list-date pull-right">2016-12-30</span></li>
						<li><a href="###" class="pull-left">全国百家媒体聚焦2016互联网+茶产业暨万里茶道武当道茶品牌推介活动</a><span class="list-date pull-right">2016-12-30</span></li>
						<li><a href="###" class="pull-left">《房陵锣鼓歌》出版 千古诗经民歌传唱至今深山传唱受赞誉</a><span class="list-date pull-right">2016-12-30</span></li>
					</ul>
				</div>
			</div>
			
			<div class="memorial arclist">
				<div class="pro-header">
					<h4 class="pro-title pull-left">最新祭奠推荐</h4>
					<ul class="pull-right pro-header-tool hidden-xs">
						<li class="pull-left"><a href="###">时间<span class="glyphicon glyphicon-arrow-up"></span></a></li>
						<li class="pull-left"><a href="###">热度<span class="glyphicon glyphicon-arrow-down"></span></a></li>
						<li class="pull-left"><a href="###">更多&raquo;</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
				<div class="list">
					<ul>
						<li><a href="###" class="pull-left">宋人眼里荒唐离奇的北地胡风民俗</a><span class="list-date pull-right">2016-12-30</span></li>
						<li><a href="###" class="pull-left">齐鲁文化—鲁文化在中国上古文化中的地位</a><span class="list-date pull-right">2016-12-30</span></li>
						<li><a href="###" class="pull-left">全民阅读生肖民俗文化惠民活动 明天将在解放碑十字金街开幕</a><span class="list-date pull-right">2016-12-30</span></li>
						<li><a href="###" class="pull-left">全国百家媒体聚焦2016互联网+茶产业暨万里茶道武当道茶品牌推介活动</a><span class="list-date pull-right">2016-12-30</span></li>
						<li><a href="###" class="pull-left">《房陵锣鼓歌》出版 千古诗经民歌传唱至今深山传唱受赞誉</a><span class="list-date pull-right">2016-12-30</span></li>
						<li><a href="###" class="pull-left">齐鲁文化—鲁文化在中国上古文化中的地位</a><span class="list-date pull-right">2016-12-30</span></li>
						<li><a href="###" class="pull-left">全民阅读生肖民俗文化惠民活动 明天将在解放碑十字金街开幕</a><span class="list-date pull-right">2016-12-30</span></li>
						<li><a href="###" class="pull-left">全民阅读生肖民俗文化惠民活动 明天将在解放碑十字金街开幕</a><span class="list-date pull-right">2016-12-30</span></li>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="col-sm-4 sidebar">
			<%@ include file="siteLogin.jsp"%>
			<br/>
			<%@ include file="siteSearch.jsp"%>
			<div class="notice">
				<%@ include file="notice.jsp"%>
			</div>
			
			<div class="recommend">
				<%-- --%>
				<%@ include file="recommend-index.jsp"%>
			</div>
		</div>
	</div>
</div>


<%@ include file="siteFooter.jsp"%>
<%@ include file="../../../common/footer-site.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/login.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/carousel.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/notice.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/index.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/information.js"></script>
<script type="text/javascript">
	var activeFlag = '首页';
	$('#index_li').addClass('active');
	//-------分页数据----------
	//var id = '${column_id }';
	//var totalPage = '${totalPage }';
	//var totalRecords = '${totalRecords }';
	// 项目路径
	var contextPath = '${pageContext.request.contextPath}';
	//-------分页数据----------	
</script>
</body>
</html>
