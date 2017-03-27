<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header-site.jsp"%>
<title>用户信息表页</title>
</head>
<body class="pos-r">
<%@ include file="siteHeader.jsp"%>

<%@ include file="page-pic.jsp"%>

<div class="article all-con cat-con">
	<div class="container">
		<div class="row">
			<div class="col-md-9 article-sidebarl list-sidebarl list-sidebarr">
				<div class="article-top text-center apply-top" style="margin-top:-10px">
					<h1 style="margin-bottom:30px">信息公开申请</h1>
					<ul class="nav nav-tabs">
						<li class="active"><a href="#" style="border-bottom-color: transparent; margin-bottom:0">公民</a></li>
						<li><a href="#">法人 / 其他组织</a></li>
						<li><a href="#" id="feedback"><span class="hidden-xs">根据确认码查看</span>反馈结果</a></li>
					</ul>
				</div>
				<div class="apply-con">
					<form class="form-horizontal">
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label">姓名</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="email" class="form-control" placeholder="请输入您的姓名">
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label">工作单位</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="email" class="form-control" placeholder="请输入您的工作单位">
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label">联系电话</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="email" class="form-control" placeholder="请输入您的联系电话">
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label">申请时间</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="email" class="form-control" placeholder="2016-12-20 12:20" disabled>
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label">通信地址 </label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="email" class="form-control" placeholder="请输入您的通信地址">
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label">邮政编码</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="email" class="form-control" placeholder="请输入您的邮政编码">
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label">证件名称</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<select class="form-control">
									<option>身份证</option>
									<option>学生证</option>
									<option>驾驶证</option>
									<option>护照</option>
								</select>
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label">证件号码</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="email" class="form-control" placeholder="请输入您的证件号码">
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label">上传证件</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="file" id="exampleInputFile" class="form-control"style="border:0; box-shadow:none">
							</div>
						</div>
						<div class="clearfix"></div>
						<div class="form-group apply-area">
							<label class="col-sm-2 col-md-4 col-lg-3">所需信息的内容描述</label>
							<textarea class="form-control" rows="5" style="margin:10px 0 0 2%; width:87%; ">请控制在100字以内</textarea>
						</div>
						<div class="form-group apply-area">
							<label class="col-sm-2 col-md-4 col-lg-3">申请获取信息的理由</label>
							<textarea class="form-control" rows="5" style="margin:10px 0 0 2%; width:87%; ">请控制在100字以内</textarea>
						</div>
						<div class="form-group apply-area">
							<label class="col-sm-2 col-md-4 col-lg-3">所需信息的公开方式</label>
							<textarea class="form-control" rows="5" style="margin:10px 0 0 2%; width:87%; ">请控制在100字以内</textarea>
						</div>
						<div class="form-group apply-area">
							<label class="col-sm-2 col-md-4 col-lg-3">备注</label>
							<textarea class="form-control" rows="5" style="margin:10px 0 0 2%; width:87%; ">请控制在100字以内</textarea>
						</div>
						<div class="form-btn">
							<button class="btn btn-default" style="margin-right:40px">重置</button>
							<button class="btn btn-primary" style="">提交</button>
						</div>
					</form>
				</div>
			</div>
<%@ include file="articleListSidebar.jsp"%>
		</div>
	</div>
</div>

<%@ include file="siteFooter.jsp"%>

<!-- 模态框声明 -->
<div class="modal fade" id="myFeedback" tabindex="-1" style="font-family:微软雅黑">
	<!-- 窗口声明 -->
	<div class="modal-dialog">
		<!-- 内容声明 -->
		<div class="modal-content">
			<div class="modal-header">
				<button class="close " data-dismiss="modal"><span>&times;</span></button>
				<h4 class="modal-title">用户信息反馈</h4>
			</div>
			<div class="modal-body">
				<div class="container-fluid">
					<form class="form-horizontal" style="font-family:微软雅黑; font-size:15px">
						<label class="control-label" style="color:#333">请输入您的确认码：</label>
						<div style="margin:10px 0">
							<input type="text" class="form-control" placeholder="请输入您的确认码">	
						</div>
					</form>
				</div>
			</div>
			<div class="modal-footer" style="margin-right:15px">
				<button class="btn btn-default" style="width:70px; font-family:微软雅黑">重置</button>
				<button class="btn btn-primary" style="width:70px; font-family:微软雅黑">提交</button>
			</div>
		</div>
	</div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">

$('#feedback').on('click', function () {
	$('#myFeedback').modal('show');
});

$('#myFeedback').modal({
	show : false,
	backdrop: 'static',
});

</script>
<%@ include file="../../../common/footer-site.jsp"%>
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
	$("#form-user-add").ajaxForm(options);
	// 表单提交     
	$('#submit_but').on('click', function() {
		$("#form-user-add").ajaxSubmit(options);
		return false;
	});
	
});
</script>
</body>
</body>
</html>