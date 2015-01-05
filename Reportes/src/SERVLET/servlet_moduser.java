package SERVLET;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import DAO.dao_modificar;

/**
 * Servlet implementation class servlet_moduser
 */
@WebServlet("/servlet_moduser")
public class servlet_moduser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_moduser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = request.getParameter("numdoc");
		String boton = request.getParameter("accion");
		PrintWriter out = response.getWriter();
		
		dao_modificar odao = new dao_modificar();
		
		if (boton.equals("eliminar")){
			
			if(odao.eliminar_usuario(usuario)){
				//OK
				out.println("El usuario "+usuario+" se ha dado de baja correctamente");
			}else{
				
				//Fallo
				out.println("Ha ocurrido un error, no se ha podido dar de baja");
			}
			
		}else if(boton.equals("guardar")){
			
			String perfil = request.getParameter("perfil");
			String servicio = request.getParameter("servicio");
			int id_perfil = 0;
			int id_servicio = 0;
			
			switch (perfil){
			
			case "Administrador": id_perfil = 1;
			case "Cliente": id_perfil = 2;
			case "Sucursal": id_perfil = 3;
			
			}
			
			switch (servicio){
			case "Apertura y cierre": id_servicio = 1;
			case "Eventos gestionables": id_servicio = 2;
			case "FULL": id_servicio = 3;
			
			}
			
			
			if (odao.cambiar_usuario(usuario, id_perfil, id_servicio)){
				
				out.println("El usuario "+usuario+" se ha modificado correctamente");
				
			}else{
				
				out.println("Ha ocurrido un error. No se pudo modificar el usuario.");
				
			}
	
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String usuario = request.getParameter("numdoc");
		
		dao_modificar odao = new dao_modificar();
		JSONObject jsonResponse = new JSONObject();
		
		
		jsonResponse = odao.traer_usuario(usuario);
    	response.setContentType("application/json");
    	System.out.println(jsonResponse.toString());
    	response.getWriter().write(jsonResponse.toString());
		
		
	}

}
