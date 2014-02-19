package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import server.DispatcherInterface;

/**
 * Classe de lancement du client
 * @author Robin Kebaili, Tristan Lefebvre
 *
 */
public class MainClient {

	public static void main(String[] args) {
		//new MainFrame();
		
		try {
			Scanner sc = new Scanner(System.in);
			
			// Verification du nombre de paramètre
			if (args.length != 2){
				System.out.println("Erreur, nombre de parametres incorrect");
				System.out.println("La commande doit etre : java client.MainClient host port");
				System.exit(1);
			}
			
			// Recuperation des parametres host et port
			String host = args[0];
			int port = Integer.parseInt(args[1]);
			
			// Recuperation du registry
			Registry r = LocateRegistry.getRegistry(host,port);
			
			// Recuperation du dispatcher
			DispatcherInterface d = (DispatcherInterface) r.lookup("dispatcher");
						
			// Creation d'un objet de type Receiver
			Receiver receiver = new Receiver(d);
			
			// Creation de son proxy
			ReceiveInterface proxy = (ReceiveInterface) UnicastRemoteObject.exportObject(receiver,0);

			

			// Inscription sur le serveur
			d.inscription(proxy);
			
			// Boucle principale
			System.out.println("Entrez un message a envoyer ou exit pour quitter");
			String str = sc.nextLine();
			while (str.compareTo("exit") != 0){
				d.dispatchMessage(str);
				str = sc.nextLine();
			} 
			sc.close();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}