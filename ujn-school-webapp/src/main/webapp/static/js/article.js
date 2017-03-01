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
						alert(open_type);
						if (open_type == '4') {
							alert("输入密码");
						} else {
							var url = contextPath
									+ "/index/controller/indexController/toContentDetail?id=" + id;
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
	window.location.href = url;
}
/*----------------------访问列表-----------------------*/

