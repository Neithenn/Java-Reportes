/**
 * 
 */

$(document).ready(function(){
	
	$("#btn_enviar").click(function(e){
		e.preventDefault();
		
		var email = $("#txtemail").val();
		
		if (email != ""){
			
			$.get('servlet_recuperar', { email : email}, function(responseText){
				
				alert(responseText);
				
				
			});
			
		}
		
	});
	
});