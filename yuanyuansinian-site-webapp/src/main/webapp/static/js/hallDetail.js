/**
 * 纪念馆详情
 * @author lzh_me@126.com
 */


$(function(){
	//跳转到灵堂
	//$('#single_memorial_but').on('click',function(){
	//		window.location.href = contextPath + "/sinian/index/indexController/toShowSingleMemorial";
	//});
	//上香
	$('#incense_but').on('click',function(){
		window.location.href = contextPath + "/sinian/index/indexController/toChooseMyProduct?type=1";
	});
	
	//贡品
	$('#tribute_but').on('click',function(){
		window.location.href = contextPath + "/sinian/index/indexController/toChooseMyProduct?type=2";
	});
	
	//献花
	$('#flowers_but').on('click',function(){
		window.location.href = contextPath + "/sinian/index/indexController/toChooseMyProduct?type=3";
	});
	
	//点歌
	$('#song_but').on('click',function(){
		window.location.href = contextPath + "/sinian/index/indexController/toChooseMyProduct?type=4";
	});
	
	/*----------------------选择提交 begin-----------------------*/
	$('#submit_choose').on('click',function(){
		layer.alert("请选择商品！",function(){
			window.location.href = contextPath + "/sinian/index/indexController/toShowHallAndProduct";
		});
	});
	/*----------------------选择提交 end-------------------------*/
});

/*----------------------搜索 begin---------------------*/
$(function() {
	$('#hall_but').on('click',function(){
		var url = contextPath + "/sinian/index/indexController/searchHall?"+ new Date().getTime();  
		$('#search_hall_form').attr("action", url).submit();;
	});
});
/*----------------------搜索end-----------------------*/

//跳转到灵堂
function toShowSingleMemorial(hallId){
	window.location.href = contextPath + "/sinian/index/indexController/toShowSingleMemorial?id=" + hallId;
}

//跳转到灵堂
function toShowDoubleMemorial(hallId){
	window.location.href = contextPath + "/sinian/index/indexController/toShowDoubleMemorial?id=" + hallId;
}
