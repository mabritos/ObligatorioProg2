package uy.edu.um.prog2.adt.abb.test;

import static org.junit.Assert.*;

import org.junit.Test;

import uy.edu.um.prog2.adt.abb.*;

public class BinarySearchTreeTest {
MyBinarySearchTree<Integer, Integer> t1;
	@Test
	public void test() {
		t1= new MyBinaryTreeSearchImp<Integer, Integer>(50, 50);
		t1.insert(70, 70);
		t1.insert(30, 30);
		t1.insert(25, 25);
		t1.insert(35, 35);
		t1.insert(32,32);
		t1.insert(40, 40);
		t1.delete(30);
		assertEquals(null, t1.find(30));
		
	}

}
