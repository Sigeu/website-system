/**
 * 祭奠选择礼品
 * @author lzh_me@126.com
 */


$(function(){
	//已买礼品 tab
	$('#warehouse_li').on('click',function(){
		$('#submit_buy').hide();
		$('#submit_choose').show();
	});
	
	//购买礼品 tab
	$('#buy_li').on('click',function(){
		$('#submit_buy').show();
		$('#submit_choose').hide();
	});
	
	
	// 使用提交
	$('#submit_choose').on('click',function(){
		//要使用的礼品
		var id = $("input[name='warehouse_choose']:checked").val();
		$.ajax({
			method : "POST",
			url : contextPath + "/sinian/warehouse/warehouseController/updateWarehouseForUse",
			data : {
				id : id
			}
		}).done(function(data) {
			var flag = data.flag;
			if(flag == '1'){
				layer.alert(data.result_message, {
				  closeBtn: 1
				}, function(){
					var url = "";
					if(hallType == '1'){
						url = contextPath + "/sinian/index/indexController/toShowSingleMemorial?id=" + hallId;
					}else{
						url = contextPath + "/sinian/index/indexController/toShowDoubleMemorial?id=" + hallId;
					}
					window.location.href = url;
				});
				
			}else{
				layer.alert(data.result_message);
			}
		});
	});
	
	// 购买提交
	$('#submit_buy').on('click',function(){
		$('#submit_buy').show();
		$('#submit_choose').hide();
	});
});

