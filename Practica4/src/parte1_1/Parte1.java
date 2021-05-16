package parte1_1;

import java.util.ArrayList;

public class Parte1 {

	public void start(int numProcesos) {
		
		ArrayList<Thread> listaHilos = new ArrayList<Thread>();
		Entero entero = new Entero();
		MiMonitor monitor = new MiMonitor(entero);
		
		for (int i = 0; i < numProcesos; i++) {
			
			Thread hilo = new Hebra(monitor);
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
