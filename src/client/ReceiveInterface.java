package client;

import java.io.Serializable;
import java.rmi.Remote;

/**
 * 
 * @author Robin Kebaili, Tristan Lefebvre
 *
 */
public interface ReceiveInterface extends Remote,Serializable{

	public abstract void afficheMessage(String s);
}
