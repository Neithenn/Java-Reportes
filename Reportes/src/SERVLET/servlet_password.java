package SERVLET;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.bean_user;
import DAO.dao_password;
import Functions.StringMD;

/**
 * Servlet implementation class servlet_password
 */
@WebServlet("/servlet_password")
public class servlet_password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_password() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public boolean Cambiar_Pass(String password, int id_user, String email){
    	
    	
    	dao_password opass = new dao_password();
    	
    	if (opass.cambiar_pass(password, id_user, email)){
    	
    		return true;
    	
    	}else{
    		
    		return false;
    	}
    	
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
	  	PrintWriter out = response.getWriter();
		bean_user user = (bean_user) session.getAttribute("obean");
		
    	String encryppass = StringMD.getStringMessageDigest(password, StringMD.MD5);
		
		if (Cambiar_Pass(encryppass, user.getId_user(), email)){
			
			out.print("Se ha cambiado la password!");
			
		}else{
			
			out.print("Ha ocurrido un error ");
		}
		
		
		
	}

}
