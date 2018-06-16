package uy.edu.um.prog2.entidades;

public class Pais implements Comparable<Pais> {

	String nombre;
	int cantidadPHab = 0;
	int cantidadPTotal = 0;

	public Pais(String nombre) {
		this.nombre = nombre;
	}
	public void agregarPHab() {
		cantidadPHab++;
	}
	public void agregarProd() {
		cantidadPTotal++;
	}
	public int getPTot() {
		return cantidadPTotal;
	}
	public int getPHab() {
		return cantidadPHab;
	}
	public void resetPHab() {
		cantidadPHab = 0;
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
