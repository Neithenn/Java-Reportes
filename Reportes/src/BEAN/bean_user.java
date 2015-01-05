/**
 * 
 */
package BEAN;

/**
 * @author Ezequiel
 *
 */
public class bean_user {

	int id_user;
	String tipodoc;
	int id_perfil;
	String nombre;
	String password;
	int id_servicio;
	String email;
	String CSID_asoc;
	int maxNum;
	int tipodoc2;
	
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId_tipodoc() {
		return tipodoc;
	}
	public void setId_tipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}
	public int getId_perfil() {
		return id_perfil;
	}
	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
	}
	public String getTipodoc() {
		return tipodoc;
	}
	public void setTipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}
	public int getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCSID_asoc() {
		return CSID_asoc;
	}
	public void setCSID_asoc(String cSID_asoc) {
		CSID_asoc = cSID_asoc;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	public int getTipodoc2() {
		return tipodoc2;
	}
	public void setTipodoc2(int tipodoc2) {
		this.tipodoc2 = tipodoc2;
	}
}

