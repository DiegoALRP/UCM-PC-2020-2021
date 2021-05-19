package Servidor;

import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ListaFlujosUsuarios {

	private ArrayList<FlujosUsuario> listaFlujosUsuarios;
	
	public ListaFlujosUsuarios() {
		super();
		this.listaFlujosUsuarios = new ArrayList<FlujosUsuario>();
	}
	
	public synchronized void addFlujo(FlujosUsuario flujosUsuario) {
		this.listaFlujosUsuarios.add(flujosUsuario);
	}
	
	public synchronized void deleteUsuario(String id) {
		for (int i = 0; i < listaFlujosUsuarios.size(); i++) {
			if (listaFlujosUsuarios.get(i).getId().equalsIgnoreCase(id)) {
				this.listaFlujosUsuarios.remove(i);
				break;
			}
		}
	}
	
	public synchronized ObjectOutputStream getOutPutStream(String id) {
		for (int i = 0; i < listaFlujosUsuarios.size(); i++) {
			if (listaFlujosUsuarios.get(i).getId().equalsIgnoreCase(id)) {
				return this.listaFlujosUsuarios.get(i).getFout();
			}
		}
		return null;
	}
}
