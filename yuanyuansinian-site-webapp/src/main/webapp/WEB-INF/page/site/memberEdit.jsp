<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<title>内容列表</title>
</head>
<body>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<div class="container con-tab all-bg miss-con new-con">
		<div class="new-body">
			<form class="form-horizontal"
				action="${pageContext.request.contextPath}/sinian/member/memberController/updateMember"
				method="post" id="form-member-register">
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">真实姓名</label>
					<div class="col-sm-8 col-md-9">
						<input type="text" value="${memberUser.real_name}" name="real_name" id="real_name"
							class="form-control" placeholder="请输入姓名">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">昵称</label>
					<div class="col-sm-8 col-md-9">
						<input type="text" value="${memberUser.member_name}" name="member_name" id="member_name"
							class="form-control" placeholder="请输入别名">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">性别</label>
					<div class="checkbox col-sm-8 col-md-9">
						<label><input type="radio" name="sex"> 男</label> <label><input
							type="radio" name="sex"> 女</label>
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">上传头像</label>
					<div class="col-sm-8 col-md-9">
						<input type="file" id="" class="form-control"
							style="border: 0; box-shadow: none">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">密码</label>
					<div class="col-sm-8 col-md-9">
						<input type="password" name="pwd" id="pwd" class="form-control"
							placeholder="请输入密码">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">确认密码</label>
					<div class="col-sm-8 col-md-9">
						<input type="password" name="pwd2" id="pwd2" class="form-control"
							placeholder="请再吃输入密码">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">手机号码</label>
					<div class="col-sm-8 col-md-9">
						<input type="text" value="${memberUser.phone}" name="phone" id="phone" class="form-control"
							placeholder="请输入手机号码">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">电子邮箱</label>
					<div class="col-sm-8 col-md-9">
						<input type="text" value="${memberUser.email}" name="email" id="email" class="form-control"
							placeholder="请输入电子邮箱">
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">居住地</label>
					<div class="col-sm-8 col-md-9">
						<div class="col-sm-6 new-noleft">
							<select class="form-control">
								<option>山东省</option>
								<option>河北省</option>
								<option>黑龙江省</option>
								<option>江苏省</option>
								<option>陕西省</option>
							</select>
						</div>
						<div class="col-sm-6 new-noright">
							<select class="form-control">
								<option>济南市</option>
								<option>青岛市</option>
								<option>临沂市</option>
								<option>潍坊市</option>
								<option>日照市</option>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group col-sm-6">
					<label class="control-label col-sm-4 col-md-3">现住地</label>
					<div class="col-sm-8 col-md-9">
						<div class="col-sm-6 new-noleft">
							<select class="form-control">
								<option>山东省</option>
								<option>河北省</option>
								<option>黑龙江省</option>
								<option>江苏省</option>
								<option>陕西省</option>
							</select>
						</div>
						<div class="col-sm-6 new-noright">
							<select class="form-control">
								<option>济南市</option>
								<option>青岛市</option>
								<option>临沂市</option>
								<option>潍坊市</option>
								<option>日照市</option>
							</select>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="new-add">
					<button class="btn btn-warning" id="submit_but">修改</button>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/layer/2.4/layer.js"></script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/nav.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
	<script type="text/javascript">
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';

		//表单提交，可上传文件
		$(function() {
			var options = {
				success : function(data) {
					layer.alert(data.result_message, {
						closeBtn : 1
					}, function() {
						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						parent.layer.close(index); //再执行关闭
					});
				}
			};
			// 准备form表单
			$("#form-member-register").ajaxForm(options);
			// 表单提交     
			$('#submit_but').on('click', function() {
				$("#form-member-register").ajaxSubmit(options);
				return false;
			});

		});
	</script>
</body>
</html>
