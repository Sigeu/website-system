/**
 * @author lzh_me@126.com
 */

/*----------------------导航-----------------------*/
$(function() {
	//----校务公开----//
	$("#span_first").hover(function(event) {
		$(this).addClass("navbar-dorpdown-one");
		$("#div_first").show();
		$("#div_second").hide();
		$("#span_second").removeClass("navbar-dorpdown-one");
	}, function(event) {
		
	});
	
	$("#div_first").hover(function(event) {
		$("#span_first").addClass("navbar-dorpdown-one");
		$(this).show();
	}, function(event) {
		$("#span_first").removeClass("navbar-dorpdown-one");
		$(this).hide(); 
	});
	//----校务公开----//
	
	//----党务公开----//
	$("#span_second").hover(function(event) {
		$(this).addClass("navbar-dorpdown-one");
		$("#div_second").show();
		$("#div_first").hide();
		$("#span_first").removeClass("navbar-dorpdown-one");
	}, function(event) {
		
	});
	
	$("#div_second").hover(function(event) {
		$("#span_second").addClass("navbar-dorpdown-one");
		$(this).show();
		$("#div_first").hide();
	}, function(event) {
		$("#span_second").removeClass("navbar-dorpdown-one");
		$(this).hide(); 
	});
	//----党务公开----//
	
	$("#logo_nav").hover(function(event) {
		$("#div_first").hide();
		$("#div_second").hide();
	});
	
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


$(function() {
	$('#search_but').on('click',function(){
		var url = contextPath + "/index/controller/indexController/search?"+ new Date().getTime();  
		$('#search_form').attr("action", url).submit();;
	});
});
