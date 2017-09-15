<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header-site.jsp"%>
<title>信息公开申请</title>
</head>
<body class="pos-r">
<%@ include file="siteHeader.jsp"%>

<%@ include file="page-pic.jsp"%>

<div class="article all-con cat-con">
	<div class="container">
			<ul class="tabBar nav nav-tabs">
				<li class="active" id="li102"><a href="#column102" style="border-bottom-color: transparent; margin-bottom:0">校务公开</a></li>
				<li class="" id="li107"><a href="#column107">党务公开</a></li>
			</ul>
			<div class="cat-list" id="column102" style="display:block">
				<c:forEach var="column" items="${columnList102}">
						<div class="cat-pro">
							<p>${column.name }</p>
							<c:forEach var="column3" items="${columnList3}">
								<c:if test="${column3.big_class == column.id}">
									<li><a href="###" onclick="toContentListForLevel3('${column3.id}');" ><span class="glyphicon glyphicon-menu-right"></span>${column3.name }</a></li>
								</c:if>
							</c:forEach>
							<div class="clearfix"></div>
						</div>
				</c:forEach>
			</div>
			
			<div class="cat-list" id="column107" style="display:none">
				<c:forEach var="column" items="${columnList107}">
						<div class="cat-pro">
							<p>${column.name }</p>
							<c:forEach var="column3" items="${columnList3}">
								<c:if test="${column3.big_class == column.id}">
									<li><a href="###" onclick="toContentListForLevel3('${column3.id}');" ><span class="glyphicon glyphicon-menu-right"></span>${column3.name }</a></li>
								</c:if>
							</c:forEach>
							<div class="clearfix"></div>
						</div>
				</c:forEach>
			</div>
	</div>

</div>


<%@ include file="siteFooter.jsp"%>

<%@ include file="../../../common/footer-site.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript">
//栏目ID
var column_id = "${column_id}";
var contextPath = "${pageContext.request.contextPath}";
var id = '${column_id }';
var totalPage = '${totalPage }';
var totalRecords = '${totalRecords }';
//
$(function() {
	//直接点击的菜单
	if(column_id == '102'){
		//$('#li102').trigger('mouseover');
		$('#column102').show();
		$('#column107').hide();
		$('#li102').addClass('active');
		$('#li107').removeClass('active');
	}
	if(column_id == '107'){
		$('#column107').show();
		$('#column102').hide();
		$('#li107').addClass('active');
		$('#li102').removeClass('active');
	}
	//点击菜单默认显示
	if(column_id == '111'){
		$('#column102').show();
		$('#column107').hide();
		$('#li102').addClass('active');
		$('#li107').removeClass('active');
	}
	//鼠标移上
	$('#li102').mouseover(function(){
		$('#column102').show();
		$('#column107').hide();
		$('#li107').removeClass('active');
		$('#li102').addClass('active');
		
	});
	
	$('#li107').mouseover(function(){
		$('#column107').show();
		$('#column102').hide();
		$('#li102').removeClass('active');
		$('#li107').addClass('active');
		
	});
	
});
</script>
</body>
</body>
</html>