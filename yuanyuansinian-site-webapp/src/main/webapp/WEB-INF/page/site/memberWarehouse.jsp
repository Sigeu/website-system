<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/keleyidivpager.css">
<title>我的思念-我的仓库</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>
	<div class="container con-tab miss">
		<%@ include file="memberInfo.jsp"%>
</div>

<div class="container con-tab all-bg miss-con">		
	<div class="row">
		<div class="col-sm-3">
			<div class="side-nav">
				<div class="pro-header">
					<h4>我的思念</h4>
				</div>
				<div class="side-nav-body">
					<ul>
						<li><a href="${pageContext.request.contextPath}/sinian/index/indexController/toMemberCreate">我的建馆</a></li>
						<li><a href="${pageContext.request.contextPath}/sinian/index/indexController/toMemberCart">我的购物车</a></li>
						<li class="active"><a href="${pageContext.request.contextPath}/sinian/index/indexController/toMemberWarehouse">我的仓库</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-sm-9">
			<div class="settlement">
				<c:forEach var="warehouse" items="${listWarehouse}">
					<div class="settlement-pro">
						<div class="col-sm-4 settlement-img"><a href="###" onclick="toShoppingDetail('${warehouse.product_id }')"><img src="${warehouse.product_img}" ></a></div>
						<div class="col-sm-8 settlement-info">
							<div class="settlement-title"><a href="###" onclick="toShoppingDetail('${warehouse.product_id }')">${warehouse.product_name}</a></div>
							<!-- 商品过期时间 start -->
							<div class="clearfix"></div>
							<span>有效期：${warehouse.validity_day==null? '10': warehouse.validity_day}天</span>
							<!-- 商品过期时间 end -->
							<div class="settlement-price">状态：${warehouse.use_status_name }</div>
							<c:choose>  
								   <c:when test="${empty sessionScope.memberUser}">
								   </c:when>  
								   <c:otherwise>
									   <button class="btn btn-danger pull-left" onclick="toDelete('${warehouse.id }')">删除</button>
								   </c:otherwise>  
								</c:choose>  
							<c:choose>  
							   <c:when test="${warehouse.use_status == '1'}">
							   </c:when>  
							   <c:otherwise>
								    <div class="shop-info pull-right"><input type="checkbox"  name="use_check" value="${warehouse.id }">勾选使用</div>
							   </c:otherwise>  
							</c:choose>  
						</div>
						<div class="clearfix"></div>
					</div>
                </c:forEach>
                <br>
                <div class="row cl">
					<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>纪念馆：</label>
					<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
						<select class="select" id="hall_id" name="hall_id">
							<option value="">--请选择--</option>  
		                    <c:forEach items="${listHallNew}" var="hall">  
		                    	<option value="${hall.id}">${hall.title}</option>  
		                    </c:forEach>  
						</select>
						</span> </div>
				</div>
				<button class="btn btn-danger pull-right settlement-btn" id="warehouse_use_but">使用</button>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
	<%@ include file="siteFooter.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/member.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/article.js"></script>
	<script type="text/javascript">
		var activeFlag = '我的思念';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
		//文本框输入事件,任何非正整数的输入都重置为1
		$("input[name='count_num']").blur(function(){
			$(this).val(this.value.replace(/[^\d]/g, 1).replace(/(\d{4})(?=\d)/g, "$1 "));
		});
		//删除
		function toDelete(id) {
			layer.confirm("确认要从仓库删除此物品吗？", {
				btn : [ '确认', '取消' ]
			//按钮
			}, function(index) {
				$.ajax({
					url : contextPath + '/sinian/warehouse/warehouseController/deleteWarehouse',
					type : "POST",
					dataType : "JSON",
					data : {
						id : id 
					},
					success : function(data) {
						layer.open({
							content : data.result_message,
							yes : function(index, layero) {
								window.location.reload();//刷新当前页面
								layer.close(index); //如果设定了yes回调，需进行手工关闭
							}
						});
					}
				});
			}, function(index) {
				layer.close(index);
			});
		}
	</script>
</body>
</html>
