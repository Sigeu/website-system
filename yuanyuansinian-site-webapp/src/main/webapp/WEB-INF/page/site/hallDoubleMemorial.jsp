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
		<c:choose>  
		   <c:when test="${empty hallDouble.template_imgs}">
		   		<img src="${pageContext.request.contextPath}/static/images/incense-double5.jpg" class="img-responsive incense-bg incense-double hidden-xs" alt="incense">
		   </c:when>  
		   <c:otherwise>
		   		<img src="${hallDouble.template_imgs }" class="img-responsive incense-bg incense-double hidden-xs" alt="incense">
		   </c:otherwise>  
		</c:choose>
		<div class="monument-double">
			<c:choose>  
			   <c:when test="${empty hallDouble.img_head}">
			   		<img src="${pageContext.request.contextPath}/static/images/default.jpg"
				class="img-responsive incense-double-img pull-left" >
			   </c:when>  
			   <c:otherwise>
			   		<img src="${hallDouble.img_head }" class="img-responsive incense-double-img pull-left" >
			   </c:otherwise>  
			</c:choose>
			<span class="incense-double-l hidden-xs">${hallDouble.name }</span>
			<c:choose>  
			   <c:when test="${empty hallDouble.img_head2}">
			   		<img src="${pageContext.request.contextPath}/static/images/default.jpg"
				class="img-responsive incense-double-img incense-double-imgsec pull-right" >
			   </c:when>  
			   <c:otherwise>
			   		<img src="${hallDouble.img_head2 }" class="img-responsive incense-double-img incense-double-imgsec pull-right" >
			   </c:otherwise>  
			</c:choose>
			<span class="incense-double-r hidden-xs">${hallDouble.name2 }</span>
		</div>
		<!-- 贡品start -->
		<div class="tribute-list hidden-xs">
			<!-- 中间的香和香炉 start -->
			<div class="tribute-conmid">
				<!-- 中间的香 start -->
				<div class="tribute-conmid-fragrant">
					<c:forEach items="${listWarehouse}" var="warehouse" varStatus="warehouseStatus"> 
						<c:if test="${warehouse.put_type == '6' }">
							<c:choose>  
							   <c:when test="${empty warehouse.product_img}">
							   		<img src="${pageContext.request.contextPath}/static/images/x2.png"
								class="img-responsive tribute" >
							   </c:when>  
							   <c:otherwise>
							   		<!-- 贡品详细信息 start -->
									<div class="tribute-info">
										<img src="${pageContext.request.contextPath}/static/images/x2.png" onmouseover='showTooltip(this);' onmouseout='hideTooltip(this);' id='img0' class="img-responsive tribute">
										<ul class="tribute-info-des" id='tooltip0' >
											<li>名称：${warehouse.product_name}</li>
											<li>祭奠人：${warehouse.member_name}</li>
											<li>有效期：${warehouse.validity_day==null? '10': warehouse.validity_day}天</li>
										</ul>
									</div>
									<!-- 贡品详细信息 end -->
								    <img src="${warehouse.product_img}" class="img-responsive tribute">
							   </c:otherwise>  
							</c:choose> 
						</c:if>
					</c:forEach>
				</div>
				<!-- 中间的香 end -->
				
				<!-- 中间的香炉 start -->
				<c:forEach items="${listWarehouse}" var="warehouse" varStatus="warehouseStatus"> 
					<c:if test="${warehouse.put_type == '7'}">
						<c:choose>  
						   <c:when test="${empty warehouse.product_img}">
						   		<img src="${pageContext.request.contextPath}/static/images/burner1.png"
							class="img-responsive tribute" >
						   </c:when>  
						   <c:otherwise>
						   		<!-- 贡品详细信息 start -->
								<div class="tribute-info">
									<img src="${pageContext.request.contextPath}/static/images/x2.png" onmouseover='showTooltip(this);' onmouseout='hideTooltip(this);' id='img0' class="img-responsive tribute">
									<ul class="tribute-info-des" id='tooltip0' >
										<li>名称：${warehouse.product_name}</li>
										<li>祭奠人：${warehouse.member_name}</li>
										<li>有效期：${warehouse.validity_day==null? '10': warehouse.validity_day}天</li>
									</ul>
								</div>
								<!-- 贡品详细信息 end -->
							    <img src="${warehouse.product_img}" class="img-responsive tribute">
						   </c:otherwise>  
						</c:choose> 
					</c:if>
				</c:forEach>
				<!-- 中间的香炉 end -->
			</div>
			<!-- 中间的香和香炉 end -->
			
			<!-- 摆出的贡品左侧 start -->
			<div class="tribute-conl">
				
				<c:forEach items="${listWarehouse}" var="warehouse" varStatus="warehouseStatus"> 
					<c:if test="${warehouse.put_type == '1' }">
						<c:choose>  
						   <c:when test="${empty warehouse.product_img}">
						   		<img src="${pageContext.request.contextPath}/static/images/flower.png"
							class="img-responsive tribute" >
						   </c:when>  
						   <c:otherwise>
						   		<!-- 贡品详细信息 start -->
								<div class="tribute-info">
									<img src="${pageContext.request.contextPath}/static/images/x2.png" onmouseover='showTooltip(this);' onmouseout='hideTooltip(this);' id='img0' class="img-responsive tribute">
									<ul class="tribute-info-des" id='tooltip0' >
										<li>名称：${warehouse.product_name}</li>
										<li>祭奠人：${warehouse.member_name}</li>
										<li>有效期：${warehouse.validity_day==null? '10': warehouse.validity_day}天</li>
									</ul>
								</div>
								<!-- 贡品详细信息 end -->
							    <img src="${warehouse.product_img}" class="img-responsive tribute">
						   </c:otherwise>  
						</c:choose> 
					</c:if>
				</c:forEach>
					
			</div>
			<!-- 摆出的贡品左侧 end -->
			
			<!-- 摆出的贡品中间 start -->
			<div class="tribute-conmid-list">
				<c:forEach items="${listWarehouse}" var="warehouse" varStatus="warehouseStatus"> 
					<c:if test="${warehouse.put_type == '3' || warehouse.put_type == '4' || warehouse.put_type == '5'}">
						<c:choose>  
						   <c:when test="${empty warehouse.product_img}">
						   		<%-- <img src="${pageContext.request.contextPath}/static/images/flower.png"
							class="img-responsive tribute" > --%>
						   </c:when>  
						   <c:otherwise>
						   		<!-- 贡品详细信息 start -->
								<div class="tribute-info">
									<img src="${pageContext.request.contextPath}/static/images/x2.png" onmouseover='showTooltip(this);' onmouseout='hideTooltip(this);' id='img0' class="img-responsive tribute">
									<ul class="tribute-info-des" id='tooltip0' >
										<li>名称：${warehouse.product_name}</li>
										<li>祭奠人：${warehouse.member_name}</li>
										<li>有效期：${warehouse.validity_day==null? '10': warehouse.validity_day}天</li>
									</ul>
								</div>
								<!-- 贡品详细信息 end -->
							    <img src="${warehouse.product_img}" class="img-responsive tribute">
						   </c:otherwise>  
						</c:choose> 
					</c:if>
				</c:forEach>
			</div>
			<!-- 摆出的贡品中间 end -->
			
			<!-- 摆出的贡品右侧 start -->
			<div class="tribute-conr">
			
				<c:forEach items="${listWarehouse}" var="warehouse" varStatus="warehouseStatus"> 
						<c:if test="${warehouse.put_type == '2'}">
							<c:choose>  
							   <c:when test="${empty warehouse.product_img}">
							   		<img src="${pageContext.request.contextPath}/static/images/flower.png"
								class="img-responsive tribute" >
							   </c:when>  
							   <c:otherwise>
							   		<!-- 贡品详细信息 start -->
								<div class="tribute-info">
									<img src="${pageContext.request.contextPath}/static/images/x2.png" onmouseover='showTooltip(this);' onmouseout='hideTooltip(this);' id='img0' class="img-responsive tribute">
									<ul class="tribute-info-des" id='tooltip0' >
										<li>名称：${warehouse.product_name}</li>
										<li>祭奠人：${warehouse.member_name}</li>
										<li>有效期：${warehouse.validity_day==null? '10': warehouse.validity_day}天</li>
									</ul>
								</div>
								<!-- 贡品详细信息 end -->
								    <img src="${warehouse.product_img}" class="img-responsive tribute">
							   </c:otherwise>  
							</c:choose> 
						</c:if>
					</c:forEach>
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
		var hallId = "${hallDouble.id }";
		var hallType = "${hallDouble.hall_type }";
		var activeFlag = '纪念馆明细';
		//-------分页数据----------
		var id = '${column_id }';
		var totalPage = '${totalPage }';
		var totalRecords = '${totalRecords }';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
		//-------分页数据----------
		//供子页面调用关闭弹出页面
		function toClose(){
			layer.closeAll(); 
			window.location.href = contextPath + "/sinian/index/indexController/toMemberCenter";
		}
	</script>
</body>
</html>
