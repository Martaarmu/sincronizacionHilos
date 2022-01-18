package Model;

public class Trabajador extends Thread {

	String nombre;
	int miParte;
	int miCuenta;
	private final GranoCafe c;

	//Obtiene el numero de granos que ha contado un trabajador
	public int getMiCuenta() {
		return miCuenta;
	}

	public Trabajador(String nombre, int miParte, GranoCafe c) {
		this.nombre = nombre;
		this.miParte = miParte;
		this.c = c;
	}

	/**
	 * El trabajador va contando su parte
	 * y va aumentando la cuenta total del numero de granos
	 */
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < miParte; i++) {
			this.c.incrementa();
			miCuenta++;
		}

		System.out.printf(nombre + " terminado, cuenta:" + getMiCuenta() + "\n");

	}
}
