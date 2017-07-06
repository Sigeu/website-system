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
		首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>字典类别
	</nav>
	<div class="page-container">
		<table style="width: 99%" class="table table-border table-bordered">
			<tr>
				<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">类别名称：</td>
				<td>${codeType.type_name }</td>

				<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">类别代码：</td>
				<td>${codeType.code_type }</td>
			</tr>
			<tr>
				<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">是否允许修改：</td>
				<td>${codeType.is_edit_name }</td>

				<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">是否加载到内容：</td>
				<td>${codeType.is_memory_name }</td>
			</tr>
			<tr>
				<td align="right" width="16%" nowrap="nowrap" class="text-r mybg">备注信息：</td>
				<td colspan="3">${codeType.remark }</td>
			</tr>
		</table>
		</br>
		<center>
			<button class="btn btn-primary radius size-MINI" id="add_but">
				<i class="Hui-iconfont Hui-iconfont-add">&nbsp;&nbsp;</i>添加
			</button> &nbsp;&nbsp;
			<button class="btn btn-danger radius size-MINI" id="close_but">
				<i class="Hui-iconfont Hui-iconfont-add">&nbsp;&nbsp;</i>返回
			</button> &nbsp;&nbsp;
		</center>
		</br>
		<table id="data_table" style="width: 98%" style="text-align: center;"
			class="table table-border table-bordered  table-hover table-striped">
			<thead>
				<tr class="text-c mybg">
					<th>序号</th>
					<th>字典名称</th>
					<th>字典值</th>
					<th>状态</th>
					<th>备注说明</th>
					<th width="15%">操作</th>
				</tr>
			</thead>
			<!-- tbody是必须的 -->
			<tbody></tbody>
		</table>
	</div>
</body>

<%@ include file="../../../../common/footer_list.jsp"%>
<!--定义操作列按钮模板-->
<script id="tpl" type="text/x-handlebars-template">
	{{#each func}}
		<button type="button" class="btn btn-{{this.type}} btn-sm" onclick="{{this.fn}}">{{this.name}}</button>
	{{/each}} 
</script>
<script type="text/javascript">
//表单提交，可上传文件
$(function() {
	$('#close_but').on('click', function() {
		//当你在iframe页面关闭自身时
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭 
	});
	
	$('#add_but').on('click', function() {
		layer.open({
		    type: 2,
		    maxmin:true,
		    title:["<strong><div class='Hui-iconfont Hui-iconfont-feedback2' style='color: white'>&nbsp;&nbsp;添加</div></strong>","background-color: #5a97df"],
		    area: ['100%', '100%'],
		    shadeClose: false, //点击遮罩关闭
		    content: '${pageContext.request.contextPath}/system/controller/codeController/toCodeAdd?code_type='+ '${codeType.code_type }'
		 });
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
								url : "${pageContext.request.contextPath}/system/controller/codeController/queryCodeList",
								type:"POST",
								//dataSrc : "list",//这个参数是自己封装的json里面的key
								data : {
									code_type: "${codeType.code_type }"
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
									data : "id"
								}, {
									data : "code_name",
									defaultContent : ""
								}, {
									data : "code_value",
									defaultContent : ""
								}, {
									data : "status_name",
									defaultContent : ""
								}, {
									data : "remark",
									defaultContent : ""
								}, {
									data : null
								} ],
							columnDefs : [ {
								targets : -1,
								render : function(data, type, row, meta) {
									var context = {
										func : [{
													"name" : "修改",
													"fn" : "toEdit(\'"
															+ row.id
															+ "\')",
													"type" : "primary-outline size-MINI radius",
													"display" : true
												},{
													"name" : "删除",
													"fn" : "toDelete(\'"
															+ row.id
															+ "\')",
													"type" : "danger-outline size-MINI radius",
													"display" : row.status == '1'? false : true
												}]
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
	});
	
    //查看
	function toDetail(id){
		layer.open({
		    type: 2,
		    maxmin:true,
		    title:["<strong><div class='Hui-iconfont Hui-iconfont-feedback2' style='color: white'>&nbsp;&nbsp;查看</div></strong>","background-color: #5a97df"],
		    area: ['100%', '100%'],
		    shadeClose: false, //点击遮罩关闭
		    content: '${pageContext.request.contextPath}/system/controller/codeController/toCodeDetail?id='+id
		 });
	}
    
    //查看
	function toEdit(id){
		layer.open({
		    type: 2,
		    maxmin:true,
		    title:["<strong><div class='Hui-iconfont Hui-iconfont-feedback2' style='color: white'>&nbsp;&nbsp;修改</div></strong>","background-color: #5a97df"],
		    area: ['100%', '100%'],
		    shadeClose: false, //点击遮罩关闭
		    content: '${pageContext.request.contextPath}/system/controller/codeController/toCodeUpdate?id='+id
		 });
	}
    
	//重新加载页面：子页面调用
	function reloadPage(){
		window.location.reload();//刷新当前页面.
	}
	
	//删除
	function toDelete(id){
		layer.confirm("确认删除？", {
			  btn: ['确认','返回'] //按钮
				}, function(index){
					$.ajax({
					    url: "${pageContext.request.contextPath}/system/controller/codeController/deleteCode" ,
					    type: "POST",
					    dataType: "JSON",
					    data: {id:id},
					    success:function(data){
					    	layer.alert(data.result_message, {
								  closeBtn: 1
								}, function(){
									//父页面刷新
									window.location.reload();//刷新当前页面.
									//var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
									//parent.layer.close(index); //再执行关闭
								});
					    }
					});
				}, function(index){
					layer.close(index);
			}); 
	}

</script>
</body>
</body>
</html>