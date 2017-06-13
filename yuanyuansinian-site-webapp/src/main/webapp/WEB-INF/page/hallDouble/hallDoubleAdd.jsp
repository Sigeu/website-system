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
<link
	href="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.css"
	rel="stylesheet" type="text/css" />
<title>纪念馆新建</title>
</head>
<body class="pos-r">
	<!-- <nav class="breadcrumb">
		首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>新增双人纪念馆
	</nav> -->

	<div class="container con-tab all-bg miss-con new-con">
		<div class="pro-header">
			<h4 class="pro-title pull-left">缘园思念网创建纪念馆</h4>
		</div>
		<div class="clearfix"></div>
		<div class="new-body">
			 <p class="new-notice text-justify">
				<!-- <span class="glyphicon glyphicon-star"></span>注意：缘园思念创建的纪念馆提供一个月的免费试用，之后您可以选择“5年300元”和“10年500元”的服务注意：缘园思念创建的纪念馆提供一个月的免费试用，之后您可以选择“5年300元”和“10年500元”的服务 -->
			</p>
			<br>
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
								<button id="ctlBtn" style="display: none"
									class="btn btn-default">开始上传</button>
							</div>
						</div>
					</div>
					<br>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-2"><span
							class="c-red">*</span>是否公开</label>
						<div class="checkbox col-sm-8 col-md-9">
							<label><input type="radio" name="open_type" value="1"
								checked="checked"> 公开</label> <label><input type="radio"
								name="open_type" value="0"> 不公开</label>
						</div>
					</div>
					<br>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-2">生平事迹：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<textarea name="life_story" cols="" rows="" class="textarea" style="height:520px"
								placeholder="生平事迹,最多2000字" dragonfly="true"
								onKeyUp="$.Huitextarealength(this,2000)"></textarea>
							<p class="textarea-numberbar">
								<em class="textarea-length">0</em>/2000
							</p>
						</div>
					</div>
					<br>
					<p class="new-notice">
						<span class="glyphicon glyphicon-edit" style="margin-right: 10px"></span>请填写双人馆第一人信息
					</p>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3"><span
							class="c-red">*</span>姓名</label>
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
						<label class="control-label col-sm-4 col-md-3"><span
							class="c-red">*</span>性别</label>
						<div class="formControls col-xs-8 col-sm-9">
							<div class="radio-box">
								<input type="radio" id="sex_1" name="sex" value="1" checked />
								<label for="sex_1">男</label>
							</div>
							<div class="radio-box">
								<input type="radio" id="sex_2" name="sex" value="2" /> <label
									for="sex_2">女</label>
							</div>
						</div>
					</div>
					<!-- <div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">照片</label>
						<div class="col-sm-8 col-md-9">
							<span class="btn-upload">
							  <a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 浏览文件</a>
							  <input type="file" multiple name="file_1" class="input-file">
							</span>
						</div>
					</div> -->
					<div class="form-group col-sm-6">
						<label class="control-label col-xs-4 col-sm-3"><span
							class="c-red">*</span>出生日期：</label>
						<div class="col-xs-8 col-sm-9">
							<input type="text"
								onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd' })" value=""
								placeholder="出生日期" id="birthday" name="birthday"
								class="form-control Wdate">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-xs-4 col-sm-3"><span
							class="c-red">*</span>生肖：</label>
						<div class="col-xs-8 col-sm-9">
							<input type="text" class="input-text" value="" placeholder="生肖" readonly="readonly"
									id="zodiac" name="zodiac">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-xs-4 col-sm-3"><span
							class="c-red">*</span>去世日期：</label>
						<div class="col-xs-8 col-sm-9">
							<input type="text"
								onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd' })" value=""
								placeholder="去世日期" id="death_date" name="death_date"
								class="form-control Wdate">
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
							<textarea name="achievement" cols="" rows="" class="textarea" style="height:300px"
								placeholder="个人能成就，最多500字" dragonfly="true"
								onKeyUp="$.Huitextarealength(this,500)"></textarea>
							<p class="textarea-numberbar">
								<em class="textarea-length">0</em>/500
							</p>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">照片</label>
						<div class="col-sm-8 col-md-9">
							<iframe src="${pageContext.request.contextPath}/sinian/index/indexController/hallDoubleAddHeadOne" name="zpiframe1" id="zpiframe1" 
						scrolling="no" frameborder="0" width="100%"></iframe>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>

				<div class="new-pro">
					<p class="new-notice">
						<span class="glyphicon glyphicon-edit" style="margin-right: 10px"></span>请填写双人馆第二人信息
					</p>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3"><span
							class="c-red">*</span>姓名</label>
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
						<label class="control-label col-sm-4 col-md-3"><span
							class="c-red">*</span>性别</label>
						<div class="formControls col-xs-8 col-sm-9">
							<div class="radio-box">
								<input type="radio" id="sex_1" name="sex2" value="1" checked />
								<label for="sex_1">男</label>
							</div>
							<div class="radio-box">
								<input type="radio" id="sex_2" name="sex2" value="2" /> <label
									for="sex_2">女</label>
							</div>
						</div>
					</div>
					<!-- <div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">照片</label>
						<div class="col-sm-8 col-md-9">
							<span class="btn-upload">
							  <a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 浏览文件</a>
							  <input type="file" multiple name="file_2" class="input-file">
							</span>
						</div>
					</div> -->
					<div class="form-group col-sm-6">
						<label class="control-label col-xs-4 col-sm-3"><span
							class="c-red">*</span>出生日期：</label>
						<div class="col-xs-8 col-sm-9">
							<input type="text"
								onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd' })" value=""
								placeholder="出生日期" id="birthday2" name="birthday2"
								class="form-control Wdate">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-xs-4 col-sm-3"><span
							class="c-red">*</span>生肖：</label>
						<div class="col-xs-8 col-sm-9">
							<input type="text" class="input-text" value="" placeholder="生肖" readonly="readonly"
							id="zodiac2" name="zodiac2">
							<!-- <span class="select-box"> <select id="zodiac2"
								name="zodiac2" class="select">
									<option value="">--请选择--</option>
									<option value="鼠">鼠</option>
									<option value="牛">牛</option>
									<option value="虎">虎</option>
									<option value="兔">兔</option>
									<option value="龙">龙</option>
									<option value="蛇">蛇</option>
									<option value="马">马</option>
									<option value="羊">羊</option>
									<option value="猴">猴</option>
									<option value="鸡">鸡</option>
									<option value="狗">狗</option>
									<option value="猪">猪</option>
							</select>
							</span> -->
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-xs-4 col-sm-3"><span
							class="c-red">*</span>去世日期：</label>
						<div class="col-xs-8 col-sm-9">
							<input type="text"
								onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd' })" value=""
								placeholder="去世日期" id="death_date2" name="death_date2"
								class="form-control Wdate">
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
							<textarea name="achievement2" cols="" rows="" class="textarea"  style="height:300px"
								placeholder="个人能成就，最多500字" dragonfly="true"
								onKeyUp="$.Huitextarealength(this,500)"></textarea>
							<p class="textarea-numberbar">
								<em class="textarea-length">0</em>/500
							</p>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label col-sm-4 col-md-3">照片</label>
						<div class="col-sm-8 col-md-9">
							<iframe src="${pageContext.request.contextPath}/sinian/index/indexController/hallDoubleAddHeadTwo" name="zpiframe2" id="zpiframe2" 
						scrolling="no" frameborder="0" width="100%"></iframe>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>

				<div class="new-add">
					<!-- <input type="checkbox" checked="checked" name="read_text"><a
						href="###">阅读并同意缘园思念网服务条款</a> -->
					<div class="clearfix"></div>
					<button id="submit_but" class="btn btn-secondary radius"
						type="submit">
						<i class="Hui-iconfont">&#xe632;</i> 保存
					</button>
					<button id="close_but" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
				</div>
			</form>
		</div>
	</div>
	<div class="clearfix"></div>
	<%@ include file="../../../common/footer_form.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/hallDouble-upload.js">
	</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript">
		var serverUrl = '/sinian/hallDouble/hallDoubleController/uploadImg';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
		//数据ID
		var model_id = '';
	</script>
	<script type="text/javascript">
	//获取生肖
	function getZodiac(year) {
		var arr = [ '猴', '鸡', '狗', '猪', '鼠', '牛', '虎', '兔', '龙', '蛇', '马',
				'羊' ];
		return /^\d{4}$/.test(year) ? arr[year % 12] : null
	}

		$(function() {
			//关闭按钮
			$('#close_but').on('click', function() {
				var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
				parent.layer.close(index); //再执行关闭
				return false;
			});
			
			$('#birthday').blur(function(){
				var year = $(this).val().substring(0,4);
				if(year != '' && typeof(year) != 'undefined'){
					$('#zodiac').val(getZodiac(year));
				}
			});
			
			$('#birthday2').blur(function(){
				var year = $(this).val().substring(0,4);
				if(year != '' && typeof(year) != 'undefined'){
					$('#zodiac2').val(getZodiac(year));
				}
			});
		});

		//表单提交，可上传文件
		$(function() {
			//表单验证
			$("#form_")
					.validate(
							{
								debug : true,
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
																	//父页面刷新
																	parent.window.location
																			.reload();
																	var index = parent.layer
																			.getFrameIndex(window.name); //先得到当前iframe层的索引
																	parent.layer
																			.close(index); //再执行关闭
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
								rules : {
									title:{
										required:true,
										maxlength:100
									},
									name:{
										required:true
									},
									sex:{
										required:true
									},
									birthday:{
										required:true
									},
									zodiac:{
										required:true
									},
									death_date:{
										required:true
									},
									open_type:{
										required:true
									},
									name2:{
										required:true
									},
									sex2:{
										required:true
									},
									birthday2:{
										required:true
									},
									zodiac2:{
										required:true
									},
									death_date2:{
										required:true
									}
								}
							});

		});
	</script>

</body>
</body>
</html>