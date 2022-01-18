package Model;

import java.util.ArrayList;
import java.util.List;

public class Fila extends Thread {

	List<Persona> personas = new ArrayList<Persona>();
	Cafetera c;

	public Fila(List<Persona> personas, Cafetera c) {
		super();
		this.personas = personas;
		this.c = c;

	}

	/**
	 * Método sincronizado atomicamente
	 * Recorre la lista de personas y simula 
	 * el uso de la cafetera ordenadamente
	 */
	public void run() {
		synchronized (c) {
			for (int i = 0; i < personas.size(); i++) {
				c.hacerCafe1(personas.get(i));
				c.notifyAll();
				try {
					c.wait();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("error");

				}

			}

		}

	}

}
