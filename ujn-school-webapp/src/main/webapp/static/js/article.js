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
function toContentList(id,csrfPreventionSalt) {
	var url = contextPath
			+ "/index/controller/indexController/toContentList?csrfPreventionSalt=" + csrfPreventionSalt + "&id=" + id;
	//信息公开申请:add 2017-11-25,暂时屏蔽信息申请
	/*if(id == '112'){
		url = contextPath + "/index/controller/indexController/toContentList112?id=" + id;
	}*/
	//信息公开目录、校务、党务：显示公开目录的菜单,
	if(id == '111' || id == '102'|| id == '107'){
		url = contextPath + "/index/controller/indexController/toContentList111?id=" + id;
	}
	//年度报告
	if(id == '113'){
		url = contextPath + "/index/controller/indexController/toContentList113?id=" + id;
	}
	window.location.href = url;
}

//3级栏目内容列表
function toContentListForLevel3(id) {
	var url = contextPath
			+ "/index/controller/indexController/toContentListForLevel3?id=" + id;
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
//最新公开列表
function toContentListForNew() {
	var url = contextPath
			+ "/index/controller/indexController/queryContentListForNew";
	window.location.href = url;
}
/*----------------------最新信息列表-----------------------*/

/*----------------------分页列表-----------------------*/
//栏目内容列表--更多--分页列表
function toContentListForPage(id) {
	//信息公开制度
	if(id == '109'){
		url = contextPath + "/index/controller/indexController/queryContentListForPage109?id=" + id;
	}
	//信息公开指南
	if(id == '110'){
		url = contextPath + "/index/controller/indexController/queryContentListForPage110?id=" + id;
	}
	//年度报告
	if(id == '113'){
		url = contextPath + "/index/controller/indexController/queryContentListForPage113?id=" + id;
	}
	
	//信息公开申请 add 2017-11-25
	if(id == '112'){
		url = contextPath + "/index/controller/indexController/queryContentListForPage112?id=" + id;
	}
	window.location.href = url;
}
/*----------------------分页列表-----------------------*/


//处理null和undefined
function toString(content){
	var str = content;
	if (typeof(content) == "undefined"){ 
		str = '';
	}
	if (!content && typeof(content)!="undefined" && content!=0){ 
		str = ''; 
	}
	if(isNaN(content)){ 
		str = '';  
	}
	return str;
}