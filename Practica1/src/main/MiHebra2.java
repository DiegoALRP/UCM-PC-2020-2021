package main;

import java.util.ArrayList;
import java.util.List;

public class MiHebra2 extends Thread{

	VariableGlobal variable;
	
	public MiHebra2(VariableGlobal variable) {
		
		this.variable = variable;
	}
	
	public void run() {
		
		for (int i = 0; i < 1; i++) {
			variable.incrementa();
		}
		
		try {
			this.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < 1; i++) {
			variable.decrementa();
		}
	}
	
}
