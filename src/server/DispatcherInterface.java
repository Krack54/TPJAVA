package server;

import java.io.Serializable;
import java.rmi.Remote;
import client.ReceiveInterface;

/**
 * 
 * @author Robin Kebaili, Tristan Lefebvre
 *
 */
public interface DispatcherInterface extends Remote,Serializable {

	/**
	 * Enregistre un client sur le serveur
	 * @param client Client ajout�
	 */
	public abstract void inscription(ReceiveInterface client);
	
	/**
	 * Envoi un message aux clients
	 * @param s Message � envoyer
	 */
	public abstract void dispatchMessage(String s);

}
