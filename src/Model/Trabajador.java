package Model;

public class Trabajador extends Thread{
	
	String nombre;
	int miParte;
	int miCuenta;
	private final GranoCafe c;
	
	public int getMiCuenta() {
		return miCuenta;
	}

	public Trabajador(String nombre, int miParte, GranoCafe c) {
		this.nombre = nombre;
		this.miParte = miParte;
		this.c=c;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<miParte;i++) {
			this.c.incrementa();
			miCuenta++;
		}
		
		System.out.printf(nombre+" terminado, cuenta:" + getMiCuenta()+"\n");
		
		
	}
}
