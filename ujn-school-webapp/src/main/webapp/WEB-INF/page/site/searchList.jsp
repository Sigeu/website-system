<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/page/page.css">
<title>搜索列表</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

	<%@ include file="page-pic.jsp"%>

	<div class="article all-con">
		<div class="container">
			<div class="row">
				<div class="col-md-9 article-sidebarl list-sidebarl list-sidebarr">
					<div class="list search-list">
						<div class="pro-top">
							<h4 class="pull-left">站内搜索：关键字“<span>${search_text }</span>”</h4>
						</div>
						<div class="clearfix"></div>
						<div class="search-list-con"  id="demoContent">
							<%-- <c:forEach var="content" items="${contentList}">
								<div class="search-pro">
									<a href="###" onclick="toContentDetail('${content.id}');"><h5>${content.title}</h5></a>
									<p class="search-date">${content.add_time}</p>
									<p>${content.description}</p>
								</div>
							</c:forEach> --%>
						</div>
					</div>
					<nav class="page">
					<ul class="pagination">
						<div id="div_pager"></div>
					</ul>
					</nav>
				</div>
				<%@ include file="articleListSidebar.jsp"%>
			</div>
		</div>
	</div>
	<input type="hidden" name="id" id="id_" value="${column_id }">
	<%@ include file="siteFooter.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/keleyidivpager.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/article.pager.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/article.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/nav.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/page/page.js"></script>
	<script type="text/javascript">
		//-------分页数据----------
		var id = '${column_id }';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
		//-------分页数据----------
		var serach_text = '${search_text }';
		var datas=[];
		var options={};
		$(function() {
			$.ajax({
				method : "POST",
				url : contextPath + "/index/controller/indexController/searchForPage",
				data : {
					serach_text : serach_text
				}
			}).done(function(data) {
				datas = data;
				options={
				"id":"page",//显示页码的元素
				"data":datas,//显示数据
			    "maxshowpageitem":5,//最多显示的页码个数
			    "pagelistcount":10,//每页显示数据个数
			    "callBack":function(result){
			    	var cHtml="";
			        for(var i=0;i<result.length;i++){
			        	//处理数据
			            cHtml += "<div class='search-pro'><a href='###'  onclick=\"toContentDetail('" + result[i].id +"')\"><h5>"+ result[i].title + "</h5></a>" +
			            "<p class='search-date'>" + toString(result[i].update_time) + "</p>" +
					    "<p>" + toString(result[i].description) + "</p>" +
			            "</div>";
			        }
			        $("#demoContent").html(cHtml);//将数据增加到页面中
			    }
			};
				page.init(datas.length,1,options);
			});
			
				
		});
	</script>
</body>
</html>
