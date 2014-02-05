package server;

import java.util.ArrayList;

import client.ReceiveInterface;

/**
 * Objet serveur principal
 * @author Robin Kebaili, Tristant Lefebvre
 */
public class Dispatcher implements DispatcherInterface {

	// Attributs
	private ArrayList<ReceiveInterface> clients;
	
	// Constructeurs
	public Dispatcher(){
		this.clients = new ArrayList<>(); 
	}
	
	// Méthodes
	public void enregistrer(ReceiveInterface client) {
		this.clients.add(client);
	}

	public void dispatchMessage(String s) {
		// TODO Auto-generated method stub
		
	}

}
