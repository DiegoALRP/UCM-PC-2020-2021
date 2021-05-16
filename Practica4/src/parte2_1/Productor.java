package parte2_1;

import java.util.Random;

public class Productor extends Thread {

	private int id;
	private MiMonitor2_1 monitor;
	private int tamBuffer;
	
	public Productor(int id, MiMonitor2_1 monitor, int tamBuffer) {
		
		this.id = id;
		this.monitor = monitor;
		this.tamBuffer = tamBuffer;
	}
	
	public void run() {
		
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			
			this.monitor.almacenar(id, i, rand.nextInt(2));
			for (int j = 0; j < 10000; j++) {
				
			}
			//System.out.println("El productor: id " + this.id + "ha almacenado: num " + i);
		}
	}
}
