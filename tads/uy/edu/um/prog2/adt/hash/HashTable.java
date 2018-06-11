package uy.edu.um.prog2.adt.hash;

import java.util.Iterator;

public interface HashTable<T> {
	
	public void insertar (String clave, T valor) throws ElementoYaExistenteException, HashCompletoException;
	public boolean pertenece (String clave);
	public void borrar (String clave) throws ElementoNoExisteException;
	public T get(String clave);
	Iterator<T> iterator();
	
}
