package parte2_1;

import java.util.Random;

public class Consumidor extends Thread {

	private int id;
	private MiMonitor2_1 monitor;
	private int tamBuffer;
	
	public Consumidor(int id, MiMonitor2_1 monitor, int tamBuffer) {
		
		this.id = id;
		this.monitor = monitor;
		this.tamBuffer = tamBuffer;
	}
	
	public void run() {
		
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			int result[] = this.monitor.extraer(id, rand.nextInt(2));
			for (int j = 0; j < 10000; j++) {
				
			}
			//System.out.println("Consumidor: id " + this.id + "ha extraido: num " + result);
		}
	}
}

