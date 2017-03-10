/**
 * @author lzh_me@126.com
 */

/*----------------------访问内容 begin-----------------------*/
//纪念馆
function toHallDetail(id) {
	url = contextPath + "/sinian/index/controller/indexController/toHallDetail?id=" + id;
	window.location.href = url;
}

//缘园资讯
function toInformationDetail(id) {
	$.ajax({
		method : "POST",
		url : contextPath + "/sinian/index/controller/indexController/toInformationDetail",
		data : {
			id : id
		}
	}).done(function(data) {
		var open_type = data.open_type;
	});
}

//商城
function toShoppingDetail(id) {
	$.ajax({
		method : "POST",
		url : contextPath + "/sinian/index/controller/indexController/toShoppingDetail",
		data : {
			id : id
		}
	}).done(function(data) {
		var open_type = data.open_type;
	});
}

//公墓陵园
function toCemeteryDetail(id) {
	$.ajax({
		method : "POST",
		url : contextPath + "/sinian/index/controller/indexController/toCemeteryDetail",
		data : {
			id : id
		}
	}).done(function(data) {
		var open_type = data.open_type;
	});
}

//我的思念
function toMemberCenterDetail(id) {
	$.ajax({
		method : "POST",
		url : contextPath + "/sinian/index/controller/indexController/toMemberCenterDetail",
		data : {
			id : id
		}
	}).done(function(data) {
		var open_type = data.open_type;
	});
}
/*----------------------访问内容 end-------------------------*/

