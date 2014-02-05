package server;

import java.rmi.Remote;
import client.ReceiveInterface;

public interface DispatcherInterface extends Remote {

	/**
	 * Enregistre un client sur le serveur
	 * @param client Client ajouté
	 */
	public abstract void enregistrer(ReceiveInterface client);
	
	/**
	 * Envoi un message aux clients
	 * @param s Message à envoyer
	 */
	public abstract void dispatchMessage(String s);

}
