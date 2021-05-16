package parte2;

public class AlgoritmoBakery {

	public volatile int n;
	public Entero[] turno;
	//public volatile int[] turno;
	public int numProcesos;
	
	public AlgoritmoBakery(int numProcesos) {
		
		this.n = 0;
		this.turno = new Entero[numProcesos + 1];
		//this.turno = new int[numProcesos + 1];
		this.numProcesos = numProcesos;
		
		for (int i = 0; i <= numProcesos; i++) {
			
			this.turno[i] = new Entero();
		}
	}
	
	public Entero getMax(Entero[] turno) {
	//public int getMax(int[] turno) {
		
		Entero max = new Entero();
		//int max = 0;
		for (int i = 0; i < turno.length; i++) {
			
			if (turno[i].getEntero() > max.getEntero()) {
			//if (turno[i] > max) {
				
				max.setEntero(turno[i].getEntero());
				//max = turno[i];
			}
		}
		
		return max;
	}
	
	public boolean mayorMayor(int a, int b, int c, int d) {
		
		if ((a > c) || (a == c && b > d)) return true;
		return false;
	}
	
	public void takeLock(int i) {
		
		turno[i].setEntero(1);
		//turno[i] = 0;
		turno = turno;
		turno[i].setEntero(getMax(turno).getEntero() + 1);
		//turno[i] = getMax(turno) + 1;
		
		for (int j = 1; j <= this.numProcesos; j++) {
			
			if (j == i) continue;
			
			while(turno[j].getEntero() != 0 && mayorMayor(turno[i].getEntero(), i, turno[j].getEntero(), j)) {
			//while(turno[j] != 0 && mayorMayor(turno[i], i, turno[j], j)) {	
			
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void release(int i) {
		
		this.turno[i].setEntero(0);
		//turno = turno;
		//this.turno[i] = 0;
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
