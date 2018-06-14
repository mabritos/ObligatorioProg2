package uy.edu.um.prog2.entidades;

public class PaisClase implements Comparable<PaisClase>{
	
	private Pais pais;
	private Clase clase;
	private int prodHab = 0;
	
	public PaisClase() {
	}
	
	public void sumarProdHab() {
		prodHab++;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	public int getProdHab() {
		return prodHab;
	}
	public void setProdHab(int prodHab) {
		this.prodHab = prodHab;
	}

	@Override
	public int compareTo(PaisClase paisClase) {
		return Integer.compare(prodHab, paisClase.getProdHab());
	}

}
