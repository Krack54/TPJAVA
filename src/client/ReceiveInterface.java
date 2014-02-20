package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface cliente
 * @author Robin Kebaili, Tristan Lefebvre
 *
 */
public interface ReceiveInterface extends Remote {

	/**
	 * Affiche un message dans la console
	 * @param s message à afficher
	 * @throws RemoteException
	 */
	public abstract void afficheMessage(String s) throws RemoteException;
	
	/**
	 * Dessine un point sur le panel
	 * @param x Position horizontale du point
	 * @param y Position verticale du point
	 * @throws RemoteException
	 */
	public abstract void dessinePoint(int x,int y) throws RemoteException;
}
