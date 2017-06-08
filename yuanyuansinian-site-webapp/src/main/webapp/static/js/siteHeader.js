/**
 * 页头导航、搜索
 * @author lzh_me@126.com
 */
/*----------------------导航 begin-----------------------*/
$(function() {
	//alert(activeFlag);
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
			if(element.name == activeFlag){
				index_li.after("<li class='active'><a href='" + contextPath + element.column_url +"'>" + element.name + "</a></li>");
			}else{
				index_li.after("<li><a href='" + contextPath + element.column_url +"'>" + element.name + "</a></li>");
			}
			
		});
	});
});

/*----------------------导航  end-------------------------*/

/*----------------------搜索 begin---------------------*/
$(function() {
	$('#search_but').on('click',function(){
		var url = contextPath + "/sinian/index/indexController/search?"+ new Date().getTime();  
		$('#search_form').attr("action", url).submit();
	});
	
		
		
});
/*----------------------搜索end-----------------------*/

//退出
$('#logout_but').on('click',function(){
	layer.confirm("确认要退出当前登录用户吗？", {
		btn : [ '退出', '取消' ]
	//按钮
	}, function(index) {
		$.ajax({
			method : "POST",
			url : contextPath + "/sinian/member/memberController/memberLogout",
			data : {
				//id : id
			}
		}).done(function(data) {
			layer.alert(data.result_message, {
				 closeBtn: 1
			}, function(){
				window.location.href = contextPath + '/sinian/index/indexController/toMemberLogin';
			});	});
	}, function(index) {
		layer.close(index);
	});
	
});
