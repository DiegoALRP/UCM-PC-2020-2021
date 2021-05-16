package parte1;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Parte1 {

	public void start(int numProcesos) {
		
		ArrayList<Thread> listaHilos = new ArrayList<Thread>();
		Entero entero = new Entero();
		Semaphore semaforo = new Semaphore(1);
		
		for (int i = 1; i <= numProcesos*2; i++) {
			
			Thread hilo = new HebraSCSemaforoINC(i, entero, semaforo);
			hilo.start();
			listaHilos.add(hilo);
		}
		
		for (Thread hilo : listaHilos) {
			
			try {
				hilo.join();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		System.out.println("Han terminado todos los hilos");
		System.out.println("El resultado es: " + entero.getEntero());
	}
}
