package uy.edu.um.prog2.entidades;

public class Producto {
	String nombre;
	String nombreFantasia;
	String estado;
	Empresa empresa;
	Pais pais;
	Clase clase;
	Rubro[] rubros;
	
	

	public Producto(String nombre, String nombreFantasia, String estado, Empresa empresa, Pais pais, Clase clase, Rubro[] rubros) {
		this.nombre = nombre;
		this.nombreFantasia = nombreFantasia;
		this.estado = estado;
		this.empresa = empresa;
		this.pais = pais;
		this.clase = clase;
		this.rubros = rubros;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	public Rubro[] getRubros() {
		return rubros;
	}
	public void setRubros(Rubro[] rubros) {
		this.rubros = rubros;
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
	

}
