package uy.edu.um.prog2.adt.abb;

import uy.edu.um.prog2.adt.queue.*;

public class MyBinaryTreeSearchImp<K extends Comparable<K>, T> implements MyBinarySearchTree {
	private NodeBST raiz;
	
	public MyBinaryTreeSearchImp(Comparable key, T data) {
		raiz = new NodeBST(key, data);
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
		raiz.insertNode(key, data);
	}

	@Override
	public void delete(Comparable key) {
		raiz.deleteNode(key);
	}
	public MyQueue<K> inOrden(){
		MyQueue<K> list= new MyQueueImp<K>();
		return raiz.inOrdenNode(list);	
	}
	
	@Override
	public MyQueue<K> preOrden() {
		MyQueue<K> list = new MyQueueImp<K>();
		return raiz.preOrdenNode(list);
	}
	@Override
	public MyQueue<K> postOrden() {
		MyQueue<K> list = new MyQueueImp<K>();
		return raiz.postOrdenNode(list);
	}

}
