package server;

import java.rmi.RemoteException;
import java.util.ArrayList;

import client.ReceiveInterface;

/**
 * Objet serveur principal
 * 
 * @author Robin Kebaili, Tristan Lefebvre
 */
public class Dispatcher implements DispatcherInterface {

	// Attributs
	/**
	 * Liste des clients enregistrés
	 */
	private ArrayList<ReceiveInterface> clients;

	// Constructeurs
	/**
	 * Constructeur principale
	 */
	public Dispatcher() {
		this.clients = new ArrayList<>();
	}

	// Méthodes
	public void inscription(ReceiveInterface client) {
		this.clients.add(client);
	}

	public void dispatchMessage(String s) {
		System.out.println("Message a dispatcher : " + s);
		for (ReceiveInterface ri : Dispatcher.this.clients) {
			try {
				ri.afficheMessage(s);
			} catch (Exception e) {
				System.out.println("Client a deco");
			}
		}

	}

	public void dispatchPoint(int x, int y) throws RemoteException {
		for (ReceiveInterface ri : this.clients) {
			try {
				ri.dessinePoint(x, y);
			} catch (Exception e) {
				System.out.println("Client à deco");
			}
		}
	}

}
