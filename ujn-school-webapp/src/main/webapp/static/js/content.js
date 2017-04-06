/**
 * 后台内容管理
 * @author lzh_me@126.com
 * 
 */

/*----------------------标签选择-----------------------*/
$(function(){
	//重要标签
	$('#importance_content button').on('click', function(){
		var thisValue = $(this).text();
		var oldValue = $('#importance').val();
		if('' == oldValue){
			$('#importance').val(thisValue);
		}else{
			$('#importance').val(oldValue + "," + thisValue);
		}
		
	});
	//内容标签
	$('#tag_content button').on('click', function(){
		var thisValue = $(this).text();
		var oldValue = $('#tag').val();
		if('' == oldValue){
			$('#tag').val(thisValue);
		}else{
			$('#tag').val(oldValue + "," + thisValue);
		}
		
	});
	
	//一级菜单
	$('#class1').on('change', function(){
		var thisValue = $(this).val();
		//先清空
		$("#class2").empty();
		$("#class2").append("<option value=''>--请选择--</option>");
		$("#class3").empty();
		$("#class3").append("<option value=''>--请选择--</option>");
		$.ajax({
			type:"post",
			url: contextPath + "/column/controller/columnController/queryChildColumnListById?id=" + thisValue,
			datatype:"json",
			success:function(data){
				for(var i = 0;i < data.length;i++){
					$("#class2").append("<option value=" + data[i].id + ">" +  data[i].name + "</option>");
				}
			}
		});
	});
	//二级菜单
	$('#class2').on('change', function(){
		var thisValue = $(this).val();
		//先清空
		$("#class3").empty();
		$("#class3").append("<option value=''>--请选择--</option>");
		$.ajax({
			type:"post",
			url: contextPath + "/column/controller/columnController/queryChildColumnListById?id=" + thisValue,
			datatype:"json",
			success:function(data){
				for(var i = 0;i < data.length;i++){
					$("#class3").append("<option value=" + data[i].id + ">" +  data[i].name + "</option>");
				}
			}
		});
	});
});
/*----------------------标签选择-----------------------*/


$(function(){
	$.ajaxSetup({
		//不设置缓存 不然get方法会报304
		cache: false,
	});
	$.ajax({
		type:"post",
		url:"liandongtry.json",
		datatype:"json",
		//请求成功后 将大范围的节点添加到第一个select中
		success:function(data){
			for(var i = 0;i < data.length;i++){
				$("#large").append("<option id=" + data[i].id + " name=" + data[i].name + ">" +  data[i].name + "</option>");
			}
		}
	});
	$("#large").change(function(){
		//当第一个select发生变化后 获取选中的option的id（-1是为了方面后面数组的操作）
		var lId = $("#large option:selected").attr("id") - 1;
		//清空第二个select的节点 不然会一直累计其中
		$("#medium").empty();
		$("#medium").append("<option>--请选择中范围--</option>");
		$.ajax({
			type:"get",
			url:"liandongtry.json",
			success:function(data){
				for(var i = 0;i < data[lId].sons.length;i++){
					$("#medium").append("<option id=" + data[lId].sons[i].id + " name=" + data[lId].sons[i].name + ">" +  data[lId].sons[i].name + "</option>");
				}
			}
		});
			$("#medium").change(function(){
				var MId = $("#medium option:selected").attr("id").toString().charAt(2);
				MId = parseInt(MId) - 1;
				$("#small").empty();
				$("#small").append("<option>--请选择小范围--</option>");
				$.ajax({
					type:"get",
					url:"liandongtry.json",
					success:function(data){
						for(var i = 0;i < data[lId].sons[MId].ssons.length;i++){
							$("#small").append("<option id=" + data[lId].sons[MId].ssons[i].id + " name=" + data[lId].sons[MId].ssons[i].name + ">" +  data[lId].sons[MId].ssons[i].name + "</option>");
						}
					}
				});
			});
	});
});
