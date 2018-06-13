package uy.edu.um.prog2.entidades;

import uy.edu.um.prog2.adt.abb.MyBinarySearchTree;
import uy.edu.um.prog2.adt.abb.MyBinaryTreeSearchImp;
import uy.edu.um.prog2.adt.hash.ClosedHashTable;
import uy.edu.um.prog2.adt.hash.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.hash.HashCompletoException;
import uy.edu.um.prog2.adt.hash.HashTable;

public class Pais implements Comparable<Pais> {

	HashTable<Marca> marcas;
	MyBinarySearchTree<Long,Empresa> empresas;
	String nombre;
	int cantidadPHab = 0;

	public Pais(String nombre) {
		empresas = new MyBinaryTreeSearchImp<Long, Empresa>();
		marcas = new ClosedHashTable<Marca>(211);
		this.nombre = nombre;
	}
	public void agregarPHab() {
		cantidadPHab++;
	}
	public int getPHab() {
		return cantidadPHab;
	}
	public void resetPHab() {
		cantidadPHab = 0;
	}
	public void agregarEmpresa(long key, Empresa e) {
		empresas.insert(key, e);
	}
	public MyBinarySearchTree<Long, Empresa> getEmpresas(){
		return empresas;
	}
	public void agregarMarca(String clave,Marca marca) throws ElementoYaExistenteException, HashCompletoException {
		marcas.insertar(clave, marca);
	}
	public HashTable<Marca> getMarcas(){
		return marcas;
	}
	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
    public int compareTo(Pais pais) {
      return Integer.compare(cantidadPHab, pais.cantidadPHab);
    }
	
}
