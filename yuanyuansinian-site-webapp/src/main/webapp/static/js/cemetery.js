/**
 * 墓地陵园
 * @author lzh_me@126.com
 */

/*----------------------访问内容 begin-----------------------*/
//墓地
function toCemeteryDetail(id) {
	url = contextPath + "/sinian/index/indexController/toCemeteryDetail?id=" + id;
	window.location.href = url;
}
//更多
function toCemeteryList() {
	url = contextPath + "/sinian/index/indexController/toCemeteryList";
	window.location.href = url;
}
/*----------------------访问内容 end-------------------------*/

