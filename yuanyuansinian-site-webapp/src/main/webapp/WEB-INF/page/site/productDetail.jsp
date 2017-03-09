<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<title>产品查看</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

	<div class="container banner-con product">
	<div class="col-sm-6">
		<img src="images/ex3.jpg" class="img-responsive" alt="product">
	</div>
	<div class="col-sm-6">
		<h3>缘园思念推荐祭奠鲜花缘园思念推荐祭奠鲜花缘园思念推荐祭奠鲜花缘园思念推荐祭奠鲜花缘园思念推荐祭奠鲜花缘园思念推荐祭奠鲜花</h3>
		<div class="product-price"><span class="btn-label pull-left">推荐价格</span><h2 class="pull-left"><small>￥</small>12.00</h2></div>
		<div class="clearfix"></div>
		<div class="product-reason">
			<span class="btn-label">推荐理由</span>
			<ul>
				<li><span class="glyphicon glyphicon-star"></span>地处济南打水井村，远离城嚣，环境清幽平静安详</li>
				<li><span class="glyphicon glyphicon-star"></span>地处济南打水井村，远离城嚣，环境清幽平静安详地处济南打水井村</li>
				<li class="hidden-sm"><span class="glyphicon glyphicon-star"></span>地处济南打水井村，远离</li>
				<li class="hidden-sm"><span class="glyphicon glyphicon-star"></span>地处济南打水井村，远离城嚣，环境清幽平</li>
			</ul>
		</div>
		<div class="product-btn">
			<button class="btn btn-warning btn-lg">加入购物车</button>
			<button class="btn btn-danger btn-lg">立即购买</button>
		</div>
	</div>
</div>

<div class="container all-bg">
	<div class="row" style="padding-top:15px">
		<div class="col-sm-8">
			<div class="article-body">
				<p>清明节又叫踏青节，在仲春与暮春之交，也就是冬至后的第108天。是中国传统节日，也是最重要的祭祀节日之一，是祭祖和扫墓的日子。中华民族传统的清明节大约始于周代，距今已有二千五百多年的历史。</p>
				<p>清明最早只是一种节气的名称， 其变成纪念祖先的节日与寒食节有关。 晋文公把寒食节的后一天定为清明节。 在山西大部分地区是在清明节前一天过寒食节；榆社县等地是在清明节前两天过寒食节；垣曲县还讲究清明节前一天为寒食节，前二天为小寒食。</p>
				<p>相传春秋时期，晋公子重耳为逃避迫害而流亡国外，流亡途中，在一处渺无人烟的地方，又累又饿，再也无力站起来。随臣找了半天也找不到一点吃的，正在大家万分焦急的时候，随臣介子推走到僻静处，从自己的大腿上割下了一块肉，煮了一碗肉汤让公子喝了，重耳渐渐恢复了精神，当重耳发现肉是介子推自己腿割下的时候，流下了眼泪。</p>
				<p><img src="images/ex3.jpg" class="img-responsive" alt="img"></p>
				<p>清明节又叫踏青节，在仲春与暮春之交，也就是冬至后的第108天。是中国传统节日，也是最重要的祭祀节日之一，是祭祖和扫墓的日子。中华民族传统的清明节大约始于周代，距今已有二千五百多年的历史。</p>
			</div>
			<div class="article-near">
				<ul class="pager">
					<li class="previous disabled"><a href="#">上一篇：没有了</a></li>
					<li class="next"><a href="#">下一篇：记忆中的棉麻服饰搭配，你还记得吗？</a></li>
				</ul>
			</div>
		</div>
		
		<div class="col-sm-4 sidebar">
			<!-- <div class="login hidden-xs">
				<div class="pro-header">
					<h4 class="pro-title pull-left">用户登录</h4>
				</div>
				<div class="clearfix"></div>
				<div class="login-body">
					<form action="" method="">
						<div class="input-group">
							<div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
							<input type="text" class="form-control" id="" placeholder="请输入用户名">
						</div>
						<div class="input-group">
							<div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
							<input type="text" class="form-control" id="" placeholder="请输入密码">
						</div>
						<div class="checkbox">
							<label class="pull-left"><input type="checkbox"> 记住密码</label>
							<a href="###" class="pull-right">忘记密码</a>
						</div>
						<button class="btn btn-success btn-login">点击登录</button>
						<button class="btn btn-warning btn-register">点击注册</button>
					</form>
				</div>
			</div> -->
			<%@ include file="siteLogin.jsp"%>
			
			<div class="recommend">
				<div class="pro-header">
					<h4 class="pro-title pull-left">公墓陵园推荐</h4>
					<a href="###" class="more pull-right">更多&raquo;</a>
				</div>
				<div class="clearfix"></div>
				<div class="recommend-body">
					<div class="thumbnail">
						 <img src="images/ex2.jpg" class="img-responsive" alt="img">
						<div class="caption">
							<a href="###"><h5>缘园思念网网推荐陵园之一缘园思念网网推荐陵园之一缘园思念网网推荐陵园之一缘园思念网网推荐陵园之一</h5></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

	<%@ include file="siteFooter.jsp"%>

	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript">
		
	</script>
</body>
</html>
