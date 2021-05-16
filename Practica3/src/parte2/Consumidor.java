package parte2;

import java.util.concurrent.Semaphore;

public class Consumidor extends Thread {

	private int id;
	private Almacen almacen;
	private Semaphore empty;
	private Semaphore full;
	
	public Consumidor(int id, Almacen almacen, Semaphore empty, Semaphore full) {
		
		this.id = id;
		this.almacen = almacen;
		this.empty = empty;
		this.full = full;
	}
	
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			
			try {
				this.full.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Consumidor coge el semaforo");
			
			int result = this.almacen.extraer(id);
			System.out.println("Consumidor extrae: " + result);
			
			this.empty.release();
			System.out.println("Consumidor libera el semaforo");
		}
	}
}
