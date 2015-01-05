
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="description" content="Lo Jack Home Reportes">
<meta name="keywords" content="LOJACK HOME,Lo Jack Home,LJHOME, Lo Jack Home Reportes, LOJACK HOME REPORTES">
<meta name="author" content="Lo Jack">


<title>Lojack Home</title>
   <link  type="text/css" href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
   <link  type="text/css" href="bootstrap/css/singin.css" rel="stylesheet" />
</head>
<body>

<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/jquery.md5.js" type="text/javascript"></script>
<script src="js/home.js" type="text/javascript"></script>

<div class="container">

      <form class="form-signin" role="form" name="form1" method="post" action="servlet_login?accion=VALIDAR">
         <img src="logo.jpg" alt="Lo Jack" class="img-responsive">
         <br>
        <select class="form-control" name="txttipodoc" placeholder="Tipo de documento" id="txttipodoc" required autofocus>
        <option>DNI</option>
        <option>Pasaporte</option>
        <option>CUIL</option>
        <option>CUIT</option>
        </select>
        <br>
        <input type="text" class="form-control" name="txtnombre" id="txtnombre" placeholder="Número de documento" required autofocus>
         <br>
        <input type="password" class="form-control" name="txtpassword" id="txtpass" placeholder="Password" required>
        
        <button class="btn btn-lg btn-danger btn-block red" type="submit">Ingresar</button>
       
        <a href="#" data-toggle="modal" data-target="#Recuperar">Recuperar contraseña</a> 
      </form>


	  <div class="modal fade" id="Recuperar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  		<div class="modal-dialog">
    		<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        			<h4 class="modal-title" id="myModalLabel">Recuperar contraseña</h4>
      			</div>
      		<div class="modal-body">
      		<div class="form-group" >
				<label for="txtemail">Introducir el email de la cuenta</label>
				<input type="email" id="txtemail" class="form-control input"></input>
				</div> 
				<br></br>
                		<div class="modal-footer">
        					<button type="button" class="btn btn-danger" data-dismiss="modal" id="btn_enviar">Enviar</button>
      					</div>      
					</div>
				</div>
			</div>
		</div>	       


    </div> <!-- /container -->

</body>
</html>