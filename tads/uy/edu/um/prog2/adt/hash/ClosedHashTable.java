package uy.edu.um.prog2.adt.hash;

public class ClosedHashTable<T> implements HashTable<T> {

	private Node<T>[] hash;
	
	public ClosedHashTable(int elementos) {
		hash = new Node[elementos];
	}
	@Override
	public void insertar(String clave, T valor) throws ElementoYaExistenteException, HashCompletoException {
		Node<T> node = new Node<T>(clave, valor);
		int pos = fHash(clave);
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
					else
						throw new HashCompletoException("Hash Completo");
				}
			}
			else
				hash[pos] = node;
	}

	@Override
	public boolean pertenece(String clave) {
		boolean belongs = false;
		int pos = fHash(clave);
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
			int pos = fHash(clave);
			int newPos =  fHashCollisions(clave,pos)+pos;
			hash[newPos] = null;
			
		}
		else 
			throw new ElementoNoExisteException("Elemento no existe en el hash");
		
	}
	
	public int fHash(String clave) {
		int suma = 0;
		int cantidadValores = clave.length();
		
		for(int x = 0; x<clave.length();x++) {
			suma = suma +clave.codePointAt(x);
		}
		
		int avg = suma/cantidadValores;
		
		return avg%hash.length;
	}
	
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
		
		return i;
	}

}
