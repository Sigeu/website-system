<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/keleyidivpager.css">
<title>缘园资讯-内容页</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

	<%@ include file="page-pic.jsp"%>

	<div class="container con-tab">
		<%@ include file="recommend.jsp"%>
	</div>
	<div class="container con-tab all-bg">
		<div class="row">
			<div class="col-sm-3">
				<div class="side-nav">
					<div class="side-nav-top">
						<h4>缘园资讯</h4>
					</div>
					<div class="side-nav-body">
						<ul>
							<li><a href="###">缘园动态</a></li>
							<li class="active"><a href="###">宗教文化</a></li>
							<li><a href="###">民间习俗</a></li>
							<li><a href="###">祭祀礼仪</a></li>
							<li><a href="###">孝道文化</a></li>
							<li><a href="###">墓志铭</a></li>
							<li><a href="###">祭文</a></li>
							<li><a href="###">悼文</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-9">
				<div class="here">
					<ol class="breadcrumb">
						<li><a href="#">首页</a></li>
						<li><a href="#">缘园资讯</a></li>
						<li><a href="#">宗教文化</a></li>
						<li class="active">清明节中华民族的传统节日</li>
					</ol>
				</div>
				<div class="article">
					<div class="article-top">
						<h1>清明节 （中华民族的传统节日）</h1>
						<div class="article-info">
							<span>2016年12月30日</span><span>作者：Admin </span><span
								class="hidden-xs">浏览次数：121018</span>
						</div>
					</div>
					<div class="article-body">
						<p>清明节又叫踏青节，在仲春与暮春之交，也就是冬至后的第108天。是中国传统节日，也是最重要的祭祀节日之一，是祭祖和扫墓的日子。中华民族传统的清明节大约始于周代，距今已有二千五百多年的历史。</p>
						<p>清明最早只是一种节气的名称， 其变成纪念祖先的节日与寒食节有关。 晋文公把寒食节的后一天定为清明节。
							在山西大部分地区是在清明节前一天过寒食节；榆社县等地是在清明节前两天过寒食节；垣曲县还讲究清明节前一天为寒食节，前二天为小寒食。</p>
						<p>相传春秋时期，晋公子重耳为逃避迫害而流亡国外，流亡途中，在一处渺无人烟的地方，又累又饿，再也无力站起来。随臣找了半天也找不到一点吃的，正在大家万分焦急的时候，随臣介子推走到僻静处，从自己的大腿上割下了一块肉，煮了一碗肉汤让公子喝了，重耳渐渐恢复了精神，当重耳发现肉是介子推自己腿割下的时候，流下了眼泪。</p>
						<p>
							<img
								src="${pageContext.request.contextPath}/static/images/ex3.jpg"
								class="img-responsive" alt="img">
						</p>
						<p>清明节又叫踏青节，在仲春与暮春之交，也就是冬至后的第108天。是中国传统节日，也是最重要的祭祀节日之一，是祭祖和扫墓的日子。中华民族传统的清明节大约始于周代，距今已有二千五百多年的历史。</p>
					</div>
					<div class="article-near">
						<ul class="pager">
							<li class="previous disabled"><a href="#">上一篇：没有了</a></li>
							<li class="next"><a href="#">下一篇：记忆中的棉麻服饰搭配，你还记得吗？</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="siteFooter.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript">
		//-------分页数据----------
		var id = '${column_id }';
		var totalPage = '${totalPage }';
		var totalRecords = '${totalRecords }';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
		//-------分页数据----------
	</script>
</body>
</html>
