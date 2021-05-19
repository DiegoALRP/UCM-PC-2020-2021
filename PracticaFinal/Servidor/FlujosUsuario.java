package Servidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FlujosUsuario {

	private String idUsuario;
	private ObjectInputStream fin;
	private ObjectOutputStream fout;
	
	public FlujosUsuario(String id, ObjectInputStream fin, ObjectOutputStream fout) {
		
		super();
		this.idUsuario = id;
		this.fin = fin;
		this.fout = fout;
	}
	
	public String getId() {
		return this.idUsuario;
	}
	
	public ObjectInputStream getFin() {
		return this.fin;
	}
	
	public ObjectOutputStream getFout() {
		return this.fout;
	}
}
