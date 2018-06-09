package uy.edu.um.prog2.main;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;

import uy.edu.um.prog2.entidades.*;

public class GenerarEntidades {
	 private static final String ADDRESS_FILE = "v_producto_real_updated.csv";
	 public static void main(String[]args) throws IOException {
		 CSVReader reader = new CSVReader(new FileReader(ADDRESS_FILE), ';');
		 String[] nextLine;
		 int capacidad = 0;
		 Rubro rubro;
		 Empresa empresa;
		 Producto producto;
		 Marca marca;
		 Clase clase;
		 Pais pais;
		 
		 while((nextLine = reader.readNext())!=null) {
			 capacidad++;
		 }
		 while((nextLine = reader.readNext())!=null) {
			 rubro = new Rubro(nextLine[3]);
			 empresa = new Empresa(nextLine[5], nextLine[23]);
			 marca = new Marca(nextLine[12]);
		 }
	 }

}
