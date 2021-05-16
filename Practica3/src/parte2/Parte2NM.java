package parte2;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Parte2NM {

	public void start(int numProcesos, int tamBuffer) {
		
		ArrayList<Thread> listaHilos = new ArrayList<Thread>();
		AlmacenArrayEnteros almacen = new AlmacenArrayEnteros(tamBuffer);
		Semaphore empy = new Semaphore(tamBuffer);
		Semaphore full = new Semaphore(0);
		Semaphore mutexP = new Semaphore(1);
		Semaphore mutexC = new Semaphore(1);
		
		for (int i = 1; i <= numProcesos; i++) {
			
			Thread hiloP = new ProductorM(i, almacen, empy, full, mutexP);
			Thread hiloC = new ConsumidorN(i, almacen, empy, full, mutexC);
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
		
		for (int i = 0; i < tamBuffer; i++) {
			
			System.out.println(almacen.buffer[i].getEntero());
		}
		//System.out.println(almacen.buffer);
		System.out.println("Han terminado todos los hilos");
	}
}
