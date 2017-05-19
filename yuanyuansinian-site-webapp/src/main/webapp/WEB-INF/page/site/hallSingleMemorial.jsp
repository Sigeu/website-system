<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<title>纪念馆-祭奠</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>
	
<div class="container incense">
	<div class="incense-body">
		<img src="${pageContext.request.contextPath}/static/images/incense.jpg" class="img-responsive incense-bg" alt="incense">
		
		<c:choose>  
		   <c:when test="${empty hall.imgs}">
		   		<img src="${pageContext.request.contextPath}/static/images/default.jpg"
			class="img-responsive" >
		   </c:when>  
		   <c:otherwise>
			    <img src="${hall.imgs }" class="img-responsive incense-img" >
		   </c:otherwise>  
		</c:choose>
			
		<c:forEach items="${listHallGift}" var="hallGift" varStatus="hallGiftStatus"> 
			<c:if test="${hallGift.product_type == 1 } ">
				<c:if test="${hallGift.product_position == 1 } ">
					<img src="${pageContext.request.contextPath}/static/images/flower.png" class="img-responsive flower-left"><!-- 左侧花 -->
				</c:if>
				<c:if test="${hallGift.product_position == 2 } ">
					<img src="${pageContext.request.contextPath}/static/images/flower.png" class="img-responsive flower-right"><!-- 右侧花 -->
				</c:if>
			</c:if>
			
			<c:if test="${hallGift.product_type == 2 } ">
				<img src="${pageContext.request.contextPath}/static/images/fragrant.png" class="img-responsive fragrant"><!-- 香 -->
			</c:if>
			
		</c:forEach>
						
		<%-- <img src="${pageContext.request.contextPath}/static/images/flower.png" class="img-responsive flower-left"><!-- 左侧花 -->
		<img src="${pageContext.request.contextPath}/static/images/flower.png" class="img-responsive flower-right"><!-- 右侧花 -->
		<img src="${pageContext.request.contextPath}/static/images/fragrant.png" class="img-responsive fragrant"><!-- 香 --> --%>
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
