 $(document).ready(function() { 

	   $("#addRow").click(function(e){
	       e.preventDefault(); 
	    var Csid=$("#txtCSID").val();
	    var TipoDoc=$("#txtTipoDoc2").val();
	    var NumDoc=$("#txtNumDoc2").val();
	    var tablaDatos= $("#tblDatos"); 
	    
	    
	    $.post ('servlet_verificarCsid', { csid : Csid, tdoc : TipoDoc, ndoc : NumDoc},
	    		
	    		
	    		
	    		function(responseText){
	    
	    if (responseText == 'true'){
	    	if(Csid!="" && TipoDoc!="" && NumDoc!="" ){ 
	    		tablaDatos.append('<tr><td>'+Csid+'</td><td>'+TipoDoc+'</td><td>'+NumDoc+'</td><td><input type="checkbox" id="checkbox1" value=""></td></tr>');

	         $("#txtCSID").val("");
	         $("#txtTipoDoc2").val("DNI");
	         $("#txtNumDoc2").val(""); 
	    	}
	    	}else{
	    		alert('Panel invalido.');
	    	}
	    }
	    
	    
	    );
	    
	   }); 
	   
	   
	   $("#removeRow").click(function(e){ 
		   e.preventDefault(); 
		   var eliminar = false; 
		   
		   $('#tblDatos tr').each(function(index){ 
		   $(this).children('td').each(function (index2){ 
		   
		   if(index2 == 3){ 
			   if ($(this).find('input').is(':checked')){ 
				   	eliminar = true; 
			   } 
		   	} 
		   
		   	}); 
		   
		   if (eliminar == true){ 
			   $(this).remove(); 
			   eliminar = false; 
		   		} 
		   		}); 
		   });
	   
	   

	 $('#callserv').click(function(e){
	  e.preventDefault();
	  
	  var tipodoc = $('#txttipodoc').val();
	  var numdoc = $('#txtnumdoc').val();
	  var email = $('#txtemail').val();
	  var maxnum = $('#txtnummax').val();
	  var serv = $('#txtserv').val();
	  var perfil = $('#txtperfil').val(); 
	  
	  
	  if (tipodoc == "" || numdoc == "" || email == "" || serv == "" || perfil == ""){
		  
		alert('Por favor complete todos los campos en pantalla');
		
	  }else{


			 var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			  if (regex.test(email) == false){
				  
				  alert('Email invalido.');
				  
			  }else{
				  
				  alert('Email valido');
			  }
		  
		  
	  var tbl = $('#tblDatos tr:has(td)').map(function(i, v) {
		    var $td =  $('td', this);
		        return {
		                 id: ++i,
		                 csid: $td.eq(0).text(),
		                 tdoc: $td.eq(1).text(),
		                 ndoc: $td.eq(2).text()               
		               }
		}).get();
	  
	  var jsoncsid = JSON.stringify(tbl);
	  
	  if (tbl == null){
		  
		  alert('Por favor agregue al menos un panel');
	  }else{
	  
	  $.post('servlet_altauser', {
		  document : tipodoc,
		  numdoc : numdoc,
		  email : email,
		  nummax : maxnum,
		  serv : serv,
		  perfil : perfil,
		  json : jsoncsid
	  }, function(responseText){	
  
		  alert(responseText);

	         $("#txtnumdoc").val("");
	         $("#txttipodoc").val("DNI");
	         $("#txtemail").val("");
	         $("#txtserv").val("Apertura y cierre");
	         $("#txtnummax").val(3);
	         $("#txtperfil").val("Cliente");
	        
		  
	  }); 
	  }
	  }
	 }); 
	 
	 
	 
   });
  