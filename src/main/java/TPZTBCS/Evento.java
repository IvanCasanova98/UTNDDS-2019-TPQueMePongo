package TPZTBCS;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;
import java.util.stream.Collectors;

import interfacesZTBCS.comando;

import java.util.Scanner;
import java.util.Timer; 
public class Evento extends TimerTask implements comando {

	public String Descripcion;
	public Atuendo AtuendoElegido=null; 
	public Date FechaDelEvento;
	public Date FechaSugerencia;
	public Usuario usuario; 
	public Atuendo Sugerencia=null; 
	public String ciudad;
	Timer timer;
	
	public Evento(Date fechaEvento,Date fechaSugerencia,Usuario ID, String ciudad,String Descripcion) {
		this.FechaDelEvento=fechaEvento;
		this.FechaSugerencia=fechaSugerencia;
		this.usuario = ID;
		this.ciudad = ciudad;
		this.Descripcion= Descripcion.toLowerCase();
		//pruebaCron	prueba=new pruebaCron();
		timer = new Timer();
		//System.out.print(fechaSugerencia.toString());
		timer.schedule(this, fechaSugerencia);
	}
	
	public Evento(Date fecha,Usuario ID) {
		this.FechaDelEvento=fecha;
		this.usuario = ID;
		this.ciudad = "Buenos Aires";
	}


	
	public String getDescripcion() {
		return this.Descripcion;
	}
	
	@Override
	public void ejecutar() {
		this.AtuendoElegido=this.Sugerencia;
		System.out.println("Atuendo Asignado");


		//SUMARLE CALIFICACION.
	}

	@Override
	public void deshacer() {
		usuario.listaEvento.remove(this);
		
		System.out.println("Evento rechazado");
		//RESTARLE CALIFICACION.
	}

	@Override
	public void rechazar() {
		System.out.println("Atuendo rechazado");
		this.run();
		//RESTARLE CALIFICACION.
	}

	@Override
	public void run() {
		try {
        
		List<Atuendo>listaSugerencias =usuario.queMePongoATodosLosGuardarropas(this.ciudad);
		listaSugerencias= listaSugerencias.stream().filter(x->x!=null).collect(Collectors.toList());
		int rnd = new Random().nextInt(listaSugerencias.size());
		 Atuendo atuendoElegido = listaSugerencias.get(rnd);
		 this.Sugerencia = atuendoElegido;
		 this.Sugerencia.imprimirPrendas();
		
		 Scanner myObj = new Scanner(System.in);
		 System.out.println("Te parece bien el atuendo?: (SI/NO)");
		 String respuesta = myObj.nextLine();
		 if (respuesta.equals("SI")) {

			this.ejecutar();
			
		 }
		 if (respuesta.equals("NO")) {
			 System.out.println("DESEA OTRA SUGERENCIA?: (SI/NO)");
		 if (respuesta.equals("SI")) {
				this.rechazar();
					
		}
		 if (respuesta.equals("NO")) {
				this.deshacer();
					
		}
		 
	}
		 
		 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
