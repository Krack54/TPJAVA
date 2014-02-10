package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.Dispatcher;

/**
 * Classe de lancement du serveur
 * @author Robin Kebaili, Tristan Lefebvre
 *
 */
public class MainServer {

	public static void main(String[] args) {
		try {
			// Création de l'objet dispatcher
			Dispatcher d = new server.Dispatcher();
			
			// Enregistrement de l'objet dispatcher dans le registre
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("dispatcher", d);
			
			while (true){
				Thread.sleep(1);
			}
		}
		catch (Exception e){
			e.printStackTrace();
			System.exit(1);
		}
		
	}
}
