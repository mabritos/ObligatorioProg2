package uy.edu.um.prog2.adt.heap;

public interface MyHeap<K extends Comparable<K>, T> {

	public void add(K key, T value);
	public T remove();
	public int heapSize();
	public void printHeap();
}
