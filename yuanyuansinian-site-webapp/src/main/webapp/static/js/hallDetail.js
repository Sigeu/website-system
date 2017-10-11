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
	$('#incense_but,#tribute_but,#flowers_but,#song_but').on('click',function(){
		layer.open({
		    type: 2,
		    maxmin:true,
		    title:["购买"],
		    area: ['70%', '60%'],
		    shadeClose: false, //点击遮罩关闭
		    //content: contextPath + "/sinian/index/indexController/toChooseProduct?type=1"
		    content: contextPath + "/sinian/index/indexController/toChooseProductAll?hallId=" +  hallId
		 });
		//window.location.href = contextPath + "/sinian/index/indexController/toChooseProduct?type=1";
	});
	//未登录点击
	$('#incense_but_nouser').on('click',function(){
		layer.alert("尚未登录，请登录后购买！", {
		  closeBtn: 1
		}, function(){
			layer.open({
			    type: 2,
			    maxmin:true,
			    title:["登录"],
			    area: ['70%', '60%'],
			    shadeClose: false, //点击遮罩关闭
			    content: contextPath + "/sinian/index/indexController/toMemberLogin?flag=buy&hallType=" + hallType + "&hallId="  +  hallId
			 });
			//先登录:设置标识buy，表示登陆后跳回购买页面
			//window.location.href = contextPath + "/sinian/index/indexController/toMemberLogin?flag=buy&type=1";
		});
		
	});
	
	
	//贡品
	/*$('#tribute_but').on('click',function(){
		window.location.href = contextPath + "/sinian/index/indexController/toChooseMyProduct?type=2";
	});*/
	
	//未登录点击
	$('#tribute_but_nouser').on('click',function(){
		layer.alert("尚未登录，请登录后购买！", {
		  closeBtn: 1
		}, function(){
			layer.open({
			    type: 2,
			    maxmin:true,
			    title:["登录"],
			    area: ['100%', '100%'],
			    shadeClose: false, //点击遮罩关闭
			    content: contextPath + "/sinian/index/indexController/toMemberLogin?flag=buy&hallType=" + hallType + "&hallId="  +  hallId
			 });
			//先登录:设置标识buy，表示登陆后跳回购买页面
			//window.location.href = contextPath + "/sinian/index/indexController/toMemberLogin?flag=buy&type=2";
		});
		
	});
	
	//献花
	/*$('#flowers_but').on('click',function(){
		window.location.href = contextPath + "/sinian/index/indexController/toChooseMyProduct?type=3";
	});*/
	
	//未登录点击
	$('#flowers_but_nouser').on('click',function(){
		layer.alert("尚未登录，请登录后购买！", {
		  closeBtn: 1
		}, function(){
			layer.open({
			    type: 2,
			    maxmin:true,
			    title:["登录"],
			    area: ['100%', '100%'],
			    shadeClose: false, //点击遮罩关闭
			    content: contextPath + "/sinian/index/indexController/toMemberLogin?flag=buy&hallType=" + hallType + "&hallId="  +  hallId
			 });
			//先登录:设置标识buy，表示登陆后跳回购买页面
			//window.location.href = contextPath + "/sinian/index/indexController/toMemberLogin?flag=buy&type=3";
		});
		
	});
	
	//点歌
	/*$('#song_but').on('click',function(){
		window.location.href = contextPath + "/sinian/index/indexController/toChooseMyProduct?type=4";
	});*/
	
	//未登录点击
	$('#song_but_nouser').on('click',function(){
		layer.alert("尚未登录，请登录后购买！", {
		  closeBtn: 1
		}, function(){
			layer.open({
			    type: 2,
			    maxmin:true,
			    title:["登录"],
			    area: ['100%', '100%'],
			    shadeClose: false, //点击遮罩关闭
			    content: contextPath + "/sinian/index/indexController/toMemberLogin?flag=buy&hallType=" + hallType + "&hallId="  +  hallId
			 });
			//先登录:设置标识buy，表示登陆后跳回购买页面
			//window.location.href = contextPath + "/sinian/index/indexController/toMemberLogin?flag=buy&type=4";
		});
		
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

//跳转到单人馆灵堂
function toShowSingleMemorial(hallId){
	window.location.href = contextPath + "/sinian/index/indexController/toShowSingleMemorial?id=" + hallId;
}

//跳转到双人馆灵堂
function toShowDoubleMemorial(hallId){
	window.location.href = contextPath + "/sinian/index/indexController/toShowDoubleMemorial?id=" + hallId;
}
