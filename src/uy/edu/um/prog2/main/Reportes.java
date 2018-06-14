package uy.edu.um.prog2.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import com.opencsv.CSVReader;

import uy.edu.prog2.ordenamiento.AlgoritmosOrdenamiento;
import uy.edu.prog2.ordenamiento.BubbleSort;
import uy.edu.prog2.ordenamiento.QuickSort;
import uy.edu.um.prog2.adt.abb.MyBinarySearchTree;
import uy.edu.um.prog2.adt.abb.MyBinaryTreeSearchImp;
import uy.edu.um.prog2.adt.hash.*;
import uy.edu.um.prog2.entidades.*;

public class Reportes {
	
	public void reporte1(HashTable<String, Empresa> empresas, HashTable<String, Producto> productos) {
		
		Iterator<Empresa> it3 = empresas.iterator();
		while(it3.hasNext()) {
			it3.next().setCantPHab(0);
		}
		Iterator<Producto> it1= productos.iterator();
		while(it1.hasNext()) {
			Producto prod1 = it1.next();
			if(prod1.getEstado().equals("HABILITADO")) {
				prod1.getEmpresa().agregarProductoHab();
			}
		}
		int cantidad = empresas.getCantElementos();
		Empresa[] empresas2 = new Empresa[cantidad];
		Iterator<Empresa> it2 = empresas.iterator();
		for(int x =0; it2.hasNext();x++) {
			empresas2[x] = it2.next();
		}
		AlgoritmosOrdenamiento<Empresa> o = new BubbleSort<Empresa>();
		empresas2 = o.order(empresas2);
		for(int x=empresas2.length-1; x>empresas2.length-21; x--)
			System.out.println(empresas2[x].getNombre()+" tiene "+empresas2[x].getCantPHab()+" productos habilitados");
	}
	
	public void reporte2(HashTable<String, Producto> productos) throws ElementoYaExistenteException {
		HashTable<String, PaisMarca> paisesXmarca = new ClosedHashTable<String, PaisMarca>(8011); //key = nombre Pais + nombre marca
		Iterator<Producto> it1 = productos.iterator();
		while(it1.hasNext()) {
			PaisMarca pm1 = new PaisMarca();
			Producto producto1 = it1.next();
			pm1.setMarca(producto1.getMarca());
			pm1.setPais(producto1.getPais());
			if(!paisesXmarca.pertenece(producto1.getPais().getNombre()+producto1.getMarca().getNombre())) {
				paisesXmarca.insertar(producto1.getPais().getNombre()+producto1.getMarca().getNombre(), pm1);
				if(producto1.getEstado().equals("HABILITADO"))
					paisesXmarca.obtener(producto1.getPais().getNombre()+producto1.getMarca().getNombre()).sumarProdHab();
			}else if(producto1.getEstado().equals("HABILITADO"))
				paisesXmarca.obtener(producto1.getPais().getNombre()+producto1.getMarca().getNombre()).sumarProdHab();
		}
		int cantidad = paisesXmarca.getCantElementos();
		PaisMarca[] paisesXmarca2 = new PaisMarca[cantidad];
		Iterator<PaisMarca> it2 = paisesXmarca.iterator();
		for(int x=0; it2.hasNext(); x++)
			paisesXmarca2[x] = it2.next();
		AlgoritmosOrdenamiento<PaisMarca> o = new BubbleSort<PaisMarca>();
		paisesXmarca2 = o.order(paisesXmarca2);
		for(int x=paisesXmarca2.length-1; x>paisesXmarca2.length-11; x--)
			System.out.println(paisesXmarca2[x].getMarca().getNombre()+" de "+paisesXmarca2[x].getPais().getNombre()+" tiene "+paisesXmarca2[x].getProdHab());
	}
	
	public void reporte3(HashTable<String, Pais> paises, HashTable<String, Producto> productos) {
		
		Iterator<Pais> it2 = paises.iterator();
		while(it2.hasNext()) {
			Pais pa1 = it2.next();
			pa1.resetPHab();
		}
		Iterator<Producto> it1 = productos.iterator();
		while(it1.hasNext()) {
			Producto p1 = it1.next();
			if(p1.getEstado().equals("HABILITADO"))
				p1.getPais().agregarPHab();
				
			p1.getPais().agregarProd();
			
		}
		Pais[] paisesarray = new Pais[paises.getCantElementos()];
		Iterator<Pais> it3 = paises.iterator();
		int x =0;
		while(it3.hasNext()) {
			Pais pa1 = it3.next();
			paisesarray[x] = pa1;
			x++;
		}
		AlgoritmosOrdenamiento<Pais> o = new BubbleSort<Pais>();
		paisesarray = o.order(paisesarray);
		for(int i=paisesarray.length-1;i>paisesarray.length-11;i--)
			System.out.println(paisesarray[i].getNombre()+" tiene "+paisesarray[i].getPHab()+" productos habilitados ("+(paisesarray[i].getPHab()*100)/paisesarray[i].getPTot()+"%)");
	

	} // refinar y agregar %
	
	public void reporte4(HashTable<String, Producto> productos) throws ElementoYaExistenteException {
		HashTable<String, PaisClase> paisesXclase = new ClosedHashTable<String, PaisClase>(8011); //key = nombre Pais + nombre clase
		Iterator<Producto> it1 = productos.iterator();
		while(it1.hasNext()) {
			
			PaisClase pc1 = new PaisClase();
			Producto producto1 = it1.next();
			pc1.setClase(producto1.getClase());
			pc1.setPais(producto1.getPais());
			if(!paisesXclase.pertenece(producto1.getPais().getNombre()+producto1.getClase().getNombre())) {
				
				paisesXclase.insertar(producto1.getPais().getNombre()+producto1.getClase().getNombre(), pc1);
				if(producto1.getEstado().equals("HABILITADO"))
					
					paisesXclase.obtener(producto1.getPais().getNombre()+producto1.getClase().getNombre()).sumarProdHab();
			}else if(producto1.getEstado().equals("HABILITADO"))
				
				paisesXclase.obtener(producto1.getPais().getNombre()+producto1.getClase().getNombre()).sumarProdHab();
		}
		int cantidad = paisesXclase.getCantElementos();
		PaisClase[] paisesXclase2 = new PaisClase[cantidad];
		Iterator<PaisClase> it2 = paisesXclase.iterator();
		
		for(int x=0; it2.hasNext(); x++)
			paisesXclase2[x] = it2.next();
		
		AlgoritmosOrdenamiento<PaisClase> o = new BubbleSort<PaisClase>();
		paisesXclase2 = o.order(paisesXclase2);
		
		for(int x=paisesXclase2.length-1; x>paisesXclase2.length-11; x--)
			System.out.println(paisesXclase2[x].getClase().getNombre()+" de "+paisesXclase2[x].getPais().getNombre()+" tiene "+paisesXclase2[x].getProdHab());
	}
}
