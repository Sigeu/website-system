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
		var importance = '';
		if('' == oldValue){
			importance = thisValue + ",";
		}else{
			importance = oldValue + thisValue + ",";
		}
		var arr = new Array();
		arr = importance.split(",");
		$('#importance').val(unique(arr));
	});
	//内容标签
	$('#tag_content button').on('click', function(){
		var thisValue = $(this).text();
		var oldValue = $('#tag').val();
		var tag = '';
		if('' == oldValue){
			tag = thisValue + ",";
		}else{
			tag =  oldValue + thisValue + ",";
		}
		var arr = new Array();
		tag = tag.replace(/，/ig,','); 
		arr = tag.split(",");
		$('#tag').val(unique(arr));
	});
	
	$('#tag').blur( function(event){
		var tag = $('#tag').val();
		tag = tag.replace(/，/ig,',');
		$('#tag').val(tag);
	});
});
/*----------------------标签选择-----------------------*/

function unique(arr) {
	// 遍历arr，把元素分别放入tmp数组(不存在才放)
	var tmp = new Array();
	for ( var i in arr) {
		// 该元素在tmp内部不存在才允许追加
		if (tmp.indexOf(arr[i]) == -1) {
			tmp.push(arr[i]);
		}
	}
	return tmp;
}