package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import server.Dispatcher;

/**
 * Classe de lancement du serveur
 * @author Robin Kebaili, Tristan Lefebvre
 *
 */
public class MainServer {

	public static void main(String[] args) {
		try {
			// Verification du nombre de paramètres
			if (args.length != 1){
				System.out.println("Erreur, nombre de parametres incorrects");
				System.out.println("La commande doit etre : java server.MainServer port");
				System.exit(1);
			}
			
			// Récupération des parametres
			int port = Integer.parseInt(args[0]);
			
			// Creation de l'objet dispatcher
			Dispatcher d = new server.Dispatcher();
			
			// Creation du proxy
			DispatcherInterface proxy = (DispatcherInterface) UnicastRemoteObject.exportObject(d, 0);
			
			// Enregistrement de l'objet dispatcher dans le registre
			Registry registry = LocateRegistry.createRegistry(port);
			registry.rebind("dispatcher", proxy);
			
			// Boucle
			Scanner sc = new Scanner(System.in);
			System.out.println("Entrez exit pour quitter");
			String str;
			do {
				str = sc.nextLine();
			}
			while (str.compareTo("exit") != 0);
			
			// Fin du programme
			sc.close();
			System.exit(0);
		}
		catch (Exception e){
			e.printStackTrace();
			System.exit(1);
		}
		
	}
}
