<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../../common/header.jsp"%>
<title>字典数据</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>字典数据新增
		</nav>
		<div class="page-container">
		<form id="form_"
			action="${pageContext.request.contextPath}/zgzssb/kaoShiChangCiController/saveKaoShiChangCi.do"
			method="post">
			<table style="width: 99%" class="table table-border table-bordered">
				<tr>
					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">字典名称：</td>
					<td nowrap="nowrap"><input type="text" style="width: 90%;" placeholder="字典名称"
						id="code_name" name="code_name" value="" class="input-text" maxlength="25"
						 /> <font style="color: red">*</font></td>

					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">字典值：</td>
					<td nowrap="nowrap">
					<input type="text"  style="width: 90%;"  placeholder="字典项数值"
						id="code_value" name="code_value" value="" class="input-text" maxlength="25" />
						<font style="color: red">*</font>
					 </td>
				</tr>
				<tr>
					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">排序值：</td>
					<td nowrap="nowrap"><input type="text"  style="width: 90%;"  placeholder="排序值，数值越小越靠前"
						id="order_num" name="order_num" value="" class="input-text" />
					</td>

					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">状态：</td>
					<td nowrap="nowrap">
					<div class="radio-box">
							<input type="radio" id="status_y" name="status" value="1" />
							<label for="sex_man">启用</label>
						</div>
						<div class="radio-box">
							<input type="radio" id="status_n" name="status" value="0" /> <label
								for="sfmj_woman">停用</label>
						</div>
					 </td>
				</tr>
				<tr>
					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">备注信息：</td>
					<td colspan="3"><textarea style="width: 90%;" id="remark" placeholder="备注说明，最多300个汉字"
							name="remark" rows="2" class="textarea" maxlength="600"></textarea>
					</td>
				</tr>
			</table>
			
			<table style="width: 99%">
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="center">
						<button id="submit_but" type="button"
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
	$("#form_").ajaxForm(options);
	// 表单提交     
	$('#submit_but').on('click', function() {
		$("#form_").ajaxSubmit(options);
		return false;
	});
	
});
function chooseAmAndPm(){
	var h = $dp.cal.getP('H');
	alert(h);
	//$dp.$('d523_y').value=$dp.cal.getP('y');
}

</script>
</body>
</body>
</html>