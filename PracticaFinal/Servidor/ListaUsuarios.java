package Servidor;

import java.util.ArrayList;

public class ListaUsuarios {

	private ArrayList<Usuario> listaUsuarios;
	
	public ListaUsuarios() {
		super();
		this.listaUsuarios = new ArrayList<Usuario>();
	}
	
	public synchronized void addUsuario(Usuario usuario) {
		this.listaUsuarios.add(usuario);
	}
	
	public synchronized void deleteUsuario(String id) {
		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getIdUsuario().equalsIgnoreCase(id)) {
				listaUsuarios.remove(i);
				break;
			}
		}
	}
	
	public synchronized ArrayList<Usuario> getListaUsuarios(){
		
		ArrayList<Usuario> copia = new ArrayList<Usuario>(this.listaUsuarios);
		return copia;
	}
	
	public synchronized Usuario getUsuario(String nombreFichero) {
		for (Usuario user : listaUsuarios) {
			for (Fichero fichero : user.getFicheros()) {
				if (fichero.getNombre().equalsIgnoreCase(nombreFichero)) {
					return user;
				}
			}
		}
		return null;
	}
	
	public synchronized void agregarFicheros(String id, ArrayList<Fichero> listaFicheros) {
		Usuario user = null;
		for (int i = 0; i < listaUsuarios.size(); i++) {
			user = listaUsuarios.get(i);
			if (user.getIdUsuario().equalsIgnoreCase(id)) break;
		}
		for (Fichero fichero : listaFicheros) {
			if (!user.getFicheros().contains(fichero)) {
				user.getFicheros().add(new Fichero(fichero.getNombre(), fichero.getRuta()));
			}
		}
	}
	
	public synchronized void eliminarFicheros(String id, ArrayList<Fichero> listaFicheros) {
		Usuario user = null;
		for (int i = 0; i < listaUsuarios.size(); i++) {
			user = listaUsuarios.get(i);
			if (user.getIdUsuario().equalsIgnoreCase(id)) break;
		}
		for (Fichero ficheroEliminar : listaFicheros) {
			if (user.getFicheros().contains(ficheroEliminar)) {
				user.removeFichero(ficheroEliminar.getNombre());
			}
		}
	}
	
	public synchronized boolean idValido(String id) {
		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getIdUsuario().equalsIgnoreCase(id)) {
				return false;
			}
		}
		return true;
	}
}
