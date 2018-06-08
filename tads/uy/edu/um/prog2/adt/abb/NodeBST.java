package uy.edu.um.prog2.adt.abb;

import uy.edu.um.prog2.adt.queue.*;

public class NodeBST <K extends Comparable<K>, T> {
	K key;
	T data;
	NodeBST <K, T> leftChild;
	NodeBST <K, T> rightChild;
	
	public NodeBST(K key, T data) {
		this.key = key;
		this.data = data;
	}
	
	public K getKey() {
		return key;
	}
	
	
	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}


	public NodeBST<K, T> getLeftChild() {
		return leftChild;
	}


	public void setLeftChild(NodeBST<K, T> leftChild) {
		this.leftChild = leftChild;
	}


	public NodeBST<K, T> getRightChild() {
		return rightChild;
	}


	public void setRightChild(NodeBST<K, T> rightChild) {
		this.rightChild = rightChild;
	}


	public void setKey(K key) {
		this.key = key;
	}


	public NodeBST<K, T> findNode(K key) {
		NodeBST n0 = null;
		if(key.compareTo(this.key)==1 && getRightChild()!=null) {
			n0=getRightChild().findNode(key);
		} 
			
		if(key.compareTo(this.key)==-1 && getLeftChild()!=null) {
			n0=getLeftChild().findNode(key);
		}	
		if(key.compareTo(this.key)==0)
			n0 = this;
		return n0;
	}
	
	public void insertNode(Comparable<K> key, T data) {
		NodeBST<K, T> n0= new NodeBST(key, data);
		if(key.compareTo(this.key)==-1) {
			if(getLeftChild()!=null)
				getLeftChild().insertNode(key, data);
			else 
				setLeftChild(n0);
		}
		if(key.compareTo(this.key)==1) {
			if(getRightChild()!=null)
				getRightChild().insertNode(key, data);
			else 
				setRightChild(n0);
		}
	}
	public NodeBST<K, T> findParent(K key){
		NodeBST<K, T> n0= null;
		if(key.compareTo(this.key)==1) {
			if(key.equals(getRightChild().getKey())) {
				n0 = this;
			}
			else 
			n0=getRightChild().findNode(key);
			}
		if(key.compareTo(this.key)==-1) {
			if(key.equals(getLeftChild().getKey()))
				n0=this;
			else
				n0=getLeftChild().findNode(key);
		}
		return n0;	
	}
	
	public NodeBST<K, T> findMin() {
		 NodeBST<K, T> oReturn = this;

		if (leftChild != null) {

			oReturn = leftChild.findMin();

		}

		return oReturn;
	}
	
	public NodeBST<K,T> deleteNode(K okey) {
			int nValue = ((Comparable<K>) okey).compareTo(key);

			if (nValue > 0) {

				if (rightChild != null) {

					rightChild = rightChild.deleteNode(okey);

				}

			} else if (nValue < 0) {

				if (leftChild != null) {

					leftChild = leftChild.deleteNode(okey);

				}
			} else if (leftChild != null && rightChild != null) {
				NodeBST<K, T> oTemp = rightChild.findMin();
				
				this.key = oTemp.getKey();
				this.data = oTemp.getData();

				rightChild = rightChild.deleteNode(oTemp.getKey());

			} else {

				if (leftChild != null) {

					return leftChild;

				} else {

					return rightChild;

				}

			}

			return this;
		}
	public MyQueue<K> inOrdenNode(MyQueue<K> list){
		if(getLeftChild()!=null) 
			getLeftChild().inOrdenNode(list);
		else
			list.enqueue(this.getKey());
		if(getRightChild()!=null) {
			list.enqueue(this.getKey());
			getRightChild().inOrdenNode(list);
		}
		return list;
	}
	
	public MyQueue<K> preOrdenNode(MyQueue<K> list){
		list.enqueue(this.getKey());
		if(getLeftChild()!=null)
			getLeftChild().preOrdenNode(list);
		if(getRightChild()!=null)
			getRightChild().preOrdenNode(list);
		return list;
	}
	
	public MyQueue<K> postOrdenNode(MyQueue<K> list){
		if(getLeftChild()!=null)
			getLeftChild().postOrdenNode(list);
		if(getRightChild()!=null)
			getRightChild().postOrdenNode(list);
		list.enqueue(this.getKey());
		return list;
	}

	}

