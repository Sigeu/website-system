/**
 * @author lzh_me@126.com
 */

/*----------------------访问内容 begin-----------------------*/
//纪念馆
function toHallDetail(id,type) {
	if(type == '1'){
		url = contextPath + "/sinian/index/indexController/toHallSingleDetail?id=" + id;
	}else if(type == '2'){
		url = contextPath + "/sinian/index/indexController/toHallDoubleDetail?id=" + id;
	}
	
	window.location.href = url;
}

//缘园资讯
function toInformationDetail(id) {
	$.ajax({
		method : "POST",
		url : contextPath + "/sinian/index/indexController/toInformationDetail",
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
		url : contextPath + "/sinian/index/indexController/toShoppingDetail",
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
		url : contextPath + "/sinian/index/indexController/toCemeteryDetail",
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
		url : contextPath + "/sinian/index/indexController/toMemberCenterDetail",
		data : {
			id : id
		}
	}).done(function(data) {
		var open_type = data.open_type;
	});
}
/*----------------------访问内容 end-------------------------*/

