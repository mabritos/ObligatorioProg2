package uy.edu.um.prog2.adt.heap;

public class MyHeapImp<K extends Comparable <K>, T> implements MyHeap<K,T> {

	HeapNode<K,T>[] list;
	
	int lastPos = 0;
	boolean max;
	
	public MyHeapImp(int cap, boolean max) {
		this.list = new HeapNode[cap];
		this.max = max;
	}
	@Override
	public void add(K key, T value) {
		HeapNode<K, T> n0 = new HeapNode<K, T>(key, value);
		
		boolean freespace = false;
		for(int x = 0; x<list.length;x++) {
			if (list[x] == null)
				freespace = true;
			}
		if (freespace==false) {
			HeapNode<K,T>[] list1 = new HeapNode[(list.length)*2];
			for(int x=0; x<list.length;x++) {
				list1[x] = list[x];
			}
			list = list1;
			list[lastPos] = n0;
		}
		else {
			list[lastPos] = n0;
		}
		list = order(list,lastPos);
		lastPos++;
		
			
	}
	public HeapNode[] order(HeapNode[] list, int pos) {
		HeapNode<K,T> hijo = list[pos];
		HeapNode<K,T> padre= list[(pos-1)/2];
		if(max == true) {
			if(hijo.getKey().compareTo(padre.getKey()) == 1) {
				list[pos] = padre;
				list[(pos-1)/2] = hijo;
				list = order(list, (pos-1)/2);
			}
		}
		else {
			if(hijo.getKey().compareTo(padre.getKey()) == -1) {
				list[pos] = padre;
				list[(pos-1)/2] = hijo;
				list = order(list, (pos-1)/2);
			}
		}
		return list;
	}
	
	public HeapNode[] orderDelete(HeapNode[] list, int pos) {
		if((2*pos+2 < list.length)) {
		HeapNode<K,T> hijo1= list[2*pos+1];
		HeapNode<K,T> hijo2= list[2*pos+2];
		HeapNode<K,T> padre= list[pos];
		if(max == true) {
			if(hijo1!=null && hijo2!=null){
			    if(padre.getKey().compareTo(hijo1.getKey())<0 && padre.getKey().compareTo(hijo2.getKey())>0){
			     		list[2*pos+1] = padre;
						list[pos] = hijo1;
						list = orderDelete(list, 2*pos+1);
			     }
			    
			    else if(padre.getKey().compareTo(hijo1.getKey())==-1 && padre.getKey().compareTo(hijo2.getKey())==-1) {
			    	if(hijo1.getKey().compareTo(hijo2.getKey())==-1) {
			    		list[2*pos+2]=padre;
			    		list[pos] = hijo2;
			    		list = orderDelete(list, 2*pos+2);
			    	}
			    	else {
			    		list[2*pos+1]=padre;
			    		list[pos] = hijo1;
			    		list = orderDelete(list, 2*pos+1);
			    	}
			    }
			    
			     else if(padre.getKey().compareTo(hijo2.getKey())==-1){
			     		list[2*pos+2] = padre;
						list[pos] = hijo2;
						list = orderDelete(list, 2*pos+1);
			     }	
			  }else if(hijo2==null && hijo1!=null){
			  		if(padre.getKey().compareTo(hijo1.getKey())==-1){
			     		list[2*pos+1] = padre;
						list[pos] = hijo1;
			     }
			  }
		}
		else {
			if(hijo1!=null && hijo2!=null){
				    if(padre.getKey().compareTo(hijo1.getKey())>0 && padre.getKey().compareTo(hijo2.getKey())<0){
				     		list[2*pos+1] = padre;
							list[pos] = hijo1;
							list = orderDelete(list, 2*pos+1);
				     }
				   
				    else if(padre.getKey().compareTo(hijo1.getKey())==1 && padre.getKey().compareTo(hijo2.getKey())==1) {
				    	if(hijo1.getKey().compareTo(hijo2.getKey())==1) {
				    		list[2*pos+2]=padre;
				    		list[pos] = hijo2;
				    		list = orderDelete(list, 2*pos+2);
				    	}
				    	else {
				    		list[2*pos+1]=padre;
				    		list[pos] = hijo1;
				    		list = orderDelete(list, 2*pos+1);
				    	}
				    }
				    
				     else if(padre.getKey().compareTo(hijo2.getKey())==1){
				     		list[2*pos+2] = padre;
							list[pos] = hijo2;
							list = orderDelete(list, 2*pos+1);
				     }	
				  }else if(hijo2==null && hijo1!=null){
				  		if(padre.getKey().compareTo(hijo1.getKey())==1){
				     		list[2*pos+1] = padre;
							list[pos] = hijo1;
				     }
				  }
		}
		}
		return list;
	}
	

	@Override
	public T remove() {
		int n = lastPos -1;
		HeapNode<K,T> n0 = list[n];
		HeapNode<K,T> raizz = list[0];
		list[n] = null;
		list[0] = n0;
		list = orderDelete(list, 0);
		lastPos--;
		return raizz.getValue();
	}
	
	public int heapSize() {
		
		return lastPos;
	}
	
	public void printHeap() {
		for(int x = 0; x < lastPos;x++) {
			System.out.println(list[x].getValue());
		}
	}

}
