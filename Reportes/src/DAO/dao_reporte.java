package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import BEAN.bean_alarma;
import BEAN.bean_report;
import Functions.CsidDatos;

public class dao_reporte {

	
	public JSONObject getAlarms (bean_report obeanalarmas){
		
		JSONObject objDatos = new JSONObject();
		
		String user = "ezequiel";
		String pass = "1234";
		String sp = "{ call getAlarmas(?, ?, ?, ?) }";
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;databaseName=Reportes_Home;";
            Connection con= DriverManager.getConnection(url, user, pass);
			
            CallableStatement proc_stmt = null;
            proc_stmt = con.prepareCall(sp);
            
            CsidDatos CsidString = new CsidDatos();
    		String consultaCsid = CsidString.Csid(obeanalarmas.getCsid1());
    		
    	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date parsed = format.parse(obeanalarmas.getfecha_desde());
            java.sql.Date f_desde = new java.sql.Date(parsed.getTime());
            
            parsed = format.parse(obeanalarmas.getfecha_hasta());
            java.sql.Date f_hasta = new java.sql.Date(parsed.getTime());
    		
    		proc_stmt.setDate(1, f_desde);
    		proc_stmt.setDate(2, f_hasta);
            proc_stmt.setString(3, consultaCsid);
            proc_stmt.setString(4, CsidString.IdAlarmas(obeanalarmas.getAl_apertura(), obeanalarmas.getAl_cierre(), obeanalarmas.getAl_robo(), 
				obeanalarmas.getAl_fuego(), obeanalarmas.getAl_policia(), obeanalarmas.getAl_medico(), obeanalarmas.getAl_vlu(), obeanalarmas.getAl_corte()));
            
            ResultSet resultado = proc_stmt.executeQuery();
            
            if( resultado != null){
				
    			List<bean_alarma> sqlresult = new ArrayList<bean_alarma>();	
    				
    				while (resultado.next()){
    					
    					
    					//Meto en un objeto los datos del select
    					bean_alarma datos = new bean_alarma();
    					datos.setFecha_evento(resultado.getString(1));
    					datos.setCsid(resultado.getString(2));
    					datos.setAlarma(resultado.getString(3));
    					datos.setNombre(resultado.getString(4));
    					datos.setDireccion(resultado.getString(5));
    					datos.setCiudad(resultado.getString(6));
    					datos.setUsuario(resultado.getInt(7));
    					//lo agrego a la lista
    					 sqlresult.add(datos);
    					
    				}
    				JSONArray objreporte = new JSONArray();
    				try{
    					//Introduzco los datos de la lista en un JsonArray
    					for (bean_alarma eventos : sqlresult){
    					     JSONObject objEventos = new JSONObject();
    				            objEventos.put("csid", eventos.getCsid());
    				            objEventos.put("nombre", eventos.getNombre());
    				            objEventos.put("direccion", eventos.getDireccion());
    				            objEventos.put("Fecha_evento", eventos.getFecha_evento());
    				            objEventos.put("Alarma", eventos.getAlarma());
    				            objEventos.put("ciudad", eventos.getCiudad());
    				            objEventos.put("Usuario", eventos.getUsuario());
    				            objreporte.put(objEventos);
    					}
    					
    					
    				}catch (Exception e){
    					System.out.println("exception al armar el jsonarray");
    					objDatos = null;
    					return objDatos;
    				}
    				
    				//adjunto el JsonArrya en un JsonObject con nombre "datos"

    				objDatos.put("Datos", objreporte);
    			    System.out.println(objDatos);
  
            }
            	con.close();
            	return objDatos;
            
            
			}catch(ClassNotFoundException ex){
	            //conexion=null;
	        	 System.out.println("Error1 Trace in getConnection() "+ex.getMessage());
	        	 return objDatos;
				
			}catch(SQLException ex){
		           // conexion=null;
	            System.out.println("Error2 Trace in getConnection() "+ex.getMessage());	
	            return objDatos;
			}catch(Exception ex){
			      // conexion=null;
	            System.out.println("Error2 Trace in getConnection() "+ex.getMessage());
	            return objDatos;
				
			}
		
		
		
	}
	
}