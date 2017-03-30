<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<title>缘园思念网-网站后台管理系统</title>
<meta name="keywords" content="缘园思念网">
<meta name="description" content="缘园思念网">
</head>
<body>
<div class="navbar-logo hidden-xs">
		<div class="navbar-header">
			<a href="${pageContext.request.contextPath}/index.jsp" target="_blank" class="navbar-brand logo"><img src="${pageContext.request.contextPath}/static/hui/admin3.0/static/h-ui.admin/images/logo.png" class="img-responsive" alt=""></a>
		</div>
</div>
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="###">源拾科技技术支持</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="##">&nbsp;</a> <span class="logo navbar-slogan f-l mr-10 hidden-xs">&nbsp;</span> <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
			<nav class="nav navbar-nav">
				<ul class="cl">
					<li class="dropDown dropDown_hover"><a href="javascript:;" class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 新增 <i class="Hui-iconfont">&#xe6d5;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a href="javascript:;" onclick="article_add('添加通知公告','article-add.html')"><i class="Hui-iconfont">&#xe616;</i> 通知公告</a></li>
							<li><a href="javascript:;" onclick="picture_add('添加公墓陵园','picture-add.html')"><i class="Hui-iconfont">&#xe613;</i> 公墓陵园</a></li>
							<li><a href="javascript:;" onclick="product_add('添加商城产品','product-add.html')"><i class="Hui-iconfont">&#xe620;</i> 商城产品</a></li>
						</ul>
					</li>
				</ul>
			</nav>
			<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
				<ul class="cl">
					<li>超级管理员</li>
					<li class="dropDown dropDown_hover"> <a href="#" class="dropDown_A">admin <i class="Hui-iconfont">&#xe6d5;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a href="#" id="userMessage">个人信息</a></li>
							<li><a href="${pageContext.request.contextPath}/system/controller/loginController/logout">切换账户</a></li>
							<li><a href="${pageContext.request.contextPath}/system/controller/loginController/logout">退出</a></li>
						</ul>
					</li>
					<!-- <li id="Hui-msg"> <a href="#" title="消息"><span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li>
					<li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
							<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
							<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
							<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
							<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
							<li><a href="javascript:;" data-val="orange" title="绿色">橙色</a></li>
						</ul>
					</li> -->
				</ul>
			</nav>
		</div>
	</div>
