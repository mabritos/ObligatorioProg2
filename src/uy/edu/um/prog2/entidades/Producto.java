package uy.edu.um.prog2.entidades;

public class Producto {
	String nombre;
	String estado;
	String idProducto;
	String nroHabilitacion;
	Pais pais;
	Empresa empresa;
	Marca marca;
	Clase clase;
	
	
	public Producto(String nombre, String estado, String idProducto, String nroHabilitacion, Pais pais, Empresa empresa, Marca marca, Clase clase) {
		super();
		this.pais = pais;
		this.nombre = nombre;
		this.estado = estado;
		this.idProducto = idProducto;
		this.nroHabilitacion = nroHabilitacion;
		this.empresa = empresa;
		this.marca = marca;
		this.clase = clase;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}
	public Pais getPais() {
		return pais;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	