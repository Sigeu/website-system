/**
 * 页脚友情链接
 * @author lzh_me@126.com
 */

/*----------------------友情链接 begin-----------------------*/
$(function() {
	$.ajax({
		method : "POST",
		url : contextPath + "/sinian/index/indexController/link",
		data : {
			//id : id
		}
	}).done(function(data) {
		var link_select = $('#link_select');
		link_select.append("<option value=''>友情链接</option>");  
		//先反转数据再遍历结果
		$.each(data.linkList.reverse(), function(index, element){
		    // this === element
			//<option value="${link.web_url }">${link.web_name}</option>
			link_select.append("<option value='" + contextPath + element.web_url +"'>" + element.web_name + "</option>");
		});
	});

});
/*----------------------友情链接  end-------------------------*/

/*----------------------友情链接 begin---------------------*/
$(function() {
	$('#link_select').on('change',function(){
		window.open($(this).val());
	});
});
/*----------------------友情链接 end-----------------------*/