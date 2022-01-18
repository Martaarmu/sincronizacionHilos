package Model;

import java.util.List;

public class HacerCafe extends Thread{

	private Cafetera c;
	private Persona per;
	List<Persona>personas;
	
	public HacerCafe(Cafetera c, List<Persona> personas) {
		super();
		this.c = c;
		this.personas = personas;
	}
	
	public void run() {
		//Persona p = new Persona();
		for(int i=0; i<personas.size(); i++) {
			c.hacerCafe(personas.get(i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("Moneda echada: "+i+personas.get(i));
			//System.out.println("echando moneda..");
		}
	}
}
