package Mensajes;

import java.util.ArrayList;

import Servidor.Fichero;
import Servidor.Usuario;

/**
 * Universidad Complutense de Madrid.
 * Programacion Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira Maria Albert Albiol.
 * 
 * Practica 5
 * 
 * Clase Mensaje Confirmacion Lista Usuarios.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public class ConfirmacionListaUsuarios extends Mensaje {

	private ArrayList<Usuario> listaUsuarios;
	private ArrayList<ArrayList<Fichero>> matrizFicheros;
	
    public ConfirmacionListaUsuarios(String origen, String destino, ArrayList<Usuario> listaUsuarios, ArrayList<ArrayList<Fichero>> matrizFicheros, String id){
        super(origen, destino, id);
        this.tipo = TipoMensaje.CONFIRMACION_LISTA_USUARIOS;
        this.listaUsuarios = listaUsuarios;
        this.matrizFicheros = matrizFicheros;
    }
    
    public ArrayList<Usuario> getListaUsuarios(){
    	return this.listaUsuarios;
    }
    
    public ArrayList<ArrayList<Fichero>> getMatrizFicheros(){
    	return this.matrizFicheros;
    }
}