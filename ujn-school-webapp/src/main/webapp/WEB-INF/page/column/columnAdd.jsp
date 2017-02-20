<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<title>栏目添加</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>新增内容
		</nav>
	<div class="page-container">
	<form action="${pageContext.request.contextPath}/column/controller/columnController/addColumn" method="post" class="form form-horizontal" id="form-column-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>分类栏目：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<!-- <ul id="column_tree" class="ztree"></ul> -->
				<span class="select-box" id="sel_span">
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>栏目名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="栏目名称" id="name" name="name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">排序值：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="排序值，越小越靠前" id="no_order" name="no_order">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">栏目级别：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="class_type" class="select">
					<option value="0">一级分类</option>
					<option value="1">二级分类</option>
					<option value="11">三级级分类</option>
					<option value="12">四级分类</option>
				</select>
				</span> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">内容分类：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="内容分类" id="module" name="module">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">外部链接：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="链接到网站外部的网址" id="links" name="links">
			</div>
		</div>
		</br>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="submit_but" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="../../../common/footer_form.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/ueditor/1.4.3/ueditor.config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/ueditor/1.4.3/ueditor.all.min.js"> </script>
<script type="text/javascript">
var setting = {
		check: {
			enable: true,
			nocheckInherit: true
		},
		data: {
			simpleData: {
				enable: true
			}
		}
	};

	$(function(){
		$.ajax({
			 type: "post",
			 url: "${pageContext.request.contextPath}/column/controller/columnController/queryColumnTree",
             data: {},
             dataType: "json",
             success: function(data){
                 $("#sel_span").append(data.selectHtml);
             },
             error: function(XMLHttpRequest, textStatus, errorThrown) {
                layer.alert("分类栏目获取失败！");
            },
		 });
		
	});
	
/* $(function(){
	//UE编辑器
	var ue = UE.getEditor('editor');
	//表单验证
	//$("#form_").Validform();

	$('#close_but').on('click', function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
		return false;
	});
	
}); */


//表单提交，可上传文件
$(function() {
	var options = {
		success : function(data) {
			layer.alert(data.result_message, {
			  closeBtn: 0
			}, function(){
				//父页面刷新
				parent.reloadPage();
				var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
				parent.layer.close(index); //再执行关闭
			});
		}
	};
	// 准备form表单
	$("#form-column-add").ajaxForm(options);
	// 表单提交     
	$('#submit_but').on('click', function() {
		$("#form-column-add").ajaxSubmit(options);
		return false;
	});
	
});
</script>
</body>
</body>
</html>