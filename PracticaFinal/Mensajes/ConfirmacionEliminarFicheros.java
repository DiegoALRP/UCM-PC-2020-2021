package Mensajes;

public class ConfirmacionEliminarFicheros extends Mensaje {

	public ConfirmacionEliminarFicheros(String origen, String destino, String id) {
		super(origen, destino, id);
		this.tipo = TipoMensaje.CONFIRMACION_ELIMINAR_FICHEROS;
	}

}
