package uy.edu.um.prog2.adt.linkedlist.test;
import uy.edu.um.prog2.adt.linkedlist.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class linkedlisttest {

	@Test
	public void test() {
		Node nodo0 = new Node(0);
		Node nodo1 = new Node(1);
		Node nodo2 = new Node(2);
		Node nodo3 = new Node(3);
		Node nodo4 = new Node(4);
		Node nodo5 = new Node(5);
		MyLinkedList list1 = new MyLinkedList(nodo0); 
		System.out.println("Lista creada");
		list1.addElement(nodo1);
		list1.addElement(nodo2);
		list1.addElement(nodo3);
		list1.addElement(nodo4);
		list1.addElement(nodo5);
		System.out.println("Anadido");
		System.out.println(list1.getElement(2));
		list1.deleteElement(3);
		System.out.println(list1.getElement(0));
		System.out.println(list1.getElement(3));
		System.out.println(list1.getElement(4));
	}

}
