package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainServer {

	public static void main(String[] args) {
		try {
			Dispatcher d = new Dispatcher();
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("dispatcher", d);
		}
		catch (Exception e){
			e.printStackTrace();
			System.exit(1);
		}
		
	}
}
