package Mensajes;

/**
 * Universidad Complutense de Madrid.
 * Programacion Concurrente.
 * Grupo A 2020-2021.
 * Profesora:
 * 	-Elvira Maria Albert Albiol.
 * 
 * Practica 5
 * 
 * Clase Mensaje Lista Usuarios.
 * 
 * @author
 * 	-Frederick Ernesto Borges Noronha.
 * 	-Diego Alejandro Rodriguez Pereira.
 *
 */
public class ListaUsuarios extends Mensaje {

    public ListaUsuarios(String origen, String destino, String id){
        super(origen, destino, id);
        this.tipo = TipoMensaje.LISTA_USUARIOS;
    }
}