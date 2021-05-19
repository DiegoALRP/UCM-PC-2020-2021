package Servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Mensajes.AgregarFicheros;
import Mensajes.Conexion;
import Mensajes.ConfirmacionAgregarFicheros;
import Mensajes.ConfirmacionConexion;
import Mensajes.ConfirmacionListaUsuarios;
import Mensajes.EmitirFichero;
import Mensajes.ErrorConexion;
import Mensajes.ErrorPedirFichero;
import Mensajes.Mensaje;
import Mensajes.PedirFichero;

public class OyenteCliente extends Thread {
	
	private Servidor servidor;
	private Socket socket;
	private ObjectInputStream fin;
	private ObjectOutputStream fout;
	
	public OyenteCliente(Socket socket, Servidor servidor) {
		
		this.socket = socket;
		this.servidor = servidor;
		try {
			this.fin = new ObjectInputStream(this.socket.getInputStream());
			this.fout = new ObjectOutputStream(this.socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		
		try {
			
			Mensaje m = null;
			while (true) {
				
				m = (Mensaje) this.fin.readObject();
				
				switch (m.getTipo()) {
				case CONEXION:
					mensajeConexion((Conexion) m);
					break;
				case LISTA_USUARIOS:
					mensajeListaUsuarios(m);
					break;
				case AGREGAR_FICHEROS:
					mensajeAgregarFicheros((AgregarFicheros) m);
					break;
				case PEDIR_FICHERO:
					mensajePedirFichero((PedirFichero) m);
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void mensajeConexion(Conexion m) throws IOException {
		
		if (servidor.idValido(m.getId())) {
			fout.writeObject(new ErrorConexion(this.servidor.getIp(), m.getOrigen(), "none"));
		}
		else {
			System.out.println("'OyenteCliente:' se ha conectado usuario: " + m.getId());
			servidor.addUsuario(new Usuario(m.getId(), m.getOrigen(), m.getListaFicheros()), new FlujosUsuario(m.getId(), this.fin, this.fout));
			this.fout.writeObject(new ConfirmacionConexion(this.servidor.getIp(), m.getOrigen(), "none"));
		}
	}

	public void mensajeListaUsuarios(Mensaje m) throws IOException {
		
		System.out.println("'OyenteCliente:' el usuario " + m.getId() + " ha solicitado la lista de usuarios");
		this.fout.writeObject(new ConfirmacionListaUsuarios(this.servidor.getIp(), m.getOrigen(), this.servidor.getListaUsuarios(), m.getId()));
	}
	
	public void mensajeAgregarFicheros(AgregarFicheros m) throws IOException {
		
		System.out.println("'OyenteCliente:' el usuario " + m.getId() + " ha compartido nuevos ficheros");
		this.servidor.agregarFicheros(m.getId(), m.getListaFicheros());
		this.fout.writeObject(new ConfirmacionAgregarFicheros(this.servidor.getIp(), m.getOrigen(), "none"));
	}
	
	public void mensajePedirFichero(PedirFichero m) throws IOException {
		
		System.out.println("'OyenteCliente:' el usuario " + m.getId() + "ha solicitdado un fichero");
		Usuario user = this.servidor.getUsuario(m.getFilename());
		if (user == null) {
			this.fout.writeObject(new ErrorPedirFichero(this.servidor.getIp(), m.getOrigen(), "none"));
		}
		else {
			
			String rutaFichero = new String();
			for (Fichero fichero : user.getFicheros()) {
				if (fichero.getNombre().equalsIgnoreCase(m.getFilename())) {
					rutaFichero = fichero.getRuta();
					break;
				}
			}
			
			ObjectOutputStream fout_e = this.servidor.getOutPutStream(user.getIdUsuario());
			fout_e.writeObject(new EmitirFichero(m.getDestino(), m.getOrigen(), m.getId(), m.getFilename(), rutaFichero, m.getId()));
		}
	}
}
