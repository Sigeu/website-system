/**
 * @author lzh_me@126.com
 */

/*----------------------登录 begin---------------------*/
$(function() {
	//登录
	var options = {
			success : function(data) {
				var flag = data.status_flag;
				if(flag == '1'){
					//layer.alert("登录成功！");
					window.location.href = contextPath + '/sinian/index/indexController/toMemberCenter';
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
	$('#register_but1,#register_but2').on('click',function(){
		layer.open({
		    type: 2,
		    maxmin:true,
		    title:["<strong><div class='Hui-iconfont Hui-iconfont-feedback2' style='color: white'>&nbsp;&nbsp;用户注册</div></strong>","background-color: #5a97df"],
		    area: ['60%', '90%'],
		    shadeClose: false, //点击遮罩关闭
		    content: contextPath + '/sinian/index/indexController/toRegister'
		 });
	});
	/*----------------------用户注册 end-----------------------*/
	
	/*----------------------会员登录返回首页 begin-----------------------*/
	$('#return_but').on('click',function(){
		window.location.href = contextPath + '/index.jsp';
	});
	/*----------------------会员登录返回首页 end-------------------------*/
});


