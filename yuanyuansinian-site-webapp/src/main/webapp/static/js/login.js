/**
 * @author lzh_me@126.com
 */

/*----------------------登录 begin---------------------*/
$(function() {
	//登录
	var options = {
			success : function(data) {
				var status_flag = data.status_flag;
				if(status_flag == '1'){
					//区分是否是灵堂购买礼品
					var flag = data.flag;
					//礼品分类
					var type = data.type;
					if(flag == 'buy'){
						window.location.href = contextPath + '/sinian/index/indexController/toChooseProduct?type=' + type;
					}else{
						window.location.href = contextPath + '/sinian/index/indexController/toMemberCenter';
					}
					
				}
			},
			error : function(data) {
				layer.alert("登录失败，请联系管理员！");
			}
		};
		// 准备form表单
		$("#login_form").ajaxForm(options);
		// 表单提交     
		$('#login_but').on('click', function() {
			options.url = contextPath + "/sinian/member/memberController/memberLogin";
			$("#login_form").ajaxSubmit(options);
			
			return false;
		});
			
});

/*----------------------登录 end-----------------------*/


$(function() {
	/*----------------------用户注册 begin---------------------*/
	$('#register_but2').on('click',function(){
		window.location.href = contextPath + '/sinian/index/indexController/toRegister';
	});
	/*----------------------用户注册 end-----------------------*/
	
	/*----------------------会员登录返回首页 begin-----------------------*/
	$('#return_but').on('click',function(){
		window.location.href = contextPath + '/index.jsp';
	});
	/*----------------------会员登录返回首页 end-------------------------*/
});


