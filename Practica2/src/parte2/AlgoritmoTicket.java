package parte2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AlgoritmoTicket {

	public volatile int n;
	public volatile AtomicInteger number;
	public volatile int next;
	public int[] turno;
	public int numProcesos;
	
	public AlgoritmoTicket(int numProcesos) {
		
		this.numProcesos = numProcesos;
		this.n = 0;
		this.number = new AtomicInteger(1);
		this.next = 1;
		this.turno = new int[numProcesos + 1];
	}
	
	public void takeLock(int i) {
		
		this.turno[i] = number.getAndIncrement();
		
		while(turno[i] != this.next) {
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void release(int i) {
		
		next = next + 1;
	}
	
	public void incrementa() {
		
		this.n++;
	}
	
	public void decrementa() {
		
		this.n--;
	}
	
	public int getN() {
		
		return this.n;
	}
}
