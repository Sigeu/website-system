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
		var ids = ""
		var names = "";
		var count = 0;
		$("input[name='pay_check']").each(function(){
			if($(this).is(":checked")){
				var count_num = $(this).parent().prev('div').find("input[name='count_num']").val();
				var value = $(this).val();
				var array = value.split("-");
				//id
				ids += array[1] + ',';
				//名称
				names += '[' + array[0] + ']' + ',';
				//价格
				count += parseFloat(array[2])*parseFloat(count_num) ;
			}
		});
		if(ids == ''){
			layer.alert("请选择要结算的礼品！");
			return;
		}
		if(count == 0.0){
			layer.alert("请选择要结算的礼品数量！");
			return;
		}
		index_confirm = layer.confirm('总金额：￥' + count + "</br>礼品：" + names, {
			  btn: ['结算','取消'] //按钮
			}, function(){
				layer.open({
				    type: 2,
				    maxmin:true,
				    title:["结算"],
				    area: ['100%', '100%'],
				    shadeClose: false, //点击遮罩关闭
				    content: contextPath + '/sinian/index/indexController/toPay?ids=' + ids + '&count=' + count
				 });
				layer.close(index_confirm);
			}, function(){
				layer.close(index_confirm);
		});
		return;
			/*layer.open({
			    type: 2,
			    maxmin:true,
			    title:["结算"],
			    area: ['100%', '100%'],
			    shadeClose: false, //点击遮罩关闭
			    content: contextPath + '/sinian/index/indexController/toSettlement'
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

