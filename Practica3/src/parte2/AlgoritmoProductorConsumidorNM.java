package parte2;

import java.util.concurrent.Semaphore;

public class AlgoritmoProductorConsumidorNM {

	public AlmacenArrayEnteros almacen;
	public Semaphore empy;
	public Semaphore full;
	public Semaphore mutexP;
	public Semaphore mutexC;
	
	public AlgoritmoProductorConsumidorNM(AlmacenArrayEnteros almacen, int tamBuffer) {
		
		this.almacen = almacen;
		this.empy = new Semaphore(tamBuffer);
		this.full = new Semaphore(0);
		this.mutexP = new Semaphore(1);
		this.mutexC = new Semaphore(1);
	}
}
