<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css" />
<title>纪念馆新建</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>新增双人纪念馆
		</nav>

	<div class="container con-tab all-bg miss-con new-con">		
	<div class="pro-header">
		<h4 class="pro-title pull-left">缘园思念网创建纪念馆</h4>
	</div>
	<div class="clearfix"></div>
	<div class="new-body">
		<p class="new-notice text-justify"><span class="glyphicon glyphicon-star"></span>注意：缘园思念创建的纪念馆提供一个月的免费试用，之后您可以选择“5年300元”和“10年500元”的服务注意：缘园思念创建的纪念馆提供一个月的免费试用，之后您可以选择“5年300元”和“10年500元”的服务</p>
		<form class="form-horizontal" action="${pageContext.request.contextPath}/sinian/hall/hallController/addDoubleHall" method="post" id="form_">
			<div class="new-pro">
				<input type="hidden" name="hall_type" id="hall_type" value="2">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>纪念馆名称：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value="" placeholder="纪念馆名称" id="title" name="title">
					</div>
				</div>
				<p class="new-notice"><span class="glyphicon glyphicon-edit" style="margin-right:10px"></span>请填写双人馆第一人信息</p>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">真实姓名</label>
					<div class="col-sm-8 col-md-9">
						<input type="text" class="form-control" placeholder="请输入姓名" id="name" name="name">	
					</div>
				</div>
				 <div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">别名</label>
					<div class="col-sm-8 col-md-9">
						<input type="password" class="form-control" placeholder="请输入别名" id="alias" name="alias">	
					</div>
				</div>
				 <div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">性别</label>
					<div class="checkbox col-sm-8 col-md-9">
						<label><input type="radio"> 男</label>
						<label><input type="radio"> 女</label>
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">上传照片</label>
					<div class="col-sm-8 col-md-9">
						<input type="file" id="" class="form-control"style="border:0; box-shadow:none">
					</div>
				</div>
				 <div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">国籍</label>
					<div class="col-sm-8 col-md-9">
						<input type="text" class="form-control" placeholder="请输入国籍" id="nationality" name="nationality">	
					</div>
				</div>
				 <div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">民族</label>
					<div class="col-sm-8 col-md-9">
						<input type="password" class="form-control" placeholder="请输入民族" id="nation" name="nation">	
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">墓地地址</label>
					<div class="col-sm-8 col-md-9">
						<input type="text" class="form-control" placeholder="请输入墓地地址" id="address" name="address">	
					</div>
				</div>
				 <div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">信仰</label>
					<div class="col-sm-8 col-md-9">
						<input type="password" class="form-control" placeholder="请输入信仰" id="belief" name="belief">	
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">出生地</label>
					<div class="col-sm-8 col-md-9">
						<div class="col-sm-6 new-noleft">
							<select class="form-control">
								<option>山东省</option>
								<option>河北省</option>
								<option>黑龙江省</option>
								<option>江苏省</option>
								<option>陕西省</option>
							</select>	
						</div>
						<div class="col-sm-6 new-noright">
							<select class="form-control">
								<option>济南市</option>
								<option>青岛市</option>
								<option>临沂市</option>
								<option>潍坊市</option>
								<option>日照市</option>
							</select>	
						</div>
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">籍贯</label>
					<div class="col-sm-8 col-md-9">
						<div class="col-sm-6 new-noleft">
							<select class="form-control">
								<option>山东省</option>
								<option>河北省</option>
								<option>黑龙江省</option>
								<option>江苏省</option>
								<option>陕西省</option>
							</select>	
						</div>
						<div class="col-sm-6 new-noright">
							<select class="form-control">
								<option>济南市</option>
								<option>青岛市</option>
								<option>临沂市</option>
								<option>潍坊市</option>
								<option>日照市</option>
							</select>	
						</div>
					</div>
				</div>
				 <div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">主要成就</label>
					<div class="col-sm-8 col-md-9">
						<input type="password" class="form-control" placeholder="请输入主要成就" id="achievement" name="achievement">	
					</div>
				</div>
				<div class="clearfix"></div>
			</div>

			<div class="new-pro">
				<p class="new-notice"><span class="glyphicon glyphicon-edit" style="margin-right:10px"></span>请填写双人馆第二人信息</p>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">真实姓名</label>
					<div class="col-sm-8 col-md-9">
						<input type="text" class="form-control" placeholder="请输入姓名" id="name2" name="name2">	
					</div>
				</div>
				 <div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">别名</label>
					<div class="col-sm-8 col-md-9">
						<input type="password" class="form-control" placeholder="请输入别名" id="alias2" name="alias2">	
					</div>
				</div>
				 <div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">性别</label>
					<div class="checkbox col-sm-8 col-md-9">
						<label><input type="radio"> 男</label>
						<label><input type="radio"> 女</label>
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">上传照片</label>
					<div class="col-sm-8 col-md-9">
						<input type="file" id="" class="form-control"style="border:0; box-shadow:none">
					</div>
				</div>
				 <div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">国籍</label>
					<div class="col-sm-8 col-md-9">
						<input type="text" class="form-control" placeholder="请输入国籍" id="nationality2" name="nationality2">	
					</div>
				</div>
				 <div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">民族</label>
					<div class="col-sm-8 col-md-9">
						<input type="password" class="form-control" placeholder="请输入民族" id="nation2" name="nation2">	
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">墓地地址</label>
					<div class="col-sm-8 col-md-9">
						<input type="text" class="form-control" placeholder="请输入墓地地址" id="address2" name="address2">	
					</div>
				</div>
				 <div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">信仰</label>
					<div class="col-sm-8 col-md-9">
						<input type="password" class="form-control" placeholder="请输入信仰" id="belief2" name="belief2">	
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">出生地</label>
					<div class="col-sm-8 col-md-9">
						<div class="col-sm-6 new-noleft">
							<select class="form-control">
								<option>山东省</option>
								<option>河北省</option>
								<option>黑龙江省</option>
								<option>江苏省</option>
								<option>陕西省</option>
							</select>	
						</div>
						<div class="col-sm-6 new-noright">
							<select class="form-control">
								<option>济南市</option>
								<option>青岛市</option>
								<option>临沂市</option>
								<option>潍坊市</option>
								<option>日照市</option>
							</select>	
						</div>
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">籍贯</label>
					<div class="col-sm-8 col-md-9">
						<div class="col-sm-6 new-noleft">
							<select class="form-control">
								<option>山东省</option>
								<option>河北省</option>
								<option>黑龙江省</option>
								<option>江苏省</option>
								<option>陕西省</option>
							</select>	
						</div>
						<div class="col-sm-6 new-noright">
							<select class="form-control">
								<option>济南市</option>
								<option>青岛市</option>
								<option>临沂市</option>
								<option>潍坊市</option>
								<option>日照市</option>
							</select>	
						</div>
					</div>
				</div>
				 <div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">主要成就</label>
					<div class="col-sm-8 col-md-9">
						<input type="password" class="form-control" placeholder="请输入主要成就" id="achievement2" name="achievement2">	
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">是否公开</label>
					<div class="checkbox col-sm-8 col-md-9">
						<label><input type="radio"> 公开</label>
						<label><input type="radio"> 不公开</label>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			
			<div class="new-add">
				<input type="checkbox"><a href="###">阅读并同意缘园思念网服务条款</a>
				<div class="clearfix"></div>
				<button class="btn btn-warning">提交建馆</button>
			</div>
		</form>
	</div>
</div>
<div class="clearfix"></div
<%@ include file="../../../common/footer_form.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/ueditor/1.4.3/ueditor.config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/ueditor/1.4.3/ueditor.all.min.js"> </script>
<script type="text/javascript">
$(function(){
	//UE编辑器
	var ue = UE.getEditor('editor');

	$('#close_but').on('click', function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
		return false;
	});
	
});


//表单提交，可上传文件
$(function() {
	//表单验证
	$("#form-product-add").validate({
		rules:{
			title:{
				required:true,
				maxlength:100
			},
			no_order:{
				digits:true
			}
		},
		onkeyup:false,
		focusCleanup:false,
		success:"valid",
		submitHandler:function(form){
			var options = {
					success : function(data) {
						layer.alert(data.result_message, {
						  closeBtn: 1
						}, function(){
							//父页面刷新
							parent.window.location.reload();
							var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
							parent.layer.close(index); //再执行关闭
						});
					}
				};
				// 准备form表单
				$("#form-product-add").ajaxForm(options);
				// 表单提交     
				$("#form-product-add").ajaxSubmit(options);
				
				return false;
		}
	});
	
});
</script>
</body>
</body>
</html>