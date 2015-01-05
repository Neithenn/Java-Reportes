/**
 * 
 */

$(document).ready(function(){
	
	
	
	$("#panel").hide();
	
	$('#btn_buscar').click(function(e){
		
		var usuario = $('#txtnumdoc').val();
		var perfil = $("#txtperfil");
		if (usuario != ""){
			
		$.post('servlet_modificar', 
				{ numdoc : usuario } , 
				function(responseJson){
			
					
					var id_usuario = responseJson.Id;
					var email = responseJson.Email;
					var perfil = responseJson.Perfil;
					var servicio = responseJson.Servicio;
					
					
					if (email != undefined){
						 
					
					document.getElementById('txtemail').innerHTML = "E-mail: "+email;
					
					
					if (perfil == 1){
						 $("#txtperfil").val("Administrador");	
					} else if (perfil == 2){
						 $("#txtperfil").val("Cliente");
					} else if (perfil == 3){
						 $("#txtperfil").val("Sucursal");
					}
					
			
					if (servicio == 1){
						$("#txtserv").val("Apertura y cierre");
					}else if(servicio == 2){
						$("#txtserv").val("Eventos gestionables");
					}else if (servicio == 3){
						$("#txtserv").val("FULL");
					}
					
					
					$.get('servlet_paneles', {user : id_usuario}, function(json){
						
						var html = '';
						$('#tblCsid tr').not(':first').remove();
						for(var i = 0; i < json.Datos.length; i++){
							var j = i + 1;
							html = html + '<tr><td>' + json.Datos[i].csid + '</td><td>' + json.Datos[i].nombre + '</td><td>' + json.Datos[i].direccion + '</td><td> <input type="checkbox" id="checkbox'+j+'" value=""></td></tr>';
						}
						
						$('#tblCsid').append(html);
					});
					
					
					
					
					
					$("#panel").show("slow");
					
					}
			
		});
		}
		
	});
	
	
	$('#btn_eliminar').click(function(e){
		
		
		var usuario = $("#txtnumdoc").val();
		
		$.get('servlet_modificar', { numdoc : usuario,
			accion : "eliminar"} ,
				function(responseText){
			
			alert(responseText);
			$('#panel').hide();
		});
		
	});
	
	
	$("#btn_guardar").click(function(){
		
		var usuario = $("#txtnumdoc").val();
		var perfil	= $("#txtperfil").val();  
		var servicio = $("#txtserv").val();
		
		$.get('servlet_modificar',
				{numdoc : usuario,
				 perfil : perfil,
				 servicio : servicio,
				 accion : "guardar"},
				 function(responseText){
					 
					 alert(responseText);
						$('#panel').hide("slow");
					 
				 });
		
	});
	
});
