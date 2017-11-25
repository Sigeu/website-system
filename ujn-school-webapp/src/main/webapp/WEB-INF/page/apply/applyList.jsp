<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<title>在线申请列表</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		在线申请管理 <span class="c-gray en">&gt;</span>在线申请
	</nav>
	<div id="win"></div>
	<div id="win2"></div>
	<div data-options="fit:true" style="height: 100%">
		<div class="page-container">
			<table id="search_table" style="width: 95%;" border="0">
				<tr>
					<td align="right" width="10%" class="mybg" nowrap="nowrap">
						<strong>申请分类:</strong>&nbsp;&nbsp;
					</td>
					<td width="10%" nowrap="nowrap"><span class="select-box" style="width: 90%;">
						<select class="select" size="1" id="user_type" name="user_type" >
							<option value=''>--请选择--</option>
	                            <option value="1">个人</option> 
	                            <option value="2">企业/组织</option> 
						</select>
						</span>
					</td>
					<td width="20%" align="left" nowrap="nowrap">&nbsp;&nbsp;
						<button class="btn btn-warning radius size-MINI" id="search_but">
							<i class="Hui-iconfont Hui-iconfont-search2">&nbsp;&nbsp;</i>查询
						</button> &nbsp;&nbsp;
						<button class="btn btn-success radius size-MINI" id="reset_but">
							<i class="Hui-iconfont Hui-iconfont-zhongzuo">&nbsp;&nbsp;</i>重置
						</button> &nbsp;&nbsp;
						 <button class="btn btn-primary radius size-MINI" id="export_but">
							<i class="Hui-iconfont Hui-iconfont-daochu">&nbsp;&nbsp;</i>导出
						</button> &nbsp;&nbsp;
						<button class="btn btn-danger radius size-MINI" id="delete_but">
							<i class="Hui-iconfont Hui-iconfont-del3">&nbsp;&nbsp;</i>批量删除
						</button> 
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
						<th><input type="checkbox" name="check_apply" id="check_all" value=""></th>
						<th>申请人姓名</th>
						<th>申请日期</th>
						<th>分类</th>
						<th>联系电话</th>
						<th>工作单位</th>
						<th>申请内容</th>
						<th>申请原因</th>
						<th>备注说明</th>
						<th>附件</th>
						<th>状态</th>
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
			//设置默认值
			$("#check_all").prop("checked",false); 
			//预编译模板
			var template = Handlebars.compile(tpl);

			//初始化表格
			var oTable = $("#data_table")
					.DataTable(
							{
								ajax : {
									url : "${pageContext.request.contextPath}/apply/controller/applyController/queryApplyList",
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
					                     return '<input type="checkbox" name="check_apply" value="' + data + '" />';
					                 }
								}, {
									data : "user_name",
									defaultContent : ""
								}, {
									data : "create_date",
									defaultContent : ""
								}, {
									data : "user_type_name",
									defaultContent : ""
								}, {
									data : "user_tel",
									defaultContent : ""
								}, {
									data : "user_unit",
									defaultContent : ""
								}, {
									data : "content",
									defaultContent : ""
								}, {
									data : "reason",
									defaultContent : ""
								}, {
									data : "remark",
									defaultContent : ""
								}, {
									data : "apply_file",
									defaultContent : ""
								}, {
									data : "status_name",
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
														"name" : "删除",
														"fn" : "toDelete(\'"
																+ row.id
																+ "\')",
														"type" : "danger-outline size-MINI radius",
														"display" : true
													},{
														"name" : "查看",
														"fn" : "toDetail(\'"
																+ row.id
																+ "\')",
														"type" : "primary-outline size-MINI radius",
														"display" : true
													},{
														"name" : "回复",
														"fn" : "toReply(\'"
																+ row.id
																+ "\')",
														"type" : "primary-outline size-MINI radius",
														"display" : row.status == '1' ? true:false
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
				//分类
				var user_type = $("#user_type").val().trim();
				//查询条件
				var param = {
					user_type : user_type
				};
				
				return param;
			}
			
			//重置
			$('#reset_but').on('click', function() {
				//分类
				$("#user_type").val('');
				$('#search_but').trigger('click');
			});
			
			//导出
			$('#export_but').on('click', function() {
				//分类
				var user_type = $("#user_type").val().trim();
				window.open('${pageContext.request.contextPath}/apply/controller/applyController/exportExcel?user_type=' + user_type,'查看原图',"fullscreen=1")
			});
			
		});

		//重新加载页面：子页面调用
		function reloadPage(){
			window.location.reload();//刷新当前页面.
		}
		
		
		//批量删除
		$('#delete_but').on('click', function() {
			//要删除的数据
			var ids = '';
			$("input[name='check_apply']:checkbox:checked").each(function(){ 
				ids += $(this).val() + ',';
			}) 
			if('' == ids){
				layer.open({
		    		  content: '请勾选要删除的数据！',
		    		  yes: function(index, layero){
		    		    layer.close(index); //如果设定了yes回调，需进行手工关闭
		    		  }
		    		});
				return;
			}
			layer.confirm("确认要删除吗？", {
				  btn: ['确认','返回'] //按钮
					}, function(index){
						$.ajax({
						    url: "${pageContext.request.contextPath}/apply/controller/applyController/deleteApplyByIds" ,
						    type: "POST",
						    dataType: "JSON",
						    data: {id:ids},
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
			
		});
		
		//查看
		function toDetail(id){
			layer.open({
			    type: 2,
			    maxmin:true,
			    title:["查看"],
			    area: ['100%', '100%'],
			    shadeClose: false, //点击遮罩关闭
			    content: '${pageContext.request.contextPath}/apply/controller/applyController/toApplyDetail?id='+id
			 });
		}
		
		//查看
		function toReply(id){
			layer.open({
			    type: 2,
			    maxmin:true,
			    title:["查看"],
			    area: ['100%', '100%'],
			    shadeClose: false, //点击遮罩关闭
			    content: '${pageContext.request.contextPath}/apply/controller/applyController/toApplyReply?id='+id
			 });
		}
	</script>
</body>
</html>