/**
 * 
 */

$(document).ready(function(){

	$('#txtserv').change(function(){
		
	var value = $('#txtserv').val();
	
	
	if (value == 'Apertura y cierre'){
		
		$("#div_evnt").hide();
		$("#div_evnt2").hide();
		$("#div_apertura").show();
		$('#cb_robo').attr('checked', false);
		$('#cb_medico').attr('checked', false);
		$('#cb_policia').attr('checked', false);
		$('#cb_fuego').attr('checked', false);
		$('#cb_vlu1').attr('checked', false);
		$('#cb_vlu2').attr('checked', false);
			
	}else if (value == 'Eventos gestionables'){
	
		$("#div_apertura").hide();
		$("#div_evnt").show();
		$("#div_evnt2").show();
		
		$('#cb_apertura').attr('checked', false);
		$('#cb_cierre').attr('checked', false);
	}else if (value == 'FULL'){
		
		$("#div_apertura").show();
		$("#div_evnt").show();
		$("#div_evnt2").show();

	}
	});
	
	
	$('#btnsearch').click(function(e){
		e.preventDefault();
		
		var obj = new Object;
		
		// FECHAS
		obj.fecha_desde = $('#desde').val();
		obj.fecha_hasta = $('#hasta').val();

	if (obj.fecha_desde == "" || obj.fecha_desde < '2014-01-01'){
		
		alert('Fecha desde invalida!');
		
	}else if (obj.fecha_hasta == "" || obj.fecha_hasta < '2014-01-01'){
		
		alert('Fecha hasta invalida!')
		
	}else if (obj.fecha_desde > obj.fecha_hasta) {
		
			alert('La fecha desde no puedo ser mayor a la hasta');
	
	}else{ 
			
		var cont = 0;
		// ALARMAS
		if (document.getElementById("cb_apertura").checked){
			
			obj.al_apertura = 1;
			cont = 1;
			}else{
				
				obj.al_apertura = 0;
			}
		
		
		if (document.getElementById("cb_apertura").checked){
					
					obj.al_apertura = 1;
					cont = 1;}else{
						
						obj.al_apertura = 0;
					}
		
		if (document.getElementById("cb_cierre").checked){
			
			obj.al_cierre = 1;
			cont = 1;}else{
				
				obj.al_cierre = 0;
			}
		
		if (document.getElementById("cb_robo").checked){
			
			obj.al_robo = 1;
			cont = 1;
			}else{
				
				obj.al_robo = 0;
			}
		
		if (document.getElementById("cb_medico").checked){
			
			obj.al_medico = 1;
			cont = 1;
			}else{
				
				obj.al_medico = 0;
			}
		
		if (document.getElementById("cb_fuego").checked){
			
			obj.al_fuego = 1;
			cont = 1;
			}else{
				
				obj.al_fuego = 0;
			}
		
		if (document.getElementById("cb_policia").checked){
			
			obj.al_policia = 1;
			cont = 1;
			}else{
				
				obj.al_policia = 0;
			}
		
		
		if (document.getElementById("cb_vlu").checked){
			
			obj.al_vlu = 1;
			cont = 1;
			}else{
				
				obj.al_vlu= 0;
			}
		
				
		if (document.getElementById("cb_corte").checked){
			
			obj.al_corte = 1;
			cont = 1;
			}else{
				
				obj.al_corte = 0;
			}
		
		
		if (cont == 0){
		
			alert('Marque al menos una alarma.');
		
		}else{
		
		//PANELES
		
		var csid = '';
		var text = '';

		$('#tblCsid tr').each(function(index){
			
	
			$(this).children('td').each(function (index2){
				
				if (index2 == 0){
					
					text =  $(this).text() + "."
					
				}else if(index2 == 3){
					var idname = 'checkbox'+index;
					if (document.getElementById('checkbox'+index).checked){
						csid = csid + text;
					}				
				}
				
			});
		});
		
		if (csid == ''){
			
			alert('Por favor seleccione al menos un domicilio.');
		}else
		{
		obj.csid1 = csid;
		
		// CREAR JSON Y ENVIAR POST
		
		$("#dvreporte").show();
		
		var json = JSON.stringify(obj);

		$.post('servlet_reporte', {datos : json},
				function(json){
			
			$('#tbl_eventos tr').not(':first').remove();
			var t = $('#tbl_eventos').DataTable();
			t.clear().draw();
			
			$('#tbl_eventos tr').not(':first').remove();
			var html = '';
			for(var i = 0; i < json.Datos.length; i++)
				t.row.add( [json.Datos[i].csid, json.Datos[i].nombre, json.Datos[i].direccion, json.Datos[i].Fecha_evento, json.Datos[i].Alarma, json.Datos[i].ciudad, json.Datos[i].Usuario ]).draw();
	
			
			//$('#tbl_eventos').append(html);
			//t.rows.add(html).draw();
			
			
			$('#tbl_eventos').DataTable();
			
		
		});
		
			}
		}
	}
	
		
	});
	
	
	$('#btn_select').click(function(e){

		$('#tblCsid tr').each(function(index){
			 var idname = "checkbox"+index;
		
			$(this).children('td').each(function (index2){
				
				if (index2 == 3){
					 document.getElementById(idname).checked = true;
				}
				
			});
		});
		
	});
	
	
	
});