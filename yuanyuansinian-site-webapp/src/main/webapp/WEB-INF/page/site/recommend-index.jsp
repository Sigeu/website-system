<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="pro-header">
	<h4 class="pro-title pull-left">公墓陵园推荐</h4>
	<a href="${pageContext.request.contextPath}/sinian/index/indexController/toCemeteryList" class="more pull-right">更多&raquo;</a>
</div>
<div class="clearfix"></div>
<div class="recommend-body">
	<c:forEach items="${cemeteryList}" var="cemetery" varStatus="cemeteryStatus"> 
		<c:if test="${cemeteryStatus.index < 4 }">
			<div class="thumbnail">
				<c:choose>  
				   <c:when test="${empty cemetery.imgs}">
				   		<img src="${pageContext.request.contextPath}/static/images/default.jpg"
					class="img-responsive" >
				   </c:when>  
				   <c:otherwise>
					    <img src="${cemetery.imgs}" class="img-responsive" alt="${cemetery.title}">
				   </c:otherwise>  
				</c:choose> 
				<div class="caption">
					<a href="###" onclick="toCemeteryDetail('${cemetery.id }')"><h5>${cemetery.title}</h5></a>
				</div>
			</div>
		</c:if>
	</c:forEach>
</div>
