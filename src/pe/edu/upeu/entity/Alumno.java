package pe.edu.upeu.entity;

public class Alumno {
	private int idalumno;
	private int idescuela;
	private String apellnombres;
	private String correo;
	private String telefono;
	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alumno(int idalumno, int idescuela, String apellnombres, String correo, String telefono) {
		super();
		this.idalumno = idalumno;
		this.idescuela = idescuela;
		this.apellnombres = apellnombres;
		this.correo = correo;
		this.telefono = telefono;
	}
	public int getIdalumno() {
		return idalumno;
	}
	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}
	public int getIdescuela() {
		return idescuela;
	}
	public void setIdescuela(int idescuela) {
		this.idescuela = idescuela;
	}
	public String getApellnombres() {
		return apellnombres;
	}
	public void setApellnombres(String apellnombres) {
		this.apellnombres = apellnombres;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
