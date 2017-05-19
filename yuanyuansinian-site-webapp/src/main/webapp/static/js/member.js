/**
 * 会员中心
 * @author lzh_me@126.com
 */


$(function(){
	/*----------------------修改信息 begin-----------------------*/
	$('#edit_but').on('click',function(){
		window.location.href = contextPath + "/sinian/index/indexController/toMemberEdit";
		/*layer.open({
		    type: 2,
		    maxmin:true,
		    title:["修改"],
		    area: ['100%', '100%'],
		    shadeClose: false, //点击遮罩关闭
		    content: contextPath + '/sinian/index/indexController/toMemberEdit'
		 });*/
	});
	/*----------------------修改信息 end-------------------------*/
	
	/*----------------------结算 begin-----------------------*/
	$('#settlement_but').on('click',function(){
		var product_id = "";
		$("[name ='pay_check']:checkbox").each(function() {
	        if ($(this).is(':checked')) {
	        	product_id += $(this).val() + ',';
	        }
		});
		if(product_id == ""){
			layer.alert("请先选择需要结算的商品！");
			return;
		}else{
			layer.alert("支付宝结算");
			return;
			/*layer.open({
			    type: 2,
			    maxmin:true,
			    title:["结算"],
			    area: ['100%', '100%'],
			    shadeClose: false, //点击遮罩关闭
			    content: contextPath + '/sinian/index/indexController/toSettlement'
			 });*/
		}
		
		
	});
	/*----------------------结算 end-------------------------*/
	
	/*----------------------创建纪念馆 begin-----------------------*/
	$('#create_hall_but').on('click',function(){
		index_confirm = layer.confirm('请选择想要创建的类型', {
			  btn: ['单人馆','双人馆'] //按钮
			}, function(){
				layer.open({
				    type: 2,
				    maxmin:true,
				    title:["创建单人纪念馆"],
				    area: ['100%', '100%'],
				    shadeClose: false, //点击遮罩关闭
				    content: contextPath + '/sinian/hall/hallController/toHallSingleAdd'
				 });
				layer.close(index_confirm);
			}, function(){
				layer.open({
				    type: 2,
				    maxmin:true,
				    title:["创建双人纪念馆"],
				    area: ['100%', '100%'],
				    shadeClose: false, //点击遮罩关闭
				    content: contextPath + '/sinian/hallDouble/hallDoubleController/toHallDoubleAdd'
				 });
				layer.close(index_confirm);
		});
	});
	/*----------------------创建纪念馆 end-------------------------*/
	
	//发布祭文
	$('#issue_but').on('click',function(){
		layer.open({
		    type: 2,
		    maxmin:true,
		    title:["发布文章"],
		    area: ['100%', '100%'],
		    shadeClose: false, //点击遮罩关闭
		    content: contextPath + '/sinian/oration/orationController/toOrationAdd'
		 });
	});
});

