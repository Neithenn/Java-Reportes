<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Reportes Home</title>

    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="bootstrap/css/navvar.css" rel="stylesheet"></link>
	<link rel="stylesheet" type="text/css" href="bootstrap/css/dataTables.bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/dataTables.jqueryui.css">
    <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
    <link href="css/inputscreen.css" rel="stylesheet"></link>

</head>

<body onload="CargaReporte()">

<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/reporting.js"></script>
<script type="text/javascript" src="js/excel.js"></script>


<%@ page import = "BEAN.bean_user"  %>

<%  if (session.getAttribute("obean") == null){
	 
	 response.sendRedirect("home.jsp");	
} %>


<div class="container">

<div class="row">
  <div class="col-md-8"></div>
  <div class="col-md-4">
  	<img src="logo_home.jpg" class="img-rounded"></img>
  </div>
</div>

 <!-- Static navbar -->
      <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">

          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="reportes.jsp">Reportes</a></li>
              <li><a href="Perfil.jsp">Perfil</a></li>
              <li><a href="planificar.jsp">Planificar</a></li>
				<li><a  id="altauser" href="Alta_Usuario.jsp">Alta usuario</a></li>
				<li><a id="moduser" href="modificar.jsp">Modificar usuarios</a></li>
            </ul>
            
            <ul class="nav navbar-nav navbar-right">
              
              <li><a href="logout.jsp">Cerrar sesión</a></li>
              
            </ul>
          </div>
<!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>


<div  class="col-md-10 col-md-offset-1">

<div class="panel panel-default">
<div class=" panel-body">
<div class="col-md-6">

	<div class="form-group">
	         <label for="txtserv">Reporte</label>
	         <select class="form-control input" name="txtserv" id="txtserv">
	              <option>Apertura y cierre</option>
	              <option>Eventos gestionables</option>
	              <option>FULL</option>
	        </select>
	 </div>
	
	<label for="div_apertura">Alarmas</label>
	<div class="checkbox" id="div_apertura">
	 <label class="checkbox-inline">
	    <input type="checkbox" value="" id="cb_apertura">
	    Apertura
	  </label>
	  <label class="checkbox-inline" >
	    <input type="checkbox" value="" id="cb_cierre">
	    Cierre
	  </label>
	</div>
	
	
	<div class="checkbox" id="div_evnt">
	 <label class="checkbox-inline">
	  <input type="checkbox" value="" id="cb_robo">
	    Robo
	  </label>
	  <label class="checkbox-inline">
	  <input type="checkbox" value="" id="cb_medico">
	    Pánico Médico
	  </label>
	  <label class="checkbox-inline">
	  <input type="checkbox" value="" id="cb_policia">
	    Pánico Policía
	  </label>
	</div>
	<div class="checkbox" id="div_evnt2">
	  <label class="checkbox-inline">
	  <input type="checkbox" value="" id="cb_fuego">
	    Pánico Fuego
	  </label>
	  <label class="checkbox-inline">
	  <input type="checkbox" value="" id="cb_vlu">
	    VLU Alarma
	  </label>
	  <label class="checkbox-inline">
	  <input type="checkbox" value="" id="cb_corte">
	    VLU corte de línea
	  </label>
	</div>
</div>
	
<div class="col-md-6">
	
	<div class="form-group">
	         <label for="txtserv">Desde</label>
	         <input type="date" class="form-control input" name="desde" id="desde">
	         <label for="txtserv">Hasta</label>
	         <input type="date" class="form-control input" name="hasta" id="hasta">
	 </div>

</div>

	<button class="btn btn-xs btn-danger btn-block button" type="button" id="domicilios" data-toggle="modal" data-target="#Domicilios">Domicilios</button>
	<button class="btn btn-xs btn-danger btn-block button" type="button" id="btnsearch">Buscar</button>

</div>
</div>

<div class="modal fade" id="Domicilios" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Seleccione los domicilios</h4>
      </div>
      <div class="modal-body">
       <br>
       
       <table class="table table-bordered" id="tblCsid">
	                <tr>
	                  <th>CSID</th>
	                  <th>Panel</th>
	                  <th>Dirección</th>
	                  <th>Seleccionar</th>
	                </tr>
	  </table>
    <br>
    <br>
    <br>
      </div>
     
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" id="btn_select">Seleccionar todos</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal" id="btn_modalsave">Guardar</button>
      </div>
    </div>
  </div>
</div>
</div>
</div>
<br>

<div  class="col-md-8 col-md-offset-2 line" id="dvreporte">

<br>
<br>

	<table class="table table-bordered table-striped" id="tbl_eventos">
	  <thead>
	    <tr>
	      <th>Csid</th>
	      <th>Nombre cliente</th>
	      <th>Direccion</th>
	      <th>Fecha del evento</th>
	      <th>Alarma</th>
	      <th>Ciudad</th>
	      <th>Usuario</th>  
	    </tr>
	  </thead>
	</table> 
  <br>
  
	<button class="btn btn-xs btn-danger btn-block button" type="button" id="btnExport">Exportar a Excel</button>
	
	<footer class="footer">
	</footer>
</div>


	
<br>
<br>
<br>


<script>
function CargaReporte(){ 


	<%  if (session.getAttribute("obean") == null){
		 
		 response.sendRedirect("home.jsp");	
	} %>


	$("#dvreporte").hide();
	
	//Servicio del usuario
	var servicio = "<% 
	bean_user obean = (bean_user)session.getAttribute("obean");
	
	out.print(obean.getId_servicio());  %>";
	
	var selectobject = document.getElementById("txtserv");
		
	if (servicio == 1){
		selectobject.remove(1);
		selectobject.remove(1);
		$("#div_evnt").hide();
		$("#div_evnt2").hide();

	}
	else if(servicio == 2){
		
		selectobject.remove(2);
		selectobject.remove(0);
		$("#div_apertura").hide();
		
	}else if(servicio == 3){
		
		$("#div_evnt").hide();
		$("#div_evnt2").hide();
		
	}
	
	//NAVBAR
	var perfil = "<%  out.print(obean.getId_perfil());%>";

	if (perfil!= 1){

		$('#altauser').remove();
		$('#moduser').remove();

		}

	
	var id_user = "<% out.print(obean.getId_user()); %>";
	
	$.get('servlet_paneles', {user : id_user}, function(json){
		
		var html = '';
		$('#tblCsid tr').not(':first').remove();
		for(var i = 0; i < json.Datos.length; i++){
			var j = i + 1;
			html = html + '<tr><td>' + json.Datos[i].csid + '</td><td>' + json.Datos[i].nombre + '</td><td>' + json.Datos[i].direccion + '</td><td> <input type="checkbox" id="checkbox'+j+'" value=""></td></tr>';
		}
		
		$('#tblCsid').append(html);
	});
	
	
	 $('#tbl_eventos').DataTable({
			
	        "language": {
	        	
	        	"emptyTable":"No se han encontrado registros",
	        	"zeroRecords": "Nothing found - sorry",
	        	"info": "Mostrando _END_ de _TOTAL_ registros",
	        	"infoEmpty":      "		",
	        	"lengthMenu": "Mostrar _MENU_ registros",
	        	"search":"Buscar:",
	        	"paginate": {
	        		"first": "<<",
	        		"last": ">>",
	        		"next":"Siguiente",
	        		"previous":"Anterior"
	        	}    	
	        }});
	
	

}
</script>
  </body>
  </html>