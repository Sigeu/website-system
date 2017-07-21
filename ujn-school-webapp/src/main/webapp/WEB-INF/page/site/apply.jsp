<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header-site.jsp"%>
<title>信息公开申请</title>
<style type="text/css">
.c-red, .c-red a, a.c-red {
    color: red;
}

.clearfix:after{content:"\20";display:block;height:0;clear:both;visibility:hidden}.clearfix{zoom:1}
.tabBar {border-bottom: 2px solid #222}
.tabBar span {background-color: #e8e8e8;cursor: pointer;display: inline-block;float: left;font-weight: bold;height: 30px;line-height: 30px;padding: 0 15px}
.tabBar span.current{background-color: #222;color: #fff}
.tabCon {display: none}
</style>
</head>
<body class="pos-r">
<%@ include file="siteHeader.jsp"%>

<%@ include file="page-pic.jsp"%>

<div class="article all-con cat-con">
	<div class="container">
		<div class="row">
			<div id="tab_demo"  class=" HuiTab col-md-9 article-sidebarl list-sidebarl list-sidebarr">
				<div class="article-top text-center apply-top" style="margin-top:-10px">
					<h1 style="margin-bottom:30px">信息公开申请</h1>
					<ul class="nav nav-tabs">
						<div class="tabBar clearfix"><span>个人</span><span>法人 / 其他组织</span><span>反馈结果</span></div>
						<!-- <li class="active"><a href="#" style="border-bottom-color: transparent; margin-bottom:0">个人</a></li>
						<li><a href="#">法人 / 其他组织</a></li>
						<li><a href="#" id="feedback"><span class="hidden-xs">根据确认码查看</span>反馈结果</a></li> -->
					</ul>
				</div>
				<div class="tabCon apply-con">
					<form action="${pageContext.request.contextPath}/apply/controller/applyController/addApply" method="post"  class="form-horizontal" id="form_">
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label"><span class="c-red">*</span>个人姓名</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="text" class="form-control" value="" placeholder="请输入您的姓名" id="user_name" name="user_name">
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label"><span class="c-red">*</span>所在工作单位</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="text" class="form-control" value="" placeholder="请输入您的工作单位" id="user_unit" name="user_unit">
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label"><span class="c-red">*</span>个人联系电话</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="text" class="form-control" value="" placeholder="请输入您的联系电话" id="user_tel" name="user_tel">
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label"><span class="c-red">*</span>通信地址 </label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="text" class="form-control" value="" placeholder="请输入您的通信地址" id="address" name="address">
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label"><span class="c-red">*</span>邮政编码</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="text" class="form-control" value="" placeholder="请输入您的邮政编码" id="postcode" name="postcode">
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label">证件类型</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<select class="form-control" id="id_type" name="id_type">
									<option value="身份证">身份证</option>
									<option value="护照">护照</option>
								</select>
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label"><span class="c-red">*</span>证件号码</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="text" class="form-control" value="" placeholder="请输入您的证件号码" id="id_num" name="id_num">
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
							<label class="col-sm-2 col-md-4 col-lg-3"><span class="c-red">*</span>所需信息的内容描述</label>
							<textarea id="content" name="content" class="form-control" rows="5" style="margin:10px 0 0 2%; width:87%; " placeholder="内容描述,最多500字。" ></textarea>
						</div>
						<div class="form-group apply-area">
							<label class="col-sm-2 col-md-4 col-lg-3"><span class="c-red">*</span>申请获取信息的理由</label>
							<textarea id="reason" name="reason" class="form-control" rows="5" style="margin:10px 0 0 2%; width:87%;" placeholder="申请获取信息的理由,最多500字。" ></textarea>
						</div>
						<div class="form-group apply-area">
							<label class="col-sm-2 col-md-4 col-lg-3">备注</label>
							<textarea id="remark" name="remark" class="form-control" rows="5" style="margin:10px 0 0 2%; width:87%; "placeholder="备注说明,最多500字。" ></textarea>
						</div>
						<!-- <div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label">确认码</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="text" class="form-control" value="" placeholder="确认码用于下次查询反馈结果" id="check_pwd" name="check_pwd">
							</div>
						</div> -->
						<br/>
						<div class="form-btn">
							<button class="btn btn-default" type="reset" style="margin-right:40px">重置</button>
							<button class="btn btn-primary" type="submit"  style="">提交</button>
						</div>
					</form>
				</div>
				
				<div class="tabCon">
					<form action="${pageContext.request.contextPath}/apply/controller/applyController/addApply" method="post"  class="form-horizontal" id="form_">
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label"><span class="c-red">*</span>法人姓名</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="text" class="form-control" value="" placeholder="请输入您的姓名" id="user_name" name="user_name">
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label"><span class="c-red">*</span>单位名称</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="text" class="form-control" value="" placeholder="请输入您的工作单位" id="user_unit" name="user_unit">
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label"><span class="c-red">*</span>单位地址 </label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="text" class="form-control" value="" placeholder="请输入您的通信地址" id="address" name="address">
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label"><span class="c-red">*</span>联系电话</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="text" class="form-control" value="" placeholder="请输入法人的联系电话" id="user_tel" name="user_tel">
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label"><span class="c-red">*</span>邮政编码</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="text" class="form-control" value="" placeholder="请输入您的邮政编码" id="postcode" name="postcode">
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label">法人证件名称</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<select class="form-control" id="id_type" name="id_type">
									<option value="身份证">身份证</option>
									<option value="护照">护照</option>
								</select>
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label"><span class="c-red">*</span>法人证件号码</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="text" class="form-control" value="" placeholder="请输入您的证件号码" id="id_num" name="id_num">
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label">上传法人证件</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="file" id="exampleInputFile" class="form-control"style="border:0; box-shadow:none">
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label"><span class="c-red">*</span>统一社会信用代码</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="text" class="form-control" value="" placeholder="请输入您的证件号码" id="id_num" name="id_num">
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label">上传营业执照</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="file" id="exampleInputFile" class="form-control"style="border:0; box-shadow:none">
							</div>
						</div>
						
						<div class="clearfix"></div>
						<div class="form-group apply-area">
							<label class="col-sm-2 col-md-4 col-lg-3"><span class="c-red">*</span>所需信息的内容描述</label>
							<textarea id="content" name="content" class="form-control" rows="5" style="margin:10px 0 0 2%; width:87%; " placeholder="内容描述,最多500字。" ></textarea>
						</div>
						<div class="form-group apply-area">
							<label class="col-sm-2 col-md-4 col-lg-3"><span class="c-red">*</span>申请获取信息的理由</label>
							<textarea id="reason" name="reason" class="form-control" rows="5" style="margin:10px 0 0 2%; width:87%;" placeholder="申请获取信息的理由,最多500字。" ></textarea>
						</div>
						<div class="form-group apply-area">
							<label class="col-sm-2 col-md-4 col-lg-3">备注</label>
							<textarea id="remark" name="remark" class="form-control" rows="5" style="margin:10px 0 0 2%; width:87%; "placeholder="备注说明,最多500字。" ></textarea>
						</div>
						<!-- <div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label">确认码</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="text" class="form-control" value="" placeholder="确认码用于下次查询反馈结果" id="check_pwd" name="check_pwd">
							</div>
						</div> -->
						<br/>
						<div class="form-btn">
							<button class="btn btn-default" type="reset" style="margin-right:40px">重置</button>
							<button class="btn btn-primary" type="submit"  style="">提交</button>
						</div>
					</form>
				</div>
				<div class="tabCon">
					<form action="${pageContext.request.contextPath}/apply/controller/applyController/addApply" method="post"  class="form-horizontal" id="form_">
						<div class="form-group col-md-6">
							<label class="col-sm-2 col-md-4 col-lg-3 control-label"><span class="c-red">*</span>确认码</label>
							<div class="col-sm-9 col-md-8 col-lg-9">
								<input type="text" class="form-control" value="" placeholder="请输入您的确认码" id="check_pwd" name="check_pwd">
							</div>
						</div>
						<br/>
						<div class="form-btn">
							<button class="btn btn-default" type="reset" style="margin-right:40px">重置</button>
							<button class="btn btn-primary" type="submit"  style="">提交</button>
						</div>
					</form>
				</div>
			</div>
<%@ include file="articleListSidebar.jsp"%>
		</div>
	</div>
</div>

<%@ include file="siteFooter.jsp"%>

<%@ include file="../../../common/footer-site.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/static/h-ui/js/H-ui.js"></script> 
<!-- 表单验证 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<!-- form提交 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
<script type="text/javascript">
var contextPath = "${pageContext.request.contextPath}";
$(function(){
	$('#close_but').on('click', function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
		return false;
	});
	
	$.Huitab("#tab_demo .tabBar span","#tab_demo .tabCon","current","click","1");
});


//表单提交，可上传文件
$(function() {
	//表单验证
	$("#form_").validate({
		rules:{
			user_name:{
				required:true,
				maxlength:20
			},
			user_unit:{
				required:true,
				maxlength:100
			},
			user_tel:{
				required:true,
				digits:true
			},
			address:{
				required:true,
				maxlength:200
			},
			postcode:{
				required:true,
				digits:true,
				maxlength:6
			},
			id_num:{
				required:true,
				maxlength:18
			},
			content:{
				required:true,
				maxlength:500
			},
			reason:{
				required:true,
				maxlength:500
			},
			open_type:{
				required:true,
				maxlength:500
			},
			remark:{
				maxlength:500
			}
		},
		onkeyup:false,
		focusCleanup:false,
		success:"valid",
		submitHandler:function(form){
			var options = {
					success : function(data) {
						layer.alert(data.result_message);
					}
				};
			// 准备form表单
			$("#form_").ajaxForm(options);
			//提交表单
			$("#form_").ajaxSubmit(options);
			
			return false;
		}
	});
});
</script>
</body>
</body>
</html>