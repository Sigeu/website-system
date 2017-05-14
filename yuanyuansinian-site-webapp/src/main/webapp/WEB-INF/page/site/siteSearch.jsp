<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form id="search_form" class="navbar-form navbar-right" role="search"
	action="${pageContext.request.contextPath}/sinian/index/indexController/search" method="post">
	<div class="input-group">
		<input type="text" class="form-control" placeholder="站内搜索" name="search_text"  id="search_text"> <span
			class="input-group-btn">
			<button class="btn btn-default" type="button" id="search_but">
				<span class="glyphicon glyphicon-search"
					style="font-size: 15px; color: #aeafb4"></span>
			</button>
		</span>
	</div>
</form>

