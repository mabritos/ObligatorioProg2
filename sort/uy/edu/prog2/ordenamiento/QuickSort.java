package uy.edu.prog2.ordenamiento;

public class QuickSort<K extends Comparable<K>> implements AlgoritmosOrdenamiento<K> {

	@Override
	public K[] order(K[] array) {
	
		return orderQuick(array,0,array.length-1);
	}
	private K[] orderQuick(K[] array, int start, int finish) {
		if(finish>0) {
		K pivot = array[finish];
		int i = start-1;
		for(int x = start; x < finish; x++) {
			if(pivot.compareTo(array[x])==1) {
				i++;
				K jota = array[x];
				K ilatina = array[i];
				array[i] = jota;
				array[x] = ilatina;
			}
		}
		for(int x = finish;x>i+1;x--) {
			K primero = array[x-1]; 
			K segundo = array[x];
			array[x-1] = segundo;
			array[x] = primero;
		}
		
		if(start<i) {
			array = orderQuick(array,start,i);
		}
		if(i+1<finish) {
			array = orderQuick(array,i+1,finish);
			
		}
		}
		return array;
	}


}
