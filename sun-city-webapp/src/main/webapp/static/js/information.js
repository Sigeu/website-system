/**
 * 列表
 * @author lzh_me@126.com
 */


/*----------------------访问列表-----------------------*/
// 列表
function toInformationList(id) {
	var url = contextPath
			+ "/sinian/index/indexController/toInformationList?id=" + id;
	window.location.href = url;
}
/*----------------------访问列表-----------------------*/


/*----------------------访问内容-----------------------*/
function toInformationDetail(id,column_id) {
	var url = contextPath
			+ "/sinian/index/indexController/toInformationDetail?id=" + id + '&column_id=' + column_id;
	window.location.href = url;
}
/*----------------------访问内容-----------------------*/

