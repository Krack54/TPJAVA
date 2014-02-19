package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author Robin Kebaili, Tristan Lefebvre
 *
 */
public interface ReceiveInterface extends Remote {

	public abstract void afficheMessage(String s) throws RemoteException;
	
	public abstract void dessinePoint(int x,int y) throws RemoteException;
}
