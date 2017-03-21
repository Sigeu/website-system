/**
 * 会员中心
 * @author lzh_me@126.com
 */


$(function(){
	/*----------------------立刻充值 begin-----------------------*/
	$('#recharge_but').on('click',function(){
		layer.alert('充值接口正在进行测试，敬请期待！');
		/*layer.open({
		    type: 2,
		    maxmin:true,
		    title:["<strong><div class='Hui-iconfont Hui-iconfont-feedback2' style='color: white'>&nbsp;&nbsp;账户充值</div></strong>","background-color: #5a97df"],
		    area: ['100%', '100%'],
		    shadeClose: false, //点击遮罩关闭
		    content: '${pageContext.request.contextPath}/zgzssb/kaoShengXinXiController/toKaoShengXinXiEdit.do?id='+id
		 });*/
	});
	/*----------------------立刻充值 end-------------------------*/
	
	/*----------------------创建纪念馆 begin-----------------------*/
	$('#create_hall_but').on('click',function(){
		layer.confirm('请选择想要创建的类型', {
			  btn: ['单人馆','双人馆'] //按钮
			}, function(){
				layer.open({
				    type: 2,
				    maxmin:true,
				    title:["<strong><div class='Hui-iconfont Hui-iconfont-feedback2' style='color: white'>&nbsp;&nbsp;创建纪念馆</div></strong>","background-color: #5a97df"],
				    area: ['100%', '100%'],
				    shadeClose: false, //点击遮罩关闭
				    content: contextPath + '/sinian/hall/hallController/toHallSingleAdd'
				 });
				layer.close();
			}, function(){
				layer.open({
				    type: 2,
				    maxmin:true,
				    title:["<strong><div class='Hui-iconfont Hui-iconfont-feedback2' style='color: white'>&nbsp;&nbsp;创建纪念馆</div></strong>","background-color: #5a97df"],
				    area: ['100%', '100%'],
				    shadeClose: false, //点击遮罩关闭
				    content: contextPath + '/sinian/hall/hallController/toHallAdd'
				 });
		});
	});
	/*----------------------创建纪念馆 end-------------------------*/
});

