package uy.edu.um.prog2.adt.heap.test;

import static org.junit.Assert.*;

import org.junit.Test;

import uy.edu.um.prog2.adt.heap.*;

public class Heapstest {

	@Test
	public void testMax() {
		MyHeap<Integer, Integer> l1 = new MyHeapImp<Integer,Integer>(5,true); 
		l1.add(50, 50);
		l1.add(45, 45);
		l1.add(46, 46);
		l1.add(51, 51);
		l1.add(100, 100);
		l1.add(98, 98);
		l1.add(13, 13);
		l1.add(59, 59);
		int n1 = l1.remove();
		int n2 = l1.remove();
		int n3 = l1.remove();
		System.out.println(n1+" "+n2+" "+n3);
		System.out.println(l1.heapSize());
		l1.printHeap();
	}
	
	@Test
	public void testMin() {
		MyHeap<Integer, Integer> l2 = new MyHeapImp<Integer,Integer>(5,false); 
		l2.add(50, 50);
		l2.add(45, 45);
		l2.add(46, 46);
		l2.add(51, 51);
		l2.add(100, 100);
		l2.add(98, 98);
		l2.add(13, 13);
		l2.add(59, 59);
		int n1 = l2.remove();
		int n2 = l2.remove();
		int n3 = l2.remove();
		System.out.println(n1+" "+n2+" "+n3);
		System.out.println(l2.heapSize());
		l2.printHeap();
	}

}
