/**
 * 
 */
package Functions;


/**
 * @author eduro
 * Devuelve el string de los CSID para realizar la consulta de BD y traer los eventos
 */
public class CsidDatos {

	public String Csid (String Csids){
		String result = "";
		String[] array = Csids.split("\\.");
		int aux = 0;
		
		if (array.length == 1){
		
			result = array[0];
		
		}else{

				for (int i=0; i< array.length - 1; i++){
				
					result = result +array[i] + ",";
					aux = i;
				}
		
				result = result + array[aux+1];
		}
		
		return result;
		
	}
	
	
	public String IdAlarmas (int apertura,int cierre, int robo, int fuego, int policia, int medico, int vlu, int corte){
		
		String result = "";
	if (apertura == 1){
			
		result = result + "A,";
		}
	
	if (cierre == 1){
		
		result = result + "C,";
	}
	if (robo == 1){
		
		result = result + "R,";
	}
	if (fuego == 1){
		
		result = result + "'4',";
	}
	if (policia == 1){
		
		result = result + "'5',";
	}
	
	if (medico == 1){
		
		result = result + "6',";
	}
	
	if (vlu == 1){
		
		result = result + "7',";
	}
	
	if (corte == 1){
		
		result = result + "8',";
	}
	
		return result;
		
	} 
	
	
}
