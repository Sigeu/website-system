<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<title>纪念馆-内容页</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>
	
	<div class="container all-bg museum">
		<div class="row museum-info">
			<div class="col-sm-4 col-md-3 museum-info-left">
				<img src="${pageContext.request.contextPath}/static/images/ex3.jpg" class="img-responsive" alt="museum" />
				<button class="btn btn-success">
					<span class="hidden-sm hidden-md">缘园</span>祭奠
				</button>
				<button class="btn btn-info">
					纪念<span class="hidden-sm hidden-md">相</span>册
				</button>
				<button class="btn btn-warning">关注</button>
			</div>
			<div class="col-sm-8 col-md-9">
				<div class="pro-header">
					<h4 class="pro-title pull-left">基本信息</h4>
					<p class="pull-right museum-des hidden-xs">
						天束幽花已经离开我们
						<mark>120</mark>
						天
					</p>
				</div>
				<div class="clearfix"></div>
				<div class="row museum-info-right">
					<div class="col-sm-6">
						<ul>
							<li><span class="pull-left">中文名：</span>天束幽花</li>
							<li><span class="pull-left">生日：</span>2016-09-30</li>
							<li><span class="pull-left">国籍：</span>中国</li>
							<li><span class="pull-left">出生地：</span>北京</li>
							<li><span class="pull-left">墓地地址：</span>打水井村缘园思念</li>
							<li><span class="pull-left">主要成就：</span>西之亚斯蓝帝国的【六度使徒】西之亚斯蓝帝国的【六度使徒】西之亚斯蓝帝国的【六度使徒】西之亚斯蓝帝国的【六度使徒】</li>
						</ul>
					</div>
					<div class="col-sm-6">
						<ul>
							<li><span class="pull-left">别名：</span>天束幽花</li>
							<li><span class="pull-left">生肖：</span>猴</li>
							<li><span class="pull-left">民族：</span>蒙古族</li>
							<li><span class="pull-left">籍贯：</span>北京</li>
							<li><span class="pull-left">信仰：</span>无</li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="museum-body">
			<div class="nav-title">
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#deeds"
						aria-controls="home" role="tab" data-toggle="tab">生平事迹</a></li>
					<li role="presentation"><a href="#anthology"
						aria-controls="profile" role="tab" data-toggle="tab">追忆文选</a></li>
					<li role="presentation"><a href="#message"
						aria-controls="profile" role="tab" data-toggle="tab">追思留言</a></li>
					<li role="presentation"><a href="#album"
						aria-controls="profile" role="tab" data-toggle="tab">纪念册</a></li>
				</ul>
				<div class="btn-tools pull-right hidden-xs">
					<button class="btn btn-danger" id="incense_but">上香</button>
					</li>
					<button class="btn btn-danger" id="tribute_but">贡品</button>
					</li>
					<button class="btn btn-danger" id="flowers_but">献花</button>
					</li>
					<button class="btn btn-danger" id="song_but">点歌</button>
					</li>
				</div>
			</div>
			<div class="tab-content">
				<div class="tab-pane active" id="deeds">
					<!-- 生平事迹，也就是文章内容模板start -->
					<div class="article-body">
						<p>由郭敬明创作的奇幻长篇小说《幻城》红透大江南北，郭敬明也因此一举成名。8年后，在创作自己准备历时五年的“划时代作品”《
							小时代 》 的同时，
							开始撰写奇幻类故事爵迹。郭敬明日前提道：“自从出道的处女作《幻城》之后，就一直没碰过奇幻的题材，是因为觉得特别难写。此次《最小说》全面改版，想到在原创作计划之外，再写一部不同于小时代的新书作为贺礼，第一个跳出来的就是《爵迹》。8年过去了，觉得自己无论是在情节还是文笔上，都比以前有了很多进步，所以现在有信心再次挑战这种题材。”</p>
						<p>故事发生在神迹的大陆，按照水、火、风、地四元素，分割成四个国家（水之亚斯兰帝国、火之弗里埃尔帝国、风之因德帝国、地之埃尔斯帝国）。各个国家的人民，在强烈的元素力量下，成为了具有各种魂力的人。灵魂是这个大路上统治一切的力量，而统御着魂兽的王爵，是人们力量的终极蜃楼。</p>
						<p>
							<img src="images/ex3.jpg" class="img-responsive" alt="img">
						</p>
						<p>出身高贵的郡主，任性、娇蛮、自私、自傲，也有些小女儿家的脾气，对麒零有些好感，但因为性格原因大部分时候口不对心。父亲是六度王爵西流尔,西流尔至死也没见过她，甚至不知她的存在。她的灵魂回路是由上代永生使徒给予。因为如此,她继承的灵魂回路是不完整的，在一些情况下恢复速度与一般魂术师无异。</p>
					</div>
					<!-- end -->
				</div>

				<div class="row tab-pane" id="anthology">
					<!-- 追忆文选和追思留言的列表都使用这个模板start -->
					<div class="article-body anthology-body">
						<div class="anthology-pro">
							<a href="###"><h5>追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板</h5></a>
							<span class="anthology-date">2016-12-20</span>
							<div class="anthology-des text-justify">追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板</div>
						</div>
						<div class="anthology-pro">
							<a href="###"><h5>追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板</h5></a>
							<span class="anthology-date">2016-12-20</span>
							<div class="anthology-des text-justify">追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板</div>
						</div>
						<div class="anthology-pro">
							<a href="###"><h5>追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板</h5></a>
							<span class="anthology-date">2016-12-20</span>
							<div class="anthology-des text-justify">追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板</div>
						</div>
						<div class="anthology-pro">
							<a href="###"><h5>追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板</h5></a>
							<span class="anthology-date">2016-12-20</span>
							<div class="anthology-des text-justify">追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板</div>
						</div>
						<div class="anthology-pro">
							<a href="###"><h5>追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板</h5></a>
							<span class="anthology-date">2016-12-20</span>
							<div class="anthology-des text-justify">追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板</div>
						</div>
					</div>
					<div class="page">
						<ul class="pagination">
							<li><a href="#" aria-label="Previous"><span
									aria-hidden="true">&laquo;</span></a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#" aria-label="Next"><span
									aria-hidden="true">&raquo;</span></a></li>
						</ul>
					</div>
					<!-- end -->
				</div>

				<div class="row tab-pane" id="message">
					<!-- 追忆文选和追思留言的列表都使用这个模板start -->
					<div class="article-body anthology-body">
						<div class="anthology-pro">
							<a href="###"><h5>追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板</h5></a>
							<span class="anthology-date">2016-12-20</span>
							<div class="anthology-des text-justify">追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板</div>
						</div>
						<div class="anthology-pro">
							<a href="###"><h5>追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板</h5></a>
							<span class="anthology-date">2016-12-20</span>
							<div class="anthology-des text-justify">追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板</div>
						</div>
						<div class="anthology-pro">
							<a href="###"><h5>追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板</h5></a>
							<span class="anthology-date">2016-12-20</span>
							<div class="anthology-des text-justify">追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板追忆文选和追思留言的列表都使用这个模板，打开的具体文章内容使用生平事迹的模板</div>
						</div>
					</div>
					<div class="page">
						<ul class="pagination">
							<li><a href="#" aria-label="Previous"><span
									aria-hidden="true">&laquo;</span></a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#" aria-label="Next"><span
									aria-hidden="true">&raquo;</span></a></li>
						</ul>
					</div>
					<!-- end -->
				</div>

				<div class="row tab-pane" id="album">
					<!-- 纪念册列表页start -->
					<div class="col-sm-4 col-md-3">
						<div class="thumbnail">
							<img src="${pageContext.request.contextPath}/static/images/slide3.png" class="img-responsive" alt="album" />
							<div class="caption">
								<a href="###">天束幽花单独半身照天束幽花单独半身照天束幽花单独半身照天束幽花单独半身照</a>
							</div>
						</div>
					</div>
					<div class="col-sm-4 col-md-3">
						<div class="thumbnail">
							<img src="${pageContext.request.contextPath}/static/images/slide1.png" class="img-responsive" alt="album" />
							<div class="caption">
								<a href="###">天束幽花单独半身照</a>
							</div>
						</div>
					</div>
					<div class="col-sm-4 col-md-3">
						<div class="thumbnail">
							<img src="${pageContext.request.contextPath}/static/images/ex2.jpg" class="img-responsive" alt="album" />
							<div class="caption">
								<a href="###">天束幽花单独半身照</a>
							</div>
						</div>
					</div>
					<div class="col-sm-4 col-md-3">
						<div class="thumbnail">
							<img src="${pageContext.request.contextPath}/static/images/ex.jpg" class="img-responsive" alt="album" />
							<div class="caption">
								<a href="###">天束幽花单独半身照</a>
							</div>
						</div>
					</div>
					<div class="col-sm-4 col-md-3">
						<div class="thumbnail">
							<img src="${pageContext.request.contextPath}/static/images/slide3.png" class="img-responsive" alt="album" />
							<div class="caption">
								<a href="###">天束幽花单独半身照</a>
							</div>
						</div>
					</div>
					<div class="col-sm-4 col-md-3">
						<div class="thumbnail">
							<img src="${pageContext.request.contextPath}/static/images/slide1.png" class="img-responsive" alt="album" />
							<div class="caption">
								<a href="###">天束幽花单独半身照</a>
							</div>
						</div>
					</div>
					<div class="col-sm-4 col-md-3">
						<div class="thumbnail">
							<img src="${pageContext.request.contextPath}/static/images/ex2.jpg" class="img-responsive" alt="album" />
							<div class="caption">
								<a href="###">天束幽花单独半身照</a>
							</div>
						</div>
					</div>
					<div class="col-sm-4 col-md-3">
						<div class="thumbnail">
							<img src="${pageContext.request.contextPath}/static/images/ex.jpg" class="img-responsive" alt="album" />
							<div class="caption">
								<a href="###">天束幽花单独半身照</a>
							</div>
						</div>
					</div>
					<div class="col-sm-4 col-md-3">
						<div class="thumbnail">
							<img src="${pageContext.request.contextPath}/static/images/slide3.png" class="img-responsive" alt="album" />
							<div class="caption">
								<a href="###">天束幽花单独半身照</a>
							</div>
						</div>
					</div>
					<div class="col-sm-4 col-md-3">
						<div class="thumbnail">
							<img src="${pageContext.request.contextPath}/static/images/slide1.png" class="img-responsive" alt="album" />
							<div class="caption">
								<a href="###">天束幽花单独半身照</a>
							</div>
						</div>
					</div>
					<div class="col-sm-4 col-md-3">
						<div class="thumbnail">
							<img src="${pageContext.request.contextPath}/static/images/ex2.jpg" class="img-responsive" alt="album" />
							<div class="caption">
								<a href="###">天束幽花单独半身照</a>
							</div>
						</div>
					</div>
					<div class="col-sm-4 col-md-3">
						<div class="thumbnail">
							<img src="${pageContext.request.contextPath}/static/images/ex.jpg" class="img-responsive" alt="album" />
							<div class="caption">
								<a href="###">天束幽花单独半身照</a>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
					<div class="page">
						<ul class="pagination">
							<li><a href="#" aria-label="Previous"><span
									aria-hidden="true">&laquo;</span></a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#" aria-label="Next"><span
									aria-hidden="true">&raquo;</span></a></li>
						</ul>
					</div>
					<!-- end -->
				</div>
			</div>
		</div>
	</div>


	<%@ include file="siteFooter.jsp"%>

	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/hallDetail.js"></script>
	<script type="text/javascript">
		var activeFlag = '纪念馆明细';
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
