<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reportes Home</title>

 <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
 <link href="bootstrap/css/navvar.css" rel="stylesheet">

</head>
<body>

<%@ page import = "BEAN.bean_user"    %>
<%   
      if (session.getAttribute("obean") != null){
    bean_user obean = (bean_user)session.getAttribute("obean");
	    if (obean.getId_perfil()!= 1){	
	    	response.sendRedirect("home.jsp");
	    }
  	}else{
    	response.sendRedirect("home.jsp");	
    }
    %>


<div class="container">

	<div class="row">
  		<div class="col-md-8">
  		</div>
  		<div class="col-md-4">
  			<img src="logo_home.jpg" class="img-rounded"></img>
  		</div>
	</div>

    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="reportes.jsp">Reportes</a></li>
              <li><a href="Perfil.jsp">Perfil</a></li>
				<li><a href="Alta_Usuario.jsp">Alta usuario</a></li>
				<li class="active"><a href="modificar.jsp">Modificar usuarios</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="logout.jsp">Cerrar sesión</a></li>
            </ul>
          </div>
        </div><!--/.container-fluid -->
	</nav>
  <br>
  <br>
  
  <div class="col-md-6">
  
  <div class="form-group">
	<label for="txtnumdoc">Número de documento</label>
	<input type="text" class="form-control input" name="txtnumdoc" id="txtnumdoc" required autofocus>
	<br>
	<button class="btn btn-danger" type="button" id="btn_buscar">Buscar</button>
  </div>
  	
  <br>
	<div id="panel" class="panel panel-default">
  		<div class=" panel-body">
	  		<p id="txtuser"></p>
  			<p id="txtemail"></p>
			<label>Perfil</label>
			 <select class="form-control input" name="txtperfil" id="txtperfil">
	            <option>Cliente</option>
	            <option>Sucursal</option>
	            <option>Administrador</option>
	          </select>
			
			<label>Servicio</label>
			<select class="form-control input" id="txtserv">
	            <option>Apertura y cierre</option>
	            <option>Eventos gestionables</option>
	            <option>FULL</option>
	          </select>
		<br>	
			<button class="btn btn-danger" type="button" id="paneles" data-toggle="modal" data-target="#Paneles">Paneles</button>
			<button class="btn btn-danger" type="button" id="btn_eliminar">Eliminar</button>  		
  			<button class="btn btn-danger" type="button" id="btn_guardar">Guardar</button>
	
  		</div>
  		
  		
  		<div class="modal fade" id="Paneles" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
			        <h4 class="modal-title" id="myModalLabel">Paneles del usuario</h4>
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
			        <button type="button" class="btn btn-danger" data-dismiss="modal" id="btn_modalsave">Aceptar</button>
			      </div>
			    </div>
			  </div>
</div>
  		
  		
  		
  	</div>
  </div>
</div>

 <script type="text/javascript" src="js/jquery-2.1.1.js"></script>
 <script src="bootstrap/js/bootstrap.js"></script>
 <script type="text/javascript" src="js/moduser.js"></script>
 
</body>
</html>
