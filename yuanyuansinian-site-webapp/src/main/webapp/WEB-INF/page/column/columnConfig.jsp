<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<title>栏目添加</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>栏目设置
		</nav>
	<div class="page-container">
	<form action="${pageContext.request.contextPath}/sinian/column/columnController/updateColumnConfig" method="post" class="form form-horizontal" id="form-column-config">
		<input type="hidden" name="id" id="id_" value="${column.id }">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>所属模块：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<span class="select-box" id="sel_span">
					<select class="select" id="module" name="module"> 
						<option value="">--请选择--</option> 
						<option value="1">文章模块</option> 
						<option value="2">简介模块</option>   
                    </select> 
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>模块分类：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<div class="radio-box">
					<input type="radio" id="if_in0" name="if_in"
						value="0" checked /> <label for="if_in0">内部模块</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="if_in1" name="if_in"
						value="1" /> <label for="if_in1">外部模块</label>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>页面title：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="页面title标签内容" id="ctitle" name="ctitle">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>栏目关键词：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="栏目关键词，多个词以空格隔开" id="keywords" name="keywords">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">打开方式：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div class="radio-box">
					<input type="radio" id="new_windows_self" name="new_windows"
						value="_self" checked /> <label for="new_windows_self">当前页打开</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="new_windows_blank" name="new_windows"
						value="_blank" /> <label for="new_windows_blank">新窗口打开</label>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">外部URL网址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="外部URL网址" id="out_url" name="out_url">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">栏目标识：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="栏目标识" id="index_num" name="index_num">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">栏目首页图片：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="栏目首页图片" id="index_img" name="index_img">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">栏目列表页图片：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="栏目列表页图片" id="column_img" name="column_img">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">是否允许添加内容（只针对简介模块）：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div class="radio-box">
					<input type="radio" id="is_show0" name="is_show"
						value="0" checked /> <label for="is_show0">否</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="is_show1" name="is_show"
						value="1" /> <label for="is_show1">是</label>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">栏目修饰名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="栏目修饰名称" id="name_mark" name="name_mark">
			</div>
		</div>
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">栏目是否允许关联：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div class="radio-box">
					<input type="radio" id="rele_class0" name="rele_class"
						value="0" checked /> <label for="rele_class0">否</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="rele_class1" name="rele_class"
						value="1" /> <label for="rele_class1">是</label>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">栏目是否前台显示：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div class="radio-box">
					<input type="radio" id="display0" name="display"
						value="0" checked /> <label for="display0">否</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="display1" name="display"
						value="1" /> <label for="display1">是</label>
				</div>
			</div>
		</div> -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">排序方式：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div class="radio-box">
					<input type="radio" id="list_order1" name="list_order"
						value="1" checked /> <label for="list_order1">更新时间</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="list_order2" name="list_order"
						value="2" /> <label for="list_order2">发布时间</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="list_order3" name="list_order"
						value="3" /> <label for="list_order3">访问数</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="list_order4" name="list_order"
						value="4" /> <label for="list_order4">添加顺序正排</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="list_order5" name="list_order"
						value="5" /> <label for="list_order5">添加顺序倒排</label>
				</div>
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
<script type="text/javascript">
$(function(){
	//设置选中
	$('#module').val('${column.module}');
	//取消按钮
	$('#close_but').on('click', function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
		return false;
	});
	
}); 


//表单提交，可上传文件
$(function() {
	//表单验证
	$("#form-column-config").validate({
		rules:{
			index_num:{
				digits:true
			},
			out_url:{
				url:true
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
							parent.reloadPage();
							var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
							parent.layer.close(index); //再执行关闭
						});
					}
				};
			// 准备form表单
			$("#form-column-config").ajaxForm(options);
			//提交表单
			$("#form-column-config").ajaxSubmit(options);
			
			return false;
		}
	});
});
</script>
</body>
</body>
</html>