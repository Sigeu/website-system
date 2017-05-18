<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<title>纪念馆-内容页</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>
	
	<div class="container all-bg museum">
		<div class="container all-bg museum">
	<div class="row museum-info">
		<div class="col-sm-4 col-md-3 museum-info-left">
			<img src="${hallDouble.imgs }" class="img-responsive" />
			<button class="btn btn-success" onclick="toShowDoubleMemorial('${hallDouble.id }')"><span class="hidden-sm hidden-md">缘园</span>祭奠</button>
			<!-- <button class="btn btn-info">纪念<span class="hidden-sm hidden-md">相</span>册</button>
			<button class="btn btn-warning">关注</button> -->
		</div>
		<div class="col-sm-8 col-md-9">
			<div class="pro-header">
				<h4 class="pro-title pull-left">基本信息</h4>
				<p class="pull-right museum-des hidden-xs">已经离开我们<mark>${hallDouble.days }</mark>天</p>
			</div>
			<div class="clearfix"></div>
			<div class="row museum-info-right">
				<div class="col-sm-6">
					<ul>
						<li><span class="pull-left">中文名：</span>${hallDouble.name }</li>
						<li><span class="pull-left">生日：</span>${hallDouble.birthday }</li>
						<li><span class="pull-left">国籍：</span>${hallDouble.nationality }</li>
						<li><span class="pull-left">出生地：</span>${hallDouble.birthplace }</li>
						<li><span class="pull-left">墓地地址：</span>${hallDouble.address }</li>
						<%-- <li><span class="pull-left">主要成就：</span>${hallDouble.achievement }</li> --%>
					</ul>
				</div>
				<div class="col-sm-6">
					<ul>
						<li><span class="pull-left">别名：</span>${hallDouble.alias }</li>
						<li><span class="pull-left">生肖：</span>${hallDouble.zodiac }</li>
						<li><span class="pull-left">民族：</span>${hallDouble.nation }</li>
						<li><span class="pull-left">籍贯：</span>${hallDouble.native_place }</li>
						<li><span class="pull-left">信仰：</span>${hallDouble.belief }</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row museum-info">
		<div class="col-sm-4 col-md-3 museum-info-left">
			<img src="${hallDouble.imgs }" class="img-responsive" />
			<button class="btn btn-success" onclick="toShowDoubleMemorial('${hallDouble.id }')"><span class="hidden-sm hidden-md">缘园</span>祭奠</button>
			<!-- <button class="btn btn-info">纪念<span class="hidden-sm hidden-md">相</span>册</button>
			<button class="btn btn-warning">关注</button> -->
		</div>
		<div class="col-sm-8 col-md-9">
			<div class="pro-header">
				<h4 class="pro-title pull-left">基本信息</h4>
				<p class="pull-right museum-des hidden-xs">已经离开我们<mark>${hallDouble.days }</mark>天</p>
			</div>
			<div class="clearfix"></div>
			<div class="row museum-info-right">
				<div class="col-sm-6">
					<ul>
						<li><span class="pull-left">中文名：</span>${hallDouble.name2 }</li>
						<li><span class="pull-left">国籍：</span>${hallDouble.nationality2 }</li>
						<li><span class="pull-left">出生地：</span>${hallDouble.birthplace2 }</li>
						<li><span class="pull-left">墓地地址：</span>${hallDouble.address2 }</li>
						<%-- <li><span class="pull-left">主要成就：</span>${hallDouble.achievement2 }</li> --%>
					</ul>
				</div>
				<div class="col-sm-6">
					<ul>
						<li><span class="pull-left">别名：</span>${hallDouble.alias2 }</li>
						<li><span class="pull-left">民族：</span>${hallDouble.nation2 }</li>
						<li><span class="pull-left">籍贯：</span>${hallDouble.native_place2 }</li>
						<li><span class="pull-left">信仰：</span>${hallDouble.belief2 }</li>
					</ul>
				</div>
			</div>
		</div>
	</div>

		<div class="museum-body">
			<div class="nav-title">
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#deeds"
						aria-controls="home" role="tab" data-toggle="tab">生平事迹</a></li>
					<li role="presentation"><a href="#anthology"
						aria-controls="profile" role="tab" data-toggle="tab">追忆文选</a></li>
					<li role="presentation"><a href="#message"
						aria-controls="profile" role="tab" data-toggle="tab">主要成就</a></li>
					<!-- <li role="presentation"><a href="#message"
						aria-controls="profile" role="tab" data-toggle="tab">追思留言</a></li>
					<li role="presentation"><a href="#album"
						aria-controls="profile" role="tab" data-toggle="tab">纪念册</a></li> -->
				</ul>
				<div class="btn-tools pull-right hidden-xs">
					<c:choose>  
					   <c:when test="${empty sessionScope.memberUser}">
					   		<button class="btn btn-danger" id="incense_but_nouser">上香</button>
							</li>
							<button class="btn btn-danger" id="tribute_but_nouser">贡品</button>
							</li>
							<button class="btn btn-danger" id="flowers_but_nouser">献花</button>
							</li>
							<button class="btn btn-danger" id="song_but_nouser">点歌</button>
							</li>
					   </c:when>  
					   <c:otherwise>
						   <button class="btn btn-danger" id="incense_but">上香</button>
							</li>
							<button class="btn btn-danger" id="tribute_but">贡品</button>
							</li>
							<button class="btn btn-danger" id="flowers_but">献花</button>
							</li>
							<button class="btn btn-danger" id="song_but">点歌</button>
							</li>
					   </c:otherwise>  
					</c:choose>  
				</div>
			</div>
			<div class="tab-content">
				<div class="tab-pane active" id="deeds">
					<!-- 生平事迹，也就是文章内容模板start -->
					<div class="article-body">
						<p>${hallDouble.life_story }</p>
					</div>
					<!-- end -->
				</div>

				<div class="row tab-pane" id="anthology">
					<!-- 追忆文选和追思留言的列表都使用这个模板start -->
					<div class="article-body anthology-body">
						<c:forEach items="${listOration}" var="oration" varStatus="orationStatus"> 
							<div class="anthology-pro">
								<a href="###" onclick="toOrationDetail('${oration.id}');"><h5>${oration.title}</h5></a>
								<span class="anthology-date">${oration.create_date}</span>
								<div class="anthology-des text-justify">${oration.description}</div>
							</div>
						</c:forEach>
					</div>
					<div class="page">
						<ul class="pagination">
							<li><a href="#" aria-label="Previous"><span
									aria-hidden="true">&laquo;</span></a></li>
							<li><a href="#">1</a></li>
							<li><a href="#" aria-label="Next"><span
									aria-hidden="true">&raquo;</span></a></li>
						</ul>
					</div>
					<!-- end -->
				</div>
				
				<div class="tab-pane" id="message">
					<!-- 生平事迹，也就是文章内容模板start -->
					<div class="article-body">
						<p>${hallDouble.achievement }</p>
					</div>
					<!-- end -->
				</div>
			</div>
		</div>
	</div>


	<%@ include file="siteFooter.jsp"%>

	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/hallDetail.js"></script>
	<script type="text/javascript">
		var activeFlag = '纪念馆明细';
		var hallType = "2";
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
