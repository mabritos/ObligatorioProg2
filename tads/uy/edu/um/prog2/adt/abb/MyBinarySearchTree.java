package uy.edu.um.prog2.adt.abb;

import uy.edu.um.prog2.adt.queue.*;

public interface MyBinarySearchTree <K extends Comparable<K>, T>{
	T find(K key);
	void insert (K key, T data);
	void delete (K key);
	boolean isEmpty();
	MyQueue<K> inOrden();
	MyQueue<K> preOrden();
	MyQueue<K> postOrden();
}
