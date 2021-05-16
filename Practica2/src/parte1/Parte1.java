package parte1;

import java.util.ArrayList;

public class Parte1 {

	public volatile int n;
	public volatile boolean in1;
	public volatile boolean in2;
	public volatile int last;
	
	public Parte1() {
		
		this.n = 0;
		this.in1 = false;
		this.in2 = false;
		this.last = 0;
	}
	
	public void start() {
		
		ArrayList<Thread> listaHilos = new ArrayList<Thread>();
		RompeEmpate re = new RompeEmpate();
		
		for (int i = 1; i <= 2; i++) {
			
			Thread hilo = new MiHebra1(i, re);
			System.out.println("Se ha creado el hilo: " + i);
			hilo.start();
			listaHilos.add(hilo);
		}
		
		for (Thread hilo : listaHilos) {
			
			try {
				
				hilo.join();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		System.out.println("Han terminado todos los hilos");
		System.out.println("El resultado es: " + re.getN());
	}
}
