<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/style.css" />
<link href="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
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
			<p class="new-notice text-justify">
				<span class="glyphicon glyphicon-star"></span>注意：缘园思念创建的纪念馆提供一个月的免费试用，之后您可以选择“5年300元”和“10年500元”的服务注意：缘园思念创建的纪念馆提供一个月的免费试用，之后您可以选择“5年300元”和“10年500元”的服务
			</p>
			<form class="form-horizontal"
				action="${pageContext.request.contextPath}/sinian/hallDouble/hallDoubleController/addDoubleHall"
				method="post" id="form_">
				<div class="new-pro">
					<input type="hidden" name="hall_type" id="hall_type" value="2">
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-2"><span
							class="c-red">*</span>纪念馆名称：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text" value=""
								placeholder="纪念馆名称" id="title" name="title">
						</div>
					</div>
					<br>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-2"><span
							class="c-red">*</span>纪念馆封面：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<div id="uploader-demo">
							    <!--用来存放item-->
							    <div id="fileList" class="uploader-list"></div>
							    <div id="filePicker">选择图片</div>
							    <button id="ctlBtn" style="display:none" class="btn btn-default">开始上传</button>
							</div>
						</div>
					</div>
					<br>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-2">是否公开</label>
						<div class="checkbox col-sm-8 col-md-9">
							<label><input type="radio" name="open_type" value="1" checked="checked"> 公开</label> <label><input
								type="radio" name="open_type" value="0"> 不公开</label>
						</div>
					</div>
					<br>
					<p class="new-notice">
						<span class="glyphicon glyphicon-edit" style="margin-right: 10px"></span>请填写双人馆第一人信息
					</p>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">姓名</label>
						<div class="col-sm-8 col-md-9">
							<input type="text" class="form-control" placeholder="请输入姓名"
								id="name" name="name">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">别名</label>
						<div class="col-sm-8 col-md-9">
							<input type="text" class="form-control" placeholder="请输入别名"
								id="alias" name="alias">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">性别</label>
						<div class="formControls col-xs-8 col-sm-9">
							<div class="radio-box">
								<input type="radio" id="sex_1" name="sex"
									value="1" checked /> <label for="sex_1">男</label>
							</div>
							<div class="radio-box">
								<input type="radio" id="sex_2" name="sex"
									value="2" /> <label for="sex_2">女</label>
							</div>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">照片</label>
						<div class="col-sm-8 col-md-9">
							<span class="btn-upload">
							  <a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 浏览文件</a>
							  <input type="file" multiple name="file_1" class="input-file">
							</span>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">国籍</label>
						<div class="col-sm-8 col-md-9">
							<input type="text" class="form-control" placeholder="请输入国籍"
								id="nationality" name="nationality">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">民族</label>
						<div class="col-sm-8 col-md-9">
							<input type="text" class="form-control" placeholder="请输入民族"
								id="nation" name="nation">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">墓地地址</label>
						<div class="col-sm-8 col-md-9">
							<input type="text" class="form-control" placeholder="请输入墓地地址"
								id="address" name="address">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">信仰</label>
						<div class="col-sm-8 col-md-9">
							<input type="text" class="form-control" placeholder="请输入信仰"
								id="belief" name="belief">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">出生地</label>
						<div class="col-sm-8 col-md-9">
							<input type="text" class="form-control" placeholder="请输入出生地"
								id="birthplace" name="birthplace">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">籍贯</label>
						<div class="col-sm-8 col-md-9">
							<input type="text" class="form-control" placeholder="请输入籍贯"
								id="native_place" name="native_place">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">成就</label>
						<div class="col-sm-8 col-md-9">
							<textarea name="achievement" cols="" rows="" class="textarea"  placeholder="成就" datatype="*0-100" dragonfly="true" onKeyUp="$.Huitextarealength(this,200)"></textarea>
							<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>

				<div class="new-pro">
					<p class="new-notice">
						<span class="glyphicon glyphicon-edit" style="margin-right: 10px"></span>请填写双人馆第二人信息
					</p>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">姓名</label>
						<div class="col-sm-8 col-md-9">
							<input type="text" class="form-control" placeholder="请输入姓名"
								id="name2" name="name2">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">别名</label>
						<div class="col-sm-8 col-md-9">
							<input type="text" class="form-control" placeholder="请输入别名"
								id="alias2" name="alias2">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">性别</label>
						<div class="formControls col-xs-8 col-sm-9">
							<div class="radio-box">
								<input type="radio" id="sex_1" name="sex2"
									value="1" checked /> <label for="sex_1">男</label>
							</div>
							<div class="radio-box">
								<input type="radio" id="sex_2" name="sex2"
									value="2" /> <label for="sex_2">女</label>
							</div>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">照片</label>
						<div class="col-sm-8 col-md-9">
							<span class="btn-upload">
							  <a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 浏览文件</a>
							  <input type="file" multiple name="file_2" class="input-file">
							</span>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">国籍</label>
						<div class="col-sm-8 col-md-9">
							<input type="text" class="form-control" placeholder="请输入国籍"
								id="nationality2" name="nationality2">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">民族</label>
						<div class="col-sm-8 col-md-9">
							<input type="text" class="form-control" placeholder="请输入民族"
								id="nation2" name="nation2">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">墓地地址</label>
						<div class="col-sm-8 col-md-9">
							<input type="text" class="form-control" placeholder="请输入墓地地址"
								id="address2" name="address2">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">信仰</label>
						<div class="col-sm-8 col-md-9">
							<input type="text" class="form-control" placeholder="请输入信仰"
								id="belief2" name="belief2">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">出生地</label>
						<div class="col-sm-8 col-md-9">
							<input type="text" class="form-control" placeholder="请输入出生地"
								id="birthplace2" name="birthplace2">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">籍贯</label>
						<div class="col-sm-8 col-md-9">
							<input type="text" class="form-control" placeholder="请输入籍贯"
								id="native_place2" name="native_place2">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">成就</label>
						<div class="col-sm-8 col-md-9">
							<textarea name="achievement2" cols="" rows="" class="textarea"  placeholder="成就" datatype="*0-100" dragonfly="true" onKeyUp="$.Huitextarealength(this,200)"></textarea>
							<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>

				<div class="new-add">
					<input type="checkbox" checked="checked" name="read_text"><a href="###">阅读并同意缘园思念网服务条款</a>
					<div class="clearfix"></div>
					<button id="submit_but" class="btn btn-secondary radius"
						type="submit">
						<i class="Hui-iconfont">&#xe632;</i> 提交
					</button>
					<button id="close_but" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
				</div>
			</form>
		</div>
	</div>
	<div class="clearfix"></div>
<%@ include file="../../../common/footer_form.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/common-upload.js"> </script>
<script type="text/javascript">
	var serverUrl = '/sinian/hallDouble/hallDoubleController/uploadImg';
	// 项目路径
	var contextPath = '${pageContext.request.contextPath}';
	//数据ID
	var model_id = '';
</script>
<script type="text/javascript">
$(function(){
	//关闭按钮
	$('#close_but').on('click', function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
		return false;
	});
	
});


//表单提交，可上传文件
$(function() {
	//表单验证
	$("#form_").validate({
		debug:true,
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
		},
		rules:{
			title:{
				required:true,
				maxlength:100
			},
			name:{
				required:true
			},
			name2:{
				required:true
			},
			open_type : {
				required:true
			},
			read_text : {
				required:true
			}
		}
	});
	
});
</script>

</body>
</body>
</html>