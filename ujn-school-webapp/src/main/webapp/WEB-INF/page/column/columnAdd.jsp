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
			首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>新增内容
		</nav>
	<div class="page-container">
	<form action="${pageContext.request.contextPath}/column/controller/columnController/addColumn" method="post" class="form form-horizontal" id="form-column-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>上级栏目：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<input type="text" class="input-text" value="" placeholder="上级栏目" id="big_class_name" name="big_class_name" readonly="readonly">
				<input type="hidden" name="big_class" id="big_class" value="">
				<input type="hidden" name="class_type" id="class_type" value="">
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
				<input type="text" class="input-text" value="1" placeholder="排序值，越小越靠前" id="no_order" name="no_order">
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
var contextPath = '${pageContext.request.contextPath}';
$(function(){
	//取消按钮
	$('#close_but').on('click', function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
		return false;
	});
	//设置栏目等级。默认为1
	$("#big_class").on('change',function(){
		var big_class_type = $(this).find("option:selected").attr('classtype');
		if(typeof(big_class_type) == "undefined"){
			$('#class_type').val('1');
		}else{
			var class_type = new Number(big_class_type) + 1;
			$('#class_type').val(class_type);
		}
	}); 
	
	
	//选择上级菜单
	$("#big_class_name").click(function(){
		utils.treeSelectColumn(false,'',function(columnList){
			if(columnList && columnList.length > 0){
				var column = columnList[0];
				$('#big_class_name').val(column.name);
				$('#big_class').val(column.id);
				$('#class_type').val(column.class_type);
			}
		});
	});
	
	
}); 


//表单提交，可上传文件
$(function() {
	//表单验证
	$("#form-column-add").validate({
		rules:{
			name:{
				required:true,
				maxlength:100
			},
			no_order:{
				required:true,
				digits:true
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
							parent.window.location.reload();
							var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
							parent.layer.close(index); //再执行关闭
						});
					}
				};
			// 准备form表单
			$("#form-column-add").ajaxForm(options);
			//提交表单
			$("#form-column-add").ajaxSubmit(options);
			
			return false;
		}
	});
});
</script>
</body>
</body>
</html>