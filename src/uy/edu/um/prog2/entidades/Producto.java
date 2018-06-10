package uy.edu.um.prog2.entidades;

public class Producto {
	String nombre;
	String nombreFantasia;
	String estado;
	String idProducto;
	String nroHabilitacion;
	public Producto(String nombre, String nombreFantasia, String estado, String idProducto, String nroHabilitacion) {
		super();
		this.nombre = nombre;
		this.nombreFantasia = nombreFantasia;
		this.estado = estado;
		this.idProducto = idProducto;
		this.nroHabilitacion = nroHabilitacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreFantasia() {
		return nombreFantasia;
	}
	public void setNombreFantasia(String nombreFantasia) {
		this.nombreFantasia = nombreFantasia;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getNroHabilitacion() {
		return nroHabilitacion;
	}
	public void setNroHabilitacion(String nroHabilitacion) {
		this.nroHabilitacion = nroHabilitacion;
	}
	
	
	
}
	