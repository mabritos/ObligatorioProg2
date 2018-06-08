package uy.edu.um.prog2.adt.queue;

public class EmptyQueueException extends Exception {

	public EmptyQueueException() {
		super();
	}
	public EmptyQueueException(String error) {
		super(error);
	}
}
