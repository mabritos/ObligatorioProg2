package uy.edu.um.prog2.entidades;

import uy.edu.um.prog2.adt.hash.ClosedHashTable;
import uy.edu.um.prog2.adt.hash.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.hash.HashCompletoException;
import uy.edu.um.prog2.adt.hash.HashTable;

public class Marca {

	private String nombre;
	private HashTable<Clase> clases = new ClosedHashTable<Clase>(211);
	
	public Marca(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarClase(String clave, Clase clase) throws ElementoYaExistenteException, HashCompletoException {
		clases.insertar(clave, clase);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
