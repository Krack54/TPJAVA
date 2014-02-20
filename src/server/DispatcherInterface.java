package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.ReceiveInterface;

/**
 * 
 * @author Robin Kebaili, Tristan Lefebvre
 *
 */
public interface DispatcherInterface extends Remote{

	/**
	 * Enregistre un client sur le serveur
	 * @param client Client ajouté
	 */
	public abstract void inscription(ReceiveInterface client) throws RemoteException;
	
	/**
	 * Envoi un message aux clients
	 * @param s Message à envoyer
	 */
	public abstract void dispatchMessage(String s) throws RemoteException;
	
	/**
	 * Envoi un évenemment de dessin de point
	 * @param x Positon horizontale du point à dessiner
	 * @param y Position verticale du point à dessiner
	 * @throws RemoteException
	 */
	public abstract void dispatchPoint(int x,int y) throws RemoteException;

}
