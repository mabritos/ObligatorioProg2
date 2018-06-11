package uy.edu.um.prog2.adt.queue;
public class MyQueueImp<T> implements MyQueue<T> {

	private Node<T> head;
	private Node<T> tail;

	public MyQueueImp() {
		
	}
	                    
	public void enqueue(T element) {
		Node<T> n1 = new Node<T>(element);
		Node<T> scope = new Node<T>();
		if(isEmpty()==true) {
			head = n1;
		}
		else {
			scope = head;
			while(scope.getNext() != null) {
				scope = scope.getNext(); 
			}
			scope.setNext(n1);
			tail = n1; 
		}
	}

	
	public T dequeue() throws EmptyQueueException {
		Node<T> scope = head;
		T value = null;
		if(isEmpty()==false) {
			head = head.getNext();
			value = (T) scope.getValue();
		}
		else
			throw new EmptyQueueException("Queue Vacio");
		return value;
	}

	
	public boolean isEmpty() {
		boolean empty;
		if(head == null)
			empty = true;
		else 
			empty = false;
		return empty;
	}

	
	public T getFirst() throws EmptyQueueException {
		T value = null;
		if(isEmpty() == false)
			value = head.getValue();
		else 
			throw new EmptyQueueException("Queue Vacio");
		return value;
	}
	public int size() {
		return head.getsize(1);
	}
	

}
