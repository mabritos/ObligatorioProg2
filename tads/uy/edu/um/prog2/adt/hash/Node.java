package uy.edu.um.prog2.adt.hash;

public class Node<K, T> {
	
	private K clave;
	private T valor;
	private boolean eliminado;

	public Node(K clave, T valor) {
		super();
		this.clave = clave;
		this.valor = valor;
		eliminado=false;
	}

	public K getClave() {
		return clave;
	}

	public void setClave(K clave) {
		this.clave = clave;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}

}