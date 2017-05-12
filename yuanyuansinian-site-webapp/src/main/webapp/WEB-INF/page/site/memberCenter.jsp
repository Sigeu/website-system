<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/keleyidivpager.css">
<title>我的思念-内容页</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>
	<div class="container con-tab miss">
	<div class="col-sm-3 miss-ico">
		<img src="${pageContext.request.contextPath}/static/images/ex3.jpg" class="img-responsive" alt="img" />
	</div>
	<div class="col-sm-9">
		<%@ include file="memberInfo.jsp"%>
	</div>
</div>
	<div class="container con-tab all-bg miss-con">		
	<div class="row">
		<div class="col-sm-3">
			<div class="side-nav">
				<div class="pro-header">
					<h4>我的思念</h4>
				</div>
				<div class="side-nav-body">
					<ul>
						<li><a href="${pageContext.request.contextPath}/sinian/index/indexController/toMemberCart">我的购物车</a></li>
						<li class="active"><a href="${pageContext.request.contextPath}/sinian/index/indexController/toMemberCreate">我的创建</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-sm-9">
			<div class="nav-title">
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#setup" aria-controls="home" role="tab" data-toggle="tab">我的建馆</a></li>
					<li role="presentation"><a href="#visit" aria-controls="profile" role="tab" data-toggle="tab">我的访问记录</a></li>
					<li role="presentation"><a href="#release" aria-controls="profile" role="tab" data-toggle="tab">我的发布</a></li>
				</ul>
			</div>
			<div class="clearfix"></div>
			<div class="tab-content">
				<div class="tab-pane active img-list shop-list miss-setup" id="setup">
					<c:forEach items="${listHall}" var="hall" varStatus="hallStatus"> 
							<div class="row miss-setup-pro">
								<div class="col-sm-4 col-md-3">
									<a href="###"  onclick="toHallDetail('${hall.id }','${hall.hall_type }')"><img src="${hall.imgs}" class="img-responsive" alt="${hall.title}" /></a>
								</div>
								<div class="col-sm-8 col-md-9">
									<a href="###"  onclick="toHallDetail('${hall.id }','${hall.hall_type }')"><h5>${hall.title}</h5></a>
									<p><strong>创建日期：</strong>${hall.create_date}</p>
									<div class="miss-des text-justify"><strong>简介：</strong>${hall.description}</div>
								</div>
								<div class="clearfix"></div>
							</div>
						</c:forEach>
				</div>
				
				<div class="tab-pane img-list shop-list miss-list" id="visit">
					<div class="list">
						<ul>
							<li><a href="###" class="pull-left">访问记录...更新中</a><span class="list-date pull-right">2016-12-30</span></li>
						</ul>
					</div>
					<div class="clearfix"></div>
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
				<div class="tab-pane img-list shop-list miss-list" id="release">
					<div class="list">
						<ul>
							<c:forEach items="${listOration}" var="oration" varStatus="orationStatus"> 
								<li><a href="###" class="pull-left" onclick="toOrationDetail('${oration.id}');">${oration.title}</a><span class="list-date pull-right">${oration.create_date}</span></li>
							</c:forEach>
							<!-- <li><a href="###" class="pull-left">在这个位置打开相应的文章页</a><span class="list-date pull-right">2016-12-30</span></li>
							<li><a href="###" class="pull-left">在这个位置打开相应的文章页在这个位置打开相应的文章页</a><span class="list-date pull-right">2016-12-30</span></li>
							<li><a href="###" class="pull-left">在这个位置打开相应的文章页 在这个位置打开相应的文章页</a><span class="list-date pull-right">2016-12-30</span></li>
							<li><a href="###" class="pull-left">在这个位置打开相应的文章页+在这个位置打开相应的文章页</a><span class="list-date pull-right">2016-12-30</span></li>
							<li><a href="###" class="pull-left">在这个位置打开相应的文章页 在这个位置打开相应的文章页</a><span class="list-date pull-right">2016-12-30</span></li>
							<li><a href="###" class="pull-left">在这个位置打开相应的文章页</a><span class="list-date pull-right">2016-12-30</span></li>
							<li><a href="###" class="pull-left">在这个位置打开相应的文章页</a><span class="list-date pull-right">2016-12-30</span></li>
							<li><a href="###" class="pull-left">在这个位置打开相应的文章页</a><span class="list-date pull-right">2016-12-30</span></li>
							<li><a href="###" class="pull-left">在这个位置打开相应的文章页 在这个位置打开相应的文章页</a><span class="list-date pull-right">2016-12-30</span></li>
							<li><a href="###" class="pull-left">在这个位置打开相应的文章页+在这个位置打开相应的文章页</a><span class="list-date pull-right">2016-12-30</span></li>
							<li><a href="###" class="pull-left">在这个位置打开相应的文章页 在这个位置打开相应的文章页</a><span class="list-date pull-right">2016-12-30</span></li>
							<li><a href="###" class="pull-left">在这个位置打开相应的文章页</a><span class="list-date pull-right">2016-12-30</span></li> -->
						</ul>
					</div>
					<div class="clearfix"></div>
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
				
				<!-- <div class="tab-pane img-list shop-list miss-list" id="release">
					文章内容开始
					<div class="article">
						<div class="article-top">
							<h1>清明节 （中华民族的传统节日）</h1>
							<div class="article-info">
								<span>2016年12月30日</span><span>作者：Admin </span><span class="hidden-xs">浏览次数：121018</span>
							</div>
						</div>
						<div class="article-body">
							<p>清明节又叫踏青节，在仲春与暮春之交，也就是冬至后的第108天。是中国传统节日，也是最重要的祭祀节日之一，是祭祖和扫墓的日子。中华民族传统的清明节大约始于周代，距今已有二千五百多年的历史。</p>
							<p>清明最早只是一种节气的名称， 其变成纪念祖先的节日与寒食节有关。 晋文公把寒食节的后一天定为清明节。 在山西大部分地区是在清明节前一天过寒食节；榆社县等地是在清明节前两天过寒食节；垣曲县还讲究清明节前一天为寒食节，前二天为小寒食。</p>
							<p>相传春秋时期，晋公子重耳为逃避迫害而流亡国外，流亡途中，在一处渺无人烟的地方，又累又饿，再也无力站起来。随臣找了半天也找不到一点吃的，正在大家万分焦急的时候，随臣介子推走到僻静处，从自己的大腿上割下了一块肉，煮了一碗肉汤让公子喝了，重耳渐渐恢复了精神，当重耳发现肉是介子推自己腿割下的时候，流下了眼泪。</p>
							<p><img src="images/ex3.jpg" class="img-responsive" alt="img"></p>
							<p>清明节又叫踏青节，在仲春与暮春之交，也就是冬至后的第108天。是中国传统节日，也是最重要的祭祀节日之一，是祭祖和扫墓的日子。中华民族传统的清明节大约始于周代，距今已有二千五百多年的历史。</p>
						</div>
					</div>
					文章内容结束
				</div> -->
			</div>
		</div>
	</div>
</div>
	<%@ include file="siteFooter.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/member.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/oration.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/article.js"></script>
	<script type="text/javascript">
		var activeFlag = '我的思念';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
	</script>
</body>
</html>
