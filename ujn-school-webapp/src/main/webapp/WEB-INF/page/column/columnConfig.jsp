<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<title>栏目设置</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>栏目设置
		</nav>
	<div class="page-container">
	<form action="${pageContext.request.contextPath}/column/controller/columnController/updateColumnConfig" method="post" class="form form-horizontal" id="form-column-config">
		<input type="hidden" name="id" id="id_" value="${column.id }">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">外部URL网址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${column.out_url }" placeholder="外部URL网址" id="out_url" name="out_url">
			</div>
		</div>
		<c:if test="${column.class_type == '2' }">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">目录分类编码(2位)：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${column.add_class }" placeholder="目录分类编码(2位)" id="add_class" name="add_class">
			</div>
		</div>
		</c:if>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">栏目是否前台显示：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div class="radio-box">
					<input type="radio" id="display0" name="display"
						value="0" /> <label for="display0">否</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="display1" name="display"
						value="1" checked/> <label for="display1">是</label>
				</div>
			</div>
		</div> 
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
						value="4" /> <label for="list_order4">排序值正序</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="list_order5" name="list_order"
						value="5" /> <label for="list_order5">排序值倒序</label>
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
	$("input[name='display'][value='${column.display}']").attr("checked",true);
	$("input[name='list_order'][value='${column.list_order}']").attr("checked",true);
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
							parent.window.location.reload();
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