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
			首页 <span class="c-gray en">&gt;</span> 资格证书申报 <span class="c-gray en">&gt;</span>考试场次新增
		</nav>
		<div class="page-container">
		<form id="form_"
			action="${pageContext.request.contextPath}/zgzssb/kaoShiChangCiController/saveKaoShiChangCi.do"
			method="post">
			<table style="width: 99%" class="table table-border table-bordered">
				<tr>
					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">登录名称：</td>
					<td nowrap="nowrap"><input type="text" style="width: 90%;" placeholder="系统登录的用户名"
						id="login_name" name="login_name" value="" class="input-text" maxlength="25"
						datatype="s1-25" /> <font style="color: red">*</font></td>

					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">真实姓名：</td>
					<td nowrap="nowrap">
					<input type="text"  style="width: 90%;"  placeholder="用户名真实姓名"
						id="real_name" name="real_name" value="" class="input-text" maxlength="25" />
						<font style="color: red">*</font>
					 </td>
				</tr>
				<tr>
					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">性别：</td>
					<td nowrap="nowrap"><div class="radio-box">
							<input type="radio" id="sex_man" name="sex" value="0" checked />
							<label for="sex_man">男</label>
						</div>
						<div class="radio-box">
							<input type="radio" id="sfmj_woman" name="sex" value="1" /> <label
								for="sfmj_woman">女</label>
						</div><font style="color: red">*</font></td>

					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">用户类别：</td>
					<td nowrap="nowrap">
					<span class="select-box" style="width: 90%;">
						<select class="select" size="1" id="user_type" name="user_type">
							<option value=''>--请选择--</option>
							<c:forEach var="list" items="${bkdjCodeList}">  
	                            <option value="${list.dmz}">  
	                            	${list.dmsm1}  
	                            </option>  
                            </c:forEach>  	
						</select>
						</span>
						<font style="color: red">*</font>
					 </td>
				</tr>
				<tr>
					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">联系电话：</td>
					<td nowrap="nowrap"><input type="text" style="width: 90%;" placeholder="办公室电话，多个以逗号分隔"
						id="contact_tel" name="contact_tel" value="" class="input-text" maxlength="25"
						datatype="s1-25" /> <font style="color: red">*</font></td>

					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">手机号：</td>
					<td nowrap="nowrap">
					<input type="text"  style="width: 90%;"  placeholder="手机号码，多个以逗号分隔"
						id="contact_mobile" name="contact_mobile" value="" class="input-text" maxlength="11" />
						<font style="color: red">*</font>
					 </td>
				</tr>
				<tr>
					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">邮箱：</td>
					<td nowrap="nowrap"><input type="text" style="width: 90%;" placeholder="邮箱"
						id="email" name="email" value="" class="input-text" maxlength="25"
						datatype="s1-25" /> <font style="color: red">*</font></td>

					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">传真：</td>
					<td nowrap="nowrap">
					<input type="text"  style="width: 90%;"  placeholder="传真号码"
						id="contact_fax" name="contact_fax" value="" class="input-text" maxlength="25" />
						<font style="color: red">*</font>
					 </td>
				</tr>
				<tr>
					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">职位：</td>
					<td><span class="select-box" style="width: 90%;">
						<select class="select" size="1" id="position" name="position">
							<option value=''>--请选择--</option>
							<c:forEach var="list" items="${bkdjCodeList}">  
	                            <option value="${list.dmz}">  
	                            	${list.dmsm1}  
	                            </option>  
                            </c:forEach>  	
						</select>
						</span>
					<font
						style="color: red">*</font>
					</td>
					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">学历：</td>
					<td nowrap="nowrap"><span class="select-box" style="width: 90%;">
						<select class="select" size="1" id="education" name="education">
							<option value=''>--请选择--</option>
							<c:forEach var="list" items="${bkdjCodeList}">  
	                            <option value="${list.dmz}">  
	                            	${list.dmsm1}  
	                            </option>  
                            </c:forEach>  	
						</select>
						</span> <font style="color: red">*</font></td>
				</tr>
				<tr>
					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">民族：</td>
					<td nowrap="nowrap"><span class="select-box" style="width: 90%;">
						<select class="select" size="1" id="nation" name="nation">
							<option value=''>--请选择--</option>
							<c:forEach var="list" items="${bkdjCodeList}">  
	                            <option value="${list.dmz}">  
	                            	${list.dmsm1}  
	                            </option>  
                            </c:forEach>  	
						</select>
						</span><font style="color: red">*</font></td>

					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">政治面貌：</td>
					<td><span class="select-box" style="width: 90%;">
						<select class="select" size="1" id="political" name="political">
							<option value=''>--请选择--</option>
							<c:forEach var="list" items="${bkdjCodeList}">  
	                            <option value="${list.dmz}">  
	                            	${list.dmsm1}  
	                            </option>  
                            </c:forEach>  	
						</select>
						</span>
					<font
						style="color: red">*</font>
					</td>
				</tr>
				<tr>
					<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">备注信息：</td>
					<td colspan="3"><textarea style="width: 90%;" id="remark" placeholder="备注说明，最多300个汉字"
							name="remark" rows="2" class="textarea" maxlength="600"
							datatype="*0-300"></textarea>
					</td>
				</tr>
			</table>
			</form>
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
		</div>
		<%@ include file="../../../../common/footer_form.jsp"%>
<script type="text/javascript">
$(function(){
	//表单验证
	$("#form_").Validform();

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