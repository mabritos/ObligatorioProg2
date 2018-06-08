package uy.edu.um.prog2.adt.stack;
public class MyStackImp<T> implements MyStack  {
	private Node head;
	
	public boolean isEmpty() {
		boolean empty;
		if (head == null)
			empty = true;
		else
			empty = false;
		return empty;
			
	}
	public void push(Node nodo) {
		Node scope = head;
		if(isEmpty() == true) 
			head = nodo;
		else {
			while(scope.getNext() !=null) {
				scope = scope.getNext();
			}
			scope.setNext(nodo);
		}
	}
	
	public void pop() throws EmptyStackEception {
		Node scope = head;
		Node scope1 = head;
		int x = 0;
		if(isEmpty() == false) {
			while(scope.getNext() != null) {
				x++;
				scope = scope.getNext();
			}
			if(x==0)
				head=null;
			else {
			for(int i = 0; i < x-1; i++) {
				scope1 = scope1.getNext();
			}
			scope1.setNext(null);
			}
		}
		else
			throw new EmptyStackEception("Stack Vacio");
		
	
	}
	
	public T top() throws EmptyStackEception {
		Node scope = head;
		if(isEmpty() == false) {
			while(scope.getNext() != null) {
				scope = scope.getNext();
			}
			return (T) scope.getValue();
		}
		else {
			throw new EmptyStackEception("Stack Vacio");
			
		}
		
	}
	
	public void makeEmpty() {
		head.setNext(null);
		head = null;
	}
	
	
}
