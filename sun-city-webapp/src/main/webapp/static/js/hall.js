/**
 * 纪念馆
 * @author lzh_me@126.com
 */


$(function(){
	/*----------------------单人馆、双人馆切换 begin-----------------------*/
	$('#single_hall').on('click',function(){
		$('#single_div').show();
		$('#double_div').hide();
	});
	
	$('#double_hall').on('click',function(){
		$('#double_div').show();
		$('#single_div').hide();
	});
	/*----------------------单人馆、双人馆切换 end-------------------------*/
	
	/*----------------------创建纪念馆 begin-----------------------*/
	$('#create_hall_but').on('click',function(){
		layer.open({
		    type: 2,
		    maxmin:true,
		    title:["<strong><div class='Hui-iconfont Hui-iconfont-feedback2' style='color: white'>&nbsp;&nbsp;创建纪念馆</div></strong>","background-color: #5a97df"],
		    area: ['100%', '100%'],
		    shadeClose: false, //点击遮罩关闭
		    content: contextPath + '/sinian/hall/hallController/toHallAdd'
		 });
	});
	/*----------------------创建纪念馆 end-------------------------*/
});

/*----------------------搜索 begin---------------------*/
$(function() {
	$('#hall_but').on('click',function(){
		var url = contextPath + "/sinian/index/indexController/searchHall?"+ new Date().getTime();  
		$('#search_hall_form').attr("action", url).submit();;
	});
});
/*----------------------搜索end-----------------------*/

