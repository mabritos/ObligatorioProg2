package uy.edu.um.prog2.adt.queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class queuetest {

	@Test
	public void test() {
		MyQueue<Integer> q1 = new MyQueueImp<Integer>();
		q1.enqueue(0);
		q1.enqueue(1);
		q1.enqueue(2);
		assertSame(3,q1.size());
		try{
			q1.dequeue();
			assertSame(2,q1.size());
		}catch(Exception e) {
			
		}
		
	}

}
