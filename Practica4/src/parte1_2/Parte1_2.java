package parte1_2;

import java.util.ArrayList;

public class Parte1_2 {

	public void start(int numProcesos, int tamBuffer) {
		
		ArrayList<Thread> listaHilos = new ArrayList<Thread>();
		//AlmacenArrayEnteros almacen = new AlmacenArrayEnteros(tamBuffer);
		MiMonitor1_2 monitor = new MiMonitor1_2(tamBuffer);
		
		for (int i = 1; i <= numProcesos; i++) {
			
			Thread hiloP = new Productor(i, monitor);
			Thread hiloC = new Consumidor(i, monitor);
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
			
			//System.out.println(almacen.buffer[i].getEntero());
		}
		//System.out.println(almacen.buffer);
		System.out.println("Han terminado todos los hilos");
	}
}
