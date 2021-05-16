package parte2;

public class HebraBakery extends Thread {

	private int id;
	private AlgoritmoBakery aBakery;
	
	public HebraBakery(int id, AlgoritmoBakery aBakery) {
		
		this.id = id;
		this.aBakery = aBakery;
	}
	
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			
			this.aBakery.takeLock(this.id);
			//System.out.println("El hilo: " + this.id + " ha tomado el cerrojo");
		
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.aBakery.incrementa();
			//System.out.println("El hilo: " + this.id + " ha incrementado n");
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.aBakery.decrementa();
			//System.out.println("El hilo: " + this.id + " ha decrementado n");
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.aBakery.release(this.id);
			//System.out.println("El hilo: " + this.id + " ha soltado el cerrojo");
		
		}
	}
	
	public int getIdentifier() {
		
		return this.id;
	}
}
