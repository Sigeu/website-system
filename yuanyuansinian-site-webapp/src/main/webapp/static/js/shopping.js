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
			layer.alert(data.result_message);
		}
	});
});
/*----------------------商城  end-------------------------*/

