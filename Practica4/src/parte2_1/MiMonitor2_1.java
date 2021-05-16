package parte2_1;

public class MiMonitor2_1 {

	private volatile int count;
	private int tamBuffer;
	private volatile Entero[] buffer;
	private volatile int fin;
	private volatile int ini;
	
	public MiMonitor2_1(int tamBuffer) {
		
		this.tamBuffer = tamBuffer;
		this.buffer = new Entero[tamBuffer];
		this.fin = 0;
		this.ini = 0;
	}
	
	public synchronized void almacenar(int id, int producto, int cantidad) {
		
		while (count == tamBuffer || cantidad > (tamBuffer - count)) {
			
			try {
				
				System.out.println("Espera: " + id);
				if (cantidad > 1) {
					cantidad--;
				}
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < cantidad; i++) {
			
			this.buffer[fin] = new Entero(producto);
			fin = (fin + 1)%tamBuffer;
			count++;
		}
		System.out.println("Productor: " + id + " Ha almacenado: cantidad " + cantidad);
		//System.out.println("Productor: " + id + " Ha almacenado: " + producto + " en la pos: " + fin);
		notifyAll();
	}
	
	public synchronized int[] extraer(int id, int cantidad) {
		
		while (count == 0 || cantidad > (tamBuffer - count)) {
			
			try {
				
				if (cantidad > 1) {
					cantidad--;
				}
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int result[] = new int[cantidad];
		for (int i = 0; i < cantidad; i++) {
			
			result[i] = this.buffer[ini].getEntero();
			ini = (ini + 1)%this.tamBuffer;
			count--;
		}
		System.out.println("Consumidor: " + id + " Ha extraido: cantidad " + cantidad);
		notifyAll();
		return result;
	}
}
