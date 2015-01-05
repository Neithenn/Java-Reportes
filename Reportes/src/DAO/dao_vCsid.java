package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class dao_vCsid {
	
	public boolean verificar_csid (String csid, String tdoc, String ndoc){
		
		ResultSet resultado;
		conexion conn = new conexion();
		
		try {
		String sql = "select top 1 idInstalacion from instalaciones as i inner join Tipo_documento2 as t on i.idTipoDocumento = t.id where csid = '"+csid+"' AND numeroDocumento = '"+ndoc+"' AND descripcion = '"+tdoc+"'";
		
		resultado = conn.query(sql);
				
			
					if (resultado.next()){

						return true;
						
					}else{
							
						return false;
					}
				} catch (SQLException e) {
		
					e.printStackTrace();
					return false;
				}
		
	}
	

}
