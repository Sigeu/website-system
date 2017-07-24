/**
 * 商城
 * @author lzh_me@126.com
 */

/*----------------------商城 begin-----------------------*/
$(function() {
});
//加入购物车:已存在则不操作，不存在则新增
$('#add_cart_but').on('click',function(){
	$.ajax({
		method : "POST",
		url : contextPath + "/sinian/cart/cartController/addCart",
		data : {
			product_id : $('#product_id').val()
		}
	}).done(function(data) {
		var flag = data.flag;
		if(flag == '0'){
			layer.alert(data.result_message, {
			  closeBtn: 1
			}, function(){
				url = contextPath + "/sinian/index/indexController/toMemberLogin";
				window.location.href = url;
			});
			
		}else{
			layer.alert(data.result_message, {
				  closeBtn: 1
			}, function(){
				url = contextPath + "/sinian/index/indexController/toMemberCart";
				window.location.href = url;
			});
		}
	});
});

//立刻购买:
$('#buy_now_but').on('click',function(){
	$.ajax({
		method : "POST",
		url : contextPath + "/sinian/cart/cartController/addCart",
		data : {
			product_id : $('#product_id').val()
		}
	}).done(function(data) {
		var flag = data.flag;
		if(flag == '0'){
			layer.alert(data.result_message, {
			  closeBtn: 1
			}, function(){
				url = contextPath + "/sinian/index/indexController/toMemberLogin";
				window.location.href = url;
			});
			
		}else{
			/*layer.alert(data.result_message, {
				  closeBtn: 1
			}, function(){
				url = contextPath + "/sinian/index/indexController/toMemberCart";
				window.location.href = url;
			});*/
				var ids = $('#product_id').val();
				var names = $('#name_').text();
				var count = $('#price_site').text();
				index_confirm = layer.open({
				    type: 2,
				    maxmin:true,
				    title:["结算"],
				    area: ['100%', '100%'],
				    shadeClose: false, //点击遮罩关闭
				    content: contextPath + '/sinian/index/indexController/choosePay?ids=' + ids + '&names=' + names + '&count=' + count
				 });
		}
	});
});

//预订
$('#buy_later_but').on('click',function(){
	$.ajax({
		method : "POST",
		url : contextPath + "/sinian/cart/cartController/addCart",
		data : {
			product_id : $('#product_id').val()
		}
	}).done(function(data) {
		var flag = data.flag;
		if(flag == '0'){
			layer.alert(data.result_message, {
			  closeBtn: 1
			}, function(){
				url = contextPath + "/sinian/index/indexController/toMemberLogin";
				window.location.href = url;
			});
			
		}else{
			layer.alert(data.result_message, {
				  closeBtn: 1
			}, function(){
				url = contextPath + "/sinian/index/indexController/toMemberCart";
				window.location.href = url;
			});
		}
	});
});