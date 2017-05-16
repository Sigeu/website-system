<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/keleyidivpager.css">
<title>公墓陵园-列表页</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

	<%@ include file="page-pic.jsp"%>

	<div class="container all-bg">
		<div class="row">
			<div class="col-sm-8">
				<div class="setup all-info">
					<div class="pro-header">
						<h4 class="pro-title pull-left">公墓陵园推荐</h4>
						<!-- <a href="###" class="more pull-right">更多&raquo;</a> -->
					</div>
					<div class="clearfix"></div>
					<div class="nav-title">
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#areaA"
								aria-controls="home" role="tab" data-toggle="tab">墓园A区</a></li>
							<li role="presentation"><a href="#areaB"
								aria-controls="profile" role="tab" data-toggle="tab">墓园B区</a></li>
							<li role="presentation"><a href="#areaC"
								aria-controls="profile" role="tab" data-toggle="tab">墓园C区</a></li>
							<li role="presentation"><a href="#areaD"
								aria-controls="profile" role="tab" data-toggle="tab">墓园D区</a></li>
							<li role="presentation"><a href="#areaE"
								aria-controls="profile" role="tab" data-toggle="tab">墓园E区</a></li>
						</ul>
						<ul
							class="pull-right pro-header-tool hidden-xs hidden-sm nav-title-tool">
							<!-- <li class="pull-left"><a href="###">时间<span
									class="glyphicon glyphicon-arrow-up"></span></a></li>
							<li class="pull-left"><a href="###">热度<span
									class="glyphicon glyphicon-arrow-down"></span></a></li>
							<li class="pull-left"><a href="###">更多&raquo;</a></li> -->
						</ul>
					</div>
					<div class="tab-content">
						<div class="row tab-pane active" id="areaA">
						<c:forEach items="${cemeteryListA}" var="cemeteryA">  
	                    	<div class="col-sm-6 col-md-4">
								<div class="thumbnail">
									<a href="###" onclick="toCemeteryDetail('${cemeteryA.id}')"><img src="${cemeteryA.imgs}" alt="${cemeteryA.title}"></a>
									<div class="caption">
										<a href="###"  onclick="toCemeteryDetail('${cemeteryA.id}')"><h5>${cemeteryA.title}</h5></a>
										<p>
											<strong>价格：</strong>面议
										</p>
										<p class="thumbnail-des text-justify">
											<strong>简介：</strong>${cemeteryA.description}
										</p>
									</div>
								</div>
							</div> 
	                    </c:forEach> 
							<div class="clearfix"></div>
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

						<div class="row tab-pane" id="areaB">
							<c:forEach items="${cemeteryListB}" var="cemeteryB">  
		                    	<div class="col-sm-6 col-md-4">
									<div class="thumbnail">
										<a href="###"  onclick="toCemeteryDetail('${cemeteryB.id}')"><img src="${cemeteryB.imgs}" alt="${cemeteryB.title}"></a>
										<div class="caption">
											<a href="###"  onclick="toCemeteryDetail('${cemeteryB.id}')"><h5>${cemeteryB.title}</h5></a>
											<p>
												<strong>价格：</strong>面议
											</p>
											<p class="thumbnail-des text-justify">
												<strong>简介：</strong>${cemeteryB.description}
											</p>
										</div>
									</div>
								</div> 
		                    </c:forEach> 
							<div class="clearfix"></div>
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

						<div class="row tab-pane" id="areaC">
							<c:forEach items="${cemeteryListC}" var="cemeteryC">  
		                    	<div class="col-sm-6 col-md-4">
									<div class="thumbnail">
										<a href="###"  onclick="toCemeteryDetail('${cemeteryC.id}')"><img src="${cemeteryC.imgs}" alt="${cemeteryC.title}"></a>
										<div class="caption">
											<a href="###"  onclick="toCemeteryDetail('${cemeteryC.id}')"><h5>${cemeteryC.title}</h5></a>
											<p>
												<strong>价格：</strong>面议
											</p>
											<p class="thumbnail-des text-justify">
												<strong>简介：</strong>${cemeteryC.description}
											</p>
										</div>
									</div>
								</div> 
		                    </c:forEach> 
							<div class="clearfix"></div>
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

						<div class="row tab-pane" id="areaD">
							<c:forEach items="${cemeteryListD}" var="cemeteryD">  
		                    	<div class="col-sm-6 col-md-4">
									<div class="thumbnail">
										<a href="###" onclick="toCemeteryDetail('${cemeteryD.id}')"><img src="${cemeteryD.imgs}" alt="${cemeteryD.title}"></a>
										<div class="caption">
											<a href="###" onclick="toCemeteryDetail('${cemeteryD.id}')"><h5>${cemeteryD.title}</h5></a>
											<p>
												<strong>价格：</strong>面议
											</p>
											<p class="thumbnail-des text-justify">
												<strong>简介：</strong>${cemeteryD.description}
											</p>
										</div>
									</div>
								</div> 
		                    </c:forEach> 
							<div class="clearfix"></div>
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

						<div class="row tab-pane" id="areaE">
							<c:forEach items="${cemeteryListE}" var="cemeteryE">  
		                    	<div class="col-sm-6 col-md-4">
									<div class="thumbnail">
										<a href="###" onclick="toCemeteryDetail('${cemeteryE.id}')"><img src="${cemeteryE.imgs}" alt="${cemeteryE.title}"></a>
										<div class="caption">
											<a href="###" onclick="toCemeteryDetail('${cemeteryE.id}')"><h5>${cemeteryE.title}</h5></a>
											<p>
												<strong>价格：</strong>面议
											</p>
											<p class="thumbnail-des text-justify">
												<strong>简介：</strong>${cemeteryE.description}
											</p>
										</div>
									</div>
								</div> 
		                    </c:forEach> 
							<div class="clearfix"></div>
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

			<div class="col-sm-4 sidebar">
				<%@ include file="siteLogin.jsp"%>
				<div class="notice">
					<%@ include file="notice.jsp"%>
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
		src="${pageContext.request.contextPath}/static/js/notice.js"></script>
		<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/cemetery.js"></script>
	<script type="text/javascript">
		var activeFlag = '公墓陵园';
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
