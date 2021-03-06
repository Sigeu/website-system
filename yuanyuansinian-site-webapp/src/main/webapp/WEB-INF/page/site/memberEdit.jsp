<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
<link href="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<title>网站会员注册</title>
</head>
<body>
<%@ include file="siteHeaderForRegister.jsp"%>
<div class="container con-tab all-bg miss-con new-con">		
		<div class="pro-header">
			<h4 class="pro-title pull-left">信息修改</h4>
		</div>
		<div class="clearfix"></div>
		<div class="new-body">
			<form class="form-horizontal"
				action="${pageContext.request.contextPath}/sinian/member/memberController/updateMember"
				method="post" id="form_">
				<input type="hidden" name="id" id="id" value="${memberUser.id}">
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3"><span
						class="c-red">*</span>真实姓名</label>
					<div class="col-sm-8 col-md-9 form-pos">
						<input type="text" name="real_name" id="real_name" value="${memberUser.real_name}"
							class="form-control" placeholder="请输入姓名">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3"><span
						class="c-red">*</span>会员昵称</label>
					<div class="col-sm-8 col-md-9 form-pos">
						<input type="text" name="member_name" id="member_name" value="${memberUser.member_name}"
							class="form-control" placeholder="请输入别名">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3"><span
						class="c-red">*</span>性别</label>
					<div class="checkbox col-sm-8 col-md-9">
						<label><input type="radio" value="1" name="sex"
							checked="checked"> 男</label> <label><input type="radio"
							value="0" name="sex"> 女</label>
					</div>
				</div>
				<!-- <div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">上传头像</label>
					<div class="col-sm-8 col-md-9">
						<input type="file" id="" class="form-control"
							style="border: 0; box-shadow: none">
					</div>
				</div> -->
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3"><span
						class="c-red">*</span>手机号码</label>
					<div class="col-sm-8 col-md-9 form-pos">
						<input type="text" name="phone" id="phone" class="form-control" readonly="readonly" value="${memberUser.phone}"
							placeholder="请输入手机号码,手机号码为会员登录帐号">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3"><span
						class="c-red">*</span>登录密码</label>
					<div class="col-sm-8 col-md-9 form-pos">
						<input type="password" name="pwd" id="pwd" class="form-control" value="${memberUser.pwd}"
							placeholder="登录密码为6-20个字母、数字组合">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3"><span
						class="c-red">*</span>电子邮箱</label>
					<div class="col-sm-8 col-md-9 form-pos">
						<input type="text" name="email" id="email" class="form-control" readonly="readonly" value="${memberUser.email}"
							placeholder="请输入电子邮箱">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3"><span
						class="c-red">*</span>确认密码</label>
					<div class="col-sm-8 col-md-9 form-pos">
						<input type="password" name="pwd2" id="pwd2" class="form-control" value=""
							placeholder="请再次输入密码">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">现居住地址</label>
					<div class="col-sm-8 col-md-9">
						<input type="text" name="addr_now" id="addr_now" value="${memberUser.addr_now}"
							class="form-control" placeholder="请输入现居住地址">
					</div>
				</div>
				<!-- <div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">地址</label>
					<div class="col-sm-8 col-md-9">
						<input type="text" name="addr_old" id="addr_old" class="form-control"
							placeholder="请输入地址">
					</div>
				</div> -->
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">上传头像：</label>
					<div class="col-xs-8 col-sm-9">
						<div id="uploader-demo">
						    <!--用来存放item-->
						    <div id="fileList" class="uploader-list"></div>
						    <div id="filePicker">选择图片</div>
						    <button id="ctlBtn" style="display:none" class="btn btn-default">开始上传</button>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="new-add">
					<div class="clearfix"></div>
					<button class="btn btn-warning" id="submit_but">提交</button>
				</div>
			</form>
		</div>
	</div>

<%@ include file="siteFooterForLogin.jsp"%>
	<%@ include file="../../../common/footer_form.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/siteFooter.js"></script>
	
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/register-upload.js"> </script>
	<script type="text/javascript">
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
		var serverUrl = '/sinian/member/memberController/uploadImg';
		//数据ID
		var model_id = '';
		jQuery.validator.addMethod('isMobile', function(value, element) {
			var length = value.length;
			var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+d{8})$/;
			return this.optional(element)
					|| (length == 11 && mobile.test(value));
		}, '请正确填写您的手机号码');
		jQuery.validator.addMethod("regexPassword", function(value, element) {  
		    return this.optional(element) || /^[A-Za-z0-9]{6,20}$/.test(value);  
		}, "密码为6-20个字母、数字组合");
		//表单提交，可上传文件
		$(function() {
			$('#sex').val('${memberUser.sex}');
			//表单验证
			$("#form_")
					.validate(
							{
								rules : {
									real_name : {
										required : true
									},
									member_name : {
										required : true
										
									},
									sex : {
										required : true
									},
									pwd : {
										required : true,
										regexPassword : "密码为6-20个字母、数字组合"
										
									},
									pwd2 : {
										required : true,
										equalTo : "#pwd"
									},
									phone : {
										required : true,
										isMobile:"请填写正确有效的手机号码!"
									},
									email : {
										required : true,
										email : true
									}
								},
								messages: {
									member_name: {
						                    required: "请填写会员名！",
						                    remote: "会员名已被注册，请重新填写！"
						                },
						           	phone: {
					                    required: "请填写正确有效的手机号码!",
					                    remote: "手机号码已被注册，请重新填写！"
					                },
					                email: {
					                    required: "请填正确的电子邮箱！",
					                    remote: "电子邮箱已被注册，请重新填写！"
					                }
						        },
								onkeyup : false,
								focusCleanup : false,
								success : "valid",
								submitHandler : function(form) {
									var imgList = $('#fileList')
											.children('div');
									if (imgList.length > 0) {
										$('#ctlBtn').trigger("click");
										// not empty
									} else {
										//  is empty
										var options = {
											success : function(data) {
												layer
														.alert(
																data.result_message,
																{
																	closeBtn : 1
																},
																function() {
																	window.location.href = contextPath + "/sinian/index/indexController/toMemberLogin";
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
