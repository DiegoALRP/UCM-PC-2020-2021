package parte2;

import java.util.ArrayList;

public class Parte2Bakery {

	public void start(int numProcesos) {
		
		ArrayList<Thread> listaHilos = new ArrayList<Thread>();
		AlgoritmoBakery aBakery = new AlgoritmoBakery(numProcesos);
		
		for (int i = 1; i <= numProcesos; i++) {
			
			Thread hilo = new HebraBakery(i, aBakery);
			//System.out.println("Se ha creado el hilo: " + i);
			hilo.start();
			listaHilos.add(hilo);
		}
		
		for (Thread hilo : listaHilos) {
			
			try {
				hilo.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Han terminado todos los hilos");
		System.out.println("El resultado es: " + aBakery.getN());
	}
}
