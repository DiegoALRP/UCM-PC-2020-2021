package main;

public class VariableGlobal {

	int entero;
	
	public VariableGlobal() {
		
		this.entero = 0;
	}
	
	public void incrementa() {
		
		this.entero++;
	}
	
	public void decrementa() {
		
		this.entero--;
	}

	public int getEntero() {
		return entero;
	}
}
