<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="myCarousel" class="carousel slide">
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
		<li data-target="#myCarousel" data-slide-to="3"></li>
		<li data-target="#myCarousel" data-slide-to="4"></li>
	</ol>
	<div class="carousel-inner">
		<c:forEach var="carousel" items="${carouselList}" varStatus="carouselStatus">
			<c:if test="${carouselStatus.index == 1}">
				<div class="item active" style="background: #aedef8">
					<img width="1600px" height="500px"
						src="${pageContext.request.contextPath}/sinian/carousel/carouselController/queryImgById?id=${carousel.id}"
						alt="${carousel.description}">
				</div>
			</c:if>
			<c:if test="${carouselStatus.index == 2}">
				<div class="item" style="background: #aedef8">
					<img width="1600px" height="500px"
						src="${pageContext.request.contextPath}/sinian/carousel/carouselController/queryImgById?id=${carousel.id}"
						alt="${carousel.description}">
				</div>
			</c:if>
			<c:if test="${carouselStatus.index == 3}">
				<div class="item" style="background: #aedef8">
					<img width="1600px" height="500px"
						src="${pageContext.request.contextPath}/sinian/carousel/carouselController/queryImgById?id=${carousel.id}"
						alt="${carousel.description}">
				</div>
			</c:if>
			<c:if test="${carouselStatus.index == 4}">
				<div class="item" style="background: #aedef8">
					<img width="1600px" height="500px"
						src="${pageContext.request.contextPath}/sinian/carousel/carouselController/queryImgById?id=${carousel.id}"
						alt="${carousel.description}">
				</div>
			</c:if>
			<c:if test="${carouselStatus.index == 5}">
				<div class="item" style="background: #aedef8">
					<img width="1600px" height="500px"
						src="${pageContext.request.contextPath}/sinian/carousel/carouselController/queryImgById?id=${carousel.id}"
						alt="${carousel.description}">
				</div>
			</c:if>
		</c:forEach>
	</div>
	<a href="#myCarousel" data-slide="prev" class="carousel-control left">
		<span class="glyphicon glyphicon-chevron-left"></span>
	</a>
	<a href="#myCarousel" data-slide="next" class="carousel-control right">
		<span class="glyphicon glyphicon-chevron-right"></span>
	</a>
</div>