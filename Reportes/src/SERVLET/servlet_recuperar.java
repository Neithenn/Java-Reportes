package SERVLET;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.dao_recuperar;
import Functions.sendEmail;

/**
 * Servlet implementation class servlet_recuperar
 */
@WebServlet("/servlet_recuperar")
public class servlet_recuperar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_recuperar() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
public String genPass(){
    	
    	String cadena = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	int cadlenght = cadena.length();
    	String pass = "";
    	int lenght = 10;
    	
	    System.out.println("generando password");
    	
    	for (int i=0; i<lenght; i++){
    		int num = (int)(Math.random()* cadlenght);
    		String caracter = cadena.substring(num, num+1);
    		pass = pass+caracter;
    	}  
    	return pass;	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		dao_recuperar odao = new dao_recuperar();
		//Verificar si existe
		if ( odao.Verificar_Email(email)){
			
			
			
			String pass = genPass();
			if (odao.Cambiar_pass(pass, email)){
			String msj = "Estimado\nSe ha solicitado al sitio Lojack Reportes Home un recupero de contraseña. En caso de que usted no lo haya solicitado, por favor contactarse con Lo Jack.\nSu nueva contraseña es: "+pass+".\n\n\nAtte. LOJACK HOME";
			String asunto = "Reportes Home recupero contraseña";
			sendEmail enviar_mail = new sendEmail();
			
			
			enviar_mail.Send(email, msj, asunto);
			out.print("Se ha enviado un correo electronico a la casilla solicitada con la nueva contraseña.");
			}else{
				
				out.print("Ha ocurrido un error inesperado.");
			}
		}else {
		
			//mandar email
		
			out.print("No se ha encontrado un usuario con el email seleccionado.");
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
