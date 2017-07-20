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
/*	$('#class1').on('change', function(){
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
	});*/
	//二级菜单
/*	$('#class2').on('change', function(){
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
	});*/
	
	
});
/*----------------------标签选择-----------------------*/
