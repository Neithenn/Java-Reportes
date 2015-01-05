package SERVLET;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import BEAN.bean_csid;
import BEAN.bean_user;
import DAO.dao_login;
import Functions.StringMD;
import Functions.sendEmail;

/**
 * Servlet implementation class servlet_altauser
 */
@WebServlet(description = "Servlet para el alta usuario administrador", urlPatterns = { "/servlet_altauser" })
public class servlet_altauser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated constructor stub
    }
    
    public String registrar(HttpServletRequest request, HttpServletResponse response, bean_user obean){
    	
    //CSID
	    System.out.println("Registrar - bean seteado");
    	
        dao_login odao=new dao_login();
        
        if (odao.VerificarUser(obean.getNombre())){
        	if (odao.VerificarMail(obean.getEmail())){
        //INSERTA
		        if (odao.Registrar(obean)){
		        	return "Se ha dado de alta el usuario correctamente. Se le enviará un correo electrónico al usuario junto con su password.";
		        }else{
		        	return "Error. No se ha podido dar de alta el usuario.";  
		        }
		    }else{
        return "Error. El correo electrónico ingresado ya se encuentra registrado.";}
     }else{
    	return "Error. El número de documento ingresado ya se encuentra registrado.";
     }
    }
    
    public String genPass(){
    	
    	String cadena = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	int cadlenght = cadena.length();
    	String pass = "";
    	int lenght = 10;
    	
	   
    	
    	for (int i=0; i<lenght; i++){
    		int num = (int)(Math.random()* cadlenght);
    		String caracter = cadena.substring(num, num+1);
    		pass = pass+caracter;
    	} 
    	
 
    	return pass;	
    }
    
    
    public boolean registrarCsids (bean_csid[] datos, String nombre, String email){
    	
        dao_login odao= new dao_login();
        int id_user = odao.getId_userBD(nombre, email);
        
        if (id_user != 0){
        	if (odao.registrarCsids(datos, id_user)== false){
        		return true;
        	}else{
        		return false;
        	}
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
		String password;
		response.setContentType("text/html;charset=UTF-8");
	  	PrintWriter out = response.getWriter();
	    System.out.println("Servlet alta usuario");

		bean_user obean = new bean_user();
		
		//Tipo documento
    	if (request.getParameter("document").equals("DNI")){	
    		obean.setTipodoc2(1);
    	}else if (request.getParameter("document").equals("PASAPORTE")){
    		obean.setTipodoc2(2);	
    	}else if (request.getParameter("document").equals("CUIL")){
    		obean.setTipodoc2(3);
    	}else if (request.getParameter("document").equals("CUIT")){
    		obean.setTipodoc2(4);
    	}
		
		//documento
    	obean.setNombre(request.getParameter("numdoc"));
    
    	//Email
    	obean.setEmail(request.getParameter("email"));
    	//pass
    	password = genPass();
    	obean.setPassword(StringMD.getStringMessageDigest(password, StringMD.MD5));
    	// maximo numero de usuario que puede crear
    	
    	int maxnum = Integer.parseInt(request.getParameter("nummax"));
    	obean.setMaxNum(maxnum);
    	
    	//Perfil
    	if (request.getParameter("perfil").equals("Administrador")){	
    		obean.setId_perfil(1);
    	}else if (request.getParameter("perfil").equals("Cliente")){
    		obean.setId_perfil(2);	
    	}else if (request.getParameter("perfil").equals("Sucursal")){
    		obean.setId_perfil(3);
    	}
    	
    	//Nivel de servicio
    	if (request.getParameter("serv").equals("Apertura y cierre")){	
    		obean.setId_servicio(1);
    	}else if (request.getParameter("serv").equals("Eventos gestionables")){
    		obean.setId_servicio(2);	
    	}else if (request.getParameter("serv").equals("FULL")){
    		obean.setId_servicio(3);
    	}else{	
    		System.out.println("serv null");
    		obean.setId_servicio(0);
    	}

    	//Tratar Csids
    	String json = request.getParameter("json");
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		//Mapea el objeto bean con el Json
		bean_csid[] datos = mapper.readValue(json, bean_csid[].class);

    	
	    
		String msjresult = this.registrar(request, response ,obean);
			
		if ( msjresult.contains("Error")){
			
			out.print(msjresult);
			
		}else{
				
			if (registrarCsids(datos, obean.getNombre(), obean.getEmail())){
			//Usuario creado correctamente
				System.out.println(password);
				sendEmail userEmail = new sendEmail();
				String msj = "Estimado. \nLe informamos que su cuenta ha sido dada de alta en Reportes Home Lojack.\nSus datos de ingreso son:\n\nNúmero de documento: "+password+"\nPassword: "+obean.getNombre()+"\n\n\nAtte. LOJACK HOME";
				String asunto = "Reportes Home alta de usuario";
				userEmail.Send(obean.getEmail(), msj, asunto);
				out.print(msjresult);
				System.out.println("Exito");
			
			}else{	
				System.out.println("Fallo alagregar csids");
				out.print("Error. Ha ocurrido un error al cargar los paneles.");
			}	
		}
	}
}
