package parte1_1;

public class MiMonitor {

	private Entero entero;
	
	public MiMonitor(Entero entero) {
		
		this.entero = entero;
	}
	
	public synchronized void mutexIncremento() {
		
		entero.incrementa();
	}
	
	public synchronized void mutexDecrementa() {
		
		entero.decrementa();
	}
}
