package Mensajes;

import java.util.ArrayList;

import Servidor.Fichero;

public class AgregarFicheros extends Mensaje {

	private ArrayList<Fichero> listaFicheros;
	
	public AgregarFicheros(String origen, String destino, String id, ArrayList<Fichero> listaFicheros) {
		super(origen, destino, id);
		this.tipo = TipoMensaje.AGREGAR_FICHEROS;
		this.listaFicheros = listaFicheros;
	}
	
	public ArrayList<Fichero> getListaFicheros() {
		return this.listaFicheros;
	}
}
