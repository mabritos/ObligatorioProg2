package uy.edu.um.prog2.adt.abb;

import uy.edu.um.prog2.adt.queue.*;

public class MyBinaryTreeSearchImp<K extends Comparable<K>, T> implements MyBinarySearchTree {
	private NodeBST raiz;
	
	public MyBinaryTreeSearchImp(Comparable key, T data) {
		raiz = new NodeBST(key, data);
	}
	public MyBinaryTreeSearchImp() {
		
	} 
	public boolean isEmpty() {
		if (raiz == null)
			return true;
		else
			return false;
	}
	@Override
	public T find(Comparable key) {
		if(raiz.findNode(key)!=null)
			return (T) raiz.findNode(key).getData();
		else 
			return null;
	}

	@Override
	public void insert(Comparable key, Object data) {
		if(raiz == null)
			raiz = new NodeBST(key, data);
		else
			raiz.insertNode(key, data);
	}
	public NodeBST getRaiz() {
		return raiz;
	}

	@Override
	public void delete(Comparable key) {
		raiz.deleteNode(key);
	}
	public MyQueue<T> inOrden(){
		MyQueue<T> list= new MyQueueImp<T>();
		return raiz.inOrdenNode(list);	
	}
	
	@Override
	public MyQueue<T> preOrden() {
		MyQueue<T> list = new MyQueueImp<T>();
		return raiz.preOrdenNode(list);
	}
	@Override
	public MyQueue<K> postOrden() {
		MyQueue<K> list = new MyQueueImp<K>();
		return raiz.postOrdenNode(list);
	}

}
