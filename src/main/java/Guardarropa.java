import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.math3.util.CombinatoricsUtils;
import org.paukov.combinatorics3.Generator;
import org.paukov.combinatorics3.IGenerator;

public class Guardarropa 
{

	public Guardarropa() {}
	
	ArrayList <Prenda> parteSuperior = new ArrayList<Prenda>();
	ArrayList <Prenda> parteInferior = new ArrayList<Prenda>();
	ArrayList <Prenda> accesorios = new ArrayList<Prenda>();
	ArrayList <Prenda> calzados = new ArrayList<Prenda>();
	
	
//-------------------AGREGAR PRENDA A GUARDARROPAS-------------------- 
	
	public void agregarAGuardarropas(Prenda prenda) 
	{	
		switch(prenda.getParteCuerpo()) 
		{
			case "Parte Superior": 
				this.parteSuperior.add(prenda);
				break;
			case "Parte Inferior": 
				this.parteInferior.add(prenda);
				break;
			case "Accesorio":
				this.accesorios.add(prenda);
				break;
			case "Calzado": 
				this.calzados.add(prenda);
				break;
			default:
				System.out.println("ESTE ELEMENTO NO PERTENECE A NINGUNA LISTA");
				break;
		}
	}
	
//-------------------MOSTRAR LOS ARRAYS DEL GUARDARROPA-------------------- 
	
	public ArrayList<String> getArrayParteSuperior() 
	{
		ArrayList <String> arrayParteSuperior = new ArrayList <String>(this.parteSuperior.stream().map(prenda -> prenda.getNombre()).collect(Collectors.toList()));
		return arrayParteSuperior;
	}
	
	public ArrayList<String> getArrayParteInferior() 
	{
		ArrayList <String> arrayParteInferior = new ArrayList <String>(this.parteInferior.stream().map(prenda -> prenda.getNombre()).collect(Collectors.toList()));
		return arrayParteInferior;
	}
	
	public ArrayList<String> getArrayAccesorios() 
	{
		ArrayList <String> arrayAccesorios = new ArrayList <String>(this.accesorios.stream().map(prenda -> prenda.getNombre()).collect(Collectors.toList()));
		return arrayAccesorios;
	}
	
	public ArrayList<String> getArrayCalzado() 
	{
		ArrayList <String> arrayCalzado = new ArrayList <String>(this.calzados.stream().map(prenda -> prenda.getNombre()).collect(Collectors.toList()));
		return arrayCalzado;
	}


//-------------------FUNCION PRINCIPAL --------------------
		
	public List<String> queMePongo()
	{
		
	    int rnd = new Random().nextInt(this.combinaciones().size());
	    
	    List <String> combinacionElegida = this.combinaciones().get(rnd);
	    combinacionElegida.forEach(System.out::println);

	    return combinacionElegida;
	}
	

//-------------------------Funcion de combinaciones----------------------- 

	public ArrayList<List<String>> combinaciones()
	{
		IGenerator<List<String>> combinaciones = Generator.cartesianProduct(this.getArrayParteSuperior(), this.getArrayParteInferior(), this.getArrayAccesorios(), this.getArrayCalzado());
		ArrayList<List<String>> arrayListCombinaciones = new ArrayList<List<String>>();
		combinaciones.forEach(Lista->arrayListCombinaciones.add(Lista));
		//arrayListCombinaciones.forEach(System.out::println);
		return	arrayListCombinaciones;		
	}
	

}
