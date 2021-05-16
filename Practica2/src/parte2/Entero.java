package parte2;

public class Entero {

	private volatile int entero;
	//int entero;
	
	public Entero() {
		this.entero = 0;
	}

	public int getEntero() {
		return entero;
	}

	public void setEntero(int entero) {
		this.entero = entero;	
	}
}
