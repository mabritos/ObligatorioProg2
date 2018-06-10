package uy.edu.um.prog2.main;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;

import uy.edu.um.prog2.adt.abb.MyBinarySearchTree;
import uy.edu.um.prog2.adt.abb.MyBinaryTreeSearchImp;
import uy.edu.um.prog2.adt.hash.*;
import uy.edu.um.prog2.entidades.*;

public class Main {
	


	 private static final String ADDRESS_FILE = "v_producto_real_updated.csv";
	 public static void main(String[]args) throws IOException, ElementoYaExistenteException, HashCompletoException {
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
			 
			 rubro = new Rubro(nextLine[3]);
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
				 marcas.insertar(nextLine[12], marca);
			 }else
				 marcas.get(nextLine[12]).agregarClase(nextLine[10], clases.get(nextLine[10]));
			 
			 if(!empresas.isEmpty()) {
				 if(empresas.find(Long.valueOf(nextLine[23]))==null) {
					 empresa = new Empresa(nextLine[5], nextLine[23]);
					 empresa.agregarMarca(nextLine[12], marcas.get(nextLine[12]));
					 empresas.insert(Long.valueOf(nextLine[23]), empresa);
					 //System.out.println(nextLine[5]);
				 }
			 }
			 else {
				 empresa = new Empresa(nextLine[5], nextLine[23]);
				 empresa.agregarMarca(nextLine[12], marcas.get(nextLine[12]));
				 empresas.insert(Long.valueOf(nextLine[23]), empresa);
			 }
			
			 
			 if(!paises.pertenece(nextLine[13])) {
				 pais = new Pais(nextLine[13]);
				 pais.agregarEmpresa(Long.valueOf(nextLine[23]), empresas.find(Long.valueOf(nextLine[23])));
				 paises.insertar(nextLine[13], pais);
			 }else 
				 paises.get(nextLine[13]).agregarEmpresa(Long.valueOf(nextLine[23]), empresas.find(Long.valueOf(nextLine[23])));
				
				
			 
			
			 
			
			
			 
		 }
		 double endTime = System.nanoTime();
		 System.out.println("Took "+(endTime - startTime)/1000000000 + " s");
	 }

}
