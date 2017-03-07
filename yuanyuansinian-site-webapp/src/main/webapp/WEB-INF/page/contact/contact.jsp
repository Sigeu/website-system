<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<title>系统设置</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 网站管理 <span class="c-gray en">&gt;</span>联系方式设置
		</nav>
<div class="page-container">
	<form class="form form-horizontal" id="form-article-contact" action="${pageContext.request.contextPath}/sinian/contact/contactController/updateContact"
			method="post">
		<input type="hidden" name="id" id="id_" value="${contact.id }">
		<div id="tab-system" class="HuiTab">
			<div class="tabBar cl">
				<span>基本设置</span>
				<span>其他设置</span>
			</div>
			<div class="tabCon">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">
						<span class="c-red">*</span>
						部门：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" id="dept_name" name="dept_name" placeholder="部门名称" value="${contact.dept_name }" class="input-text">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">
						<span class="c-red">*</span>
						地址：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" id="address" name="address" placeholder="联系地址" value="${contact.address }" class="input-text">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">
						<span class="c-red">*</span>
						电话：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" id="tel" name="tel" placeholder="联系电话" value="${contact.tel }" class="input-text">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">
						<span class="c-red">*</span>
						邮编：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" id="addr_zip" name="addr_zip" placeholder="邮编" value="${contact.addr_zip }" class="input-text">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">
						<span class="c-red">*</span>
						邮箱：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" id="email" name="email" placeholder="联系邮箱" value="${contact.email }" class="input-text">
					</div>
				</div>
			</div>
			<div class="tabCon">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="submit_but"  class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="../../../common/footer_form.jsp"%>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	$.Huitab("#tab-system .tabBar span","#tab-system .tabCon","current","click","0");
});
//表单提交，可上传文件
$(function() {
	//表单验证
	$("#form-article-contact").validate({
		rules:{
			dept_name:{
				maxlength:100
			},
			address:{
				maxlength:100
			},
			tel:{
				//maxlength:50
			},
			addr_zip:{
				digits:true
			},
			email:{
				email:true
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
						});
					}
				};
			// 准备form表单
			$("#form-article-contact").ajaxForm(options);
			//提交表单
			$("#form-article-contact").ajaxSubmit(options);
			
			return false;
		}
	});
	
});
</script>
</body>
</body>
</html>