package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import client.gui.MainFrame;

import server.Dispatcher;

/**
 * Classe de lancement du client
 * @author Robin Kebaili, Tristan Lefebvre
 *
 */
public class MainClient {

	public static void main(String[] args) {
		new MainFrame();
		/*
		try {
			Scanner sc = new Scanner(System.in);
			
			// Vérification du nombre de paramètre
			if (args.length != 2){
				System.out.println("nombre de paramètre incorrect");
				System.exit(1);
			}
			
			// Récupération des paramètres host et port
			String host = args[0];
			int port = Integer.parseInt(args[1]);
			
			// Création d'un objet de type Receiver
			Receiver receiver = new Receiver();

			// Exportation référence distante implémentant ReceiverInterface
			Registry r = LocateRegistry.getRegistry(host,port);

			// Récupération de la référence distante vers le serveur Dispatcher
			// à partir du rmiregistry
			Dispatcher d = (Dispatcher) r.lookup("dispatcher");

			// Appel de enregistrer(ReceiverInterface ri) sur la référence du
			// serveur en passant en paramètre sa propre référence
			d.inscription(receiver);
			
			do {
				System.out.println("Entrez un message a envoyer");
				d.dispatchMessage(sc.nextLine());
			} while (true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
}