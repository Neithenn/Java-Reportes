/**
 * 
 */

$(document).ready(function(){
	
	$('#btn_save').click(function(e){
		e.preventDefault();
		var email = $('#email').val();
		var password = $('#pass').val();
		var repassword = $('#repass').val();
		
		if (password == ""){
			
			alert('Por favor ingrese un nuevo password');
		}else  if (password != repassword){
				
				alert('Las passwords indroducidas no coinciden!');
			} else {
				
				$.post('servlet_password', {pass : password, email : email}, function(responseText){
						
						alert(responseText);
					});

			
			}
		
		
		
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});