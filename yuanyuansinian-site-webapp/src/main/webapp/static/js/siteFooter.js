/**
 * 页脚友情链接
 * @author lzh_me@126.com
 */

/*----------------------加载友情链接 begin-----------------------*/
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
			//link_select.append("<option value='" + contextPath + element.web_url +"'>" + element.web_name + "</option>");link_select.append("<option value='" + contextPath + element.web_url +"'>" + element.web_name + "</option>");
			link_select.append("<option value='" + element.web_url +"'>" + element.web_name + "</option>");
		});
	});

});
/*----------------------加载友情链接  end-------------------------*/

/*----------------------点击友情链接 begin---------------------*/
$(function() {
	$('#link_select').on('change',function(){
		window.open($(this).val());
	});
});
/*----------------------点击友情链接 end-----------------------*/

/*----------------------页脚联系方式 begin---------------------*/
$(function() {
	$.ajax({
		method : "POST",
		url : contextPath + "/sinian/index/indexController/contact",
		data : {
			//id : id
		}
	}).done(function(data) {
		var contact = data.contact;
		$('#copyright').text(contact.copyright);
		$('#record_num').text(contact.record_num);
		$('#address').text(contact.address);
		$('#tel').text(contact.tel);
		$('#addr_zip').text(contact.addr_zip);
	});
});
/*----------------------页脚联系方式 end-----------------------*/