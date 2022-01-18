package Model;

import java.util.List;

public class Cafetera {

	private boolean monedaEchada = false;

	/**
	 * M�todo usado para la sincronizaci�n at�mica
	 * @param Persona p
	 */
	public void hacerCafe1(Persona p) {
		System.out.print("Caf� hecho..." + p.nombre + "\n");
	}

	/**
	 * M�todo sincronizado para el modelo productor-consumidor
	 * Esta ser�a la parte del consumidor -> mientras monedaEchada=false -> wait
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
	 * M�todo sincronizado para el modelo productor-consumidor
	 * Esta ser�a la parte del productor -> mientras monedaEchada=true -> wait
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
