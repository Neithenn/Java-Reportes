package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import BEAN.bean_csid;
import BEAN.bean_paneles;
import BEAN.bean_user;

public class dao_login {
	
	public boolean Validar (bean_user obeanlogin){
		
		try{
			ResultSet resultado;
			int perfil = 0;
			int servicio = 0;
			String sql = "select top 1 id_usuario, id_perfil, id_servicio, email from usuarios inner join tipo_documento ON tipo_documento.ID_tipodoc = usuarios.id_tipodoc where NumDoc = '"+obeanlogin.getNombre()+"' AND password = '"+obeanlogin.getPassword()+"' AND descripcion = '"+obeanlogin.getId_tipodoc()+"'";
			conexion oconn = new conexion();
			resultado = oconn.query(sql);
			System.out.println("validar dao_login");
			if (resultado != null){
					while (resultado.next()){
						
						obeanlogin.setId_user(resultado.getInt(1));
						perfil = resultado.getInt(2);
						servicio = resultado.getInt(3);
						obeanlogin.setEmail(resultado.getString(4));
						
					}

					if (perfil != 0){
						obeanlogin.setId_perfil(perfil);
						if(servicio != 0){
							
						obeanlogin.setId_servicio(servicio);
						return true;
						
						}else{
							return false;
						}
					}else{
						return false;
					}
					
			}else{
					return false;
						}
		}catch(Exception ex){
			
			System.out.println(""+ex.getMessage());
			return false;
			
		}
	}
	
	
	public boolean VerificarUser (String username){
		
		
		try{
			String sql = "select id_usuario FROM usuarios WHERE NumDoc = '"+username+"'";
			ResultSet resultado;
			conexion oconn = new conexion();
			resultado = oconn.query(sql);
			
			if (resultado.next()){
				return false;
			}else{
				return true;
			}
			
			}catch(Exception ex){
				
				System.out.println(""+ex.getMessage());
				return true;
			}
		
	}
	
	
	public boolean VerificarMail (String email){
		
		try{
			String sql = "select id_usuario FROM usuarios WHERE Email = '"+email+"'";
			ResultSet resultado;
			conexion oconn = new conexion();
			resultado = oconn.query(sql);
			
			if (resultado.next()){
				return false;
			}else{
				return true;
			}
			
			}catch(Exception ex){
				
				System.out.println(""+ex.getMessage());
				return true;
			}
		
	}

	public boolean Registrar (bean_user obeanalta){
		
		try{
			String sql = "insert into usuarios values ('"+obeanalta.getNombre()+"', "+obeanalta.getId_perfil()+", "+obeanalta.getTipodoc2()+", '"+obeanalta.getEmail()+"', "+obeanalta.getId_servicio()+", "+obeanalta.getMaxNum()+", '"+obeanalta.getPassword()+"')";
			conexion oconn = new conexion();
		    System.out.println("a ejecutar el insert");
			if (oconn.ejecuta_sql(sql)){	
				return true;	
			}else{
				return false;		
			}
		}catch (Exception ex){
			 System.out.println("exception del insert");
			return false;
		}

	}
	

	public JSONObject getCsids(int id_user) {
		
		ResultSet resultado;
		
		try {
			String sql = "select csid, nombre_Csid, direccion_csid, ciudad_csid from Csid_asociados where ID_usuario = "+id_user;
			conexion oconn = new conexion();
			resultado = oconn.query(sql);
			
			if (resultado != null){
			
				JSONObject objDatos = new JSONObject();
				List<bean_paneles> sqlresult = new ArrayList<bean_paneles>();
				while (resultado.next()){
					bean_paneles datos = new bean_paneles();
					datos.setCsid(resultado.getString(1));
					datos.setNombre(resultado.getString(2));
					datos.setDireccion(resultado.getString(3));
					datos.setCiudad(resultado.getString(4));
					
					sqlresult.add(datos);
				}
				
				JSONArray objcsid = new JSONArray();
				try{
					//Introduzco los datos de la lista en un JsonArray
					for (bean_paneles paneles : sqlresult){
					     JSONObject objPaneles = new JSONObject();
				            objPaneles.put("csid", paneles.getCsid());
				            objPaneles.put("nombre", paneles.getNombre());
				            objPaneles.put("direccion", paneles.getDireccion());
				            objPaneles.put("ciudad", paneles.getCiudad());
				            objcsid.put(objPaneles);
					}
					
				}catch (Exception e){
					System.out.println("exception al armar el jsonarray");
					objDatos = null;
					return objDatos;
				}
				
				//adjunto el JsonArrya en un JsonObject con nombre "datos"

				objDatos.put("Datos", objcsid);
			    System.out.println(objDatos);
				
			     return objDatos;
				
			}
			
			
		}catch(Exception e){}
		
		return null;
	}
	
	
	
public boolean registrarCsids(bean_csid[] csidarray, int id_user) {
		
		conexion oconn = new conexion();
		boolean error = false;
		int i = 0;
		
		while (error == false && i< csidarray.length)
		{
			String sql = "INSERT INTO Csid_Asociados(Id_usuario, Csid, nombre_Csid, ciudad_Csid, direccion_Csid) SELECT "+id_user+", '"+csidarray[i].getCsid()+"', nombre, ciudad, direccion from instalaciones where csid = '"+csidarray[i].getCsid()+"'";
			
			if (oconn.ejecuta_sql(sql) == false ){
				error = true;
			}
			
			i++;
		}
		
		return error;
	}
	
	
	
	public int getId_userBD (String nombre, String email){

		ResultSet resultado;
		int i = 0; 
		try{
			conexion oconn = new conexion();
			String sql = "SELECT TOP 1 id_usuario FROM usuarios WHERE NumDoc = '"+nombre+"' AND email = '"+email+"'";
			resultado = oconn.query(sql);
			
			while(resultado.next()){
				
				i = resultado.getInt(1);
				
			}
			
			return i;
			
		}catch (Exception e){
			
			return 0;
			
		}	
		
	}

	

}
