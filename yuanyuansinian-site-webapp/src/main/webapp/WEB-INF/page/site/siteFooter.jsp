<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<footer id="footer">
	<div class="container">
		<div class="row">
			<div class="col-sm-3 footer-logo hidden-xs"><img src="${pageContext.request.contextPath}/static/images/footer.png" class="img-responsive" alt="logo"></div>
			<div class="col-sm-6">
				<ul>
					<li>${config.copyright }</li>
					<li>${config.record_num }</li>
					<li>地址：${contact.address } 电话：${contact.tel } <span class="hidden-xs hidden-sm">邮编：${contact.addr_zip }</span></li>
				</ul>
			</div>
			<div class="col-sm-3">
				<div class="footer-tool pull-right hidden-xs">
					<p>技术支持：lzh_me@126.com</p>
					<select id="link_select" name="link" class="form-control">
						<option value="">友情链接</option>  
	                    <c:forEach var="link" items="${linkList}">  
	                    	<option value="${link.web_url }">${link.web_name}</option> 
	                    </c:forEach>  
                	</select>
				</div>
			</div>
		</div>
	</div>
</footer>

