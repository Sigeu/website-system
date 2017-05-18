<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../../common/header.jsp"%>
<title>字典类别</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		系统管理 <span class="c-gray en">&gt;</span>字典类别
	</nav>
	<div id="win"></div>
	<div id="win2"></div>
	<div data-options="fit:true" style="height: 100%">
		<div class="page-container">
			<table id="search_table" style="width: 95%;" border="0">
				<tr>
					<td align="right" width="10%" class="mybg" nowrap="nowrap">
						<strong>字典类别名称:</strong>&nbsp;&nbsp;
					</td>
					<td width="10%" nowrap="nowrap"><input type="text" id="type_name"
						name="type_name" class="input-text input-collspace size-MINI" />
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
					<tr class="text-c mybg">
						<th>序号</th>
						<th>类别名称</th>
						<th>类别代码</th>
						<th>是否可修改</th>
						<th>是否加载内存</th>
						<th>备注</th>
						<th width="15%">操作</th>
					</tr>
				</thead>
				<!-- tbody是必须的 -->
				<tbody></tbody>
			</table>
		</div>
	</div>
	<%@ include file="../../../../common/footer_list.jsp"%>
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
									url : "${pageContext.request.contextPath}/system/controller/codeTypeController/queryCodeTypeList",
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
									data : "id"
								}, {
									data : "type_name",
									defaultContent : ""
								}, {
									data : "code_type",
									defaultContent : ""
								}, {
									data : "is_edit_name",
									defaultContent : ""
								}, {
									data : "is_memory_name",
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
											func : [
													{
														"name" : "修改",
														"fn" : "toEdit(\'"
																+ row.id
																+ "\')",
														"type" : "primary-outline size-MINI radius",
														"display" : row.zt == '1'? false:true
													},{
														"name" : "删除",
														"fn" : "toDelete(\'"
																+ row.id
																+ "\')",
														"type" : "primary-outline size-MINI radius",
														"display" : row.zt == '1'? true:false
													},{
														"name" : "数据管理",
														"fn" : "toDetail(\'"
																+ row.id
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
			$('#search_but').on('click', function() {
				oTable.settings()[0].ajax.data = getSearchParams();
				oTable.ajax.reload();
			});
			
			//获取查询条件
			function getSearchParams(){
				//类别名称
				var type_name = $("#type_name").val().trim();
				//查询条件
				var param = {
					"type_name" : type_name
				};
				
				return param;
			}
			
			//重置
			$('#reset_but').on('click', function() {
				//类别名称
				$("#type_name").val('');
			});
			
			//添加
			$('#add_but').on('click', function() {
				layer.open({
				    type: 2,
				    maxmin:true,
				    title:["<strong><div class='Hui-iconfont Hui-iconfont-feedback2' style='color: white'>&nbsp;&nbsp;添加类别</div></strong>","background-color: #5a97df"],
				    area: ['100%', '100%'],
				    shadeClose: false, //点击遮罩关闭
				    content: '${pageContext.request.contextPath}/system/controller/codeTypeController/toCodeTypeAdd'
				 });
			});
			
		});

		//重新加载页面：子页面调用
		function reloadPage(){
			window.location.reload();//刷新当前页面.
		}
		
		//修改
		function toEdit(id){
			layer.open({
			    type: 2,
			    maxmin:true,
			    title:["<strong><div class='Hui-iconfont Hui-iconfont-feedback2' style='color: white'>&nbsp;&nbsp;修改用户</div></strong>","background-color: #5a97df"],
			    area: ['100%', '100%'],
			    shadeClose: false, //点击遮罩关闭
			    content: '${pageContext.request.contextPath}/system/controller/codeTypeController/toCodeTypeUpdate?id='+id
			 });
		}
		//删除
		function toDelete(id){
			layer.confirm("确认要删除吗？类别删除会同时删除对应的字典数据", {
				  btn: ['确认','返回'] //按钮
					}, function(index){
						$.ajax({
						    url: "${pageContext.request.contextPath}/zgzssb/kaoShiChangCiController/issueKaoShiChangCi.do" ,
						    type: "POST",
						    dataType: "JSON",
						    data: {id:id},
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
		
		//查看明细
		function toDetail(id){
			layer.open({
			    type: 2,
			    maxmin:true,
			    title:["<strong><div class='Hui-iconfont Hui-iconfont-feedback2' style='color: white'>&nbsp;&nbsp;字典数据</div></strong>","background-color: #5a97df"],
			    area: ['100%', '100%'],
			    shadeClose: false, //点击遮罩关闭
			    content: '${pageContext.request.contextPath}/system/controller/codeTypeController/toCodeTypeDetail?id='+id
			 });
		}
		
		//考生列表
		function toShowList(id){
			layer.open({
			    type: 2,
			    maxmin:true,
			    title:["<strong><div class='Hui-iconfont Hui-iconfont-feedback2' style='color: white'>&nbsp;&nbsp;修改用户</div></strong>","background-color: #5a97df"],
			    area: ['100%', '100%'],
			    shadeClose: false, //点击遮罩关闭
			    content: '${pageContext.request.contextPath}/zgzssb/kaoShengXinXiController/toKaoShengXinXiList.do?kscc='+id
			 });
		}
		
	</script>
</body>
</html>