/**
 * @author lzh_me@126.com
 */

/*----------------------导航-----------------------*/
$(function() {
	//二级导航
	$(".navbar-pos").hover(function(event) {
		 
		$(this).children("ul").show();
	}, function(event) {
		var $this=$(this); 
	    setTimeout(function(){
	    	$this.children("ul").hide();
	    },500); 
	});

});

/*----------------------导航-----------------------*/

