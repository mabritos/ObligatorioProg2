package uy.edu.um.prog2.adt.stack.test;

import static org.junit.Assert.*;

import org.junit.Test;

import uy.edu.um.prog2.adt.stack.*;

public class stacktest {

	@Test
	public void test() {
		Node n0 = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		MyStackImp s1 = new MyStackImp();
		
		s1.push(n0);
		s1.push(n1);
		s1.push(n2);
		s1.push(n3);
		try {
			System.out.println(s1.top());
			s1.pop();
			System.out.println(s1.top());
		} catch (EmptyStackEception e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
}


