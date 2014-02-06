package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.Dispatcher;

/**
 * Classe de lancement du client
 * @author Robin Kebaili, Tristan Lefebvre
 *
 */
public class MainClient {

	public static void main(String[] args) {
		try {
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
			d.enregistrer(receiver);

			// Le serveur Dispatcher reçoit cette référence et l'ajoute dans sa
			// liste de références clients
			// TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}