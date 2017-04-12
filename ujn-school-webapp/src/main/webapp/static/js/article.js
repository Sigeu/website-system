/**
 * @author lzh_me@126.com
 */

/*----------------------访问内容-----------------------*/
// 内容：先验证访问方式
function toContentDetail(id) {
	$
			.ajax(
					{
						method : "POST",
						url : contextPath
								+ "/index/controller/indexController/toContentCheck",
						data : {
							id : id
						}
					})
			.done(
					function(data) {
						var open_type = data.open_type;
						if (open_type == '2') {
							layer
									.prompt(
											{
												title : '输入访问密码，并确认',
												formType : 1
											},
											function(pass, index) {
												layer.close(index);
												$
														.ajax(
																{
																	method : "POST",
																	url : contextPath
																			+ "/index/controller/indexController/toContentCheckPwd",
																	data : {
																		id : id
																	}
																})
														.done(
																function(data) {
																	if (data.open_tupe == '5') {
																		var url = contextPath
																				+ "/index/controller/indexController/toContentDetail?id="
																				+ id;
																		window.location.href = url;
																	} else {
																		layer
																				.alert('密码错误，请联系管理员索取密码！')
																	}
																});
											});
						} else {
							var url = contextPath
									+ "/index/controller/indexController/toContentDetail?id="
									+ id;
							window.location.href = url;
						}
					});
}
/*----------------------访问内容-----------------------*/

/*----------------------访问列表-----------------------*/
// 列表
function toContentList(id) {
	var url = contextPath
			+ "/index/controller/indexController/toContentList?id=" + id;
	//信息公开申请
	if(id == '112'){
		url = contextPath + "/index/controller/indexController/toContentList112?id=" + id;
	}
	window.location.href = url;
}
/*----------------------访问列表-----------------------*/


/*----------------------重要信息列表-----------------------*/
//列表
function toContentListForImportance() {
	var url = contextPath
			+ "/index/controller/indexController/queryContentListForImportance";
	window.location.href = url;
}
/*----------------------重要信息列表-----------------------*/

/*----------------------最新信息列表-----------------------*/
//列表
function toContentListForNew() {
	var url = contextPath
			+ "/index/controller/indexController/queryContentListForNew";
	window.location.href = url;
}
/*----------------------最新信息列表-----------------------*/

