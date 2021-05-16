package parte1_2;

public class Productor extends Thread {

	private int id;
	private MiMonitor1_2 monitor;
	
	public Productor(int id, MiMonitor1_2 monitor) {
		
		this.id = id;
		this.monitor = monitor;
	}
	
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			
			this.monitor.almacenar(id, i);
			for (int j = 0; j < 10000; j++) {
				
			}
			//System.out.println("El productor: id " + this.id + "ha almacenado: num " + i);
		}
	}
}
