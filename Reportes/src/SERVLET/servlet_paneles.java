package SERVLET;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import DAO.dao_login;

/**
 * Servlet implementation class servlet_paneles
 */
@WebServlet("/servlet_paneles")
public class servlet_paneles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_paneles() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		int id_user = Integer.parseInt(request.getParameter("user"));
		
		if (id_user != 0){
			
			dao_login odao = new dao_login();
			JSONObject ojson = new JSONObject();
			
			ojson = odao.getCsids(id_user);
			
			if (ojson != null){
				response.setContentType("application/json");
				System.out.println(ojson.toString());
		    	response.getWriter().write(ojson.toString());
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
