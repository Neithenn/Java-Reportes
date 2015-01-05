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
import DAO.dao_login;
import Functions.StringMD;

/**
 * Servlet implementation class servlet_login
 */
@WebServlet("/servlet_login")
public class servlet_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated constructor stub
    }
    
    
    
    public boolean validar(HttpServletRequest request, HttpServletResponse response, bean_user obean){
	  	HttpSession session = request.getSession();
        dao_login odao=new dao_login();
        
        if(odao.Validar(obean)){
       session.setAttribute("obean", obean);
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
		// TODO Auto-generated method stub
	  	System.out.println("Servlet");
	  	String encryppass;
	  	PrintWriter out = response.getWriter();
	    bean_user obean=new bean_user();      
	    obean.setNombre(request.getParameter("txtnombre"));
	    encryppass = StringMD.getStringMessageDigest(request.getParameter("txtpassword"), StringMD.MD5);
	    obean.setPassword(encryppass);
	    obean.setId_tipodoc(request.getParameter("txttipodoc"));
	  	 
	            if(this.validar(request, response, obean)){
	            	System.out.println("Ingreso correcto");
	            	
	            	if (obean.getId_perfil() == 1){
	            		
	            		response.sendRedirect("Alta_Usuario.jsp");
	            		
	            	}else
	            		if(obean.getId_perfil() == 2){
	            		
	            		response.sendRedirect("reportes.jsp");
	            	}else
	            		if(obean.getId_perfil() == 3){
		            		
		            		response.sendRedirect("reportes.jsp");
		            	}
	            }else{
	            	
	            	 out.print("<script>alert('usuario incorrecto'); location.href='home.jsp'</script>");
	            	System.out.println("usuario incorrecto");
	            }
	}

}
