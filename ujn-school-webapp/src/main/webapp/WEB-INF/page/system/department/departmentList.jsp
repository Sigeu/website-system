<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../../common/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/admin3.0/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" />
<title>部门表页</title>
</head>
<body class="pos-r">
<div class="pos-a" style="width:260px;overflow:scroll;left:0;top:0; bottom:0; height:100%; border-right:1px solid #e5e5e5; background-color:#f5f5f5">
	<br>
	<ul id="dept_tree" class="ztree"></ul>
</div>
<div style="margin-left:260px;">
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 部门管理 <span class="c-gray en">&gt;</span> 部门列表 
	</nav>
	<div class="page-container">
		<table id="search_table" style="width: 95%;" border="0">
				<tr>
					<td align="right" width="10%" class="mybg" nowrap="nowrap">
						<strong>部门名称:</strong>&nbsp;&nbsp;
					</td>
					<td width="10%" nowrap="nowrap"><input type="text" id="dept_name"
						name="dept_name" class="input-text input-collspace size-MINI" />
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
					<td colspan="3">&nbsp;&nbsp;</td>
				</tr>
			</table>
			<table id="data_table" style="width: 98%" style="text-align: center;"
				class="table table-border table-bordered  table-hover table-striped">
				<input type="hidden" name="parent_code" id="parent_code" value="" >
				<thead>
					<tr class="text-c mybg">
						<th>序号</th>
						<th>部门代码</th>
						<th>部门名称</th>
						<th>上级部门</th>
						<th>部门联系人</th>
						<th>联系电话</th>
						<th>传真</th>
						<th width="15%">操作</th>
					</tr>
				</thead>
				<!-- tbody是必须的 -->
				<tbody></tbody>
			</table>
		
	</div>
</div>
<%@ include file="../../../../common/footer_list.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/zTree/v3/js/jquery.ztree.core-3.5.min.js"></script> 
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
	var setting = {
			check: {
				enable: true,
				nocheckInherit: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: toShowList
			}
		};
	
	function toShowList(event, treeId, treeNode, clickFlag){
		//查询条件
		var param = {
			"treeNode" : treeNode.id
		};
		$('#parent_code').val(treeNode.id);
		var myTable = $("#data_table").DataTable();
		myTable.settings()[0].ajax.data = param;
		myTable.ajax.reload();
	}
	
		$(function(){
			$.ajax({
				 type: "post",
				 url: "${pageContext.request.contextPath}/system/controller/departmentController/queryDepartmentTree.do",
	             data: {},
	             dataType: "json",
	             success: function(data){
	            	 $.fn.zTree.init($("#dept_tree"), setting, data);
	             },
	             error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus);
                },
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
									url : "${pageContext.request.contextPath}/system/controller/departmentController/queryDepartmentList",
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
									data : "dept_code",
									defaultContent : ""
								}, {
									data : "dept_name",
									defaultContent : ""
								}, {
									data : "dept_main",
									defaultContent : ""
								}, {
									data : "manager_user_id",
									defaultContent : ""
								}, {
									data : "contact_tel",
									defaultContent : ""
								}, {
									data : "contact_fax",
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
														"name" : "查看",
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
				//部门名称
				var dept_name = $("#dept_name").val().trim();
				//查询条件
				var param = {
					"dept_name" : dept_name
				};
				
				return param;
			}
			
			//重置
			$('#reset_but').on('click', function() {
				$("#dept_name").val('');
				$('#search_but').trigger('click');
			});
			
			//添加
			$('#add_but').on('click', function() {
				layer.open({
				    type: 2,
				    maxmin:true,
				    title:["添加"],
				    area: ['100%', '100%'],
				    shadeClose: false, //点击遮罩关闭
				    content: '${pageContext.request.contextPath}/system/controller/departmentController/toDepartmentAdd?parent_code=' + $('#parent_code').val()
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
			    title:["修改"],
			    area: ['100%', '100%'],
			    shadeClose: false, //点击遮罩关闭
			    content: '${pageContext.request.contextPath}/system/controller/departmentController/toDepartmentUpdate?id='+id
			 });
		}
		
		//查看明细
		function toDetail(id){
			layer.open({
			    type: 2,
			    maxmin:true,
			    title:["查看"],
			    area: ['100%', '100%'],
			    shadeClose: false, //点击遮罩关闭
			    content: '${pageContext.request.contextPath}/system/controller/departmentController/toDepartmentDetail?id='+id
			 });
		}

		
	</script>
</body>
</html>