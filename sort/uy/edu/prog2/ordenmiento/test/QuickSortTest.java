package uy.edu.prog2.ordenmiento.test;

import static org.junit.Assert.*;

import org.junit.Test;

import uy.edu.prog2.ordenamiento.AlgoritmosOrdenamiento;
import uy.edu.prog2.ordenamiento.BubbleSort;
import uy.edu.prog2.ordenamiento.QuickSort;

public class QuickSortTest {

	@Test
	public void test1() {
		AlgoritmosOrdenamiento<Integer> oQuick = new QuickSort<>();
		Integer[] array = {0,3,2,4,1};
		Integer[] ordered = {0,1,2,3,4};
		Integer[] array1 = oQuick.order(array);
		for(int x=0; x<array.length;x++) {
			assertEquals(array1[x],ordered[x]);
		}
	}
	
	@Test
	public void test2() {
		AlgoritmosOrdenamiento<Integer> oQuick = new QuickSort<>();
		Integer[] array = {0,3,2,4,1,2000,405050,23,66,-1,-7,98,10};
		Integer[] ordered = {-7,-1,0,1,2,3,4,10,23,66,98,2000,405050};
		Integer[] array1 = oQuick.order(array);
		for(int x=0; x<array.length;x++) {
			assertEquals(array1[x],ordered[x]);
		}
	}

}
