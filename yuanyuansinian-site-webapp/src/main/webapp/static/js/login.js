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
						//父页面刷新
						parent.window.location.reload();
						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						parent.layer.close(index); //再执行关闭
					}else{
						window.location.href = contextPath + '/sinian/index/indexController/toMemberCenter';
					}
					
				}else{
					var index = layer.alert(data.result_message,{closeBtn: 0}, function(){
						//关闭后的操作
						window.location.reload();
					});
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
			var phone = $('#name').val();
			var pwd = $('#pwd').val();
			var vCode = $('#vCode').val();
			if(phone == ''){
				var index = layer.alert('手机号码不能为空！',{closeBtn: 0}, function(){
					//关闭后的操作
					$('#name').focus();
					layer.close(index);
				});
				return;
			}
			if(pwd == ''){
				var index = layer.alert('密码不能为空！',{closeBtn: 0}, function(){
					//关闭后的操作
					$('#pwd').focus();
					layer.close(index);
				});
				return;
			}
			if(vCode == ''){
				var index = layer.alert('验证码不能为空！',{closeBtn: 0}, function(){
					//关闭后的操作
					$('#vCode').focus();
					layer.close(index);
				});
				return;
			}
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


