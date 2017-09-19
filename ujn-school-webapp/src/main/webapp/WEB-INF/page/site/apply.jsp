<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link href="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<title>信息公开申请</title>
<style type="text/css">
.c-red, .c-red a, a.c-red {
    color: red;
}
.but_hidden{position: absolute; visibility: hidden;}
.clearfix:after{content:"\20";display:block;height:0;clear:both;visibility:hidden}.clearfix{zoom:1}
.tabBar {border-bottom: 2px solid #222}
.tabBar span {background-color: #e8e8e8;cursor: pointer;display: inline-block;float: left;font-weight: bold;height: 30px;line-height: 30px;padding: 0 15px}
.tabBar span.current{background-color: #222;color: #fff}
.tabCon {display: none}

.btn-upload{position: relative; display:inline-block;height:36px; *display:inline;overflow:hidden;vertical-align:middle;cursor:pointer}
.upload-url{cursor: pointer}
.input-file{position:absolute; right:0; top:0; cursor: pointer; z-index:1; font-size:30em; *font-size:30px;opacity:0;filter: alpha(opacity=0)}
.btn-upload .input-text{ width:auto}
.form-group .upload-btn{ margin-left:-1px}

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
					</ul>
				</div>
				<div class="tabCon apply-con">
					<form action="${pageContext.request.contextPath}/apply/controller/applyController/addApply" method="post"  class="form-horizontal" id="form_personal">
						<input type="hidden" name="user_type" id="user_type" value="1">
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">姓名</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<input type="text" class="form-control" placeholder="请输入您的姓名" id="user_name" name="user_name">
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">工作单位</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<input type="text" class="form-control" placeholder="请输入您的工作单位" id="user_unit" name="user_unit">
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">联系电话</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<input type="text" class="form-control" placeholder="请输入您的联系电话" id="user_tel" name="user_tel">
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">通信地址 </label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<input type="text" class="form-control" placeholder="请输入您的通信地址" id="address" name="address">
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">邮政编码</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<input type="text" class="form-control" placeholder="请输入您的邮政编码" id="postcode" name="postcode">
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">证件类型</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<select class="form-control" id="id_type" name="id_type">
									<option value="身份证">身份证</option>
									<option value="护照">护照</option>
								</select>
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">证件号码</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<input type="text" class="form-control" placeholder="请输入您的证件号码" id="id_num" name="id_num">
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">上传证件(10M以内)</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<iframe src="${pageContext.request.contextPath}/apply/controller/applyController/toApplyIdPicUpload" name="idiframe" id="idiframe" 
										scrolling="no" frameborder="0" ></iframe>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">上传附件(50M以内)</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<%-- <iframe src="${pageContext.request.contextPath}/apply/controller/applyController/toApplyFilePicUpload" name="fileiframe" id="fileiframe" 
										scrolling="no" frameborder="0" ></iframe> --%>
								<span class="btn-upload form-group">
								  <input class="input-text upload-url radius"  type="text" name="uploadfile-1" id="uploadfile-1" readonly>&nbsp;&nbsp;<a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 浏览文件</a>
								  <input type="file" multiple name="file-apply" class="input-file">
								</span>
							</div>
						</div>
						<div class="clearfix"></div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-2 col-md-3 control-label">所需信息的内容描述</label>
							<textarea id="content" name="content" class="col-xs-12 col-sm-6 col-md-6 " rows="5" placeholder=""></textarea>
							
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-2 col-md-3 control-label">申请获取信息的理由</label>
							<textarea id="reason" name="reason" class="col-xs-12 col-sm-6 col-md-6" rows="5" placeholder=""></textarea>
							
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-2 col-md-3 control-label">备注</label>
							<textarea id="remark" name="remark" class="col-xs-12 col-sm-6 col-md-6" rows="5" placeholder=""></textarea>
							
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-2 col-md-3 control-label">信息公开申请表下载</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<span class="btn-upload form-group">
								<a href="##">信息公开申请表</a>
								</span>
							</div>
						</div>
						<br/>
						<div class="form-btn">
							<button class="btn btn-default" type="reset" style="margin-right:30px">重置</button>
							<button class="btn btn-primary" id="personal_submit" type="submit">提交</button>
						</div>
					</form>
				</div>
				
				<div class="tabCon apply-con">
					<form action="${pageContext.request.contextPath}/apply/controller/applyController/addApply" method="post"  class="form-horizontal" id="form_company">
						<input type="hidden" name="credit_code_file" value="" id="credit_code_file">
						<input type="hidden" name="user_type" id="user_type" value="2">
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">法人姓名</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<input type="text" class="form-control" placeholder="请输入您的姓名" id="user_name" name="user_name">
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">工作单位</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<input type="text" class="form-control" placeholder="请输入您的工作单位" id="user_unit" name="user_unit">
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">统一社会信用代码</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<input type="text" class="form-control" placeholder="请输入您的证件号码" id="credit_code" name="credit_code">
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">联系电话</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<input type="text" class="form-control" placeholder="请输入您的联系电话" id="user_tel" name="user_tel">
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">通信地址 </label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<input type="text" class="form-control" placeholder="请输入您的通信地址" id="address" name="address">
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">邮政编码</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<input type="text" class="form-control" placeholder="请输入您的邮政编码" id="postcode" name="postcode">
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">法人证件类型</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<select class="form-control" id="id_type" name="id_type">
									<option value="身份证">身份证</option>
									<option value="护照">护照</option>
								</select>
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">法人证件号码</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<input type="text" class="form-control" placeholder="请输入您的证件号码" id="id_num" name="id_num">
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">法人证件附件(10M以内)</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<iframe src="${pageContext.request.contextPath}/apply/controller/applyController/toApplyIdPicUpload" name="idiframe" id="idiframe" 
										scrolling="no" frameborder="0" ></iframe>
							</div>
						</div>
						<%-- <div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">企业营业执照附件</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<iframe src="${pageContext.request.contextPath}/apply/controller/applyController/toApplyCreditPicUpload" name="creditiframe" id="creditiframe" 
										scrolling="no" frameborder="0" ></iframe>
							</div>
						</div> --%>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">企业营业执照附件(10M以内)</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<span class="btn-upload form-group">
								  <input class="input-text upload-url radius"  type="text" name="uploadfile-1" id="uploadfile-1" readonly>&nbsp;&nbsp;<a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 浏览文件</a>
								  <input type="file" multiple name="file-credit" class="input-file">
								</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-md-3 control-label">上传附件(50M以内)</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<span class="btn-upload form-group">
								  <input class="input-text upload-url radius"  type="text" name="uploadfile-1" id="uploadfile-1" readonly>&nbsp;&nbsp;<a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 浏览文件</a>
								  <input type="file" multiple name="file-apply" class="input-file">
								</span>
							</div>
						</div>
						<div class="clearfix"></div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-2 col-md-3 control-label">所需信息的内容描述</label>
							<textarea id="content" name="content" class="col-xs-12 col-sm-6 col-md-6 " rows="5" placeholder=""></textarea>
							
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-2 col-md-3 control-label">申请获取信息的理由</label>
							<textarea id="reason" name="reason" class="col-xs-12 col-sm-6 col-md-6" rows="5" placeholder=""></textarea>
							
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-2 col-md-3 control-label">备注</label>
							<textarea id="remark" name="remark" class="col-xs-12 col-sm-6 col-md-6" rows="5" placeholder=""></textarea>
							
						</div>
						<div class="form-group">
							<label class="col-xs-12 col-sm-2 col-md-3 control-label">信息公开申请表下载</label>
							<div class="col-sm-6 col-md-6 apply-pos">
								<span class="btn-upload form-group">
									<a href="##">信息公开申请表</a>
								</span>
							</div>
						</div>
						<br/>
						<div class="form-btn">
							<button class="btn btn-default" type="reset" style="margin-right:30px">重置</button>
							<button class="btn btn-primary" type="submit" id="company_but">提交</button>
						</div>
					</form>
				</div>
				<div class="tabCon apply-con">
					<div data-options="fit:true" style="height: 100%">
						<div class="page-container">
							<table id="search_table" style="width: 95%;" border="0">
								<tr>
									<td align="right" width="10%" class="mybg" nowrap="nowrap">
										<strong>申请确认码:</strong>&nbsp;&nbsp;
									</td>
									<td width="10%" nowrap="nowrap"><input type="text" id="check_pwd"
										name="check_pwd" placeholder="申请确认码" class="input-text input-collspace size-MINI" />
									</td>
									<td width="20%" align="left" nowrap="nowrap">&nbsp;&nbsp;
										<button class="btn btn-warning radius size-MINI" id="reply_search_but">
											<i class="Hui-iconfont Hui-iconfont-search2">&nbsp;&nbsp;</i>查询
										</button> &nbsp;&nbsp;
										<button class="btn btn-success radius size-MINI" id="reply_reset_but">
										<i class="Hui-iconfont Hui-iconfont-zhongzuo">&nbsp;&nbsp;</i>重置
									</td>
								</tr>
				
								<tr>
									<td colspan="5">&nbsp;&nbsp;</td>
								</tr>
							</table>
							<table id="data_table" style="width: 98%" style="text-align: center;"
								class="table table-border table-bordered  table-hover table-striped">
								<thead>
									<tr class="text-c">
										<th>申请人</th>
										<th>申请日期</th>
										<th>申请内容</th>
										<th width="8%">操作</th>
									</tr>
								</thead>
								<!-- tbody是必须的 -->
								<tbody></tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
<%@ include file="articleListSidebar.jsp"%>
		</div>
	</div>
</div>

<%@ include file="siteFooter.jsp"%>

<%@ include file="../../../common/footer-site.jsp"%>
<%@ include file="../../../common/footer_list.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/static/h-ui/js/H-ui.js"></script> 
<!-- 表单验证 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<!-- form提交 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.min.js"></script>
<!-- 模版 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/handlebars-v4.0.5.js"></script>
<!--定义操作列按钮模板-->
<script id="tpl" type="text/x-handlebars-template">
	{{#each func}}
		{{#if this.display}}
			<button type="button" class="btn btn-{{this.type}} btn-sm" onclick="{{this.fn}}">{{this.name}}</button>
		{{/if}} 
		{{else}}
	{{/each}} 
</script>
<script type="text/javascript">
var contextPath = "${pageContext.request.contextPath}";
var apply_id = '';
var check_pwd = '';
var credit_path = '';
$(function(){
	$('#close_but').on('click', function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
		return false;
	});
	
	$.Huitab("#tab_demo .tabBar span","#tab_demo .tabCon","current","click","0");
});


//个人申请表单提交
$(function() {
	
	var options = {
			success : function(data) {
				apply_id = data.apply_id;
				check_pwd = data.check_pwd;
				//确保图片上传
				var idiframe = $("#form_personal  #idiframe")[0].contentWindow;
				var imgList = $("#form_personal  #idiframe").contents().find("#fileList").children('div');
				if (imgList.length > 0) {
					// not empty
					$("#form_personal #idiframe").contents().find('#ctlBtn').trigger('click');
				} else {
					if(data.flag == 'succ'){
						layer.alert("请保存好您的确认码，用于查看申请结果：" + data.check_pwd,
								{
									closeBtn : 1
								},
								function() {
									//父页面刷新
									parent.window.location
											.reload();
									var index = parent.layer
											.getFrameIndex(window.name); //先得到当前iframe层的索引
									parent.layer
											.close(index); //再执行关闭
								});
					}else{
						layer.alert( "提交失败",
								{
									closeBtn : 1
								},
								function() {
									//父页面刷新
									parent.window.location
											.reload();
									var index = parent.layer
											.getFrameIndex(window.name); //先得到当前iframe层的索引
									parent.layer
											.close(index); //再执行关闭
								});
					}
				}
			}
		};
	
	//表单验证
	$("#form_personal").validate({
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
			remark:{
				maxlength:500
			}
		},
		onkeyup:false,
		//onsubmit:false,
		focusCleanup:false,
		success:"valid",
		submitHandler:function(form){
			// 准备form表单
			$("#form_personal").ajaxForm(options);
			// 表单提交     
			$("#form_personal").ajaxSubmit(options);

			return false;
			
		}
	});
	
});

//企业申请表单提交
$(function() {
	
	var options_company = {
			success : function(data) {
				apply_id = data.apply_id;
				check_pwd = data.check_pwd;
				//确保图片上传
				var idiframe = $("#form_company  #idiframe")[0].contentWindow;
				var imgList = $("#form_company  #idiframe").contents().find("#fileList").children('div');
				if (imgList.length > 0) {
					// not empty
					$("#form_company #idiframe").contents().find('#ctlBtn').trigger('click');
				} else {
					if(data.flag == 'succ'){
						layer.alert("请保存好您的确认码，用于查看申请结果：" + data.check_pwd,
								{
									closeBtn : 1
								},
								function() {
									//父页面刷新
									parent.window.location
											.reload();
									var index = parent.layer
											.getFrameIndex(window.name); //先得到当前iframe层的索引
									parent.layer
											.close(index); //再执行关闭
								});
					}else{
						layer.alert( "提交失败",
								{
									closeBtn : 1
								},
								function() {
									//父页面刷新
									parent.window.location
											.reload();
									var index = parent.layer
											.getFrameIndex(window.name); //先得到当前iframe层的索引
									parent.layer
											.close(index); //再执行关闭
								});
					}
				}
			}
		};
	
	//表单验证
	$("#form_company").validate({
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
			remark:{
				maxlength:500
			}
		},
		onkeyup:false,
		//onsubmit:false,
		focusCleanup:false,
		success:"valid",
		submitHandler:function(form){
			// 准备form表单
			$("#form_company").ajaxForm(options_company);
			// 表单提交     
			$("#form_company").ajaxSubmit(options_company);

			return false;
			
		}
	});
	
});
	//初始化
	$(function() {
		//按钮模版
		var tpl = $("#tpl").html();
		//预编译模板
		var template = Handlebars.compile(tpl);
		//初始化表格
		var oTable = $("#data_table")
				.DataTable(
						{
							ajax : {
								url : "${pageContext.request.contextPath}/apply/controller/applyController/queryApplyByPwd",
								type:"POST",
								data : {
									///check_pwd: $('#check_pwd').val()
								}
							}, 
							serverSide : true,//开启服务器模式:启用服务器分页
							lengthChange : false,//是否允许用户改变表格每页显示的记录数
							ordering : false,//是否允许用户排序
							paging : true,//是否分页
							pagingType : "full_numbers",//除首页、上一页、下一页、末页四个按钮还有页数按钮
							processing : true,//是否显示处理状态
							/* scrollX: true,//允许水平滚动
							scrollY: "200px",
							scrollCollapse: true, */
							searching : false,//是否开始本地搜索
							stateSave : false,//刷新时是否保存状态
							autoWidth : true,//自动计算宽度
							//deferRender : true,//延迟渲染
							columns : [ {
								data : "user_name",
								defaultContent : ""
							}, {
								data : "create_date",
								defaultContent : ""
							}, {
								data : "content",
								defaultContent : ""
							}, {
								data : null
							} ],
							columnDefs : [ {
								targets : -1,
								render : function(data, type, row, meta) {
									var context = {
										func : [
												{
													"name" : "查看",
													"fn" : "toDetail(\'"
															+ row.id + "\',\'" + row.check_pwd
															+ "\')",
													"type" : "primary-outline size-MINI radius",
													"display" : true
												} ]
									};
									var html = template(context);
									return html;
								}
							} ],
							language : {
								lengthMenu : "每页显示 _MENU_记录",
								zeroRecords : "没有匹配的数据",
								info : "第_PAGE_页 / 共_PAGES_页",
								infoEmpty : "",
								search : "查找",
								infoFiltered : "",
								paginate : {
									"first" : "首页 ",
									"last" : "末页",
									"next" : "下一页",
									"previous" : "上一页"
								}
							}
						});
		//条件查询
		$('#reply_search_but').on('click', function() {
			oTable.settings()[0].ajax.data = getSearchParams();
			oTable.ajax.reload();
		});
		
		//获取查询条件
		function getSearchParams(){
			//
			var check_pwd = $("#check_pwd").val().trim();
			//查询条件
			var param = {
				"check_pwd" : check_pwd
			};
			return param;
		}
		
		//重置
		$('#reply_reset_but').on('click', function() {
			//标题
			$("#check_pwd").val('');
			$('#reply_search_but').trigger('click');
		});
	});
	
	//查看
	function toDetail(id,check_pwd){
		window.open('${pageContext.request.contextPath}/apply/controller/applyController/toShowReplyApplyDetail?id=' + id + '&check_pwd=' + check_pwd ,'查看',"fullscreen=1")
	}
</script>
</body>
</body>
</html>