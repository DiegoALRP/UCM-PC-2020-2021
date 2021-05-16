package parte1;

public class MiHebra1 extends Thread {

	private int id;
	private RompeEmpate re;
	
	public MiHebra1(int id, RompeEmpate re) {
		
		this.id = id;
		this.re = re;
	}
	
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			
			if (this.id == 1) {
				
				this.re.takeLockP1();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				
				this.re.takeLockP2();
			}
			
			System.out.println("El hilo: " + this.id + " ha tomado el cerrojo");
			
			this.re.incrementa();
			System.out.println("El hilo: " + this.id + " ha incrementado n");
			this.re.decrementa();
			System.out.println("El hilo: " + this.id + " ha decrementado n");
			
			if (this.id == 1) {
				
				this.re.releaseP1();
			}
			else {
				
				this.re.releaseP2();
			}
			
			System.out.println("El hilo: " + this.id + " ha soltado el cerrojo");
		}
	}
	
	public int getIdentifier() {
		
		return this.id;
	}
}
