package uy.edu.um.prog2.entidades;

import uy.edu.um.prog2.adt.hash.ClosedHashTable;
import uy.edu.um.prog2.adt.hash.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.hash.HashCompletoException;
import uy.edu.um.prog2.adt.hash.HashTable;

public class Marca {

	private String nombre;
	private int prodxPais = 0;
	private HashTable<Clase> clases = new ClosedHashTable<Clase>(211);
	private HashTable<Producto> productos = new ClosedHashTable<Producto>(211);
	
	public Marca(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarClase(String clave, Clase clase) throws ElementoYaExistenteException, HashCompletoException {
		clases.insertar(clave, clase);
	}
	public void agregarProdxPais() {
		prodxPais++;
	}
	public void agregarProducto(String clave, Producto producto) throws ElementoYaExistenteException, HashCompletoException {
		productos.insertar(clave, producto);
	}
	public HashTable<Producto> getProductos(){
		return productos;
	}
	
	public int getProdxPais() {
		return prodxPais;
	}
	
	public void setProdxPais(int prodxPais) {
		this.prodxPais = prodxPais;
	}

	public HashTable<Clase> getClases(){
		return clases;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
