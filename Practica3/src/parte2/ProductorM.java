package parte2;

import java.util.concurrent.Semaphore;

public class ProductorM extends Thread {

	private int id;
	private Almacen almacen;
	private Semaphore empty;
	private Semaphore full;
	private Semaphore mutexP;
	
	public ProductorM(int id, Almacen almacen, Semaphore empty, Semaphore full,
			Semaphore mutexP) {
		
		this.id = id;
		this.almacen = almacen;
		this.empty = empty;
		this.full = full;
		this.mutexP = mutexP;
	}
	
	public void run() {
		
		//for (int i = 0; i < 10; i++) {
			
			try {
				this.empty.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Productor: " + this.id + " coge el semaforo empty");
			
			try {
				this.mutexP.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Productor: " + this.id + " coge el semaforo mutexP");
			
			this.almacen.almacenar(id, id);
			
			this.mutexP.release();
			System.out.println("Productor: " + this.id + " libera el semaforo mutexP");
			this.full.release();
			System.out.println("Productor: " + this.id + " libera el semaforo full");
		//}
	}
}
