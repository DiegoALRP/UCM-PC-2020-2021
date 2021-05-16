package parte2;

public class HebraTicket extends Thread {

	private int id;
	private AlgoritmoTicket aTicket;
	
	public HebraTicket(int id, AlgoritmoTicket aTicket) {
		
		this.id = id;
		this.aTicket = aTicket;
	}
	
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			
			this.aTicket.takeLock(this.id);
			System.out.println("El hilo: " + this.id + " ha tomado el cerrojo");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.aTicket.incrementa();
			System.out.println("El hilo: " + this.id + " ha incrementado n");
			this.aTicket.decrementa();
			System.out.println("El hilo: " + this.id + " ha decrementado n");
			
			this.aTicket.release(this.id);
			System.out.println("El hilo: " + this.id + " ha soltado el cerrojo");
		}
	}
	
	public int getIdentifier() {
		
		return this.id;
	}
}
