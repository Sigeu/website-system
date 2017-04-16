	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/keleyidivpager.css">
<title>纪念馆-列表页</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

	<%@ include file="page-pic.jsp"%>

	<div class="container all-bg">
		<div class="row memorial-tab">
			<div class="col-sm-4">
				<div class="memorial-pro">
					<div class="pro-header">
						<h4 class="pro-title pull-left">最新建馆</h4>
						<a href="###" class="more pull-right">更多&raquo;</a>
					</div>
					<div class="clearfix"></div>
					<div class="with-date">
						<ul>
							<c:forEach items="${listHallNew}" var="hall" varStatus="hallStatus"> 
								<li><a href="###" class="pull-left" onclick="toHallDetail('${hall.id }','${hall.hall_type }')">${hall.title}</a><span
									class="list-date pull-right">${fn:substring(hall.create_date, 0, 10)}</span></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="memorial-pro metorial-arc">
					<div class="pro-header">
						<h4 class="pro-title pull-left">最新文章</h4>
						<a href="###" class="more pull-right">更多&raquo;</a>
					</div>
					<div class="clearfix"></div>
					<div class="without-date">
						<ul>
							<c:forEach items="${listOrationNew}" var="oration" varStatus="orationStatus"> 
								<li><a href="###" onclick="toOrationDetail('${oration.id }')">${oration.title}</a></li>
							</c:forEach>
							<!-- <li><a href="###">宋人眼里荒唐离奇的北地胡风民俗</a></li>
							<li><a href="###">鬼山缝魂网上纪念馆鬼山缝魂网上纪念馆鬼山缝魂网上纪念馆</a></li>
							<li><a href="###">齐鲁文化—鲁文化在中国上古文化中的地位</a></li>
							<li><a href="###">全民阅读生肖民俗文化惠民活动 明天将在解放碑十</a></li>
							<li><a href="###">全国百家媒体聚焦2016互联网+茶产业暨万里茶道</a></li>
							<li><a href="###">《房陵锣鼓歌》出版 千古诗经民歌传唱至今深山传</a></li> -->
						</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="memorial-pro search-memorial">
					<div class="pro-header">
						<h4 class="pro-title pull-left">查找纪念馆</h4>
					</div>
					<div class="clearfix"></div>
					<div class="search-body">
						<form id="search_hall_form" action="#" method="post">
							<div class="form-group">
								<input type="text" class="form-control" name="hall_name"
									placeholder="请输入逝者姓名">
							</div>
							<button class="btn btn-warning" id="hall_but">查找纪念馆</button>
						</form>
						<dl>
							<dt>
								<a href="###"><h5>
										<span class="glyphicon glyphicon-question-sign"></span>常见问题
									</h5></a>
							</dt>
							<dd>方便新注册用户快速上手</dd>
						</dl>
						<dl>
							<dt>
								<a href="###"><h5>
										<span class="glyphicon glyphicon glyphicon-yen"></span>费用详解
									</h5></a>
							</dt>
							<dd>为您解答相应缴费策略</dd>
						</dl>
					</div>
				</div>
			</div>
		</div>
		<div class="img-list">
			<%@ include file="recommend.jsp"%>
		</div>
		<div class="all-info img-list">
			<div class="pro-header">
				<h4 class="pro-title pull-left">网上纪念馆</h4>
				<button class="btn btn-warning btn-xs btn-memorial" id="single_hall">单人馆</button>
				<button class="btn btn-warning btn-xs btn-memorial" id="double_hall">双人馆</button>
				<a href="###" class="more pull-right">更多&raquo;</a>
			</div>
			<div class="clearfix"></div>
				<div class="row" id="double_div" style="display:none"> 
				<c:forEach items="${listHallByOpenType}" var="hallOpen"> 
				<c:if test="${hallOpen.hall_type == '2'}">
	            	<div class="col-sm-4 col-md-3">
						<div class="thumbnail">
							<a href="###" onclick="toHallDetail('${hallOpen.id }','${hallOpen.hall_type }')"><img src="${hallOpen.img_index}" class="img-responsive"
								alt="img"></a>
							<div class="caption">
								<a href="###" onclick="toHallDetail('${hallOpen.id }','${hallOpen.hall_type }')"><h5>${hallOpen.title}</h5></a>
								<p>
									<strong>在世：</strong>2016-2016
								</p>
								<p class="thumbnail-des text-justify">
									<strong>简介：</strong>${hallOpen.description}
								</p>
							</div>
						</div>
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
					</c:if>
            </c:forEach> 
				</div>	
				 
                
			<div class="row" id="single_div"  style="block">
				<c:forEach items="${listHallByOpenType}" var="hallOpen"> 
				<c:if test="${hallOpen.hall_type == '1'}">
				<div class="row" id="double_div" style="display:none"> 
	            	<div class="col-sm-4 col-md-3">
						<div class="thumbnail">
							<a href="###" onclick="toHallDetail('${hallOpen.id }','${hallOpen.hall_type }')"><img src="${hallOpen.img_index}" class="img-responsive"
								alt="img"></a>
							<div class="caption">
								<a href="###" onclick="toHallDetail('${hallOpen.id }','${hallOpen.hall_type }')"><h5>${hallOpen.title}</h5></a>
								<p>
									<strong>在世：</strong>2016-2016
								</p>
								<p class="thumbnail-des text-justify">
									<strong>简介：</strong>${hallOpen.description}
								</p>
							</div>
						</div>
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
				 </c:if>
            </c:forEach> 
			</div>
		</div>
	</div>

	<%@ include file="siteFooter.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/hall.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/cemetery.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/article.js"></script>
	<script type="text/javascript">
		var activeFlag = '纪念馆';
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
