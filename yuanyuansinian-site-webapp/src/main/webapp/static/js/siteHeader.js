/**
 * 页头导航、搜索
 * @author lzh_me@126.com
 */

/*----------------------导航 begin-----------------------*/
$(function() {
	$.ajax({
		method : "POST",
		url : contextPath + "/sinian/index/indexController/navigation",
		data : {
			//id : id
		}
	}).done(function(data) {
		var index_li = $('#index_li');
		//先反转数据再遍历结果
		$.each(data.columnList.reverse(), function(index, element){
		    // this === element
			index_li.after("<li><a href='" + contextPath + element.column_url +"'>" + element.name + "</a></li>");
		});
	});

});
/*----------------------导航  end-------------------------*/

/*----------------------搜索 begin---------------------*/
$(function() {
	$('#search_but').on('click',function(){
		var url = contextPath + "/sinian/index/indexController/search?"+ new Date().getTime();  
		$('#search_form').attr("action", url).submit();;
	});
});
/*----------------------搜索end-----------------------*/
