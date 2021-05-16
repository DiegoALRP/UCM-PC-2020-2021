package main;

import java.util.ArrayList;
import java.util.List;

public class MiHebra1 extends Thread {
	
	public MiHebra1() {
		
	}

	public void run() {
		
		try {
			
			long id = this.getId();
			System.out.println("Se ha creado el hilo: " + id);
			
			this.sleep(500);
			
			System.out.println("Se ha terminado el hilo: " + id);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		List<Thread> hilos = new ArrayList<Thread>();
		
		for (int i = 0; i < 10; i++) {
			
			Thread hilo = new MiHebra1();
			
			hilo.start();
			hilos.add(hilo);
			
		}
		
		for (Thread hilo : hilos) {
			
			try {
				hilo.join();
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Han terminado todos los hilos");
	}
}
