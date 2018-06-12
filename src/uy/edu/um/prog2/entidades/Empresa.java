package uy.edu.um.prog2.entidades;

import uy.edu.um.prog2.adt.hash.ClosedHashTable;
import uy.edu.um.prog2.adt.hash.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.hash.HashCompletoException;
import uy.edu.um.prog2.adt.hash.HashTable;

public class Empresa implements Comparable<Empresa> {

	private	String nombre;
	private String ruc;
	private int cantPHab=0;
	private HashTable<Marca> marcas = new ClosedHashTable<>(211);
	private HashTable<Producto> productos = new ClosedHashTable<Producto>(211);
	
	public Empresa(String nombre, String ruc) {
		super();
		this.nombre = nombre;
		this.ruc = ruc;
	}
	public void agregarMarca(String clave, Marca marca) throws ElementoYaExistenteException, HashCompletoException  {
		marcas.insertar(clave, marca);
	}
	public int getCantPHab() {
		return cantPHab;
	}
	public void setCantPHab(int cantPHab) {
		this.cantPHab = cantPHab;
	}
	public HashTable<Producto> getProductos() {
		return productos;
	}
	public void setProductos(String clave, Producto producto) throws ElementoYaExistenteException, HashCompletoException {
		productos.insertar(clave, producto);
	}
	public HashTable getMarcas() {
		return marcas;
	}
	public void agregarProductoHab() {
		cantPHab++;
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
	@Override
    public int compareTo(Empresa empresa) {
      return Integer.compare(cantPHab, empresa.cantPHab);
    }
	
	
}
