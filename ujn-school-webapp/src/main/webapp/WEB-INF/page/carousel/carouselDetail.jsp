<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<title>友情链接明细</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>友情链接详情
		</nav>
	<div class="page-container">
	<form action="#" method="post" class="form form-horizontal" id="form-link-detail">
		<input type="hidden" name="id" id="id" value="${link.id }" >
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>网站名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${link.web_name }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">网站URL：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${link.web_url }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">联系方式：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${link.contact }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">描述说明：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${link.info }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">排序值：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${link.order_no }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">缩略图：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<a href="###" onclick="toShowImg('${carousel.id }');return false;">
					<img width="200px" src="${pageContext.request.contextPath}/sinian/carousel/carouselController/queryImgById?id=${carousel.id }">
				</a>
			</div>
		</div> 
		</br>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="close_but" class="btn btn-default radius" type="button">&nbsp;&nbsp;返回&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="../../../common/footer_form.jsp"%>
<script type="text/javascript">
//表单提交，可上传文件
$(function() {
	//返回
	$('#close_but').on('click', function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
		return false;
	});
	
});

function toShowImg(id){
	layer.open({
	    type: 2,
	    maxmin:true,
	    title:["<strong><div class='Hui-iconfont Hui-iconfont-feedback2' style='color: white'>&nbsp;&nbsp;查看</div></strong>","background-color: #5a97df"],
	    area: ['100%', '100%'],
	    shadeClose: false, //点击遮罩关闭
	    content: '${pageContext.request.contextPath}/sinian/carousel/carouselController/showImg?id=' + id
	 });
}
</script>
</body>
</body>
</html>