<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<title>内容信息表页</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>内容明细
		</nav>
	<div class="page-container">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">分类：</label>
			<div class="formControls col-xs-8 col-sm-9">
				商城产品
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">产品名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${product.name }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">简短标题：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${product.name_short }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">销售价格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${product.price_site }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">成本价格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${product.price_cost }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">最低价格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${product.price_min }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">计算单位：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${product.units }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">关键词：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${product.keywords }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">描述说明：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${product.description }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">排序值：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${product.no_order }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">产品封面：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<img src="${product.pic }" width="100px" heigth="100px"/>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">详细内容：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				${product.content }
			</div>
		</div>
		</br>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="close_but" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
</div>
<%@ include file="../../../common/footer_form.jsp"%>
<script type="text/javascript">
$(function(){
	//关闭
	$('#close_but').on('click', function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
		return false;
	});
});
</script>
</body>
</body>
</html>