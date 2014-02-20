package server;

import java.rmi.RemoteException;
import java.util.ArrayList;

import client.ReceiveInterface;

/**
 * Objet serveur principal
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
	public Dispatcher(){
		this.clients = new ArrayList<>(); 
	}
	
	// Méthodes
	public void inscription(ReceiveInterface client) {
		this.clients.add(client);
	}

	public void dispatchMessage(String s) throws RemoteException {
		System.out.println("Message à dispatcher : "+s);
		for (ReceiveInterface ri : this.clients){
			ri.afficheMessage(s);
		}
	}
	
	public void dispatchPoint(int x,int y) throws RemoteException{
		for (ReceiveInterface ri: this.clients){
			ri.dessinePoint(x, y);
		}
	}

}
