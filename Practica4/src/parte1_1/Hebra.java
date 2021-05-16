package parte1_1;

public class Hebra extends Thread {

	private int id;
	private MiMonitor monitor;
	
	public Hebra(MiMonitor monitor) {
		
		this.monitor = monitor;
	}
	
	public void run() {
		
		this.monitor.mutexIncremento();
		this.monitor.mutexDecrementa();
	}
	
	public long getId() {
		
		return this.id;
	}
}
