/**
 * @author lzh_me@126.com
 */

/*----------------------分页-----------------------*/
var pageNo = getParameter('p'); //这里设置参数名(柯 乐 义 注 释)
if (!pageNo) {
	pageNo = 1;
}
//生成分页控件 根据分页的形式在这里设置
kkpager.init({
	pno : pageNo,
	//总页码
	total : totalPage,
	//总数据条数
	totalRecords : totalRecords,
	//链接前部
	hrefFormer : '',
	//链接尾部
	hrefLatter : '',
	getLink : function(n) {
		return contextPath
				+ "/index/controller/indexController/toContentList?id=" + id
				+ "&p=" + n; //参数名跟上面相同
	}
});
kkpager.generPageHtml();
/*----------------------分页-----------------------*/
