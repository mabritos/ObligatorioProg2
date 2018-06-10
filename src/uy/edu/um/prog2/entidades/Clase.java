package uy.edu.um.prog2.entidades;

import uy.edu.um.prog2.adt.hash.ClosedHashTable;
import uy.edu.um.prog2.adt.hash.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.hash.HashCompletoException;
import uy.edu.um.prog2.adt.hash.HashTable;

public class Clase {

	private String nombre;
	private HashTable<Producto> productos = new ClosedHashTable<Producto>(211);

	public Clase(String nombre) {
		super();
		this.nombre = nombre;
	}
	public void agregarProducto(String clave, Producto producto) throws ElementoYaExistenteException, HashCompletoException {
		productos.insertar(clave, producto);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
