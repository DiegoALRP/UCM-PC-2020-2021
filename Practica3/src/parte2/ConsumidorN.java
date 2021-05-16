package parte2;

import java.util.concurrent.Semaphore;

public class ConsumidorN extends Thread {

	private int id;
	private Almacen almacen;
	private Semaphore empty;
	private Semaphore full;
	private Semaphore mutexC;
	
	public ConsumidorN(int id, Almacen almacen, Semaphore empty, Semaphore full,
			Semaphore mutexC) {
		
		this.id = id;
		this.almacen = almacen;
		this.empty = empty;
		this.full = full;
		this.mutexC = mutexC;
	}
	
	public void run() {
		
		//for (int i = 0; i < 10; i++) {
			
			try {
				this.full.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Consumidor: " + this.id + " coge el semaforo full");
			
			try {
				this.mutexC.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Consumidor: " + this.id + " coge el semaforo mutexC");
			
			int result = this.almacen.extraer(id);
			//System.out.println("Consumidor: " + this.id + " extrae: " + result);
			
			this.mutexC.release();
			System.out.println("Consumidor: " + this.id + " librera el semaforo mutexC");
			this.empty.release();
			System.out.println("Consumidor: " + this.id + " librera el semaforo empty");
		//}
	}
}
