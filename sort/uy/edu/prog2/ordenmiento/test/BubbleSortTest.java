package uy.edu.prog2.ordenmiento.test;

import static org.junit.Assert.*;

import org.junit.Test;

import uy.edu.prog2.ordenamiento.AlgoritmosOrdenamiento;
import uy.edu.prog2.ordenamiento.BubbleSort;

public class BubbleSortTest {

	@Test
	public void test() {
		Integer[] array = {0,3,2,4,1};
		Integer[] ordered = {0,1,2,3,4};
		AlgoritmosOrdenamiento<Integer> oBubble = new BubbleSort<Integer>();
		Integer[] array1 = oBubble.order(array);
		for(int x=0; x<array.length;x++) {
			assertEquals(array1[x],ordered[x]);
		}
	}

}
