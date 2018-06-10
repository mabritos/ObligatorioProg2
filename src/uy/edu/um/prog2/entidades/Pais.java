package uy.edu.um.prog2.entidades;

import uy.edu.um.prog2.adt.abb.MyBinarySearchTree;
import uy.edu.um.prog2.adt.abb.MyBinaryTreeSearchImp;
import uy.edu.um.prog2.adt.hash.ClosedHashTable;
import uy.edu.um.prog2.adt.hash.HashTable;

public class Pais {

	MyBinarySearchTree<Long,Empresa> empresas;
	String nombre;

	public Pais(String nombre) {
		empresas = new MyBinaryTreeSearchImp<Long, Empresa>();
		this.nombre = nombre;
	}
	public void agregarEmpresa(long key, Empresa e) {
		empresas.insert(key, e);
	}

	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
