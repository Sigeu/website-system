<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<title>用户信息表页</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		网站管理 <span class="c-gray en">&gt;</span>栏目管理
	</nav>
	<div id="win"></div>
	<div id="win2"></div>
	<div data-options="fit:true" style="height: 100%">
		<div class="page-container">
			<table id="search_table" style="width: 95%;" border="0">
				<tr>
					<td align="right" width="10%" class="mybg" nowrap="nowrap">
						<strong>栏目名称:</strong>&nbsp;&nbsp;
					</td>
					<td width="10%" nowrap="nowrap"><input type="text" id="name"
						name="name" class="input-text input-collspace size-MINI" />
					</td>
					<td width="20%" align="left" nowrap="nowrap">&nbsp;&nbsp;
						<button class="btn btn-warning radius size-MINI" id="search_but">
							<i class="Hui-iconfont Hui-iconfont-search2">&nbsp;&nbsp;</i>查询
						</button> &nbsp;&nbsp;
						<button class="btn btn-success radius size-MINI" id="reset_but">
							<i class="Hui-iconfont Hui-iconfont-zhongzuo">&nbsp;&nbsp;</i>重置
						</button> &nbsp;&nbsp;
						<button class="btn btn-primary radius size-MINI" id="add_but">
							<i class="Hui-iconfont Hui-iconfont-add">&nbsp;&nbsp;</i>添加
						</button> &nbsp;&nbsp;
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
						<!-- <th>序号</th> -->
						<th width="35%">栏目名称</th>
						<th>栏目级别</th>
						<th>上级栏目</th>
						<!-- <th>是否前台显示</th> -->
						<!-- <th>栏目级别</th>
						<th>打开方式</th> -->
						<th width="15%">操作</th>
					</tr>
				</thead>
				<!-- tbody是必须的 -->
				<tbody></tbody>
			</table>
		</div>
	</div>
	<%@ include file="../../../common/footer_list.jsp"%>
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
									url : "${pageContext.request.contextPath}/column/controller/columnController/queryColumnList",
									type:"POST",
									data : {
										//args1: "固定传参"
									}
								}, 
								serverSide : true,//开启服务器模式:启用服务器分页
								lengthChange : false,//是否允许用户改变表格每页显示的记录数
								ordering : false,//是否允许用户排序
								paging : false,//是否分页
								//pagingType : "full_numbers",//除首页、上一页、下一页、末页四个按钮还有页数按钮
								processing : true,//是否显示处理状态
								/* scrollX: true,//允许水平滚动
								scrollY: "200px",
								scrollCollapse: true, */
								searching : false,//是否开始本地搜索
								stateSave : false,//刷新时是否保存状态
								autoWidth : true,//自动计算宽度
								//deferRender : true,//延迟渲染
								columns : [ {
									data : "name",
									defaultContent : ""
								}, {
									data : "class_type_name",
									defaultContent : ""
								}, {
									data : "big_class_name",
									defaultContent : ""
								}, /*{
									data : "display",
									defaultContent : ""
								},  */{
									data : null
								} ],
								columnDefs : [ {
									targets : -1,
									render : function(data, type, row, meta) {
										var context = {
											func : [{
														"name" : "设置",
														"fn" : "toConfig(\'"
																+ row.id
																+ "\')",
														"type" : "primary-outline size-MINI radius",
														"display" : true
													}, {
														"name" : "修改",
														"fn" : "toEdit(\'"
																+ row.id
																+ "\')",
														"type" : "primary-outline size-MINI radius",
														"display" :true
													}, {
														"name" : "删除",
														"fn" : "toDelete(\'"
																+ row.id
																+ "\')",
														"type" : "danger-outline size-MINI radius",
														"display" : true
													}]
										};
										var html = template(context);
										return html;
									}
								} ],
							});
			//条件查询
			$('#search_but').on('click', function() {
				oTable.settings()[0].ajax.data = getSearchParams();
				oTable.ajax.reload();
			});
			
			//获取查询条件
			function getSearchParams(){
				//栏目名称
				var name = $("#name").val().trim();
				//查询条件
				var param = {
					"name" : name
				};
				
				return param;
			}
			
			//重置
			$('#reset_but').on('click', function() {
				//名称
				$("#name").val('');
				$('#search_but').trigger("click"); 
			});
			
			//添加
			$('#add_but').on('click', function() {
				layer.open({
				    type: 2,
				    maxmin:true,
				    title:["添加"],
				    area: ['100%', '100%'],
				    shadeClose: false, //点击遮罩关闭
				    content: '${pageContext.request.contextPath}/column/controller/columnController/toColumnAdd'
				 });
			});
			
		});
		
		//修改
		function toEdit(id){
			layer.open({
			    type: 2,
			    maxmin:true,
			    title:["修改"],
			    area: ['100%', '100%'],
			    shadeClose: false, //点击遮罩关闭
			    content: '${pageContext.request.contextPath}/column/controller/columnController/toColumnUpdate?id='+id
			 });
		}
		
		//设置
		function toConfig(id){
			layer.open({
				type: 2,
			    title: '设置',
			    shadeClose: true,
			    shade: 0.8,
			    area: ['100%', '100%'],
			    content: '${pageContext.request.contextPath}/column/controller/columnController/toColumnConfig?id='+id
			 });
		}
		
		
		//删除(此处兼容批量删除)
		function toDelete(id){
			layer.confirm("确认要删除吗？栏目下的内容也会一并删！", {
				  btn: ['确认','返回'] //按钮
					}, function(index){
						$.ajax({
						    url: "${pageContext.request.contextPath}/column/controller/columnController/deleteColumn" ,
						    type: "POST",
						    dataType: "JSON",
						    data: {ids:id+','},
						    success:function(data){
						    	layer.open({
						    		  content: data.result_message,
						    		  yes: function(index, layero){
						    		    window.location.reload();//刷新当前页面
						    		    layer.close(index); //如果设定了yes回调，需进行手工关闭
						    		  }
						    		});
						    }
						});
					}, function(index){
						layer.close(index);
				}); 
		}
		
		
	</script>
</body>
</html>