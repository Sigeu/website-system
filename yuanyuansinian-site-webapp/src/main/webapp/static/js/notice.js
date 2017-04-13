/**
 * 通知公告
 * @author lzh_me@126.com
 */

/*----------------------通知公告 begin-----------------------*/
$(function() {
	$.ajax({
		method : "POST",
		url : contextPath + "/sinian/index/indexController/notice",
		data : {
			//id : id
		}
	}).done(function(data) {
		var notice_ul = $('#notice_ul');
		//先反转数据再遍历结果
		$.each(data.contentNoticeList.reverse(), function(index, element){
		    // this === element
			notice_ul.after("<li><a href='###' onclick='toShowNoticeDetail(" + element.id +")'>" + element.title + "</a></li>");
			
		});
	});
});

//通知公告详情
function toShowNoticeDetail(id) {
	var url = contextPath + "/sinian/index/indexController/toNoticeDetail?id=" + id;
	window.location.href = url;
}


//通知公告列表
function toShowNoticeList(id) {
	var url = contextPath + "/sinian/index/indexController/toNoticeList?id=" + id;
	window.location.href = url;
}
/*----------------------通知公告  end-------------------------*/

