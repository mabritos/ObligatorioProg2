package uy.edu.um.prog2.entidades;

public class Empresa implements Comparable<Empresa> {

	private	String nombre;
	private String ruc;
	private int cantPHab=0;
	
	public Empresa(String nombre, String ruc) {
		this.nombre = nombre;
		this.ruc = ruc;
	}
	public int getCantPHab() {
		return cantPHab;
	}
	public void setCantPHab(int cantPHab) {
		this.cantPHab = cantPHab;
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
