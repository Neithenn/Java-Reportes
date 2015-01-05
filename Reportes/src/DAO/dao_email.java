package DAO;

public class dao_email {

public static void Save(String msj, String to){
		
		conexion conn = new conexion();
		String sql = "INSERT INTO Send_Mail VALUES('"+msj+"', '"+to+"', GETDATE())";
		conn.ejecuta_sql(sql);
		
	}
	
}
