package Model;

import java.util.List;

public class Cafetera {

	private boolean monedaEchada = false;

	/**
	 * Método usado para la sincronización atómica
	 * @param Persona p
	 */
	public void hacerCafe1(Persona p) {
		System.out.print("Café hecho..." + p.nombre + "\n");
	}

	/**
	 * Método sincronizado para el modelo productor-consumidor
	 * Esta sería la parte del consumidor -> mientras monedaEchada=false -> wait
	 * @param Persona p
	 */
	public synchronized void hacerCafe(Persona p) {
		while (!monedaEchada) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Haciendo cafe para " + p.nombre);
		System.out.print("Cafe hecho..." + p.nombre + "\n\n");
		monedaEchada = false;
		notifyAll();

	}

	/**
	 * Método sincronizado para el modelo productor-consumidor
	 * Esta sería la parte del productor -> mientras monedaEchada=true -> wait
	 * @param Persona p
	 */
	public synchronized void echarMoneda(Persona p) {

		while (monedaEchada) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Echando moneda... " + p.nombre);
		monedaEchada = true;
		notifyAll();

	}
}
