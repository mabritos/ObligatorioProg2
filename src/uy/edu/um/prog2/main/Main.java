package uy.edu.um.prog2.main;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.opencsv.CSVReader;

import uy.edu.prog2.ordenamiento.AlgoritmosOrdenamiento;
import uy.edu.prog2.ordenamiento.BubbleSort;
import uy.edu.prog2.ordenamiento.QuickSort;
import uy.edu.um.prog2.adt.abb.MyBinarySearchTree;
import uy.edu.um.prog2.adt.abb.MyBinaryTreeSearchImp;
import uy.edu.um.prog2.adt.hash.*;
import uy.edu.um.prog2.adt.queue.EmptyQueueException;
import uy.edu.um.prog2.adt.queue.MyQueue;
import uy.edu.um.prog2.adt.queue.MyQueueImp;
import uy.edu.um.prog2.entidades.*;

public class Main {
	
	private static final String ADDRESS_FILE = "v_producto_real_updated.csv";
	
	private static void reporte1(MyBinarySearchTree<Long, Empresa> empresas) throws EmptyQueueException {
		MyQueue<Empresa> newEmpresa = empresas.preOrden();
		int x = 0;
		Empresa[] arrayEmpresas = new Empresa[newEmpresa.size()];
		while(newEmpresa.isEmpty()==false) {
			Empresa empresa1 = newEmpresa.dequeue();
			Iterator<Producto> iterator1 = empresa1.getProductos().iterator();
			while(iterator1.hasNext()) {
				Producto producto1 = iterator1.next();
				if(producto1.getEstado().equals("HABILITADO"))
					empresa1.agregarProductoHab();
			}
			arrayEmpresas[x] = empresa1;
			x++;
		}
		AlgoritmosOrdenamiento<Empresa> o = new BubbleSort();
		arrayEmpresas =  o.order(arrayEmpresas);
		for(int i =arrayEmpresas.length-1; i>(arrayEmpresas.length-20);i--) {
			System.out.println(arrayEmpresas[i].getNombre() +" "+ arrayEmpresas[i].getCantPHab());
		}
		
		 
	 }
	
	private static void reporte2(HashTable<Pais> paises) {
		Iterator<Pais> iterator1 = paises.iterator();
		while(iterator1.hasNext()) {
			HashTable<Marca> marca1 =iterator1.next().getMarcas();
			Iterator<Marca> iterator2 = marca1.iterator();
			while(iterator2.hasNext()) {
				Marca marca2 = iterator2.next();
				HashTable<Producto> producto1 = marca2.getProductos();
				Iterator<Producto> iterator3 = producto1.iterator();
				while(iterator3.hasNext()) {
					Producto producto2 = iterator3.next();
					if(producto2.getEstado().equals("HABILITADO"))
						marca2.agregarProdxPais();
				}
			}
		}
		
	}


	 
	 public static void main(String[]args) throws IOException, ElementoYaExistenteException, HashCompletoException, EmptyQueueException {
		 double startTime = System.nanoTime();
		 CSVReader reader = new CSVReader(new FileReader(ADDRESS_FILE), ';');
		 String[] nextLine;
		 int capacidad = 0;
		 Rubro rubro;
		 Empresa empresa;
		 Producto producto;
		 Marca marca;
		 Clase clase;
		 Pais pais;
		 
		 
		 HashTable<Pais> paises = new ClosedHashTable<Pais>(211);
		 MyBinarySearchTree<Long, Empresa> empresas = new MyBinaryTreeSearchImp<Long, Empresa>();
		 HashTable<Marca> marcas = new ClosedHashTable<Marca>(5107);
		 HashTable<Clase> clases = new ClosedHashTable<Clase>(719);
		 HashTable<Producto> productos = new ClosedHashTable<Producto>(50363);
		
		 nextLine = reader.readNext();
		 while((nextLine = reader.readNext())!=null) {
			 
			// rubro = new Rubro(nextLine[3]);
			// marca = new Marca(nextLine[12]);
			// clase = new Clase(nextLine[8]);
			 
			 
			 producto = new Producto(nextLine[0],nextLine[1], nextLine[20], nextLine[2], nextLine[4]);
			 productos.insertar(nextLine[0]+nextLine[2]+nextLine[4], producto);
			 
			 if(!clases.pertenece(nextLine[10])) {
				 clase = new Clase(nextLine[10]);
				 clase.agregarProducto(nextLine[0]+nextLine[2]+nextLine[4], producto);
				 clases.insertar(nextLine[10], clase);
			 }
			 else
				 clases.get(nextLine[10]).agregarProducto(nextLine[0]+nextLine[2]+nextLine[4], producto);
			 
			 if(!marcas.pertenece(nextLine[12])) {
				 marca = new Marca(nextLine[12]);
				 marca.agregarClase(nextLine[10], clases.get(nextLine[10]));
				 marca.agregarProducto(nextLine[0]+nextLine[2]+nextLine[4], producto);
				 marcas.insertar(nextLine[12], marca);
			 }else {
				 marcas.get(nextLine[12]).agregarClase(nextLine[10], clases.get(nextLine[10]));
				 marcas.get(nextLine[12]).agregarProducto(nextLine[0]+nextLine[2]+nextLine[4], producto);
			 }
			 
			 if(empresas.isEmpty()==false) {
				 if(empresas.find(Long.valueOf(nextLine[23]))==null) {
					 empresa = new Empresa(nextLine[5], nextLine[23]);
					 empresa.setProductos(nextLine[0]+nextLine[2]+nextLine[4], producto);
					 empresa.agregarMarca(nextLine[12], marcas.get(nextLine[12]));
					 empresas.insert(Long.valueOf(nextLine[23]), empresa);
					// System.out.println(nextLine[5]);contador++;
				 }
			 }
			 else {
				 empresa = new Empresa(nextLine[5], nextLine[23]);
				 empresa.agregarMarca(nextLine[12], marcas.get(nextLine[12]));
				 empresas.insert(Long.valueOf(nextLine[23]), empresa);
				// System.out.println(nextLine[5]);contador++;
			 }
			 empresas.find(Long.valueOf(nextLine[23])).setProductos(nextLine[0]+nextLine[2]+nextLine[4], producto);
			
			 marca = marcas.get(nextLine[12]);
			 if(!paises.pertenece(nextLine[13])) {
				 pais = new Pais(nextLine[13]);
				 pais.agregarEmpresa(Long.valueOf(nextLine[23]), empresas.find(Long.valueOf(nextLine[23])));
				 pais.agregarMarca(nextLine[12],marca);
				 paises.insertar(nextLine[13], pais);
			 }else {
				 paises.get(nextLine[13]).agregarEmpresa(Long.valueOf(nextLine[23]), empresas.find(Long.valueOf(nextLine[23])));
				 paises.get(nextLine[13]).agregarMarca(nextLine[12],marca);
			 }
			
		 }
		 
		 reporte1(empresas);
		 reporte2(paises);
		 double endTime = System.nanoTime();
		 System.out.println("Took "+(endTime - startTime)/1000000000 + " s");
		 
		
		 
		 
	 }

}
