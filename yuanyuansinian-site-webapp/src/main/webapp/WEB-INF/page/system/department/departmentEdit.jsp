<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../../common/header.jsp"%>
<title>部门更新</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>更新部门
		</nav>
	<div class="page-container">
	<form action="${pageContext.request.contextPath}/system/controller/departmentController/updateDepartment" method="post" class="form form-horizontal" id="form-department-add">
		<input type="hidden" name="id" id="id" value="${department.id }" >
		<input type="hidden" name="id" id="id" value="${department.parent_code }" >
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>上级部门：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${parent_name }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>部门名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${department.dept_name }" placeholder="部门名称" id="dept_name" name="dept_name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">部门编码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${department.dept_code }" placeholder="部门编码" id="dept_code" name="dept_code">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">部门联系人：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${department.manager_user_id }" placeholder="部门联系人" id="manager_user_id" name="manager_user_id">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">联系电话：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${department.contact_tel }" placeholder="联系电话" id="contact_tel" name="contact_tel">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">传真：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${department.contact_fax }" placeholder="传真" id="contact_fax" name="contact_fax">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">备注说明：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="remark" cols="" rows="" class="textarea"  placeholder="备注说明" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="$.Huitextarealength(this,200)">${department.remark }</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		</br>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="submit_but" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button id="close_but"  class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="../../../../common/footer_form.jsp"%>
<script type="text/javascript">
$(function(){
	//表单验证
	//$("#form_").Validform();

	$('#close_but').on('click', function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
		return false;
	});
	
});


//表单提交，可上传文件
$(function() {
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
	$("#form-department-add").ajaxForm(options);
	// 表单提交     
	$('#submit_but').on('click', function() {
		$("#form-department-add").ajaxSubmit(options);
		return false;
	});
	
});
</script>
</body>
</body>
</html>