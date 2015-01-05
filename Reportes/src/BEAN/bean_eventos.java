package BEAN;

import java.sql.Date;

public class bean_eventos {

	String Csid;
	String direc;
	String nombre;
	Date fecha_evento;
	int id_alarma;
	String  ciudad;
	String desc_usuario;
	
	public String getCsid() {
		return Csid;
	}
	public void setCsid(String csid) {
		Csid = csid;
	}
	public String getDirec() {
		return direc;
	}
	public void setDirec(String direc) {
		this.direc = direc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha_evento() {
		return fecha_evento;
	}
	public void setFecha_evento(Date fecha_evento) {
		this.fecha_evento = fecha_evento;
	}
	public int getId_alarma() {
		return id_alarma;
	}
	public void setId_alarma(int id_alarma) {
		this.id_alarma = id_alarma;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDesc_usuario() {
		return desc_usuario;
	}
	public void setDesc_usuario(String desc_usuario) {
		this.desc_usuario = desc_usuario;
	}
	
	
	
}
