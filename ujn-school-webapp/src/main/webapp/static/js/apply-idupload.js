
// 轮播图片上传
jQuery(function() {
	var $ = jQuery, $list = $('#fileList'), $btn = $('#ctlBtn'),state = 'pending',
	// 优化retina, 在retina下这个值是2
	ratio = window.devicePixelRatio || 1,

	// 缩略图大小
	thumbnailWidth = 100 * ratio, thumbnailHeight = 100 * ratio,

	// Web Uploader实例
	uploader;

	// 初始化Web Uploader
	uploader = WebUploader.create({

		// 自动上传。
		auto : false,

		// swf文件路径
		swf : contextPath + '/js/Uploader.swf',

		// 文件接收服务端。
		server: contextPath + '/apply/controller/applyController/uploadIdImg',

		// 选择文件的按钮。可选。
		// 内部根据当前运行是创建，可能是input元素，也可能是flash.
		pick : {
			id : '#filePicker',
			multiple : false
		},

		// 只允许选择文件，可选。
		accept : {
			title : 'Images',
			extensions : 'gif,jpg,jpeg,bmp,png',
			mimeTypes : 'image/*'
		},
		 duplicate : true,
		 disableGlobalDnd : true,
		 fileVal : 'img_',
		 /*formData : {
			 'model_id' : model_id
		 },*/
         //fileNumLimit: 1,
         //fileSizeLimit: 200 * 1024 * 1024,    // 200 M
         fileSingleSizeLimit: 5 * 1024 * 1024    // 5 M
	});
	
    
	// 当有文件添加进来的时候
	uploader.on('fileQueued', function(file) {
		//先清空(只是清空了缩略图，但是之前的图片还是会上传)
		$list.empty();
		//移除之前所有文件
		//uploader.removeFile(uploader.getFiles());
		var $li = $('<div id="' + file.id + '" class="file-item thumbnail">'
				+ '<img>' + '<div class="info">' + file.name + '</div>'
				+ '</div>'), $img = $li.find('img');
	
		$list.append($li);
		
		// 创建缩略图
		uploader.makeThumb(file, function(error, src) {
			if (error) {
				$img.replaceWith('<span>不能预览</span>');
				return;
			}

			$img.attr('src', src);
		}, thumbnailWidth, thumbnailHeight);
		
	});

	// 文件上传过程中创建进度条实时显示。
	uploader.on('uploadProgress', function(file, percentage) {
		var $li = $('#' + file.id), $percent = $li.find('.progress span');

		// 避免重复创建
		if (!$percent.length) {
			$percent = $('<p class="progress"><span></span></p>').appendTo($li)
					.find('span');
		}

		$percent.css('width', percentage * 100 + '%');
	});

	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on('uploadSuccess', function(file) {
		$('#' + file.id).addClass('upload-state-done');
	});

	// 文件上传失败，现实上传出错。
	uploader.on('uploadError', function(file) {
		var $li = $('#' + file.id), $error = $li.find('div.error');

		// 避免重复创建
		if (!$error.length) {
			$error = $('<div class="error"></div>').appendTo($li);
		}

		$error.text('上传失败');
	});

	// 完成上传完了，成功或者失败，先删除进度条。
	uploader.on('uploadComplete', function(file) {
		$('#' + file.id).find('.progress').remove();
	});
	
	uploader.on('all', function(type) {
		if (type === 'startUpload') {
			state = 'uploading';
		} else if (type === 'stopUpload') {
			state = 'paused';
		} else if (type === 'uploadFinished') {
			state = 'done';
		}

		if (state === 'uploading') {
			$btn.text('暂停上传');
		} else {
			$btn.text('开始上传');
		}
	});
	
	//点击上传
	$btn.on('click', function() {
		if (state === 'uploading') {
			uploader.stop();
		} else {
			uploader.options.formData.model_id = parent.apply_id;
			uploader.upload();
		}
	});
	//提示上传状态
	uploader.on( 'uploadAccept', function( file, response ) {
        if ( response.code==1 ) {
            // 通过return false来告诉组件，此文件上传有错。
        	parent.layer.alert("图片上传失败，请联系管理员！", {
				  closeBtn: 1
				}, function(){
					//父页面刷新
					parent.window.location.reload();
					var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
					parent.layer.close(index); //再执行关闭
				});
            return false;
        }else{
        	parent.layer.alert("请保存好您的确认码，用于查看申请结果：" + parent.check_pwd,
					{
						closeBtn : 1
					},
					function() {
						//父页面刷新
						parent.window.location
								.reload();
						var index = parent.layer
								.getFrameIndex(window.name); //先得到当前iframe层的索引
						parent.layer
								.close(index); //再执行关闭
					});
			/*parent.layer.alert("保存成功！", {
				  closeBtn: 1
				}, function(){
					//父页面刷新
					parent.window.location.reload();
					var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
					parent.layer.close(index); //再执行关闭
				});*/
        }
    });
});
