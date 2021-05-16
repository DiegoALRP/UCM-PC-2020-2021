package parte1_2;

public class Entero {

	private volatile int entero;
	
	public Entero() {
		
		this.entero = 0;
	}
	
	public Entero(int entero) {
		
		this.entero = entero;
	}
	
	public int getEntero() {
		
		return this.entero;
	}
	
	public void setEntero(int entero) {
		
		this.entero = entero;
	}
	
	public void incrementa() {
		
		this.entero++;
	}
	
	public void decrementa() {
		
		this.entero--;
	}
}
