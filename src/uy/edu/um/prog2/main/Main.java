package uy.edu.um.prog2.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import com.opencsv.CSVReader;
import uy.edu.um.prog2.adt.abb.MyBinarySearchTree;
import uy.edu.um.prog2.adt.abb.MyBinaryTreeSearchImp;
import uy.edu.um.prog2.adt.hash.*;
import uy.edu.um.prog2.entidades.*;

public class Main {
	private static final String ADDRESS_FILE = "v_producto_real_updated.csv";
	 
	public static void main(String[]args) throws IOException, ElementoYaExistenteException {
		double startTime = System.nanoTime();
		
		CSVReader reader = new CSVReader(new FileReader(ADDRESS_FILE), ';');
		Scanner sc = new Scanner(System.in);
		String[] nextLine;
		int capacidad = 0;
		Empresa empresa;
		Producto producto;
		Marca marca;
		Clase clase;
		Pais pais;
	 
		HashTable<String, Pais> paises = new ClosedHashTable<String, Pais>(211);
		HashTable<String, Empresa> empresas = new ClosedHashTable<String, Empresa>(1721);
		HashTable<String, Marca> marcas = new ClosedHashTable<String, Marca>(9461);
		HashTable<String, Clase> clases = new ClosedHashTable<String, Clase>(877);
		HashTable<String, Producto> productos = new ClosedHashTable<String, Producto>(50363);
	
		nextLine = reader.readNext();
		boolean exit = false;
		int opcion;
		System.out.println("-Cargando datos");
		 
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
			 
			producto = new Producto(nextLine[0], nextLine[20], nextLine[2], nextLine[4], paises.obtener(nextLine[13]), empresas.obtener(nextLine[23]), marcas.obtener(nextLine[12]), clases.obtener(nextLine[10]));
			productos.insertar(nextLine[0]+nextLine[2]+nextLine[4], producto);
		 }
		 
		 double endTime = System.nanoTime();
		 System.out.println("-Carga de datos completada ("+(endTime - startTime)/1000000000 + " s)");
		 Reportes r1 = new Reportes();
		 
		 while(!exit) {
			System.out.println("--Ingrese el reporte a realizar:");
			System.out.println("(1) Primer Reporte");
			System.out.println("(2) Segundo Reporte");
			System.out.println("(3) Tercer Reporte");
			System.out.println("(4) Cuarto Reporte");
			System.out.println("(5) Salir");
			try{
				opcion = Integer.valueOf(sc.nextLine());
				switch(opcion) {
				case 1:
					System.out.println("Reporte 1:");
					r1.reporte1(empresas, productos);
					break;
				case 2:
					System.out.println("Reporte 2:");
					r1.reporte2(productos);
					break;
				case 3:
					System.out.println("Reporte 3:");
					r1.reporte3(paises, productos);
					break;
				case 4:
					System.out.println("Reporte 4:");
					r1.reporte4(productos);
					break;
				case 5:
					exit = true;
					break;
				default:
					break;
				}
				System.out.println("---Presione enter para continuar");
				sc.nextLine();
			}catch(Exception e) {
				
			}
			
		 }
	 }
	 
}

