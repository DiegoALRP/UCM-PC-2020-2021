package parte2;

public class AlmacenArrayEnteros implements Almacen {

	public volatile Entero[] buffer;
	public volatile int tamBuffer;
	public volatile int fin;
	public volatile int ini;
	
	public AlmacenArrayEnteros(int tamBuffer) {
		
		this.tamBuffer = tamBuffer;
		this.buffer = new Entero[tamBuffer];
		this.fin = 0;
		this.ini = 0;
	}
	@Override
	public void almacenar(int id, int producto) {
		
		System.out.println("Ha entrado: " + id);
		this.buffer[fin] = new Entero(producto);
		System.out.println("Productor: " + id + " Ha almacenado: " + producto + " en la pos: " + fin);
		fin = (fin + 1)%tamBuffer;
		System.out.println("Ha sumado el: " + id);
	}

	@Override
	public int extraer(int id) {
		
		int result = this.buffer[ini].getEntero();
		System.out.println("Consumidor: " + id + " Ha extraido: " + result + " pos: " + ini);
		ini = (ini + 1)%this.tamBuffer;
		return result;
	}

}
