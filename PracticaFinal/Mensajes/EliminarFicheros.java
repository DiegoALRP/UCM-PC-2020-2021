package Mensajes;

import java.util.ArrayList;

import Servidor.Fichero;

public class EliminarFicheros extends Mensaje {

	private ArrayList<Fichero> listaFicheros;
	
	public EliminarFicheros(String origen, String destino, String id, ArrayList<Fichero> listaFicheros) {
		super(origen, destino, id);
		this.tipo = TipoMensaje.ELIMINAR_FICHEROS;
		this.listaFicheros = listaFicheros;
	}

	public ArrayList<Fichero> getListaFicheros() {
		return this.listaFicheros;
	}
}
