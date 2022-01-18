package Model;

import java.util.List;

public class HacerCafe extends Thread {

	private Cafetera c; //Recurso compartido
	List<Persona> personas;

	public HacerCafe(Cafetera c, List<Persona> personas) {
		super();
		this.c = c;
		this.personas = personas;
	}

	/**
	 * Recorre la lista de personas y simulan hacer un café
	 */
	public void run() {

		for (int i = 0; i < personas.size(); i++) {
			c.hacerCafe(personas.get(i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
