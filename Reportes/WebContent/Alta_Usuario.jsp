<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Reportes Home</title>
<!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="bootstrap/css/navvar.css" rel="stylesheet">
    <link href="css/inputscreen.css" rel="stylesheet">

    <script type="text/javascript" src="js/jquery-2.1.1.js"></script>
    <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/callservlet.js"></script>
    

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
  <div class="col-md-8"></div>
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
				<li  class="active"><a  id="altauser" href="Alta_Usuario.jsp">Alta usuario</a></li>
				<li><a id="moduser" href="modificar.jsp">Modificar usuarios</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="logout.jsp">Cerrar sesión</a></li>
            </ul>
          </div>
        </div><!--/.container-fluid -->
	</nav>
  <br>
  <br>
      
<div class="tab-content">     
	
	    <div class="col-md-8 col-md-offset-3">
	    
	        <div class="form-group">
	          <label for="txttipodoc">Tipo de documento</label>
	          <select  class="form-control input" name="txttipodoc" id="txttipodoc">
	            <option>DNI</option>
	            <option>PASAPORTE</option>
	            <option>CUIL</option>
	            <option>CUIT</option>
	          </select>
	        </div>
	
	        <div class="form-group">
	          <label for="txtnumdoc">Número de documento</label>
	          <input type="text" class="form-control input" name="txtnumdoc" id="txtnumdoc" required autofocus>
	        </div>
	
	        <div class="form-group">
	          <label for="txtemail">E-Mail</label>
	          <input type="email"  class="form-control input" name="txtemail" id="txtemail" required>
	        </div>
	
	        <div class="form-group">
	          <label for="txtnummax">Max. cantidad de usuarios</label>
	          <input class="form-control input" type="number" name="txtnummax" id="txtnummax" value="3" min="0">
	        </div>
	
	        <div class="form-group">
	          <label for="txtserv">Nivel de servicio</label>
	          <select class="form-control input" name="txtserv" id="txtserv">
	            <option>Apertura y cierre</option>
	            <option>Eventos gestionables</option>
	            <option>FULL</option>
	          </select>
	        </div>
	
	        <div class="form-group">
	          <label for="txtperfil">Perfil</label>
	          <select class="form-control input" name="txtperfil" id="txtperfil">
	            <option>Cliente</option>
	            <option>Sucursal</option>
	            <option>Administrador</option>
	          </select>
	        </div>
	        <br></br>
	        
	      <button class="btn btn-xs btn-danger btn-block button" type="submit" id="cancelar">Cancelar</button>
		  <button class="btn btn-xs btn-danger btn-block button" type="button" id="modalpanel" data-toggle="modal" data-target="#Paneles">Agregar paneles</button> 
	      <button class="btn btn-xs btn-danger btn-block button" type="button" id="callserv">Crear Usuario</button>
	  </div>
	  
	  
	  <div class="modal fade" id="Paneles" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  		<div class="modal-dialog">
    		<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        			<h4 class="modal-title" id="myModalLabel">Seleccione los domicilios</h4>
      			</div>
      		<div class="modal-body">
	  
	        <form>
	         <div class="form-group">
	          <label for="txtCSID">CSID</label>
	          <input type="text" class="form-control input" id="txtCSID" maxlength="4">
	        </div>
		
	        <div class="form-group">
	          <label for="txtTipoDoc2">Tipo de documento CSID</label>
	          <select  class="form-control input" id="txtTipoDoc2">
	            <option>DNI</option>
	            <option>Pasaporte</option>
	            <option>CUIL</option>
	            <option>CUIT</option>
	          </select>
	        </div>
	
	        <div class="form-group">
	          <label for="txtNumDoc2">Número de documento CSID</label>
	          <input type="text" class="form-control input" id="txtNumDoc2">
	        </div>
	      <br>
	        <button id="addRow" class="btn btn-xs btn-danger btn-block button" type="submit">Agregar</button>
	      </form>
	      <br>
	      
	      </br>
	            <table class="table table-bordered" id="tblDatos">
	                <tr>
	                  <th>CSID</th>
	                  <th>Tipo de Documento</th>
	                  <th>Número de Documento</th>
	                  <th>Seleccionar</th>
	                </tr>
	            </table>
	            
	                <div class="modal-footer">
	               		<button type="button" class="btn btn-danger" id="removeRow">Eliminar</button>
        				<button type="button" class="btn btn-danger" data-dismiss="modal">Guardar</button>
      				</div>      
			</div>
		</div>
	</div>
</div>	       

</div> <!--.tab content-->
</div> <!-- /container -->

<footer class="footer">

</footer>

</body>
</html>
