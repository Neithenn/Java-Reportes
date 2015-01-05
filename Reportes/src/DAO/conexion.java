package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class conexion {
	
	private static String user;
	private static String pass;
	private static Connection conexion = null;
	
	
	protected Connection Conectar(){
		
		user = "Ezequiel-PC\\Ezequiel";
		pass = "amelie";
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;databaseName=Reportes_Home;integratedSecurity=true;";
            conexion= DriverManager.getConnection(url, user, pass);
			
			}catch(ClassNotFoundException ex){
	            //conexion=null;
	        	 System.out.println("Error1 Trace in getConnection() "+ex.getMessage());
				
			}catch(SQLException ex){
		           // conexion=null;
	            System.out.println("Error2 Trace in getConnection() "+ex.getMessage());	
			}catch(Exception ex){
			      // conexion=null;
	            System.out.println("Error2 Trace in getConnection() "+ex.getMessage());	
				
			}
		return conexion;
	}
	
	protected ResultSet query(String QUERY_SQL){
		// PARA SELECTS, TRAER DATOS
		Connection conexion;
		Statement st;
		conexion = Conectar();
		ResultSet resultado;
	
		try{
			
			st = conexion.createStatement();
			resultado = st.executeQuery(QUERY_SQL);
			System.out.println("query");
			return resultado;
			
		}catch(SQLException ex){
			System.out.println("Error...."+ ex.toString());
            return null;
			
		}
		
	}

	protected boolean ejecuta_sql(String COMANDO_SQL){
		  //PARA INSERTAR,MODIFICAR,ELIMINAR
		  Connection conexion;
		  Statement st;
		  
			  try{
			      conexion = Conectar();
			      st = conexion.createStatement();
			      System.out.println("insertando...");
			      st.executeUpdate(COMANDO_SQL);
			      conexion.close();
			      st.close();
			      return true;
			  }catch(Exception ex){
			      System.out.println("Error...."+ ex.toString());
			      return false;
		 }
	}
	

}