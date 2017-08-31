<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<title>用户信息表页</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		系统管理 <span class="c-gray en">&gt;</span>内容审核
	</nav>
	<div id="win"></div>
	<div id="win2"></div>
	<div data-options="fit:true" style="height: 100%">
		<div class="page-container">
			<table id="search_table" style="width: 95%;" border="0">
				<tr>
					<td align="right" width="10%" class="mybg" nowrap="nowrap">
						<strong>内容标题:</strong>&nbsp;&nbsp;
					</td>
					<td width="10%" nowrap="nowrap"><input type="text" id="title"
						name="title" placeholder="标题" class="input-text input-collspace size-MINI" />
					</td>
					<td align="right" width="10%" class="mybg" nowrap="nowrap">
						<strong>内容关键字:</strong>&nbsp;&nbsp;
					</td>
					<td width="10%" nowrap="nowrap"><input type="text" id="keywords"
						name="keywords" placeholder="关键字" class="input-text input-collspace size-MINI" />
					</td>
					<td width="20%" align="left" nowrap="nowrap">&nbsp;&nbsp;
						<button class="btn btn-warning radius size-MINI" id="search_but">
							<i class="Hui-iconfont Hui-iconfont-search2">&nbsp;&nbsp;</i>查询
						</button> &nbsp;&nbsp;
						<button class="btn btn-success radius size-MINI" id="reset_but">
							<i class="Hui-iconfont Hui-iconfont-zhongzuo">&nbsp;&nbsp;</i>重置
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
						<th><input type="checkbox" name="" value=""></th>
						<th>标题</th>
						<th>发布人</th>
						<th>更新时间</th>
						<th>添加时间</th>
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
									url : "${pageContext.request.contextPath}/audit/controller/auditController/queryAuditContentList",
									type:"POST",
									data : {
										//args1: "固定传参"
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
									data : "id",
									render: function (data, type, full, meta) {
					                     return '<input type="checkbox" value="' + data + '" />';
					                 }
								}, {
									data : "title",
									defaultContent : "",
									render : function(data, type, row, meta) {
										var context = '<a href="##" onclick="toDetail(\'' + row.id + '\')">'+ data + '</a>';
										return context;
									}
								}, {
									data : "issue_name",
									defaultContent : ""
								}, {
									data : "update_time",
									defaultContent : ""
								}, {
									data : "add_time",
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
														"name" : "通过",
														"fn" : "toAuditTrue(\'"
																+ row.id
																+ "\')",
														"type" : "primary-outline size-MINI radius",
														"display" : true
													},{
														"name" : "不通过",
														"fn" : "toAuditFalse(\'"
																+ row.id
																+ "\')",
														"type" : "danger-outline size-MINI radius",
														"display" : true
													},
													<shiro:hasPermission name="24">
													{
														"name" : "删除",
														"fn" : "toDelete(\'"
																+ row.id
																+ "\')",
														"type" : "danger-outline size-MINI radius",
														"display" : true
													}
													</shiro:hasPermission> 
													]
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
			$('#search_but').on('click', function() {
				oTable.settings()[0].ajax.data = getSearchParams();
				oTable.ajax.reload();
			});
			
			//获取查询条件
			function getSearchParams(){
				//标题
				var title = $("#title").val().trim();
				//关键字
				var keywords = $("#keywords").val().trim();
				//查询条件
				var param = {
					"title" : title,
					"keywords" : keywords
				};
				
				return param;
			}
			
			//重置
			$('#reset_but').on('click', function() {
				//标题
				$("#title").val('');
				//关键字
				$("#keywords").val('');
				
			});
			
		});

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
						    url: "${pageContext.request.contextPath}/content/controller/contentController/deleteContent" ,
						    type: "POST",
						    dataType: "JSON",
						    data: {id:id},
						    success:function(data){
						    	layer.alert(data.result_message, {
									  closeBtn: 1
									}, function(){
										//父页面刷新
										window.location.reload();//刷新当前页面.
										var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
										parent.layer.close(index); //再执行关闭
									});
						    }
						});
					}, function(index){
						layer.close(index);
				}); 
		}

		
		//审核不通过
		function toAuditFalse(id){
			layer.confirm("确认不通过？", {
				  btn: ['确认','返回'] //按钮
					}, function(index){
						$.ajax({
						    url: "${pageContext.request.contextPath}/content/controller/contentController/auditContent" ,
						    type: "POST",
						    dataType: "JSON",
						    data: {id : id,
						    	status : '3'
						    },
						    success:function(data){
						    	layer.alert(data.result_message, {
									  closeBtn: 1
									}, function(){
										//父页面刷新
										window.location.reload();//刷新当前页面.
										var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
										parent.layer.close(index); //再执行关闭
									});
						    }
						});
					}, function(index){
						layer.close(index);
				}); 
		}
		
		//审核通过
		function toAuditTrue(id){
			layer.confirm("确认通过？", {
				  btn: ['确认','返回'] //按钮
					}, function(index){
						$.ajax({
						    url: "${pageContext.request.contextPath}/content/controller/contentController/auditContent" ,
						    type: "POST",
						    dataType: "JSON",
						    data: {id : id,
						    	status : '1'
						    },
						    success:function(data){
						    	layer.alert(data.result_message, {
									  closeBtn: 1
									}, function(){
										//父页面刷新
										window.location.reload();//刷新当前页面.
										var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
										parent.layer.close(index); //再执行关闭
									});
						    }
						});
					}, function(index){
						layer.close(index);
				}); 
		}
		
		
		//查看
		function toDetail(id){
			var url = '${pageContext.request.contextPath}/index/controller/indexController/toContentDetail?id='+id;
			window.open ( url, "内容查看" ,"_blank") ;
			/* layer.open({
			    type: 2,
			    maxmin:true,
			    title:["查看"],
			    area: ['100%', '100%'],
			    shadeClose: false, //点击遮罩关闭
			    content: '${pageContext.request.contextPath}/index/controller/indexController/toContentDetail?id='+id
			 }); */
		}
	</script>
</body>
</html>