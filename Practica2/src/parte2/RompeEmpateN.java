package parte2;

public class RompeEmpateN {

	public volatile int n;
	public volatile int[] in;
	public volatile int[] last;
	public volatile int numProcesos;
	
	public RompeEmpateN(int numProcesos) {
		
		this.numProcesos = numProcesos;
		this.in = new int[numProcesos + 1];
		this.last = new int[numProcesos + 1];
		
		for (int i = 0; i <= numProcesos; i++) {
			
			in[i] = 0;
			last[i] = 0;
		}
	}
	
	public void takeLock(int i) {
		
		for (int j = 1; j <= this.numProcesos; j++) {
			
			in[i] = j;
			last[j] = i;
			
			for (int k = 1; k <= this.numProcesos; k++) {
				
				if (k == i) continue;
				while(in[k] >= in[i] && last[j] == i) {
					
					System.out.println("!! Hilo: " + i + " esperando !!");
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void release(int i) {
		
		in[i] = 0;
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
