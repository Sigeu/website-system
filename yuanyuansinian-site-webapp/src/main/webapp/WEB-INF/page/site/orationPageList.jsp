<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/page/page.css">
<title>用户文章分页列表</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

	<%@ include file="page-pic.jsp"%>
	
	<div class="container con-tab all-bg">		
	<div class="info-list">
		<div class="pro-header">
			<h4 class="pro-title pull-left"><span class="hidden-xs">共<mark>${size }</mark>条</span></h4>
		</div>
		<div class="clearfix"></div>
		<div class="arclist info-list-body">
			
			<div class="search-list-con" id="demoContent">
				<%-- <c:forEach items="${listHallBySearch}" var="hall"> 
					<div class="search-pro">
						<a href="###"  onclick="toHallDetail('${hall.id }','${hall.hall_type }')"><h5>${hall.title }</h5></a>
						<p class="search-date">${fn:substring(hall.create_date, 0, 10)}</p>
						<p>${hall.description }</p>
					</div>
				</c:forEach> --%>
			</div>
		</div>
		<div class="page">
			<ul class="pagination" id="page">
			</ul>
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
		src="${pageContext.request.contextPath}/static/page/page.js"></script>
	<script type="text/javascript">
		var activeFlag = '搜索';
		//-------分页数据----------
		var id = '${column_id }';
		var totalPage = '${totalPage }';
		var totalRecords = '${totalRecords }';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
		//-------分页数据----------
	</script>
	<script type="text/javascript">
		var datas=[];
		var options={};
		$(function() {
			$.ajax({
				method : "POST",
				url : contextPath + "/sinian/index/indexController/orationForPage",
				data : {
					//id : '${column_id }'
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
			            cHtml += "<div class='search-pro'><a href='###'  onclick=\"toOrationDetail('" + result[i].id +"')\"><h5>"+ result[i].title + "</h5></a><p class='search-date'>" + result[i].create_date.substring(0,10) + "</p></div>";//处理数据
			        }
			        $("#demoContent").html(cHtml);//将数据增加到页面中
			    }
			};
				page.init(datas.length,1,options);
			});
			
				
		});
		   
		//查看内容
		function toOrationDetail(id) {
			url = contextPath + "/sinian/index/indexController/toOrationDetail?id=" + id;
			window.location.href = url;
		}
	</script>
</body>
</html>
