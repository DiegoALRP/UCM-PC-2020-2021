package parte2;

public class HebraRompeEmpate extends Thread {

	private int id;
	private RompeEmpateN re;
	
	public HebraRompeEmpate(int id, RompeEmpateN re) {
		
		this.id = id;
		this.re = re;
	}
	
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			
			this.re.takeLock(id);
			System.out.println("El hilo: " + this.id + " ha tomado el cerrojo");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.re.incrementa();
			System.out.println("El hilo: " + this.id + " ha incrementado n");
			this.re.decrementa();
			System.out.println("El hilo: " + this.id + " ha decrementado n");
			
			this.re.release(id);
			System.out.println("El hilo: " + this.id + " ha soltado el cerrojo");
		}
	}
	
	public int getIdentifier() {
		
		return this.id;
	}
}
