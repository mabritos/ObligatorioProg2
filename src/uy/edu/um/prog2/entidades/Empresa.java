package uy.edu.um.prog2.entidades;

import uy.edu.um.prog2.adt.hash.ClosedHashTable;
import uy.edu.um.prog2.adt.hash.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.hash.HashCompletoException;
import uy.edu.um.prog2.adt.hash.HashTable;

public class Empresa {

	private	String nombre;
	private String ruc;
	private HashTable<Marca> marcas = new ClosedHashTable<>(211);
	
	public Empresa(String nombre, String ruc) {
		super();
		this.nombre = nombre;
		this.ruc = ruc;
	}
	public void agregarMarca(String clave, Marca marca) throws ElementoYaExistenteException, HashCompletoException  {
		marcas.insertar(clave, marca);
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
