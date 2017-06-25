<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
<title>纪念馆-模版选择</title>
</head>
<body>
	<!-- 模板选择弹出页 start -->
<div class="container template">
	<div class="pro-header">
		<h4 class="pro-title pull-left">模板选择</h4>
	</div>
	<div class="clearfix"></div>
	<div class="row">
		<c:forEach items="${singleTemplateImgList}" var="templateImg" varStatus="templateImgStatus"> 
			<div class="col-sm-4 col-md-3 template-pro">
				<div class="thumbnail">
					<c:choose>  
					   <c:when test="${empty templateImg.imgs}">
					   		<img src="${pageContext.request.contextPath}/static/images/incense2.jpg">
					   </c:when>  
					   <c:otherwise>
						    <img src="${templateImg.imgs}" alt="${templateImg.title}">
					   </c:otherwise>  
					</c:choose>
					<div class="caption">
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" value="${templateImg.id}">
								<span>${templateImg.title}</span>
							</label>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
		<%-- <div class="col-sm-4 col-md-3 template-pro">
			<div class="thumbnail">
				<img src="${pageContext.request.contextPath}/static/images/incense2.jpg" alt="template">
				<div class="caption">
					<div class="radio">
						<label>
							<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
							墓碑模板一
						</label>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-4 col-md-3 template-pro">
			<div class="thumbnail">
				<img src="${pageContext.request.contextPath}/static/images/incense3.jpg" alt="template">
				<div class="caption">
					<div class="radio">
						<label>
							<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
							墓碑模板二
						</label>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-4 col-md-3 template-pro">
			<div class="thumbnail">
				<img src="${pageContext.request.contextPath}/static/images/incense4.jpg" alt="template">
				<div class="caption">
					<div class="radio">
						<label>
							<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
							墓碑模板三
						</label>
					</div>
				</div>
			</div>
		</div><div class="col-sm-4 col-md-3 template-pro">
			<div class="thumbnail">
				<img src="${pageContext.request.contextPath}/static/images/incense5.jpg" alt="template">
				<div class="caption">
					<div class="radio">
						<label>
							<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
							墓碑模板四
						</label>
					</div>
				</div>
			</div>
		</div> --%>
	</div>
</div>
<!-- 模板选择弹出页 end -->
<%@ include file="../../../common/footer_form.jsp"%>
<script type="text/javascript">
	// 项目路径
	var contextPath = '${pageContext.request.contextPath}';
	function getSelected(){
		var value = $('input[name=optionsRadios]:checked').val();
		var text = $('input[name=optionsRadios]:checked + span').text();
		var templateImg = new Object();
		templateImg.id = value;
		templateImg.title = text;
		
		return templateImg;
	}
</script>
</body>
</html>