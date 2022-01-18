package Model;

import java.util.List;

public class EcharMoneda extends Thread {

	private Cafetera cafetera;  //Recurso compartido 
	private List<Persona> p;

	public EcharMoneda(Cafetera cafetera, List<Persona> p) {
		super();
		this.cafetera = cafetera;
		this.p = p;
	}

	/**
	 * Recorre la lista de personas y simulan echar una 
	 * moneda en la máquina
	 */
	public void run() {
		for (int i = 0; i < p.size(); i++) {
			cafetera.echarMoneda(p.get(i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
