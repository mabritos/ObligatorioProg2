package uy.edu.um.prog2.adt.hash;

import java.util.Iterator;

public class ClosedHashTable<K, T> implements HashTable<K, T>, Iterable<T> {
	private Node<K, T>[] hash;
	private int size;
	private int cantElementos;

	public ClosedHashTable(int sizeInicial) {
		hash = new Node[sizeInicial];
		size = sizeInicial;
		cantElementos = 0;
	}

	public void insertar(K key, T value) {
		Node<K, T> newNode = new Node<K, T>(key, value);
		
		if (cantElementos == size) {
			agrandarHash();
		}
		
		int posicion = Math.abs(key.hashCode()) % size;
		
		if (hash[posicion] == null || hash[posicion].isEliminado())
			hash[posicion] = newNode;
		else {
			
			int posAux 		= posicion;
			int cuadratica	= 1;
			
			while (hash[posAux] != null && !hash[posAux].isEliminado()) {
				
				posAux++;
				if (posAux >= size) {
					posAux = 0;
				}
			}
			hash[posAux] = newNode;
		}
		cantElementos++;
	}

	public boolean pertenece(K clave) {
		boolean pertenece 	= false;
		int 	posEsperada = Math.abs(clave.hashCode()) % size;
		
		
		if (hash[posEsperada]	!= null) {
			
			if (hash[posEsperada].getClave().equals(clave) && hash[posEsperada].isEliminado() == false) {
				pertenece = true;
			} else {
				posEsperada++;
				int cantRecorridas=0;
				while (cantRecorridas<size && (hash[posEsperada] != null && !hash[posEsperada].getClave().equals(clave))) {
					posEsperada++;
					if(posEsperada>=size) {
						posEsperada=0;
					}
					cantRecorridas++;
				}
				if (posEsperada < hash.length && hash[posEsperada]!=null) {
					if (hash[posEsperada].getClave().equals(clave) && hash[posEsperada].isEliminado() == false) {
						pertenece = true;
					}
				}
			}	
		}
		return pertenece;
	}

	public void borrar(K clave) throws ElementoNoExisteException {
		if (pertenece(clave)) {
			get(clave).setEliminado(true);
			cantElementos--;
		} else {
			throw new ElementoNoExisteException();
		}
	}

	private void agrandarHash() {
		int nuevoSize = 2 * size;
		Node<K, T>[] vectorNuevo = new Node[nuevoSize];
		for (int i = 0; i < size; i++) {
			K claveAux = hash[i].getClave();
			T valorAux = hash[i].getValor();

			int posicion = Math.abs(claveAux.hashCode() % nuevoSize);
			if (vectorNuevo[posicion] == null) {
				vectorNuevo[posicion] = hash[i];
			} else {
				int posAux = posicion;
				int cuadratica=1;
				while (hash[posAux] != null && hash[posAux].isEliminado()) {
						
					posAux++;
					if (posAux >= size) {
						posAux = 0;
					}
				}
				vectorNuevo[posAux] = hash[i];
			}
		}
		size = nuevoSize;
		hash = vectorNuevo;
	}

	private Node<K, T> get(K clave) {
		Node<K, T> nodo = null;
		int posEsperada = Math.abs(clave.hashCode()) % size;
		if (hash[posEsperada].getClave().equals(clave) && hash[posEsperada].isEliminado() == false) {
			nodo = hash[posEsperada];
		} else {
			posEsperada++;
			while (posEsperada < hash.length && (hash[posEsperada] != null && !hash[posEsperada].getClave().equals(clave))) {
				posEsperada++;
			}
			if (hash[posEsperada].getClave().equals(clave) && hash[posEsperada].isEliminado() == false) {
				nodo = hash[posEsperada];
			}
		}
		return nodo;
	}
	
	public T obtener(K clave) {
		Node<K, T> nodo = null;
		int posEsperada = Math.abs(clave.hashCode()) % size;
		if (hash[posEsperada].getClave().equals(clave) && hash[posEsperada].isEliminado() == false) {
			nodo = hash[posEsperada];
		} else {
			posEsperada++;
			while (posEsperada < hash.length && (hash[posEsperada] != null && !hash[posEsperada].getClave().equals(clave))) {
				posEsperada++;
			}
			if (hash[posEsperada].getClave().equals(clave) && hash[posEsperada].isEliminado() == false) {
				nodo = hash[posEsperada];
			}
		}
		return nodo.getValor();
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> it = new Iterator<T>() {

        private int	currentIndex 	= 0;
        private	int itemCount		= 1;	

        @Override
        public boolean hasNext() {
        	return itemCount <= cantElementos;
            }

        @Override
        public T next() {
            
            while (hash[currentIndex] == null) 
            	currentIndex++;
            
            T temp = hash[currentIndex].getValor();
            itemCount++;
            currentIndex++;
            return temp;
            }
        
		};
		
		return it;
	}

	public int getCantElementos() {
		return cantElementos;
	}

}