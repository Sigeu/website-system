<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../../common/header.jsp"%>
<title>用户信息表页</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>字典类别新增
		</nav>
		<div class="page-container">
		<form id="form_"
			action="${pageContext.request.contextPath}/system/controller/codeTypeController/addCodeType" class="form form-horizontal" 
			method="post">
			<table style="width: 99%" class="table table-border table-bordered">
				<tr>
					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">类别名称：</td>
					<td nowrap="nowrap"><input type="text" style="width: 90%;" placeholder="类别名称"
						id="type_name" name="type_name" value="" class="input-text"/> 
						<font style="color: red">*</font></td>

					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">类别代码：</td>
					<td nowrap="nowrap">
					<input type="text"  style="width: 90%;"  placeholder="类别代码"
						id="code_type" name="code_type" value="" class="input-text" />
						<font style="color: red">*</font>
					 </td>
				</tr>
				<tr>
					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">是否允许修改：</td>
					<td nowrap="nowrap"><div class="radio-box">
							<input type="radio" id="is_edit_y" name="is_edit" value="1" checked />
							<label for="sex_man">是</label>
						</div>
						<div class="radio-box">
							<input type="radio" id="is_edit_n" name="is_edit" value="0" /> <label
								for="sfmj_woman">否</label>
						</div></td>

					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">是否加载到内存：</td>
					<td nowrap="nowrap">
					<div class="radio-box">
							<input type="radio" id="is_memory_y" name="is_memory" value="1" checked />
							<label for="sex_man">是</label>
						</div>
						<div class="radio-box">
							<input type="radio" id="is_memory_n" name="is_memory" value="0" /> <label
								for="sfmj_woman">否</label>
						</div>
					 </td>
				</tr>
				<tr>
					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">备注信息：</td>
					<td colspan="3"><textarea style="width: 90%;" id="remark" placeholder="备注说明，最多300个汉字"
							name="remark" rows="2" class="textarea" maxlength="600"
							></textarea>
					</td>
				</tr>
			</table>
			
			<table style="width: 99%">
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="center">
						<button id="submit_but" type="submit"
							class="btn btn-primary radius">保存</button> &nbsp;&nbsp;
						<button class="btn btn-danger radius" id="close_but">取消</button>
					</td>
				</tr>
			</table>
		</form>
		</div>
		<%@ include file="../../../../common/footer_form.jsp"%>
<script type="text/javascript">
$(function(){
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
			type_name:{
				required:true,
				maxlength:25
			},
			code_type:{
				required:true,
				maxlength:25
			},
			remark:{
				maxlength:300
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
				$("#form_").ajaxForm(options);
				// 表单提交     
				$("#form_").ajaxSubmit(options);
				
				return false;
		}
	});
	
});

</script>
</body>
</body>
</html>