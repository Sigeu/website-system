<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
<title>纪念馆-灵堂祭奠</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

<div class="container incense">
	<div class="incense-body">
		<c:choose>  
		   <c:when test="${empty hall.template_imgs}">
		   		<img src="${pageContext.request.contextPath}/static/images/incense5.jpg" class="img-responsive incense-bg" alt="incense">
		   </c:when>  
		   <c:otherwise>
			    <img src="${hall.template_imgs }" class="img-responsive incense-bg" >
		   </c:otherwise>  
		</c:choose>
		<div class="monument">
			<c:choose>  
			   <c:when test="${empty hall.imgs}">
			   		<img src="${pageContext.request.contextPath}/static/images/default.jpg"
				class="img-responsive incense-img" >
			   </c:when>  
			   <c:otherwise>
				    <img src="${hall.imgs }" class="img-responsive incense-img" >
			   </c:otherwise>  
			</c:choose>
			<span class="hidden-xs">${hall.name }</span>
		</div>
		<!-- 贡品start -->
		<div class="tribute-list hidden-xs">
			<!-- 中间的香和香炉 start -->
			<div class="tribute-conmid">
				<!-- 中间的香 start -->
				<%-- <c:forEach items="${listWarehouse}" var="warehouse" varStatus="warehouseStatus"> 
					<c:if test="${warehouseStatus.index == 0 }">
						<c:choose>  
						   <c:when test="${empty warehouse.product_img}">
						   		<img src="${pageContext.request.contextPath}/static/images/flower.png"
							class="img-responsive flower-left" >
						   </c:when>  
						   <c:otherwise>
							    <img src="${warehouse.product_img}" class="img-responsive flower-left">
						   </c:otherwise>  
						</c:choose> 
					</c:if>
				</c:forEach> --%>
				<div class="tribute-conmid-fragrant">
					<img src="${pageContext.request.contextPath}/static/images/x2.png" class="img-responsive tribute">
					<img src="${pageContext.request.contextPath}/static/images/x2.png" class="img-responsive tribute">
					<img src="${pageContext.request.contextPath}/static/images/x2.png" class="img-responsive tribute">
				</div>
				<!-- 中间的香 end -->
				<img src="${pageContext.request.contextPath}/static/images/burner1.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/burner1.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/burner1.png" class="img-responsive tribute">
			</div>
			<!-- 中间的香和香炉 end -->
			
			<!-- 摆出的贡品左侧 start -->
			<div class="tribute-conl">
				<img src="${pageContext.request.contextPath}/static/images/mt3.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/mt4.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/j3.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/qc4.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/kst4.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/y2.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/zy2.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/zy4.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/x12.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/kst4.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/y2.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/zy2.png" class="img-responsive tribute">
			</div>
			<!-- 摆出的贡品左侧 end -->
			
			<!-- 摆出的贡品中间 start -->
			<div class="tribute-conmid-list">
				<img src="${pageContext.request.contextPath}/static/images/mt3.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/mt4.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/j3.png" class="img-responsive tribute">
			</div>
			<!-- 摆出的贡品中间 end -->
			
			<!-- 摆出的贡品右侧 start -->
			<div class="tribute-conr">
				<img src="${pageContext.request.contextPath}/static/images/mt3.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/mt4.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/j3.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/qc4.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/kst4.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/y2.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/zy2.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/zy4.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/x12.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/kst4.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/y2.png" class="img-responsive tribute">
				<img src="${pageContext.request.contextPath}/static/images/zy2.png" class="img-responsive tribute">
			</div>
			<!-- 摆出的贡品右侧 end -->
		</div>
		<!-- 贡品end -->
		<div class="incense-btn">
			<c:choose>  
			   <c:when test="${empty sessionScope.memberUser}">
			   		<button class="btn btn-danger" id="incense_but_nouser">上香</button>
					<button class="btn btn-danger" id="tribute_but_nouser">贡品</button>
					<button class="btn btn-danger" id="flowers_but_nouser">献花</button>
					<button class="btn btn-danger" id="song_but_nouser">点歌</button>
			   </c:when>  
			   <c:otherwise>
				    <button class="btn btn-danger" id="incense_but">上香</button>
					<button class="btn btn-danger" id="tribute_but">贡品</button>
					<button class="btn btn-danger" id="flowers_but">献花</button>
					<button class="btn btn-danger" id="song_but">点歌</button>
			   </c:otherwise>  
			</c:choose>  
		</div>
	</div>
</div>


	<%@ include file="siteFooter.jsp"%>

	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/hallDetail.js"></script>
	<script type="text/javascript">
		var hallId = "${hall.id }";
		var hallType = "${hall.hall_type }";
		var activeFlag = '纪念馆明细';
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
