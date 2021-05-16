package parte2;

public class AlmacenEnteros implements Almacen {

	private volatile int buffer;
	
	public AlmacenEnteros() {
		
		this.buffer = 0;
	}
	@Override
	public void almacenar(int id, int producto) {

		this.buffer = producto;
		System.out.println("Se ha almacenado el producto: " + producto);
	}

	@Override
	public int extraer(int id) {
		
		int result = this.buffer;
		System.out.println("Se ha extraido: " + result);
		return result;
	}

}
