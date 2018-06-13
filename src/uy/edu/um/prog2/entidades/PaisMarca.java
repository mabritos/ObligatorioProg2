package uy.edu.um.prog2.entidades;

public class PaisMarca implements Comparable<PaisMarca> {
	
	private Pais pais;
	private Marca marca;
	private int prodHab = 0;
	
	public PaisMarca(Pais pais, Marca marca, int prodHab) {
		
		this.pais = pais;
		this.marca = marca;
		this.prodHab = prodHab;
	}
	
	public PaisMarca() {
		
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public int getProdHab() {
		return prodHab;
	}

	public void setProdHab(int prodHab) {
		this.prodHab = prodHab;
	}
	
	@Override
    public int compareTo(PaisMarca paisMarca) {
      return Integer.compare(prodHab, paisMarca.getProdHab());
    }

}
