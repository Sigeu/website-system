<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-md-3 sidebarl">
	<div class="sidebar-top">
		<h4>${column.name}</h4>
	</div>
	<div class="sidebar-nav">
		<ul class="nav nav-stacked">
		<c:forEach var="column" items="${columnListThis3}">
			<li><a href="###"  title="${column.name}" onclick="toContentList('${column.id}','${csrfPreventionSalt}');return false;">${column.name}</a></li>
		</c:forEach>
		</ul>
	</div>
</div>
