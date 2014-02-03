package server;

import java.rmi.Remote;
import client.ReceiveInterface;

public interface DispatcherInterface extends Remote {
	
	public abstract void inscription(ReceiveInterface client);
	
	public abstract void DispatchMessage(String s);

}
