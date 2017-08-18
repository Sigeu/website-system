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
					<td align="right" width="10%" class="mybg" nowrap="nowrap">
						<strong>申请时间开始:</strong>&nbsp;&nbsp;
					</td>
					<td width="10%" nowrap="nowrap">
						<input type="text"
							onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endDate\')||\'%y-%M-%d\'}' })" id="startDate" name="startDate"
							class="input-text Wdate size-M">
					</td>
					<td align="right" width="10%" class="mybg" nowrap="nowrap">
						<strong>申请时间结束:</strong>&nbsp;&nbsp;
					</td>
					<td width="10%" nowrap="nowrap">
						<input type="text"
							onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startDate\')}' })" id="endDate" name="endDate" class="input-text Wdate size-M">
					</td>
					
					<td width="20%" align="left" nowrap="nowrap">&nbsp;&nbsp;
						<button class="btn btn-warning radius size-MINI" id="search_but">
							<i class="Hui-iconfont Hui-iconfont-search2">&nbsp;&nbsp;</i>查询
						</button> &nbsp;&nbsp;
						<button class="btn btn-success radius size-MINI" id="reset_but">
							<i class="Hui-iconfont Hui-iconfont-zhongzuo">&nbsp;&nbsp;</i>重置
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
						<th>申请人分类</th>
						<th>数量</th>
					</tr>
				</thead>
				<!-- tbody是必须的 -->
				<tbody></tbody>
			</table>
		</div>
	</div>
	<%@ include file="../../../common/footer_list.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/My97DatePicker/4.8/WdatePicker.js"></script>
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
									url : "${pageContext.request.contextPath}/apply/controller/applyController/queryApplyStatistics",
									type:"POST",
									data : {
										//args1: "固定传参"
									}
								}, 
								serverSide : true,//开启服务器模式:启用服务器分页
								lengthChange : false,//是否允许用户改变表格每页显示的记录数
								ordering : false,//是否允许用户排序
								paging : false,//是否分页
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
									data : "user_type_name",
									defaultContent : ""
								}, {
									data : "count",
									defaultContent : ""
								} ],
								columnDefs : [ {
									
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
				var startDate = $("#startDate").val().trim();
				var endDate = $("#endDate").val().trim();
				//查询条件
				var param = {
					user_type : user_type,
					startDate : startDate,
					endDate : endDate
				};
				
				return param;
			}
			
			//重置
			$('#reset_but').on('click', function() {
				//分类
				$("#user_type").val('');
				$("#startDate").val('');
				$("#endDate").val('');
				$('#search_but').trigger('click');
			});
			
		});
	</script>
</body>
</html>