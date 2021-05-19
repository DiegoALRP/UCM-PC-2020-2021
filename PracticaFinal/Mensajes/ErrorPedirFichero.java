package Mensajes;

public class ErrorPedirFichero extends Mensaje {

	public ErrorPedirFichero(String origen, String destino, String id) {
		super(origen, destino, id);
		this.tipo = TipoMensaje.ERROR_PEDIR_FICHERO;
	}

}
