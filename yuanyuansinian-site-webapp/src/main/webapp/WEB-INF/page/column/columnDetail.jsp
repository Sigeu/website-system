<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<title>用户信息表页</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 网站管理 <span class="c-gray en">&gt;</span>新增栏目
		</nav>
		<div class="page-container">
		<form id="form_"
			action="${pageContext.request.contextPath}/sinian/column/columnController/addColumn"
			method="post">
			<div class="panel panel-primary">
				<div class="panel-header">主要内容</div>
				<div class="panel-body">
					<table style="width: 99%" class="table table-border table-bordered">
				<tr>
					<td align="right" nowrap="nowrap" class="text-r mybg">上级栏目：</td>
					<td nowrap="nowrap">
						<span class="select-box" style="width: 90%;">
							<select class="select" size="1" id="big_class" name="big_class">
								<option value=''>--请选择--</option>
								<c:forEach var="list" items="${bkdjCodeList}">  
		                            <option value="${list.dmz}">  
		                            	${list.dmsm1}  
		                            </option>  
	                            </c:forEach>  	
							</select>
						</span>
					</td>
					<td align="right" nowrap="nowrap" class="text-r mybg">栏目名称：</td>
					<td nowrap="nowrap"><input type="text" style="width: 90%;" placeholder="栏目名称"
						id="name" name="name" value="" class="input-text" maxlength="25"
						datatype="s1-25" /> <font style="color: red">*</font></td>
				</tr>
				<tr>
					<td align="right" nowrap="nowrap" class="text-r mybg">所属模块：</td>
					<td nowrap="nowrap">
						<span class="select-box" style="width: 90%;">
							<select class="select" size="1" id="module" name="module">
								<option value=''>--请选择--</option>
								<c:forEach var="list" items="${bkdjCodeList}">  
		                            <option value="${list.dmz}">  
		                            	${list.dmsm1}  
		                            </option>  
	                            </c:forEach>  	
							</select>
						</span>
					 </td>
					<td align="right" nowrap="nowrap" class="text-r mybg">类型：</td>
					<td nowrap="nowrap">
						<div class="radio-box">
							<input type="radio" id="if_in_y" name="if_in" value="0" checked />
							<label for="sex_man">内容模块</label>
						</div>
						<div class="radio-box">
							<input type="radio" id="if_in_n" name="if_in" value="1" /> <label
								for="sfmj_woman">外部模块</label>
						</div>
					 </td>
				</tr>
				<tr>
					<td align="right" nowrap="nowrap" class="text-r mybg">显示位置：</td>
					<td nowrap="nowrap">
						<div class="radio-box">
							<input type="radio" id="nav_1" name="nav" value="1" checked />
							<label for="sex_man">导航</label>
						</div>
						<div class="radio-box">
							<input type="radio" id="nav_2" name="nav" value="2" />
							<label for="sex_man">尾部导航</label>
						</div>
						<div class="radio-box">
							<input type="radio" id="nav_3" name="nav" value="3" /> <label
								for="sfmj_woman">都显示</label>
						</div>
					</td>

					<td align="right" nowrap="nowrap" class="text-r mybg">排序：</td>
					<td nowrap="nowrap">
					<input type="text"  style="width: 90%;"  placeholder="排序数值，越小越靠前"
						id="list_order" name="list_order" value="" class="input-text" maxlength="11" />
					 </td>
				</tr>
			</table>
				</div>
			</div>
			<div class="panel panel-secondary mt-20">
				<div class="panel-header">选填内容</div>
				<div class="panel-body">
					<table style="width: 100%" class="table table-border table-bordered">
						<tr>
							<td align="right" nowrap="nowrap" class="text-r mybg">页面title标签内容：</td>
							<td nowrap="nowrap"><input type="text" style="width: 90%;" placeholder="页面title标签内容"
								id="ctitle" name="ctitle" value="" class="input-text" maxlength="25"
								datatype="s1-25" />
							</td>
		
							<td align="right" nowrap="nowrap" class="text-r mybg">栏目关键词：</td>
							<td nowrap="nowrap">
								<input type="text"  style="width: 90%;"  placeholder="栏目关键词，多个以空格隔开"
									id="keywords" name="keywords" value="" class="input-text" maxlength="25" />
							 </td>
						</tr>
						<tr>
							<td align="right" nowrap="nowrap" class="text-r mybg">栏目简短描述：</td>
							<td>
								<textarea style="width: 90%;" id="description" placeholder="简短描述，最多60个汉字"
									name="description" rows="2" class="textarea" maxlength="60"
									datatype="*0-60"></textarea>
							</td>
							<td align="right" nowrap="nowrap" class="text-r mybg">是否新窗口打开：</td>
							<td nowrap="nowrap">
								<div class="radio-box">
									<input type="radio" id="new_windows_n" name="new_windows" value="0" checked />
									<label for="sex_man">本窗口打开</label>
								</div>
								<div class="radio-box">
									<input type="radio" id="new_windows_y" name="new_windows" value="1" />
									<label for="sex_man">新窗口打开</label>
								</div>
							</td>
						</tr>
						<tr>
							<td align="right" nowrap="nowrap" class="text-r mybg">栏目标识：</td>
							<td nowrap="nowrap">
								<input type="text"  style="width: 90%;"  placeholder="栏目标识，非需要请不要随意修改"
									id="index_num" name="index_num" value="" class="input-text" maxlength="11" />
							</td>
		
							<td align="right" nowrap="nowrap" class="text-r mybg">栏目修饰内容：</td>
							<td>
								<input type="text" style="width: 90%;" placeholder="栏目修饰内容，如英文标题等内容"
									id="name_mark" name="name_mark" value="" class="input-text" maxlength="25"
									datatype="s1-25" />
							</td>
						</tr>
						<tr>
							<td align="right" nowrap="nowrap" class="text-r mybg">首页标识图片：</td>
							<td nowrap="nowrap">
								<span class="btn-upload form-group">
								  <input class="input-text upload-url radius" type="text" name="uploadfile-1" id="index_img" readonly><a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 浏览文件</a>
								  <input type="file" multiple name="file-1" class="input-file">
								</span>
							</td>
		
							<td align="right" nowrap="nowrap" class="text-r mybg">列表页标识图片：</td>
							<td>
								<span class="btn-upload form-group">
								  <input class="input-text upload-url radius" type="text" name="uploadfile-1" id="column_img" readonly><a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 浏览文件</a>
								  <input type="file" multiple name="file-1" class="input-file">
								</span>
							</td>
						</tr>
						<tr>
							<td align="right" nowrap="nowrap" class="text-r mybg">是否被关联：</td>
							<td nowrap="nowrap">
								<div class="radio-box">
									<input type="radio" id="rele_class_n" name="rele_class" value="0" checked />
									<label for="sex_man">不关联</label>
								</div>
								<div class="radio-box">
									<input type="radio" id="rele_class_y" name="rele_class" value="0" />
									<label for="sex_man">关联</label>
								</div>
							</td>
		
							<td align="right" nowrap="nowrap" class="text-r mybg">是否前台显示：</td>
							<td>
								<div class="radio-box">
									<input type="radio" id="display_y" name="display" value="0" checked />
									<label for="sex_man">前台显示</label>
								</div>
								<div class="radio-box">
									<input type="radio" id="display_n" name="display" value="0" />
									<label for="sex_man">前台不显示</label>
								</div>
							</td>
						</tr>
						<tr id="content_tr" style="display:none">
							<td><label class="form-label">详细内容：</label></td>
							<td colspan="3"><div class="formControls" style="width:90%"><script id="editor" type="text/plain" style="min-width:300px; height:400px"></script></div></td>
							<!-- 上面formControls的 style="width:90%"，对于编辑器的长度起作用 -->
						</tr>
					</table>
				</div>
			</div>
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
<%@ include file="../../../common/footer_form.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/ueditor/1.4.3/ueditor.config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/ueditor/1.4.3/ueditor.all.min.js"> </script>
<script type="text/javascript">
$(function(){
	//UE编辑器
	var ue = UE.getEditor('editor');
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
				parent.window.location.reload();
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
</script>
</body>
</body>
</html>