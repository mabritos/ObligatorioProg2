package uy.edu.um.prog2.adt.hash;

import java.util.Iterator;

public interface HashTable<K, T> {
	public void insertar(K clave, T valor) throws ElementoYaExistenteException;
	public boolean pertenece(K clave);
	public void borrar(K clave) throws ElementoNoExisteException;
	public Iterator<T> iterator();
	public T obtener(K clave);
	public int getCantElementos();
}
