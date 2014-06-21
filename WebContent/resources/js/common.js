/**
 * Contains common JS functions
 */

	String.prototype.endsWith = function(suffix) {
	    return this.indexOf(suffix, this.length - suffix.length) !== -1;
	};
	
	$(document).ready(function() {
			//var contextPath = "${pageContext.request.contextPath}";	//Doesnt work after moving to js file obviously
			var path = window.location.pathname;
			/*console.log("context path: "+contextPath);
			console.log("current path:"+path);*/
			$("#main-nav-ul li").removeClass("active");
			
			if(path.endsWith("buy")){
				$("#buy-li").addClass("active");
			}else if(path.endsWith("sell")){
				$("#sell-li").addClass("active");
			}else{
				$("#home-li").addClass("active");
			}
	
	});
