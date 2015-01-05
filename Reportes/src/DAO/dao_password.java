package DAO;

public class dao_password {

	public boolean cambiar_pass(String password, int id_user, String email) {
	try{
		
		conexion oconn = new conexion();
		String sql = "UPDATE Usuarios SET password = '"+password+"', email = '"+email+"' WHERE ID_Usuario = "+id_user; 
		if (oconn.ejecuta_sql(sql)){
			return true;
			
		}else{
			return false;
		}

	}catch(Exception e){
		return false;}
	}

}
