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
			// V�rification du nombre de param�tre
			if (args.length != 2){
				System.out.println("nombre de param�tre incorrect");
				System.exit(1);
			}
			
			// R�cup�ration des param�tres host et port
			String host = args[0];
			int port = Integer.parseInt(args[1]);
			
			// Cr�ation d'un objet de type Receiver
			Receiver receiver = new Receiver();

			// Exportation r�f�rence distante impl�mentant ReceiverInterface
			Registry r = LocateRegistry.getRegistry(host,port);

			// R�cup�ration de la r�f�rence distante vers le serveur Dispatcher
			// � partir du rmiregistry
			Dispatcher d = (Dispatcher) r.lookup("dispatcher");

			// Appel de enregistrer(ReceiverInterface ri) sur la r�f�rence du
			// serveur en passant en param�tre sa propre r�f�rence
			d.enregistrer(receiver);

			// Le serveur Dispatcher re�oit cette r�f�rence et l'ajoute dans sa
			// liste de r�f�rences clients
			// TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}