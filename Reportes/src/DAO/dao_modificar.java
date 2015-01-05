package DAO;

import java.sql.ResultSet;

import org.json.JSONObject;

public class dao_modificar {
	
	public JSONObject  traer_usuario(String usuario){
		
		
		ResultSet resultado;
		JSONObject ojson = new JSONObject();
		try{
		conexion oconn = new conexion();
		String sql = "Select top 1 ID_usuario, email, ID_perfil, Id_Servicio FROM Usuarios WHERE numdoc = '"+usuario+"'";
		resultado = oconn.query(sql);
		
		
		
		while (resultado.next()){
			
			ojson.put("Id", resultado.getInt(1));
			ojson.put("Email", resultado.getString(2));
			ojson.put("Perfil", resultado.getInt(3));
			ojson.put("Servicio", resultado.getInt(4));
			
			
		}
		
		}catch(Exception e){
			
			
			System.out.println("Error consulta");
			
		}
		
		return ojson;
	}
	
	
	public boolean eliminar_usuario (String usuario){
		
		conexion oconn = new conexion();
		String sql = "DELETE usuarios WHERE numdoc = '"+usuario+"'";
		if (oconn.ejecuta_sql(sql)){
			return true;
		}else{
			
			return false;
		}
		
	}
	
	
	public boolean cambiar_usuario (String usuario, int perfil, int servicio){
		
		if (perfil == 0 || servicio == 0){
			return false;
		}else{
			
			conexion oconn = new conexion();
			String sql = "UPDATE Usuarios SET Id_perfil = "+perfil+" ,Id_servicio = "+servicio+" WHERE NumDoc = '"+usuario+"'";
			if (oconn.ejecuta_sql(sql)){
				return true;
			}else{
				
				return false;
			}
		}
		
	}
	

}
