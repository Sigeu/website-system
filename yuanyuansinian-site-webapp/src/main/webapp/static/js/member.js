/**
 * 会员中心
 * @author lzh_me@126.com
 */


$(function(){
	/*----------------------修改信息 begin-----------------------*/
	$('#edit_but').on('click',function(){
		layer.open({
		    type: 2,
		    maxmin:true,
		    title:["<strong><div class='Hui-iconfont Hui-iconfont-feedback2' style='color: white'>&nbsp;&nbsp;修改信息</div></strong>","background-color: #5a97df"],
		    area: ['100%', '100%'],
		    shadeClose: false, //点击遮罩关闭
		    content: contextPath + '/sinian/index/indexController/toMemberEdit'
		 });
	});
	/*----------------------修改信息 end-------------------------*/
	
	/*----------------------结算 begin-----------------------*/
	$('#settlement_but').on('click',function(){
		layer.alert("请先选择需要结算的商品！");
		/*layer.open({
		    type: 2,
		    maxmin:true,
		    title:["<strong><div class='Hui-iconfont Hui-iconfont-feedback2' style='color: white'>&nbsp;&nbsp;修改信息</div></strong>","background-color: #5a97df"],
		    area: ['100%', '100%'],
		    shadeClose: false, //点击遮罩关闭
		    content: contextPath + '/sinian/index/indexController/toMemberEdit'
		 });*/
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
				    content: contextPath + '/sinian/hall/hallController/toHallDoubleAdd'
				 });
				layer.close(index_confirm);
		});
	});
	/*----------------------创建纪念馆 end-------------------------*/
});

