package uy.edu.um.prog2.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import uy.edu.um.prog2.adt.abb.MyBinarySearchTree;
import uy.edu.um.prog2.adt.abb.MyBinaryTreeSearchImp;
import uy.edu.um.prog2.adt.hash.*;
import uy.edu.um.prog2.entidades.*;

public class Main {
	private static final String ADDRESS_FILE = "v_producto_real_updated.csv";
	 
	 public static void main(String[]args) throws IOException, ElementoYaExistenteException {
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
		 HashTable<Empresa> empresas = new ClosedHashTable<Empresa>(1721);
		 HashTable<Marca> marcas = new ClosedHashTable<Marca>(5107);
		 HashTable<Clase> clases = new ClosedHashTable<Clase>(719);
		 HashTable<Producto> productos = new ClosedHashTable<Producto>(50363);
	
		 double startTime = System.nanoTime();
		 nextLine = reader.readNext();
		 while((nextLine = reader.readNext())!=null) {
			 
			 if(!paises.pertenece(nextLine[13])) {
				 pais = new Pais(nextLine[13]);
				 paises.insertar(nextLine[13], pais);
			 }
			 if(!empresas.pertenece(nextLine[23])) {
				 empresa = new Empresa(nextLine[5], nextLine[23]);
				 empresas.insertar(nextLine[23], empresa);
			 }
			 if(!marcas.pertenece(nextLine[12])) {
				 marca = new Marca(nextLine[12]);
				 marcas.insertar(nextLine[12], marca);
			 }
			 if(!clases.pertenece(nextLine[10])) {
				 clase = new Clase(nextLine[10]);
				 clases.insertar(nextLine[10], clase);
			 }
			 
			 producto = new Producto(nextLine[0], nextLine[20], nextLine[2], nextLine[4], paises.get(nextLine[13]), empresas.get(nextLine[23]), marcas.get(nextLine[12]), clases.get(nextLine[10]));
			 productos.insertar(nextLine[0]+nextLine[2]+nextLine[4], producto);
		 }
		 Reportes r1 = new Reportes();
		 //r1.reporte1(empresas, productos);
		 //r1.reporte2(productos);
		 r1.reporte3(paises, productos);
		 
		
		 
		 double endTime = System.nanoTime();
		 System.out.println("Took "+(endTime - startTime)/1000000000 + " s");
	 }
	 
}

