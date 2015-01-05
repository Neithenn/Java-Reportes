 $(document).ready(function() { 
   $('#callserv').click(function(e){
	  e.preventDefault();
	  
	  var tipodoc = $('#txttipodoc').val();
	  var numdoc = $('#txtnumdoc').val();
	  var email = $('#txtemail').val();
	  var maxnum = $('#txtnummax').val();
	  var serv = $('#txtserv').val();
	  var perfil = $('#txtperfil').val(); 
	   
	   
	  
	  $.post('servlet_altauser', {
		  document : tipodoc,
		  numdoc : numdoc,
		  mail : email,
		  maxnum : maxnum,
		  servidor : serv,
		  perfil : perfil
	  }, function(responseText){
		  
		  alert('holaa'+responseText);
		  
	  }); 
	  }); 
   });
  
 