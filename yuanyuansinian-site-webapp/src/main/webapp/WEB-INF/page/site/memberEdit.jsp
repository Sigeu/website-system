<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link href="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<title>内容列表</title>
</head>
<body>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<div class="container con-tab all-bg miss-con new-con">
		<div class="new-body">
			<form class="form-horizontal"
				action="${pageContext.request.contextPath}/sinian/member/memberController/updateMember"
				method="post" id="form_">
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3"><span class="c-red">*</span>真实姓名</label>
					<div class="col-sm-8 col-md-9">
						<input type="text" value="${memberUser.real_name}" name="real_name" id="real_name"
							class="form-control" placeholder="请输入姓名">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3"><span class="c-red">*</span>昵称</label>
					<div class="col-sm-8 col-md-9">
						<input type="text" value="${memberUser.member_name}" name="member_name" id="member_name"
							class="form-control" placeholder="请输入别名">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">性别</label>
					<div class="checkbox col-sm-8 col-md-9">
						<label><input type="radio" name="sex"> 男</label> <label><input
							type="radio" name="sex"> 女</label>
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">上传头像</label>
					<div class="col-sm-8 col-md-9">
						<div id="uploader-demo">
						    <!--用来存放item-->
						    <div id="fileList" class="uploader-list"></div>
						    <div id="filePicker">选择图片</div>
						    <button id="ctlBtn" style="display:none" class="btn btn-default">开始上传</button>
						</div>
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3"><span class="c-red">*</span>登录密码</label>
					<div class="col-sm-8 col-md-9">
						<input type="password" name="pwd" id="pwd" class="form-control"
							placeholder="请输入密码">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3"><span class="c-red">*</span>再次输入密码</label>
					<div class="col-sm-8 col-md-9">
						<input type="password" name="pwd2" id="pwd2" class="form-control"
							placeholder="请再吃输入密码">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3"><span class="c-red">*</span>手机号码</label>
					<div class="col-sm-8 col-md-9">
						<input type="text" value="${memberUser.phone}" name="phone" id="phone" class="form-control"
							placeholder="请输入手机号码">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">电子邮箱</label>
					<div class="col-sm-8 col-md-9">
						<input type="text" value="${memberUser.email}" name="email" id="email" class="form-control"
							placeholder="请输入电子邮箱">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">地址</label>
					<div class="col-sm-8 col-md-9">
						<input type="text" value="${memberUser.addr_old}" name="email" id="email" class="form-control"
							placeholder="请输入电子邮箱">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">现居住地</label>
					<div class="col-sm-8 col-md-9">
						<input type="text" value="${memberUser.addr_now}" name="email" id="email" class="form-control"
							placeholder="请输入电子邮箱">
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="new-add">
					<button class="btn btn-warning" id="submit_but">修改</button>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/layer/2.4/layer.js"></script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/nav.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/common-upload.js"> </script>
<script type="text/javascript">
var serverUrl = '/sinian/product/productController/uploadImg';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';

		//表单提交，可上传文件
		$(function() {
			//表单验证
			$("#form_").validate({
				rules:{
					real_name:{
						required:true
					},
					member_name:{
						required:true
					},
					pwd:{
						required:true
					},
					pwd2:{
						required:true,
						equalTo:"#pwd"
					},
					phone:{
						required:true,
						digits:true
					},
					no_order:{
						digits:true
					}
				},
				onkeyup:false,
				focusCleanup:false,
				success:"valid",
				submitHandler:function(form){
					var imgList = $('#fileList').children('div');
					if (imgList.length > 0) {
						$('#ctlBtn').trigger("click");
						// not empty
					} else {
						//  is empty
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
							$("#form_").ajaxForm(options);
							// 表单提交     
							$("#form_").ajaxSubmit(options);
					}  
					return false;
				}
			});
			
		});
	</script>
</body>
</html>
