/**
 * 祭奠选择礼品
 * @author lzh_me@126.com
 */
$(function(){
	// 购买提交
	$('#submit_buy').on('click',function(){
		var ids = ""
		var names = "";
		var count = 0;
		$("input[name='product_choose']").each(function(){
			if($(this).is(":checked")){
				var value = $(this).val();
				var array = value.split("-");
				//id
				ids += array[1] + ',';
				//名称
				names += '[' + array[0] + ']' + ',';
				//价格
				count += parseFloat(array[2]) ;
			}
		});
		if(ids == ''){
			layer.alert("请选择要结算的礼品！");
			return;
		}
		index_confirm = layer.confirm('总金额：￥' + count + "</br>礼品：" + names, {
			  btn: ['结算','取消'] //按钮
			}, function(){
				layer.open({
				    type: 2,
				    maxmin:true,
				    title:["结算"],
				    area: ['60%', '60%'],
				    shadeClose: false, //点击遮罩关闭
				    content: contextPath + '/sinian/index/indexController/toPay?ids=' + ids + '&count=' + count
				 });
				layer.close(index_confirm);
			}, function(){
				layer.close(index_confirm);
		});
	});
});

