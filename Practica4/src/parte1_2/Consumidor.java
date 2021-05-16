package parte1_2;

public class Consumidor extends Thread {

	private int id;
	private MiMonitor1_2 monitor;
	
	public Consumidor(int id, MiMonitor1_2 monitor) {
		
		this.id = id;
		this.monitor = monitor;
	}
	
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			int result = this.monitor.extraer(id);
			for (int j = 0; j < 10000; j++) {
				
			}
			//System.out.println("Consumidor: id " + this.id + "ha extraido: num " + result);
		}
	}
}
