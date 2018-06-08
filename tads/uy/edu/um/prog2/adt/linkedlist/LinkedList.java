package uy.edu.um.prog2.adt.linkedlist;

public interface LinkedList<T> {
	
	public void addElement(Node<T> oElement);
	public boolean checkEmpty();
	public T getElement(int nPosition);
	public void deleteElement(int nPosition);

}
