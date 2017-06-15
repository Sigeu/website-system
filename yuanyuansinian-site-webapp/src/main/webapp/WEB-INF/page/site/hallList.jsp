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
						<a href="#moreHall" class="more pull-right">更多&raquo;</a>
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
						<a href="${pageContext.request.contextPath}/sinian/index/indexController/toInformationList?id=130" class="more pull-right">更多&raquo;</a>
					</div>
					<div class="clearfix"></div>
					<div class="without-date">
						<ul>
							<c:forEach items="${listOrationNew}" var="oration" varStatus="orationStatus"> 
								<li><a href="###" onclick="toOrationDetail('${oration.id }')">${oration.title}</a></li>
							</c:forEach>
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
								<span>提示：可以通过纪念馆名称、纪念人姓名、纪念馆简短描述的关键词进行查找</span>
								<input type="text" class="form-control" name="hall_name"
									placeholder="请输入搜索关键词">
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
			<div class="pro-header" id="moreHall">
				<h4 class="pro-title pull-left">网上纪念馆</h4>
				<button class="btn btn-warning btn-xs btn-memorial" id="single_hall">单人馆</button>
				<button class="btn btn-warning btn-xs btn-memorial" id="double_hall">双人馆</button>
			</div>
			<div class="clearfix"></div>
			<div class="row" id="single_div" style="display: block"> 
				<c:forEach items="${listSingleHallByOpenType}" var="singleHall" varStatus="singleHallStatus"> 
					<c:if test="${singleHallStatus.index < 20 }">
	            	<div class="col-sm-4 col-md-3">
						<div class="thumbnail">
							<a href="###" onclick="toHallDetail('${singleHall.id }','${singleHall.hall_type }')">
							<c:choose>  
							   <c:when test="${empty singleHall.imgs}">
							   		<img src="${pageContext.request.contextPath}/static/images/default.jpg"
								class="img-responsive" >
							   </c:when>  
							   <c:otherwise>
								    <img src="${singleHall.imgs}" class="img-responsive" alt="${singleHall.title}">
							   </c:otherwise>  
							</c:choose> 
							
							</a>
							<div class="caption">
								<a href="###" onclick="toHallDetail('${singleHall.id }','${singleHall.hall_type }')"><h5>${singleHall.title}</h5></a>
								<p>
									<strong>在世：</strong>${singleHall.alive_date }
								</p>
								<p class="thumbnail-des text-justify">
									<strong>简介：</strong>${singleHall.description}
								</p>
							</div>
						</div>
					</div>
					</c:if>
            </c:forEach> 
            <div class="clearfix"></div>
            		<div class="page">
						<button class="btn btn-warning btn-xs btn-memorial" id="single_more">查看更多</button>
					</div>
				</div>	
				 
                
			<div class="row" id="double_div"  style="display:none">
				<c:forEach items="${listHallDoubleByOpenType}" var="hallDouble" varStatus="hallDoubleStatus"> 
					<c:if test="${hallDoubleStatus.index < 20 }">
	            	<div class="col-sm-4 col-md-3">
						<div class="thumbnail">
							<a href="###" onclick="toHallDetail('${hallDouble.id }','${hallDouble.hall_type }')">
							<c:choose>  
							   <c:when test="${empty hallDouble.imgs}">
							   		<img src="${pageContext.request.contextPath}/static/images/default.jpg"
								class="img-responsive" >
							   </c:when>  
							   <c:otherwise>
								    <img src="${hallDouble.imgs}" class="img-responsive" alt="${hallDouble.title}">
							   </c:otherwise>  
							</c:choose> 
							
								
							</a>
							<div class="caption">
								<a href="###" onclick="toHallDetail('${hallDouble.id }','${hallDouble.hall_type }')"><h5>${hallDouble.title}</h5></a>
								<p>
									<strong>在世：</strong>${hallDouble.alive_date }
								</p>
								<p class="thumbnail-des text-justify">
									<strong>简介：</strong>${hallDouble.description}
								</p>
							</div>
						</div>
					</div>
					</c:if>
            </c:forEach> 
            <div class="clearfix"></div>
            	<div class="page">
						<button class="btn btn-warning btn-xs btn-memorial" id="double_more">查看更多</button>
					</div>
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
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/oration.js"></script>
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
