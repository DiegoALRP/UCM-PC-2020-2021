package parte1;

import java.util.concurrent.Semaphore;

public class HebraSCSemaforoINC extends Thread{

	private int id;
	private Entero entero;
	private Semaphore semaforo;
	
	public HebraSCSemaforoINC(int id, Entero entero, Semaphore semaforo) {
		
		this.id = id;
		this.entero = entero;
		this.semaforo = semaforo;
	}
	
	public void run() {
		
		//System.out.println("Proceso: " + this.id);
		for (int i = 0; i < 10; i++) {
			
			try {
				this.semaforo.acquire();
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
			//System.out.println("El hilo: " + this.id + " ha tomado el semaforo");
			
			if (this.id%2 == 0) {
				this.entero.incrementa();
				//System.out.println("El hilo: " + this.id + " ha incrementado n");
			}
			else {
				
				this.entero.decrementa();
				//System.out.println("El hilo: " + this.id + " ha decrementado n");
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.semaforo.release();
			//System.out.println("El hilo: " + this.id + " ha liberado el semaforo");
		}
	}
	
	public int getIdentifier() {
		
		return this.id;
	}
}
