

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Cafetera;
import Model.EcharMoneda;
import Model.Fila;
import Model.GranoCafe;
import Model.HacerCafe;
import Model.Persona;
import Model.Trabajador;

public class Ejecutable {
	private static final int CAMION_DESCARGA = 750;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GranoCafe c = new GranoCafe();
		Trabajador t1 = new Trabajador("Trabajador 1", CAMION_DESCARGA/2, c);
		Trabajador t2 = new Trabajador("Trabajador 2", CAMION_DESCARGA/2, c);
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		trabajadores.add(t1);
		trabajadores.add(t2);
		for(int i=0; i<trabajadores.size();i++) {
			trabajadores.get(i).start();
			try {
				trabajadores.get(i).join();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
		
		System.out.println("Se han contado: " +c.getnGranos()+ " granos de cafe.");

		

		Scanner teclado = new Scanner(System.in);
		int opcion = -1;

		System.out.println("¿De qué manera quieres sincronizar la cafetera?");
		System.out.println("1- Sincronizando el uso de la cafetera.");
		System.out.println("2- Cliente usa la cafetera con productor consumidor.");
		System.out.println("0- Salir");

		opcion = teclado.nextInt();
		
		
		Cafetera cafetera = new Cafetera();
		List<Persona> fila1 = new ArrayList<Persona>();
		List<Persona> fila2 = new ArrayList<Persona>();
		for (int i = 0; i < 3; i++) {
			Persona p = new Persona("Persona numero " + i + " de la fila derecha.");
			fila1.add(p);
		}

		for (int i = 0; i < 3; i++) {
			Persona p = new Persona("Persona numero " + i + " de la fila izquierda.");
			fila2.add(p);
		}
		
		

		switch (opcion) {
		case 1:

			Fila derecha = new Fila(fila1, cafetera);
			Fila izquierda = new Fila(fila2, cafetera);

			derecha.start();
			izquierda.start();
			

			break;
		case 2:

			EcharMoneda e = new EcharMoneda(cafetera, fila1);
			HacerCafe h = new HacerCafe(cafetera, fila1);
			e.start();
			h.start();
			try {
				e.join();
				h.join();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("No hay mas personas en la fila");
			break;

		case 0:
			break;
		default:
			System.out.println("Esa opcion no esta disponible "+opcion);
		}
		

	}

}
