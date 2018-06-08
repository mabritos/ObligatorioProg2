package uy.edu.um.prog2.entidades;

public class Empresa {

	String nombre;
	String ruc;
	
	public Empresa(String nombre, String ruc) {
		super();
		this.nombre = nombre;
		this.ruc = ruc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
	
}
