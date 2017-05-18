<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="pro-header">
	<h4 class="pro-title pull-left">公墓陵园推荐</h4>
	<a href="###" class="more pull-right" onclick="toCemeteryList()">更多&raquo;</a>
</div>
<div class="clearfix"></div>
<div class="recommend-body">
	<c:forEach items="${cemeteryList}" var="cemetery" varStatus="cemeteryStatus"> 
		<c:if test="${cemeteryStatus.index < 4 }">
			<div class="thumbnail">
				<img src="${cemetery.imgs}"
					class="img-responsive" alt="img">
				<div class="caption">
					<a href="###" onclick="toCemeteryDetail('${cemetery.id }')"><h5>${cemetery.title}</h5></a>
				</div>
			</div>
		</c:if>
	</c:forEach>
</div>
