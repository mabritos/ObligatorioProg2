package uy.edu.um.prog2.adt.hash;

import java.util.Iterator;

public class ClosedHashTable<T> implements HashTable<T> {

	private Node<T>[] hash;
	private int cantElementos;
	
	public ClosedHashTable(int elementos) {
		hash = new Node[elementos];
	}
	public ClosedHashTable() {
		hash = new Node[10];
	}
	@Override
	public void insertar(String clave, T valor) throws ElementoYaExistenteException, HashCompletoException {
		Node<T> node = new Node<T>(clave, valor);
		cantElementos++;
		int pos = Math.abs(clave.hashCode() % hash.length);
			/*if(pertenece(clave)==true)
				throw new ElementoYaExistenteException("Elemento ya existente en el Hash");
			
			else */if(hash[pos]!=null) {
				int x = 0;
				while(x+pos<hash.length-1 && hash[x+pos]!=null) {
					x++;
				}
				if(hash[x+pos]==null)
					hash[x+pos] = node;
				else {
					int i = 0;
					while(i+pos>0 && hash[i+pos]!=null) {
						i--;
					}
					if(hash[i+pos]==null)
						hash[i+pos] = node;
					else {
						//arraycopy(Object src, int srcPos,
	                            // Object dest, int destPos, int length)
						int e = 0;
						Node<T>[] hash1 = new Node[hash.length+hash.length/2];
						for(int n = 0; n<hash.length;n++) {
							hash1[n] = hash[n];
							e = n;
						}
						hash = hash1;
						hash[e]=node;
					}
				}
			}
			else
				hash[pos] = node;
	}

	@Override
	public boolean pertenece(String clave) {
		boolean belongs = false;
		int pos = Math.abs(clave.hashCode() % hash.length);;
		if(hash[pos]!=null) {
			if(hash[pos].getKey().equals(clave))
				belongs = true;
			}
		if(belongs == false) {
			for(int x = 0; x<hash.length && belongs==false; x++) {
				if (hash[x]!=null) {
					if(hash[x].getKey().equals(clave))
						belongs = true;
				}
			}
		}	
		return belongs;
	}

	@Override
	public void borrar(String clave) throws ElementoNoExisteException {
		if(pertenece(clave) == true) {
			int pos = Math.abs(clave.hashCode() % hash.length);;
			int newPos =  fHashCollisions(clave,pos)+pos;
			hash[newPos] = null;
			
		}
		else 
			throw new ElementoNoExisteException("Elemento no existe en el hash");
		
	}
	
	/*public int fHash(String clave) {
		int suma = 0;
		int cantidadValores = clave.length();
		
		for(int x = 0; x<clave.length();x++) {
			suma = suma +clave.codePointAt(x);
		}
		
		int avg = suma/cantidadValores;
		
		return avg%hash.length;
	}*/
	
	public int fHashCollisions(String clave, int pos) {
		int i = 0;
		boolean ret = false;
		if(hash[pos]!=null) {
			if(hash[pos].getKey().equals(clave)) {
				ret = true;
			}
		}
		if(ret == false) {
			for(int x =0;x+pos<hash.length && ret == false;x++) {
				if(hash[x+pos]!=null) {
					if(hash[x+pos].getKey().equals(clave))
						ret = true;
				}
				i = x;
			}
			
			if(ret == false) {
				for(int x=0;x+pos>-1 && ret == false; x--) {
					if(hash[x+pos]!=null) {
						if(hash[x+pos].getKey().equals(clave))
							ret = true;
					}
					i = x;
				}
			}
		}
			
		
		return i;
	}
	/*public T get(String clave){
		int pos = fHash(clave);
		return hash[fHashCollisions(clave, pos)].getValue();
		
	}*/
	public T get(String clave) {
		if(pertenece(clave) == true) {
			int pos = Math.abs(clave.hashCode() % hash.length);;
			int newPos =  fHashCollisions(clave,pos)+pos;
			return hash[newPos].getValue();
			
		}
		else 
			return null;
		
	}
	@Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

        private int currentIndex = 0;
        private int itemCount = 1;

        @Override
        public boolean hasNext() {
            return itemCount < cantElementos;
            }

        @Override
        public T next() {
        	while(hash[currentIndex]==null) {
        		currentIndex++;
        	} 
        	itemCount++;
            T esto = hash[currentIndex].getValue();
        	
        	
            
			return esto;
        }
        };

        return it;
    }

}
