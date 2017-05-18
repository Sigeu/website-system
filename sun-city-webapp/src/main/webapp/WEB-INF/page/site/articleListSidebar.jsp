<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-md-3 sidebarr hidden-xs hidden-sm">
	<div class="sidebarr-pro">
		<div class="sidebar-top">
			<h4>信息公开联系方式</h4>
		</div>
		<div class="sidebar-con">
			<ul>
				<li>部门：${contact.dept_name }</li>
				<li>地址：${contact.address }</li>
				<li>电话：${contact.tel }</li>
				<li>邮编：${contact.addr_zip }</li>
				<li>邮箱：${contact.email }</li>
			</ul>
		</div>
	</div>
	<div class="sidebarr-pro">
		<div class="sidebar-top">
			<h4>年度报告</h4>
		</div>
		<div class="sidebar-con">
			<ul>
				<c:forEach var="contentReport" items="${contentReportList}"> 
					<li><a href="###" onclick="toContentDetail('${content2.id}');">${contentReport.title}</a></li>
                 </c:forEach>
			</ul>
		</div>
	</div>
</div>
