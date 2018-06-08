package uy.edu.um.prog2.adt.stack;
public interface MyStack<T> { 
	 public void pop () throws EmptyStackEception; 
	 public T top() throws EmptyStackEception; 
	 public void push(Node element); 
	 public boolean isEmpty (); 
	 public void makeEmpty(); 
	 } 