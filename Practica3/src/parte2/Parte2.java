package parte2;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Parte2 {

	public void start(int numProcesos) {
		
		ArrayList<Thread> listaHilos = new ArrayList<Thread>();
		Almacen almacen = new AlmacenEnteros();
		Semaphore empy = new Semaphore(1);
		Semaphore full = new Semaphore(0);
		
		for (int i = 1; i <= numProcesos; i++) {
			
			Thread hiloP = new Productor(i, almacen, empy, full);
			Thread hiloC = new Consumidor(i, almacen, empy, full);
			hiloP.start();
			hiloC.start();
			listaHilos.add(hiloP);
			listaHilos.add(hiloC);
		}
		
		for (Thread hilo : listaHilos) {
			
			try {
				hilo.join();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		System.out.println("Han terminado todos los hilos");
	}
}