</header>
<aside class="Hui-aside">
	<input runat="server" id="divScrollValue" type="hidden" value="" />
	<div class="menu_dropdown bk_2">
		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 网站管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${pageContext.request.contextPath}/sinian/config/configController/toConfig" data-title="系统设置" href="javascript:void(0)">系统设置</a></li>
					<li><a data-href="${pageContext.request.contextPath}/sinian/column/columnController/toColumnList" data-title="栏目管理" href="javascript:void(0)">栏目管理</a></li>
					<li><a data-href="${pageContext.request.contextPath}/sinian/link/linkController/toLinkList" data-title="友情链接管理" href="javascript:void(0)">友情链接管理</a></li>
					<li><a data-href="${pageContext.request.contextPath}/sinian/contact/contactController/toContact" data-title="联系方式设置" href="javascript:void(0)">联系方式设置</a></li>
					<li><a data-href="${pageContext.request.contextPath}/sinian/carousel/carouselController/toCarouselList" data-title="轮播图片管理" href="javascript:void(0)">轮播图片管理</a></li>
				</ul>
			</dd>
		</dl>
		
		<dl id="menu-article">
			<dt><i class="Hui-iconfont">&#xe616;</i> 内容管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${pageContext.request.contextPath}/sinian/content/contentController/toContentList" data-title="通知公告管理" href="javascript:void(0)">通知公告管理</a></li>
					<li><a data-href="${pageContext.request.contextPath}/sinian/content/contentController/toContentRecycleList" data-title="内容回收站" href="javascript:void(0)">内容回收站</a></li>
				</ul>
			</dd>
		</dl>
		<%-- <dl id="menu-picture">
			<dt><i class="Hui-iconfont">&#xe637;</i> 审核管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${pageContext.request.contextPath}/sinian/audit/auditController/toAuditContentList" data-title="审核管理" href="javascript:void(0)">审核管理</a></li>
				</ul>
			</dd>
		</dl> --%>
		<dl id="menu-product">
			<dt><i class="Hui-iconfont">&#xe620;</i> 网站产品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${pageContext.request.contextPath}/sinian/product/productController/toProductList" data-title="商城产品管理" href="javascript:void(0)">商城产品管理</a></li>
					<li><a data-href="${pageContext.request.contextPath}/sinian/order/orderController/toOrderList" data-title="订单管理" href="javascript:void(0)">订单管理</a></li>
					<li><a data-href="${pageContext.request.contextPath}/sinian/product/productController/toProductListForHall" data-title="礼品管理" href="javascript:void(0)">礼品管理</a></li>
					<li><a data-href="${pageContext.request.contextPath}/sinian/cemetery/cemeteryController/toCemeteryList" data-title="墓地陵园管理" href="javascript:void(0)">墓地陵园管理</a></li>
					<li><a data-href="${pageContext.request.contextPath}/sinian/hall/hallController/toHallList" data-title="纪念馆管理" href="javascript:void(0)">纪念馆管理</a></li>
					<li><a data-href="${pageContext.request.contextPath}/sinian/oration/orationController/toOrationList" data-title="用户文章管理" href="javascript:void(0)">用户文章管理</a></li>
				</ul>
			</dd>
		</dl>
		<!-- <dl id="menu-comments">
			<dt><i class="Hui-iconfont">&#xe622;</i> 评论管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="http://h-ui.duoshuo.com/admin/" data-title="评论列表" href="javascript:;">评论列表</a></li>
					<li><a data-href="feedback-list.html" data-title="意见反馈" href="javascript:void(0)">意见反馈</a></li>
				</ul>
			</dd>
		</dl> -->
		<dl id="menu-member">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 会员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${pageContext.request.contextPath}/sinian/member/memberController/toMemberList" data-title="会员列表" href="javascript:;">会员列表</a></li>
					<li><a data-href="member-del.html" data-title="删除的会员" href="javascript:;">停用的会员</a></li>
					<li><a data-href="member-record-browse.html" data-title="浏览记录" href="javascript:void(0)">浏览记录</a></li>
					<li><a data-href="member-record-download.html" data-title="购买记录" href="javascript:void(0)">购买记录</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-tongji">
			<dt><i class="Hui-iconfont">&#xe61a;</i> 统计<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="charts-1.html" data-title="折线图" href="javascript:void(0)">产品销量统计</a></li>
					<li><a data-href="charts-2.html" data-title="时间轴折线图" href="javascript:void(0)">纪念馆统计</a></li>
					<li><a data-href="charts-3.html" data-title="区域图" href="javascript:void(0)">墓地陵园统计</a></li>
				</ul>
			</dd>
		</dl>
		
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62d;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${pageContext.request.contextPath}/system/controller/userController/toUserList" data-title="用户管理" href="javascript:void(0)">用户管理</a></li>
					<li><a data-href="${pageContext.request.contextPath}/system/controller/roleController/toRoleList" data-title="角色管理" href="javascript:void(0)">角色管理</a></li>
					<li><a data-href="${pageContext.request.contextPath}/system/controller/funcrightController/toFuncrightList" data-title="菜单管理" href="javascript:void(0)">菜单管理</a></li>
					<li><a data-href="${pageContext.request.contextPath}/system/controller/departmentController/toDepartmentList" data-title="部门管理" href="javascript:void(0)">部门管理</a></li>
					<li><a data-href="${pageContext.request.contextPath}/system/controller/codeTypeController/toCodeTypeList" data-title="数据字典" href="javascript:void(0)">数据字典管理</a></li>
					<li><a data-href="system-shielding.html" data-title="屏蔽词" href="javascript:void(0)">屏蔽词管理</a></li>
					<li><a data-href="${pageContext.request.contextPath}/system/controller/logController/toLogList" data-title="系统日志" href="javascript:void(0)">系统日志</a></li>
				
				</ul>
			</dd>
		</dl>
	</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active"><span title="我的桌面" data-href="${pageContext.request.contextPath}/sinian/content/contentController/toContentList">我的桌面</span><em></em></li>
			</ul>
		</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
	</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="${pageContext.request.contextPath}/sinian/content/contentController/toContentList"></iframe>
		</div>
	</div>
</section>

<div class="contextMenu" id="Huiadminmenu">
	<ul>
		<li id="closethis">关闭当前 </li>
		<li id="closeall">关闭全部 </li>
	</ul>
</div>
<!--_footer 作为公共模版分离出去-->
<%@ include file="../../../common/footer_list.jsp"%>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
$(function(){
	$('#userMessage').on('click',function(){
		layer.open({
		    type: 2,
		    maxmin:true,
		    title:["<strong><div class='Hui-iconfont Hui-iconfont-feedback2' style='color: white'>&nbsp;&nbsp;用户信息</div></strong>","background-color: #5a97df"],
		    area: ['100%', '100%'],
		    shadeClose: false, //点击遮罩关闭
		    content: '${pageContext.request.contextPath}/system/controller/userController/toUserMessage'
		 });
	});
	/*$("#min_title_list li").contextMenu('Huiadminmenu', {
		bindings: {
			'closethis': function(t) {
				console.log(t);
				if(t.find("i")){
					t.find("i").trigger("click");
				}		
			},
			'closeall': function(t) {
				alert('Trigger was '+t.id+'\nAction was Email');
			},
		}
	});*/
});
/*资讯-添加*/
function article_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*图片-添加*/
function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
</script> 
</body>
</html>