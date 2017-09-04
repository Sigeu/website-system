<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<title>内容管理信息表页</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		系统管理 <span class="c-gray en">&gt;</span>内容管理
	</nav>
	<div id="win"></div>
	<div id="win2"></div>
	<div data-options="fit:true" style="height: 100%">
		<div class="page-container">
			<table id="search_table" style="width: 95%;" border="0">
				<tr>
					<td align="right" width="10%" class="mybg" nowrap="nowrap">
						<strong>部门:</strong>&nbsp;&nbsp;
					</td>
					<td width="30%" nowrap="nowrap">
						<select class="select" id="dept_code" name="dept_code">
							<option value="">--请选择--</option>  
		                    <c:forEach items="${departmentList}" var="dept">  
		                    	<option value="${dept.dept_code}">${dept.dept_name}</option>  
		                    </c:forEach>  
						</select>
					</td>
					<td align="right" width="10%" class="mybg" nowrap="nowrap">
						<strong>发布时间开始:</strong>&nbsp;&nbsp;
					</td>
					<td width="10%" nowrap="nowrap">
						<input type="text"
							onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endDate\')||\'%y-%M-%d\'}' })" id="startDate" name="startDate"
							class="input-text Wdate size-M">
					</td>
					<td align="right" width="10%" class="mybg" nowrap="nowrap">
						<strong>发布时间结束:</strong>&nbsp;&nbsp;
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
						<th>栏目</th>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/commons.js"></script>
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
	var contextPath = '${pageContext.request.contextPath}';
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
									url : "${pageContext.request.contextPath}/content/controller/contentController/queryContentStatisticsForDept",
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
									data : "dept_code_name",
									defaultContent : ""
								}, {
									data : "count",
									defaultContent : ""
								}],
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
				var dept_code = $("#dept_code").val();
				var startDate = $("#startDate").val().trim();
				var endDate = $("#endDate").val().trim();
				//查询条件
				var param = {
					"dept_code" : dept_code,
					"startDate" : startDate,
					"endDate" : endDate
				};
				
				return param;
			}
			
			//重置
			$('#reset_but').on('click', function() {
				$("#dept_code").val('');
				$("#dept_code_name").val('');
				$("#startDate").val('');
				$("#endDate").val('');
				$('#search_but').trigger('click');
			});
			
			
		});
		
	</script>
</body>
</html>