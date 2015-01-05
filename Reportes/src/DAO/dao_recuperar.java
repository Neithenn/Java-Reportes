package DAO;

import java.sql.ResultSet;

public class dao_recuperar {
	
	
	public boolean Verificar_Email (String email){
	
	ResultSet resultado = null;
	
	try{
	conexion oconn = new conexion();
	String sql = "SELECT top 1 id_usuario FROM Usuarios WHERE email = '"+email+"'";
	
	resultado = oconn.query(sql);
		if (resultado.next()){
			
			return true;
		}else{
			return false;
		}
	}catch (Exception e){
		
		System.out.println("Error sql verificar");
		return false;
		
	}
	
	}
	
	
	public boolean Cambiar_pass (String pass, String email){
		
		conexion oconn = new conexion();
		String sql = "UPDATE Usuarios SET password = '"+pass+"' WHERE email = '"+email+"'";
		
		if (oconn.ejecuta_sql(sql)){
			return true;
		}else{
			return false;
		}
		
	}
	

}