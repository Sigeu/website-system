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
		<%-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>所属栏目：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" id="column_id" name="column_id">
					<option value="0">--请选择--</option>  
                    <c:forEach items="${columnSelectList}" var="column">  
                    	<option value="${column.id}">${column.name}</option>  
                    </c:forEach>  
				</select>
				</span> 
			</div>
		</div> --%>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>一级栏目：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" id="class1" name="class1">
					<option value="0">--请选择--</option>  
                    <c:forEach items="${columnListByLevel}" var="column">  
                    	<option value="${column.id}">${column.name}</option>  
                    </c:forEach>  
				</select>
				</span> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>二级栏目：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" id="class2" name="class2">
					<option value="">--请选择--</option>  
				</select>
				</span> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>三级栏目：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" id="class3" name="class3">
					<option value="">--请选择--</option>  
				</select>
				</span> 
			</div>
		</div>
		<%-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>编号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${orderNum }" placeholder="编号" id="code_num" name="code_num" readonly="readonly">
			</div>
		</div> --%>
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
				<textarea name="description" cols="" rows="" class="textarea"  placeholder="描述说明" datatype="*10-100" dragonfly="true" onKeyUp="$.Huitextarealength(this,200)"></textarea>
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
		<!-- <div class="row cl input-label">
			<label class="form-label col-xs-4 col-sm-2">添加之前：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="添加之前的样子" id="" name="">
			</div>
		</div>
		<div class="row cl btn-label">
			<label class="form-label col-xs-4 col-sm-2">添加之后：</label>
			<div class="formControls col-xs-8 col-sm-9">
				选择的标签出现在这里
				<span class="btn btn-primary">财务信息</span>
				<span class="btn btn-primary">院办公开文件</span>
				<span class="btn btn-primary">招生信息</span>
				选择的标签 end
				<input type="text" class="input-text" value="" placeholder='请输入标签名称，多个标签之间用 " , " 隔开' id="" name="">
			</div>
		</div>
		<div class="row cl btn-label btn-prompt">
			提示标签
			<label class="form-label col-xs-4 col-sm-2"></label>占位置
			<div class="formControls col-xs-8 col-sm-9">
				<button class="btn" type="button">JAVA</button>
				<button class="btn" type="button">PHP</button>
				<button class="btn" type="button">财务信息</button>
				<button class="btn" type="button">JAVA</button>
				<button class="btn" type="button">PHP</button>
				<button class="btn" type="button">院办公开文件</button>
				<button class="btn" type="button">JAVA</button>
				<button class="btn" type="button">招生信息</button>
				<button class="btn" type="button">BootStrap</button>
			</div>
			提示标签 end
		</div> -->
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">重要信息标签：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="重要信息标签，可以手动录入或选择已有常用标签" id="importance" name="importance">
			</div>
		</div>
		<div class="row cl btn-label btn-prompt">
			<label class="form-label col-xs-4 col-sm-2"></label>
			<div class="formControls col-xs-8 col-sm-9" id="importance_content">
				<c:forEach items="${codeImportantList}" var="codeImportant" varStatus="code"> 
				 	<c:if test="${code.index < 10}">
                  		<button class="btn" type="button">${codeImportant.code_value }</button>
                  	</c:if> 
                 </c:forEach> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">内容标签：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="内容标签，可以手动录入或选择已有常用标签" id="tag" name="tag">
			</div>
		</div>
		<div class="row cl btn-label btn-prompt">
			<!-- 提示标签 -->
			<label class="form-label col-xs-4 col-sm-2"></label><!-- 占位置 -->
			<div class="formControls col-xs-8 col-sm-9" id="tag_content">
				 <c:forEach items="${codeContentList}" var="codeContent" varStatus="code"> 
				 	<c:if test="${code.index < 10}">
                  		<button class="btn" type="button">${codeContent.code_value }</button>
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
			<label class="form-label col-xs-4 col-sm-2">目录分类：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
					<select class="select" id="class_code" name="class_code">
						<option value="">--请选择--</option> 
						<c:forEach items="${classCodeList}" var="classCode" varStatus="code"> 
	                  		<option value="${classCode.code_value }">${classCode.code_name }</option> 
	                 	</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">外部链接：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="链接到网站外部的网址" id="links" name="links">
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
$(function(){
	//UE编辑器
	var ue = UE.getEditor('editor');
	//取消按钮
	$('#close_but').on('click', function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
		return false;
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
			},
			links:{
				url:true
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