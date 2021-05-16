package parte1_2;

public class MiMonitor1_2 {

	private int count;
	private int tamBuffer;
	private volatile Entero[] buffer;
	private volatile int fin;
	private volatile int ini;
	
	public MiMonitor1_2(int tamBuffer) {
		
		this.tamBuffer = tamBuffer;
		this.buffer = new Entero[tamBuffer];
		this.fin = 0;
		this.ini = 0;
	}
	
	public synchronized void almacenar(int id, int producto) {
		
		while (count == tamBuffer) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//System.out.println("Ha entrado: " + id);
		this.buffer[fin] = new Entero(producto);
		System.out.println("Productor: " + id + " Ha almacenado: " + producto + " en la pos: " + fin);
		fin = (fin + 1)%tamBuffer;
		//System.out.println("Ha sumado el: " + id);
		count++;
		//System.out.println("Productor: " + id + " termina");
		notifyAll();
	}
	
	public synchronized int extraer(int id) {
		
		while (count == 0) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int result = this.buffer[ini].getEntero();
		System.out.println("Consumidor: " + id + " Ha extraido: " + result + " pos: " + ini);
		ini = (ini + 1)%this.tamBuffer;
		count--;
		notifyAll();
		return result;
	}
}
