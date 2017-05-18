<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../../common/header.jsp"%>
<title>部门明细</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>查看部门
		</nav>
	<div class="page-container">
	<form action="${pageContext.request.contextPath}/system/controller/departmentController/updateDepartment" method="post" class="form form-horizontal" id="form-department-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>上级部门：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${parent_name }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>部门名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${department.dept_name }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">部门编码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${department.dept_code }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">部门联系人：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${department.manager_user_id }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">联系电话：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${department.contact_tel }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">传真：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${department.contact_fax }
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">备注说明：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${department.remark }
			</div>
		</div>
		</br>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="close_but" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
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

</script>
</body>
</body>
</html>