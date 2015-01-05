<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="org.json.JSONObject, java.util.List, com.fasterxml.jackson.databind.ObjectMapper, com.fasterxml.jackson.databind.type.TypeFactory" %>
    <%@ page import="BEAN.bean_excel" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reportes Home</title>
</head>
<body>

<script type="text/javascript" src="js/jquery-2.1.1.js"></script>



	<table hidden class="table table-bordered table-striped" id="tbl_eventos">
	  <thead>
	    <tr>
	      <th>Csid</th>
	      <th>Nombre del cliente</th>
	      <th>Dirección</th>
	      <th>Fecha evento</th>
	      <th>Alarma</th>
	      <th>Ciudad</th>
	      <th>Usuario</th>  
	    </tr>
	    
	    <% String id = request.getParameter("id");
	    System.out.println(id);
	    
	    ObjectMapper objectMapper = new ObjectMapper();
	    
	    List<bean_excel> lista = objectMapper.readValue(id,  objectMapper.getTypeFactory().constructCollectionType(List.class, bean_excel.class));
	    
	    for (int i = 0; i < lista.size(); i++){
	    bean_excel oeventos = new bean_excel();
	    oeventos = lista.get(i); 
	    
	    %>
	    <tr>
	    <td><%= oeventos.getCsid()%></td>
	    <td><%= oeventos.getNombrecliente()%></td>
	    <td><%= oeventos.getDireccion()%></td>
	    <td><%= oeventos.getFechadelevento()%></td>
	    <td><%= oeventos.getCiudad()%></td>
	    <td><%= oeventos.getUsuario()%></td>
	    </tr>
	    
	 <%
	 }
		response.setHeader("Content-Disposition",  "attachment;filename=\"ReporteHome.xls\"");
	    
	    %>
	    
	  </thead>
	</table>

</body>
</html>