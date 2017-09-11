<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link href="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<title>信息公开申请</title>
<style type="text/css">
.c-red, .c-red a, a.c-red {
    color: red;
}
.but_hidden{position: absolute; visibility: hidden;}
.clearfix:after{content:"\20";display:block;height:0;clear:both;visibility:hidden}.clearfix{zoom:1}
.tabBar {border-bottom: 2px solid #222}
.tabBar span {background-color: #e8e8e8;cursor: pointer;display: inline-block;float: left;font-weight: bold;height: 30px;line-height: 30px;padding: 0 15px}
.tabBar span.current{background-color: #222;color: #fff}
.tabCon {display: none}

.btn-upload{position: relative; display:inline-block;height:36px; *display:inline;overflow:hidden;vertical-align:middle;cursor:pointer}
.upload-url{cursor: pointer}
.input-file{position:absolute; right:0; top:0; cursor: pointer; z-index:1; font-size:30em; *font-size:30px;opacity:0;filter: alpha(opacity=0)}
.btn-upload .input-text{ width:auto}
.form-group .upload-btn{ margin-left:-1px}

</style>
</head>
<body class="pos-r">

					<form action="${pageContext.request.contextPath}/apply/controller/applyController/addApply" method="post"  class="form-horizontal" id="form_personal">
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">姓名</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<input type="text" class="form-control" placeholder="请输入您的姓名" id="user_name" name="user_name">
							</div>
							<div class="col-md-3 apply-warning text-danger">请输入合法的信息</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">工作单位</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<input type="text" class="form-control" placeholder="请输入您的工作单位" id="user_unit" name="user_unit">
							</div>
							<div class="col-md-3 apply-warning text-danger">请输入合法的信息</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">联系电话</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<input type="text" class="form-control" placeholder="请输入您的联系电话" id="user_tel" name="user_tel">
							</div>
							<div class="col-md-3 apply-warning text-danger">请输入合法的信息</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">通信地址 </label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<input type="text" class="form-control" placeholder="请输入您的通信地址" id="address" name="address">
							</div>
							<div class="col-md-3 apply-warning text-danger">请输入合法的信息</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">邮政编码</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<input type="text" class="form-control" placeholder="请输入您的邮政编码" id="postcode" name="postcode">
							</div>
							<div class="col-md-3 apply-warning text-danger">请输入合法的信息</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">证件类型</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<select class="form-control" id="id_type" name="id_type">
									<option value="身份证">身份证</option>
									<option value="护照">护照</option>
								</select>
							</div>
							<div class="col-md-3 apply-warning text-danger">请输入合法的信息</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">证件号码</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<input type="text" class="form-control" placeholder="请输入您的证件号码" id="id_num" name="id_num">
							</div>
							<div class="col-md-3 apply-warning text-danger">请输入合法的信息</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">上传证件</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<iframe src="${pageContext.request.contextPath}/apply/controller/applyController/toApplyIdPicUpload" name="idiframe" id="idiframe" 
										scrolling="no" frameborder="0" ></iframe>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">上传附件</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<iframe src="${pageContext.request.contextPath}/apply/controller/applyController/toApplyFilePicUpload" name="fileiframe" id="fileiframe" 
										scrolling="no" frameborder="0" ></iframe>
							</div>
						</div>
						<div class="clearfix"></div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-2 col-md-3 control-label">所需信息的内容描述</label>
							<textarea id="content" name="content" class="col-xs-12 col-sm-6 col-md-6 " rows="5" placeholder=""></textarea>
							<div class="col-md-3 apply-warning text-danger">请输入合法的信息</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-2 col-md-3 control-label">申请获取信息的理由</label>
							<textarea id="reason" name="reason" class="col-xs-12 col-sm-6 col-md-6" rows="5" placeholder=""></textarea>
							<div class="col-md-3 apply-warning text-danger">请输入合法的信息</div>
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-2 col-md-3 control-label">备注</label>
							<textarea id="remark" name="remark" class="col-xs-12 col-sm-6 col-md-6" rows="5" placeholder=""></textarea>
							<div class="col-md-3 apply-warning text-danger">请输入合法的信息</div>
						</div>
						<br/>
						<div class="form-btn">
							<button class="btn btn-default" type="reset" style="margin-right:30px">重置</button>
							<button class="btn btn-primary" id="personal_submit" type="submit">提交</button>
						</div>
					</form>

<%@ include file="../site/siteFooter.jsp"%>

<%@ include file="../../../common/footer-site.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/static/h-ui/js/H-ui.js"></script> 
<!-- 表单验证 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<!-- form提交 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/apply-upload.js"> </script>
<script type="text/javascript">
var contextPath = "${pageContext.request.contextPath}";
var totalPage = '';

//表单提交，可上传文件
$(function() {
	
	var options = {
			success : function(data) {
				layer.alert(data.result_message,
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
	
	//表单验证
	$("#form_personal").validate({
		rules:{
			user_name:{
				required:true,
				maxlength:20
			},
			user_unit:{
				required:true,
				maxlength:100
			},
			user_tel:{
				required:true,
				digits:true
			},
			address:{
				required:true,
				maxlength:200
			},
			postcode:{
				required:true,
				digits:true,
				maxlength:6
			},
			id_num:{
				required:true,
				maxlength:18
			},
			content:{
				required:true,
				maxlength:500
			},
			reason:{
				required:true,
				maxlength:500
			},
			remark:{
				maxlength:500
			}
		},
		onkeyup:false,
		focusCleanup:false,
		success:"valid",
		submitHandler:function(form){
			//确保图片上传
			var idiframe = $("#idiframe")[0].contentWindow;
			var imgList = $("#idiframe").contents().find("#fileList").children('div');
			if (imgList.length > 0) {
				// not empty
				idiframe.toClickUpload();
			} else {
				// 准备form表单
				$("#form_personal").ajaxForm(options);
				// 表单提交     
				$("#form_personal").ajaxSubmit(options);
			}

	return false;
			
		}
	});
	
	
	
	
	
});
</script>
</body>
</body>
</html>