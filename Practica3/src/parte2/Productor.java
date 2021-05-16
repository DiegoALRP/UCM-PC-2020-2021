package parte2;

import java.util.concurrent.Semaphore;

public class Productor extends Thread{

	private int id;
	private Almacen almacen;
	private Semaphore empty;
	private Semaphore full;
	
	public Productor(int id, Almacen almacen, Semaphore empty, Semaphore full) {
		
		this.id = id;
		this.almacen = almacen;
		this.empty = empty;
		this.full = full;
	}
	
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			
			try {
				this.empty.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Productor coge el semaforo");
			
			this.almacen.almacenar(id, i);
			
			this.full.release();
			System.out.println("Productor libera el semaforo");
		}
	}
}
