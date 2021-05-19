package Mensajes;

public class ConfirmacionAgregarFicheros extends Mensaje {

	public ConfirmacionAgregarFicheros(String origen, String destino, String id) {
		super(origen, destino, id);
		this.tipo = TipoMensaje.CONFIRMACION_AGREGAR_FICHEROS;
	}

}
