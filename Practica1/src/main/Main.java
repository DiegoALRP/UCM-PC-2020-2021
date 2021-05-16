package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void metodo2() {
		
		List<Thread> hilos = new ArrayList<Thread>();
		VariableGlobal variable = new VariableGlobal();
		
		for (int i = 0; i < 2; i++) {
			
			Thread hilo = new MiHebra2(variable);
			
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
		System.out.println("El resultado es: " + variable.getEntero());
	}
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			metodo2();
		}
	}
}
