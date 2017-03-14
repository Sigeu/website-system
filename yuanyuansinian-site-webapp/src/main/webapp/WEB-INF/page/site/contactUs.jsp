<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<title>联系我们</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

	<div class="container contact">
	<div class="article-top">
		<h1>缘园思念网简介</h1>
	</div>
	<div class="article-body" style="padding-top:0">
		<p>清明节又叫踏青节，在仲春与暮春之交，也就是冬至后的第108天。是中国传统节日，也是最重要的祭祀节日之一，是祭祖和扫墓的日子。中华民族传统的清明节大约始于周代，距今已有二千五百多年的历史。</p>
		<p>清明最早只是一种节气的名称， 其变成纪念祖先的节日与寒食节有关。 晋文公把寒食节的后一天定为清明节。 在山西大部分地区是在清明节前一天过寒食节；榆社县等地是在清明节前两天过寒食节；垣曲县还讲究清明节前一天为寒食节，前二天为小寒食。</p>
		<p>相传春秋时期，晋公子重耳为逃避迫害而流亡国外，流亡途中，在一处渺无人烟的地方，又累又饿，再也无力站起来。随臣找了半天也找不到一点吃的，正在大家万分焦急的时候，随臣介子推走到僻静处，从自己的大腿上割下了一块肉，煮了一碗肉汤让公子喝了，重耳渐渐恢复了精神，当重耳发现肉是介子推自己腿割下的时候，流下了眼泪。</p>
		<p><img src="images/ex3.jpg" class="img-responsive" alt="img"></p>
		<p>清明节又叫踏青节，在仲春与暮春之交，也就是冬至后的第108天。是中国传统节日，也是最重要的祭祀节日之一，是祭祖和扫墓的日子。中华民族传统的清明节大约始于周代，距今已有二千五百多年的历史。</p>
	</div>
</div>

<div class="container contact contact-add">
	<div class="row">
		<div class="col-sm-6 col-md-5 contact-left">
			<h2>山东缘园思念信息咨询有限公司</h2>
			<p class="hidden-sm"><span class="glyphicon glyphicon-map-marker"></span>山东省济南市历下区历山路76号</p>
			<p class="contact-tel"><span class="glyphicon glyphicon-phone-alt"></span>0531 - 12345678</p>
			<p class="contact-zip hidden-sm">邮编：250000</p>
		</div>
		<div class="col-sm-6 col-md-7 contact-add-map">
			<img src="${pageContext.request.contextPath}/static/images/contact.jpg" class="img-responsive" alt="地理位置" />
		</div>
	</div>
</div>

	<%@ include file="siteFooter.jsp"%>

	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript">
		var activeFlag = '首页';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
	</script>
</body>
</html>
