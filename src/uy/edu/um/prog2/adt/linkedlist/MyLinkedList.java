package uy.edu.um.prog2.adt.linkedlist;

public class MyLinkedList<T> implements LinkedList<T>{

	private Node<T> head;
	
	public MyLinkedList(Node<T> head) {
		
		this.head = head;
	}
	
	public void addElement(Node<T> oElement) {
	
		if(head == null) {
			head = oElement;
		}else{
			Node<T> scope = head;
			Node<T> target = head;
			int savePrev = 0;
			while (scope.getNext() != null) {
				
				scope = scope.getNext();
				savePrev++;
			}
			scope.setNext(oElement);
			for(int i=0; i<savePrev-1; i++) {
				
				target = target.getNext();
			}
			scope.setPrevious(target);
		}
	}

	
	public boolean checkEmpty() {

		boolean revision;
		if(head == null) {
			revision = true;
		}else {
			revision = false;
		}
		return revision;
	}

	
	public T getElement(int nPosition) {

		T searched = null;
		if(checkEmpty() == false) {
			
			Node<T> scope = head;
			for(int x=0; x < nPosition; x++) {
				
				scope= scope.getNext();
			}
			searched = (T) scope.getValue();
		}
		return searched;
	}

	
	public void deleteElement(int nPosition) {
		
		Node<T> scope = head;
		Node<T> newNext;
		Node<T> newPrev;
		
		if(nPosition == 0) {
			
			head = head.getNext();
		}else {
			
			for(int x=0; x < nPosition; x++) {
				
				scope = scope.getNext();
			}
			newNext = scope.getNext();
			newPrev = scope.getPrevious();
			newNext.setPrevious(newPrev);
			newPrev.setNext(newNext);
			scope.setNext(null);
			scope.setPrevious(null);
		}
		
	}

}
