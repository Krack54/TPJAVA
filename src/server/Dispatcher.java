package server;

import java.util.ArrayList;

import client.ReceiveInterface;

/**
 * Objet serveur principal
 * @author Robin Kebaili, Tristan Lefebvre
 */
public class Dispatcher implements DispatcherInterface {

	// Attributs
	private ArrayList<ReceiveInterface> clients;
	
	// Constructeurs
	public Dispatcher(){
		this.clients = new ArrayList<>(); 
	}
	
	// Méthodes
	public void inscription(ReceiveInterface client) {
		this.clients.add(client);
	}

	public void dispatchMessage(String s) {
		System.out.println("Message à dispatcher : "+s);
		for (ReceiveInterface ri : this.clients){
			ri.afficheMessage(s);
		}
	}

}
