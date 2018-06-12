package uy.edu.prog2.ordenamiento;

public class BubbleSort <K extends Comparable<K>> implements AlgoritmosOrdenamiento<K> {
	@Override
	public K[] order(K[] array) {
		
		return orderBubble(array.length-1,array);
	}
	private K[] orderBubble(int n, K[] thisArray) {
		boolean cambio = false;
		for(int x = 0; x < n; x++) {
			K primero =thisArray[x]; 
			K segundo = thisArray[x+1];
			
			if(primero.compareTo(segundo)==1) {
				thisArray[x]=segundo;
				thisArray[x+1]=primero;
				cambio = true;
				
			}
		}if(n-1 > 0 && cambio != false)
			thisArray = orderBubble(n-1,thisArray);
		return thisArray;
	}

}
