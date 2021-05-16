package parte1;

public class RompeEmpate {

	public volatile int n;
	public volatile boolean in1;
	public volatile boolean in2;
	public volatile int last;
	
	public RompeEmpate() {
		
		this.n = 0;
		this.in1 = false;
		this.in2 = false;
		this.last = 0;
	}
	
	public void takeLockP1() {
		
		this.in1 = true;
		this.last = 1;
		while(this.in2 && this.last == 1) {
			
			System.out.println("!!! 1 Esperando");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void takeLockP2() {
		
		this.in2 = true;
		this.last = 2;
		while(this.in1 && last == 2) {
			
			System.out.println("!!! 2 Esperando");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void releaseP1() {
		
		this.in1 = false;
	}
	
	public void releaseP2() {
		
		this.in2 = false;
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
