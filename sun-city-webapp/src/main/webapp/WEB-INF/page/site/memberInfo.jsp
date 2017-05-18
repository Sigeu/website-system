<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="col-sm-3 miss-ico">
			<img src="${memberUser.imgs}" class="img-responsive" />
		</div>
		<div class="col-sm-9">
		
	<div class="web-info">
		<h3>${memberUser.member_name}</h3>
		<p class="hidden-sm">注册时间：${memberUser.create_date}</p>
		<p class="hidden-sm">你已经在缘园思念网注册${memberUser.days }天了，感谢您的支持</p>
	</div>
	<div class="true-info">
		<ul>
			<li class="pull-left"><span>姓名：</span>${memberUser.real_name}</li>
			<li class="pull-left"><span>性别：</span>${memberUser.sex_name}</li>
			<li class="pull-left"><span>联系方式：</span>${memberUser.phone}&nbsp;|&nbsp;${memberUser.email}</li>
			<%-- <li class="pull-left"><span>居住地：</span>${memberUser.addr_old}</li> --%>
			<li class="pull-left"><span>现居住地：</span>${memberUser.addr_now}</li>
		</ul>
	</div>
	<div class="clearfix"></div>
	<div class="count-info">
		<button class="btn btn-danger pull-left" id="edit_but">修改信息</button>
		<button class="btn btn-warning pull-left" id="create_hall_but">创建纪念馆</button>
		<button class="btn btn-warning pull-left" id="issue_but">发布祭文</button>
	</div>
	</div>
	</div>
