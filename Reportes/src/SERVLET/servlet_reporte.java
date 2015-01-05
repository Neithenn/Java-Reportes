package SERVLET;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import BEAN.bean_report;
import DAO.dao_reporte;

/**
 * Servlet implementation class servlet_reporte
 */
@WebServlet(asyncSupported = true, description = "logica reporte", urlPatterns = { "/servlet_reporte" })
public class servlet_reporte extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String jsonStr = request.getParameter("datos");
		
		
		PrintWriter out = response.getWriter();
		bean_report datos = null;
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		//Mapea el objeto bean con el Json
		datos = mapper.readValue(jsonStr, bean_report.class);
	    System.out.println(datos.getCsid1());
	    System.out.println(datos.getfecha_desde());
	    System.out.println(datos.getfecha_hasta());

	    //Alarmas
	    System.out.println(datos.getAl_apertura());
	    System.out.println(datos.getAl_cierre());
	    System.out.println(datos.getAl_robo());
	    System.out.println(datos.getAl_policia());
	    System.out.println(datos.getAl_medico());
	    System.out.println(datos.getAl_fuego());
	    System.out.println(datos.getAl_vlu());
	    System.out.println(datos.getAl_corte());
	    
	    
	    if (datos.getCsid1() != null){
	    	
			dao_reporte odao=new dao_reporte();
			JSONObject jsonResponse = new JSONObject();
			
			jsonResponse = odao.getAlarms(datos);
	    	response.setContentType("application/json");
	    	System.out.println(jsonResponse.toString());
	    	response.getWriter().write(jsonResponse.toString());
	    	
	    	
	    }else{
	    	
	    	out.print("Ha ocurrido un error inesperado, vuelva a intentarlo en unos minutos");
	    	
	    }
	    
	}


}
