<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<link href="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
//window.k = "/static/hui/admin3.0/lib/ueditor/1.4.3/";//编辑器项目路径
</script>
<title>产品新增表页</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>新增产品
		</nav>
	<div class="page-container">
	<form action="${pageContext.request.contextPath}/sinian/product/productController/addProduct" method="post" class="form form-horizontal" id="form_">
		<input type="hidden" name="big_type" id="big_type" value="${big_type}">
		<%-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>大类：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" id="big_type" name="big_type">
					<option value="0">--请选择--</option>  
                    <c:forEach items="${bigTypeCodeList}" var="bigTypeCode">  
                    	<option value="${bigTypeCode.code_value}">${bigTypeCode.code_name}</option>  
                    </c:forEach>   
				</select>
				</span> </div>
		</div> --%>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>分类：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" id="type" name="type">
					<option value="0">--请选择--</option>  
                    <c:forEach items="${codeList}" var="code">  
                    	<option value="${code.code_value}">${code.code_name}</option>  
                    </c:forEach>  
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>摆放分类：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" id="put_type" name="put_type">
					<option value="0">--请选择--</option>  
                    <c:forEach items="${putTypeList}" var="code">  
                    	<option value="${code.code_value}">${code.code_name}</option>  
                    </c:forEach>  
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>产品名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="产品名称" id="name" name="name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">简短标题：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="简短标题" id="name_short" name="name_short">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>销售价格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="销售价格" id="price_site" name="price_site">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>有效期(天)：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="有效期" id="validity_day" name="validity_day">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">计价单位：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="元宝" placeholder="计算单位" id="units" name="units">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">描述说明：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="description" cols="" rows="" class="textarea"  placeholder="描述说明" datatype="*10-100" dragonfly="true" onKeyUp="$.Huitextarealength(this,200)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">产品封面：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div id="uploader-demo">
				    <!--用来存放item-->
				    <div id="fileList" class="uploader-list"></div>
				    <div id="filePicker">选择图片</div>
				    <button id="ctlBtn" style="display:none" class="btn btn-default">开始上传</button>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">详细内容：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<script id="editor" name="content" type="text/plain" style="width:100%;height:400px;"></script> 
			</div>
		</div>
		</br>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="submit_but" class="btn btn-secondary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button id="close_but" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="../../../common/footer_form.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/common-upload.js"> </script>
<script type="text/javascript">
var contextPath = '${pageContext.request.contextPath}';
var serverUrl = '/sinian/product/productController/uploadImg';
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
	$("#form_").validate({
		rules:{
			name:{
				required:true,
				maxlength:100
			},
			price_site:{
				required:true,
				number:true
			},
			put_type:{
				required:true,
				number:true
			},
			validity_day:{
				required:true,
				number:true
			},
			type:{
				required:true
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
</body>
</html>