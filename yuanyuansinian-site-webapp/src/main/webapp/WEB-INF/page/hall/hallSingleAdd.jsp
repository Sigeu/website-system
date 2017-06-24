<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<link
	href="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.css"
	rel="stylesheet" type="text/css" />
<title>单人纪念馆新建</title>
</head>
<body class="pos-r">
	<!-- <nav class="breadcrumb">
		首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>新增单人纪念馆
	</nav> -->
	<div class="page-container">
		<form
			action="${pageContext.request.contextPath}/sinian/hall/hallController/addSingleHall"
			method="post" class="form form-horizontal" id="form_">
			<input type="hidden" name="hall_type" id="hall_type" value="1">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span
					class="c-red">*</span>纪念馆名称：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="纪念馆名称"
						id="title" name="title">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">纪念馆简短说明：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<textarea name="description" cols="" rows="" class="textarea"
						placeholder="纪念馆简短说明" dragonfly="true"
						onKeyUp="$.Huitextarealength(this,200)"></textarea>
					<p class="textarea-numberbar">
						<em class="textarea-length">0</em>/200
					</p>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span
					class="c-red">*</span>纪念馆模版：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<div class="formControls col-xs-8 col-sm-9">
						<input id="input_template" value="" class="input-text radius" placeholder="模版" type="text" style="cursor: pointer;" readonly="readonly" name="templateName">
			          	<input type="hidden" id="template_id" name="template_id" value="">
					</div>
					<div class="formControls col-xs-1 col-sm-1">
						<a id="btn_select" class="btn btn-secondary size-S radius" type="button" > <i class="Hui-iconfont Hui-iconfont-search2"></i>&nbsp;选择</a>
					</div>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">别名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="别名"
						id="alias" name="alias">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span
					class="c-red">*</span>姓名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="姓名"
						id="name" name="name">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span
					class="c-red">*</span>性别：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<div class="radio-box">
						<input type="radio" id="sex_1" name="sex" value="1" checked /> <label
							for="sex_1">男</label>
					</div>
					<div class="radio-box">
						<input type="radio" id="sex_2" name="sex" value="2" /> <label
							for="sex_2">女</label>
					</div>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span
					class="c-red">*</span>出生日期：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd' })"
						value="" placeholder="出生日期" id="birthday" name="birthday"
						class="input-text Wdate">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span
					class="c-red">*</span>生肖：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="生肖" readonly="readonly"
						id="zodiac" name="zodiac">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span
					class="c-red">*</span>去世日期：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd' })"
						value="" placeholder="去世日期" id="death_date" name="death_date"
						class="input-text Wdate">
				</div>
			</div>

			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">国籍：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="国籍"
						id="nationality" name="nationality">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">出生地：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="出生地"
						id="birthplace" name="birthplace">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">籍贯：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="籍贯"
						id="native_place" name="native_place">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">民族：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="民族"
						id="nation" name="nation">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">墓地地址：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="墓地地址"
						id="address" name="address">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">信仰：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="信仰"
						id="belief" name="belief">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">成就：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<textarea name="achievement" cols="" rows="" class="textarea" style="height:150px"
						placeholder="成就" dragonfly="true"
						onKeyUp="$.Huitextarealength(this,500)"></textarea>
					<p class="textarea-numberbar">
						<em class="textarea-length">0</em>/500
					</p>
				</div>
			</div>
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
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span
					class="c-red">*</span>是否公开：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<div class="radio-box">
						<input type="radio" id="open_type_y" name="open_type" value="1"
							checked /> <label for="open_type_y">公开</label>
					</div>
					<div class="radio-box">
						<input type="radio" id="open_type_n" name="open_type" value="0" />
						<label for="open_type_n">非公开</label>
					</div>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span
					class="c-red">*</span>纪念馆封面：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<div id="uploader-demo">
						<!--用来存放item-->
						<div id="fileList" class="uploader-list"></div>
						<div id="filePicker">选择图片</div>
						<button id="upload_but" style="display: none"
							class="btn btn-default">开始上传</button>
					</div>
				</div>
			</div>
			</br>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
					<button id="submit_but" class="btn btn-secondary radius"
						type="submit">
						<i class="Hui-iconfont">&#xe632;</i> 保存
					</button>
					<button id="close_but" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
				</div>
			</div>
		</form>
	</div>
	<%@ include file="../../../common/footer_form.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/file-upload.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/template.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript">
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
		//数据ID
		var model_id = '';
	</script>
	<script type="text/javascript">
	
		//选择模版
		$("#btn_select,#input_template").click(function(){
			utils.treeSelectTemplate(function(menuObj){
				$("input[name='menuIconName']").val(menuObj.menuIconName);
				$("#menuIcon").val(menuObj.menuIcon);
			});
		});
	
		//获取生肖
		function getZodiac(year) {
			var arr = [ '猴', '鸡', '狗', '猪', '鼠', '牛', '虎', '兔', '龙', '蛇', '马',
					'羊' ];
			return /^\d{4}$/.test(year) ? arr[year % 12] : null
		}

		$(function() {
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
										$('#upload_but').trigger("click");
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
									title : {
										required : true,
										maxlength : 100
									},
									name : {
										required : true
									},
									sex : {
										required : true
									},
									birthday : {
										required : true
									},
									zodiac : {
										required : true
									},
									death_date : {
										required : true
									},
									open_type : {
										required : true
									}
								}
							});

		});
	</script>
</body>
</body>
</html>