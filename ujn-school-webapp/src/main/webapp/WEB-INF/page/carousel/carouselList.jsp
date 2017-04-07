<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<title>轮播图片表页</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		系统管理 <span class="c-gray en">&gt;</span>轮播图片管理
	</nav>
	<div id="win"></div>
	<div id="win2"></div>
	<div data-options="fit:true" style="height: 100%">
		<div class="page-container">
			<table id="search_table" style="width: 95%;" border="0">
				<tr>
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
						<th><input type="checkbox" name="" value=""></th>
						<th>标题</th>
						<th>URL</th>
						<th>图片</th>
						<th>描述</th>
						<th>备注说明</th>
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
									url : "${pageContext.request.contextPath}/carousel/carouselController/queryCarouselList",
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
								},  {
									data : "title",
									defaultContent : 0
								}, {
									data : "img_url",
									defaultContent : ""
								}, {
									data : "id",
									render : function(data, type, row, meta) {
										var context = '<img width="210" class="picture-thumb" src="' + '${pageContext.request.contextPath}/carousel/carouselController/queryImgById?id=' + data + '">';
										return context;
									}
								}, {
									data : "description",
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
														"display" : true
													},{
														"name" : "删除",
														"fn" : "toDelete(\'"
																+ row.id
																+ "\')",
														"type" : "danger-outline size-MINI radius",
														"display" : row.zt == '1'? false:true
													},{
														"name" : "查看",
														"fn" : "toDetail(\'"
																+ row.id
																+ "\')",
														"type" : "primary-outline size-MINI radius",
														"display" : false
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
				//登录名称
				var login_name = $("#login_name").val().trim();
				//真实姓名
				var real_name = $("#real_name").val().trim();
				//注册时间
				var date_start = $("#date_start").val().trim();
				var date_end = $("#date_end").val().trim();
				//查询条件
				var param = {
					"login_name" : login_name,
					"real_name" : real_name,
					"date_start" : date_start,
					"date_end" : date_end
				};
				
				return param;
			}
			
			//重置
			$('#reset_but').on('click', function() {
				//登录名称
				$("#login_name").val('');
				//真实姓名
				$("#real_name").val('');
				//注册时间
				$("#date_start").val('');
				$("#date_end").val('');
				
			});
			
			//添加
			$('#add_but').on('click', function() {
				layer.open({
				    type: 2,
				    maxmin:true,
				    title:["<strong><div class='Hui-iconfont Hui-iconfont-feedback2' style='color: white'>&nbsp;&nbsp;添加栏目</div></strong>","background-color: #5a97df"],
				    area: ['100%', '100%'],
				    shadeClose: false, //点击遮罩关闭
				    content: '${pageContext.request.contextPath}/carousel/carouselController/toCarouselAdd'
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
			    content: '${pageContext.request.contextPath}/carousel/carouselController/toCarouselUpdate?id='+id
			 });
		}
		//删除
		function toDelete(id){
			layer.confirm("确认删除？", {
				  btn: ['确认','返回'] //按钮
					}, function(index){
						$.ajax({
						    url: "${pageContext.request.contextPath}/carousel/carouselController/deleteCarousel" ,
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
		
		//查看
		function toDetail(id){
			layer.open({
			    type: 2,
			    maxmin:true,
			    title:["<strong><div class='Hui-iconfont Hui-iconfont-feedback2' style='color: white'>&nbsp;&nbsp;用户明细</div></strong>","background-color: #5a97df"],
			    area: ['100%', '100%'],
			    shadeClose: false, //点击遮罩关闭
			    content: '${pageContext.request.contextPath}/carousel/carouselController/toCarouselDetail?id='+id
			 });
		}
		
	</script>
</body>
</html>