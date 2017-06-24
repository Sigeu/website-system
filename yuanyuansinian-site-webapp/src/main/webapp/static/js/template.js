/**
 * 模版
 * @author lzh_me@126.com
 */


var index_
var utils = {
	getRootPath: function () {
		var pathName = window.location.pathname.substring(1);
		var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
		return window.location.protocol + '//' + window.location.host + '/' + webName + '/';
	},
	isBlank: function (obj) {
		return (!obj || $.trim(obj) === "");
	},
	isNotBlank: function (obj) {
		return !commons.isBlank(obj);
	},
	//获取文件名后缀
	getExtension: function (file_name) {
		var result = /\.[^\.]+/.exec(file_name);
		return result;
	},
	// 取得父链接参数
	getParameter: function (name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) {
			return unescape(r[2]);
		}
		return null;
	},
	//选择灵堂模版。func回调方法
	treeSelectTemplate: function (func) {
		index_ = top.layer.open({
				type: 2,
				title: '选择模版',
				shadeClose: true,
				shade: false,
				maxmin: true, //开启最大化最小化按钮
				area: ['625px', '745px'],
				//允许出现滚动条
				content: [contextPath + '/sinian/templateImg/templateImgController/toTemplateImgChoose'],
				btn: ["确认", "关闭"],
				yes: function (index, layero) {
					var selectedData = layero.find("iframe")[0].contentWindow.getSelected();
					top.layer.close(index_);
					func(selectedData);
				}
			});
	}
};
