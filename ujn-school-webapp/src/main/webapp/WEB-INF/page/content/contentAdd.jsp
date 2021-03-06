<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<script type="text/javascript">
//window.k = "/static/hui/admin3.0/lib/ueditor/1.4.3/";//编辑器项目路径
</script>
<title>内容信息表页</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>新增内容
		</nav>
	<div class="page-container">
	<form action="${pageContext.request.contextPath}/content/controller/contentController/addContent" method="post" class="form form-horizontal" id="form-content-add">
		<input type="hidden" name="read_pwd" id="read_pwd" value="${randomPwd }" >
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>所属栏目：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<input type="text" class="input-text" value="" placeholder="所属栏目" id="column_id_name" name="column_id_name" readonly="readonly">
				<input type="hidden" name="column_id" id="column_id" value="">
				<input type="hidden" name="class1" id="class1" value="">
				<input type="hidden" name="class2" id="class2" value="">
				<input type="hidden" name="class3" id="class3" value="">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>标题：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="标题" id="title" name="title">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">详细内容：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<script id="editor" name="content" type="text/plain" style="width:100%;height:400px;"></script> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">描述说明：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="description" id="description" cols="" rows="" class="textarea"  placeholder="描述说明" datatype="*10-100" dragonfly="true" onKeyUp="$.Huitextarealength(this,200)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">排序值：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="0" placeholder="排序值，越小越靠前" id="no_order" name="no_order">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">有效期：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" class="input-text Wdate"  value="" placeholder="内容公示截止有效期,不填为永久有效" id="validity_time" name="validity_time">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">重要信息标签(手输无效)：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" readonly="readonly" placeholder="重要信息标签，可以手动录入或选择已有常用标签" id="importance" name="importance">
			</div>
		</div>
		<div class="row cl btn-label btn-prompt">
			<label class="form-label col-xs-4 col-sm-2"></label>
			<div class="formControls col-xs-8 col-sm-9" id="importance_content">
				<c:forEach items="${codeImportantList}" var="codeImportant" varStatus="code"> 
				 	<c:if test="${code.index < 10}">
                  		<button class="btn" type="button">${codeImportant.code_name }</button>
                  	</c:if> 
                 </c:forEach> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">关键词：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="关键词，可以手动录入或选择已有常用标签" id="tag" name="tag">
			</div>
		</div>
		<div class="row cl btn-label btn-prompt">
			<!-- 提示标签 -->
			<label class="form-label col-xs-4 col-sm-2"></label><!-- 占位置 -->
			<div class="formControls col-xs-8 col-sm-9" id="tag_content">
				 <c:forEach items="${codeContentList}" var="codeContent" varStatus="code"> 
				 	<c:if test="${code.index < 10}">
                  		<button class="btn" type="button">${codeContent.code_name }</button>
                  	</c:if> 
                 </c:forEach> 
			</div>
			<!-- 提示标签 end -->
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">阅读方式：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
					<select class="select" id="read_type" name="read_type">
						<option value="0">社会公众</option> 
						<option value="1">校内访问</option> 
						<option value="2">仅部分人可访问</option>  
					</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">公开分类：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
					<select class="select" id="open_type_code" name="open_type_code">
						<option value="1">主动公开</option> 
						<option value="2">依申请公开</option>  
					</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">是否置顶显示：</label>
			 <div class="radio-box">
			    <input type="radio" id="top_ok-0" value="0" name="top_ok"  checked>
			    <label for="radio-1">不置顶</label>
			  </div>
			  <div class="radio-box">
			    <input type="radio" id="top_ok-1" value="1" name="top_ok">
			    <label for="radio-2">置顶显示</label>
			  </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">添加时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="" placeholder="不填则为当前时间" id="add_time" name="add_time" class="input-text Wdate">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">更新时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="" placeholder="不填则为当前时间" id="update_time" name="update_time" class="input-text Wdate">
			</div>
		</div>
		</br>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="submit_but" class="btn btn-secondary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button id="close_but" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="../../../common/footer_form.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/ueditor/1.4.3/ueditor.config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/ueditor/1.4.3/ueditor.all.min.js"> </script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/content.js"> </script>
<script type="text/javascript">
var contextPath = '${pageContext.request.contextPath}';
var ue;
$(function(){
	//UE编辑器
	ue = UE.getEditor('editor');
	//取消按钮
	$('#close_but').on('click', function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
		return false;
	});
	
	//所属栏目
	$("#column_id_name").click(function(){
		utils.treeSelectColumnForContent(false,'',function(columnList){
			if(columnList && columnList.length > 0){
				var column = columnList[0];
				$('#column_id_name').val(column.name);
				$('#column_id').val(column.column_id);
				$('#class1').val(column.class1);
				$('#class2').val(column.class2);
				$('#class3').val(column.class3);
			}
		});
	});
	
});


//表单提交，可上传文件
$(function() {
	//表单验证
	$("#form-content-add").validate({
		rules:{
			title:{
				required:true,
				maxlength:100
			},
			no_order:{
				digits:true
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
							parent.window.location.reload();
							var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
							parent.layer.close(index); //再执行关闭
						});
					}
				};
				if($('#description').val() == ''){
					var contentTxt = ue.getContentTxt();
					if(contentTxt.length > 200){
						$('#description').val(contentTxt.substring(0,200));
					}else{
						$('#description').val(contentTxt);
					}
				}
				// 准备form表单
				$("#form-content-add").ajaxForm(options);
				// 表单提交     
				$("#form-content-add").ajaxSubmit(options);
				
				return false;
		}
	});
	
});
</script>
</body>
</body>
</html>