package uy.edu.um.prog2.adt.queue.test;
import uy.edu.um.prog2.adt.queue.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class testQueue {

	@Test
	public void test() {
		MyQueueImp<Integer> q0 = new MyQueueImp<Integer>();
		q0.enqueue(0); 
		q0.enqueue(1);
		q0.enqueue(2);
		try{
			System.out.println(q0.dequeue());
			System.out.println(q0.getFirst());
			System.out.println(q0.dequeue());
			System.out.println(q0.getFirst());
			System.out.println(q0.dequeue());
			System.out.println(q0.getFirst());
			System.out.println(q0.dequeue());
		}
		catch(EmptyQueueException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void testEmpty(){
		MyQueueImp<String> q0 = new MyQueueImp<String>();
		System.out.println(q0.isEmpty());
	}

}
