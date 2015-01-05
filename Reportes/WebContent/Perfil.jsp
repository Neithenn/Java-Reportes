<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Reportes Home</title>


	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="bootstrap/css/navvar.css" rel="stylesheet">
    <link href="css/inputscreen.css" rel="stylesheet">



</head>
<body onload="Load();">
	<%@ page import = "BEAN.bean_user"    %>
            <% 
    //Checkear mejor forma de hacer esto.
    if (session.getAttribute("obean") != null){
    bean_user obean = (bean_user)session.getAttribute("obean");
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
    
 <!-- Static navbar -->
      <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">

          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="reportes.jsp">Reportes</a></li>
              <li class="active"><a href="Perfil.jsp">Perfil</a></li>
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
  <br>
  
  <div class="col-md-offset-2">
  

  		<label for="tipodoc">Tipo Documento</label>
  		<input id="tipodoc" class="form-group form-control input" value="" disabled></input>
  		<label for="numdoc" >Número de documento</label>
  		<input id="numdoc" class="form-group form-control input" value="" disabled></input>
  		<label for="email" >E-mail</label>
  		<input id="email" class="form-group form-control input" value=""></input>
		<label for="pass">Password</label>
		<input id="pass" type="password" class="form-group form-control input"></input>
		<label for="repass">Repetir password</label>
		<input id="repass" type="password" class="form-group form-control input"></input>
		<button type="submit" class="btn btn-danger" id="btn_save">Guardar</button>
  </div>
  <br>
  <br>
  <br>
  <footer class="footer">
	</footer>
  
  
    <script type="text/javascript" src="js/jquery-2.1.1.js"></script>
    <script type="text/javascript" src="js/perfil.js"></script>
        <script>

function Load() {
	
	var TipoDoc = "<% bean_user obean2 = (bean_user)session.getAttribute("obean");
	 out.print(obean2.getId_tipodoc());%>";

	document.getElementById("tipodoc").value = TipoDoc;
	var NumDoc = "<% out.print(obean2.getNombre()); %>";
	document.getElementById("numdoc").value = NumDoc;
	var email = "<% out.print(obean2.getEmail()); %>";
	document.getElementById("email").value = email;
	}
	
	
	var perfil = "<%  out.print(obean2.getId_perfil());%>";
	
	if (perfil!= 1){
	
		$('#altauser').remove();
		$('#moduser').remove();
	
		}


</script>
</body>




</html>